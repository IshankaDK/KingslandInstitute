package lk.ijse.kingsland.dao.custom.impl;

import lk.ijse.kingsland.dao.CrudUtil;
import lk.ijse.kingsland.dao.custom.StudentDAO;
import lk.ijse.kingsland.entity.Student;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {


    @Override
    public boolean save(Student student) throws Exception {
        return CrudUtil.execute("INSERT INTO Student VALUES (?,?,?,?,?,?)",
                student.getId(),student.getStudentName(),student.getAddress(),student.getContact(),student.getDob(),student.getGender());
    }

    @Override
    public boolean update(Student student) throws Exception {
        return CrudUtil.execute("UPDATE Student SET studentName =? , address =? , contact =? , dob =? , gender =? WHERE id = ? ",
                student.getStudentName(),student.getAddress(),student.getContact(),student.getDob(),student.getGender(),student.getId());

    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtil.execute("DELETE FROM Student WHERE id = ?",s);
    }

    @Override
    public Student get(String s) throws Exception {
        ResultSet set = CrudUtil.execute("SELECT * FROM Student WHERE id = ?",s);
        if(set.next()){
            return new Student(
                    set.getString(1),
                    set.getString(2),
                    set.getString(3),
                    set.getString(4),
                    set.getString(5),
                    set.getString(6));

        }else{
            return null;
        }

    }
    @Override
    public List<Student> getAll() throws Exception {
        ResultSet set = CrudUtil.execute("SELECT * FROM Student");
        ArrayList<Student>stuList = new ArrayList<>();
        while (set.next()){
            stuList.add(new Student( set.getString(1),
                        set.getString(2),
                        set.getString(3),
                        set.getString(4),
                        set.getString(5),
                        set.getString(6)));
        }
        return stuList;
    }
}
