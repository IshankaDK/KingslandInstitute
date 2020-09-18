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
import lk.ijse.kingsland.bo.custom.StudentBo;
import lk.ijse.kingsland.dto.StudentDTO;
import lk.ijse.kingsland.view.tm.StudentTM;

import java.util.List;
import java.util.Optional;

public class StudentFormController {
    public TableView<StudentTM> tblStudent;
    public AnchorPane root;
    public JFXTextField txtId;
    public JFXTextField txtContact;
    public JFXTextField txtDob;
    public JFXTextField txtName;
    public JFXTextField txtGender;
    public JFXTextField txtAddress;
    public JFXButton btnSave;
    public JFXButton btnNew;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colContact;
    public TableColumn colDob;
    public TableColumn colGender;
    public TableColumn colOperation;
    StudentBo bo;

    public void initialize() throws Exception {
        bo = BoFactory.getInstance().getBo(BoFactory.BOType.STUDENT);
        loadAllStudents();

        colId.setCellValueFactory(new PropertyValueFactory("id"));
        colName.setCellValueFactory(new PropertyValueFactory("studentName"));
        colAddress.setCellValueFactory(new PropertyValueFactory("address"));
        colContact.setCellValueFactory(new PropertyValueFactory("contact"));
        colDob.setCellValueFactory(new PropertyValueFactory("dob"));
        colGender.setCellValueFactory(new PropertyValueFactory("gender"));
        colOperation.setCellValueFactory(new PropertyValueFactory("btn"));

        tblStudent.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    setData(newValue);
                });
    }

    private void setData(StudentTM tm) {
        txtId.setText(tm.getId());
        txtName.setText(tm.getStudentName());
        txtAddress.setText(tm.getAddress());
        txtContact.setText(tm.getContact());
        txtDob.setText(tm.getDob());
        txtGender.setText(tm.getGender());
    }


    public void btnSaveOnAction(ActionEvent actionEvent) throws Exception {
        if(btnSave.getText().equalsIgnoreCase("Save")) {
            boolean isSaved = bo.saveStudent(new StudentDTO(
                    txtId.getText(), txtName.getText(),
                    txtAddress.getText(), txtContact.getText(),
                    txtDob.getText(),txtGender.getText()
            ));

            new Alert(Alert.AlertType.CONFIRMATION, "Saved",
                    ButtonType.OK).show();
            loadAllStudents();
           // btnSave.setText("Update");
        }else if(btnSave.getText().equalsIgnoreCase("Update")) {
            btnSave.setText("Update");
            boolean isUpdated = bo.updateStudent(new StudentDTO(
                    txtId.getText(), txtName.getText(),
                    txtAddress.getText(), txtContact.getText(),
                    txtDob.getText(),txtGender.getText()
            ));
            new Alert(Alert.AlertType.CONFIRMATION, "Updated",
                    ButtonType.OK).show();
            loadAllStudents();
            clear();
        }
    }

    private void clear() {
        txtId.setText(null);
        txtName.setText(null);
        txtAddress.setText(null);
        txtContact.setText(null);
        txtDob.setText(null);
        txtGender.setText(null);
    }

    public void btnNewOnAction(ActionEvent actionEvent) {
        clear();
        btnSave.setText("Save");
    }

    private void loadAllStudents() throws Exception {
        ObservableList<StudentTM> tmList = FXCollections.observableArrayList();
        List<StudentDTO> allStudent = bo.getAllStudents();
        for (StudentDTO dto : allStudent ) {
            Button btn = new Button("Delete");
            StudentTM tm = new StudentTM(dto.getId(), dto.getStudentName(),
                    dto.getAddress(),dto.getContact(),dto.getDob(),dto.getGender(),btn);
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
                        if (bo.deleteStudent(tm.getId())) {
                            new Alert(Alert.AlertType.CONFIRMATION,
                                    "Deleted", ButtonType.OK).show();
                            loadAllStudents();
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
        //System.out.println(tmList);
        tblStudent.setItems(tmList);

   }

    public void txtIdOnAction(ActionEvent actionEvent) throws Exception {
        StudentDTO dto = bo.getStudent(txtId.getText());
        if (dto != null) {
            txtId.setText(dto.getId());
            txtName.setText(dto.getStudentName());
            txtAddress.setText(dto.getAddress());
            txtContact.setText(dto.getContact());
            txtDob.setText(dto.getDob());
            txtGender.setText(dto.getGender());
        }
    }
}
