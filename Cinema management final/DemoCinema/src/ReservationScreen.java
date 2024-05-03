import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Map;
import java.util.Vector;

public class ReservationScreen extends JFrame {
    private ImageIcon ImageSize(ImageIcon image,int with,int height ) {
        Image scaledImage = image.getImage().getScaledInstance(with, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }
    static MovieRating m=new MovieRating();
    private static final Color Bcolor2=new Color(12, 12, 52);
    private static final Color Bcolor3=new Color(	138, 138, 138);
    private static final Color Bcolor4=new Color(		49, 161, 211);
    private static final Color Bcolor6=new Color(8, 143, 143);
    private static final Color Bcolor7=new Color(0, 150, 255);
    private static final Color Bcolor1=new Color(0, 0, 0);
    private int rating;

    Container c;
    static JLabel title,name,type, choose,emp, Price, hall, MoveIcon,PaymentMethod,MoveTime,Comment;
    static JRadioButton time1,time2,Payment1,Payment2,Payment3,starButton;
    ButtonGroup group1,group2;
    static  JComboBox seats;
    JTextField AddComment;
    JButton book,Add,ShowComment;
    static String seat1[],TimeZ;
    static String []z;
    public ReservationScreen(String path,String []a,String price)
    {
        z=a;
        setBackground(Bcolor2);
        setTitle("Movie Features");
        setBounds(200, 50, 1100, 750);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        c = this.getContentPane();
        c.setLayout(null);
        title = new JLabel("Movie Features");
        title.setFont(new Font("Times New Roman", Font.BOLD, 30));
        title.setSize(400, 30);
        title.setLocation(400, 28);
        title.setForeground(Bcolor6);
        name = new JLabel();
        name.setText(a[1]);
        name.setFont(new Font("Times New Roman", Font.BOLD, 32));
        name.setSize(400, 35);
        name.setLocation(450, 140);
        name.setForeground(Bcolor7);
        type = new JLabel();
        type.setText(a[2]);
        type.setFont(new Font("Arial", Font.BOLD, 25));
        type.setSize(400, 30);
        type.setLocation(450, 200);
        type.setForeground(Bcolor4);
        hall = new JLabel();
        hall.setText("Cinema hall : "+a[3]);
        hall.setFont(new Font("Arial", Font.BOLD, 25));
        hall.setSize(300, 30);
        hall.setLocation(450, 250);
        hall.setForeground(Bcolor4);
        Price = new JLabel();
        Price.setText("Ticket Price : "+price+ "$");
        Price.setFont(new Font("Arial", Font.BOLD, 25));
        Price.setSize(300, 30);
        Price.setLocation(450, 300);
        Price.setForeground(Bcolor4);
        MoveIcon =new JLabel();
        MoveIcon.setIcon(ImageSize(new ImageIcon(path),380,550));
        MoveIcon.setLocation(10, -80);
        MoveIcon.setSize(400,750);
        time1 =new JRadioButton(a[4]);
        time1.setBounds(450,385,60,40);
        time1.setBackground(Bcolor2);
        time1.setForeground(Bcolor4);
        time1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
               seat1 = Ticketing.showAvailableSeats(Integer.parseInt(a[3]), Main.timeConverter.get(a[4])).toArray(new String[0]);
                seats.setModel(new DefaultComboBoxModel<>(seat1));
                if(seat1.length!=0) {
                    emp.setVisible(false);
                    choose.setVisible(true);
                    seats.setVisible(true);
                }
                else {
                    emp.setVisible(true);
                    choose.setVisible(false);
                    seats.setVisible(false);
                }
                TimeZ=time1.getText();
            }
        });
        time2 =new JRadioButton(a[5]);
        time2.setBounds(450,435,60,40);
        time2.setBackground(Bcolor2);
        time2.setForeground(Bcolor4);
        time2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                seat1 = Ticketing.showAvailableSeats(Integer.parseInt(a[3]), Main.timeConverter.get(a[5])).toArray(new String[0]);
                seats.setModel(new DefaultComboBoxModel<>(seat1));
                if(seat1.length!=0) {
                    emp.setVisible(false);
                    choose.setVisible(true);
                    seats.setVisible(true);
                }
                else {
                    emp.setVisible(true);
                    choose.setVisible(false);
                    seats.setVisible(false);
                }
                TimeZ=time2.getText();
            }
        });
        Payment1 =new JRadioButton("Cash");
        Payment1.setBounds(800,385,150,40);
        Payment1.setBackground(Bcolor2);
        Payment1.setForeground(Bcolor4);
        Payment2 =new JRadioButton("Credit card");
        Payment2.setBounds(800,420,150,40);
        Payment2.setBackground(Bcolor2);
        Payment2.setForeground(Bcolor4);
        Payment3 =new JRadioButton("Pay via application");
        Payment3.setBounds(800,455,150,40);
        Payment3.setBackground(Bcolor2);
        Payment3.setForeground(Bcolor4);
        PaymentMethod = new JLabel("Choose a Payment Method :");
        PaymentMethod.setFont(new Font("Arial", Font.BOLD, 15));
        PaymentMethod.setSize(400, 30);
        PaymentMethod.setLocation(800, 350);
        PaymentMethod.setForeground(Bcolor3);
        MoveTime = new JLabel("Choose the show time :");
        MoveTime.setFont(new Font("Arial", Font.BOLD, 15));
        MoveTime.setSize(400, 30);
        MoveTime.setLocation(450, 350);
        MoveTime.setForeground(Bcolor3);
        group1=new ButtonGroup();
        group1.add(time1);
        group1.add(time2);
        group2=new ButtonGroup();
        group2.add(Payment1);
        group2.add(Payment2);
        group2.add(Payment3);
        choose = new JLabel("Choose the seat you want :");
        choose.setFont(new Font("Arial", Font.BOLD, 15));
        choose.setSize(400, 30);
        choose.setLocation(450, 470);
        choose.setForeground(Bcolor3);
        choose.setVisible(false);
        emp = new JLabel("All Seats have been reserved for this movie");
        emp.setFont(new Font("Arial", Font.BOLD, 15));
        emp.setSize(400, 30);
        emp.setLocation(450, 470);
        emp.setForeground(Bcolor3);
        emp.setVisible(false);
        seats = new JComboBox();
        seats.setFont(new Font("Arial", Font.PLAIN, 15));
        seats.setSize(50, 20);
        seats.setLocation(450, 505);
        seats.setBackground(Bcolor2);
        seats.setForeground(Bcolor3);
        seats.setVisible(false);
        book = new JButton("Book");
        book.setFont(new Font("Arial", Font.BOLD, 13));
        book.setBackground(Bcolor3);
        book.setForeground(Bcolor1);
        book.setSize(70,25);
        book.setLocation(1000,650);
        book.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (HomeScreen.Login.isVisible()) {
                    JOptionPane.showMessageDialog(null, "You must login or create an account first", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    if ((time1.isSelected() && (seat1.length != 0)) || (time2.isSelected() && (seat1.length != 0))) {
                        if (Payment1.isSelected()) {
                            Book b = new Book(Main.timeConverter.get(TimeZ), String.valueOf(seats.getSelectedItem()), a[3], UserAccountScreen.getFatherUserName(), UserAccountScreen.getUserName(), a[1]);
                            Thread bookthreed = new Thread(b);
                            bookthreed.start();
                            JOptionPane.showMessageDialog(null, "Your reservation has been completed successfully");
                            group1.clearSelection();
                            group2.clearSelection();
                            seats.setVisible(false);
                            choose.setVisible(false);
                            emp.setVisible(false);
                        } else if (Payment2.isSelected()) {
                            String userInput = JOptionPane.showInputDialog(null, "Enter your card number");
                            if (!userInput.isEmpty()) {
                                Book b = new Book(Main.timeConverter.get(TimeZ), String.valueOf(seats.getSelectedItem()), a[3], UserAccountScreen.getFatherUserName(), UserAccountScreen.getUserName(), a[1]);
                                Thread bookthreed = new Thread(b);
                                bookthreed.start();
                                JOptionPane.showMessageDialog(null, "Your reservation has been completed successfully");
                                group1.clearSelection();
                                group2.clearSelection();
                                seats.setVisible(false);
                                choose.setVisible(false);
                                emp.setVisible(false);
                            } else {
                                // User clicked "Cancel" or closed the dialog
                                JOptionPane.showMessageDialog(null, "Operation canceled");
                            }
                        } else if (Payment3.isSelected()) {
                            String userInput = JOptionPane.showInputDialog(null, "Enter your account");
                            if (!userInput.isEmpty()) {
                                Book b = new Book(Main.timeConverter.get(TimeZ), String.valueOf(seats.getSelectedItem()), a[3], UserAccountScreen.getFatherUserName(), UserAccountScreen.getUserName(), a[1]);
                                Thread bookthreed = new Thread(b);
                                bookthreed.start();
                                JOptionPane.showMessageDialog(null, "Your reservation has been completed successfully");
                                group1.clearSelection();
                                group2.clearSelection();
                                seats.setVisible(false);
                                choose.setVisible(false);
                                emp.setVisible(false);

                            } else {
                                // User clicked "Cancel" or closed the dialog
                                JOptionPane.showMessageDialog(null, "Operation canceled");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Please Choose a Payment Method", "alert", JOptionPane.ERROR_MESSAGE);
                        }

                    } else if (seat1.length == 0) {
                        JOptionPane.showMessageDialog(null, "All Seats have been reserved for this time", "alert", JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Please choose a time", "alert", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        Comment = new JLabel("If you have any comments on the movie, Form here");
        Comment.setFont(new Font("Arial", Font.BOLD, 15));
        Comment.setSize(400, 30);
        Comment.setLocation(20, 580);
        Comment.setForeground(Bcolor3);
        AddComment = new JTextField();
        AddComment.setFont(new Font("Arial", Font.PLAIN, 15));
        AddComment.setSize(200, 20);
        AddComment.setLocation(20, 620);
        AddComment.setBackground(Bcolor2);
        AddComment.setCaretColor(Color.white);
        AddComment.setForeground(Bcolor3);
        Add = new JButton("Send");
        Add.setBackground(Bcolor6);
        Add.setForeground(Bcolor1);
        Add.setSize(70,25);
        Add.setLocation(230,618);
        Add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(AddComment.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"You must add a comment !","Error",JOptionPane.ERROR_MESSAGE);
                }
                else {
                    if (HomeScreen.Login.isVisible()) {
                        JOptionPane.showMessageDialog(null, "You must login or create an account first", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else if (!UserAccountScreen.verify(AddComment.getText()))
                        JOptionPane.showMessageDialog(null, "You Cannot enter this character ';'", "Error", JOptionPane.ERROR_MESSAGE);
                    else {
                        JOptionPane.showMessageDialog(null, "Your comment has been added successfully \n" +
                                "You rated the movie " + rating + " stars!");
                        m.leaveComment(a[1], AddComment.getText(), UserAccountScreen.getUserName(), rating);
                        AddComment.setText("");
                    }
                }
            }
        });
        ShowComment = new JButton();
        ShowComment.setText("Show Comment");
        ShowComment.setFont(new Font("Arial ", Font.BOLD, 12));
        ShowComment.setBackground(Bcolor6);
        ShowComment.setForeground(Bcolor1);
        ShowComment.setBounds(320,618,130,25);
        ShowComment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File f=new File(Main.path+"\\Comment.txt");
                if(f.exists()) {
                    ShowComment show = new ShowComment();
                }
                else {
                    JOptionPane.showMessageDialog(null,"No Comment added yet","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        ButtonGroup buttonGroup = new ButtonGroup();
        int x=26;
        for (int i = 1; i <= 5; i++) {
            starButton = new JRadioButton("" + i);
            starButton.setActionCommand("" + i);
            starButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    rating = Integer.parseInt(e.getActionCommand());
                }
            });
            starButton.setBounds(x,650,60,30);
            starButton.setBackground(Bcolor2);
            starButton.setForeground(Bcolor3);
            c.add(starButton);
            x+=20;
            buttonGroup.add(starButton);
        }
        c.add(title);
        c.add(AddComment);
        c.add(Add);
        c.add(Comment);
        c.add(seats);
        c.add(time1);
        c.add(ShowComment);
        c.add(time2);
        c.add(book);
        c.add(Payment1);
        c.add(Payment2);
        c.add(Payment3);
        c.add(PaymentMethod);
        c.add(MoveTime);
        c.add(name);
        c.add(choose);
        c.add(emp);
        c.add(hall);
        c.add(type);
        c.add(Price);
        c.add(MoveIcon);
        c.setBackground(Bcolor2);
    }

}


/*

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomTitleBarExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setSize(400, 300);
            frame.setUndecorated(true); // Set to undecorated to hide the default title bar

            JPanel titleBar = new JPanel();
            titleBar.setBackground(new Color(12, 12, 52)); // Set your desired color
            titleBar.setPreferredSize(new Dimension(frame.getWidth(), 30));

            JButton closeButton = new JButton("Close");
            closeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });

            titleBar.add(closeButton);

            frame.getContentPane().setLayout(new BorderLayout());
            frame.getContentPane().add(titleBar, BorderLayout.NORTH);
            frame.getContentPane().setBackground(new Color(12, 14, 52)); // Set your desired background color

            frame.setVisible(true);
        });
    }
}


 */