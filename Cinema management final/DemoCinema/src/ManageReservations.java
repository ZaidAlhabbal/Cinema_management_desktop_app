import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ManageReservations extends JFrame {
    private ImageIcon ImageSize(ImageIcon image,int with,int height ) {
        Image scaledImage = image.getImage().getScaledInstance(with, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }
    String[][] data2z;
     public void setMovie(ArrayList<String[]> a)
    {
        int n=a.size(),j=0;
        String[][] data=new String [n][4];
        String[][] data2=new String [n][4];
        for(var i:a)
        {
            data[j]= i;
            j++;
        }
        for (int i = 0; i < n; i++) {
            data2[i][0]="";
            data2[i][1]="";
            data2[i][2]="";
            data2[i][3]="";
            data2[i][0]+= data[i][0];
            data2[i][0]+= data[i][1];
            data2[i][0]+= data[i][2];
            data2[i][1]+= data[i][3];
            data2[i][2]+= data[i][2];
            data2[i][3]+= Main.timeConverter2.get(Integer.parseInt(data[i][1]));
        }
        this.data2z=data2;
    }

    FileDeal ff=new FileDeal();
    private static final Color Bcolor2=new Color(12, 12, 52);
    private static final Color Bcolor3=new Color(138, 138, 138);
    private static final Color Bcolor4=new Color(49, 161, 211);

    Container c;
    JLabel title,Text;
    JTable MoveList;
    JScrollPane scrollPane;
    JTextField MoveId;
    JButton cancel;
    public ManageReservations()
    {
        setBackground(Bcolor2);
        setTitle("Manage reservations");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        c = this.getContentPane();
        c.setLayout(null);
        title = new JLabel("Manage reservations");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setSize(400, 30);
        title.setLocation(260, 28);
        title.setForeground(Bcolor3);
        ArrayList<String[]> a=new ArrayList<>();
        try {
          a=  ff.readStr(Main.path+"\\"+UserAccountScreen.getUserName()+UserAccountScreen.getFatherUserName()+"\\UserTickets.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        setMovie(a);
        String[] columnNames = { "ID", "Move Name", "Seat Number","Show Time" };
        DefaultTableModel model = new DefaultTableModel(data2z, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Make all cells non-editable
                return false;
            }
        };
        MoveList = new JTable(model);
        MoveList.setBounds(120, 90, 120, 200);
        MoveList.setBackground(Bcolor3);
        MoveList.setForeground(Bcolor2);
        // adding it to JScrollPane
        scrollPane = new JScrollPane(MoveList);
        scrollPane.setSize(900, 200);
        scrollPane.setLocation(0, 120);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setForeground(Bcolor2);
        scrollPane.setBackground(Bcolor2);
        MoveId = new JTextField();
        MoveId.setSize(50, 25);
        MoveId.setLocation(582, 474);
        MoveId.setFont(new Font("Arial", Font.PLAIN, 15));
        MoveId.setCaretColor(Color.white);
        MoveId.setForeground(Color.BLACK);
        MoveId.setBackground(Bcolor3);
        cancel = new JButton();
        //cancellation of reservation
        cancel.setText("Ok");
        cancel.setFont(new Font("Arial", Font.BOLD, 15));
        cancel.setSize(60,25);//width height
        cancel.setLocation(655,474);
        cancel.setBackground(Bcolor2);
        cancel.setForeground(Color.white);
        cancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                cancel.setBackground(Color.red); // Change color on hover
            }

            @Override
            public void mouseExited(MouseEvent e) {
                cancel.setBackground(null); // Revert to original color when mouse leaves
            }
        });
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show a confirmation dialog
                int result = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to cancel your reservation?", "Alert", JOptionPane.YES_NO_OPTION);
                // Check the user's choice
                if (result == JOptionPane.YES_OPTION) {
                    if(!MoveId.getText().isEmpty())
                    {
                        //Cancel do
                        try {
                            Ticketing t2 = new Ticketing();
                            Cancel c = new Cancel(t2, MoveId.getText());
                            Thread t = new Thread(c);
                            t.start();
                            t.join();
                            if (Cancel.ans) {
                                JOptionPane.showMessageDialog(null,
                                        "Your reservation has been successfully cancelled ", "mission accomplished", JOptionPane.INFORMATION_MESSAGE);
                                MoveId.setText("");
                                try {
                                    ArrayList<String[]> a = new ArrayList<>();
                                    a = ff.readStr(Main.path + "\\" + UserAccountScreen.getUserName() + UserAccountScreen.getFatherUserName() + "\\UserTickets.txt");
                                    setMovie(a);
                                    DefaultTableModel model1 = new DefaultTableModel(data2z, columnNames) {
                                        @Override
                                        public boolean isCellEditable(int row, int column) {
                                            // Make all cells non-editable
                                            return false;
                                        }
                                    };
                                    model.setRowCount(0);
                                    for (int row = 0; row < model1.getRowCount(); row++) {
                                        Object[] rowData = new Object[model1.getColumnCount()];
                                        for (int col = 0; col < model1.getColumnCount(); col++) {
                                            rowData[col] = model1.getValueAt(row, col);
                                        }
                                        model.addRow(rowData);
                                    }
                                } catch (Exception ex) {
                                    throw new RuntimeException(ex);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "No such ID exists", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Please enter the Movies ID", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        Text = new JLabel("Enter the Move ID you want to Cancel:");
        Text.setFont(new Font("Arial", Font.BOLD, 25));
        Text.setSize(550, 30);
        Text.setLocation(60, 470);
        Text.setForeground(Bcolor3);
        c.add(scrollPane);
        c.add(MoveId);
        c.add(Text);
        c.add(cancel);
        c.add(title);
        c.setBackground(Bcolor2);
    }
}