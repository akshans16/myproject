import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;


public class Login extends JFrame implements ActionListener {

    JButton login, cancel;
    JTextField userTextField, tfpassword;
    
    public Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblusername = new JLabel("Username : ");
        lblusername.setBounds(90, 60, 100, 20);
        add(lblusername);

        userTextField = new JTextField();
        userTextField.setBounds(160, 60, 150, 20);
        add(userTextField);

        JLabel lblpassword = new JLabel("Password : ");
        lblpassword.setBounds(90, 100, 100, 20);
        add(lblpassword);

        tfpassword = new JPasswordField();
        tfpassword.setBounds(160, 100, 150, 20);
        add(tfpassword);

        login = new JButton("Login");
        login.setBounds(90, 170, 100, 40);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.GREEN);
        login.setFont(new Font("Arial Black", Font.BOLD, 15));
        login.addActionListener(this);
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(210, 170, 100, 40);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.RED);
        cancel.setForeground(Color.RED);
        cancel.setFont(new Font("Arial Black", Font.BOLD, 15));
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(290, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(330, 0, 250, 250);
        add(image);

        setSize(600, 350);
        setLocation(350, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String username = userTextField.getText();
            String password = tfpassword.getText();

            String query = "select * from login where username='"+username+"' and password='"+password+"'";

            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Main();
                } else {
                    JOptionPane.showMessageDialog(null, "invalid username or password");
                }
            } catch (Exception e) {
                e.getStackTrace();
            }

        } else if (ae.getSource() == cancel) {

            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
        
    }

}
