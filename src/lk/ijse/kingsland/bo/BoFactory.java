package lk.ijse.kingsland.bo;


import lk.ijse.kingsland.bo.custom.impl.*;

public class BoFactory {
    //1st Step
    private static BoFactory boFactory;

    //2nd Step
    private BoFactory() {
    }

    //3rd Step
    public static BoFactory getInstance() {
        return (boFactory == null) ?
                (boFactory = new BoFactory()) : (boFactory);
    }

    //4th Step
    public enum BOType {
        STUDENT, COURSE, REGISTRATION,REPORT,DEFAULT
    }

    //5th Step
    public <T> T getBo(BOType type) {
        switch (type) {
            case STUDENT:
                return (T) new StudentBoImpl();
            case COURSE:
                return (T) new CourseBoImpl();
            case REGISTRATION:
                return (T) new RegistrationBoImpl();
            case REPORT:
                return (T) new ReportBoImpl();
            case DEFAULT:
                return (T) new DefaultBoImpl();

            default:
                return null;
        }
    }

}
