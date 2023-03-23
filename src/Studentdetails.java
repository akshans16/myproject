import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class Studentdetails extends JFrame implements ActionListener {

    Choice crollno;
    JTable table;
    JButton search, print, add, cancel, delete,refresh;

    Studentdetails() {

        getContentPane().setBackground(Color.PINK);
        setLayout(null);

        JLabel heading = new JLabel("Search by Roll Number");
        heading.setBounds(20, 20, 150, 20);
        add(heading);

        crollno = new Choice();
        crollno.setBounds(180, 20, 150, 20);
        add(crollno);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while (rs.next()) {
                crollno.add(rs.getString("Roll_No"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();
        table.setBackground(Color.PINK);
        table.setFillsViewportHeight(true);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* Setting coloum width */
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setPreferredWidth(60);
        table.getColumnModel().getColumn(2).setPreferredWidth(80);
        table.getColumnModel().getColumn(4).setPreferredWidth(50);
        table.getColumnModel().getColumn(5).setPreferredWidth(120);
        table.getColumnModel().getColumn(10).setPreferredWidth(130);

        JScrollPane jsp = new JScrollPane(table);
        jsp.setForeground(Color.PINK);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);

        /* Adding Buttons to frame */
        search = addButton("Search", 20, 70, 80, 20);
        add(search);
        print = addButton("Print", 120, 70, 80, 20);
        add(print);
        add = addButton("Add", 220, 70, 80, 20);
        add(add);
        delete = addButton("Delete", 320, 70, 80, 20);
        add(delete);
        refresh = addButton("Refresh", 420, 70, 80, 20);
        add(refresh);
        cancel = addButton("Cancel", 520, 70, 80, 20);
        add(cancel);
        

        setSize(910, 600);
        setLocation(180, 60);
        setTitle("Student Details Page");
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String query = "select * from student where Roll_No = '" + crollno.getSelectedItem() + "'";
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
            dispose();
            new AddStudent();
        } else if (ae.getSource() == delete) {
            String query = "DELETE FROM STUDENT WHERE Roll_No = '" + crollno.getSelectedItem()+"'";
            try {
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Selected student has been deleted");

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == refresh) {
            dispose();
            new Studentdetails();
        }

        else {
            dispose();
        }
    }

    public JButton addButton(String name, int x, int y, int width, int height) {
        JButton button = new JButton(name);
        button.setBounds(x, y, width, height);
        button.addActionListener(this);
        return button;
    }

    public static void main(String[] args) {
        new Studentdetails();
    }
}