package firma.controllers;

import firma.modelFx.PracownikFx;
import firma.modelFx.PracownikModel;
import firma.modelFx.WynagrodzenieFx;
import firma.utils.DialogsUnits;
import firma.utils.FxmlUtils;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;

/**
 * Created by   on 2017-06-10.
 */
public class TableEmployeeController {
    @FXML
    private TableView<PracownikFx> employeeTableViev;
    @FXML
    private TableColumn<PracownikFx, String> id_pracownikColumn;
    @FXML
    private TableColumn<PracownikFx, String> imieColumn;
    @FXML
    private TableColumn<PracownikFx, String> nazwiskoColumn;
    @FXML
    private TableColumn<PracownikFx, String> stanowiskoColumn;
    @FXML
    private TableColumn<PracownikFx, String> plecColumn;
    @FXML
    private TableColumn<PracownikFx, String> peselColumn;
    @FXML
    private TableColumn<PracownikFx, String> data_zatrudnieniaColumn;
    @FXML
    private TableColumn<PracownikFx, String> data_urodzeniaColumn;
    @FXML
    private TableColumn<PracownikFx, String> czy_pracuje_aktualnieColumn;
    @FXML
    private TableColumn<PracownikFx, String> nr_kataColumn;
    @FXML
    private TableColumn<PracownikFx, String> nr_telefonuColumn;
    @FXML
    private TableColumn<PracownikFx, String> emialColumn;
    @FXML
    private TableColumn<PracownikFx, String> id_centralaColumn;
    @FXML
    private TableColumn<PracownikFx, String> id_placowka_sprzedarzyColumn;
    @FXML
    private TableColumn<PracownikFx, String> id_placowka_naprawczaColumn;

    private PracownikModel pracownikModel;

    public void initialize(){
        this.pracownikModel = new PracownikModel();
        this.pracownikModel.init(); // metoda z klasy pracownik model która inicjlizuje dane w tabeli pobrane z bazy danych
        /**
         * Nizęj obsługa tabeli w k której ustawiamy observable list całej tabeli oraz wypisujemy każdą wartośc do odpowiedniej
         * kolumny tabeli za pomocą lambdy. Korzystamy tu z klasy pracownik fx która będzie wysietlana w tabeli.
         */
        this.employeeTableViev.setItems(this.pracownikModel.getPracownikFxObservableList());
        this.id_pracownikColumn.setCellValueFactory(cellData -> cellData.getValue().id_pracownikProperty());
        this.imieColumn.setCellValueFactory(cellData -> cellData.getValue().imieProperty());
        this.nazwiskoColumn.setCellValueFactory(cellData -> cellData.getValue().nazwiskoProperty());
        this.stanowiskoColumn.setCellValueFactory(cellData -> cellData.getValue().stanowiskoProperty());
        this.plecColumn.setCellValueFactory(cellData -> cellData.getValue().plecProperty());
        this.peselColumn.setCellValueFactory(cellData -> cellData.getValue().peselProperty());
        this.data_zatrudnieniaColumn.setCellValueFactory(cellData -> cellData.getValue().data_zatrudnieniaProperty());
        this.data_urodzeniaColumn.setCellValueFactory(cellData -> cellData.getValue().data_urodzeniaProperty());
        this.czy_pracuje_aktualnieColumn.setCellValueFactory(cellData -> cellData.getValue().czy_pracuje_aktualnieProperty());
        this.nr_kataColumn.setCellValueFactory(cellData -> cellData.getValue().nr_kontaProperty());
        this.nr_telefonuColumn.setCellValueFactory(cellData -> cellData.getValue().nr_telefonuProperty());
        this.emialColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        this.id_centralaColumn.setCellValueFactory(cellData -> cellData.getValue().id_centralaProperty());
        this.id_placowka_sprzedarzyColumn.setCellValueFactory(cellData -> cellData.getValue().id_placowka_sprzedarzyProperty());
        this.id_placowka_naprawczaColumn.setCellValueFactory(cellData -> cellData.getValue().id_placowka_naprawczaProperty());

        //  this.id_wynagrodzenieColumn.setCellFactory(TextFieldTableCell.forTableColumn()); // Zakomentowane zeby nie umożliwiac edycje pola id

        //this.id_pracownikColumn.setCellFactory(TextFieldTableCell.forTableColumn());// Zakomentowane zeby nie umożliwiac edycje pola id
        this.imieColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.nazwiskoColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.stanowiskoColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.plecColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.peselColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.data_zatrudnieniaColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.data_urodzeniaColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.czy_pracuje_aktualnieColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.nr_kataColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.nr_telefonuColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.emialColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.id_centralaColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.id_placowka_sprzedarzyColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.id_placowka_naprawczaColumn.setCellFactory(TextFieldTableCell.forTableColumn());

    }

    /**
     * metoda ibsługujaca przycisk usuwania pracownika
     */
    @FXML
    void deletePracownikButtonOnAction() {
        if (LoginController.uprawnieniaObecnieZalogowanego.equals("Administrator")) {
            pracownikModel.deletePracownikFromDataBase(employeeTableViev.getSelectionModel().getSelectedItem().getId_pracownik());
        } else DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("Error.access.deny"));

    }

    /**
     * metody wywoływane w chwili naciśniecia enter przy edycji komórki w tabeli
     */
    @FXML
    void onEditCommitImie(TableColumn.CellEditEvent<PracownikFx, String> pracownikFxStringCellEditEvent) {
        if (LoginController.uprawnieniaObecnieZalogowanego.equals("Administrator")) {
        System.out.println("table column :"+pracownikFxStringCellEditEvent.getTableColumn().getId());
        pracownikModel.updatePracownikInDateBase(pracownikFxStringCellEditEvent.getNewValue(),pracownikFxStringCellEditEvent.getRowValue().getId_pracownik(),pracownikFxStringCellEditEvent.getTableColumn().getId());
        } else DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("Error.access.deny"));
    }

    @FXML
    void onEditCommitNazwisko(TableColumn.CellEditEvent<PracownikFx, String> pracownikFxStringCellEditEvent) {
        if (LoginController.uprawnieniaObecnieZalogowanego.equals("Administrator")) {
            pracownikModel.updatePracownikInDateBase(pracownikFxStringCellEditEvent.getNewValue(),pracownikFxStringCellEditEvent.getRowValue().getId_pracownik(),pracownikFxStringCellEditEvent.getTableColumn().getId());
        } else DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("Error.access.deny"));
    }

    @FXML
    void onEditCommitCzy_pracuje_aktualnie(TableColumn.CellEditEvent<PracownikFx, String> pracownikFxStringCellEditEvent) {
        if (LoginController.uprawnieniaObecnieZalogowanego.equals("Administrator")) {
            pracownikModel.updatePracownikInDateBase(pracownikFxStringCellEditEvent.getNewValue(),pracownikFxStringCellEditEvent.getRowValue().getId_pracownik(),pracownikFxStringCellEditEvent.getTableColumn().getId());
        } else DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("Error.access.deny"));
    }

    @FXML
    void onEditCommitData_urodzenia(TableColumn.CellEditEvent<PracownikFx, String> pracownikFxStringCellEditEvent) {
        if (LoginController.uprawnieniaObecnieZalogowanego.equals("Administrator")) {
            pracownikModel.updatePracownikInDateBase(pracownikFxStringCellEditEvent.getNewValue(),pracownikFxStringCellEditEvent.getRowValue().getId_pracownik(),pracownikFxStringCellEditEvent.getTableColumn().getId());
        } else DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("Error.access.deny"));
    }

    @FXML
    void onEditCommitData_zatrudnienia(TableColumn.CellEditEvent<PracownikFx, String> pracownikFxStringCellEditEvent) {
        if (LoginController.uprawnieniaObecnieZalogowanego.equals("Administrator")) {
        pracownikModel.updatePracownikInDateBase(pracownikFxStringCellEditEvent.getNewValue(),pracownikFxStringCellEditEvent.getRowValue().getId_pracownik(),pracownikFxStringCellEditEvent.getTableColumn().getId());
        } else DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("Error.access.deny"));
    }

    @FXML
    void onEditCommitEmial(TableColumn.CellEditEvent<PracownikFx, String> pracownikFxStringCellEditEvent) {
        if (LoginController.uprawnieniaObecnieZalogowanego.equals("Administrator")) {
            pracownikModel.updatePracownikInDateBase(pracownikFxStringCellEditEvent.getNewValue(),pracownikFxStringCellEditEvent.getRowValue().getId_pracownik(),pracownikFxStringCellEditEvent.getTableColumn().getId());
        } else DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("Error.access.deny"));
    }

    @FXML
    void onEditCommitId_centrala(TableColumn.CellEditEvent<PracownikFx, String> pracownikFxStringCellEditEvent) {
        if (LoginController.uprawnieniaObecnieZalogowanego.equals("Administrator")) {
            pracownikModel.updatePracownikInDateBase(pracownikFxStringCellEditEvent.getNewValue(),pracownikFxStringCellEditEvent.getRowValue().getId_pracownik(),pracownikFxStringCellEditEvent.getTableColumn().getId());
        } else DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("Error.access.deny"));
    }

    @FXML
    void onEditCommitId_placowak_sprzedarzy(TableColumn.CellEditEvent<PracownikFx, String> pracownikFxStringCellEditEvent) {
        if (LoginController.uprawnieniaObecnieZalogowanego.equals("Administrator")) {
        pracownikModel.updatePracownikInDateBase(pracownikFxStringCellEditEvent.getNewValue(),pracownikFxStringCellEditEvent.getRowValue().getId_pracownik(),pracownikFxStringCellEditEvent.getTableColumn().getId());
        } else DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("Error.access.deny"));
    }

    @FXML
    void onEditCommitId_placowka_naprawcza(TableColumn.CellEditEvent<PracownikFx, String> pracownikFxStringCellEditEvent) {
        if (LoginController.uprawnieniaObecnieZalogowanego.equals("Administrator")) {
        pracownikModel.updatePracownikInDateBase(pracownikFxStringCellEditEvent.getNewValue(),pracownikFxStringCellEditEvent.getRowValue().getId_pracownik(),pracownikFxStringCellEditEvent.getTableColumn().getId());
        } else DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("Error.access.deny"));
    }

    @FXML
    void onEditCommitId_pracownik(TableColumn.CellEditEvent<PracownikFx, String> pracownikFxStringCellEditEvent) {
        if (LoginController.uprawnieniaObecnieZalogowanego.equals("Administrator")) {
        pracownikModel.updatePracownikInDateBase(pracownikFxStringCellEditEvent.getNewValue(),pracownikFxStringCellEditEvent.getRowValue().getId_pracownik(),pracownikFxStringCellEditEvent.getTableColumn().getId());
        } else DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("Error.access.deny"));
    }



    @FXML
    void onEditCommitNr_kata(TableColumn.CellEditEvent<PracownikFx, String> pracownikFxStringCellEditEvent) {
        if (LoginController.uprawnieniaObecnieZalogowanego.equals("Administrator")) {
        pracownikModel.updatePracownikInDateBase(pracownikFxStringCellEditEvent.getNewValue(),pracownikFxStringCellEditEvent.getRowValue().getId_pracownik(),pracownikFxStringCellEditEvent.getTableColumn().getId());
        } else DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("Error.access.deny"));
    }

    @FXML
    void onEditCommitNr_telefonu(TableColumn.CellEditEvent<PracownikFx, String> pracownikFxStringCellEditEvent) {
        if (LoginController.uprawnieniaObecnieZalogowanego.equals("Administrator")) {
            pracownikModel.updatePracownikInDateBase(pracownikFxStringCellEditEvent.getNewValue(),pracownikFxStringCellEditEvent.getRowValue().getId_pracownik(),pracownikFxStringCellEditEvent.getTableColumn().getId());
        } else DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("Error.access.deny"));
    }

    @FXML
    void onEditCommitPesel(TableColumn.CellEditEvent<PracownikFx, String> pracownikFxStringCellEditEvent) {
        if (LoginController.uprawnieniaObecnieZalogowanego.equals("Administrator")) {
        pracownikModel.updatePracownikInDateBase(pracownikFxStringCellEditEvent.getNewValue(),pracownikFxStringCellEditEvent.getRowValue().getId_pracownik(),pracownikFxStringCellEditEvent.getTableColumn().getId());
        } else DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("Error.access.deny"));
    }

    @FXML
    void onEditCommitPlec(TableColumn.CellEditEvent<PracownikFx, String> pracownikFxStringCellEditEvent) {
        if (LoginController.uprawnieniaObecnieZalogowanego.equals("Administrator")) {
            pracownikModel.updatePracownikInDateBase(pracownikFxStringCellEditEvent.getNewValue(),pracownikFxStringCellEditEvent.getRowValue().getId_pracownik(),pracownikFxStringCellEditEvent.getTableColumn().getId());
        } else DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("Error.access.deny"));
    }

    @FXML
    void onEditCommitStanowisko(TableColumn.CellEditEvent<PracownikFx, String> pracownikFxStringCellEditEvent) {
        if (LoginController.uprawnieniaObecnieZalogowanego.equals("Administrator")) {
        pracownikModel.updatePracownikInDateBase(pracownikFxStringCellEditEvent.getNewValue(),pracownikFxStringCellEditEvent.getRowValue().getId_pracownik(),pracownikFxStringCellEditEvent.getTableColumn().getId());
        } else DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("Error.access.deny"));
    }


}
