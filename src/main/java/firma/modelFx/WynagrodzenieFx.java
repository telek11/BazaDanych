package firma.modelFx;

import javafx.beans.property.*;
import javafx.css.SimpleStyleableObjectProperty;

import java.time.LocalDate;

/**
 * Created by   on 2017-06-08.
 */
public class WynagrodzenieFx {
    private StringProperty id_wynagrodzenie = new SimpleStringProperty();
    private StringProperty data_wyplaty = new SimpleStringProperty();
    private StringProperty kwota_bazowa = new SimpleStringProperty();
    private StringProperty przelicznik_etatu = new SimpleStringProperty();
    private StringProperty przelicznik_stanowiska = new SimpleStringProperty();
    private StringProperty premia = new SimpleStringProperty();
    private StringProperty id_pracownik = new SimpleStringProperty();

    public WynagrodzenieFx() {
    }

    public String getId_wynagrodzenie() {
        return id_wynagrodzenie.get();
    }

    public StringProperty id_wynagrodzenieProperty() {
        return id_wynagrodzenie;
    }

    public void setId_wynagrodzenie(String id_wynagrodzenie) {
        this.id_wynagrodzenie.set(id_wynagrodzenie);
    }

    public String getData_wyplaty() {
        return data_wyplaty.get();
    }

    public StringProperty data_wyplatyProperty() {
        return data_wyplaty;
    }

    public void setData_wyplaty(String data_wyplaty) {
        this.data_wyplaty.set(data_wyplaty);
    }

    public String getKwota_bazowa() {
        return kwota_bazowa.get();
    }

    public StringProperty kwota_bazowaProperty() {
        return kwota_bazowa;
    }

    public void setKwota_bazowa(String kwota_bazowa) {
        this.kwota_bazowa.set(kwota_bazowa);
    }

    public String getPrzelicznik_etatu() {
        return przelicznik_etatu.get();
    }

    public StringProperty przelicznik_etatuProperty() {
        return przelicznik_etatu;
    }

    public void setPrzelicznik_etatu(String przelicznik_etatu) {
        this.przelicznik_etatu.set(przelicznik_etatu);
    }

    public String getPrzelicznik_stanowiska() {
        return przelicznik_stanowiska.get();
    }

    public StringProperty przelicznik_stanowiskaProperty() {
        return przelicznik_stanowiska;
    }

    public void setPrzelicznik_stanowiska(String przelicznik_stanowiska) {
        this.przelicznik_stanowiska.set(przelicznik_stanowiska);
    }

    public String getPremia() {
        return premia.get();
    }

    public StringProperty premiaProperty() {
        return premia;
    }

    public void setPremia(String premia) {
        this.premia.set(premia);
    }

    public String getId_pracownik() {
        return id_pracownik.get();
    }

    public StringProperty id_pracownikProperty() {
        return id_pracownik;
    }

    public void setId_pracownik(String id_pracownik) {
        this.id_pracownik.set(id_pracownik);
    }

    @Override
    public String toString() {
        return "WynagrodzenieFx{" +
                "id_wynagrodzenie=" + id_wynagrodzenie +
                ", data_wyplaty=" + data_wyplaty +
                ", kwota_bazowa=" + kwota_bazowa +
                ", przelicznik_etatu=" + przelicznik_etatu +
                ", przelicznik_stanowiska=" + przelicznik_stanowiska +
                ", premia=" + premia +
                ", id_pracownik=" + id_pracownik +
                '}';
    }
}
