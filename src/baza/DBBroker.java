package baza;

import java.sql.*;

public class DBBroker {

    private Connection connection;

    private static DBBroker instance;

    public static DBBroker getInstance() {
        if (instance == null) {
            instance = new DBBroker();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void ucitajKonekciju() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/korisnik";
            String user = "root";
            String password = "root";
            connection = DriverManager.getConnection(url, user, password);

        }catch (Exception e){
            System.out.println(e);
            throw e;
        }
    }

    public void raskiniKonekciju() throws Exception{
        try {
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    /*public void ubaciKorisnika (Korisnik korisnik){

        String upit = "INSERT INTO KORISNIK(IME, PREZIME, EMAIL, TELEFON) VALUES ('"+korisnik.getIme()+"','"+korisnik.getPrezime()+"','"+korisnik.getEmail()+"', '"+korisnik.getTelefon()+"')";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(upit);
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }*/

}

