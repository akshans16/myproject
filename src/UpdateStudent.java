import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.*;
import java.sql.*;


public class UpdateStudent extends JFrame implements ActionListener {
    
    JButton submit,cancel;
    JTextField nameF,phoneF,fatherF,emailF,classXIIF,classXF,aadharF,addressF;
    JLabel number,cbcourses,GenderList;
    JFormattedTextField tft2;
    Statement s;
    Choice crollno;

    UpdateStudent() {

        setSize(800, 600);
        setLocation(240, 60);
        getContentPane().setBackground(Color.PINK);
        setResizable(false);
        setTitle("Update Student Details Page");
        setLayout(null);

        /* Creating border object */
        LineBorder b = new LineBorder(Color.BLACK,1,true);

        /* Main Heading */

        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(210, 20, 380, 40);
        heading.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
        heading.setForeground(Color.BLACK);
        add(heading);

        /* select your roll number */

        JLabel selectRollNo = new JLabel("Select Your Roll No");
        selectRollNo.setBounds(270,80,150,20);
        selectRollNo.setFont(new Font("Calibri (Body)", Font.BOLD, 16));
        selectRollNo.setForeground(Color.BLACK);
        add(selectRollNo);

        crollno = new Choice();
        crollno.setBounds(430, 80, 110, 20);
        crollno.setFont(new Font("Calibri (Body)", Font.BOLD, 15));
        crollno.setBackground(Color.PINK);
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

        /* Line separator */

        JSeparator s = new JSeparator();
        s.setOrientation(SwingConstants.HORIZONTAL);
        s.setBounds(0, 70, 800, 10);
        s.setForeground(Color.RED);
        add(s);

        JLabel name = new JLabel("Name");
        name.setBounds(100, 120, 100, 30);
        name.setFont(new Font("Calibri (Body)", Font.BOLD, 15));
        selectRollNo.setForeground(Color.BLACK);
        name.setForeground(Color.BLACK);
        add(name);

        nameF = new JTextField();
        nameF.setBounds(250, 120, 150, 25);
        nameF.setBackground(Color.PINK);
        nameF.setForeground(Color.BLACK);
        nameF.setFont(new FontUIResource("Calibri (Body)", Font.BOLD, 15));
        nameF.setBorder(b);
        add(nameF);

        JLabel phone = new JLabel("Mobile No");
        phone.setBounds(100, 180, 100, 30);
        phone.setFont(new Font("Calibri (Body)", Font.BOLD, 15));
        phone.setForeground(Color.BLACK);
        add(phone);

        phoneF = new JTextField();
        phoneF.setBounds(250, 180, 150, 25);
        phoneF.setBorder(b);
        phoneF.setBackground(Color.PINK);
        phoneF.setForeground(Color.BLACK);
        phoneF.setFont(new FontUIResource("Calibri (Body)", Font.BOLD, 15));
        add(phoneF);

        JLabel email = new JLabel("Email ID ");
        email.setBounds(100, 240, 100, 30);
        email.setFont(new Font("Calibri (Body)", Font.BOLD, 15));
        email.setForeground(Color.BLACK);
        add(email);

        emailF = new JTextField();
        emailF.setBounds(250, 240, 150, 25);
        emailF.setBorder(b);
        emailF.setBackground(Color.PINK);
        emailF.setForeground(Color.BLACK);
        emailF.setFont(new FontUIResource("Calibri (Body)", Font.BOLD, 15));
        add(emailF);

        JLabel classXII = new JLabel("Class XII(%)");
        classXII.setBounds(100, 300, 150, 30);
        classXII.setFont(new Font("Calibri (Body)", Font.BOLD, 15));
        classXII.setForeground(Color.BLACK);
        add(classXII);

        classXIIF = new JTextField();
        classXIIF.setBounds(250, 300, 150, 25);
        classXIIF.setBorder(b);
        classXIIF.setBackground(Color.PINK);
        classXIIF.setForeground(Color.BLACK);
        classXIIF.setFont(new FontUIResource("Calibri (Body)", Font.BOLD, 15));
        add(classXIIF);


        JLabel dob = new JLabel("Date Of Birth");
        dob.setBounds(100, 360, 500, 30);
        dob.setFont(new Font("Calibri (Body)", Font.BOLD, 15));
        dob.setForeground(Color.BLACK);
        add(dob);

        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        tft2 = new JFormattedTextField(format);
        tft2.setValue(new Date());
        tft2.setBounds(250,360,150,25);
        tft2.setBackground(Color.PINK);
        tft2.setForeground(Color.BLACK);
        tft2.setFont(new FontUIResource("Calibri (Body)", Font.BOLD, 15));
        tft2.setBorder(b);
        add(tft2);

        JLabel course = new JLabel("Course");
        course.setBounds(100, 420, 500, 30);
        course.setFont(new Font("Calibri (Body)", Font.BOLD, 15));
        course.setForeground(Color.BLACK);
        add(course);

        cbcourses = new JLabel();
        cbcourses.setBounds(250,420,100,25);
        cbcourses.setFont(new Font("Calibri (Body)", Font.BOLD, 15));
        cbcourses.setForeground(Color.BLACK);
        add(cbcourses);

        /* Coloum two */

        JLabel fatherName = new JLabel("Father's name");
        fatherName.setBounds(450, 120, 500, 30);
        fatherName.setFont(new Font("Calibri (Body)", Font.BOLD, 15));
        fatherName.setForeground(Color.BLACK);
        add(fatherName);

        fatherF = new JTextField();
        fatherF.setBounds(580, 120, 150, 25);
        fatherF.setBorder(b);
        fatherF.setBackground(Color.PINK);
        fatherF.setForeground(Color.BLACK);
        fatherF.setFont(new FontUIResource("Calibri (Body)", Font.BOLD, 15));
        add(fatherF);

        JLabel address = new JLabel("Address");
        address.setBounds(450, 180, 500, 30);
        address.setFont(new Font("Calibri (Body)", Font.BOLD, 15));
        address.setForeground(Color.BLACK);
        add(address);

        addressF = new JTextField();
        addressF.setBounds(580, 180, 150, 25);
        addressF.setBorder(b);
        addressF.setBackground(Color.PINK);
        addressF.setForeground(Color.BLACK);
        addressF.setFont(new FontUIResource("Calibri (Body)", Font.BOLD, 15));
        add(addressF);

        JLabel aadhar = new JLabel("Aadhaar No");
        aadhar.setBounds(450, 240, 500, 30);
        aadhar.setFont(new Font("Calibri (Body)", Font.BOLD, 15));
        aadhar.setForeground(Color.BLACK);
        add(aadhar);

        aadharF = new JTextField("0000-0000-0000");
        aadharF.setBounds(580, 240, 150, 25);
        aadharF.setBorder(b);
        aadharF.setBackground(Color.PINK);
        aadharF.setForeground(Color.BLACK);
        aadharF.setFont(new FontUIResource("Calibri (Body)", Font.BOLD, 15));
        add(aadharF);

        JLabel classX = new JLabel("Class X(%)");
        classX.setBounds(450, 300, 500, 30);
        classX.setFont(new Font("Calibri (Body)", Font.BOLD, 15));
        classX.setForeground(Color.BLACK);
        add(classX);

        classXF = new JTextField();
        classXF.setBounds(580, 300, 150, 25);
        classXF.setBorder(b);
        classXF.setBackground(Color.PINK);
        classXF.setForeground(Color.BLACK);
        classXF.setFont(new FontUIResource("Calibri (Body)", Font.BOLD, 15));
        add(classXF);

        JLabel rollNo = new JLabel("Roll No");
        rollNo.setBounds(450, 360, 500, 30);
        rollNo.setFont(new Font("Calibri (Body)", Font.BOLD, 15));
        rollNo.setForeground(Color.BLACK);
        add(rollNo);

        number = new JLabel();
        number.setBounds(580, 360, 500, 30);
        number.setFont(new Font("Calibri (Body)", Font.BOLD, 15));
        number.setForeground(Color.BLACK);
        add(number);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(450, 420, 500, 30);
        gender.setFont(new Font("Calibri (Body)", Font.BOLD, 15));
        gender.setForeground(Color.BLACK);
        add(gender);

        GenderList = new JLabel();
        GenderList.setBounds(580,420,100,25);
        GenderList.setFont(new Font("Calibri (Body)", Font.BOLD, 15));
        GenderList.setForeground(Color.BLACK);
        add(GenderList);

        /* Setting textfield according to selected roll number */
        
        try {
            Conn c = new Conn();
            String query = "select * from student where Roll_No='"+crollno.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                nameF.setText(rs.getString("name"));
                fatherF.setText(rs.getString("F_name"));
                tft2.setText(rs.getString("DOB"));
                addressF.setText(rs.getString("Address"));
                phoneF.setText(rs.getString("Phone"));
                emailF.setText(rs.getString("Email"));
                classXF.setText(rs.getString("Class_X"));
                classXIIF.setText(rs.getString("Class_XII"));
                aadharF.setText(rs.getString("Aadhar"));
                number.setText(rs.getString("Roll_No"));
                cbcourses.setText(rs.getString("Course"));
                GenderList.setText(rs.getString("Gender"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        crollno.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from student where Roll_No='"+crollno.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                        nameF.setText(rs.getString("name"));
                        fatherF.setText(rs.getString("F_Name"));
                        tft2.setText(rs.getString("DOB"));
                        addressF.setText(rs.getString("Address"));
                        phoneF.setText(rs.getString("Phone"));
                        emailF.setText(rs.getString("Email"));
                        classXF.setText(rs.getString("Class_X"));
                        classXIIF.setText(rs.getString("Class_XII"));
                        aadharF.setText(rs.getString("Aadhar"));
                        number.setText(rs.getString("Roll_No"));
                        cbcourses.setText(rs.getString("Course"));
                        GenderList.setText(rs.getString("Gender"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        /* Submit and Cancel button */
        submit = new JButton("Submit");
        submit.setBounds(250, 480, 100, 40);
        submit.setFont(new Font("Calibri(Body)", Font.BOLD, 15));
        submit.setForeground(Color.BLACK);
        submit.setBorder(b);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(480, 480, 100, 40);
        cancel.setFont(new Font("Calibri(Body)", Font.BOLD, 15));
        cancel.setForeground(Color.BLACK);
        cancel.setBorder(b);
        cancel.addActionListener(this);
        add(cancel);
        
        
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String name = nameF.getText();
            String fname = fatherF.getText();
            String classX = classXF.getText();
            String classXII = classXIIF.getText();
            String rollno = number.getText();
            String address = addressF.getText();
            String phone = phoneF.getText();
            String email = emailF.getText();
            String aad = aadharF.getText();
            String dob = tft2.getText();
            
            try {
                String query = "update student set Name='"+name+"', F_Name='"+fname+"', Phone='"+phone+"', Address='"+address+"',Aadhar='"+aad+"',Class_XII='"+classXII+"',Class_X='"+classX+"',DOB='"+dob+"',Email ='"+email+"' where Roll_No='"+rollno+"'";
                Conn con = new Conn();
                con.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Student Details Updated Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new UpdateStudent();
    }
}
