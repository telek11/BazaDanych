package firma;

import firma.controllers.LoginController;
import firma.utils.DialogsUnits;
import firma.utils.FxmlUtils;

import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Locale;

/**
 * Created by   on 2017-06-07.
 */
public class Main extends Application{

    public static final String BORDER_PANEL_MAIN_FXML = "/fxml/BorderPanelMain.fxml";

    public static void main(String[] args) {

        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Locale.setDefault(new Locale(DialogsUnits.languageDialog())); //Wywołanie okna dilogowego w którym następuje wybór języka a następnie załadowanie odpowiedniego resource bundles
        DialogsUnits.logDialog();

        Pane borderPane = FxmlUtils.fxmlLoader(BORDER_PANEL_MAIN_FXML);

        primaryStage.setScene(new Scene(borderPane));
        primaryStage.setTitle(FxmlUtils.getResourceBundle().getString("title.application")+"   "+FxmlUtils.getResourceBundle().getString("title.loged.by")+ LoginController.uprawnieniaObecnieZalogowanego);
        primaryStage.show();

    }
}
