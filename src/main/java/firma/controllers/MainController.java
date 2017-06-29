package firma.controllers;

import firma.utils.DialogsUnits;
import firma.utils.FxmlUtils;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.Optional;

import static javafx.application.Application.STYLESHEET_CASPIAN;
import static javafx.application.Application.STYLESHEET_MODENA;

/**
 * Created by   on 2017-06-07.
 */
public class MainController {

    @FXML
    private BorderPane borderPane;

    @FXML
    private TopMenuButtomsController topMenuButtomsController;

    /**
     * W tej metodzie następuje ustawienie głównego kontrolera sekcji topMenuButtoms na akutualnie znajdujący sie kontroleer
     * czyi na MainController
     */
    @FXML
    private void initialize() {
        topMenuButtomsController.setMainController(this);
    }

    /**
     * Wczytanie z klasy FxmlUtils pliku FXML i ustawienie go w centrum
     * @param fxmlPath sciezka do pliku fxml
     */
    public void setCenter(String fxmlPath){
        borderPane.setCenter(FxmlUtils.fxmlLoader(fxmlPath));
    }





    /**
     * Wywołuje się po wciśnieciu opcjin zamknij w menu głównym aplikacji
     */
    @FXML
    public void closeAplication() {
        Optional<ButtonType> result = DialogsUnits.dialogConfirmation();
        if(result.get() == ButtonType.OK) {
            Platform.exit();
            System.exit(0);
        }
    }
    @FXML
    public void setCaspian() {
        Application.setUserAgentStylesheet(STYLESHEET_CASPIAN);
    }
    @FXML
    public void setModena() {
        Application.setUserAgentStylesheet(STYLESHEET_MODENA);
    }
    @FXML
    public void setAlwaysOnTop(ActionEvent actionEvent) {

        /**
         * Odwołanie sie do Stage który jest w klasie Main
         */
        Stage stage = (Stage) borderPane.getScene().getWindow();
        /**
         * odwołuje sie do żródła którym wiem że ejs CheckMenuItem, skoro to wiem to mogę na to rzutowac następnie
         * wyciagam wartosc czy jest  zaznaczone i przypisuje do booleana
         */
        boolean value = ((CheckMenuItem) actionEvent.getSource()).selectedProperty().get();

        /**
         * Ustawienie tego by funkcja zawsze na wierzchu była zaznaczona jak value (które zalezy od wartosci checkMenuitem)
         * jest zaznaczone  czyli = true
         */
        stage.setAlwaysOnTop(value);
    }

    /**
     * Obsługuje menu górne w sekcji pomoc -> o aplikcaji
     */
    @FXML
    public void about() {
        DialogsUnits.dialogAboutAplication();
    }

    /*
     narazie nie wiem jak zrobić żeby w czasie trwania programu zmianiac język albo mam pomysła żeby
     robic to słabo     */
    @FXML
    public void setPolish() {
    }
    @FXML
    public void setEnglish() {
    }
}
