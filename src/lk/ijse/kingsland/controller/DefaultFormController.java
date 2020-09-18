package lk.ijse.kingsland.controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lk.ijse.kingsland.bo.BoFactory;
import lk.ijse.kingsland.bo.custom.DefaultBo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DefaultFormController {
    public AnchorPane root;
    public Label lblTime;
    public Label lblDate;
    public Label lblTotStudent;
    public Label lblTotCourse;
    DefaultBo bo;
    public void initialize() throws Exception {
        bo = BoFactory.getInstance().getBo(BoFactory.BOType.DEFAULT);
        generateDateTime();
        getTotStudent();
        getTotCourse();

    }

    public void generateDateTime() {
        lblDate.setText(LocalDate.now().toString());

        Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
            lblTime.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
    public void getTotStudent() throws Exception {
        lblTotStudent.setText(String.valueOf(bo.getTotalStudent()));
    }
    public void getTotCourse() throws Exception {
        lblTotCourse.setText(String.valueOf(bo.getTotalCourse()));
    }


}
