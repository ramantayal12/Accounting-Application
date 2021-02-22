


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


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

        font1 = new Font("Comic Sans" , Font.BOLD,50);
        font2 = new Font("Comic Sans" , Font.BOLD,25);
        welcomeText = new JLabel("WELCOME");
        welcomeText2 = new JLabel("Please login to continue...");
        welcomeText.setFont(font1);
        add(welcomeText);
        welcomeText.setBounds(20,20,500,200);
        welcomeText2.setBounds(20,50,300,200);
        welcomeText2.setFont(font2);
        add(welcomeText2);

        userName = new JLabel("Username :");
        userName.setBounds(400,20,500,200);
        userName.setFont(font2);
        passWord = new JLabel("Password :");
        passWord.setBounds(400,60,500,200);
        passWord.setFont(font2);
        add(userName);
        add(passWord);

        userText = new JTextField(20);
        userText.setBounds(550,115,200,20);
        passwordField = new JPasswordField(20);
        passwordField.setBounds(550,155,200,20);
        add(userText);
        add(passwordField);

        submit = new JButton("Login");
        add(submit);
        submit.addActionListener(this);
        submit.setBounds(500,185,100,38);
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


            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration_form", "root", "root");
                Statement smt = con.createStatement();
                ResultSet rs = smt.executeQuery("Select * from info where user_id = '"+userName+"' and password = '"+pass+"'");

                dispose();

            } catch (SQLException throwables ) {
                throwables .printStackTrace();
            }
        }
    }
}

public class login_example {
    public static void main(String []args ){
        login l = new login();
    }
}
