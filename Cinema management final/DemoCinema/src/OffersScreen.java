import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.MouseInputAdapter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class OffersScreen extends JFrame {
        private static final Color Bcolor2 = new Color(12, 12, 52);
        private static final Color Bcolor3 = new Color(138, 138, 138);
        private static final Color Bcolor4 = new Color(49, 161, 211);
        FileDeal ff=new FileDeal();
        JLabel BusyTimes,Times;
        int t1,t2,t3;

        OffersScreen() {
                setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                Container c = new Container();
                setVisible(true);
                setResizable(false);
                setBounds(500, 150, 600, 500);
                c = this.getContentPane();
                c.setBackground(Bcolor2);
                c.setForeground(Bcolor3);
                c.setSize(600, 500);
                c.setVisible(true);
                c.setLayout(null);
                BusyTimes =new JLabel();
                BusyTimes.setText("The Three most popular times :");
                BusyTimes.setFont(new Font("Arial", Font.BOLD, 18));
                BusyTimes.setBounds(8,200,290,40);
                BusyTimes.setForeground(Bcolor4);
                BusyTimes.setBackground(Bcolor4);
                BusyTimes.setVisible(true);
                int []time=MovieRating.generateBusyTimesReport();
                int []time2=MovieRating.generateBusyTimesReport();
                Arrays.sort(time2);
                for(int i=0;i<8;i++)
                {
                    if(time[i]==time2[7])
                        t1=i;
                    else if(time[i]==time2[6])
                        t2=i;
                    else if(time[i]==time2[5])
                        t3=i;
                }
                Times =new JLabel();
                Times.setText("1_"+Main.timeConverter2.get(t1+1)+"/ 2_"+Main.timeConverter2.get(t2+1)+"/ 3_"+Main.timeConverter2.get(t3+1));
                Times.setFont(new Font("Arial", Font.BOLD, 15));
                Times.setBounds(290,200,290,40);
                Times.setForeground(Bcolor4);
                Times.setBackground(Bcolor4);
                Times.setVisible(true);
                c.add(BusyTimes);
                c.add(Times);
            ArrayList<String[]>a=new ArrayList<>();
                String[] colum = {"Special offers"};
                try {
                     a=ff.readStr(Main.path+"\\Movies.txt");
                } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                }
            String[][] data2=new String[a.size()][1];
            String[][] data=new String[a.size()][6];
                int  j=0;
                for (var i:a)
                {
                        data[j]=i;
                        j++;
                }
                for (int i = 0,j1=0; (i < a.size() && j1<6); i+=4,j1++) {
                                data2[j1][0] = data[i][1];
                }
                DefaultTableModel defaultTableModel = new DefaultTableModel(data2, colum) {
                        @Override
                        public boolean isCellEditable(int row, int column) {
                                // Make all cells non-editable
                                return false;
                        }
                };
                JTable table = new JTable(defaultTableModel);
                table.setBackground(Bcolor2);
                table.setForeground(Bcolor3);
                JScrollPane scrollPane = new JScrollPane(table);
                scrollPane.setBounds(0,30,600, 150);
                scrollPane.setVisible(true);
                scrollPane.setBackground(Bcolor2);
                scrollPane.setForeground(Bcolor3);
                c.add(scrollPane);
                String[] colum1 = {"The most popular Movie"};
                String[][] data1 =new String[6][1];
                data=new String[a.size()][6];
                String[][] data3=new String[a.size()][6];
                j=0;
                for (var i:a)
                {
                        data[j]=i;
                        j++;
                }
                for (int i = 3,j1=0; (i < a.size() && j1<6); i+=4,j1++) {
                        data3[j1][0] = data[i][1];
                }
                DefaultTableModel defaultTableModel1 = new DefaultTableModel(data3, colum1) {
                        @Override
                        public boolean isCellEditable(int row, int column) {
                                // Make all cells non-editable
                                return false;
                        }
                };
                table.addMouseListener(new MouseInputAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                                if (e.getClickCount() == 2) { // Double-click event
                                        int row = table.getSelectedRow();
                                        if (row != -1) {
                                                ArrayList<String[]> a = new ArrayList<>();
                                                FileDeal f = new FileDeal();
                                                try {
                                                        a = f.readStr(Main.path + "\\Movies.txt");
                                                } catch (FileNotFoundException ex) {
                                                        throw new RuntimeException(ex);
                                                }
                                                if(row<6) {
                                                    ReservationScreen z = new ReservationScreen(HomeScreen.ima[(row * 4)], a.get(row * 4), "20");
                                                }
                                                else {
                                                JOptionPane.showMessageDialog(null,"You must choose from the list","Error",JOptionPane.ERROR_MESSAGE);
                                            }
                                        }
                                }
                        }
                });
                JTable table1 = new JTable(defaultTableModel1);
                JScrollPane scrollPane1 = new JScrollPane(table1);
                scrollPane1.setBounds(0, 267, 600, 150);
                scrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
                scrollPane.setVisible(true);
                c.add(scrollPane1);
                table1.addMouseListener(new MouseInputAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                                if (e.getClickCount() == 2) { // Double-click event
                                        int row = table1.getSelectedRow();
                                        if (row != -1) {
                                                ArrayList<String[]> a = new ArrayList<>();
                                                FileDeal f = new FileDeal();
                                                try {
                                                        a = f.readStr(Main.path + "\\Movies.txt");
                                                } catch (FileNotFoundException ex) {
                                                        throw new RuntimeException(ex);
                                                }
                                                if(row <= 5)
                                                {
                                                        ReservationScreen z = new ReservationScreen(HomeScreen.ima[3+(row*4)], a.get(3+(row*4)),"40");
                                                }
                                                else {
                                                        JOptionPane.showMessageDialog(null,"You must choose from the list","Error",JOptionPane.ERROR_MESSAGE);
                                                }
                                        }
                                }
                        }
                });
                table1.setForeground(Bcolor3);
                table1.setBackground(Bcolor2);
                scrollPane1.setBackground(Bcolor2);
                scrollPane1.setForeground(Bcolor3);
            }
}