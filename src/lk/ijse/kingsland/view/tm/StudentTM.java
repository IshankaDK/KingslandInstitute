package lk.ijse.kingsland.view.tm;

import javafx.scene.control.Button;

public class StudentTM {
    private String id;
    private String studentName;
    private String address;
    private String contact;
    private String dob;
    private String gender;
    private Button btn;

    public StudentTM() {
    }

    public StudentTM(String id, String studentName, String address, String contact, String dob, String gender, Button btn) {
        this.setId(id);
        this.setStudentName(studentName);
        this.setAddress(address);
        this.setContact(contact);
        this.setDob(dob);
        this.setGender(gender);
        this.setBtn(btn);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}
