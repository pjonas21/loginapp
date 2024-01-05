package com.pjonas.loginapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class HelloController {
    @FXML
    private Button cancelButton;

    @FXML
    private Label messageLoginLabel;

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordPasswordField;

    public void onLoginButtonClick(ActionEvent e) {

        if (!usernameTextField.getText().isBlank() && !passwordPasswordField.getText().isBlank()) {
            validateLogin();
        } else {
            messageLoginLabel.setText("Informe usuario e senha");
        }
    }

    @FXML
    protected void onCancelButtonClick(ActionEvent e) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void validateLogin() {
        DatabaseConn conn = new DatabaseConn();
        Connection connectDB = conn.getConnection();

        String verifyLogin = "SELECT count(1) FROM users.UserAccounts WHERE username = '" + usernameTextField.getText() + "' AND password = '" + passwordPasswordField.getText() + "'";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet resultSet = statement.executeQuery(verifyLogin);

            while(resultSet.next()) {
                if(resultSet.getInt(1) == 1) {
                    messageLoginLabel.setText("Bem vindo!");
                } else {
                    messageLoginLabel.setText("Dados invalidos. Tente novamente.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}