package logic;

import korisnik.DBBroker;

public class Kontroler {
    private DBBroker dbbr;

    public Kontroler () {
        dbbr = new DBBroker();
    }

    public void napraviKorisnika() throws  Exception{
        try {
            dbbr.ucitajKonekciju();
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        try{
            dbbr.ubaciKorisnika();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }finally { dbbr.raskiniKonekciju(); }
    }
}
