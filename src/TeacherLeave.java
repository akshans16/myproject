import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Date;
import java.sql.*;
import java.awt.event.*;

public class TeacherLeave extends JFrame implements ActionListener {

    Choice cEmpID;
    ButtonGroup checkboxes;
    JTextField nameF;
    JButton submit, cancel;
    JCheckBox box1, box2, box3;
    JFormattedTextField firstDateF, lastDateF;

    TeacherLeave() {
        /* Border */
        Border b = new LineBorder(Color.BLACK, 1, true);
        Border textB = new LineBorder(Color.BLACK, 1, true);
        /* First Heading */

        JLabel heading = new JLabel("Teacher Leave Application Form");
        heading.setBounds(200, 10, 450, 40);
        heading.setFont(new Font("Calibri (Body)", Font.BOLD, 20));
        heading.setForeground(Color.BLACK);
        add(heading);

        /* Line Separator */

        JSeparator s = new JSeparator();
        s.setOrientation(SwingConstants.HORIZONTAL);
        s.setBounds(0, 50, 700, 10);
        s.setForeground(Color.RED);
        add(s);

        /* Enter name */

        JLabel enterName = new JLabel("Enter Your Name");
        enterName.setBounds(40, 100, 150, 20);
        enterName.setFont(new Font("Calibri (Body)", Font.BOLD, 15));
        enterName.setForeground(Color.BLACK);
        add(enterName);

        nameF = new JTextField("");
        nameF.setBorder(textB);
        nameF.addActionListener(this);
        nameF.setOpaque(false);
        nameF.setFont(new Font("Calibri (Body)", Font.BOLD, 12));
        nameF.setBounds(210, 100, 120, 20);

        add(nameF);

        /* Select Roll Number */
        JLabel rollF = new JLabel("Select Your Emp ID");
        rollF.setBounds(350, 100, 150, 25);
        rollF.setFont(new Font("Calibri (Body)", Font.BOLD, 15));
        rollF.setForeground(Color.BLACK);
        add(rollF);

        cEmpID = new Choice();
        cEmpID.setBounds(520, 100, 120, 20);
        cEmpID.setBackground(Color.PINK);
        add(cEmpID);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from techer");
            while (rs.next()) {
                cEmpID.add(rs.getString("emp_ID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* Enter first and last date of absence */

        JLabel firstDate = new JLabel("First Date Of Absence");
        firstDate.setBounds(40, 160, 170, 20);
        firstDate.setFont(new Font("Calibri (Body)", Font.BOLD, 15));
        firstDate.setForeground(Color.BLACK);
        add(firstDate);

        firstDateF = new JFormattedTextField(new Date());
        firstDateF.setBorder(textB);
        firstDateF.setBounds(210, 160, 120, 20);
        firstDateF.setOpaque(false);
        firstDateF.setHorizontalAlignment(JLabel.CENTER);
        firstDateF.setFont(new Font("Calibri (Body)", Font.BOLD, 12));
        add(firstDateF);

        JLabel lastDate = new JLabel("Last Date Of Absence");
        lastDate.setBounds(350, 160, 170, 25);
        lastDate.setFont(new Font("Calibri (Body)", Font.BOLD, 15));
        lastDate.setForeground(Color.BLACK);
        add(lastDate);

        lastDateF = new JFormattedTextField(new Date());
        lastDateF.setBounds(520, 160, 120, 20);
        lastDateF.setHorizontalAlignment(JLabel.CENTER);
        lastDateF.setBorder(textB);
        lastDateF.setFont(new Font("Calibri (Body)", Font.BOLD, 12));
        lastDateF.setOpaque(false);
        add(lastDateF);

        /* Reason for absence */

        JLabel reason = new JLabel("Reason For Absence");
        reason.setBounds(40, 220, 170, 20);
        reason.setFont(new Font("Calibri (Body)", Font.BOLD, 15));
        reason.setForeground(Color.BLACK);
        add(reason);

        box1 = new JCheckBox("Emergency Leave");
        box1.setBounds(345, 220, 170, 20);
        box1.setOpaque(false);
        box1.setFont(new Font("Calibri (Body)", Font.BOLD, 15));
        box1.setForeground(Color.BLACK);

        add(box1);

        box2 = new JCheckBox("Casual Leave");
        box2.setBounds(210, 220, 120, 20);
        box2.setOpaque(false);
        box2.setBorder(null);
        box2.setFont(new Font("Calibri (Body)", Font.BOLD, 15));
        box2.setForeground(Color.BLACK);

        add(box2);

        box3 = new JCheckBox("Other");
        box3.setBounds(515, 220, 70, 20);
        box3.setOpaque(false);
        box3.setFont(new Font("Calibri (Body)", Font.BOLD, 15));
        box3.setForeground(Color.BLACK);

        add(box3);

        /* Adding button to checkbuttons */
        checkboxes = new ButtonGroup();

        checkboxes.add(box1);
        checkboxes.add(box2);
        checkboxes.add(box3);

        /* Buttons */

        submit = new JButton("Submit");
        submit.setFont(new Font("Calibri (Body)", Font.BOLD, 15));
        submit.setForeground(Color.BLACK);
        submit.setBounds(200, 300, 100, 20);
        submit.addActionListener(this);
        submit.setBorder(b);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Calibri (Body)", Font.BOLD, 15));
        cancel.setForeground(Color.BLACK);
        cancel.setBounds(400, 300, 100, 20);
        cancel.setBorder(b);
        cancel.addActionListener(this);
        add(cancel);

        /* Main frame setting */

        setTitle("Teacher Leave Application Page");
        setResizable(false);
        getContentPane().setBackground(Color.PINK);
        setSize(700, 400);
        setLocation(320, 120);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == submit) {
            if (nameF.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please Enter Your Name");
            } else if (!box1.isSelected() && !box2.isSelected() && !box3.isSelected()) {
                JOptionPane.showMessageDialog(null, "Please check your reason for absence");
            } else {
                try {
                    String Name = nameF.getText();
                    String empID = (String) cEmpID.getSelectedItem();
                    String firstDate = firstDateF.getText();
                    String lastDate = lastDateF.getText();
                    String reason;
                    if (box1.isSelected()) {
                        reason = box1.getText();
                    } else if (box2.isSelected()) {
                        reason = box2.getText();
                    } else {
                        reason = box3.getText();
                    }

                    String query = "insert into teacherleave values('" + Name + "','" + empID + "','" + firstDate
                            + "','" + lastDate + "','" + reason + "')";
                    Conn con = new Conn();
                    con.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Your Leave is Confirmed");
                    setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new TeacherLeave();
    }

}
