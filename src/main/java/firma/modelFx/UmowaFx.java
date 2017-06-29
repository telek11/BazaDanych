package firma.modelFx;

import javafx.beans.property.*;
import javafx.css.SimpleStyleableObjectProperty;

import java.time.LocalDate;

/**
 * Created by   on 2017-06-08.
 */
public class UmowaFx {
    private StringProperty id_umowy = new SimpleStringProperty();
    private StringProperty data_zawarcia = new SimpleStringProperty();
    private StringProperty data_konca = new SimpleStringProperty();
    private StringProperty opis = new SimpleStringProperty();
    private StringProperty znizka_na_telefon = new SimpleStringProperty();
    private StringProperty kara_za_zerwanie = new SimpleStringProperty();
    private StringProperty opcjonalny_telefon = new SimpleStringProperty();
    private StringProperty id_centrala = new SimpleStringProperty();
    private StringProperty id_pracownik = new SimpleStringProperty();
    private StringProperty id_klienta = new SimpleStringProperty();

    public UmowaFx() {
    }

    public String getId_umowy() {
        return id_umowy.get();
    }

    public StringProperty id_umowyProperty() {
        return id_umowy;
    }

    public void setId_umowy(String id_umowy) {
        this.id_umowy.set(id_umowy);
    }

    public String getData_zawarcia() {
        return data_zawarcia.get();
    }

    public StringProperty data_zawarciaProperty() {
        return data_zawarcia;
    }

    public void setData_zawarcia(String data_zawarcia) {
        this.data_zawarcia.set(data_zawarcia);
    }

    public String getData_konca() {
        return data_konca.get();
    }

    public StringProperty data_koncaProperty() {
        return data_konca;
    }

    public void setData_konca(String data_konca) {
        this.data_konca.set(data_konca);
    }

    public String getOpis() {
        return opis.get();
    }

    public StringProperty opisProperty() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis.set(opis);
    }

    public String getZnizka_na_telefon() {
        return znizka_na_telefon.get();
    }

    public StringProperty znizka_na_telefonProperty() {
        return znizka_na_telefon;
    }

    public void setZnizka_na_telefon(String znizka_na_telefon) {
        this.znizka_na_telefon.set(znizka_na_telefon);
    }

    public String getKara_za_zerwanie() {
        return kara_za_zerwanie.get();
    }

    public StringProperty kara_za_zerwanieProperty() {
        return kara_za_zerwanie;
    }

    public void setKara_za_zerwanie(String kara_za_zerwanie) {
        this.kara_za_zerwanie.set(kara_za_zerwanie);
    }

    public String getOpcjonalny_telefon() {
        return opcjonalny_telefon.get();
    }

    public StringProperty opcjonalny_telefonProperty() {
        return opcjonalny_telefon;
    }

    public void setOpcjonalny_telefon(String opcjonalny_telefon) {
        this.opcjonalny_telefon.set(opcjonalny_telefon);
    }

    public String getId_centrala() {
        return id_centrala.get();
    }

    public StringProperty id_centralaProperty() {
        return id_centrala;
    }

    public void setId_centrala(String id_centrala) {
        this.id_centrala.set(id_centrala);
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

    public String getId_klienta() {
        return id_klienta.get();
    }

    public StringProperty id_klientaProperty() {
        return id_klienta;
    }

    public void setId_klienta(String id_klienta) {
        this.id_klienta.set(id_klienta);
    }

    @Override
    public String toString() {
        return "UmowaFx{" +
                "id_umowy=" + id_umowy +
                ", data_zawarcia=" + data_zawarcia +
                ", data_konca=" + data_konca +
                ", opis=" + opis +
                ", znizka_na_telefon=" + znizka_na_telefon +
                ", kara_za_zerwanie=" + kara_za_zerwanie +
                ", opcojnalny_telefon=" + opcjonalny_telefon +
                ", id_centrala=" + id_centrala +
                ", id_pracownik=" + id_pracownik +
                ", id_klienta=" + id_klienta +
                '}';
    }
}

