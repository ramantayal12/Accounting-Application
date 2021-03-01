import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class options_window {


    public static void show_options(){

        JFrame jf = new JFrame(" Customer Menu ");
        JPanel jp = new JPanel( new GridLayout(3,1));
        jf.setSize(800,800);

        JButton but1 = new JButton("Add new Customer");
        JButton but2 = new JButton("Show Existing Customers ");
        JButton but3 = new JButton("Create Bill ");

        jp.add(but1);
        jp.add(but2);
        jp.add(but3);

        but1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    add_customer();
                } catch (ClassNotFoundException | SQLException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }
        });
        but2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                show_customers();
            }
        });

        but3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generate_bill.bill_window();
            }
        });

        jf.add(jp);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


     public static void add_customer() throws ClassNotFoundException, SQLException {

         JFrame jf = new JFrame("Add new Customer ");
         JPanel p = new JPanel(new GridLayout(7,1));
         jf.setSize(800,800);

         JLabel customer_name = new JLabel("Enter Customer name ");
         JLabel opening_balance = new JLabel("Enter opening Balance ");
         JLabel user_id = new JLabel("Enter User_ID ");

         JTextField name = new JTextField();
         JTextField bal = new JTextField();
         JTextField id = new JTextField();
         JButton but1 = new JButton("Submit ");

         p.add(user_id);
         p.add(id);
         p.add(customer_name);
         p.add(name);
         p.add(opening_balance);
         p.add(bal);
         p.add(but1);

         but1.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                 try {
                     Class.forName("org.sqlite.JDBC");
                     Connection c = DriverManager.getConnection("jdbc:sqlite:customer_data");
                     Statement statement = c.createStatement();
                     statement.executeUpdate("Insert into customer_data(User_ID, Name, Balance ) values (" + (id.getText()) + ",' " + name.getText() + "' ," + bal.getText() +");" );
                     statement.close();
                     c.close();

                     String title = "Inserted Successfully";
                     mesaage_window.show_window(title,title);

                     show_options();
                 }catch(Exception ex ){

                     String text = ex.getMessage();
                     String title = "database issue ";
                     mesaage_window.show_window(title,text);
                 }
             }
         });



         jf.add(p);
         jf.setVisible(true);
         jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void show_customers(){

        JFrame jf = new JFrame("List of Customers ");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel jp1;
        jf.setSize(1000,1000);
        try {
            Class.forName("org.sqlite.JDBC");
            Connection c = DriverManager.getConnection("jdbc:sqlite:customer_data");
            Statement statement = c.createStatement();

            ResultSet rs1 = statement.executeQuery("SELECT COUNT(*) FROM customer_data");
            rs1.next();
            jp1 = new JPanel(new GridLayout(rs1.getInt(1)+1,3));

            ResultSet rs = statement.executeQuery("SELECT * FROM customer_data");

            Font font1 = new Font("Comic Sans" , Font.BOLD,25);
            JLabel lid = new JLabel("User_ID");
            lid.setFont(font1);
            JLabel le = new JLabel("Name of Customer ");
            le.setFont(font1);
            JLabel ll = new JLabel("Balance ");
            ll.setFont(font1);
            jp1.add(lid);
            jp1.add(le);
            jp1.add(ll);

            while (rs.next())
            {
                int id = rs.getInt("User_ID");
                String name = rs.getString("Name");
                int balance = rs.getInt("Balance");


                JLabel label_id = new JLabel(String.valueOf(id));
                JLabel label_name = new JLabel(String.valueOf(name));
                JLabel label_bal = new JLabel(String.valueOf(balance));

                jp1.add(label_id);
                jp1.add(label_name);
                jp1.add(label_bal);
            }
            jf.add(jp1);
            statement.close();
        } catch (ClassNotFoundException | SQLException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }


        jf.setVisible(true);

    }

}
