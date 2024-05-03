import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ShowComment extends JFrame {
    private ImageIcon ImageSize(ImageIcon image,int with,int height ) {
        Image scaledImage = image.getImage().getScaledInstance(with, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }
    private static final Color Bcolor2=new Color(12, 12, 52);
    FileDeal ff =new FileDeal();
    private static final Color Bcolor3=new Color(138, 138, 138);
    Container c;
    JLabel title;
    JTable MoveList;
    JScrollPane scrollPane;
    public ShowComment()
    {
        setBackground(Bcolor2);
        setTitle("Show Comments");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        c = this.getContentPane();
        c.setLayout(null);
        title = new JLabel("Show Comments");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setSize(400, 30);
        title.setLocation(260, 28);
        title.setForeground(Bcolor3);
        ArrayList<String[]>AllData=new ArrayList<>();
        try {
          AllData= ff.readStr(Main.path+"\\Comment.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String[][] data = new String[AllData.size()][4];
        int j=0;
        for(var i :AllData )
        {
            data[j]=i;
            j++;
        }
        // Column Names
        String[] columnNames = { "Name", "Move Name", "Comments","Number of Star" };
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Make all cells non-editable
                return false;
            }
        };
        MoveList = new JTable(model);
        MoveList.setBounds(120, 90, 120, 300);
        MoveList.setBackground(Bcolor3);
        MoveList.setForeground(Bcolor2);
        // adding it to JScrollPane
        scrollPane = new JScrollPane(MoveList);
        scrollPane.setSize(900, 300);
        scrollPane.setLocation(0, 120);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setForeground(Bcolor2);
        scrollPane.setBackground(Bcolor2);
        c.add(scrollPane);
        c.add(title);
        c.setBackground(Bcolor2);
    }
}