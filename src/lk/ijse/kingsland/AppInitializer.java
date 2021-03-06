package lk.ijse.kingsland;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppInitializer extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/lk/ijse/kingsland/view/LoginForm.fxml"))));
        primaryStage.setTitle("Kingsland Institute");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}