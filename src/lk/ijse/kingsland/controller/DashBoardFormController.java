package lk.ijse.kingsland.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashBoardFormController {
    public JFXButton btnDashBoard;
    public JFXButton btnStudent;
    public JFXButton btnCourse;
    public JFXButton btnRegister;
    public AnchorPane root;
    public JFXButton btnReport;


    public void initialize() throws IOException {
        initUi("DefaultForm.fxml");
    }

    private void initUi(String location) throws IOException {
        this.root.getChildren().clear();
        this.root.getChildren().add(FXMLLoader.load(this.getClass().getResource("/lk/ijse/kingsland/view/"+location)));
    }

    public void imgCloseOnAction(MouseEvent mouseEvent) {
        System.exit(0);
    }

    public void imgCourseOnAction(MouseEvent mouseEvent) throws IOException {
        initUi("CourseForm.fxml");
    }

    public void imgStudentOnAction(MouseEvent mouseEvent) throws IOException {
        initUi("StudentForm.fxml");
    }

    public void imgHomeOnAction(MouseEvent mouseEvent) throws IOException {
        initUi("DefaultForm.fxml");
    }

    public void btnDashBoardOnAction(ActionEvent actionEvent) throws IOException {
       initUi("DefaultForm.fxml");
    }

    public void btnStudentOnAction(ActionEvent actionEvent) throws IOException {
       initUi("StudentForm.fxml");
    }

    public void btnCourseOnAction(ActionEvent actionEvent) throws IOException {
        initUi("CourseForm.fxml");
    }

    public void btnRegisterOnAction(ActionEvent actionEvent) throws IOException {
        initUi("RegisterForm.fxml");
    }

    public void btnReportOnAction(ActionEvent actionEvent) throws IOException {
        initUi("ReportForm.fxml");
    }
}
