import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class EnterMarks extends JFrame implements ActionListener, KeyListener {

    JComboBox<String> cbcourses, cbyears;
    JTextField tfsub1, tfsub2, tfsub3, tfsub4, tfsub5, tfsub6;
    JTextField cce1, cce2, cce3, cce4, cce5, cce6;
    JTextField t1, t2, t3, t4, t5, t6;
    JTextField p1, p2, p3, p4, p5, p6;
    JTextField to1, to2, to3, to4, to5, to6;
    static Choice crollno;
    static JLabel namef, fatherf;
    JButton submit, cancel;
    int TOTAL, total1, total2, total3, total4, total5, total6;
    String totalStr;
    JTextField totalMarks, gradeF;
    static LineBorder lb;

    EnterMarks() {

        /* Creating Line Border */
        lb = new LineBorder(Color.BLACK, 1, true);
        LineBorder lb1 = new LineBorder(Color.RED, 1, true);
        /* Main Heading */
        JLabel heading = new JLabel("Upload Marks");
        heading.setBounds(300, 20, 200, 40);
        heading.setFont(new Font("Round MT Bell", Font.BOLD, 30));
        heading.setForeground(Color.BLACK);
        add(heading);

        /* Line separator */
        add(line(0, 70, 800, 1));

        /* Select Course Field */

        JLabel course = label("Course", 50, 80, 100, 30);
        add(course);

        String courses[] = { "B.Sc", "BCA", "BA", "B.Com", "M.Sc", "MCA", "MA", "M.Com" };
        cbcourses = new JComboBox<>(courses);
        cbcourses.setBounds(120, 80, 100, 25);
        add(cbcourses);

        /* Select Year Field */

        JLabel year = label("Year", 300, 80, 50, 30);
        add(year);

        String years[] = { "1st year", "2nd year", "3rd year", "4th year" };
        cbyears = new JComboBox<>(years);
        cbyears.setBounds(360, 80, 100, 20);
        add(cbyears);

        /* Select Roll No Field */

        JLabel rollHeading = label("Select Roll No", 520, 85, 120, 20);
        add(rollHeading);

        crollno = new Choice();
        crollno.setBounds(640, 80, 100, 20);
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

        /* Automation for fetching name */
        JLabel name = label("Name", 100, 120, 100, 20);
        add(name);

        namef = label("", 200, 120, 150, 20);
        add(namef);

        /* fetching father's name details */
        JLabel father = label("Father name", 400, 120, 150, 20);
        add(father);

        fatherf = label("", 550, 120, 150, 20);
        add(fatherf);

        /* Setting textfield according to selected roll number */
        setNames(crollno);

        /* Line separator */
        add(line(0, 150, 800, 1));

        /* creating Coloum title -> Subject */
        JLabel sub = new JLabel("Subject");
        sub.setFont(new Font("Calibri (Body)", Font.BOLD, 14));
        sub.setForeground(Color.BLACK);
        sub.setBounds(55, 160, 100, 20);
        add(sub);

        tfsub1 = textF(10, 220, 150, 20);
        add(tfsub1);

        tfsub2 = textF(10, 260, 150, 20);
        add(tfsub2);

        tfsub3 = textF(10, 300, 150, 20);
        add(tfsub3);

        tfsub4 = textF(10, 340, 150, 20);
        add(tfsub4);

        tfsub5 = textF(10, 380, 150, 20);
        add(tfsub5);

        tfsub6 = textF(10, 420, 150, 20);
        add(tfsub6);

        /* Coloum 2 Enter mark coloum */

        JLabel mark = new JLabel("Marks");
        mark.setFont(new Font("Calibri (Body)", Font.BOLD, 14));
        mark.setForeground(Color.BLACK);
        mark.setBounds(240, 160, 100, 20);
        add(mark);

        /* setting cce label */
        JLabel cce = new JLabel("CCE");
        cce.setBounds(180, 190, 50, 15);
        cce.setFont(new Font("Calibri (Body)", Font.BOLD, 13));
        cce.setForeground(Color.BLACK);
        add(cce);

        cce1 = textF(180, 220, 25, 20);
        cce1.addKeyListener(this);
        add(cce1);

        cce2 = textF(180, 260, 25, 20);
        cce2.addKeyListener(this);
        add(cce2);

        cce3 = textF(180, 300, 25, 20);
        cce3.addKeyListener(this);
        add(cce3);

        cce4 = textF(180, 340, 25, 20);
        cce4.addKeyListener(this);
        add(cce4);

        cce5 = textF(180, 380, 25, 20);
        cce5.addKeyListener(this);
        add(cce5);

        cce6 = textF(180, 420, 25, 20);
        cce6.addKeyListener(this);
        add(cce6);

        /* setting theory label */

        JLabel theory = new JLabel("Theory");
        theory.setBounds(230, 190, 50, 15);
        theory.setFont(new Font("Calibri (Body)", Font.BOLD, 13));
        theory.setForeground(Color.BLACK);
        add(theory);

        t1 = textF(230, 220, 50, 20);
        t1.setBounds(230, 220, 50, 20);
        t1.addKeyListener(this);
        add(t1);

        t2 = textF(230, 260, 50, 20);
        t2.addKeyListener(this);
        add(t2);

        t3 = textF(230, 300, 50, 20);
        t3.addKeyListener(this);
        add(t3);

        t4 = textF(230, 340, 50, 20);
        t4.addKeyListener(this);
        add(t4);

        t5 = textF(230, 380, 50, 20);
        t5.addKeyListener(this);
        add(t5);

        t6 = textF(230, 420, 50, 20);
        t6.addKeyListener(this);
        add(t6);

        /* setting practical coloum */

        JLabel prac = new JLabel("Practical");
        prac.setBounds(300, 190, 80, 15);
        prac.setFont(new Font("Calibri (Body)", Font.BOLD, 13));
        prac.setForeground(Color.BLACK);
        add(prac);

        p1 = textF(300, 220, 50, 20);
        p1.addKeyListener(this);
        add(p1);

        p2 = textF(300, 260, 50, 20);
        p2.addKeyListener(this);
        add(p2);

        p3 = textF(300, 300, 50, 20);
        p3.addKeyListener(this);
        add(p3);

        p4 = textF(300, 340, 50, 20);
        p4.addKeyListener(this);
        add(p4);

        p5 = textF(300, 380, 50, 20);
        p5.addKeyListener(this);
        add(p5);

        p6 = textF(300, 420, 50, 20);
        p6.addKeyListener(this);
        add(p6);

        /* setting total coloum */
        JLabel total = new JLabel("Total");
        total.setFont(new Font("Calibri (Body)", Font.BOLD, 14));
        total.setForeground(Color.BLACK);
        total.setBounds(410, 160, 100, 20);
        add(total);

        to1 = textF(400, 220, 50, 20);
        to1.setEditable(false);
        to1.addKeyListener(this);
        add(to1);

        to2 = textF(400, 260, 50, 20);
        to2.setEditable(false);
        to2.addKeyListener(this);
        add(to2);

        to3 = textF(400, 300, 50, 20);
        to3.setEditable(false);
        to3.addKeyListener(this);
        add(to3);

        to4 = textF(400, 340, 50, 20);
        to4.setEditable(false);
        to4.addKeyListener(this);
        add(to4);

        to5 = textF(400, 380, 50, 20);
        to5.setEditable(false);
        to5.addKeyListener(this);
        add(to5);

        to6 = textF(400, 420, 50, 20);
        to6.setEditable(false);
        to6.addKeyListener(this);
        add(to6);

        /* creating marks obtained and percentage section */

        JLabel markOb = label("Marks Obtained", 10, 460, 120, 20);
        add(markOb);

        totalMarks = textF(150, 460, 130, 20);
        totalMarks.setBackground(Color.PINK);
        totalMarks.addKeyListener(this);
        add(totalMarks);

        /* Creation of Grade level */
        JLabel grade = label("Grade", 350, 460, 50, 20);
        add(grade);

        gradeF = textF(420, 460, 25, 20);
        gradeF.setBackground(Color.PINK);
        gradeF.setEditable(false);
        add(gradeF);

        /* creating buttons */

        submit = buttons("submit", 60, 500, 100, 40);
        submit.addActionListener(this);
        add(submit);

        cancel = buttons("cancel", 300, 500, 100, 40);
        cancel.addActionListener(this);
        add(cancel);

        /* Adding Image to the side */

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/exam2re.jpg"));
        Image i2 = i1.getImage().getScaledInstance(310, 460, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(480, 150, 310, 460);
        image.setBorder(lb1);
        add(image);

        /* Main Frame Setting */
        setResizable(false);
        setLayout(null);
        getContentPane().setBackground(Color.PINK);
        setTitle("Upload Marks Page");
        setSize(800, 600);
        setLocation(240, 60);
        setVisible(true);
    }

    public static void main(String[] args) {
        new EnterMarks();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == submit) {

            /* checking all text field has filled or not */
            if (((to1.getText().isEmpty()) && (to2.getText().isEmpty()) && (to3.getText().isEmpty())
                    && (to4.getText().isEmpty()) && (to5.getText().isEmpty()) && (to6.getText().isEmpty()))) {
                JOptionPane.showMessageDialog(null, "please fill out all required fields");
            }

            else {

                String fillRollNo = (String) crollno.getSelectedItem();
                String fillCourse = (String) cbcourses.getSelectedItem();
                String fillYear = (String) cbyears.getSelectedItem();

                String sub1 = tfsub1.getText();
                String sub2 = tfsub2.getText();
                String sub3 = tfsub3.getText();
                String sub4 = tfsub4.getText();
                String sub5 = tfsub5.getText();
                String sub6 = tfsub6.getText();

                String fillcce1 = cce1.getText();
                String fillcce2 = cce2.getText();
                String fillcce3 = cce3.getText();
                String fillcce4 = cce4.getText();
                String fillcce5 = cce5.getText();
                String fillcce6 = cce6.getText();

                String fillt1 = t1.getText();
                String fillt2 = t2.getText();
                String fillt3 = t3.getText();
                String fillt4 = t4.getText();
                String fillt5 = t5.getText();
                String fillt6 = t6.getText();

                String fillprac1 = p1.getText();
                String fillprac2 = p2.getText();
                String fillprac3 = p3.getText();
                String fillprac4 = p4.getText();
                String fillprac5 = p5.getText();
                String fillprac6 = p6.getText();

                String fillto1 = to1.getText();
                String fillto2 = to2.getText();
                String fillto3 = to3.getText();
                String fillto4 = to4.getText();
                String fillto5 = to5.getText();
                String fillto6 = to6.getText();

                String fillmarkOb = totalMarks.getText();
                String fillgrade = gradeF.getText();

                try {

                    /* Subject query */
                    String query1 = "insert into subject values('" + fillRollNo + "','" + fillCourse + "','" + fillYear
                            + "','" + sub1 + "','" + sub2 + "','" + sub3 + "','"
                            + sub4 + "','" + sub5 + "','" + sub6 + "')";
                    /* CCE query */
                    String query2 = "insert into cceMarks values('" + fillRollNo + "','" + fillCourse + "','" + fillYear
                            + "','" + fillcce1 + "','" + fillcce2 + "','" + fillcce3 + "','"
                            + fillcce4 + "','" + fillcce5 + "','" + fillcce6 + "')";
                    /* Theory query */
                    String query3 = "insert into theoryMarks values('" + fillRollNo + "','" + fillCourse + "','"
                            + fillYear + "','" + fillt1 + "','" + fillt2 + "','" + fillt3 + "','"
                            + fillt4 + "','" + fillt5 + "','" + fillt6 + "')";
                    /* Practical query */
                    String query4 = "insert into pracMarks values('" + fillRollNo + "','" + fillCourse + "','"
                            + fillYear + "','" + fillprac1 + "','" + fillprac2 + "','" + fillprac3 + "','"
                            + fillprac4 + "','" + fillprac5 + "','" + fillprac6 + "')";
                    /* Total query */
                    String query5 = "insert into totalMarks values('" + fillRollNo + "','" + fillCourse + "','"
                            + fillYear + "','" + fillto1 + "','" + fillto2 + "','" + fillto3 + "','"
                            + fillto4 + "','" + fillto5 + "','" + fillto6 + "')";
                    /* Result query */
                    String query6 = "insert into result values('" + fillRollNo + "','" + fillCourse + "','" + fillYear
                            + "','" + fillmarkOb + "','" + fillgrade + "')";

                    Conn con = new Conn();
                    con.s.executeUpdate(query1);
                    con.s.executeUpdate(query2);
                    con.s.executeUpdate(query3);
                    con.s.executeUpdate(query4);
                    con.s.executeUpdate(query5);
                    con.s.executeUpdate(query6);

                    JOptionPane.showMessageDialog(null, "Result Uploaded Successfully");
                    dispose();;
                } catch (Exception error) {
                    error.printStackTrace();
                }
            }

        } else {
            dispose();;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {

        if (!(cce1.getText().isEmpty()) && !(t1.getText().isEmpty()) && !(p1.getText().isEmpty())) {
            String textTo1 = "";
            total1 = Integer.parseInt(cce1.getText()) + Integer.parseInt(p1.getText())
                    + Integer.parseInt(t1.getText());
            textTo1 = Integer.toString(total1);
            to1.setText(textTo1);
        }

        if (!(cce2.getText().isEmpty()) && !(t2.getText().isEmpty()) && !(p2.getText().isEmpty())) {
            total2 = Integer.parseInt(cce2.getText()) + Integer.parseInt(p2.getText())
                    + Integer.parseInt(t2.getText());
            String textTo2 = String.valueOf(total2);
            to2.setText(textTo2);
        }

        if (!(cce3.getText().isEmpty()) && !(t3.getText().isEmpty()) && !(p3.getText().isEmpty())) {
            String textTo3 = "";
            total3 = Integer.parseInt(cce3.getText()) + Integer.parseInt(p3.getText())
                    + Integer.parseInt(t3.getText());
            textTo3 = Integer.toString(total3);
            to3.setText(textTo3);
        }

        if (!(cce4.getText().isEmpty()) && !(t4.getText().isEmpty()) && !(p4.getText().isEmpty())) {
            String textTo4 = "";
            total4 = Integer.parseInt(cce4.getText()) + Integer.parseInt(p4.getText())
                    + Integer.parseInt(t4.getText());
            textTo4 = Integer.toString(total4);
            to4.setText(textTo4);
        }

        if (!(cce5.getText().isEmpty()) && !(t5.getText().isEmpty()) && !(p5.getText().isEmpty())) {
            String textTo5 = "";
            total5 = Integer.parseInt(cce5.getText()) + Integer.parseInt(p5.getText())
                    + Integer.parseInt(t5.getText());
            textTo5 = Integer.toString(total5);
            to5.setText(textTo5);
        }

        if (!(cce6.getText().isEmpty()) && !(t6.getText().isEmpty()) && !(p6.getText().isEmpty())) {
            String textTo6 = "";
            total6 = Integer.parseInt(cce6.getText()) + Integer.parseInt(p6.getText())
                    + Integer.parseInt(t6.getText());
            textTo6 = Integer.toString(total6);
            to6.setText(textTo6);
        }

        if (!((to1.getText().isEmpty()) && (to2.getText().isEmpty()) && (to3.getText().isEmpty())
                && (to4.getText().isEmpty()) && (to5.getText().isEmpty()) && (to6.getText().isEmpty()))) {
            TOTAL = total1 + total2 + total3 + total4 + total5 + total6;
            totalStr = String.valueOf(TOTAL);
            gradeF.setText(" " + gradeGen(TOTAL));
            totalMarks.setText(" " + totalStr + " out of 1200");
        }

    }

    String gradeGen(int n) {
        int per = n / 12;
        String G = "";
        if (per >= 90) {
            G = "A+";
        } else if ((per >= 70) && (per <= 90)) {
            G = "A";
        } else if ((per >= 60) && (per <= 70)) {
            G = "B";
        } else if ((per >= 50) && (per <= 60)) {
            G = "C";
        } else if ((per >= 35) && (per <= 50)) {
            G = "D";
        } else if ((per >= 0) && (per <= 35)) {
            G = "F";
        }
        return G;
    }

    /* Creating function for Line seperator <------------------> */
    static JSeparator line(int x, int y, int width, int height) {
        JSeparator s = new JSeparator();
        s.setOrientation(SwingConstants.HORIZONTAL);
        s.setBounds(x, y, width, height);
        s.setForeground(Color.BLACK);
        return s;
    }

    /* Creating buttons */
    static JButton buttons(String name, int x, int y, int width, int height) {
        JButton button = new JButton(name);
        button.setFont(new Font("Bell MT", Font.BOLD, 20));
        button.setBackground(Color.CYAN);
        button.setForeground(Color.BLACK);
        button.setBorder(lb);
        button.setBounds(x, y, width, height);
        return button;
    }

    /*
     * Fetching values for name and father's name
     * Name --> akshansh khare
     * Father's Name --> ashok
     */
    static void setNames(Choice crollno) {
        try {
            Conn c = new Conn();
            String query = "select * from student where Roll_No='" + crollno.getSelectedItem() + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                namef.setText(rs.getString("name"));
                fatherf.setText(rs.getString("F_name"));

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
                        fatherf.setText(rs.getString("F_Name"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /*
     * Function for creating text field
     * ________
     * |_______|
     */
    static JTextField textF(int x, int y, int width, int height) {
        JTextField tf = new JTextField();
        tf.setBounds(x, y, width, height);
        tf.setBorder(lb);
        tf.setFont(new Font("Calibri (Body)", 0, 12));
        tf.setForeground(Color.BLACK);
        return tf;
    }

    /* Function for creating lable */
    static JLabel label(String name, int x, int y, int width, int height) {
        JLabel lbl = new JLabel(name);
        lbl.setBounds(x, y, width, height);
        lbl.setFont(new Font("Calibri (Body)", Font.BOLD, 16));
        lbl.setForeground(Color.BLACK);
        return lbl;
    }
}
