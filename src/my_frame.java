import javax.swing.*;


public class my_frame extends JFrame {
    my_frame(String s) {
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
        setSize(1000,800);
        setTitle(s);
    }
}
