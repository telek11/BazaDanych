package firma.controllers;

import firma.modelFx.UmowaFx;
import firma.modelFx.UmowaModel;
import firma.modelFx.WynagrodzenieFx;
import firma.utils.DialogsUnits;
import firma.utils.FxmlUtils;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;

/**
 * Created by Matball on 2017-06-11.
 */
public class TableUmowaController {

    @FXML
    private TableView<UmowaFx> umowaTableViev;
    @FXML
    private TableColumn<UmowaFx, String > id_umowyColumn;
    @FXML
    private TableColumn<UmowaFx, String> data_zawarciaColumn;
    @FXML
    private TableColumn<UmowaFx, String> data_koncaColumn;
    @FXML
    private TableColumn<UmowaFx, String> opisColumn;
    @FXML
    private TableColumn<UmowaFx, String> znizka_na_telefonColumn;
    @FXML
    private TableColumn<UmowaFx, String> kara_za_zerwanieColumn;
    @FXML
    private TableColumn<UmowaFx, String> opcjonalny_telefonColumn;
    @FXML
    private TableColumn<UmowaFx, String> id_centralaColumn;
    @FXML
    private TableColumn<UmowaFx, String> id_pracownikColumn;
    @FXML
    private TableColumn<UmowaFx, String> id_klientaColumn;

    private UmowaModel umowaModel;

    public void initialize(){
        this.umowaModel = new UmowaModel();
        this.umowaModel.init();
        /**
         * Nizęj obsługa tabeli w k której ustawiamy observable list całej tabeli oraz wypisujemy każdą wartośc do odpowiedniej
         * kolumny tabeli za pomocą lambdy. Korzystamy tu z klasy  fx która będzie wysietlana w tabeli.
         */
        this.umowaTableViev.setItems(this.umowaModel.getUmowaFxObservableList());

        this.id_umowyColumn.setCellValueFactory(cellData -> cellData.getValue().id_umowyProperty());
        this.data_zawarciaColumn.setCellValueFactory(cellData -> cellData.getValue().data_zawarciaProperty());
        this.data_koncaColumn.setCellValueFactory(cellData -> cellData.getValue().data_koncaProperty());
        this.opisColumn.setCellValueFactory(cellData -> cellData.getValue().opisProperty());
        this.znizka_na_telefonColumn.setCellValueFactory(cellData -> cellData.getValue().znizka_na_telefonProperty());
        this.kara_za_zerwanieColumn.setCellValueFactory(cellData -> cellData.getValue().kara_za_zerwanieProperty());
        this.opcjonalny_telefonColumn.setCellValueFactory(cellData -> cellData.getValue().opcjonalny_telefonProperty());
        this.id_centralaColumn.setCellValueFactory(cellData -> cellData.getValue().id_centralaProperty());
        this.id_pracownikColumn.setCellValueFactory(cellData -> cellData.getValue().id_pracownikProperty());
        this.id_klientaColumn.setCellValueFactory(cellData -> cellData.getValue().id_klientaProperty());

        this.data_zawarciaColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.data_koncaColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.opisColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.znizka_na_telefonColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.kara_za_zerwanieColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.opcjonalny_telefonColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.id_centralaColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.id_pracownikColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.id_klientaColumn.setCellFactory(TextFieldTableCell.forTableColumn());

    }


    @FXML
    void deleteUmowaButtonOnAction() {
        if (LoginController.uprawnieniaObecnieZalogowanego.equals("Administrator") || LoginController.uprawnieniaObecnieZalogowanego.equals("Pracownik")) {
        umowaModel.deleteUmowaFromDataBase(umowaTableViev.getSelectionModel().getSelectedItem().getId_umowy());
        System.out.println("Z tabeli "+umowaTableViev.getSelectionModel().getSelectedItem().getId_umowy());
        } else DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("Error.access.deny"));
    }


    /**
     * metody wywoływane w chwili naciśniecia enter przy edycji komórki w tabeli
     */
    @FXML
    void onEditCommitId_umowy() {

    }

    @FXML
    void onEditCommitData_konca(TableColumn.CellEditEvent<UmowaFx, String> umowaFxStringCellEditEvent) {
        if (LoginController.uprawnieniaObecnieZalogowanego.equals("Administrator") || LoginController.uprawnieniaObecnieZalogowanego.equals("Pracownik")) {
        System.out.println("table column :"+umowaFxStringCellEditEvent.getTableColumn().getId());
        umowaModel.updateUmowaInDataBase(umowaFxStringCellEditEvent.getNewValue(),umowaFxStringCellEditEvent.getRowValue().getId_umowy(),umowaFxStringCellEditEvent.getTableColumn().getId());
        } else DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("Error.access.deny"));
    }

    @FXML
    void onEditCommitData_zawarcia(TableColumn.CellEditEvent<UmowaFx, String> umowaFxStringCellEditEvent) {
        if (LoginController.uprawnieniaObecnieZalogowanego.equals("Administrator") || LoginController.uprawnieniaObecnieZalogowanego.equals("Pracownik")) {
        umowaModel.updateUmowaInDataBase(umowaFxStringCellEditEvent.getNewValue(),umowaFxStringCellEditEvent.getRowValue().getId_umowy(),umowaFxStringCellEditEvent.getTableColumn().getId());
        } else DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("Error.access.deny"));
    }

    @FXML
    void onEditCommitId_centrala(TableColumn.CellEditEvent<UmowaFx, String> umowaFxStringCellEditEvent) {
        if (LoginController.uprawnieniaObecnieZalogowanego.equals("Administrator") || LoginController.uprawnieniaObecnieZalogowanego.equals("Pracownik")) {
            umowaModel.updateUmowaInDataBase(umowaFxStringCellEditEvent.getNewValue(),umowaFxStringCellEditEvent.getRowValue().getId_umowy(),umowaFxStringCellEditEvent.getTableColumn().getId());
        } else DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("Error.access.deny"));
    }

    @FXML
    void onEditCommitId_klienta(TableColumn.CellEditEvent<UmowaFx, String> umowaFxStringCellEditEvent) {
        if (LoginController.uprawnieniaObecnieZalogowanego.equals("Administrator") || LoginController.uprawnieniaObecnieZalogowanego.equals("Pracownik")) {
        umowaModel.updateUmowaInDataBase(umowaFxStringCellEditEvent.getNewValue(),umowaFxStringCellEditEvent.getRowValue().getId_umowy(),umowaFxStringCellEditEvent.getTableColumn().getId());
        } else DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("Error.access.deny"));
    }

    @FXML
    void onEditCommitId_pracownik(TableColumn.CellEditEvent<UmowaFx, String> umowaFxStringCellEditEvent) {
        if (LoginController.uprawnieniaObecnieZalogowanego.equals("Administrator") || LoginController.uprawnieniaObecnieZalogowanego.equals("Pracownik")) {
        umowaModel.updateUmowaInDataBase(umowaFxStringCellEditEvent.getNewValue(),umowaFxStringCellEditEvent.getRowValue().getId_umowy(),umowaFxStringCellEditEvent.getTableColumn().getId());
        } else DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("Error.access.deny"));
    }



    @FXML
    void onEditCommitKara_za_zerwanie(TableColumn.CellEditEvent<UmowaFx, String> umowaFxStringCellEditEvent) {
        if (LoginController.uprawnieniaObecnieZalogowanego.equals("Administrator") || LoginController.uprawnieniaObecnieZalogowanego.equals("Pracownik")) {
        umowaModel.updateUmowaInDataBase(umowaFxStringCellEditEvent.getNewValue(),umowaFxStringCellEditEvent.getRowValue().getId_umowy(),umowaFxStringCellEditEvent.getTableColumn().getId());
        } else DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("Error.access.deny"));
    }

    @FXML
    void onEditCommitOpcjonalny_telefon(TableColumn.CellEditEvent<UmowaFx, String> umowaFxStringCellEditEvent) {
        if (LoginController.uprawnieniaObecnieZalogowanego.equals("Administrator") || LoginController.uprawnieniaObecnieZalogowanego.equals("Pracownik")) {
            umowaModel.updateUmowaInDataBase(umowaFxStringCellEditEvent.getNewValue(),umowaFxStringCellEditEvent.getRowValue().getId_umowy(),umowaFxStringCellEditEvent.getTableColumn().getId());
        } else DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("Error.access.deny"));
    }

    @FXML
    void onEditCommitOpis(TableColumn.CellEditEvent<UmowaFx, String> umowaFxStringCellEditEvent) {
        if (LoginController.uprawnieniaObecnieZalogowanego.equals("Administrator") || LoginController.uprawnieniaObecnieZalogowanego.equals("Pracownik")) {
            umowaModel.updateUmowaInDataBase(umowaFxStringCellEditEvent.getNewValue(),umowaFxStringCellEditEvent.getRowValue().getId_umowy(),umowaFxStringCellEditEvent.getTableColumn().getId());
        } else DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("Error.access.deny"));
    }

    @FXML
    void onEditCommitZnizka_na_telefon(TableColumn.CellEditEvent<UmowaFx, String> umowaFxStringCellEditEvent) {
        if (LoginController.uprawnieniaObecnieZalogowanego.equals("Administrator") || LoginController.uprawnieniaObecnieZalogowanego.equals("Pracownik")) {
            umowaModel.updateUmowaInDataBase(umowaFxStringCellEditEvent.getNewValue(),umowaFxStringCellEditEvent.getRowValue().getId_umowy(),umowaFxStringCellEditEvent.getTableColumn().getId());
        } else DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("Error.access.deny"));
    }

}
