import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
import java.sql.*;
import java.awt.*;
import net.proteanit.sql.*;

public class FeeStruct extends JFrame{
    
    JTable table;

    

    FeeStruct(){

        /* Creating main heading */
        JLabel mainHeading = new JLabel("Fee Structure");
        mainHeading.setBounds(120,0,170,25);
        mainHeading.setFont(new Font("Calibri(Body)", Font.BOLD, 25));
        mainHeading.setForeground(Color.BLACK);
        add(mainHeading);

        /* Line separator */
        JSeparator s = new JSeparator();
        s.setOrientation(SwingConstants.HORIZONTAL);
        s.setBounds(0, 30, 400, 2);
        s.setForeground(Color.BLACK);
        add(s);

        /* Creating table */
        table = new JTable();
        table.setFillsViewportHeight(true);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from FeeStructure");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 30, 400, 300);
        add(jsp);

        TableColumnModel cm = table.getColumnModel();
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        cm.getColumn(0).setCellRenderer(cellRenderer);
        cm.getColumn(1).setCellRenderer(cellRenderer);

        table.getTableHeader().setFont(new Font("Calibri(Body)", Font.BOLD, 14));
        table.getTableHeader().setForeground(Color.BLACK);
        table.getTableHeader().setBackground(Color.PINK);

        table.setBackground(Color.PINK);

        /* Creating main frame */
        setResizable(false);
        setLayout(null);
        setSize(400,300);
        setLocation(440,130);
        getContentPane().setBackground(Color.PINK);
        setVisible(true);
    }
    public static void main(String[] args) {
        new FeeStruct();
    }
}
