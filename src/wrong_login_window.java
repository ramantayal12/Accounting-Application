import javax.swing.*;

public class wrong_login_window {

    void show_window(String title, String text ){
        JFrame jf = new JFrame(title );
        jf.setSize(400,400);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel(text);
        jf.add(label);
        jf.setVisible(true);

    }

}
