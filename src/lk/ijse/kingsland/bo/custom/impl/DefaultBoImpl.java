package lk.ijse.kingsland.bo.custom.impl;

import lk.ijse.kingsland.bo.custom.DefaultBo;
import lk.ijse.kingsland.dao.DaoFactory;
import lk.ijse.kingsland.dao.QueryDAO;

public class DefaultBoImpl implements DefaultBo {
    private QueryDAO qDao= DaoFactory.getInstance().getDao(DaoFactory.DAOType.QUERY);
    @Override
    public int getTotalStudent() throws Exception {
        return qDao.getTotStudent();
    }

    @Override
    public int getTotalCourse() throws Exception {
        return qDao.getTotCourse();
    }
}
