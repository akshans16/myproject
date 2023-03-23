import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class TeacherDetails extends JFrame implements ActionListener {

    Choice eEmpId;
    JTable table;
    JButton search, print, add, cancel, delete, refresh;

    TeacherDetails() {

        getContentPane().setBackground(Color.PINK);
        setTitle("Teacher Details Page");
        setLayout(null);

        JLabel heading = new JLabel("Search by Employee ID");
        heading.setBounds(20, 20, 150, 20);
        add(heading);

        eEmpId = new Choice();
        eEmpId.setBounds(180, 20, 150, 20);
        add(eEmpId);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from techer");
            while (rs.next()) {
                eEmpId.add(rs.getString("emp_ID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();
        table.setBackground(Color.PINK);
        table.setFillsViewportHeight(true);
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from techer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* Setting coloum width */
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setPreferredWidth(60);
        table.getColumnModel().getColumn(2).setPreferredWidth(70);
        table.getColumnModel().getColumn(3).setPreferredWidth(70);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);
        table.getColumnModel().getColumn(5).setPreferredWidth(100);
        table.getColumnModel().getColumn(8).setPreferredWidth(120);

        JScrollPane jsp = new JScrollPane(table);
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
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String query = "select * from techer where emp_ID = '" + eEmpId.getSelectedItem() + "'";
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
            String query = "DELETE FROM STUDENT WHERE emp_ID = '" + eEmpId.getSelectedItem() + "'";
            try {
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Selected faculty has been deleted");

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == refresh) {
            dispose();
            new TeacherDetails();
        } else {
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
        new TeacherDetails();
    }
}