package lk.ijse.kingsland.dao.custom.impl;

import lk.ijse.kingsland.dao.CrudUtil;
import lk.ijse.kingsland.dao.custom.RegistrationDAO;
import lk.ijse.kingsland.entity.Registration;
import lk.ijse.kingsland.entity.Student;

import java.sql.ResultSet;
import java.util.List;

public class RegistrationDAOImpl implements RegistrationDAO {

    @Override
    public boolean save(Registration reg) throws Exception {
        return CrudUtil.execute("INSERT INTO Registration VALUES (?,?,?,?,?)",
                reg.getRegNo(),reg.getRegDate(),reg.getRegFee(),
                reg.getStudentId(),reg.getCourseCode());
    }

    @Override
    public boolean update(Registration reg) throws Exception {
        return CrudUtil.execute("UPDATE Registration SET regDate =? ,regFee =? ,StudentId = ? , Coursecode = ? WHERE regNo = ?",
               reg.getRegDate(),reg.getRegFee(),
                reg.getStudentId(),reg.getCourseCode(),reg.getRegNo());
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtil.execute("DELETE FROM Registration WHERE regNo = ?",s);
    }

    @Override
    public Registration get(String s) throws Exception {
        int a= Integer.parseInt(s);
        ResultSet set = CrudUtil.execute("SELECT * FROM Registration WHERE regNo=?",a);
        if(set.next()){ return new Registration(
                    set.getInt(1),
                    set.getString(2),
                    set.getString(3),
                    set.getString(4),
                    set.getString(5));
        }else {
            return null;
        }

    }

    @Override
    public List<Registration> getAll() throws Exception {
        return null;
    }
}
