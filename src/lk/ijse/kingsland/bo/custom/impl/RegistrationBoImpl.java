package lk.ijse.kingsland.bo.custom.impl;

import lk.ijse.kingsland.bo.custom.RegistrationBo;
import lk.ijse.kingsland.dao.DaoFactory;
import lk.ijse.kingsland.dao.QueryDAO;
import lk.ijse.kingsland.dao.custom.RegistrationDAO;
import lk.ijse.kingsland.dto.RegistrationDTO;
import lk.ijse.kingsland.entity.Registration;

import java.util.ArrayList;

public class RegistrationBoImpl implements RegistrationBo {

    private RegistrationDAO dao = DaoFactory.getInstance().getDao(DaoFactory.DAOType.REGISTRATION);
    private QueryDAO qDao= DaoFactory.getInstance().getDao(DaoFactory.DAOType.QUERY);
    
    @Override
    public boolean saveRegistration(RegistrationDTO dto) throws Exception {

        return dao.save(new Registration(dto.getRegNo(),dto.getRegDate(),dto.getRegFee(),
                dto.getStudentId(),dto.getCourseCode()));
    }

    @Override
    public boolean updateRegistration(RegistrationDTO dto) throws Exception {
        return dao.update(new Registration(dto.getRegNo(),dto.getRegDate(),dto.getRegFee(),
                dto.getStudentId(),dto.getCourseCode()));
    }

    @Override
    public boolean deleteRegistration(String no) throws Exception {
        return dao.delete(no);
    }

    @Override
    public RegistrationDTO getRegistration(String no) throws Exception {
        Registration r = dao.get(no);
        return new RegistrationDTO(r.getRegNo(),r.getRegDate(),r.getRegFee(),r.getStudentId(),r.getCourseCode());
    }

    @Override
    public ArrayList<RegistrationDTO> getAllRegistrations() throws Exception {
        return null;
    }

    @Override
    public ArrayList<String> getName() throws Exception {

        return qDao.getCourseNames();

    }


}
