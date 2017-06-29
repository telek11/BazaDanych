package firma.controllers;

import firma.modelFx.WynagrodzenieModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddWynagrodzenieController {

    @FXML
    private TextField data_zaplatyTF;

    @FXML
    private TextField kwota_bazowa_TF;

    @FXML
    private TextField przelicznik_etatuTF;

    @FXML
    private TextField przelicznik_stanowiskaTF;

    @FXML
    private TextField premiaTF;

    @FXML
    private TextField id_pracownikTF;

    @FXML
    private Button AddWynagrodzenieButton;

    private WynagrodzenieModel wynagrodzenieModel;

    @FXML
    public void  initialize(){
        this.wynagrodzenieModel= new WynagrodzenieModel();
    }

    /**
     * Metoda obługiwana po wciśnieciu przycisku dodaj wynagrodzenie
     * pobierane sa w niej ciągi znakowe z pól text field a następnie zapisaywane w zmiennych w których sa przesyłane do metody zapisujacej
     * wynagrodzenie w bazie danych
     */
    @FXML
    void AddWynagrodzenie() {
        String dataZaplaty = data_zaplatyTF.getText();
        String kwotaBazowa = kwota_bazowa_TF.getText();
        String przelicznikEtatu = przelicznik_etatuTF.getText();
        String przelicznikStanowiska = przelicznik_stanowiskaTF.getText();
        String premia = premiaTF.getText();
        String idPracownika = id_pracownikTF.getText();


        wynagrodzenieModel.saveWynagrodzenieInDataBase(dataZaplaty,kwotaBazowa,przelicznikEtatu,przelicznikStanowiska,premia,idPracownika);
    }

}
