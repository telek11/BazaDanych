package firma.controllers;

import firma.modelFx.UmowaModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

/**
 * Created by Matball on 2017-06-10.
 */
public class AddUmowaController {

    @FXML
    private TextField id_umowaTF;
    @FXML
    private TextField data_zawarciaTF;
    @FXML
    private TextField data_koncaTF;
    @FXML
    private TextField opisTF;
    @FXML
    private TextField znizka_na_telefonTF;
    @FXML
    private TextField kara_za_zerwanieTF;
    @FXML
    private CheckBox opcjonalny_telefonTF;
    @FXML
    private TextField id_centralaTF;
    @FXML
    private TextField id_pracownikTF;
    @FXML
    private TextField id_klientaTF;
    @FXML
    private Button AddUmowaButton;

    private UmowaModel umowaModel;

    @FXML
    public void initialize(){this.umowaModel= new UmowaModel();}

    @FXML
    void AddUmowa(){

        String dataZawarcia =data_zawarciaTF.getText();
        String dataKonca =data_koncaTF.getText();
        String opis =opisTF.getText();
        String znizkaNaTelefon =znizka_na_telefonTF.getText();
        String karaZaZerwanie =kara_za_zerwanieTF.getText();
        String idCentrala =id_centralaTF.getText();
        String idPracownik=id_pracownikTF.getText();
        String idKlienta=id_klientaTF.getText();

        String opcjonalny_telefon="0";
        if(opcjonalny_telefonTF.isSelected()==true){opcjonalny_telefon="1";}
        else{opcjonalny_telefon="0";}

        umowaModel.saveUmowaInDateBase(dataZawarcia,dataKonca,opis,znizkaNaTelefon,karaZaZerwanie,opcjonalny_telefon,idCentrala,idPracownik,idKlienta);
    }


}
