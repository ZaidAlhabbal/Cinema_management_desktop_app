import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.*;
public class HomeScreen extends JFrame {
   static String path="DemoCinema/Source";
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int screenHeight = (int) screenSize.getHeight(),screenWidth = (int) screenSize.getWidth();
    private ImageIcon ImageSize(ImageIcon image,int with,int height ) {
        Image scaledImage = image.getImage().getScaledInstance(with, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }
    JPanel panel;
    static JLabel label, Welcome;
    Timer timer;
   static String []ima=new String[24];

    static JButton Register,Login,Logout, UserAccount,Booking;
    ImageIcon[] images;
    private int index;
    final int FRAME_WIDTH = screenWidth;
    final int FRAME_HEIGHT =screenHeight;
    private static final int DELAY = 3000; //   3 seconds
    private static final Color Bcolor=new Color(12, 12, 52);
    private static final Color Bcolor3=new Color(8, 143, 143);
    private static final Color Bcolor7=new Color(0, 150, 255);
    static void Changes(String name){
        Register.setVisible(false);
        Login.setVisible(false);
        Booking.setVisible(true);
        UserAccount.setVisible(true);
        Logout.setVisible(true);
        Welcome.setVisible(true);
        Welcome.setText("Welcome "+name);
        Welcome.setSize(10,10);
    }
    static void Changes2(){
        Register.setVisible(true);
        Login.setVisible(true);
        Booking.setVisible(false);
        UserAccount.setVisible(false);
        Logout.setVisible(false);
        Welcome.setVisible(false);
    }
    public HomeScreen () {
        super ("Z_Movies");
        super.setBackground(Bcolor);
        panel = new JPanel ();
        label = new JLabel ();
        timer = new Timer (DELAY, e -> changeImage ());
        images = new ImageIcon[3];
        int with=1400,height=290;
        images[0] = ( ImageSize(new ImageIcon(path+"/Photos/ee.jpg"),with,height));
        images[1] = ( ImageSize(new ImageIcon(path+"/Photos/GK.jpg"),with,height));
        images[2] = ( ImageSize(new ImageIcon(path+"/Photos/R (1).jpg"),with,height));
        index = 0;
        panel.setBackground (Bcolor);
        label.setIcon (images[index]);
        label.setHorizontalAlignment (SwingConstants.CENTER);
        label.setVerticalAlignment (SwingConstants.TOP);
        panel.add (label);
        Welcome = new JLabel();
        Welcome.setFont(new Font("Arial", Font.BOLD, 25));
        Welcome.setForeground(Bcolor3);
        Welcome.setVisible(false);
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        Logout = new JButton();
        Logout.setVisible(false);
        Logout.setText("Logout now                  ");
        Logout.setFont(new Font("Arial ", Font.BOLD, 12));
        Logout.setBackground(Bcolor);
        Logout.setForeground(Bcolor7);
        Logout.setSize(50,100);
        Logout.setIcon( ImageSize(new ImageIcon(path+"/Icons/ou.png"),40,30));
        Logout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Logout.setBackground(Color.red); // Change color on hover
            }
            @Override
            public void mouseExited(MouseEvent e) {
                Logout.setBackground(null); // Revert to original color when mouse leaves
            }
        });
        Logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to logout of your account ?",
                        "Exit Confirmation",
                        JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    HomeScreen.Changes2();
                }
            }
        });
        Login = new JButton();
        Login.setText("Login now                  ");
        Login.setFont(new Font("Arial ", Font.BOLD, 12));
        Login.setBackground(Bcolor);
        Login.setForeground(Bcolor7);
        Login.setSize(50,150);
        Login.setIcon( ImageSize(new ImageIcon(path+"/Icons/lo.png"),40,30));
        Login.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Login.setBackground(Color.GREEN); // Change color on hover
            }
            @Override
            public void mouseExited(MouseEvent e) {
                Login.setBackground(null); // Revert to original color when mouse leaves
            }
        });
        Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginScreen loginScreen =new LoginScreen();
            }
        });
        Register = new JButton();
        Register.setText("Register now                 ");
        Register.setFont(new Font("Arial ", Font.BOLD, 12));
        Register.setBackground(Bcolor);
        Register.setForeground(Bcolor7);
        Register.setSize(50,50);
        Register.setIcon( ImageSize(new ImageIcon(path+"/Icons/R (1).png"),40,30));
        Register.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Register.setBackground(Color.GREEN); // Change color on hover
            }
            @Override
            public void mouseExited(MouseEvent e) {
                Register.setBackground(null); // Revert to original color when mouse leaves
            }
        });
        Register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterScreen registerScreen =new RegisterScreen();
            }
        });
        rightPanel.add(Welcome);
        rightPanel.add(Login);
        rightPanel.add(Welcome);
        rightPanel.add(Register);
        UserAccount = new JButton();
        UserAccount.setVisible(false);
        UserAccount.setText("User Account               ");
        UserAccount.setFont(new Font("Arial ", Font.BOLD, 12));
        UserAccount.setForeground(Bcolor7);
        UserAccount.setSize(50,50);
        UserAccount.setBackground(Bcolor);
        UserAccount.setIcon( ImageSize(new ImageIcon(path+"/Icons/ww.png"),40,30));
        UserAccount.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {

                UserAccount.setBackground(Color.GREEN); // Change color on hover
            }

            @Override
            public void mouseExited(MouseEvent e) {
                UserAccount.setBackground(null); // Revert to original color when mouse leaves
            }
        });
        UserAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserAccountScreen UserAccountScreen =new UserAccountScreen();
            }
        });
        rightPanel.add(UserAccount);
        JButton moviesStatistics = new JButton();
        moviesStatistics.setText("Movies Statistics    ");
        moviesStatistics.setForeground(Bcolor7);
        moviesStatistics.setFont(new Font("Arial", Font.BOLD, 12));
        moviesStatistics.setSize(50,50);
        moviesStatistics.setIcon( ImageSize(new ImageIcon(path+"/Icons/6503604.png"),40,30));
        moviesStatistics.setBackground(Bcolor);
        moviesStatistics.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                moviesStatistics.setBackground(Color.GREEN); // Change color on hover
            }

            @Override
            public void mouseExited(MouseEvent e) {
                moviesStatistics.setBackground(null); // Revert to original color when mouse leaves
            }
        });
        moviesStatistics.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OffersScreen UserReservations =new OffersScreen();
            }
        });
        rightPanel.add(moviesStatistics);
        Booking = new JButton();
        Booking.setVisible(false);
        Booking.setText("Manage reservations");
        Booking.setForeground(Bcolor7);
        Booking.setFont(new Font("Arial", Font.BOLD, 12));
        Booking.setSize(50,50);
        Booking.setIcon( ImageSize(new ImageIcon(path+"/Icons/re.jpg"),40,30));
        Booking.setBackground(Bcolor);
        Booking.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Booking.setBackground(Color.GREEN); // Change color on hover
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Booking.setBackground(null); // Revert to original color when mouse leaves
            }
        });
        Booking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File f=new File(Main.path+"\\"+UserAccountScreen.getUserName()+UserAccountScreen.getFatherUserName()+"\\UserTickets.txt");
                if(f.exists()) {
                    ManageReservations UserReservations = new ManageReservations();
                }
                else
                    JOptionPane.showMessageDialog(null,"You have not made a reservation yet","Error",JOptionPane.ERROR_MESSAGE);
            }
        });
        rightPanel.add(Booking);
        rightPanel.add(Logout);
        JButton exitButton = new JButton();
        exitButton.setText("Exit");
        exitButton.setForeground(Bcolor7);
        exitButton.setFont(new Font("Arial", Font.BOLD, 12));
        exitButton.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        exitButton.setIcon( ImageSize(new ImageIcon(path+"/Icons/Exit.png"),40,30));
        exitButton.setBackground(Bcolor);
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                exitButton.setBackground(Color.red); // Change color on hover
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton.setBackground(null); // Revert to original color when mouse leaves
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to exit?",
                        "Exit Confirmation",
                        JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        rightPanel.add(Box.createVerticalGlue());
        rightPanel.add(exitButton);
        rightPanel.setBackground (Bcolor);
        DefaultListModel<ImageIcon> listModel1 = new DefaultListModel<ImageIcon>();
        int wi=150,hi=225;
        for (int i = 0; i < 24; i++)
        {
            File F = new File("DemoCinema/Source/Movies_photos/");
            ima[i]="DemoCinema/Source/Movies_photos/"+ Objects.requireNonNull(F.list())[i];
            ImageIcon image = ImageSize(new ImageIcon(ima[i]),wi,hi);
            listModel1.addElement(image);
        }
        JList<ImageIcon> imageList = new JList<>(listModel1);
        imageList.setCellRenderer(new ImageRenderer());
        // Set the selection mode to single interval
        imageList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        // Set the layout orientation to horizontal wrap
        imageList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        // Set the visible row count to 5
        imageList.setVisibleRowCount(4);
        imageList.setBackground (Bcolor);
        imageList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                    // Handle picture click event here
                    int clickedIndex = imageList.locationToIndex(e.getPoint());
                    //ImageIcon clickedImage = listModel1.getElementAt(clickedIndex);
                    ArrayList<String[]> a = new ArrayList<>();
                    FileDeal f = new FileDeal();
                    try {
                        a = f.readStr(Main.path + "\\Movies.txt");
                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                    ReservationScreen z = new ReservationScreen(ima[clickedIndex], a.get(clickedIndex),"40");
            }
        });
        // Create a scroll pane that contains the image list
        JScrollPane scrollPane = new JScrollPane(imageList);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        JPanel mainPanel = new JPanel(new BorderLayout());
        add(rightPanel,BorderLayout.WEST);
        mainPanel.add(panel,BorderLayout.PAGE_START);
        mainPanel.add( scrollPane, BorderLayout.CENTER);
        mainPanel.setBackground (Bcolor);
        mainPanel.setForeground(Bcolor);
        add (mainPanel);
        pack();
        setLocationRelativeTo (null);
        setDefaultCloseOperation (EXIT_ON_CLOSE);
        setVisible (true);
        timer.start ();
    }
    private void changeImage () {
        index++;
        if (index == images.length) {
            index = 0;
        }
        label.setIcon(images[index]);
    }
    class ImageRenderer extends JLabel implements ListCellRenderer<ImageIcon> {
        @Override
        public Component getListCellRendererComponent(JList<? extends ImageIcon> list, ImageIcon value, int index, boolean isSelected, boolean cellHasFocus) {
            setIcon(value);
            setBorder(BorderFactory.createEmptyBorder(10, 36, 10, 34)); // Add spacing around the image
            return this;
        }
    }
}