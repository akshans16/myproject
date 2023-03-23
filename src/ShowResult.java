import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class ShowResult extends JFrame {

    static JLabel lblNameF, lblFatherF, lblDobF, lblRollNoF;
    static JTextField tfsub1, tfsub2, tfsub3, tfsub4, tfsub5, tfsub6;
    static JTextField cce1, cce2, cce3, cce4, cce5, cce6;
    static JTextField t1, t2, t3, t4, t5, t6;
    static JTextField p1, p2, p3, p4, p5, p6;
    static JTextField to1, to2, to3, to4, to5, to6;
    static JTextField gradeF, totalMarks;

    static String ROLL_NO;
    
    ShowResult(String RollNo) {

        /* Storing Roll No in Global variable */
        ROLL_NO = RollNo;

        /* Creating main heading */
        JLabel clgName = new JLabel("Maharaja Chhatrasal Bundelkhand University");
        clgName.setBounds(100, 30, 600, 30);
        clgName.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
        clgName.setForeground(Color.BLACK);
        add(clgName);

        JLabel clgSubHeading = new JLabel("Chhatarpur (M.P.)");
        clgSubHeading.setBounds(275, 65, 250, 30);
        clgSubHeading.setFont(new Font("Arial Rounded MT", Font.BOLD, 25));
        clgSubHeading.setForeground(Color.BLACK);
        add(clgSubHeading);

        /* Examination result */
        JLabel resultH = new JLabel("Examination Result");
        resultH.setBounds(255, 100, 250, 30);
        resultH.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
        resultH.setForeground(Color.BLACK);
        add(resultH);

        /* Line Seperator */
        add(line(0, 140, 800, 1));

        /* Name field */
        JLabel lblName = new JLabel("Student Name");
        lblName.setBounds(100, 150, 150, 20);
        lblName.setFont(new Font("Arial Rounded MT", Font.PLAIN, 16));
        lblName.setForeground(Color.BLACK);
        add(lblName);

        lblNameF = new JLabel("");
        lblNameF.setBounds(250, 150, 150, 20);
        lblNameF.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 16));
        lblNameF.setForeground(Color.BLACK);
        add(lblNameF);

        /* Roll No field */
        JLabel lblRollNo = new JLabel("Roll Number");
        lblRollNo.setBounds(100, 180, 100, 20);
        lblRollNo.setFont(new Font("Arial Rounded MT", Font.PLAIN, 16));
        lblRollNo.setForeground(Color.BLACK);
        add(lblRollNo);

        lblRollNoF = new JLabel("");
        lblRollNoF.setBounds(250, 180, 150, 20);
        lblRollNoF.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 16));
        lblRollNoF.setForeground(Color.BLACK);
        add(lblRollNoF);

        /* Father's name Field */
        JLabel lblFather = new JLabel("Father Name");
        lblFather.setBounds(450, 150, 150, 20);
        lblFather.setFont(new Font("Arial Rounded MT", Font.PLAIN, 16));
        lblFather.setForeground(Color.BLACK);
        add(lblFather);

        lblFatherF = new JLabel("");
        lblFatherF.setBounds(600, 150, 150, 20);
        lblFatherF.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 16));
        lblFatherF.setForeground(Color.BLACK);
        add(lblFatherF);

        /* Date Of Birth */
        JLabel lblDob = new JLabel("Date Of Birth");
        lblDob.setBounds(450, 180, 150, 20);
        lblDob.setFont(new Font("Arial Rounded MT", Font.PLAIN, 16));
        lblDob.setForeground(Color.BLACK);
        add(lblDob);

        lblDobF = new JLabel("");
        lblDobF.setBounds(600, 180, 150, 20);
        lblDobF.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 16));
        lblDobF.setForeground(Color.BLACK);
        add(lblDobF);

        /* Filling label fields */
        setValues();

        /* Line Seperator */
        add(line(0, 210, 800, 1));

        /* creating Coloum title -> Subject */
        JLabel sub = new JLabel("Subject");
        sub.setFont(new Font("Calibri (Body)", Font.BOLD, 14));
        sub.setForeground(Color.BLACK);
        sub.setBounds(230, 220, 100, 20);
        add(sub);

        tfsub1 = new JTextField();
        tfsub1.setBounds(175, 280, 150, 20);
        tfsub1.setEditable(false);
        add(tfsub1);

        tfsub2 = new JTextField();
        tfsub2.setBounds(175, 320, 150, 20);
        tfsub2.setEditable(false);
        add(tfsub2);

        tfsub3 = new JTextField();
        tfsub3.setBounds(175, 360, 150, 20);
        tfsub3.setEditable(false);
        add(tfsub3);

        tfsub4 = new JTextField();
        tfsub4.setBounds(175, 400, 150, 20);
        tfsub4.setEditable(false);
        add(tfsub4);

        tfsub5 = new JTextField();
        tfsub5.setBounds(175, 440, 150, 20);
        tfsub5.setEditable(false);
        add(tfsub5);

        tfsub6 = new JTextField();
        tfsub6.setBounds(175, 480, 150, 20);
        tfsub6.setEditable(false);
        add(tfsub6);

        /* Coloum 2 Enter mark coloum */

        JLabel mark = new JLabel("Marks");
        mark.setFont(new Font("Calibri (Body)", Font.BOLD, 14));
        mark.setForeground(Color.BLACK);
        mark.setBounds(410, 220, 100, 20);
        add(mark);

        /* setting cce label */
        JLabel cce = new JLabel("CCE");
        cce.setBounds(350, 250, 50, 15);
        cce.setFont(new Font("Calibri (Body)", Font.BOLD, 13));
        cce.setForeground(Color.BLACK);
        add(cce);

        cce1 = new JTextField();
        cce1.setBounds(350, 280, 20, 20);
        cce1.setEditable(false);
        add(cce1);

        cce2 = new JTextField();
        cce2.setBounds(350, 320, 20, 20);
        cce2.setEditable(false);
        add(cce2);

        cce3 = new JTextField();
        cce3.setBounds(350, 360, 20, 20);
        cce3.setEditable(false);
        add(cce3);

        cce4 = new JTextField();
        cce4.setBounds(350, 400, 20, 20);
        cce4.setEditable(false);
        add(cce4);

        cce5 = new JTextField();
        cce5.setBounds(350, 440, 20, 20);
        cce5.setEditable(false);
        add(cce5);

        cce6 = new JTextField();
        cce6.setBounds(350, 480, 20, 20);
        cce6.setEditable(false);
        add(cce6);

        /* setting theory label */

        JLabel theory = new JLabel("Theory");
        theory.setBounds(400, 250, 50, 15);
        theory.setFont(new Font("Calibri (Body)", Font.BOLD, 13));
        theory.setForeground(Color.BLACK);
        add(theory);

        t1 = new JTextField();
        t1.setBounds(400, 280, 50, 20);
        t1.setEditable(false);
        add(t1);

        t2 = new JTextField();
        t2.setBounds(400, 320, 50, 20);
        t2.setEditable(false);
        add(t2);

        t3 = new JTextField();
        t3.setBounds(400, 360, 50, 20);
        t3.setEditable(false);
        add(t3);

        t4 = new JTextField();
        t4.setBounds(400, 400, 50, 20);
        t4.setEditable(false);
        add(t4);

        t5 = new JTextField();
        t5.setBounds(400, 440, 50, 20);
        t5.setEditable(false);
        add(t5);

        t6 = new JTextField();
        t6.setBounds(400, 480, 50, 20);
        t6.setEditable(false);
        add(t6);

        /* setting practical coloum */

        JLabel prac = new JLabel("Practical");
        prac.setBounds(480, 250, 80, 15);
        prac.setFont(new Font("Calibri (Body)", Font.BOLD, 13));
        prac.setForeground(Color.BLACK);
        add(prac);

        p1 = new JTextField();
        p1.setBounds(480, 280, 50, 20);
        p1.setEditable(false);;
        add(p1);

        p2 = new JTextField();
        p2.setBounds(480, 320, 50, 20);
        p2.setEditable(false);
        add(p2);

        p3 = new JTextField();
        p3.setBounds(480, 360, 50, 20);
        p3.setEditable(false);
        add(p3);

        p4 = new JTextField();
        p4.setBounds(480, 400, 50, 20);
        p4.setEditable(false);
        add(p4);

        p5 = new JTextField();
        p5.setBounds(480, 440, 50, 20);
        p5.setEditable(false);
        add(p5);

        p6 = new JTextField();
        p6.setBounds(480, 480, 50, 20);
        p6.setEditable(false);
        add(p6);

        /* setting total coloum */
        JLabel total = new JLabel("Total");
        total.setFont(new Font("Calibri (Body)", Font.BOLD, 14));
        total.setForeground(Color.BLACK);
        total.setBounds(550, 250, 100, 20);
        add(total);

        to1 = new JTextField();
        to1.setBounds(550, 280, 50, 20);
        to1.setEditable(false);
        add(to1);

        to2 = new JTextField();
        to2.setBounds(550, 320, 50, 20);
        to2.setEditable(false);
        add(to2);

        to3 = new JTextField();
        to3.setBounds(550, 360, 50, 20);
        to3.setEditable(false);
        add(to3);

        to4 = new JTextField();
        to4.setBounds(550, 400, 50, 20);
        to4.setEditable(false);
        add(to4);

        to5 = new JTextField();
        to5.setBounds(550, 440, 50, 20);
        to5.setEditable(false);
        add(to5);

        to6 = new JTextField();
        to6.setBounds(550, 480, 50, 20);
        to6.setEditable(false);
        add(to6);

        /* Line Seperator */
        add(line(0, 540, 800, 1));

        /* creating marks obtained and percentage section */

        JLabel markOb = new JLabel("Marks Obtained");
        markOb.setBounds(185, 560, 120, 20);
        markOb.setFont(new Font("Calibri (Body)", Font.BOLD, 15));
        markOb.setForeground(Color.BLACK);
        add(markOb);

        totalMarks = new JTextField();
        totalMarks.setBounds(320, 560, 120, 20);
        totalMarks.setFont(new Font("Calibri (Body)", Font.BOLD, 14));
        totalMarks.setEditable(false);
        totalMarks.setBackground(Color.PINK);
        add(totalMarks);

        /* Creation of Grade level */
        JLabel grade = new JLabel("Grade ");
        grade.setBounds(500, 560, 50, 20);
        grade.setFont(new Font("Calibri (Body)", Font.BOLD, 14));
        grade.setForeground(Color.BLACK);
        add(grade);

        gradeF = new JTextField();
        gradeF.setBounds(575, 560, 25, 20);
        gradeF.setEditable(false);
        gradeF.setFont(new Font("Calibri (Body)",Font.BOLD,15));
        gradeF.setBackground(Color.PINK);
        add(gradeF);

        /* Filling values of result */
        setResultValues();

        /* Main Frame Setting */
        getContentPane().setBackground(Color.WHITE);
        setResizable(false);
        setLayout(null);
        setLocation(240, 0);
        setSize(800, 650);
        setVisible(true);
    }

    /* Setting values Name --> akshansh khare , Father --> ashok , Roll no -->21105703 */
    static void setValues() {
        try {
            Conn c = new Conn();
            String query = "select * from student where Roll_No='" + ROLL_NO + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                lblNameF.setText(rs.getString("Name"));
                lblFatherF.setText(rs.getString("F_Name"));
                lblRollNoF.setText(rs.getString("Roll_No"));
                lblDobF.setText(rs.getString("DOB"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /* Setting values of subjct & marks */
    static void setResultValues() {
        try {
            Conn c = new Conn();

            String query1 = "select * from subject where Roll_No='" + ROLL_NO + "'";
            ResultSet rs1 = c.s.executeQuery(query1);
            while (rs1.next()) {
                tfsub1.setText(rs1.getString("sub1"));
                tfsub2.setText(rs1.getString("sub2"));
                tfsub3.setText(rs1.getString("sub3"));
                tfsub4.setText(rs1.getString("sub4"));
                tfsub5.setText(rs1.getString("sub5"));
                tfsub6.setText(rs1.getString("sub6"));
            }

            String query2 = "select * from cceMarks where Roll_No='" + ROLL_NO + "'";
            ResultSet rs2 = c.s.executeQuery(query2);
            while (rs2.next()) {
                cce1.setText(rs2.getString("cce1"));
                cce2.setText(rs2.getString("cce2"));
                cce3.setText(rs2.getString("cce3"));
                cce4.setText(rs2.getString("cce4"));
                cce5.setText(rs2.getString("cce5"));
                cce6.setText(rs2.getString("cce6"));
            }

            String query3 = "select * from theoryMarks where Roll_No='" + ROLL_NO + "'";
            ResultSet rs3 = c.s.executeQuery(query3);
            while (rs3.next()) {
                t1.setText(rs3.getString("t1"));
                t2.setText(rs3.getString("t2"));
                t3.setText(rs3.getString("t3"));
                t4.setText(rs3.getString("t4"));
                t5.setText(rs3.getString("t5"));
                t6.setText(rs3.getString("t6"));
            }

            String query4 = "select * from pracMarks where Roll_No='" + ROLL_NO + "'";
            ResultSet rs4 = c.s.executeQuery(query4);
            while (rs4.next()) {
                p1.setText(rs4.getString("p1"));
                p2.setText(rs4.getString("p2"));
                p3.setText(rs4.getString("p3"));
                p4.setText(rs4.getString("p4"));
                p5.setText(rs4.getString("p5"));
                p6.setText(rs4.getString("p6"));
            }

            String query5 = "select * from totalMarks where Roll_No='" + ROLL_NO + "'";
            ResultSet rs5 = c.s.executeQuery(query5);
            while (rs5.next()) {
                to1.setText(rs5.getString("to1"));
                to2.setText(rs5.getString("to2"));
                to3.setText(rs5.getString("to3"));
                to4.setText(rs5.getString("to4"));
                to5.setText(rs5.getString("to5"));
                to6.setText(rs5.getString("to6"));
            }
            
            String query6 = "select * from result where Roll_No='" + ROLL_NO + "'";
            ResultSet rs6 = c.s.executeQuery(query6);
            while (rs6.next()) {
                totalMarks.setText(rs6.getString("markObtained"));
                gradeF.setText(rs6.getString("grade"));
            }

            rs1.close();
            rs2.close();
            rs3.close();
            rs4.close();
            rs5.close();
            rs6.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /* Creating function for Line seperator <------------------> */
    static JSeparator line(int x,int y,int width,int height) {
        JSeparator s = new JSeparator();
        s.setOrientation(SwingConstants.HORIZONTAL);
        s.setBounds(x, y, width, height);
        s.setForeground(Color.BLACK);
        return s;
    }
    public static void main(String[] args) {
        new ShowResult("21101230");
    }
    
}
