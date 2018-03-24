/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package calculate;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.*;

/**
 *
 * @author MAHBUBAH
 */
public class Calculate extends JFrame implements ActionListener {

   JLabel lblFamilyName = new JLabel("Enter your full name: ");
   JTextField txtFamilyName = new JTextField(10);
   JRadioButton redBachelor = new JRadioButton("Bachelors");
   JRadioButton redMaster = new JRadioButton("Masters");
   ButtonGroup bgpStatus = new ButtonGroup();
   JLabel lblCourses = new JLabel("Enter your number of courses you are taking: ");
   JTextField txtNo = new JTextField(10);
   JButton btnSubmit = new JButton("Submit details");
   JLabel lblFees = new JLabel("The fees for you are:");
   JTextField txtFees = new JTextField(10);
   JButton btnClear = new JButton("clear fields");
    
    public static void main(String[] args) {
        // TODO code application logic here
        Calculate cal = new Calculate();
//        centerFrame(cal);
        cal.setVisible(true);
    }
    
    public Calculate(){
        setLayout(new FlowLayout());
        setSize(300, 220);
        setTitle("Fee Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        bgpStatus.add(redBachelor);
        bgpStatus.add(redMaster);
        add(lblFamilyName);
        add(txtFamilyName);
        add(redBachelor);
        add(redMaster);
        add(lblCourses);
        add(txtNo);
        add(btnSubmit);
        add(lblFees);
        add(txtFees);
        add(btnClear);
        btnSubmit.addActionListener(this);
        btnClear.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSubmit){
            DecimalFormat fmtDollar = new DecimalFormat("$###,##0.00");
            String name = txtFamilyName.getText();
            boolean home = redBachelor.isSelected();
            int courses = Integer.parseInt(txtNo.getText());
            Fees fees = new Fees(name, home, courses);
            double feesDue = fees.calcFees();
            txtFees.setText(fmtDollar.format(feesDue));
            
        }
        if (e.getSource() == btnClear){
            txtFamilyName.setText("");
            txtNo.setText("");
            txtFees.setText("");
        }
    }
  
}

class Fees{
    static String name;
    static boolean home;
    static int courses;
    
    
    public Fees(String n, boolean h, int c){
        name = setName(n);
        home = h;
        courses = setCourses(c);
    }
    
    private String setName(String n){
        n = n.toLowerCase();
        n = n.substring(0, 1).toUpperCase()+n.substring(1);
        System.out.println(n);
        return n;
    }
    private int setCourses(int c){
        if(c<0){
            c=0;
        }
        return c;
    }
    
    public static double calcFees(){
        final int BACHELORS_FEE = 600;
        final int MASTERS_FEE = 2000;
        
//        if ("Wicks".equalsIgnoreCase(name)){
//            return 0;
        if(home){
            return BACHELORS_FEE * courses;
        }else{
            return MASTERS_FEE * courses;
        }
    }
     
}