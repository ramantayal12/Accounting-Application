import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class generate_bill {

    public static void bill_window(){

        JFrame jf = new JFrame("Generate Bill");
        jf.setSize(800,800);
        JPanel jp = new JPanel(new GridLayout(5,1));

        JLabel customer_id = new JLabel(" Enter the ID of customer ");
        JTextField customer_id_input = new JTextField();


        JLabel bill_amount = new JLabel("Enter Amount  ");
        JTextField bill_amount_input = new JTextField();


        JButton submit_button = new JButton("Submit");
        submit_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user_id = customer_id_input.getText();
                if (user_id.length() == 0) {
                    JOptionPane.showMessageDialog(jf,"User ID Cant be Empty ","Error", JOptionPane.WARNING_MESSAGE);
                    user_id = customer_id_input.getText();
                }

                String bill_amount = bill_amount_input.getText();
                if (bill_amount.length() == 0) {
                    JOptionPane.showMessageDialog(jf,"User ID Cant be Empty ","Error", JOptionPane.WARNING_MESSAGE);
                    bill_amount = bill_amount_input.getText();
                }

                if( bill_amount.length() != 0 && user_id.length() != 0 ) {
                    int id = Integer.parseInt(customer_id_input.getText());
                    int amount = Integer.parseInt(bill_amount_input.getText());
                    String[] data = get_details(id, amount);
                    String name = data[0];
                    mesaage_window.show_window("Bill Passed", "New Balance of " + name + " is " + data[1]);
                }

            }
        });



        jp.add(customer_id);
        jp.add(customer_id_input);
        jp.add(bill_amount);
        jp.add(bill_amount_input);
        jp.add(submit_button);


        jf.add(jp);
        jf.setVisible(true);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static String[] get_details(int id ,int amount){

        String[] data = {"Dummy","0"};
        try {

            Class.forName("org.sqlite.JDBC");
            Connection c = DriverManager.getConnection("jdbc:sqlite:customer_data");
            Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * from customer_data where User_ID = " + id + ";" );

            rs.next();
            String name = rs.getString("Name");
            int balance = rs.getInt("Balance");

            int new_bal = balance - amount;
            statement.executeUpdate("Update customer_data SET Balance = " + new_bal +
                    " where User_ID = " + id+ ";" );

            data[0] = name;
            data[1] = String.valueOf(new_bal);

            statement.close();
            c.close();


        }catch(Exception ex ){
            System.out.println(ex.getMessage());
        }
        return data;
    }
}
