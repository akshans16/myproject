import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;
import java.awt.event.*;
import java.sql.*;

public class AddTeacher extends JFrame implements ActionListener {
    JButton submit, cancel;
    JTextField nameF, phoneF, dobF, fatherF, emailF, aadharF, addressF;
    JLabel empId;
    JComboBox<String> GenderList, subject;
    JFormattedTextField tft2;
    Statement s;

    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L);

    AddTeacher() {

        setSize(800, 600);
        setLocation(240, 60);
        setLayout(null);
        setTitle("Add Teacher Page");
        getContentPane().setBackground(Color.PINK);
        setResizable(false);
        setTitle("Add New Faculty");

        /* Coloum one */

        JLabel heading = new JLabel("Add Teacher Details");
        heading.setBounds(260, 20, 320, 40);
        heading.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
        heading.setForeground(Color.BLACK);
        add(heading);

        // Line separaotr --------------
        JSeparator s = new JSeparator();
        s.setOrientation(SwingConstants.HORIZONTAL);
        s.setBounds(0, 70, 800, 10);
        s.setForeground(Color.RED);
        add(s);

        JLabel name = new JLabel("Name");
        name.setBounds(100, 120, 100, 30);
        name.setFont(new Font("Calibri(Body)", Font.BOLD, 15));
        name.setForeground(Color.BLACK);
        add(name);

        nameF = new JTextField();
        nameF.setBounds(250, 120, 130, 25);
        add(nameF);

        JLabel phone = new JLabel("Mobile No");
        phone.setBounds(100, 180, 100, 30);
        phone.setFont(new Font("Calibri(Body)", Font.BOLD, 15));
        phone.setForeground(Color.BLACK);
        add(phone);

        phoneF = new JTextField();
        phoneF.setBounds(250, 180, 130, 25);
        add(phoneF);

        JLabel email = new JLabel("Email ID ");
        email.setBounds(100, 240, 100, 30);
        email.setFont(new Font("Calibri(Body)", Font.BOLD, 15));
        email.setForeground(Color.BLACK);
        add(email);

        emailF = new JTextField();
        emailF.setBounds(250, 240, 130, 25);
        add(emailF);

        JLabel dob = new JLabel("Date Of Birth");
        dob.setBounds(100, 300, 500, 30);
        dob.setFont(new Font("Calibri(Body)", Font.BOLD, 15));
        dob.setForeground(Color.BLACK);
        add(dob);

        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        tft2 = new JFormattedTextField(format);
        tft2.setValue(new Date());
        tft2.setBounds(250, 300, 130, 25);
        add(tft2);

        JLabel sub = new JLabel("Subject");
        sub.setBounds(100, 360, 500, 30);
        sub.setFont(new Font("Calibri(Body)", Font.BOLD, 15));
        sub.setForeground(Color.BLACK);
        add(sub);

        String subjects[] = { "Physics", "Computer Science", "Mathematics", "Chemistry", "English", "Histroy",
                "Political Science", "Economics", "Geography", "Hindi", "English", "Yoga & Meditation",
                "Web Designing" };
        subject = new JComboBox<>(subjects);
        subject.setBounds(250, 360, 130, 25);
        subject.setForeground(Color.BLACK);
        add(subject);

        /* Coloum two */

        JLabel fatherName = new JLabel("Father's name");
        fatherName.setBounds(450, 120, 500, 30);
        fatherName.setFont(new Font("Calibri(Body)", Font.BOLD, 15));
        fatherName.setForeground(Color.BLACK);
        add(fatherName);

        fatherF = new JTextField();
        fatherF.setBounds(580, 120, 130, 25);
        add(fatherF);

        JLabel address = new JLabel("Address");
        address.setBounds(450, 180, 500, 30);
        address.setFont(new Font("Calibri(Body)", Font.BOLD, 15));
        address.setForeground(Color.BLACK);
        add(address);

        addressF = new JTextField();
        addressF.setBounds(580, 180, 130, 25);
        add(addressF);

        JLabel aadhar = new JLabel("Aadhaar No");
        aadhar.setBounds(450, 240, 500, 30);
        aadhar.setFont(new Font("Calibri(Body)", Font.BOLD, 15));
        aadhar.setForeground(Color.BLACK);
        add(aadhar);

        aadharF = new JTextField("0000-0000-0000");
        aadharF.setBounds(580, 240, 130, 25);
        add(aadharF);

        JLabel rollNo = new JLabel("Employee ID");
        rollNo.setBounds(450, 300, 500, 30);
        rollNo.setFont(new Font("Calibri(Body)", Font.BOLD, 15));
        rollNo.setForeground(Color.BLACK);
        add(rollNo);

        empId = new JLabel("1510" + first4);
        first4 += 1;
        empId.setBounds(580, 300, 500, 30);
        empId.setFont(new Font("Calibri(Body)", Font.BOLD, 15));
        empId.setForeground(Color.BLACK);
        add(empId);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(450, 360, 500, 30);
        gender.setFont(new Font("Calibri(Body)", Font.BOLD, 15));
        gender.setForeground(Color.BLACK);
        add(gender);

        String gType[] = { "Male", "Female", "Other" };
        GenderList = new JComboBox<>(gType);
        GenderList.setBounds(580, 360, 130, 25);
        GenderList.setForeground(Color.BLACK);
        add(GenderList);

        /* Submit and Cancel button */
        submit = new JButton("Submit");
        submit.setBounds(260, 480, 100, 40);

        submit.setFont(new Font("Calibri(Body)", Font.BOLD, 15));
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(480, 480, 100, 40);

        cancel.setFont(new Font("Calibri(Body)", Font.BOLD, 15));
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {

            if (((nameF.getText().isEmpty()) && (phoneF.getText().isEmpty())
                    && (fatherF.getText().isEmpty()) && (emailF.getText().isEmpty())
                    && (addressF.getText().isEmpty()))) {
                JOptionPane.showMessageDialog(null, "please fill out all required fields");
            } else {
                String Name = nameF.getText();
                String FName = fatherF.getText();
                String Phone = phoneF.getText();
                String address = addressF.getText();
                String Subject = (String) subject.getSelectedItem();
                String Aadhar = aadharF.getText();
                String DOB = tft2.getText();
                String RollNo = empId.getText();
                String Email = emailF.getText();
                String Gender = (String) GenderList.getSelectedItem();

                try {
                    String query = "insert into techer values('" + Name + "','" + FName + "','" + Phone + "','"
                            + address
                            + "','" + Subject + "','" + Aadhar + "', '" + DOB + "','"
                            + RollNo + "','" + Email + "','" + Gender + "')";

                    Conn con = new Conn();
                    con.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Data Inserted Sucessfully");
                    setVisible(false);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new AddTeacher();
    }
}
