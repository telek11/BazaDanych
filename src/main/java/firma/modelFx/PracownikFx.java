package firma.modelFx;

import javafx.beans.property.*;
import javafx.css.SimpleStyleableObjectProperty;

import java.time.LocalDate;

/**
 * Created by   on 2017-06-08.
 */
public class PracownikFx {
    private StringProperty id_pracownik = new SimpleStringProperty();
    private StringProperty imie = new SimpleStringProperty();
    private StringProperty nazwisko = new SimpleStringProperty();
    private StringProperty stanowisko = new SimpleStringProperty();
    private StringProperty plec = new SimpleStringProperty();
    private StringProperty pesel = new SimpleStringProperty();
    private StringProperty data_zatrudnienia = new SimpleStringProperty();
    private StringProperty data_urodzenia = new SimpleStringProperty();
    private StringProperty czy_pracuje_aktualnie =  new SimpleStringProperty();
    private StringProperty nr_konta = new SimpleStringProperty();
    private StringProperty nr_telefonu = new SimpleStringProperty();
    private StringProperty email = new SimpleStringProperty();
    private StringProperty id_centrala = new SimpleStringProperty();
    private StringProperty id_placowka_sprzedarzy = new SimpleStringProperty();
    private StringProperty id_placowka_naprawcza = new SimpleStringProperty();

    public PracownikFx() {
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

    public String getImie() {
        return imie.get();
    }

    public StringProperty imieProperty() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie.set(imie);
    }

    public String getNazwisko() {
        return nazwisko.get();
    }

    public StringProperty nazwiskoProperty() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko.set(nazwisko);
    }

    public String getStanowisko() {
        return stanowisko.get();
    }

    public StringProperty stanowiskoProperty() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko.set(stanowisko);
    }

    public String getPlec() {
        return plec.get();
    }

    public StringProperty plecProperty() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec.set(plec);
    }

    public String getPesel() {
        return pesel.get();
    }

    public StringProperty peselProperty() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel.set(pesel);
    }

    public String getData_zatrudnienia() {
        return data_zatrudnienia.get();
    }

    public StringProperty data_zatrudnieniaProperty() {
        return data_zatrudnienia;
    }

    public void setData_zatrudnienia(String data_zatrudnienia) {
        this.data_zatrudnienia.set(data_zatrudnienia);
    }

    public String getData_urodzenia() {
        return data_urodzenia.get();
    }

    public StringProperty data_urodzeniaProperty() {
        return data_urodzenia;
    }

    public void setData_urodzenia(String data_urodzenia) {
        this.data_urodzenia.set(data_urodzenia);
    }

    public String getCzy_pracuje_aktualnie() {
        return czy_pracuje_aktualnie.get();
    }

    public StringProperty czy_pracuje_aktualnieProperty() {
        return czy_pracuje_aktualnie;
    }

    public void setCzy_pracuje_aktualnie(String czy_pracuje_aktualnie) {
        this.czy_pracuje_aktualnie.set(czy_pracuje_aktualnie);
    }

    public String getNr_konta() {
        return nr_konta.get();
    }

    public StringProperty nr_kontaProperty() {
        return nr_konta;
    }

    public void setNr_konta(String nr_konta) {
        this.nr_konta.set(nr_konta);
    }

    public String getNr_telefonu() {
        return nr_telefonu.get();
    }

    public StringProperty nr_telefonuProperty() {
        return nr_telefonu;
    }

    public void setNr_telefonu(String nr_telefonu) {
        this.nr_telefonu.set(nr_telefonu);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
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

    public String getId_placowka_sprzedarzy() {
        return id_placowka_sprzedarzy.get();
    }

    public StringProperty id_placowka_sprzedarzyProperty() {
        return id_placowka_sprzedarzy;
    }

    public void setId_placowka_sprzedarzy(String id_placowka_sprzedarzy) {
        this.id_placowka_sprzedarzy.set(id_placowka_sprzedarzy);
    }

    public String getId_placowka_naprawcza() {
        return id_placowka_naprawcza.get();
    }

    public StringProperty id_placowka_naprawczaProperty() {
        return id_placowka_naprawcza;
    }

    public void setId_placowka_naprawcza(String id_placowka_naprawcza) {
        this.id_placowka_naprawcza.set(id_placowka_naprawcza);
    }

    @Override
    public String toString() {
        return "PracownikFx{" +
                "id_pracownik=" + id_pracownik +
                ", imie=" + imie +
                ", nazwisko=" + nazwisko +
                ", stanowisko=" + stanowisko +
                ", plec=" + plec +
                ", pesel=" + pesel +
                ", data_zatrudnienia=" + data_zatrudnienia +
                ", data_urodzenia=" + data_urodzenia +
                ", czy_pracuje_aktualnie=" + czy_pracuje_aktualnie +
                ", nr_konta=" + nr_konta +
                ", nr_telefonu=" + nr_telefonu +
                ", email=" + email +
                ", id_centrala=" + id_centrala +
                ", id_placowka_sprzedarzy=" + id_placowka_sprzedarzy +
                ", id_placowka_naprawcza=" + id_placowka_naprawcza +
                '}';
    }
}
