import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;
import java.awt.event.*;
import java.sql.*;

public class AddStudent extends JFrame implements ActionListener {
    int count = 11;
    JButton submit, cancel;
    JTextField nameF, phoneF, dobF, fatherF, emailF, classXIIF, classXF, aadharF, addressF;
    JLabel number;
    JComboBox<String> GenderList, cbcourses;
    JFormattedTextField tft2;
    Statement s;

    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L);

    AddStudent() {

        setSize(800, 600);
        setLocation(240, 60);
        setLayout(null);
        getContentPane().setBackground(Color.PINK);
        setResizable(false);
        setTitle("Add New Student");

        /* Coloum one */

        JLabel heading = new JLabel("Add Student Details");
        heading.setBounds(260, 20, 320, 40);
        heading.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
        heading.setForeground(Color.BLACK);
        add(heading);

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
        email.setBounds(100, 420, 100, 30);
        email.setFont(new Font("Calibri(Body)", Font.BOLD, 15));
        email.setForeground(Color.BLACK);
        add(email);

        emailF = new JTextField();
        emailF.setBounds(250, 420, 130, 25);
        add(emailF);

        JLabel classXII = new JLabel("Class XII(%)");
        classXII.setBounds(100, 300, 500, 30);
        classXII.setFont(new Font("Calibri(Body)", Font.BOLD, 15));
        classXII.setForeground(Color.BLACK);
        add(classXII);

        classXIIF = new JTextField();
        classXIIF.setBounds(250, 300, 130, 25);
        add(classXIIF);

        JLabel dob = new JLabel("Date Of Birth");
        dob.setBounds(100, 360, 500, 30);
        dob.setFont(new Font("Calibri(Body)", Font.BOLD, 15));
        dob.setForeground(Color.BLACK);
        add(dob);

        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        tft2 = new JFormattedTextField(format);
        tft2.setValue(new Date());
        tft2.setBounds(250, 360, 130, 25);
        add(tft2);

        JLabel course = new JLabel("Courses");
        course.setBounds(100, 240, 500, 30);
        course.setFont(new Font("Calibri(Body)", Font.BOLD, 15));
        course.setForeground(Color.BLACK);
        add(course);

        String courses[] = { "B.Sc", "BCA", "BA", "B.Com", "M.Sc", "MCA", "MA", "M.Com" };
        cbcourses = new JComboBox<>(courses);
        cbcourses.setBounds(250, 240, 130, 25);
        add(cbcourses);

        /* Coloum two */

        JLabel fatherName = new JLabel("Father's name");
        fatherName.setBounds(450, 120, 130, 30);
        fatherName.setFont(new Font("Calibri(Body)", Font.BOLD, 15));
        fatherName.setForeground(Color.BLACK);
        add(fatherName);

        fatherF = new JTextField();
        fatherF.setBounds(580, 120, 130, 25);
        add(fatherF);

        JLabel address = new JLabel("Address");
        address.setBounds(450, 180, 100, 30);
        address.setFont(new Font("Calibri(Body)", Font.BOLD, 15));
        address.setForeground(Color.BLACK);
        add(address);

        addressF = new JTextField();
        addressF.setBounds(580, 180, 130, 25);
        add(addressF);

        JLabel aadhar = new JLabel("Aadhaar No");
        aadhar.setBounds(450, 240, 100, 30);
        aadhar.setFont(new Font("Calibri(Body)", Font.BOLD, 15));
        aadhar.setForeground(Color.BLACK);
        add(aadhar);

        aadharF = new JTextField("0000-0000-0000");
        aadharF.setBounds(580, 240, 130, 25);
        add(aadharF);

        JLabel classX = new JLabel("Class X(%)");
        classX.setBounds(450, 300, 100, 30);
        classX.setFont(new Font("Calibri(Body)", Font.BOLD, 15));
        classX.setForeground(Color.BLACK);
        add(classX);

        classXF = new JTextField();
        classXF.setBounds(580, 300, 130, 25);
        add(classXF);

        JLabel rollNo = new JLabel("Roll No");
        rollNo.setBounds(450, 360, 100, 30);
        rollNo.setFont(new Font("Calibri(Body)", Font.BOLD, 15));
        rollNo.setForeground(Color.BLACK);
        add(rollNo);

        number = new JLabel("2110" + first4);
        first4 += 1;
        number.setBounds(580, 360, 130, 30);
        number.setFont(new Font("Calibri(Body)", Font.BOLD, 15));
        number.setForeground(Color.BLACK);
        add(number);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(450, 420, 100, 30);
        gender.setFont(new Font("Calibri(Body)", Font.BOLD, 15));
        gender.setForeground(Color.BLACK);
        add(gender);

        String gType[] = { "Male", "Female", "Other" };
        GenderList = new JComboBox<>(gType);
        GenderList.setBounds(580, 420, 130, 25);
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
                    && (addressF.getText().isEmpty()) && (classXF.getText().isEmpty())
                    && (classXIIF.getText().isEmpty()))) {
                JOptionPane.showMessageDialog(null, "please fill out all required fields");
            } else {
                String Name = nameF.getText();
                String FName = fatherF.getText();
                String Phone = phoneF.getText();
                String Address = addressF.getText();
                String Course = (String) cbcourses.getSelectedItem();
                String Aadhar = aadharF.getText();
                String ClassXII = classXIIF.getText();
                String ClassX = classXF.getText();
                String DOB = tft2.getText();
                String RollNo = number.getText();
                String Email = emailF.getText();
                String Gender = (String) GenderList.getSelectedItem();

                try {
                    String query = "insert into student values('" + Name + "','" + FName + "','" + Phone + "','"
                            + Address + "','" + Course + "','" + Aadhar + "','" + ClassXII + "','" + ClassX + "', '"
                            + DOB + "','" + RollNo + "','" + Email + "','" + Gender + "')";

                    Conn con = new Conn();
                    con.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Data Inserted Sucessfully");
                    dispose();;

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (ae.getSource() == cancel) {
            dispose();
        }

    }

    public static void main(String[] args) {
        new AddStudent();
    }
}
