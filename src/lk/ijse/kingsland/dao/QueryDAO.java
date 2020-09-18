package lk.ijse.kingsland.dao;

import javafx.collections.ObservableList;
import lk.ijse.kingsland.entity.Student;

import java.util.ArrayList;
import java.util.List;

public interface QueryDAO {
    public ArrayList getCourseNames() throws Exception;
    public ArrayList<Student> getCourseWise(String courseName) throws Exception;
    public int getTotStudent() throws Exception;
    public int getTotCourse() throws Exception;

// public Registration getRegDetails(String no) throws Exception;


}
