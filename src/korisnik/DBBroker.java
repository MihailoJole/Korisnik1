package korisnik;
import java.sql.*;

public class DBBroker {
    private Connection connection;

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

    public void ubaciKorisnika (){
        String ime= "Jovan";
        String prezime= "Jolovic";
        String email= "mj@gmail.com";
        String telefon = "064";



        String upit = "INSERT INTO KORISNIK(IME, PREZIME, EMAIL, TELEFON) VALUES ('"+ime+"','"+prezime+"','"+email+"', '"+telefon+"')";
        try {
           Statement statement = connection.createStatement();
           statement.executeUpdate(upit);
           statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}

