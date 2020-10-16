package lk.ijse.kingsland.dao.custom.impl;

import lk.ijse.kingsland.dao.CrudUtil;
import lk.ijse.kingsland.dao.QueryDAO;
import lk.ijse.kingsland.entity.Student;

import java.sql.ResultSet;
import java.util.ArrayList;

public class QueryDAOImpl implements QueryDAO {

    @Override
    public ArrayList getCourseNames() throws Exception {
        ResultSet set = CrudUtil.execute("SELECT * FROM Course");
        ArrayList<String> list = new ArrayList<>();
        while (set.next()){
            list.add(set.getString(2));

        }
        return list;
    }

    @Override
    public ArrayList<Student> getCourseWise(String courseName) throws Exception {
        ResultSet set = CrudUtil.execute("SELECT distinct s.id,s.studentName,s.address,s.contact,s.dob,s.gender FROM student s,registration r,course c " +
                "WHERE(c.code=r.coursecode && s.id = r.studentid) && c.courseName = ?;",courseName);
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

    @Override
    public int getTotStudent() throws Exception {
       ResultSet set = CrudUtil.execute("SELECT count(id) from Student");
       if(set.next()){
          return set.getInt(1);
       }
       return 0;
    }

    @Override
    public int getTotCourse() throws Exception {
        ResultSet set = CrudUtil.execute("SELECT count(code) from Course");
        if(set.next()){
            return set.getInt(1);
        }
        return 0;

    }
}
