package firma.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Klasa będzie odpowiedzialana za ładowanie wszystkich FXML w naszej aplikacji
 */
public class FxmlUtils {

    private static Boolean flagaWlaczenia = new Boolean(true);
    private static Boolean flagaZalogownaia = new Boolean(true);
    /**
     * Po Pane dziedziczą wszystkie kontenery w javie FX możemy go zwracac bez wiekszych obaw
     * zawraca zaaładowany już plik FXML a jej argument to ścieżka do pliku fxml
     */
    public static Pane fxmlLoader(String fxmlPath){

        /*
        warunek w którym ograniczamy właczenieni okna dialogowego pytajacego o jezyk tylko przy pierwszym wywołaniu tego okna czyli przy
        właczeniu aplikacji
         */
        /*
        if (flagaWlaczenia){
            Locale.setDefault(new Locale(DialogsUnits.languageDialog())); //Wywołanie okna dilogowego w którym następuje wybór języka a następnie załadowanie odpowiedniego resource bundles
            flagaWlaczenia=false;
        }
        if (flagaZalogownaia){
            FXMLLoader loader= new FXMLLoader(FxmlUtils.class.getResource("/fxml/Login.fxml"));
            loader.setResources(getResourceBundle());

            try {
                return loader.load();
            } catch (Exception e) {
                DialogsUnits.errorDialog(e.getMessage());
            }

            flagaZalogownaia=false;
        }
        */

        FXMLLoader loader= new FXMLLoader(FxmlUtils.class.getResource(fxmlPath));
        loader.setResources(getResourceBundle());

        try {
            return loader.load();
        } catch (Exception e) {
            DialogsUnits.errorDialog(e.getMessage());
        }
        return null; //tymczasowe
    }

    public static ResourceBundle getResourceBundle() {
        return ResourceBundle.getBundle("bundles.messages");
    }
}