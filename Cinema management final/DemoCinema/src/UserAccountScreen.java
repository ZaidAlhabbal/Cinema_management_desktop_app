import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
public class UserAccountScreen extends JFrame {
    private ImageIcon ImageSize(ImageIcon image,int with,int height ) {
        Image scaledImage = image.getImage().getScaledInstance(with, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }
    private static final Color Bcolor2=new Color(12, 12, 52);
    private static final Color Bcolor3=new Color(	138, 138, 138);
    private static final Color Bcolor4=new Color(		49, 161, 211);
    Container c;
    JLabel title,name,phone,fname,age,gender,UserIcon;
    JButton changePassword;

    static String [] info2=null;
    public static void addview(String a[]){
        info2=a;
    }
    static String UserName,FatherName;
    public static String getUserName(){
            return UserName;
    }
    public static void  setUserName(String a){
        UserName = a;
    }
    public static String getFatherUserName(){return FatherName;}
    public static void  setUserFatherName(String a){
            FatherName=a;
    }
    public static boolean verify(String x)
    {
        int index = x.indexOf(';');
        return index == -1;
    }
    public UserAccountScreen()
    {
        if(info2 !=null)
        {
            setBackground(Bcolor2);
            setTitle("User account");
            setBounds(300, 90, 900, 600);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setResizable(false);
            setVisible(true);
            c = this.getContentPane();
            c.setLayout(null);
            title = new JLabel("User account information");
            title.setFont(new Font("Arial", Font.BOLD, 30));
            title.setSize(400, 30);
            title.setLocation(260, 28);
            title.setForeground(Bcolor3);
            name = new JLabel();
            name.setText("User name : "+info2[0]);
            name.setFont(new Font("Arial", Font.BOLD, 25));
            name.setSize(300, 30);
            name.setLocation(50, 150);
            name.setForeground(Bcolor4);
            fname = new JLabel();
            fname.setText("father name : "+info2[2]);
            setUserFatherName(info2[1]);
            fname.setFont(new Font("Arial", Font.BOLD, 25));
            fname.setSize(300, 30);
            fname.setLocation(50, 200);
            fname.setForeground(Bcolor4);
            phone = new JLabel();
            phone.setText("User Phone : "+info2[3]);
            phone.setFont(new Font("Arial", Font.BOLD, 25));
            phone.setSize(300, 30);
            phone.setLocation(50, 250);
            phone.setForeground(Bcolor4);
            age = new JLabel();
            age.setText("Age : "+info2[5]);
            age.setFont(new Font("Arial", Font.BOLD, 25));
            age.setSize(300, 30);
            age.setLocation(50, 300);
            age.setForeground(Bcolor4);
            changePassword=new JButton();
            changePassword.setText("Change Password");
            changePassword.setBounds(50,400,140,25);
            changePassword.setForeground(Bcolor3);
            changePassword.setBackground(Bcolor2);
            changePassword.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    changePassword.setBackground(Color.red); // Change color on hover
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    changePassword.setBackground(Bcolor2); // Revert to original color when mouse leaves
                }
            });
            changePassword.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int result = JOptionPane.showConfirmDialog(null,
                            "Are you sure you want to change your password?",
                            "alert",
                            JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION) {
                      String res=  JOptionPane.showInputDialog("Enter the new password you want ");
                        if (!res.isEmpty() && verify(res)) {
                            try {
                                User.ChangePass(res, info2[1]);
                            } catch (FileNotFoundException ex) {
                                throw new RuntimeException(ex);
                            }
                            JOptionPane.showMessageDialog(null, "Your password has been successfully changed", "alert", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else if (!verify(res))
                            JOptionPane.showMessageDialog(null, "You Cannot enter this character ';' ", "Error", JOptionPane.ERROR_MESSAGE);
                        else
                            JOptionPane.showMessageDialog(null, "It should not be empty", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            gender = new JLabel();
            gender.setText("Gender : "+info2[4]);
            gender.setFont(new Font("Arial", Font.BOLD, 25));
            gender.setSize(300, 30);
            gender.setLocation(50, 350);
            gender.setForeground(Bcolor4);
            UserIcon =new JLabel();
            if(Objects.equals(info2[4], "Male"))
                UserIcon.setIcon(ImageSize(new ImageIcon("Source/Icons/MaleU.png"),350,300));
            else
                UserIcon.setIcon(ImageSize(new ImageIcon("Source/Icons/Ufemale.png"),350,300));
            UserIcon.setLocation(470, 130);
            UserIcon.setSize(350,300);
            c.add(title);
            c.add(name);
            c.add(fname);
            c.add(phone);
            c.add(age);
            c.add(gender);
            c.add(UserIcon);
            c.add(changePassword);
            c.setBackground(Bcolor2);

        }
        else {
            ArrayList<String> info= RegisterScreen.GetUserinfo();
            setBackground(Bcolor2);
            setTitle("User account");
            setBounds(300, 90, 900, 600);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setResizable(false);
            setVisible(true);
            c = this.getContentPane();
            c.setLayout(null);
            title = new JLabel("User account information");
            title.setFont(new Font("Arial", Font.BOLD, 30));
            title.setSize(400, 30);
            title.setLocation(260, 28);
            title.setForeground(Bcolor3);
            name = new JLabel();
            name.setText("User name : "+info.get(0));
            setUserName(info.get(0));
            name.setFont(new Font("Arial", Font.BOLD, 25));
            name.setSize(300, 30);
            name.setLocation(50, 150);
            name.setForeground(Bcolor4);
            fname = new JLabel();
            fname.setText("father name : "+info.get(1));
            fname.setFont(new Font("Arial", Font.BOLD, 25));
            fname.setSize(300, 30);
            fname.setLocation(50, 200);
            fname.setForeground(Bcolor4);
            phone = new JLabel();
            phone.setText("User Phone : "+info.get(2));
            phone.setFont(new Font("Arial", Font.BOLD, 25));
            phone.setSize(300, 30);
            phone.setLocation(50, 250);
            phone.setForeground(Bcolor4);
            age = new JLabel();
            age.setText("Age : "+info.get(3));
            age.setFont(new Font("Arial", Font.BOLD, 25));
            age.setSize(300, 30);
            age.setLocation(50, 300);
            age.setForeground(Bcolor4);
            changePassword=new JButton();
            changePassword.setText("Change Password");
            changePassword.setBounds(50,400,140,25);
            changePassword.setForeground(Bcolor3);
            changePassword.setBackground(Bcolor2);
            changePassword.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    changePassword.setBackground(Color.red); // Change color on hover
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    changePassword.setBackground(Bcolor2); // Revert to original color when mouse leaves
                }
            });
            changePassword.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int result = JOptionPane.showConfirmDialog(null,
                            "Are you sure you want to change your password?",
                            "alert",
                            JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION) {
                        String res = JOptionPane.showInputDialog("Enter the new password you want ");
                        if (!res.isEmpty() && verify(res)) {
                            try {
                                User.ChangePass(res, info.get(4));
                            } catch (FileNotFoundException ex) {
                                throw new RuntimeException(ex);
                            }
                            JOptionPane.showMessageDialog(null, "Your password has been successfully changed", "alert", JOptionPane.INFORMATION_MESSAGE);
                        } else if (!verify(res))
                            JOptionPane.showMessageDialog(null, "You Cannot enter this character ';'", "Error", JOptionPane.ERROR_MESSAGE);
                        else
                            JOptionPane.showMessageDialog(null, "It should not be empty", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            gender = new JLabel();
            gender.setText("Gender : "+info.get(5));
            gender.setFont(new Font("Arial", Font.BOLD, 25));
            gender.setSize(300, 30);
            gender.setLocation(50, 350);
            gender.setForeground(Bcolor4);
            UserIcon =new JLabel();
            if(Objects.equals(info.get(5), "Male"))
                UserIcon.setIcon(ImageSize(new ImageIcon("Source/Icons/MaleU.png"),350,300));
            else
                UserIcon.setIcon(ImageSize(new ImageIcon("Source/Icons/Ufemale.png"),350,300));
            UserIcon.setLocation(470, 130);
            UserIcon.setSize(350,300);
            c.add(title);
            c.add(name);
            c.add(fname);
            c.add(phone);
            c.add(age);
            c.add(gender);
            c.add(UserIcon);
            c.add(changePassword);
            c.setBackground(Bcolor2);
        }

    }

}