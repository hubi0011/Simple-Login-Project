package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.ResultSet;
import java.sql.Statement;
public class LoginController {
    @FXML
    Button buttonLogin;
    @FXML
    PasswordField passwordField;
    @FXML
    TextField textFieldUserName;
    @FXML
    Button cancelButton;
    @FXML
    Label loginMessage;

    public void cancelButton(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    public void buttonLogin(ActionEvent e) {
        if (!textFieldUserName.getText().isEmpty() && !passwordField.getText().isEmpty()) {
            validate();
        } else
            loginMessage.setText("naura");
    }
    public void validate() {
        Connect conncetNow = new Connect();
        conncetNow.getConnetion();
        String verifyLogin = "select count (1) from account join password on " +
                "account.password_passwrodid=password.passwrodID " +
                "where password='" +
                passwordField.getText() + "'" +
                "and userName_userName='" +
                textFieldUserName.getText() + "'";
        try {
            Statement statement = conncetNow.getConnetion().createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    loginMessage.setText("Welcome");
                } else {
                    loginMessage.setText("Try Again");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}

