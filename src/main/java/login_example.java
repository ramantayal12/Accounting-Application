
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class login extends Component {


    public static void execute_application() {

        JFrame jf = new JFrame("Login Window ");
        JPanel jp = new JPanel(new GridLayout(7, 1));
        jf.setSize(1000, 800);

        JLabel welcomeText, welcomeText2, userName, passWord;
        JTextField userText;
        JPasswordField passwordField;
        JButton submit;
        Font font1 = new Font("Comic Sans" , Font.BOLD,20);;


        welcomeText = new JLabel("WELCOME");
        welcomeText2 = new JLabel("Please login to continue...");
        welcomeText.setFont(font1);
        welcomeText2.setFont(font1);


        userName = new JLabel("Username :");
        userName.setFont(font1);
        passWord = new JLabel("Password :");
        passWord.setFont(font1);


        userText = new JTextField(20);
        passwordField = new JPasswordField(20);
        submit = new JButton("Login");

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = userText.getText();
                if (userName.length() == 0) {
                    JOptionPane.showMessageDialog(jf,"User Name Cant be Empty ","Error", JOptionPane.WARNING_MESSAGE);
                    userName = userText.getText();
                }
                String pass = passwordField.getText();
                if (pass.length() == 0) {
                    JOptionPane.showMessageDialog(jf,"PassWord Cant be Empty ","Error", JOptionPane.WARNING_MESSAGE);
                    //JOptionPane.showMessageDialog( e,"Password can't be empty!!", "Error", JOptionPane.WARNING_MESSAGE);
                    pass = passwordField.getText();
                }
                if (userName.length() != 0 && pass.length() != 0) {
                    if (userName.equals("root") && pass.equals("root")) {
                        options_window.show_options();
                    } else {
                        String text = "You Entered Wrong Credentials, Please try Again ";
                        String title = "Wrong Credential ";
                        mesaage_window.show_window(title, text);
                    }

                }
            }
        });

        jp.add(welcomeText);
        jp.add(welcomeText2);
        jp.add(userText);
        jp.add(userName);
        jp.add(passwordField);
        jp.add(passWord);
        jp.add(submit);

        jf.add(jp);
        jf.setVisible(true);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
}

public class login_example {

}
