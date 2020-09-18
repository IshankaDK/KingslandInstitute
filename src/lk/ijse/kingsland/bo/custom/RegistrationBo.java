package lk.ijse.kingsland.bo.custom;


import javafx.collections.ObservableList;
import lk.ijse.kingsland.dto.RegistrationDTO;

import java.util.ArrayList;
import java.util.List;

public interface RegistrationBo {
    public boolean saveRegistration(RegistrationDTO dto)throws Exception;
    public boolean updateRegistration(RegistrationDTO dto)throws Exception;
    public boolean deleteRegistration(String no)throws Exception;
    public RegistrationDTO getRegistration(String no)throws Exception;
    public ArrayList<RegistrationDTO> getAllRegistrations()throws Exception;

    public ArrayList<String> getName()throws Exception;
}
