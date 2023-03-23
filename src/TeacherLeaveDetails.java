import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class TeacherLeaveDetails extends JFrame implements ActionListener {

    Choice crollno;
    JTable table;
    JButton search, print, update, add, cancel;
    DefaultTableCellRenderer cellRenderer;

    TeacherLeaveDetails() {

        getContentPane().setBackground(Color.PINK);
        setLayout(null);

        /* creating border */
        Border b = new LineBorder(Color.BLACK,1,true);

        JLabel mainHeading = new JLabel("Teacher Leave Details");
        mainHeading.setBounds(200, 10, 450, 40);
        mainHeading.setFont(new Font("Adobe Gothic Std B", Font.BOLD, 20));
        mainHeading.setForeground(Color.BLACK);
        add(mainHeading);

        /* Line Separator */

        JSeparator s = new JSeparator();
        s.setOrientation(SwingConstants.HORIZONTAL);
        s.setBounds(0, 50, 700, 10);
        s.setForeground(Color.RED);
        add(s);

        JLabel heading = new JLabel("Search by Emp ID");
        heading.setBounds(150, 80, 130, 20);
        heading.setFont(new Font("Calibri(Body)", Font.BOLD, 14));
        heading.setForeground(Color.BLACK);
        add(heading);

        crollno = new Choice();
        crollno.setBounds(280, 80, 150, 20);
        crollno.setBackground(Color.PINK);
        crollno.setForeground(Color.BLACK);
        add(crollno);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacherleave");
            while (rs.next()) {
                crollno.add(rs.getString("emp_ID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();
        table.setBackground(Color.PINK);
        table.setFillsViewportHeight(true);
        
        table.getTableHeader().setBorder(b);
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacherleave");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        //table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumnModel cm = table.getColumnModel();
        cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        cm.getColumn(0).setCellRenderer(cellRenderer);
        cm.getColumn(1).setCellRenderer(cellRenderer);
        cm.getColumn(2).setCellRenderer(cellRenderer);
        cm.getColumn(3).setCellRenderer(cellRenderer);
        cm.getColumn(4).setCellRenderer(cellRenderer);

        cm.getColumn(0).setPreferredWidth(100);
        cm.getColumn(1).setPreferredWidth(100);
        cm.getColumn(2).setPreferredWidth(100);
        cm.getColumn(3).setPreferredWidth(80);
        cm.getColumn(4).setPreferredWidth(100);

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 160, 586, 500);
        jsp.setForeground(Color.PINK);
        add(jsp);

        search = new JButton("Search");
        search.setBounds(56, 120, 80, 20);
        search.setBorder(b);
        search.setFont(new Font("Calibri(Body)", Font.BOLD, 12));
        search.setForeground(Color.BLACK);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(192, 120, 80, 20);
        print.setBorder(b);
        print.setFont(new Font("Calibri(Body)", Font.BOLD, 12));
        print.setForeground(Color.BLACK);
        print.addActionListener(this);
        add(print);

        add = new JButton("Add");
        add.setBounds(328, 120, 80, 20);
        add.setBorder(b);
        add.setFont(new Font("Calibri(Body)", Font.BOLD, 12));
        add.setForeground(Color.BLACK);
        add.addActionListener(this);
        add(add);


        cancel = new JButton("Cancel");
        cancel.setBounds(464, 120, 80, 20);
        cancel.setBorder(b);
        cancel.setFont(new Font("Calibri(Body)", Font.BOLD, 12));
        cancel.setForeground(Color.BLACK);
        cancel.addActionListener(this);
        add(cancel);

        setTitle("Teacher Leave Details");
        setResizable(false);
        setSize(600, 600);
        setLocation(340, 60);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String query = "select * from teacherleave where emp_ID = '" + crollno.getSelectedItem() + "'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == print) {
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == add) {
            setVisible(false);
            new StudentLeave();
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new TeacherLeaveDetails();
    }
}