import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;

public class Student {
    public static void main(String a[])
    {
        JFrame frame1 = new JFrame("Student Database");
        JButton b1 = new JButton("View DataBase");
        JButton b2 = new JButton("Enter student details");
        JFrame frame4 = new JFrame("Delete");
        JButton b5 = new JButton("Delete");
        JFrame frame3 =  new JFrame("Database");
        JTextArea outputArea = new JTextArea();
        Label l1 = new Label("Welcome to Student Database");
        l1.setFont(new Font("Arial", Font.PLAIN, 30));
        frame1.add(l1);
        l1.setBounds(70, 40, 450, 100);
        b1.setBounds(150, 200, 220, 50);
        b2.setBounds(150, 300, 220, 50);
        b5.setBounds(150, 400, 220, 50);
        frame1.setLayout(new GridLayout(5,1));
        frame1.add(b1);
        frame1.add(b2);
        frame1.add(b5);
        outputArea.setBounds(80, 400, 360, 70);
        frame1.setSize(600,500);
        frame4.setSize(600,300);
        frame1.setLayout(null);
        frame1.setVisible(true);
        JFrame frame2 = new JFrame();
        JLabel b2l1 = new JLabel("Name:");
        JTextField ta1 = new JTextField();
        JLabel b2l2 = new JLabel("Date of Birth:");
        JTextField ta2 = new JTextField("DD/MM/YYYY");
        JToolBar tb1 = new JToolBar();
        tb1.add(b2l1);
        tb1.add(ta1);
        tb1.add(b2l2);
        tb1.add(ta2);
        JLabel b2l3 = new JLabel("Father's name:");
        JTextField ta3 = new JTextField();                  
        JLabel b2l4 = new JLabel("Mother's name:");
        JTextField ta4 = new JTextField();
        JToolBar tb2= new JToolBar();
        tb2.add(b2l3);
        tb2.add(ta3);
        tb2.add(b2l4);
        tb2.add(ta4);
        JLabel b2l5 = new JLabel("City: ");
        JTextField ta5 = new JTextField();
        JLabel b2l6 = new JLabel("State:");
        JTextField ta6 = new JTextField();
        JToolBar tb3 = new JToolBar();
        tb3.add(b2l5);
        tb3.add(ta5);
        tb3.add(b2l6);
        tb3.add(ta6);
        JLabel b2l7 = new JLabel("Year of Study:");
        JTextField ta7 = new JTextField("YYYY");
        JLabel b2l8 = new JLabel("Semester:");
        JTextField ta8 = new JTextField();
        JLabel b2l9 = new JLabel("Passout Year:");
        JTextField ta9 = new JTextField("YYYY");
        JToolBar tb4 = new JToolBar();
        tb4.add(b2l7);
        tb4.add(ta7);
        tb4.add(b2l8);
        tb4.add(ta8);
        tb4.add(b2l9);
        tb4.add(ta9);
        JLabel b2l10 = new JLabel("CGPA:");
        JTextField ta10 = new JTextField();
        JToolBar tb5 = new JToolBar();
        tb5.add(b2l10);
        tb5.add(ta10);
        JLabel b2l11 = new JLabel("Current subjects:");
        JLabel b2l12 = new JLabel("Name:");
        JTextField ta12 = new JTextField();
        JLabel b2l13 = new JLabel("Mark:");
        JTextField ta13 = new JTextField();
        JToolBar tb6 = new JToolBar();
        tb6.add(b2l12);
        tb6.add(ta12);
        tb6.add(b2l13);
        tb6.add(ta13);
        JLabel b2l14 = new JLabel("Name:");
        JTextField ta14 = new JTextField();
        JLabel b2l15 = new JLabel("Mark:");
        JTextField ta15 = new JTextField();
        JToolBar tb7 = new JToolBar();
        tb7.add(b2l14);
        tb7.add(ta14);
        tb7.add(b2l15);
        tb7.add(ta15);
        JLabel b2l16 = new JLabel("Name:");
        JTextField ta16 = new JTextField();
        JLabel b2l17 = new JLabel("Mark:");
        JTextField ta17 = new JTextField();
        JToolBar tb8 = new JToolBar();
        tb8.add(b2l16);
        tb8.add(ta16);
        tb8.add(b2l17);
        tb8.add(ta17);
        JLabel b2l18 = new JLabel("Name:");
        JTextField ta18 = new JTextField();
        JLabel b2l19 = new JLabel("Mark:");
        JTextField ta19 = new JTextField();
        JToolBar tb9 = new JToolBar();
        tb9.add(b2l18);
        tb9.add(ta18);
        tb9.add(b2l19);
        tb9.add(ta19);
        JLabel b2l20 = new JLabel("Name:");
        JTextField ta20 = new JTextField();
        JLabel b2l21 = new JLabel("Mark:");
        JTextField ta21 = new JTextField();
        JToolBar tb10 = new JToolBar();
        tb10.add(b2l20);
        tb10.add(ta20);
        tb10.add(b2l21);
        tb10.add(ta21);
        JButton b3 = new JButton("Save");
        frame2.add(tb1);
        frame2.add(tb2);
        frame2.add(tb3);
        frame2.add(tb4);
        frame2.add(tb5);
        frame2.add(b2l11);
        frame2.add(tb6);
        frame2.add(tb7);
        frame2.add(tb8);
        frame2.add(tb9);
        frame2.add(tb10);
        frame2.add(b3);
        frame2.setSize(700,1000);
        frame2.setLayout(new GridLayout(12, 1));
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton b4 = new JButton("Back");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                frame1.setVisible(false);
                frame3.setVisible(true);
            }
        });
        JScrollPane sp = new JScrollPane(outputArea);
        sp.setBounds(100,0,1200,500);
        frame3.add(sp);
        frame3.add(b4);
        b4.setBounds(600, 500, 200, 100);
        frame3.setBounds(0,0,1400,700);
        frame3.setLayout(null);
        b4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                frame3.setVisible(false);
                frame1.setVisible(true);
                try
                {
                    Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project","postgres","Kairos2895");
                    Statement stmt= con.createStatement();
                    ResultSet res;
                    String ret= "select * from student;";
                    res = stmt.executeQuery(ret);
                    while(res.next())
                    {
                        String name = res.getString(1);
                        outputArea.append("Name:" + name + "\n");
                        String dob = res.getString(2);
                        outputArea.append(dob);
                        String fname = res.getString(3);
                        outputArea.append(fname);
                        String mname = res.getString(4);
                        outputArea.append(mname);
                        String city = res.getString(5);
                        outputArea.append(city);
                        String state = res.getString(6);
                        outputArea.append(state);
                        int yos = res.getInt(7);
                        outputArea.append(String.valueOf(yos));
                        int sem = res.getInt(8);
                        outputArea.append(String.valueOf(sem));
                        int poy = res.getInt(9);
                        outputArea.append(String.valueOf(poy));
                        float cg = res.getFloat(10);
                        outputArea.append(String.valueOf(cg));
                        String s1 = res.getString(11);
                        outputArea.append(s1);
                        int m1 = res.getInt(12);
                        outputArea.append(String.valueOf(m1));
                        String s2 = res.getString(13);
                        outputArea.append(s2);
                        int m2 = res.getInt(14);
                        outputArea.append(String.valueOf(m2));
                        String s3 = res.getString(15);
                        outputArea.append(s3);
                        int m3 = res.getInt(16);
                        outputArea.append(String.valueOf(m3));
                        String s4 = res.getString(17);
                        outputArea.append(s4);
                        int m4 = res.getInt(18);
                        outputArea.append(String.valueOf(m4));
                        String s5 = res.getString(19);
                        outputArea.append(s5);
                        int m5 = res.getInt(20);
                        outputArea.append(String.valueOf(m5));
                    }
                }
                catch(Exception e)
                {
                    System.out.println(e.getMessage());
                }
            }
        });
        frame4.setLayout(new GridLayout(3,2));
        JLabel name1 = new JLabel("Name");
        JLabel sem1 = new JLabel("Sem");
        JTextField n1 = new JTextField();
        JTextField s1 = new JTextField();
        JButton del = new JButton("Confirm");
        frame4.add(name1);
        frame4.add(n1);
        frame4.add(sem1);
        frame4.add(s1);
        frame4.add(del);
        del.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                frame4.setVisible(false);
                frame1.setVisible(true);
                try
                {
                    Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project","postgres","Kairos2895");
                    String ret= "DELETE * FROM student WHERE name = ? and sem = ?";
                    String na1 = name1.getText();
                    int sm1 = Integer.parseInt(sem1.getText());
                    PreparedStatement stmt= con.prepareStatement(ret);
                    stmt.setString(1,na1);
                    stmt.setInt(2,sm1);
                    ResultSet res = stmt.executeQuery();
                }
                catch(Exception e)
                {
                    System.out.println("Deleted");
                }

            }
        });
        b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                frame1.setVisible(false);
                frame4.setVisible(true);
            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                frame1.setVisible(false);
                frame2.setVisible(true);
            }
        });
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    String name = ta1.getText();
                    String dob = ta2.getText();
                    String fname = ta3.getText();
                    String mname = ta4.getText();
                    String city = ta5.getText();
                    String state = ta6.getText();
                    int yos = Integer.parseInt(ta7.getText());
                    int sem = Integer.parseInt(ta8.getText());
                    int poy = Integer.parseInt(ta9.getText());
                    float cg = Float.parseFloat(ta10.getText());
                    String s1 = ta12.getText();
                    int m1 = Integer.parseInt(ta13.getText());
                    String s2 = ta14.getText();
                    int m2 = Integer.parseInt(ta15.getText());
                    String s3 = ta16.getText();
                    int m3 = Integer.parseInt(ta17.getText());
                    String s4 = ta18.getText();
                    int m4 = Integer.parseInt(ta19.getText());
                    String s5 = ta20.getText();
                    int m5 = Integer.parseInt(ta21.getText());
                    Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project","postgres","Kairos2895");
                    String fin = "INSERT INTO Student(name, dob, fname, mname, city, state, yearos, sem, passyr, cgpa, s1n, s1m, s2n, s2m, s3n, s3m, s4n, s4m, s5n, s5m) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement pstmt = con.prepareStatement(fin);
                    pstmt.setString(1, name);
                    pstmt.setString(2, dob);
                    pstmt.setString(3, fname);
                    pstmt.setString(4, mname);
                    pstmt.setString(5, city);
                    pstmt.setString(6, state);
                    pstmt.setInt(7, yos);
                    pstmt.setInt(8, sem);
                    pstmt.setInt(9, poy);
                    pstmt.setFloat(10, cg);
                    pstmt.setString(11, s1);
                    pstmt.setInt(12, m1);
                    pstmt.setString(13, s2);
                    pstmt.setInt(14, m2);
                    pstmt.setString(15, s3);
                    pstmt.setInt(16, m3);
                    pstmt.setString(17, s4);
                    pstmt.setInt(18, m4);
                    pstmt.setString(19, s5);
                    pstmt.setInt(20, m5);
                }
                catch(Exception ex)
                {
                    System.out.println(ex.getMessage());
                }
                frame2.setVisible(false);
                frame1.setVisible(true);
            }
        });
        
                    
    }
}
