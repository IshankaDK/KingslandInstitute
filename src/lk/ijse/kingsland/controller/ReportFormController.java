package lk.ijse.kingsland.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.kingsland.bo.BoFactory;
import lk.ijse.kingsland.bo.custom.ReportBo;
import lk.ijse.kingsland.dto.StudentDTO;
import lk.ijse.kingsland.view.tm.ReportTM;

import java.util.ArrayList;
import java.util.List;

public class ReportFormController {

    public TableView <ReportTM>tblStudent;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colContact;
    public TableColumn colDob;
    public TableColumn colGender;
    public AnchorPane root;
    public JFXComboBox cmbCourseName;
    ReportBo cBo;
    //QueryBo qBO;

    public void initialize() throws Exception {
        cBo = BoFactory.getInstance().getBo(BoFactory.BOType.REPORT);
      //  qBO = BoFactory.getInstance().getBo(BoFactory.BOType.QUERY);
        getCourseNames();
        colId.setCellValueFactory(new PropertyValueFactory("id"));
        colName.setCellValueFactory(new PropertyValueFactory("studentName"));
        colAddress.setCellValueFactory(new PropertyValueFactory("address"));
        colContact.setCellValueFactory(new PropertyValueFactory("contact"));
        colDob.setCellValueFactory(new PropertyValueFactory("dob"));
        colGender.setCellValueFactory(new PropertyValueFactory("gender"));
    }

    public void cmbCourseNameOnAction(ActionEvent actionEvent) throws Exception {
        ObservableList<ReportTM> tmList = FXCollections.observableArrayList();
        List<StudentDTO> allStudent = cBo.getAllStudents((String) cmbCourseName.getValue());
        for (StudentDTO dto : allStudent ) {
            ReportTM tm = new ReportTM(dto.getId(),dto.getStudentName(),dto.getAddress(),
                    dto.getContact(),dto.getDob(),dto.getGender());
            tmList.add(tm);

        }
        tblStudent.setItems(tmList);
    }
    public void getCourseNames() throws Exception {
        ObservableList<String> observableList = FXCollections.observableArrayList();
        ArrayList<String> arrayList = cBo.getName();
        for (String s : arrayList) {
            observableList.add(s);

        }
        cmbCourseName.setItems(observableList);
    }
}
