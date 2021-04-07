package baza;

import korisnik.Korisnik;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UnesiKorBaza {

    public UnesiKorBaza() {

    }

//    private static UnesiKorBaza instance;
//
//    public static UnesiKorBaza getInstance() {
//        if (instance == null) {
//            instance = new UnesiKorBaza();
//        }
//        return instance;
//    }

    public Korisnik unesiPodatkeKor(){
        Korisnik k = new Korisnik();
//        String ime;
//        String prezime;
//        String email;
//        String telefon;

        Scanner skener = new Scanner(System.in);
        System.out.println("Unesite ime korisnika:");
        k.setIme(skener.nextLine());
        System.out.println("Unesite prezime korisnika:");
        k.setPrezime(skener.nextLine());
        System.out.println("Unesite email korisnika:");
        k.setEmail(skener.nextLine());
        System.out.println("Unesite telefon korisnika:");
        k.setTelefon(skener.nextLine());

        return k;
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
