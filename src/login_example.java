
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class login extends my_frame implements ActionListener {

    JLabel welcomeText;
    JLabel welcomeText2;
    JLabel userName;
    JLabel passWord;
    JTextField userText;
    JPasswordField passwordField;
    JButton submit;
    Font font1,font2;

    login() {
        super("Login Page");
        setLayout(null);

        font1 = new Font("Comic Sans" , Font.BOLD,25);
        font2 = new Font("Comic Sans" , Font.BOLD,25);
        welcomeText = new JLabel("WELCOME to Billing Application");
        welcomeText2 = new JLabel("Please Login");
        welcomeText.setFont(font1);
        add(welcomeText);
        welcomeText.setBounds(200,20,500,100);
        welcomeText2.setBounds(200,120,300,100);
        welcomeText2.setFont(font2);
        add(welcomeText2);

        userName = new JLabel("Username :");
        userName.setBounds(200,220,500,100);
        userName.setFont(font2);
        passWord = new JLabel("Password :");
        passWord.setBounds( 200,340,500,100);
        passWord.setFont(font2);
        add(userName);
        add(passWord);

        userText = new JTextField(20);
        userText.setBounds(200,320,200,20);
        passwordField = new JPasswordField(20);
        passwordField.setBounds( 200,440,200,20);
        add(userText);
        add(passwordField);

        submit = new JButton("Login");
        add(submit);
        submit.addActionListener(this);
        submit.setBounds( 200,460,100,38);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String userName = userText.getText();
        if (userName.length() == 0) {
            JOptionPane.showMessageDialog(this,"UserName can't be empty!!","Error",JOptionPane.WARNING_MESSAGE);
            userName=userText.getText();
        }
        String pass = passwordField.getText();
        if (pass.length() == 0) {
            JOptionPane.showMessageDialog(this,"Password can't be empty!!","Error",JOptionPane.WARNING_MESSAGE);
            pass = passwordField.getText();
        }
        if(userName.length() != 0 && pass.length() != 0) {
            if(userName.equals("root") && pass.equals("root")){
                customer_window.show_options();
            }
            else {
                wrong_login_window wrw = new wrong_login_window();
                String text = "You Entered Wrong Credentials, Please try Again ";
                String title = "Wrong Credential ";
                wrw.show_window(title,text);
            }

        }
    }
}

public class login_example {

}
