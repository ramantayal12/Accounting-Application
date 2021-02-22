import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;

public class customer_window {

    public static void show_options(){

        JFrame jf = new JFrame(" Customer Menu ");
        jf.setSize(800,800);

        JButton but1 = new JButton("Add new Customer");
        JButton but2 = new JButton("Show Existing Customers ");

        but1.setBounds(200,100,200,20);
        but2.setBounds(200,120,200,20);

        jf.add(but1);
        jf.add(but2);

        but1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                add_customer();
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


    static void add_customer(){

        Connection c = null;
        try{
            c = DriverManager.getConnection("jdbc:sqlite3:customer_data");
            customer_window.customer();
        }
        catch( Exception e ){
            wrong_login_window wrw = new wrong_login_window();
            String text = e.getMessage();
            String title = "database issue ";
            wrw.show_window(title,text);
        }
    }

     public static void customer(){

         JFrame jf = new JFrame("Add new Customer ");
         jf.setSize(800,800);

         JLabel customer_name = new JLabel("Enter Customer name ");
         JLabel opening_balance = new JLabel("Enter opening Balance ");
         JLabel user_id = new JLabel("Enter User_ID ");

         JTextField name = new JTextField();
         JTextField bal = new JTextField();
         JTextField id = new JTextField();

         jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         customer_name.setBounds(200,100,200,50);
         name.setBounds(200,150,200,50);
         opening_balance.setBounds(200,200,200,50);
         bal.setBounds(200,250,200,50);
         user_id.setBounds(200,300,200,50);
         id.setBounds(200,350,200,50);


         jf.add(customer_name);
         jf.add(name);
         jf.add(opening_balance);
         jf.add(bal);
         jf.add(user_id);
         jf.add(id);

         jf.setVisible(true);

    }

    public static void show_customers(){

        JFrame jf = new JFrame("Add new Customer ");
        jf.setSize(800,800);
    }
}
