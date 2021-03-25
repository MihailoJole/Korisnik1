package dbbroker;

import korisnik.Korisnik;

import java.sql.SQLException;
import java.sql.Statement;

public class UnesiKorBaza {

    private static UnesiKorBaza instance;

    public static UnesiKorBaza getInstance() {
        if (instance == null) {
            instance = new UnesiKorBaza();
        }
        return instance;
    }

    public void ubaciKorisnika (Korisnik korisnik){

        String upit = "INSERT INTO KORISNIK(IME, PREZIME, EMAIL, TELEFON) VALUES ('"+korisnik.getIme()+"','"+korisnik.getPrezime()+"','"+korisnik.getEmail()+"', '"+korisnik.getTelefon()+"')";
        try {
            Statement statement = DBBroker.getInstance().getConnection().createStatement();
            statement.executeUpdate(upit);
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
