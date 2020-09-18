package lk.ijse.kingsland.dao;

import lk.ijse.kingsland.dao.custom.impl.CourseDAOImpl;
import lk.ijse.kingsland.dao.custom.impl.QueryDAOImpl;
import lk.ijse.kingsland.dao.custom.impl.RegistrationDAOImpl;
import lk.ijse.kingsland.dao.custom.impl.StudentDAOImpl;

public class DaoFactory {
    private static DaoFactory daoFactory;

    //2nd Step
    private DaoFactory() {
    }

    //3rd Step
    public static DaoFactory getInstance() {
        return (daoFactory == null) ?
                (daoFactory = new DaoFactory()) : (daoFactory);
    }

    //4th Step
    public enum DAOType {
        COURSE, STUDENT, REGISTRATION,QUERY
    }
    public <T> T getDao(DAOType type) {
        switch (type) {
            case COURSE:
                return (T) new CourseDAOImpl();
            case STUDENT:
                return (T) new StudentDAOImpl();
            case REGISTRATION:
                return (T) new RegistrationDAOImpl();
            case QUERY:
                return (T) new QueryDAOImpl();
            default:
                return null;
        }
    }
}