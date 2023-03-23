import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class FeeForm extends JFrame implements ActionListener {

    Choice crollno,cbcourses;
    JComboBox<String> cbyear;
    JButton pay,cancel;

    FeeForm() {

        /* Main heading */
        JLabel feePayment  = new JLabel("Fee Payment");
        feePayment.setBounds(100, 0, 200, 40);
        feePayment.setFont(new Font("Calibri(Body)", Font.BOLD, 30));
        feePayment.setBackground(Color.ORANGE);
        feePayment.setForeground(Color.BLACK);
        add(feePayment);

        /* Line Seperator */
        JSeparator s = new JSeparator();
        s.setOrientation(SwingConstants.HORIZONTAL);
        s.setBounds(0, 50, 400, 2);
        s.setForeground(Color.BLACK);
        add(s);

        /* creating border */
        LineBorder lb = new LineBorder(Color.BLACK,1,true);
        /* Select roll no label */
        JLabel cRollNo = new JLabel("Roll No");
        cRollNo.setBounds(100, 100, 100, 20);
        cRollNo.setFont(new Font("Calibri(Body)", Font.BOLD, 20));
        cRollNo.setForeground(Color.BLACK);
        add(cRollNo);

        /* roll no choice box */
        crollno = new Choice();
        crollno.setBounds(200, 100, 100, 20);
        crollno.setForeground(Color.BLACK);
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

        /* Fetch name and course according to selected roll no */
        JLabel name = new JLabel("Name");
        name.setBounds(100, 140, 100, 20);
        name.setFont(new Font("Calibri(Body)", Font.BOLD, 20));
        name.setForeground(Color.BLACK);
        add(name);

        JLabel namef = new JLabel();
        namef.setBounds(200, 140, 150, 20);
        namef.setFont(new Font("Calibri(Body)", Font.BOLD, 20));
        namef.setForeground(Color.BLACK);
        add(namef);

        JLabel course = new JLabel("Course");
        course.setBounds(100, 180, 100, 20);
        course.setFont(new Font("Calibri(Body)", Font.BOLD, 20));
        course.setForeground(Color.BLACK);
        add(course);

        cbcourses = new Choice();
        cbcourses.setBounds(200, 180, 100, 20);
        cbcourses.setForeground(Color.BLACK);
        add(cbcourses);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from FeeStructure");
            while (rs.next()) {
                cbcourses.add(rs.getString("Name_Of_Class"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* Setting textfield according to selected roll number */

        try {
            Conn c = new Conn();
            String query = "select * from student where Roll_No='" + crollno.getSelectedItem() + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                namef.setText(rs.getString("name"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        crollno.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from student where Roll_No='" + crollno.getSelectedItem() + "'";
                    ResultSet rs = c.s.executeQuery(query);
                    while (rs.next()) {
                        namef.setText(rs.getString("name"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        /* creating year selecting box */
        JLabel year = new JLabel("Year");
        year.setBounds(100, 220, 100, 20);
        year.setFont(new Font("Calibri(Body)", Font.BOLD, 20));
        year.setForeground(Color.BLACK);
        add(year);

        String[] years = { "1st year", "2nd year", "3rd year", "4th year" };
        cbyear = new JComboBox<>(years);
        cbyear.setBounds(200, 220, 100, 20);
        cbyear.setFont(new Font("Calibri(Body)", Font.BOLD, 14));
        add(cbyear);

        /* creating amount label */
        JLabel amount = new JLabel("Amount");
        amount.setBounds(100, 260, 100, 20);
        amount.setFont(new Font("Calibri(Body)", Font.BOLD, 20));
        amount.setForeground(Color.BLACK);
        add(amount);

        JLabel amountL = new JLabel();
        amountL.setBounds(200, 260, 100, 20);
        amountL.setFont(new Font("Calibri(Body)", Font.BOLD, 20));
        amountL.setForeground(Color.BLACK);
        add(amountL);

        /* Setting amount according to course*/

        try {
            Conn c = new Conn();
            String query = "select * from FeeStructure where Name_Of_Class ='" + cbcourses.getSelectedItem() + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                amountL.setText(rs.getString("Amount"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        cbcourses.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from FeeStructure where Name_Of_Class ='" + cbcourses.getSelectedItem() + "'";
                    ResultSet rs = c.s.executeQuery(query);
                    while (rs.next()) {
                        amountL.setText(rs.getString("Amount"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        /* Creating buttons */

        pay = new JButton("Pay");
        pay.setFont(new Font("Bell MT", Font.BOLD, 20));
        pay.setBackground(Color.CYAN);
        pay.setForeground(Color.BLACK);
        pay.setBorder(lb);
        pay.addActionListener(this);
        pay.setBounds(100,360,80,40);
        add(pay);

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Bell MT", Font.BOLD, 20));
        cancel.setBackground(Color.CYAN);
        cancel.setForeground(Color.BLACK);
        cancel.setBorder(lb);
        cancel.addActionListener(this);
        cancel.setBounds(220,360,80,40);
        add(cancel);

        /* Main Frame Setting */
        setTitle("Fee Submission Form");
        getContentPane().setBackground(Color.PINK);
        setLayout(null);
        setLocation(440, 60);
        setSize(400, 550);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        
        new FeeForm();
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==pay){
            String year = (String)cbyear.getSelectedItem();
            String rollno = (String) crollno.getSelectedItem();
            String status = "paid";
            try {
               
                String query = "update feespayment set Year='"+year+"', Status='"+status+"' where Roll_No='"+rollno+"'";
                Conn con = new Conn();
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Payment Successful");
                setVisible(false);
            } catch (Exception error) {
                error.printStackTrace();
            }
            
        }
        else {
            setVisible(false);
        }
    }
}
