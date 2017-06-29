package firma.controllers;

import firma.utils.DialogsUnits;
import firma.utils.FxmlUtils;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by   on 2017-06-07.
 */
public class TopMenuButtomsController {


    public static final String FXML_TABLE_WYNAGRODZENIE = "/fxml/TableWynagrodzenie.fxml";
    public static final String FXML_TABLE_EMPLOYEE = "/fxml/TableEmployee.fxml";
    public static final String FXML_TABLE_UMOWA = "/fxml/TableUmowa.fxml";
    @FXML
    private ComboBox<String> comboBox;

    public static final String FXML_ADD_EMPLOYEE = "/fxml/AddEmployee.fxml";
    public static final String FXML_ADD_WYNAGRODZENIE = "/fxml/AddWynagrodzenie.fxml";
    public static final String FXML_ADD_UMOWA = "/fxml/AddUmowa.fxml";

    private MainController mainController;

    /**
     * Na poczatku metody tworze liste z Encjami dostepnymi w programie
     */
    public void initialize(){
        List<String> arrayList =  new ArrayList<String>();
        arrayList.add(new String(FxmlUtils.getResourceBundle().getString("comboBox.pracownik")));
        arrayList.add(new String(FxmlUtils.getResourceBundle().getString("comboBox.umowa")));
        arrayList.add(new String(FxmlUtils.getResourceBundle().getString("comboBox.wynagrodzenie")));

        comboBox.getItems().addAll(arrayList);
    }

    /**
     * Funkcja "przekazuje sterowanie nad menu przycisków
     */
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    public void openTable() {


        if((comboBox.getSelectionModel().getSelectedItem()).equals(FxmlUtils.getResourceBundle().getString("comboBox.wynagrodzenie"))){
            if (LoginController.uprawnieniaObecnieZalogowanego.equals("Administrator") || LoginController.uprawnieniaObecnieZalogowanego.equals("Ksiegowy")) {
            mainController.setCenter(FXML_TABLE_WYNAGRODZENIE);
            } else DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("Error.access.deny"));
        }
        if((comboBox.getSelectionModel().getSelectedItem()).equals(FxmlUtils.getResourceBundle().getString("comboBox.pracownik"))) {
            if (LoginController.uprawnieniaObecnieZalogowanego.equals("Administrator") || LoginController.uprawnieniaObecnieZalogowanego.equals("Ksiegowy") || LoginController.uprawnieniaObecnieZalogowanego.equals("Pracownik")) {
            mainController.setCenter(FXML_TABLE_EMPLOYEE);
            } else DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("Error.access.deny"));
        }
        if((comboBox.getSelectionModel().getSelectedItem()).equals(FxmlUtils.getResourceBundle().getString("comboBox.umowa"))) {
            if (LoginController.uprawnieniaObecnieZalogowanego.equals("Administrator") || LoginController.uprawnieniaObecnieZalogowanego.equals("Ksiegowy") || LoginController.uprawnieniaObecnieZalogowanego.equals("Pracownik")) {
            mainController.setCenter(FXML_TABLE_UMOWA);
            } else DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("Error.access.deny"));
        }

    }

    @FXML
    public void openSortProperties() {

    }

    @FXML
    public void openSearchByPhraze() {

        String numberOfRecords = new String();
        try {
            Connection connection = null;
            String sql= "Select id_pracownik,imie,czy_pracuje_aktualnie from pracownik";
            System.out.println(sql);

            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:", "SYSTEM", "oracle");
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();

            //for (int i=1;i<=rsmd.getColumnCount();i++)
           // {
            //    System.out.println(rsmd.getColumnLabel(i));
            //}


            while (rs.next())
            {
                int id_pracownik =rs.getInt("id_pracownik");
                String imie = rs.getString("imie");
                Boolean czy_pracuje_aktualnie = rs.getBoolean("czy_pracuje_aktualnie");
                System.out.println("id: "+id_pracownik+"imie :"+imie+" czy pracuje "+czy_pracuje_aktualnie);
            }
        }
        catch (SQLException e){
            System.out.println("Connection to DataBase failed ! Check output consloe");
            DialogsUnits.errorDialog(e.getMessage());
        }
    }

    @FXML
    public void openAddTable() {
        System.out.println("UPRANIENIA : "+LoginController.uprawnieniaObecnieZalogowanego);



            //DO ZAIMPLEMENTOWANIA OBSLUGA // if(comboBox.getSelectionModel().isEmpty())
            // GDZY NIC NIE MA ZAZNACZONEGO W COMBO BOXIE//    DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("error.not.category"));

        /**
         * Ponizej if-y ktore nadaja uprawnineia
         */
        if ((comboBox.getSelectionModel().getSelectedItem()).equals(FxmlUtils.getResourceBundle().getString("comboBox.wynagrodzenie"))) {
            if (LoginController.uprawnieniaObecnieZalogowanego.equals("Administrator")) {
                mainController.setCenter(FXML_ADD_WYNAGRODZENIE);
            } else DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("Error.access.deny"));
        }

        if ((comboBox.getSelectionModel().getSelectedItem()).equals(FxmlUtils.getResourceBundle().getString("comboBox.pracownik"))) {
            if (LoginController.uprawnieniaObecnieZalogowanego.equals("Administrator")) {
                mainController.setCenter(FXML_ADD_EMPLOYEE);
            } else DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("Error.access.deny"));
        }

        if ((comboBox.getSelectionModel().getSelectedItem()).equals(FxmlUtils.getResourceBundle().getString("comboBox.umowa"))) {
            if (LoginController.uprawnieniaObecnieZalogowanego.equals("Administrator") || LoginController.uprawnieniaObecnieZalogowanego.equals("Pracownik")) {
                mainController.setCenter(FXML_ADD_UMOWA);
            } else DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("Error.access.deny"));
        }

    }
}
