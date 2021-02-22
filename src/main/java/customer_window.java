import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class customer_window {

    public static void show_options(){

        JFrame jf = new JFrame(" Customer Menu ");
        jf.setSize(800,800);

        JButton but1 = new JButton("Add new Customer");
        JButton but2 = new JButton("Show Existing Customers ");

        but1.setBounds(200,100,500,50);
        jf.add(but1);

        but2.setBounds(200,150,500,50);
        jf.add(but2);

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

        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


     public static void add_customer() throws ClassNotFoundException, SQLException {

         JFrame jf = new JFrame("Add new Customer ");
         jf.setSize(800,800);

         JLabel customer_name = new JLabel("Enter Customer name ");
         JLabel opening_balance = new JLabel("Enter opening Balance ");
         JLabel user_id = new JLabel("Enter User_ID ");

         JTextField name = new JTextField();
         JTextField bal = new JTextField();
         JTextField id = new JTextField();

         JButton but1 = new JButton("Submit ");
         but1.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 try {
                     Class.forName("org.sqlite.JDBC");
                     Connection c = DriverManager.getConnection("jdbc:sqlite:customer_data");
                     Statement statement = c.createStatement();
                     ResultSet rs = statement.executeQuery("Insert into customer_data (User_ID, Name, Balance ) values (" + id + "," + name + "," + bal );
                     rs.close();
                     statement.close();
                     c.close();
                 }catch(Exception ex ){
                     wrong_login_window wrw = new wrong_login_window();
                     String text = ex.getMessage();
                     String title = "database issue ";
                     wrw.show_window(title,text);
                 }
             }
         });


         customer_name.setBounds(200,100,200,50);
         name.setBounds(200,150,200,50);
         opening_balance.setBounds(200,200,200,50);
         bal.setBounds(200,250,200,50);
         user_id.setBounds(200,300,200,50);
         id.setBounds(200,350,200,50);
         but1.setBounds(200,400,100,50);

         jf.add(customer_name);
         jf.add(name);
         jf.add(opening_balance);
         jf.add(bal);
         jf.add(user_id);
         jf.add(id);
         jf.add(but1);


         jf.setVisible(true);
         jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void show_customers(){

        JFrame jf = new JFrame("List of Customers ");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jf.setSize(1000,1000);
        try {
            Class.forName("org.sqlite.JDBC");
            Connection c = DriverManager.getConnection("jdbc:sqlite:customer_data");
            Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM customer_data");
            int i = 0;
            while (rs.next())
            {
                int id = rs.getInt("User_ID");
                String name = rs.getString("Name");
                int balance = rs.getInt("Balance");


                JLabel label_id = new JLabel(String.valueOf(id));
                JLabel label_name = new JLabel(String.valueOf(name));
                JLabel label_bal = new JLabel(String.valueOf(balance));

                label_id.setBounds( 10,(i+2)*100,100,50);
                label_name.setBounds(150,(i+2)*100,100,50);
                label_bal.setBounds(400,(i+2)*100,100,50);

                jf.add(label_id);
                jf.add(label_name);
                jf.add(label_bal);
                i += 1;
            }
            statement.close();
        } catch (ClassNotFoundException | SQLException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }

        jf.setVisible(true);

    }

}
