package lk.ijse.kingsland.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {
    public TextField txtUserName;
    public PasswordField txtPassword;
    public JFXButton btnLogin;
    public Hyperlink hyprCreateNew;
    public AnchorPane root;

    public void hyprCreateNewOnAction(ActionEvent actionEvent) {
        // new user view form
    }

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        String uName = txtUserName.getText().trim();
        String password = txtPassword.getText().trim();
        if (uName.length()>0 && password.length()>0){
            if(uName.equalsIgnoreCase("admin") && password.equalsIgnoreCase("1234")){
                Stage stage = (Stage) root.getScene().getWindow();
                stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/lk/ijse/kingsland/view/DashBoardForm.fxml"))));
            }
        }
    }
}
