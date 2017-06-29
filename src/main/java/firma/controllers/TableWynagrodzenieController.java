package firma.controllers;

import firma.Main;
import firma.database.models.Wynagrodzenie;
import firma.modelFx.WynagrodzenieFx;
import firma.modelFx.WynagrodzenieModel;
import firma.utils.DialogsUnits;
import firma.utils.FxmlUtils;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;

/**
 * Created by Matball on 2017-06-11.
 */
public class TableWynagrodzenieController {


    @FXML
    private Button deleteWynagrodzenieButton;
    @FXML
    private TableView<WynagrodzenieFx> wynagrodzenieTableViev;
    @FXML
    private TableColumn<WynagrodzenieFx, String> id_wynagrodzenieColumn;
    @FXML
    private TableColumn<WynagrodzenieFx, String> data_wyplatyColumn;
    @FXML
    private TableColumn<WynagrodzenieFx, String>kwota_bazowaColumn;
    @FXML
    private TableColumn<WynagrodzenieFx, String> przelicznik_etatuColumn;
    @FXML
    private TableColumn<WynagrodzenieFx, String> przelicznik_stanowiskaColumn;
    @FXML
    private TableColumn<WynagrodzenieFx, String> premiaColumn;
    @FXML
    private TableColumn<WynagrodzenieFx, String> id_pracownikColumn;


    private WynagrodzenieModel wynagrodzenieModel;

    public void initialize(){
        this.wynagrodzenieModel = new WynagrodzenieModel();
        this.wynagrodzenieModel.init();
        /**
         * Nizęj obsługa tabeli w k której ustawiamy observable list całej tabeli oraz wypisujemy każdą wartośc do odpowiedniej
         * kolumny tabeli za pomocą lambdy. Korzystamy tu z klasy  fx która będzie wysietlana w tabeli.
         */
        this.wynagrodzenieTableViev.setItems(this.wynagrodzenieModel.getWynagrodzenieFxObservableList());

        this.id_wynagrodzenieColumn.setCellValueFactory(cellData -> cellData.getValue().id_wynagrodzenieProperty());
        this.data_wyplatyColumn.setCellValueFactory(cellData -> cellData.getValue().data_wyplatyProperty());
        this.kwota_bazowaColumn.setCellValueFactory(cellData -> cellData.getValue().kwota_bazowaProperty());
        this.przelicznik_etatuColumn.setCellValueFactory(cellData -> cellData.getValue().przelicznik_etatuProperty());
        this.przelicznik_stanowiskaColumn.setCellValueFactory(cellData -> cellData.getValue().przelicznik_etatuProperty());
        this.premiaColumn.setCellValueFactory(cellData -> cellData.getValue().premiaProperty());
        this.id_pracownikColumn.setCellValueFactory(cellData -> cellData.getValue().id_pracownikProperty());

      //  this.id_wynagrodzenieColumn.setCellFactory(TextFieldTableCell.forTableColumn()); // Zakomentowane zeby nie umożliwiac edycje pola id
       this.data_wyplatyColumn.setCellFactory(TextFieldTableCell.forTableColumn());
       this.kwota_bazowaColumn.setCellFactory(TextFieldTableCell.forTableColumn());
       this.przelicznik_etatuColumn.setCellFactory(TextFieldTableCell.forTableColumn());
       this.przelicznik_stanowiskaColumn.setCellFactory(TextFieldTableCell.forTableColumn());
       this.premiaColumn.setCellFactory(TextFieldTableCell.forTableColumn());
       this.id_pracownikColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    }


    /**
     * metoda ibsługujaca przycisk usuwania wynagrodzenia
     */
    @FXML
    public void deleteWynagrodzenieButtonOnAction() {
        if (LoginController.uprawnieniaObecnieZalogowanego.equals("Administrator")) {
        wynagrodzenieModel.deleteWynagrodzenieFromDataBase(wynagrodzenieTableViev.getSelectionModel().getSelectedItem().getId_wynagrodzenie());
        } else DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("Error.access.deny"));
    }

    /**
     * metody wywoływane w chwili naciśniecia enter przy edycji komórki w tabeli
     */
    public void onEditComitId_wynagrodzenie(TableColumn.CellEditEvent<WynagrodzenieFx, Number> wynagrodzenieFxNumberCellEditEvent) {
    } //Metoda która wywołuje sie przy edycji pola id którego ni bedziemy edytowac

    public void onEditComitData_wyplaty(TableColumn.CellEditEvent<WynagrodzenieFx, String> wynagrodzenieFxStringCellEditEvent) {
        if (LoginController.uprawnieniaObecnieZalogowanego.equals("Administrator")) {
        System.out.println("table column :"+wynagrodzenieFxStringCellEditEvent.getTableColumn().getId());
        wynagrodzenieModel.updateWynagrodzenieInDataBase(wynagrodzenieFxStringCellEditEvent.getNewValue(),wynagrodzenieFxStringCellEditEvent.getRowValue().getId_wynagrodzenie(),wynagrodzenieFxStringCellEditEvent.getTableColumn().getId());
        } else DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("Error.access.deny"));
    }

    public void onEditComitkwota_bazowa(TableColumn.CellEditEvent<WynagrodzenieFx, String> wynagrodzenieFxNumberCellEditEvent) {
        if (LoginController.uprawnieniaObecnieZalogowanego.equals("Administrator")) {
            wynagrodzenieModel.updateWynagrodzenieInDataBase(wynagrodzenieFxNumberCellEditEvent.getNewValue(),wynagrodzenieFxNumberCellEditEvent.getRowValue().getId_wynagrodzenie(),wynagrodzenieFxNumberCellEditEvent.getTableColumn().getId());
        } else DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("Error.access.deny"));
    }

    public void onEditComitPrzelicznik_etatu(TableColumn.CellEditEvent<WynagrodzenieFx, String> wynagrodzenieFxNumberCellEditEvent) {
        if (LoginController.uprawnieniaObecnieZalogowanego.equals("Administrator")) {
            wynagrodzenieModel.updateWynagrodzenieInDataBase(wynagrodzenieFxNumberCellEditEvent.getNewValue(),wynagrodzenieFxNumberCellEditEvent.getRowValue().getId_wynagrodzenie(),wynagrodzenieFxNumberCellEditEvent.getTableColumn().getId());
        } else DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("Error.access.deny"));
    }

    public void onEditComitPrzelicznik_stanowiska(TableColumn.CellEditEvent<WynagrodzenieFx, String> wynagrodzenieFxNumberCellEditEvent) {
        if (LoginController.uprawnieniaObecnieZalogowanego.equals("Administrator")) {
            wynagrodzenieModel.updateWynagrodzenieInDataBase(wynagrodzenieFxNumberCellEditEvent.getNewValue(),wynagrodzenieFxNumberCellEditEvent.getRowValue().getId_wynagrodzenie(),wynagrodzenieFxNumberCellEditEvent.getTableColumn().getId());
        } else DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("Error.access.deny"));
    }

    public void onEditComitPremia(TableColumn.CellEditEvent<WynagrodzenieFx, String> wynagrodzenieFxNumberCellEditEvent) {
        if (LoginController.uprawnieniaObecnieZalogowanego.equals("Administrator")) {
            wynagrodzenieModel.updateWynagrodzenieInDataBase(wynagrodzenieFxNumberCellEditEvent.getNewValue(),wynagrodzenieFxNumberCellEditEvent.getRowValue().getId_wynagrodzenie(),wynagrodzenieFxNumberCellEditEvent.getTableColumn().getId());
        } else DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("Error.access.deny"));
    }

    public void onEditComitId_pracownik(TableColumn.CellEditEvent<WynagrodzenieFx, String> wynagrodzenieFxNumberCellEditEvent) {
        if (LoginController.uprawnieniaObecnieZalogowanego.equals("Administrator")) {
            wynagrodzenieModel.updateWynagrodzenieInDataBase(wynagrodzenieFxNumberCellEditEvent.getNewValue(),wynagrodzenieFxNumberCellEditEvent.getRowValue().getId_wynagrodzenie(),wynagrodzenieFxNumberCellEditEvent.getTableColumn().getId());
        } else DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("Error.access.deny"));
    }


}
