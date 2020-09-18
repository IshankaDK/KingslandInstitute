package lk.ijse.kingsland.view.tm;

import javafx.scene.control.Button;

public class CourseTM {
    private String code;
    private String courseName;
    private String courseType;
    private String courseDuration;
    private Button btn;

    public CourseTM(String code, String courseName, String courseType, String courseDuration, Button btn) {
        this.setCode(code);
        this.setCourseName(courseName);
        this.setCourseType(courseType);
        this.setCourseDuration(courseDuration);
        this.setBtn(btn);
    }


    public CourseTM() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}
