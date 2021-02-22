import javax.swing.*;

public class customer_window {
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

         customer_name.setBounds(200,100,200,20);
         name.setBounds(200,120,200,20);
         opening_balance.setBounds(200,140,200,20);
         bal.setBounds(200,160,200,20);
         user_id.setBounds(200,180,200,20);
         id.setBounds(200,200,200,20);


         jf.add(customer_name);
         jf.add(name);
         jf.add(opening_balance);
         jf.add(bal);
         jf.add(user_id);
         jf.add(id);

         jf.setVisible(true);

    }
}
