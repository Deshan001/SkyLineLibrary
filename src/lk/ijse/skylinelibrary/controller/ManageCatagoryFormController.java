package lk.ijse.skylinelibrary.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.skylinelibrary.service.custom.CategoryService;
import lk.ijse.skylinelibrary.service.custom.impl.CategoryServiceImpl;
import lk.ijse.skylinelibrary.to.Catagory;
import lk.ijse.skylinelibrary.util.Regex;
import lk.ijse.skylinelibrary.util.TextFields;

import java.io.IOException;
import java.sql.SQLException;

public class ManageCatagoryFormController {

    public JFXButton btnAddCatagory;
    public JFXButton btnClear;
    public ToggleGroup btnGroup;
    public JFXButton btnBack;
    public JFXButton btnSearch;
    public TableView tblCategory;
    public TableColumn columnId;
    public TableColumn columnName;
    public TableColumn columnAgeGroup;
    public AnchorPane ManageCatagoryContext;
    public Label lblCategoryId;
    public JFXTextField txtCategory;
    public JFXComboBox cbCategoryComboBox;
    public JFXTextField txtSearch;
    public RadioButton rdId;
    public RadioButton rdCatagoryName;
    private CategoryService categoryService;

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        ManageCatagoryContext.getChildren().clear();
        ManageCatagoryContext.getChildren().add(FXMLLoader.load(getClass().getResource("../view/DashBoardForm.fxml")));
    }

    public void initialize(){
        categoryService = new CategoryServiceImpl();
        setCatagoryComboBox();
        setCategoryTable();
        setNewCatagoryLabel();


    }
    public void setNewCatagoryLabel(){
        try {
            lblCategoryId.setText(categoryService.getCatagoryId());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setCategoryTable(){
        columnId.setCellValueFactory(new PropertyValueFactory<Catagory,String>("id"));
        columnName.setCellValueFactory(new PropertyValueFactory<Catagory,String>("category"));
        columnAgeGroup.setCellValueFactory(new PropertyValueFactory<Catagory,String>("age_group"));
        try {
            ObservableList<Catagory> allCatagory = categoryService.getAllCatagory();
            tblCategory.setItems(allCatagory);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void setCatagoryComboBox(){
        String [] ageGroups={"Children","Teen","Adult"};
        cbCategoryComboBox.setItems(FXCollections.observableArrayList(ageGroups));
    }

    public void search(String searchBy) throws SQLException, ClassNotFoundException {
        tblCategory.setItems(categoryService.searchCatagory(searchBy,txtSearch.getText()));
    }

    public void btnSearchOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if(rdId.isSelected()){
            search("C_Id");
        }
        if(rdCatagoryName.isSelected()){
            search("category");
        }

    }



    public void btnAddCatagoryOnAction(ActionEvent actionEvent) {
        String id = lblCategoryId.getText();
        String category = txtCategory.getText();
        String age_group = cbCategoryComboBox.getSelectionModel().getSelectedItem().toString();

        if(category.length()<5){
            new Alert(Alert.AlertType.ERROR,"Category Added Fail - Please Enter category with characters more than 5").show();
            return;
        }

        Catagory temp = new Catagory(id,category,age_group);

        try {
            boolean flag = categoryService.addCatagory(temp);
            if(flag){
                new Alert(Alert.AlertType.INFORMATION,"Category Added Successful").show();
                setCategoryLabelId();
                txtCategory.clear();
                setCategoryTable();
            }else{
                new Alert(Alert.AlertType.ERROR,"Category Added Fail").show();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void setCategoryLabelId() {
        try {
            lblCategoryId.setText(categoryService.getCatagoryId());
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Getting new Category Id Error - Database Error").show();
        } catch (ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, "Getting New Category Id Error - Driver Error").show();

        }
    }

    public void txtCategoryOnKeyReleasedAction(KeyEvent keyEvent) {
        Regex.setTextColor(TextFields.NAME,txtCategory);
        System.out.println(Regex.isTextFieldValid(TextFields.NAME,txtCategory.getText()));
    }
}

