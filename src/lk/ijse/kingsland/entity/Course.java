package lk.ijse.kingsland.entity;

import javafx.scene.control.Button;

public class Course implements SuperEntity {
    private String code;
    private String courseName;
    private String courseType;
    private String courseDuration;

    public Course(String code, String courseName, String courseType, String courseDuration) {
        this.code = code;
        this.courseName = courseName;
        this.courseType = courseType;
        this.courseDuration = courseDuration;
    }

    public Course() {
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


}
