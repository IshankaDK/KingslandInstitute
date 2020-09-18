package lk.ijse.kingsland.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.kingsland.bo.BoFactory;
import lk.ijse.kingsland.bo.custom.CourseBo;
import lk.ijse.kingsland.dto.CourseDTO;
import lk.ijse.kingsland.view.tm.CourseTM;

import java.util.List;
import java.util.Optional;

public class CourseFormController {
    public AnchorPane root;
    public TableView<CourseTM> tblCourse;
    public JFXTextField txtCourseId;
    public JFXButton btnSave;
    public JFXButton btnNew;
    public JFXTextField txtType;
    public JFXTextField txtCourseName;
    public JFXTextField txtDuration;
    public TableColumn colCourseId;
    public TableColumn colCourseName;
    public TableColumn colType;
    public TableColumn colDuration;
    public TableColumn colOperation;
    CourseBo bo;

    public void initialize() throws Exception {

        bo = BoFactory.getInstance()
                .getBo(BoFactory.BOType.COURSE);

        colCourseId.setCellValueFactory(new PropertyValueFactory("code"));
        colCourseName.setCellValueFactory(new PropertyValueFactory("courseName"));
        colType.setCellValueFactory(new PropertyValueFactory("courseType"));
        colDuration.setCellValueFactory(new PropertyValueFactory("courseDuration"));
        colOperation.setCellValueFactory(new PropertyValueFactory("btn"));

        loadAllCourses();

        tblCourse.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    setData(newValue);
                });
    }

    private void setData(CourseTM tm) {
        txtCourseId.setText(tm.getCode());
        txtCourseName.setText(tm.getCourseName());
        txtType.setText(tm.getCourseType());
        txtDuration.setText(tm.getCourseDuration());
    }

    private void loadAllCourses() throws Exception {
        ObservableList<CourseTM> tmList =
                FXCollections.observableArrayList();
        List<CourseDTO> allCourse = bo.getAllCourse();
        for (CourseDTO dto : allCourse ) {
            Button btn = new Button("Delete");
            CourseTM tm = new CourseTM(dto.getCode(), dto.getCourseName(),
                    dto.getCourseType(), dto.getCourseDuration(), btn);
            tmList.add(tm);
            btn.setOnAction((e) -> {
                try {

                    ButtonType ok = new ButtonType("OK",
                            ButtonBar.ButtonData.OK_DONE);
                    ButtonType no = new ButtonType("NO",
                            ButtonBar.ButtonData.CANCEL_CLOSE);

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                            "Are You Sure ?", ok, no);
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.orElse(no) == ok) {
                        if (bo.deleteCourse(tm.getCode())) {
                            new Alert(Alert.AlertType.CONFIRMATION,
                                    "Deleted", ButtonType.OK).show();
                            loadAllCourses();
                            return;
                        }
                        new Alert(Alert.AlertType.WARNING,
                                "Try Again", ButtonType.OK).show();
                    } else {
                        //no
                    }


                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            });
        }
//        System.out.println(tmList);
        tblCourse.setItems(tmList);

    }

    public void btnSaveOnAction(ActionEvent actionEvent) throws Exception {

           if(btnSave.getText().equalsIgnoreCase("Save")) {
               boolean isSaved = bo.saveCourse(new CourseDTO(
                       txtCourseId.getText(), txtCourseName.getText(),
                       txtType.getText(), txtDuration.getText()
               ));

               new Alert(Alert.AlertType.CONFIRMATION, "Saved",
                       ButtonType.OK).show();
               loadAllCourses();
               //btnSave.setText("Update");
           }else if(btnSave.getText().equalsIgnoreCase("Update")) {
               btnSave.setText("Update");
               boolean isUpdated = bo.updateCourse(new CourseDTO(
                       txtCourseId.getText(), txtCourseName.getText(),
                       txtType.getText(), txtDuration.getText()
               ));
               new Alert(Alert.AlertType.CONFIRMATION, "Updated",
                       ButtonType.OK).show();
               loadAllCourses();
               clear();
           }
    }

    public void btnNewOnAction(ActionEvent actionEvent) {
        clear();
        btnSave.setText("Save");
    }

    private void clear(){
        txtCourseId.setText(null);
        txtCourseName.setText(null);
        txtType.setText(null);
        txtDuration.setText(null);
    }

    public void txtCourseIdOnAction(ActionEvent actionEvent) throws Exception {
       /* CourseDTO dto = bo.getCourse(txtCourseId.getText());
        if (dto != null) {
            txtCourseId.setText(dto.getCode());
            txtCourseName.setText(dto.getCourseName());
            txtType.setText(dto.getCourseType());
            txtDuration.setText(dto.getCourseDuration());
        }*/
    }
}
