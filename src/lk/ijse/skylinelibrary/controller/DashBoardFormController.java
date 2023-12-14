package lk.ijse.skylinelibrary.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.skylinelibrary.service.custom.*;
import lk.ijse.skylinelibrary.service.custom.impl.*;
import lk.ijse.skylinelibrary.util.CrudUtil;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DashBoardFormController {
    public JFXButton btnManageMembers;
    public AnchorPane DashBoardContext;
    public JFXButton btnManageBooks;
    public JFXButton btnBorrowedBookRecords;
    public JFXButton btnManageAuthors;
    public JFXButton btnManagePublishers;
    public JFXButton btnManageCategory;
    public JFXButton btnManageExpenditure;
    public JFXButton btnReturnAndFine;
    public JFXButton btnLogOut;
    public Label lblMemberCount;
    public Label lblBookCount;
    public Label lblRecordsCount;
    public Label lblAuthorCount;
    public Label lblCatagoryCount;
    public Label lblExpenditureCount;
    public Label lblPublisherCount;
    private BorrowBookRecordsService borrowBookRecordsService;
    private BookService bookService;
    private AuthorService authorService;
    private CategoryService categoryService;
    private  ExpenditureService expenditureService;
    private MemberService memberService;
    private PublisherService publisherService;

   public void initialize() throws SQLException, ClassNotFoundException {
       borrowBookRecordsService=new BorrowBookRecordsServiceImpl();
       bookService=new BookServiceImpl();
       authorService=new AuthorSeviceImpl();
       categoryService=new CategoryServiceImpl();
       expenditureService = new ExpenditureServiceImpl();
       memberService = new MemberServiceImpl();
       publisherService = new PublisherServiceImpl();
       visibleMemberCount();
       visibleBookCount();
       visibleRecordsCount();
       visibleAuthorCount();
       visiblePublisherCount();
       visibleCatagoryCount();
       visibleExpenditureCount();

    }
    public void btnManageMembersOnAction(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) DashBoardContext.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ManageMemberForm.fxml"))));
    }

    public void visibleMemberCount() throws SQLException, ClassNotFoundException {
        lblMemberCount.setText(memberService.getMemberCount());
    }


    public void btnManageBooksOnAction(ActionEvent actionEvent) throws IOException {
        DashBoardContext.getChildren().clear();
        DashBoardContext.getChildren().add(FXMLLoader.load(getClass().getResource("../view/ManageBooksForm.fxml")));
    }

    public void visibleBookCount() throws SQLException, ClassNotFoundException {
        lblBookCount.setText(bookService.getBookCount());
    }

    public void btnBorrowedBookRecordsOnAction(ActionEvent actionEvent) throws IOException {
        DashBoardContext.getChildren().clear();
        DashBoardContext.getChildren().add(FXMLLoader.load(getClass().getResource("../view/BorrowedBookRecords.fxml")));
    }

    public void visibleRecordsCount() throws SQLException, ClassNotFoundException {
        lblRecordsCount.setText(borrowBookRecordsService.getRecordsCount());
    }

    public void btnManageAuthorsOnAction(ActionEvent actionEvent) throws IOException {
        DashBoardContext.getChildren().clear();
        DashBoardContext.getChildren().add(FXMLLoader.load(getClass().getResource("../view/ManageAuthorForm.fxml")));
    }

    public void visibleAuthorCount() throws SQLException, ClassNotFoundException {
        lblAuthorCount.setText(authorService.getAuthorCount());
    }

    public void btnManagePublishersOnAction(ActionEvent actionEvent) throws IOException {
        DashBoardContext.getChildren().clear();
        DashBoardContext.getChildren().add(FXMLLoader.load(getClass().getResource("../view/ManagePublisherForm.fxml")));
    }


    public void visiblePublisherCount() throws SQLException, ClassNotFoundException {
        lblPublisherCount.setText(publisherService.getPublisherCount());
    }

    public void btnManageCatagoryOnAction(ActionEvent actionEvent) throws IOException {
        DashBoardContext.getChildren().clear();
        DashBoardContext.getChildren().add(FXMLLoader.load(getClass().getResource("../view/ManageCatagoryForm.fxml")));
    }

    public void visibleCatagoryCount() throws SQLException, ClassNotFoundException {
        lblCatagoryCount.setText(categoryService.getCatagoryCount());
    }

    public void btnManageExpenditureOnAction(ActionEvent actionEvent) throws IOException {
        DashBoardContext.getChildren().clear();
        DashBoardContext.getChildren().add(FXMLLoader.load(getClass().getResource("../view/ManageExpenditure.fxml")));
    }

    public void visibleExpenditureCount() throws SQLException, ClassNotFoundException {
        lblExpenditureCount.setText(expenditureService.getExpenditureCount());
    }

    public void btnManageIncomeOnAction(ActionEvent actionEvent) throws IOException {
        DashBoardContext.getChildren().clear();
        DashBoardContext.getChildren().add(FXMLLoader.load(getClass().getResource("../view/ManageIncome.fxml")));
    }

    public void btnLogOutOnAction(ActionEvent actionEvent) throws IOException {
        DashBoardContext.getChildren().clear();
        DashBoardContext.getChildren().add(FXMLLoader.load(getClass().getResource("../view/LoginForm.fxml")));
    }

}
