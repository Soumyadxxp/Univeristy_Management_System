package guiapplicationpack;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

class LoginFrame extends JFrame
{
    private Font fnt = new Font("verdana",1,12);
    private JComboBox cmbRole;
    private JTextField txtUid;
    private JPasswordField txtPwd;
    private JButton btnSignup,btnSignin,btnReset,btnExit;
    private String[] role = {"Select Your Role","Admin","Professor","Student"};
    
    private JLabel makeLabel(String cap,int x,int y,int w,int h)
    {
        JLabel temp = new JLabel(cap);
        temp.setFont(new Font("Courier New",1,16));
        temp.setBounds(x,y,w,h);
        super.add(temp);
        return temp;
    }
    private JComponent makeTextBox(int x,int y,int w,int h,int mode)
    {
        JComponent temp = null;
        if(mode == 1)
            temp = new JTextField();
        else if(mode == 2)
            temp = new JPasswordField();
        temp.setFont(new Font("Courier New", 1, 18));
        temp.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        temp.setBounds(x,y,w,h);
        add(temp);
        return temp;
    }
    private JComboBox makeComboBox(int x,int y,int w,int h,String[] items)
    {
        JComboBox temp = new JComboBox(items);
        temp.setFont(new Font("Verdana", 1, 14));
        temp.setBounds(x,y,w,h);
        ((JLabel)temp.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
        temp.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int listIndex = temp.getSelectedIndex();
                if(listIndex == 0)
                {
                    btnSignup.setEnabled(false);
                    btnSignin.setEnabled(false);
                    btnReset.setEnabled(false);
                }
                else if(listIndex == 1 || listIndex == 2 || listIndex == 3)
                {
                    btnSignup.setEnabled(false);
                    btnSignin.setEnabled(true);
                    btnReset.setEnabled(true);
                }
                if(listIndex == 1) btnSignup.setEnabled(true);
            }
        });
        add(temp);
        return temp;
    }
    private JButton makeButton(String caption,int x,int y,int w,int h)
    {
        JButton temp = new JButton(caption);
        temp.setBounds(x,y,w,h);
        temp.setFont(new Font("Verdana", 1, 12));
        temp.setMargin(new Insets(0,0,0,0));
        temp.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {try
                {
                    Object ob = e.getSource();
                    if(ob==btnSignup)
                    {
                        Toolkit tk = Toolkit.getDefaultToolkit();
                        Image img = tk.getImage("p0.jpg");
                        SignupFrame signFrame = new SignupFrame();
                        signFrame.setIconImage(img);
                        signFrame.setTitle("SIGN UP PANEL...");
                        signFrame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                        signFrame.setResizable(false);
                        signFrame.setSize(500,300);
                        signFrame.setLocationRelativeTo(null);
                        signFrame.getContentPane().setBackground(new Color(250,250,200));
                        signFrame.setLayout(new BorderLayout());
                        signFrame.setModal(true);
                        signFrame.setUndecorated(true);
                        signFrame.getRootPane().setWindowDecorationStyle(JRootPane.COLOR_CHOOSER_DIALOG);
                        signFrame.setVisible(true);
                    }
                    else if(ob==btnSignin)
                    {
                        if(cmbRole.getSelectedIndex()==0||txtUid.getText().equals("")||txtPwd.getText().equals(""))
                            JOptionPane.showMessageDialog(null, "INCOMPLETE CREDENTIAL SUBMITTED");
                        else
                        {
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/unisys?autoReconnect=true&useSSL=false","root","1234");
                            String sql = "SELECT USERID,PASSWORD,ROLE FROM USER WHERE USERID = ? AND PASSWORD = ? AND ROLE = ?";
                            PreparedStatement pst = con.prepareStatement(sql);
                            pst.setString(1, txtUid.getText());
                            pst.setString(2, txtPwd.getText());
                            pst.setString(3, (String)cmbRole.getSelectedItem());
                            ResultSet rst = pst.executeQuery();
                            if(!rst.next())
{
    JOptionPane.showMessageDialog(null, "CREDENTIAL ERROR");
    txtUid.setText("");
    txtPwd.setText("");
    txtUid.grabFocus();
}
else
{
    if(cmbRole.getSelectedItem().equals("Student"))
    {
        System.setProperty("student_id", txtUid.getText());
    }

    dispose();

    Toolkit tk = Toolkit.getDefaultToolkit();
    Image img = tk.getImage("p0.jpg");
    MainFrame mFrame = new MainFrame();
    mFrame.setIconImage(img);
    mFrame.setTitle("STUDENT MANAGEMENT SYSTEM");
    mFrame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    mFrame.setResizable(false);
    mFrame.setSize(800,600);
    mFrame.setLocationRelativeTo(null);
    mFrame.getContentPane().setBackground(new Color(250,250,200));
    mFrame.setLayout(new BorderLayout());
    mFrame.setUndecorated(true);
    mFrame.getRootPane().setWindowDecorationStyle(JRootPane.COLOR_CHOOSER_DIALOG);
    mFrame.setVisible(true);
}
                        }
                    }
                    else if(ob==btnReset)
                    {
                        cmbRole.setSelectedIndex(0);
                        txtUid.setText("");
                        txtPwd.setText("");
                    }
                    else if(ob==btnExit)
                    {
                        System.exit(0);
                    }
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        });
        super.add(temp);
        return temp;
    }
    public LoginFrame()
    {
        Border brdr1 = BorderFactory.createLineBorder(Color.RED, 2);
        Border brdr2 = BorderFactory.createLineBorder(Color.BLUE, 2);
        Border brdr3 = BorderFactory.createCompoundBorder(brdr1,brdr2);
        JLabel caption = new JLabel("ON BOARD LOGIN");
        caption.setFont(new Font("verdana",1,24));
        caption.setHorizontalAlignment(JLabel.CENTER);
        caption.setOpaque(true);
        caption.setBackground(Color.YELLOW);
        caption.setForeground(Color.red);
        caption.setBorder(brdr3);
        caption.setBounds(10,10,470,50);
        super.add(caption);
        
        makeLabel("SELECT ROLE/PRIVILEGE",10,70,250,30);
        cmbRole = makeComboBox(250,70,230,30,role);
        makeLabel("ENTER USER ID",10,110,250,30);
        txtUid = (JTextField)makeTextBox(250,110,230,30,1);
        txtUid.setHorizontalAlignment(JTextField.CENTER);
        makeLabel("ENTER PASSWORD",10,150,250,30);
        txtPwd = (JPasswordField)makeTextBox(250,150,230,30,2);
        txtPwd.setHorizontalAlignment(JPasswordField.CENTER);
        txtPwd.setEchoChar('*');
        
        btnSignup = makeButton("Sign Up",20,190,100,30);
        btnSignup.setEnabled(false);
        btnSignin = makeButton("Sign In",140,190,100,30);
        btnSignin.setEnabled(false);
        btnReset = makeButton("Reset",260,190,100,30);
        btnReset.setEnabled(false);
        btnExit = makeButton("Exit",380,190,100,30);
        btnExit.setEnabled(true);
        
        makeLabel("",100,100,2,2);
        
        
    }
}

public class LoginMain
{
    public static void main(String[] args)
    {
        try
        {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/unisys?autoReconnect=true&useSSL=false","root","1234");
            DatabaseMetaData metadata = con.getMetaData();
            ResultSet result = metadata.getTables("unisys","root","USER",new String[]{"TABLE"});
            Statement sst = con.createStatement();
            if(!result.next())
            {
                String sql = "";
                sql = "create table user(userid varchar(20) primary key,password varchar(20),role varchar(9))";
                sst.executeUpdate(sql);
                sql = "insert into user values('admin','admin','Admin')";
                sst.executeUpdate(sql);
                
                sql = "create table student_master(student_id varchar(15) primary key,name varchar(20),father_name varchar(20),gender varchar(6),address varchar(50),dob date,phone varchar(12),email varchar(30),course varchar(5),semester char(1))";
                sst.executeUpdate(sql);
                
                sql = "create table professor_master(professor_id varchar(13) primary key,name varchar(20),address varchar(50),gender varchar(6),phone varchar(12),email varchar(30),dob date,doj date)";
                sst.executeUpdate(sql);
                
                sql = "create table professor_degree(professor_id varchar(13),degree varchar(10),primary key(professor_id,degree),foreign key(professor_id) references professor_master(professor_id) on delete cascade)";
                sst.executeUpdate(sql);
                
                sql = "create table student_grade(student_id varchar(15),semester char(1),grade char(1),primary key(student_id,semester),foreign key(student_id) references student_master(student_id) on delete cascade)";
                sst.executeUpdate(sql);
            }
            con.close();
            
            Toolkit tk = Toolkit.getDefaultToolkit();
            Image img = tk.getImage("p0.jpg");
            LoginFrame frame = new LoginFrame();
            frame.setIconImage(img);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(510, 270);
            frame.setLocationRelativeTo(null);
            frame.setTitle("SIGN IN PANEL");
            frame.setResizable(false);
            frame.getContentPane().setBackground(new Color(250,200,200));
            frame.setUndecorated(true);
            frame.getRootPane().setWindowDecorationStyle(JRootPane.COLOR_CHOOSER_DIALOG);
            frame.setLayout(new BorderLayout());
            frame.setVisible(true);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
