package firma.modelFx;

import firma.utils.DialogsUnits;
import firma.utils.FxmlUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matball on 2017-06-10.
 */
public class UmowaModel {

    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:";
    private static final String USER = "SYSTEM";
    private static final String PASS = "oracle";

    private ObservableList<UmowaFx> umowaFxObservableList = FXCollections.observableArrayList();


    /**
     * Metoda w której wczytujemy pracowników z bazy danych i umieszczamy ich w liscie, a tą liste przekazujemy do
     * observable list który jest zbindowany z tabelą w TableEmployee
     */
    public void init(){
        /**
         *  odczytanie danych o wynagrodzeniu i przekazanie ich do listy a tę liste do tabeli
         */
        List<UmowaFx> umowaFxList=new ArrayList<UmowaFx>();
        this.umowaFxObservableList.clear();
        /**
         * Metoda w której wczytujemy pracowników z bazy danych i umieszczamy ich w liscie, a tą liste przekazujemy do
         * observable list który jest zbindowany z tabelą w TableEmployee
         */
        try {
            Connection connection = null;
            String sql = "Select * from umowa";
            System.out.println(sql);

            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:", "SYSTEM", "oracle");
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();


            while (rs.next()) {
                UmowaFx umowaFxTmp = new UmowaFx();
                umowaFxTmp.setId_umowy(rs.getString("id_umowy"));
                umowaFxTmp.setData_zawarcia(rs.getString("data_zawarcia"));
                umowaFxTmp.setData_konca(rs.getString("data_konca"));
                umowaFxTmp.setOpis(rs.getString("opis"));
                umowaFxTmp.setZnizka_na_telefon(rs.getString("znizka_na_telefon"));
                umowaFxTmp.setKara_za_zerwanie(rs.getString("kara_za_zerwanie"));

                umowaFxTmp.setOpcjonalny_telefon(rs.getString("opcojnalny_telefon"));//jak nie dziala to sprobuj opcojnalny_telefon
                umowaFxTmp.setId_centrala(rs.getString("id_centrala"));
                umowaFxTmp.setId_pracownik(rs.getString("id_pracownik"));
                umowaFxTmp.setId_klienta(rs.getString("id_klienta"));

                umowaFxList.add(umowaFxTmp);
            }



        }   catch (SQLException e){
            System.out.println("Connection to DataBase failed ! Check output consloe");
            System.out.println("kod błedu : "+ e.getErrorCode());
            if(e.getErrorCode()== 936) DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("error.message.missing"));
            else if(e.getErrorCode()== 1861) DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("error.message.wrongString"));
            else if(e.getErrorCode()== 984) DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("error.messageStringZamiastInt"));
            else if(e.getErrorCode()== 2291) DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("error.messageWrongId"));
            else if(e.getErrorCode()== 1426) DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("error.message.numericOverflow"));
            else DialogsUnits.errorDialog(e.getMessage());
        }


        //Przekazanie listy do listy obserwowalniej powiazanej z tabela
        this.umowaFxObservableList.addAll(umowaFxList);
    }

    public void saveUmowaInDateBase(String data_zawarcia_umowa,String data_konca_umowa,String opis_umowa,String znizka_na_telefon
            ,String kara_za_zerwanie_umowa,String opcjonalny_telefon_komorka,String id_centrala_umowa,String id_pracownik,String id_klienta){

        int numberOfRecord=0;
        /**
         * Niżej blok try catch w kótrym jest wysłane polecenie select count(*) from wynagrodzenie które zwraca aktualna liczbę krotek
         * w relacji po to by móc dodać kolejną krotkę o odpowiednim id
         */
        try {
            Connection connection = null;
            String sql= "Select * from umowa";
            System.out.println(sql);

            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:", "SYSTEM", "oracle");
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();

            // Pętla która przechodzi przez wszystkie krotki relacji i wyszukuje najwieksza wartosc w polu id a nastepnie zapisuje ja w numberofrecord
            while (rs.next())
            {
                System.out.println(rs.getInt(1));
                if (rs.getInt(1)>numberOfRecord)
                    numberOfRecord = rs.getInt(1);
            }
        }
        catch (SQLException e){
            System.out.println("Connection to DataBase failed ! Check output consloe");
            System.out.println("kod błedu : "+ e.getErrorCode());
            if(e.getErrorCode()== 936) DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("error.message.missing"));
            else if(e.getErrorCode()== 1861) DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("error.message.wrongString"));
            else if(e.getErrorCode()== 984) DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("error.messageStringZamiastInt"));
            else if(e.getErrorCode()== 2291) DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("error.messageWrongId"));
            else if(e.getErrorCode()== 1426) DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("error.message.numericOverflow"));
            else DialogsUnits.errorDialog(e.getMessage());
        }
        System.out.println("liczba rekordów: "+numberOfRecord);

        /**
         * niżej blok try catch w którym następuje wysłanie polecenia insert do bazy danych w kórym jest wstawiany rekord którego pola są wczytywane
         * z odpowiednich textField w AddWynagrodzenie.fxml pole id_wynagrodzenie jest ustawiane automatycznie poprzez wcześniejsze zapytanie do bazy
         * danych (patrz wyżej) i zczytanie aktualnej liczby rekordów a następnie dodanie rekordu o id o jeden większym
         */
        try{


            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:", "SYSTEM", "oracle");
            Statement stmt = conn.createStatement();

            String sql;
            sql= "insert into umowa values ("+(numberOfRecord+1)+",'"+data_zawarcia_umowa+"','" +data_konca_umowa+"','"+opis_umowa+"',"+znizka_na_telefon
                    +","+kara_za_zerwanie_umowa+","+opcjonalny_telefon_komorka+","+id_centrala_umowa+","+id_pracownik+","+id_klienta+")";


            System.out.println(sql);

            stmt.executeUpdate(sql);

            stmt.close();
            conn.close();
            DialogsUnits.acceptDialog();

        }   catch (SQLException e){
            System.out.println("Connection to DataBase failed ! Check output consloe");
            System.out.println("kod błedu : "+ e.getErrorCode());
            if(e.getErrorCode()== 936) DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("error.message.missing"));
            else if(e.getErrorCode()== 1861) DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("error.message.wrongString"));
            else if(e.getErrorCode()== 984) DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("error.messageStringZamiastInt"));
            else if(e.getErrorCode()== 2291) DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("error.messageWrongId"));
            else if(e.getErrorCode()== 1426) DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("error.message.numericOverflow"));
            else DialogsUnits.errorDialog(e.getMessage());
        }
    }

    /**
     * Metoda która uaktualnia wpis do bazy danych
     */
    public void updateUmowaInDataBase (String nowaWartosć, String nrWiersza, String idKolumny){
        try {
            String atrybut=null;
            if (idKolumny.equals("data_zawarciaColumn")) atrybut="data_zawarcia";
            if (idKolumny.equals("data_koncaColumn")) atrybut="data_konca" ;
            if (idKolumny.equals("opisColumn")) atrybut="opis" ;
            if (idKolumny.equals("znizka_na_telefonColumn")) atrybut="znizka_na_telefon" ;
            if (idKolumny.equals("kara_za_zerwanieColumn")) atrybut="kara_za_zerwanie" ;
            if (idKolumny.equals("opcjonalny_telefonColumn")) atrybut= "opcojnalny_telefon" ;
            if (idKolumny.equals("id_centralaColumn")) atrybut= "id_centrala" ;
            if (idKolumny.equals("id_pracownikColumn")) atrybut= "id_pracownik" ;
            if (idKolumny.equals("id_klientaColumn")) atrybut= "id_klienta" ;

            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:", "SYSTEM", "oracle");
            Statement stmt = conn.createStatement();

            String sql;
            sql = "UPDATE umowa set "+atrybut+"='"+nowaWartosć+"' WHERE id_umowy="+nrWiersza;
            System.out.println(sql);

            stmt.executeUpdate(sql);

            stmt.close();
            conn.close();
            DialogsUnits.acceptDialog();
        }
        catch (SQLException e){
            System.out.println("Connection to DataBase failed ! Check output consloe");
            System.out.println("kod błedu : "+ e.getErrorCode());
            if(e.getErrorCode()== 936) DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("error.message.missing"));
            else if(e.getErrorCode()== 1861) DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("error.message.wrongString"));
            else if(e.getErrorCode()== 984) DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("error.messageStringZamiastInt"));
            else if(e.getErrorCode()== 2291) DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("error.messageWrongId"));
            else if(e.getErrorCode()== 1426) DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("error.message.numericOverflow"));
            else DialogsUnits.errorDialog(e.getMessage());
        }

    }

    /**
     * Metoda usuwajca rekord wynagrodzenia z bazy danych
     */
    public void deleteUmowaFromDataBase (String idUmowa){

        try {

            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:", "SYSTEM", "oracle");
            Statement stmt = conn.createStatement();

            String sql;
            sql = "DELETE FROM umowa Where id_umowy="+idUmowa;
            System.out.println(sql);

            stmt.executeUpdate(sql);

            stmt.close();
            conn.close();
            DialogsUnits.deleteDialog();
        }
        catch (SQLException e){
            System.out.println("Connection to DataBase failed ! Check output consloe");
            System.out.println("kod błedu : "+ e.getErrorCode());
            if(e.getErrorCode()== 936) DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("error.message.missing"));
            else if(e.getErrorCode()== 1861) DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("error.message.wrongString"));
            else if(e.getErrorCode()== 984) DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("error.messageStringZamiastInt"));
            else if(e.getErrorCode()== 2291) DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("error.messageWrongId"));
            else if(e.getErrorCode()== 1426) DialogsUnits.errorDialog(FxmlUtils.getResourceBundle().getString("error.message.numericOverflow"));
            else DialogsUnits.errorDialog(e.getMessage());
        }
        this.init();

    }

    public ObservableList<UmowaFx> getUmowaFxObservableList() {
        return umowaFxObservableList;
    }

    public void setUmowaFxObservableList(ObservableList<UmowaFx> umowaFxObservableList) {
        this.umowaFxObservableList = umowaFxObservableList;
    }
}
