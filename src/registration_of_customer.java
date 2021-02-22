import java.sql.*;


public class registration_of_customer {

    static void add_customer(){

        Connection c = null;
        try{
            c = DriverManager.getConnection("jdbc:sqlite3:customer_data");
            wrong_login_window wrw = new wrong_login_window();
            String text = "DataBase Opened";
            String title = "Database";
            wrw.show_window(title,text);
        }
        catch( Exception e ){
            wrong_login_window wrw = new wrong_login_window();
            String text = e.getMessage();
            String title = "database issue ";
            wrw.show_window(title,text);
        }
    }

    public static void main(String []args){


    }
}
