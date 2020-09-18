package lk.ijse.kingsland.bo.custom.impl;

import lk.ijse.kingsland.bo.custom.StudentBo;
import lk.ijse.kingsland.dao.DaoFactory;
import lk.ijse.kingsland.dao.custom.StudentDAO;
import lk.ijse.kingsland.dto.StudentDTO;
import lk.ijse.kingsland.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentBoImpl implements StudentBo {

    private StudentDAO dao = DaoFactory.getInstance()
            .getDao(DaoFactory.DAOType.STUDENT);


    @Override
    public boolean saveStudent(StudentDTO dto) throws Exception {
        return dao.save(new Student(dto.getId(),dto.getStudentName(),dto.getAddress(),dto.getContact(),dto.getDob(),dto.getGender()));
    }

    @Override
    public boolean updateStudent(StudentDTO dto) throws Exception {
        return dao.update(new Student(dto.getId(),dto.getStudentName(),dto.getAddress(),dto.getContact(),dto.getDob(),dto.getGender()));
    }

    @Override
    public boolean deleteStudent(String id) throws Exception {
        return dao.delete(id);
    }

    @Override
    public StudentDTO getStudent(String id) throws Exception {
        Student s = dao.get(id);
        if (s != null) {
            return new StudentDTO(s.getId(), s.getStudentName(), s.getAddress(), s.getContact(), s.getDob(), s.getGender());
        }
        return null;
    }

    @Override
    public ArrayList<StudentDTO> getAllStudents() throws Exception {
        List<Student> studentList = dao.getAll();
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
