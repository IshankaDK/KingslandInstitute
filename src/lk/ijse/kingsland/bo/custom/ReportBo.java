package lk.ijse.kingsland.bo.custom;

import lk.ijse.kingsland.dto.StudentDTO;

import java.util.ArrayList;

public interface ReportBo {
    public ArrayList<String> getName()throws Exception;
    public ArrayList<StudentDTO> getAllStudents(String courseName)throws Exception;
}
