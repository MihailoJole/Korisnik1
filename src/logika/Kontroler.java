package logika;

import baza.DBBroker;
import baza.UnesiKorBaza;
import korisnik.Korisnik;


public class Kontroler {
//    private DBBroker dbbr;
    private UnesiKorBaza u;

    private static Kontroler instance;

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

//    private Kontroler () {
//        dbbr = new DBBroker();
//    }

    public void napraviKorisnika() throws  Exception{
        u = new UnesiKorBaza();
        Korisnik k = u.unesiPodatkeKor();
//        Korisnik korisnik = new Korisnik("Nemanja", "Jovanovic", "nj@gmail.com", "064");
        try {
            DBBroker.getInstance().ucitajKonekciju();
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        try{
            u.ubaciKorisnika(k);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }finally { DBBroker.getInstance().raskiniKonekciju(); }
    }
}
