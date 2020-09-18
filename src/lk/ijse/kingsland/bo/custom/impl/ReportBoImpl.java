package lk.ijse.kingsland.bo.custom.impl;

import lk.ijse.kingsland.bo.custom.ReportBo;
import lk.ijse.kingsland.dao.DaoFactory;
import lk.ijse.kingsland.dao.QueryDAO;
import lk.ijse.kingsland.dto.StudentDTO;
import lk.ijse.kingsland.entity.Student;

import java.util.ArrayList;

public class ReportBoImpl implements ReportBo {
    private QueryDAO dao = DaoFactory.getInstance().getDao(DaoFactory.DAOType.QUERY);
    @Override
    public ArrayList<String> getName() throws Exception {
        return dao.getCourseNames();
    }
    @Override
    public ArrayList<StudentDTO> getAllStudents(String courseName) throws Exception {
        ArrayList<Student> studentList = dao.getCourseWise(courseName);
        ArrayList<StudentDTO>dtoList = new ArrayList<>();
        for (Student student : studentList) {
            dtoList.add(new StudentDTO(student.getId(),
                    student.getStudentName(),student.getAddress(),
                    student.getContact(),student.getDob(),
                    student.getGender()));
        }
        return dtoList;
    }
}
