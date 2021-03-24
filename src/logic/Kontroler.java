package logic;

import dbbroker.DBBroker;
import korisnik.Korisnik;


public class Kontroler {
    private DBBroker dbbr;

    private static Kontroler instance;

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    private Kontroler () {
        dbbr = new DBBroker();
    }

    public void napraviKorisnika() throws  Exception{
        Korisnik korisnik = new Korisnik("Nikola", "Jovanovic", "nj@gmail.com", "064");
        try {
            dbbr.ucitajKonekciju();
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        try{
            dbbr.ubaciKorisnika(korisnik);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }finally { dbbr.raskiniKonekciju(); }
    }
}
