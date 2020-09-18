package lk.ijse.kingsland.bo.custom.impl;

import lk.ijse.kingsland.bo.custom.CourseBo;
import lk.ijse.kingsland.dao.DaoFactory;
import lk.ijse.kingsland.dao.custom.CourseDAO;
import lk.ijse.kingsland.dto.CourseDTO;
import lk.ijse.kingsland.entity.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseBoImpl  implements CourseBo {

    private CourseDAO dao = DaoFactory.getInstance()
            .getDao(DaoFactory.DAOType.COURSE);

    @Override
    public boolean saveCourse(CourseDTO dto) throws Exception {
        return dao.save(new Course(dto.getCode(),dto.getCourseName(),dto.getCourseType(),dto.getCourseDuration()));
    }

    @Override
    public boolean updateCourse(CourseDTO dto) throws Exception {
        return dao.update(new Course(dto.getCode(),dto.getCourseName(),dto.getCourseType(),dto.getCourseDuration()));
    }

    @Override
    public boolean deleteCourse(String code) throws Exception {
        return dao.delete(code);
    }

    @Override
    public CourseDTO getCourse(String code) throws Exception {
        Course c = dao.get(code);
        return new CourseDTO(c.getCode(),c.getCourseName(),c.getCourseType(),c.getCourseDuration());
    }

    @Override
    public ArrayList<CourseDTO> getAllCourse() throws Exception {
        List<Course> courseList = dao.getAll();
        ArrayList<CourseDTO> dtoList = new ArrayList<>();
        for (Course c : courseList) {
            dtoList.add(new CourseDTO(c.getCode(),
                    c.getCourseName(),c.getCourseType(),
                    c.getCourseDuration()));
        }
        return dtoList;
    }
}
