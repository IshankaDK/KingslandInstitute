package lk.ijse.kingsland.entity;

public class Registration implements SuperEntity {
    private int regNo;
    private String regDate;
    private String regFee;
    private String StudentId;
    private String courseCode;

    public Registration(int regNo, String regDate, String regFee, String studentId, String courseCode) {
        this.regNo = regNo;
        this.regDate = regDate;
        this.regFee = regFee;
        this.StudentId = studentId;
        this.courseCode = courseCode;
    }

    public Registration() {
    }

    public int getRegNo() {
        return regNo;
    }

    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getRegFee() {
        return regFee;
    }

    public void setRegFee(String regFee) {
        this.regFee = regFee;
    }

    public String getStudentId() {
        return StudentId;
    }

    public void setStudentId(String studentId) {
        this.StudentId = studentId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "regNo=" + regNo +
                ", regDate='" + regDate + '\'' +
                ", regFee='" + regFee + '\'' +
                ", StudentId='" + StudentId + '\'' +
                ", courseCode='" + courseCode + '\'' +
                '}';
    }
}
