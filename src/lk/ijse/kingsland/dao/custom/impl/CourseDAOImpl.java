package lk.ijse.kingsland.dao.custom.impl;

import lk.ijse.kingsland.dao.CrudUtil;
import lk.ijse.kingsland.dao.custom.CourseDAO;
import lk.ijse.kingsland.entity.Course;
import lk.ijse.kingsland.entity.Registration;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {

    @Override
    public boolean save(Course course) throws Exception {
        return CrudUtil.execute("INSERT INTO Course VALUES(?,?,?,?)",
                course.getCode(),course.getCourseName(),course.getCourseType(),course.getCourseDuration());
    }

    @Override
    public boolean update(Course course) throws Exception {
        return CrudUtil.execute("UPDATE Course SET courseName=? , courseType=? , duration=? WHERE code = ?",
                course.getCourseName(),course.getCourseType(),course.getCourseDuration(),course.getCode());
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtil.execute("DELETE FROM Course WHERE code = ?" ,s);
    }

    @Override
    public Course get(String s) throws Exception {
        ResultSet set = CrudUtil.execute("SELECT * FROM Course WHERE courseName = ?",s);
        if (set.next()) {
            return new Course(
                    set.getString(1),
                    set.getString(2),
                    set.getString(3),
                    set.getString(4));
        } else {
            return null;
        }
    }

    @Override
    public List<Course> getAll() throws Exception {
        ResultSet set = CrudUtil.execute("SELECT * FROM Course");
        ArrayList<Course> coursesList  = new ArrayList<>();
        while(set.next()){
            coursesList.add(new Course(set.getString(1),
                    set.getString(2),set.getString(3),set.getString(4)));
        }
        return coursesList;
    }
}
