package lk.ijse.kingsland.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.kingsland.bo.BoFactory;
import lk.ijse.kingsland.bo.custom.CourseBo;
import lk.ijse.kingsland.bo.custom.RegistrationBo;
import lk.ijse.kingsland.bo.custom.StudentBo;
import lk.ijse.kingsland.dao.custom.RegistrationDAO;
import lk.ijse.kingsland.db.DBConnection;
import lk.ijse.kingsland.dto.CourseDTO;
import lk.ijse.kingsland.dto.RegistrationDTO;
import lk.ijse.kingsland.dto.StudentDTO;
import lk.ijse.kingsland.view.tm.StudentTM;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RegisterFormController {
    public AnchorPane root;
    public JFXTextField txtId;
    public JFXTextField txtContact;
    public JFXTextField txtDob;
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXButton btnSave;
    public JFXButton btnSearch;
    public JFXTextField txtGender;
    public TextField txtSearch;
    public JFXButton btnNew;
    public JFXTextField txtCourseId;
    public JFXTextField txtCourseName;
    public JFXTextField txtCourseType;
    public JFXTextField txtCourseDuration;
    public JFXTextField txtRegId;
    public JFXTextField txtRegDate;
    public JFXTextField txtRegFee;
    public JFXComboBox cmbCourseName;

    RegistrationBo bo;
    StudentBo stBo;
    CourseBo courseBo;


    public void initialize() throws Exception {
        bo = BoFactory.getInstance().getBo(BoFactory.BOType.REGISTRATION);
        stBo = BoFactory.getInstance().getBo(BoFactory.BOType.STUDENT);
        courseBo = BoFactory.getInstance().getBo(BoFactory.BOType.COURSE);

        getCourseNames();


    }

    public void btnSaveOnAction(ActionEvent actionEvent) throws Exception {
       /* Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
       try{*/
          /* boolean isSaved =  stBo.saveStudent(new StudentDTO(txtId.getText(),txtName.getText(),txtAddress.getText(),
                    txtContact.getText(),txtDob.getText(),txtGender.getText()));*/

           boolean isRegistered = bo.saveRegistration(new RegistrationDTO(Integer.parseInt(txtRegId.getText()),txtRegDate.getText(),txtRegFee.getText(),
                    txtId.getText(),txtCourseId.getText()));
           if(isRegistered) {
               new Alert(Alert.AlertType.CONFIRMATION, "Saved",
                       ButtonType.OK).show();
           }
/*
           if(isSaved==true && isRegistered == true){
              connection.commit();
               new Alert(Alert.AlertType.CONFIRMATION, "Saved",
                       ButtonType.OK).show();
               return ;
           }else {
               connection.rollback();
               return ;
           }
       }finally {
               connection.setAutoCommit(true);
       }*/

    }

    private void clear() {
        txtId.setText(null);
        txtRegDate.setText(null);
        txtRegFee.setText(null);
        txtRegId.setText(null);
        txtAddress.setText(null);
        txtName.setText(null);
        txtGender.setText(null);
        txtDob.setText(null);
        txtCourseId.setText(null);
        txtCourseType.setText(null);
        txtCourseDuration.setText(null);
        txtContact.setText(null);

    }

    public void btnSearchOnAction(ActionEvent actionEvent) throws Exception {
        RegistrationDTO dto = bo.getRegistration(txtSearch.getText());
        if (dto != null) {
            txtRegId.setText(dto.getRegNo()+"");
            txtRegFee.setText(dto.getRegFee());
            txtRegDate.setText(dto.getRegDate());
            txtId.setText(dto.getStudentId());
            txtCourseId.setText(dto.getCourseCode());
      }

    }

    public void btnNewOnAction(ActionEvent actionEvent) throws IOException {
        this.root.getChildren().clear();
        this.root.getChildren().add(FXMLLoader.load(this.getClass().getResource("/lk/ijse/kingsland/view/StudentForm.fxml")));
        btnSave.setText("Save");
    }

    public void txtIDOnAction(ActionEvent actionEvent) throws Exception {
        StudentDTO dto = stBo.getStudent(txtId.getText());
        if (dto != null) {
            txtId.setText(dto.getId());
            txtName.setText(dto.getStudentName());
            txtAddress.setText(dto.getAddress());
            txtContact.setText(dto.getContact());
            txtDob.setText(dto.getDob());
            txtGender.setText(dto.getGender());
        }else if(dto == null) {
            ButtonType ok = new ButtonType("OK",
                    ButtonBar.ButtonData.OK_DONE);
            ButtonType no = new ButtonType("NO",
                    ButtonBar.ButtonData.CANCEL_CLOSE);
            Alert alert = new Alert(Alert.AlertType.WARNING,
                    "Student not found!, Add Student ", ok, no);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.orElse(no) == ok) {
                this.root.getChildren().clear();
                this.root.getChildren().add(FXMLLoader.load(this.getClass().getResource("/lk/ijse/kingsland/view/StudentForm.fxml")));
            }
        }
    }

    public void getCourseNames() throws Exception {
        ObservableList<String> observableList = FXCollections.observableArrayList();
        ArrayList<String> arrayList = bo.getName();
        for (String s : arrayList) {
            observableList.add(s);

        }
        cmbCourseName.setItems(observableList);
    }


    public void cmbCourseNameOnAction(ActionEvent actionEvent) throws Exception {
        CourseDTO dto = courseBo.getCourse(String.valueOf(cmbCourseName.getValue()));
        if (dto != null) {
            txtCourseId.setText(dto.getCode());
            txtCourseType.setText(dto.getCourseType());
            txtCourseDuration.setText(dto.getCourseDuration());
        }
    }

    public void txtCourseIdOnAction(ActionEvent actionEvent) {

    }
}
