package firma.utils;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Optional;
import java.util.ResourceBundle;

public class DialogsUnits {

    static ResourceBundle bundles = FxmlUtils.getResourceBundle();

    /**
     * Dialog wyskakujcay po wciśnieciu przycisku o aplikacji w sekcji pomoc menu głównego
     * Zawiera inforamcje o aplikacji
     */
    public static void dialogAboutAplication () {
        Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);

        informationAlert.setTitle(bundles.getString("about.title"));
        informationAlert.setHeaderText(bundles.getString("about.header"));
        informationAlert.setContentText(bundles.getString("about.content"));

        informationAlert.showAndWait();
    }

    /**
     * Dialog wyskakujacy w momencie wyłaczania aplikacji i w którym mamy potwierzic chęć naszego wyjśćia
     */
    public static Optional<ButtonType> dialogConfirmation() {
        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);

        confirmationAlert.setTitle(bundles.getString("exit.title"));
        confirmationAlert.setHeaderText(bundles.getString("exit.header"));
        Optional<ButtonType> result = confirmationAlert.showAndWait();
        return result;
    }

    /**
     * Dialo który wsykakyje gdy w programie nastapił bład w smbie ma pole tekstowe w którym wypisana jest informacja o błedzie
     * @param error bład jaki wyskoczył
     */
    public static void errorDialog(String error){
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle(bundles.getString("error.title"));
        //errorAlert.setHeaderText(bundles.getString("error.header"));

        Label labelerror = new Label(error);
        errorAlert.getDialogPane().setContent(labelerror);

        errorAlert.showAndWait();
    }

    /**
     * Tworze okno w którym nastepuje wybór języka programu. okno jest uruchamiane przed wczytaneim plików z resourcebundles ( czyli
     * przed wczytaniem fxml) okno(metoda która robi to onko) zwraca wartosc string w ktorej jest zawarta informacja o wybranym jezyku
     * wybór jezyka nastepuje przez wcisniecie odpowiedzniego przycisku a nastepnie zatwierdzenie klawisza ok
     * @return
     */
    public static String languageDialog(){
        final String[] result = {new String("PL")};

        Alert chooseAlert = new Alert(Alert.AlertType.INFORMATION);

        chooseAlert.setTitle("Language");
        chooseAlert.setHeaderText("Choose Langugae:");

        HBox languageBox = new HBox();
        /*
        Utworzenie przycisku, ustalenie preferowanego wymiaru a nastepnie dodanie event handlera który opisuje zachoawnie sie
        tego przycisku, Przycisk nastepnie jest dodawany do Vboxa a v box do Alertu (tu choose alert)
         */
        ToggleButton plButton = new ToggleButton("PL");
        plButton.setPrefSize(50,20);
        plButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                result[0] ="PL";
                chooseAlert.close();
            }
        });

        ToggleButton enButton = new ToggleButton("EN");
        enButton.setPrefSize(50,20);
        enButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                result[0] ="EN";
                chooseAlert.close();
            }
        });

        ToggleGroup languageToggleGroup = new ToggleGroup();
        languageToggleGroup.getToggles().addAll(plButton,enButton);

        languageBox.getChildren().addAll(plButton,enButton);

        chooseAlert.getDialogPane().setContent(languageBox);

        chooseAlert.showAndWait();


        return result[0];
    }

    /**
     * Okno Wyskakujące po pomyslnym zapisie w bazie danych wprowadzonych informacji
     */
    public static void acceptDialog(){
        Alert acceptAlert = new Alert(Alert.AlertType.INFORMATION);
        acceptAlert.setTitle(bundles.getString("accept.title"));
        acceptAlert.setHeaderText(bundles.getString("accept.header"));

        ImageView image = new ImageView("/icons/confirmation.png");
        acceptAlert.getDialogPane().setContent(image);

        acceptAlert.showAndWait();
    }

    /**
     * Okno Wyskakujące po pomyslnym usunieciu z bazy danych
     */
    public static void deleteDialog(){
        Alert deleteDialog = new Alert(Alert.AlertType.INFORMATION);
        deleteDialog.setTitle(bundles.getString("delete.title"));
        deleteDialog.setHeaderText(bundles.getString("delete.header"));

        ImageView image = new ImageView("/icons/confirmation.png");
        deleteDialog.getDialogPane().setContent(image);

        deleteDialog.showAndWait();
    }


    /**
     * Okno służace do zalogowania sie do aplikacji
     */

    public static void logDialog(){
        Alert logDialog = new Alert(Alert.AlertType.NONE);
        logDialog.setTitle(bundles.getString("log.title"));
        logDialog.setHeaderText(bundles.getString("log.header"));

        logDialog.getDialogPane().setContent(FxmlUtils.fxmlLoader("/fxml/Login.fxml"));

        logDialog.showAndWait();
    }

}
