import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Main extends JFrame implements ActionListener {

    public Main() {
        // Labels
        JLabel db = lbl(15, 15, 120, 20,"Dashboard",20);
        add(db);

        JLabel mcbu = lbl(370, 10, 700, 30, "MAHARAJA CHHATRASAL BUNDELKHAND UNIVERSITY",24);
        add(mcbu);

        JLabel student = lbl(10, 60, 120, 20, "Student",18);
        add(student);

        JLabel teacher = lbl(10, 240, 120, 20, "Teacher",18);
        add(teacher);

        JLabel examination = lbl(10, 420, 120, 20, "Examination", 18);
        add(examination);

        JLabel feeDetails = lbl(10, 510, 120, 20, "Fee Details",18);
        add(feeDetails);

        JLabel utility = lbl(10, 600, 120, 20, "Utility",18);
        add(utility);

        // Separators
        JSeparator j1 = separator(150, 0, 10, 720);
        j1.setOrientation(SwingConstants.VERTICAL);
        add(j1);

        JSeparator j2 = separator(150, 50, 1280, 10);
        add(j2);

        JSeparator j3 = separator(0, 50, 150, 10);
        add(j3);        

        // Student section
        addSt = button(15, 90, 120, 20, "Add");
        add(addSt);

        updateSt = button(15, 120, 120, 20, "Update");
        add(updateSt);

        leaveSt = button(15, 150, 120, 20, "Apply leave");
        add(leaveSt);

        detailSt = button(15, 180, 120, 20, "Details");
        add(detailSt);

        leaveDeatailSt = button(15, 210, 120, 20, "Leave Details");
        add(leaveDeatailSt);

        // Teacher section
        addT = button(15, 270, 120, 20, "Add");
        add(addT);

        updateT = button(15, 300, 120, 20, "Update");
        add(updateT);

        leaveT = button(15, 330, 120, 20, "Apply leave");
        add(leaveT);

        detailT = button(15, 360, 120, 20, "Details");
        add(detailT);

        leaveDeatailT = button(15, 390, 120, 20, "Leave Details");
        add(leaveDeatailT);

        // Examination section

        enterMark = button(15,450,120,20,"Enter Marks");
        add(enterMark);

        result = button(15,480,120,20,"Check Result");
        add(result);

        // Fee Details section
        feeSt = button(15, 540, 120, 20, "Fee structure");
        add(feeSt);

        feeForm = button(15, 570, 120, 20, "Fee form");
        add(feeForm);

        // Utility Section
        calc = button(15, 630, 120, 20, "Calculator");
        add(calc);

        //Exit Section
        exit = button(10, 660, 120, 20, "EXIT");
        add(exit);

        // Load illustration image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1130, 670, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(150, 50, 1130, 670);
        add(image);

        // Main frame
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        setResizable(false);
        setTitle("Home Page");
        setSize(screenSize.width, screenSize.height);
        setVisible(true);

    }

    JButton button(int x, int y, int width, int height, String name) {
        JButton buttonB = new JButton();
        buttonB.setText(name);
        buttonB.setBounds(x, y, width, height);
        buttonB.setFont(new Font("Arial MT Rounded Bold", Font.BOLD, 16));
        buttonB.setBackground(Color.LIGHT_GRAY);
        buttonB.setForeground(Color.BLACK);
        buttonB.setBorder(null);
        buttonB.setHorizontalAlignment(SwingConstants.LEFT);
        buttonB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        buttonB.addActionListener(this);
        return buttonB;
    }

    JLabel lbl(int x, int y, int width, int height, String name, int font) {
        JLabel lb = new JLabel();
        lb.setText(name);
        lb.setBounds(x, y, width, height);
        lb.setFont(new Font("Arial Rounded MT BOLD", Font.BOLD, font));
        lb.setForeground(Color.BLACK);
        return lb;
    }
    
    JSeparator separator(int x, int y, int width, int height) {
        JSeparator j = new JSeparator();
        j.setForeground(Color.BLACK);
        j.setBounds(x,y,width,height);
        return j;
    }

    public static void main(String args[]) {
        new Main();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addSt) {
            new AddStudent();
        }
        else if (ae.getSource() == updateSt) {
            new UpdateStudent();
        }
        else if (ae.getSource() == leaveSt) {
            new StudentLeave();
        }
        else if (ae.getSource() == detailSt) {
            new Studentdetails();
        }
        else if (ae.getSource() == leaveDeatailSt) {
            new StudentLeaveDetails();
        }
        else if (ae.getSource() == addT) {
            new AddTeacher();
        }
        else if (ae.getSource() == updateT) {
            new UpdateTeacher();
        }
        else if (ae.getSource() == leaveT) {
            new TeacherLeave();
        }
        else if (ae.getSource() == detailT) {
            new TeacherDetails();
        }
        else if (ae.getSource() == updateT) {
            new UpdateTeacher();
        }
        else if (ae.getSource() == leaveDeatailT) {
            new TeacherLeaveDetails();
        }
        else if (ae.getSource() == feeSt) {
            new FeeStruct();
        }
        else if (ae.getSource() == feeForm) {
            new FeeForm();
        } else if (ae.getSource() == calc) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == enterMark) {
            new EnterMarks();
        } else if (ae.getSource() == result) {
            new CheckResult();
        }
        else {
           dispose();
        }
    }
    
    // Variable declarations
    JButton addSt;
    JButton updateSt;
    JButton leaveSt;
    JButton leaveDeatailSt;
    JButton detailSt;
    JButton addT;
    JButton updateT;
    JButton leaveT;
    JButton leaveDeatailT;
    JButton detailT;
    JButton feeSt;
    JButton feeForm;
    JButton calc;
    JButton exit;
    JButton enterMark;
    JButton result;
    
    

}
