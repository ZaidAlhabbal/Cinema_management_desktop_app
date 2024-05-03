import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class LoginScreen extends JFrame {


    FileDeal f = new FileDeal();
    User user;
    private ImageIcon ImageSize(ImageIcon image,int with,int height ) {
        Image scaledImage = image.getImage().getScaledInstance(with, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }
    private static final Color Bcolor2=new Color(12, 12, 52);
    private static final Color Bcolor3=new Color(138, 138, 138);
    private static final Color Bcolor4=new Color(49, 161, 211);
    JButton blogin;
    JButton showHideButton,HideButton;
    JPanel loginpanel;
    JTextField txuser;
    JPasswordField  pass;
    JLabel username,password;
    public LoginScreen() {
        super("Login");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        blogin = new JButton("Login");
        blogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user =new User();
                try {
                  char[] p = pass.getPassword();
                  String ans ="";
                  for(var i:p)
                      ans+=i;
                    if(user.login(txuser.getText(),ans) != null)
                    {
                        UserAccountScreen.addview(user.login(txuser.getText(),ans));
                        JOptionPane.showMessageDialog(null,"Welcome Back");
                        HomeScreen.Changes(txuser.getText());
                        Timer timer = new Timer(500, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                dispose();
                            }
                        });
                        timer.setRepeats(false); // Only run the task once
                        timer.start();
                    }
                    else {
                        JOptionPane.showMessageDialog(null, " Incorrect password or username", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch (IOException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        });
        loginpanel = new JPanel();
        txuser = new JTextField(15);
        pass = new JPasswordField(15);
        username = new JLabel("User - ");
        password = new JLabel("Password - ");
        setSize(300, 200);
        setLocation(500, 280);
        loginpanel.setLayout(null);
        txuser.setBounds(70, 30, 150, 20);
        pass.setBounds(70, 65, 150, 20);
        blogin.setBounds(110, 100, 80, 20);
        username.setBounds(20, 28, 80, 20);
        password.setBounds(5, 63, 80, 20);
        showHideButton = new JButton(ImageSize(new ImageIcon("Source/Icons/hide.png"),40,40));
        HideButton = new JButton(ImageSize(new ImageIcon("Source/Icons/view.png"),40,40));
        showHideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Toggle the password visibility
                pass.setEchoChar((char) 0);
                showHideButton.setVisible(false);
                HideButton.setVisible(true);
            }
        });
        HideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Toggle the password visibility
                HideButton.setVisible(false);
                showHideButton.setVisible(true);
                pass.setEchoChar('\u2022');
            }
        });
        showHideButton.setBounds(230,63,35,30);
        HideButton.setBounds(230,63,35,30);
        loginpanel.add(showHideButton);
        loginpanel.add(HideButton);
        loginpanel.add(blogin);
        loginpanel.add(txuser);
        loginpanel.add(pass);
        loginpanel.add(username);
        loginpanel.add(password);
        getContentPane().add(loginpanel);
        loginpanel.setBackground(Bcolor2);
        blogin.setForeground(Bcolor4);
        blogin.setBackground(Bcolor2);
        txuser.setBackground(Bcolor2);
        txuser.setForeground(Bcolor3);
        txuser.setCaretColor(Color.white);
        pass.setBackground(Bcolor2);
        pass.setForeground(Bcolor3);
        pass.setCaretColor(Color.white);
        username.setBackground(Bcolor2);
        username.setForeground(Bcolor4);
        password.setBackground(Bcolor2);
        password.setForeground(Bcolor4);
        setVisible(true);
    }
}
