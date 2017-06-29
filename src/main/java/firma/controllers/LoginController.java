package firma.controllers;

import com.sun.javafx.binding.StringFormatter;
import firma.modelFx.WynagrodzenieFx;
import firma.utils.DialogsUnits;
import firma.utils.FxmlUtils;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.sql.*;
import java.util.Optional;

public class LoginController {


    public static String uprawnieniaObecnieZalogowanego;


    @FXML
    private VBox hboxlogin;
    @FXML
    private TextField loginTF;

    @FXML
    private TextField passwordTF;

    @FXML
    private Button logButton;

    @FXML
    private Button cencelButton;

    @FXML
    void cencelButtonOnAction() {
            Platform.exit();
            System.exit(0);
    }

    @FXML
    public void logButtonOnAction() {
        String login =new String();
        String password = new String();
        String abiblities =  new String();
        Boolean logFlag = false;

        try {
            Connection connection = null;
            String sql = "Select * from konto_uzytkownik";
            System.out.println(sql);

            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:", "SYSTEM", "oracle");
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();

            while (rs.next()) {
              login=rs.getString("nazwa_uzytkownika");
              password=rs.getString("haslo");
              abiblities=rs.getString("uprawnienia");

                if(login.equals(loginTF.getText()) && password.equals(passwordTF.getText())) {
                    System.out.println("login :"+login+"  tf "+loginTF.getText());
                    uprawnieniaObecnieZalogowanego=abiblities;
                    logFlag=true;
                }
            }

        }catch (SQLException e){
            System.out.println("Connection to DataBase failed ! Check output consloe");
            DialogsUnits.errorDialog(e.getMessage());

        }

        if(logFlag) {
            System.out.println("zalogowano");
            hboxlogin.getScene().getWindow().hide();
        }
        else {
            System.out.println("blad logowania");
            DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("log.fxml.wrong"));
        }
    }

}
