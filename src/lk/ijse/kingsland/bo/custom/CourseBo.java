package lk.ijse.kingsland.bo.custom;

import lk.ijse.kingsland.dto.CourseDTO;

import java.util.ArrayList;

public interface CourseBo {
    public boolean saveCourse(CourseDTO dto)throws Exception;
    public boolean updateCourse(CourseDTO dto)throws Exception;
    public boolean deleteCourse(String code)throws Exception;
    public CourseDTO getCourse(String code)throws Exception;
    public ArrayList<CourseDTO> getAllCourse()throws Exception;
  //  public String getId()throws Exception;
}
