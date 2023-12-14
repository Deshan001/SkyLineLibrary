package lk.ijse.skylinelibrary.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.skylinelibrary.service.custom.PublisherService;
import lk.ijse.skylinelibrary.service.custom.impl.PublisherServiceImpl;
import lk.ijse.skylinelibrary.to.Publisher;
import lk.ijse.skylinelibrary.util.Regex;
import lk.ijse.skylinelibrary.util.TextFields;

import java.io.IOException;
import java.sql.SQLException;

public class ManagePublisherFormController {
    public AnchorPane PublisherFormContext;
    public JFXButton btnAddPublisher;
    public JFXButton btnClear;
    public ToggleGroup btnGroup;
    public JFXButton btnBack;
    public JFXButton btnSearch;
    public Label lblPublisherId;
    public JFXTextField txtName;
    public JFXTextField txtCountry;
    public TableView tblPublisher;
    public TableColumn columnPub_ID;
    public TableColumn columnName;
    public TableColumn columnCountry;
    public JFXTextField txtSearch;
    public RadioButton rdId;
    public RadioButton rdName;
    private PublisherService publisherService;

    public void initialize(){
        publisherService = new PublisherServiceImpl();
        setPublisherIdLabel();
        setTblPublisher();

    }

    public void setTblPublisher() {
        columnPub_ID.setCellValueFactory(new PropertyValueFactory<Publisher, String>("id"));
        columnName.setCellValueFactory(new PropertyValueFactory<Publisher, String>("name"));
        columnCountry.setCellValueFactory(new PropertyValueFactory<Publisher, String>("country"));

        try {
            tblPublisher.setItems(publisherService.getAllPublishers());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        PublisherFormContext.getChildren().clear();
        PublisherFormContext.getChildren().add(FXMLLoader.load(getClass().getResource("../view/DashBoardForm.fxml")));
    }

    public void search(String searchBy) throws SQLException, ClassNotFoundException {
        tblPublisher.setItems(publisherService.searchPublisher(searchBy,txtSearch.getText()));
    }


    public void btnSearchOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if(rdId.isSelected()){
            search("Pub_Id");
        }
        if(rdName.isSelected()){
            search("Pub_Name");
        }


    }

    public void setPublisherIdLabel(){
        try {
            lblPublisherId.setText(publisherService.getPublisherId());
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Getting new Publisher Id Error - Database Error").show();
        } catch (ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, "Getting New Publisher Id Error - Driver Error").show();

        }
    }

    public void btnAddPublisherOnAction(ActionEvent actionEvent) {

            String id = lblPublisherId.getText();
            String name = txtName.getText();
            String country= txtCountry.getText();

            if(name.length()<5){
                new Alert(Alert.AlertType.ERROR,"Publisher Added Fail - Please Enter name with characters more than 5").show();
                return;
            }

            Publisher temp = new Publisher(id,name,country);

            try {
                boolean flag = publisherService.addPublisher(temp);
                if(flag){
                    new Alert(Alert.AlertType.INFORMATION,"Publisher Added Successful").show();
                    setPublisherIdLabel();
                    txtName.clear();
                    txtCountry.clear();
                    setTblPublisher();

                }else{
                    new Alert(Alert.AlertType.ERROR,"Publisher Added Fail").show();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
    }

    public void txtNameOnKeyReleasedAction(KeyEvent keyEvent) {
        Regex.setTextColor(TextFields.PHONE,txtName);
        System.out.println(Regex.isTextFieldValid(TextFields.NAME,txtName.getText()));
    }

    public void txtCountryOnKeyReleasedAction(KeyEvent keyEvent) {
        Regex.setTextColor(TextFields.NAME,txtCountry);
        System.out.println(Regex.isTextFieldValid(TextFields.NAME,txtCountry.getText()));
    }
}
