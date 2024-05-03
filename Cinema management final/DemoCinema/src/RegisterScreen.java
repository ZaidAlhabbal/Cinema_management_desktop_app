import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

class RegisterScreen extends JFrame implements ActionListener {
    public User createUser( String username, String password, String fathername, String phone, String gender, int age){
        return new User(username,password ,fathername,phone,gender,age);
    }

    static ArrayList<String> GetUserinfo(){
        if (male.isSelected())
            data1 = "Male";
        else
            data1 = "Female";
         String name=tname.getText(),fname=tfname.getText(),phone=tmno.getText(),age= String.valueOf(calculateAge(ans)),password=tpass.getText(),gender=data1;
         ArrayList<String> info=new ArrayList<>();
         info.add(name);
         info.add(fname);
         info.add(phone);
         info.add(age);
         info.add(password);
         info.add(gender);
         if (male.isSelected())
         {
             info.add("Male");
         }
         else
             info.add("female");
        return info;
    }

    static String data1;

    private static final Color Bcolor=new Color(	19, 21, 48);
    private static final Color Bcolor2=new Color(12, 12, 52);
    private static final Color Bcolor3=new Color(	138, 138, 138);
    private static final Color Bcolor4=new Color(		49, 161, 211);
    private static  String ans;
     Container c;
     JLabel title;
     JLabel name;
     static JTextField tname,tfname,tmno,tpass;
     JLabel fname;
     JLabel mno;
     JLabel gender;
     JLabel pass;
     static JRadioButton male;
     JRadioButton female;
     ButtonGroup gengp;
     JLabel age;
     JComboBox date;
     JComboBox month;
     JComboBox year;
     JCheckBox term;
     JButton sub;
     JButton reset;
     JTextArea tout;
     JLabel res;
     String dates[]
            = { "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "30",
            "31" };
     String months[]
            = { "Jan", "feb", "Mar", "Apr",
            "May", "Jun", "July", "Aug",
            "Sep", "Oct", "Nov", "Dec" };
     String years[] =
             { "1991", "1992", "1993", "1994",
             "1995", "1996", "1997", "1998",
            "1999", "2000", "2001", "2002",
            "2003", "2004", "2005", "2006",
            "2007", "2008", "2009", "2010",
            "2011", "2012", "2013", "2014",
            "2015", "2016", "2017", "2018",
            "2019"
     };
    public RegisterScreen()
    {
        setBackground(Bcolor);
        setTitle("Registration Form");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        c = getContentPane();
        c.setLayout(null);
        title = new JLabel("Registration Form");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        title.setForeground(Bcolor4);
        c.add(title);
        name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setLocation(100, 100);
        name.setBackground(Bcolor);
        name.setForeground(Bcolor4);
        c.add(name);
        tname = new JTextField();
        tname.setText("");
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(190, 20);
        tname.setLocation(200, 100);
        tname.setCaretColor(Color.white);
        tname.setBackground(Bcolor);
        tname.setForeground(Bcolor3);
        c.add(tname);
        fname = new JLabel("Father Name");
        fname.setFont(new Font("Arial", Font.PLAIN, 20));
        fname.setSize(150, 20);
        fname.setLocation(100, 150);
        fname.setBackground(Bcolor);
        fname.setForeground(Bcolor4);
        c.add(fname);
        tfname = new JTextField();
        tfname.setFont(new Font("Arial", Font.PLAIN, 15));
        tfname.setSize(150, 20);
        tfname.setLocation(240, 150);
        tfname.setCaretColor(Color.white);
        tfname.setBackground(Bcolor);
        tfname.setForeground(Bcolor3);
        c.add(tfname);
        pass = new JLabel("Password");
        pass.setFont(new Font("Arial", Font.PLAIN, 20));
        pass.setSize(100, 20);
        pass.setLocation(100, 200);
        pass.setBackground(Bcolor);
        pass.setForeground(Bcolor4);
        c.add(pass);
        tpass = new JTextField();
        tpass.setFont(new Font("Arial", Font.PLAIN, 15));
        tpass.setSize(150, 20);
        tpass.setLocation(200, 200);
        tpass.setBackground(Bcolor);
        tpass.setCaretColor(Color.white);
        tpass.setForeground(Bcolor3);
        c.add(tpass);
        mno = new JLabel("Mobile");
        mno.setFont(new Font("Arial", Font.PLAIN, 20));
        mno.setSize(100, 20);
        mno.setLocation(100, 250);
        mno.setBackground(Bcolor);
        mno.setForeground(Bcolor4);
        c.add(mno);
        tmno = new JTextField();
        tmno.setFont(new Font("Arial", Font.PLAIN, 15));
        tmno.setSize(150, 20);
        tmno.setLocation(200, 250);
        tmno.setBackground(Bcolor);
        tmno.setCaretColor(Color.white);
        tmno.setForeground(Bcolor3);
        c.add(tmno);
        gender = new JLabel("Gender");
        gender.setFont(new Font("Arial", Font.PLAIN, 20));
        gender.setSize(100, 20);
        gender.setLocation(100, 300);
        gender.setBackground(Bcolor);
        gender.setForeground(Bcolor4);
        c.add(gender);
        male = new JRadioButton("Male");
        male.setFont(new Font("Arial", Font.PLAIN, 15));
        male.setSelected(true);
        male.setSize(75, 20);
        male.setLocation(200, 300);
        male.setBackground(Bcolor);
        male.setForeground(Bcolor3);
        c.add(male);
        female = new JRadioButton("Female");
        female.setFont(new Font("Arial", Font.PLAIN, 15));
        female.setSelected(false);
        female.setSize(80, 20);
        female.setLocation(275, 300);
        female.setBackground(Bcolor);
        female.setForeground(Bcolor3);
        c.add(female);
        gengp = new ButtonGroup();
        gengp.add(male);
        gengp.add(female);
        age = new JLabel("Age");
        age.setFont(new Font("Arial", Font.PLAIN, 20));
        age.setSize(100, 20);
        age.setLocation(100, 350);
        age.setBackground(Bcolor);
        age.setForeground(Bcolor4);
        c.add(age);
        date = new JComboBox(dates);
        date.setFont(new Font("Arial", Font.PLAIN, 15));
        date.setSize(50, 20);
        date.setLocation(200, 350);
        date.setBackground(Bcolor);
        date.setForeground(Bcolor3);
        c.add(date);
        month = new JComboBox(months);
        month.setFont(new Font("Arial", Font.PLAIN, 15));
        month.setSize(60, 20);
        month.setLocation(255, 350);
        month.setBackground(Bcolor);
        month.setForeground(Bcolor3);
        c.add(month);
        year = new JComboBox(years);
        year.setFont(new Font("Arial", Font.PLAIN, 15));
        year.setSize(60, 20);
        year.setLocation(320, 350);
        year.setBackground(Bcolor);
        year.setForeground(Bcolor3);
        c.add(year);
        term = new JCheckBox("Accept Terms And Conditions.");
        term.setFont(new Font("Arial", Font.PLAIN, 15));
        term.setSize(250, 20);
        term.setLocation(150, 400);
        term.setBackground(Bcolor);
        term.setForeground(Bcolor3);
        c.add(term);
        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(150, 450);
        sub.addActionListener(this);
        sub.setBackground(Bcolor);
        sub.setForeground(Bcolor3);
        c.add(sub);
        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(270, 450);
        reset.addActionListener(this);
        reset.setBackground(Bcolor);
        reset.setForeground(Bcolor3);
        c.add(reset);
        tout = new JTextArea();
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(300, 400);
        tout.setLocation(500, 100);
        tout.setLineWrap(true);
        tout.setEditable(false);
        tout.setCaretColor(Bcolor);
        tout.setBackground(Bcolor);
        tout.setForeground(Bcolor3);
        c.add(tout);
        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 500);
        res.setBackground(Bcolor);
        res.setForeground(Bcolor3);
        c.add(res);
        c.setBackground(Bcolor2);
        c.setForeground(Bcolor3);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == sub) {
            if (term.isSelected()) {
                if ((!UserAccountScreen.verify(tname.getText()))||(!UserAccountScreen.verify(tfname.getText()))||(!UserAccountScreen.verify(tmno.getText()))||(!UserAccountScreen.verify(tpass.getText())))
                   JOptionPane.showMessageDialog(null, "You Cannot enter this character ';'", "Error", JOptionPane.ERROR_MESSAGE);
               else if(!(tname.getText().trim().isEmpty())&& !(tfname.getText().trim().isEmpty()) && !(tmno.getText().trim().isEmpty())&& !(tpass.getText().trim().isEmpty()))
                {
                    ans = (String) date.getSelectedItem();
                    ans += "-";
                    ans += (String) month.getSelectedItem();
                    ans += "-";
                    ans += (String) year.getSelectedItem();
                    String data
                            = "Name : "
                            + tname.getText() + "\n" +
                            "Father Name : "
                            + tfname.getText() + "\n"
                            + "Mobile : "
                            + tmno.getText() + "\n";
                    if (male.isSelected())
                        data1 = "Gender : Male"
                                + "\n";
                    else
                        data1 = "Gender : Female"
                                + "\n";
                    String data2
                            = "Age : "
                            + calculateAge(ans);
                    tout.setText(data + data1 + data2);
                    tout.setEditable(false);
                    res.setText("Registration Successfully..");
                    UserAccountScreen.setUserName(tname.getText());
                    UserAccountScreen.setUserFatherName(tfname.getText());
                    HomeScreen.Changes(tname.getText());
                    UserAccountScreen.addview(null);
                    Timer timer = new Timer(1000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            dispose();
                        }
                    });
                    timer.setRepeats(false); // Only run the task once
                    timer.start();
                    if (male.isSelected())
                        data1 = "Male";
                    else
                        data1 = "Female";
                    createUser(tname.getText(),tpass.getText(),tfname.getText(),tmno.getText(),data1,calculateAge(ans));
                }
            else {
                JOptionPane.showMessageDialog(this, "All fields are required !","Warning" ,JOptionPane.ERROR_MESSAGE);
            }
            }
            else {
                tout.setText("");
                res.setText("Please accept the"
                        + " terms & conditions..");
            }
        }
        else if (e.getSource() == reset) {
            String def = "";
            tname.setText(def);
            tfname.setText(def);
            tmno.setText(def);
            res.setText(def);
            tout.setText(def);
            term.setSelected(false);
            date.setSelectedIndex(0);
            month.setSelectedIndex(0);
            year.setSelectedIndex(0);
        }
    }
    public static int calculateAge(String dob) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        try {
            Date birthDate = dateFormat.parse(dob);
            Date currentDate = new Date();
            long timeDifference = currentDate.getTime() - birthDate.getTime();
            long years = timeDifference / (1000L * 60 * 60 * 24 * 365);
            return (int) years;
        } catch (ParseException e) {
            e.printStackTrace();
            return -1;
        }
    }
}