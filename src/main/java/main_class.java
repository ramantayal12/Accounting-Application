import java.sql.SQLException;

public class main_class {
    public static void main(String []args ) throws SQLException, ClassNotFoundException {
        login l = new login();
        l.execute_application();
        //customer_window.add_customer();
        //customer_window.show_options();
    }
}
