import javax.swing.*;
import javax.swing.border.LineBorder;
import net.proteanit.sql.DbUtils;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class CheckResult extends JFrame implements ActionListener{

    JTextField rollNoF;
    JButton check, cancel;
    JTable table;

    CheckResult() {

        /* Creating line Border ----------> */
        LineBorder lb = new LineBorder(Color.BLACK, 1, true);

        /* Roll number heading */
        JLabel rollH = new JLabel("Roll Number");
        rollH.setFont(new Font("Calibri(Head)",Font.BOLD,18));
        rollH.setBounds(50, 35, 120, 20);
        add(rollH);
        /* Roll Number textField */
        rollNoF = new JTextField();
        rollNoF.setBounds(200, 35, 100, 20);
        add(rollNoF);
        
        /* creating buttons */

        check = new JButton("Check Result");
        check.setFont(new Font("Bell MT", Font.BOLD, 18));
        check.setBackground(Color.CYAN);
        check.setForeground(Color.BLACK);
        check.setBorder(lb);
        check.addActionListener(this);
        check.setBounds(320, 30, 150, 30);
        add(check);

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Bell MT", Font.BOLD, 18));
        cancel.setBackground(Color.CYAN);
        cancel.setForeground(Color.BLACK);
        cancel.setBorder(lb);
        cancel.addActionListener(this);
        cancel.setBounds(490, 30, 150, 30);
        add(cancel);

        /* Creating Student details table */
        
        table = new JTable();
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setPreferredWidth(60);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(60);
        table.getColumnModel().getColumn(5).setPreferredWidth(110);
        table.getColumnModel().getColumn(10).setPreferredWidth(140);
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 80, 900, 500);
        add(jsp);

        /* Adding mouse listener to table */
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                int row = table.getSelectedRow();
                rollNoF.setText(table.getModel().getValueAt(row, 9).toString());
            }
        });

        /* Main Frame Setting */
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setTitle("Check Result Page");
        setLocation(240,60);
        setSize(900, 600);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new CheckResult();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == check) {
            new ShowResult(rollNoF.getText());
        }
        else {
            setVisible(false);
        }
        
    }
}
