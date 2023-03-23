import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Date;
import java.sql.*;
import java.awt.event.*;

public class StudentLeave extends JFrame implements ActionListener {

    Choice crollno;
    ButtonGroup checkboxes;
    JTextField nameF;
    JButton submit, cancel;
    JCheckBox box1, box2, box3;
    JFormattedTextField firstDateF, lastDateF;
    Border b, textB;

    StudentLeave() {
        /* Border */
        b = new LineBorder(Color.BLACK, 1, true);
        textB = new LineBorder(Color.BLACK, 1, true);
        /* First Heading */

        JLabel heading = new JLabel("Student Leave Application Form");
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

        JLabel enterName = returnLabel("Enter Your Name", 40, 100, 150, 20, 15);
        add(enterName);

        nameF = new JTextField("");
        nameF.setBorder(textB);
        nameF.addActionListener(this);
        nameF.setOpaque(false);
        nameF.setFont(new Font("Calibri (Body)", Font.BOLD, 12));
        nameF.setBounds(210, 100, 120, 20);

        add(nameF);

        /* Select Roll Number */
        JLabel rollF = returnLabel("Select your roll no", 350, 100, 150, 25, 15);
        add(rollF);

        crollno = new Choice();
        crollno.setBounds(520, 100, 120, 20);
        crollno.setBackground(Color.PINK);
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

        /* Enter first and last date of absence */

        JLabel firstDate = returnLabel("First Date Of Absence", 40, 160, 170, 20, 15);
        add(firstDate);

        firstDateF = fFields(210, 160, 120, 20);
        add(firstDateF);

        JLabel lastDate = returnLabel("Last Date Of Absence", 350, 160, 170, 25, 15);
        add(lastDate);

        lastDateF = fFields(520, 160, 120, 20);
        add(lastDateF);

        /* Reason for absence */

        JLabel reason = returnLabel("Reason For Absence", 40, 220, 160, 20, 15);
        add(reason);

        box1 = returnBox("Emergency Leave",345, 220, 160, 20);
        add(box1);

        box2 = returnBox("Casual Leave", 210, 220, 130, 20);
        add(box2);

        box3 = returnBox("Other", 515, 220, 70, 20);
        add(box3);

        /* Adding button to checkbuttons */
        checkboxes = new ButtonGroup();

        checkboxes.add(box1);
        checkboxes.add(box2);
        checkboxes.add(box3);

        /* Buttons */

        submit = returnButton("Submit", 200, 300, 100, 20);
        add(submit);

        cancel = returnButton("Cancel", 400, 300, 100, 20);
        add(cancel);

        /* Main frame setting */

        setTitle("Student Leave Application Page");
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
                    String Roll_No = (String) crollno.getSelectedItem();
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

                    String query = "insert into studentleave values('" + Name + "','" + Roll_No + "','" + firstDate
                            + "','" + lastDate + "','" + reason + "')";
                    Conn con = new Conn();
                    con.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Your Leave is Confirmed");
                    dispose();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            dispose();
        }

    }

    public JButton returnButton(String name, int x, int y, int width, int height) {
        JButton button = new JButton(name);
        button.setFont(new Font("Calibri (Body)", Font.BOLD, 15));
        button.setForeground(Color.BLACK);
        button.setBounds(x, y, width, height);
        button.setBorder(b);
        button.addActionListener(this);
        return button;
    }

    public JFormattedTextField fFields(int x, int y, int width, int height) {
        JFormattedTextField field = new JFormattedTextField(new Date());
        field.setBounds(x, y, width, height);
        field.setHorizontalAlignment(JTextField.CENTER);
        field.setBorder(textB);
        field.setFont(new Font("Calibri (Body)", Font.BOLD, 12));
        field.setOpaque(false);
        return field;
    }

    public JLabel returnLabel(String name, int x, int y, int width, int height, int size) {
        JLabel lbl = new JLabel(name);
        lbl.setBounds(x, y, width, height);
        lbl.setFont(new Font("Calibri (Body)", Font.BOLD, size));
        lbl.setForeground(Color.BLACK);
        return lbl;
    }

    public JCheckBox returnBox(String name, int x, int y, int width, int height) {
        JCheckBox box = new JCheckBox(name);
        box.setBounds(x, y, width, height);
        box.setOpaque(false);
        box.setFont(new Font("Calibri (Body)", Font.BOLD, 15));
        box.setForeground(Color.BLACK);
        return box;
    }

    public static void main(String[] args) {
        new StudentLeave();
    }

}
