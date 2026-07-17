
/**
 * Write a description of class renu here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.ButtonGroup;

public class GymGUI implements ActionListener
{
    
    ArrayList<GymMember>  cone = new ArrayList<GymMember>(); 
    private JFrame obj;
    private JPanel abc;
    private Color cc;
    private JLabel id1;
    private JLabel id3;
    private JLabel id4;
    private JLabel id5;
    private JLabel id6,labelA;
    private JLabel location1;
    private JLabel email1;
    private JLabel name1;
    private JLabel phone1;
    private JLabel dob1;
    private JLabel membershipdate1;
    private JLabel gender1;
    private JLabel referralsource1,personaltrainer1;
    private JLabel regularmember1,premiummember1;
    private Font Font1;
    private Font Font2;
    private Font Font3;
    private Font Font4;
    private Font Font5;
    private Font Font6;
    private Font Font7;
    private Font Font8;
    private Font Font9,FontA,FontB,FontC,FontD,FontE;
    private JTextField id2,idA,idB,idC;
    private JTextField location2;
    private JTextField email2;
    private JTextField name2;
    private JTextField phone2;
    private JTextField referralsource2,personaltrainer2,textfield1;
    private JComboBox combo1;
    private JComboBox combo2;
    private JComboBox combo3;
    private JComboBox combo4;
    private JComboBox combo5;
    private JComboBox combo6;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JComboBox plan1;
    private JRadioButton button1;
    private JRadioButton button2;
    private ButtonGroup group;
    private JButton button3;
    private JButton button4,button5,button6,button7,button8,button9,button10,button11
    ,button12,button13,button14,button15,button16;
    private Font Font10,Font11,Font12,Font13,Font14,Font15,Font16,Font17,Font18,Font19,
    Font20,Font21,Font22;
 
public void actionPerformed(ActionEvent e) {
    try {
        if (e.getSource() == button14) {
            regularmember();
        } else if (e.getSource() == button15) {
            premiummember();
        } else if (e.getSource() == button3) { // Add Regular Member
            int id = Integer.parseInt(id2.getText());
            for (GymMember gm : cone) {
                if (gm.getId() == id) {
                    JOptionPane.showMessageDialog(null, "Duplicate ID"); return;
                }
            }
            String name = name2.getText();
            String location = location2.getText();
            String phone = phone2.getText();
            String email = email2.getText();
            String gender = button1.isSelected() ? "Male" : (button2.isSelected() ? "Female" : "");
            String dob = combo1.getSelectedItem() + "-" + combo2.getSelectedItem() + "-" + combo3.getSelectedItem();
            String membershipDate = combo4.getSelectedItem() + "-" + combo5.getSelectedItem() + "-" + combo6.getSelectedItem();
            String referral = referralsource2.getText();

            cone.add(new RegularMember(id, name, location, phone, email, gender, dob, membershipDate, referral));
            JOptionPane.showMessageDialog(null, "Regular member added!");
        } else if (e.getSource() == button13) { // Add Premium Member
            int id = Integer.parseInt(id2.getText());
            for (GymMember gm : cone) {
                if (gm.getId() == id) {
                    JOptionPane.showMessageDialog(null, "Duplicate ID"); return;
                }
            }
            String name = name2.getText();
            String location = location2.getText();
            String phone = phone2.getText();
            String email = email2.getText();
            String gender = button1.isSelected() ? "Male" : (button2.isSelected() ? "Female" : "");
            String dob = combo1.getSelectedItem() + "-" + combo2.getSelectedItem() + "-" + combo3.getSelectedItem();
            String membershipDate = combo4.getSelectedItem() + "-" + combo5.getSelectedItem() + "-" + combo6.getSelectedItem();
            String trainer = personaltrainer2.getText();

            cone.add(new PremiumMember(id, name, location, phone, email, gender, dob, membershipDate, trainer));
            JOptionPane.showMessageDialog(null, "Premium member added!");
        } else if (e.getSource() == button16) { // Calculate Discount
            int inputId = Integer.parseInt(idA.getText());
            for (GymMember gm : cone) {
                if (gm instanceof PremiumMember && gm.getId() == inputId) {
                    ((PremiumMember) gm).calculateDiscount();
                    JOptionPane.showMessageDialog(null, "Discount calculated.");
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "Premium member not found.");
        } else if (e.getSource() == button4) { // Activate
            int inputId = Integer.parseInt(idA.getText());
            for (GymMember gm : cone) {
                if (gm.getId() == inputId) {
                    gm.activateMembership();
                    JOptionPane.showMessageDialog(null, "Membership activated!");
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "Member ID not found.");
        } else if (e.getSource() == button5) { // Deactivate
            int inputId = Integer.parseInt(idA.getText());
            for (GymMember gm : cone) {
                if (gm.getId() == inputId) {
                    gm.deactivateMembership();
                    JOptionPane.showMessageDialog(null, "Membership deactivated!");
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "Member ID not found.");
        } else if (e.getSource() == button6) { // Mark Attendance
            int inputId = Integer.parseInt(idA.getText());
            for (GymMember gm : cone) {
                if (gm.getId() == inputId) {
                    if (gm.isActiveStatus()) {
                        gm.markAttendance();
                        JOptionPane.showMessageDialog(null, "Attendance marked!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Membership not active.");
                    }
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "Member ID not found.");
        } else if (e.getSource() == button7) { // Revert
            int inputId = Integer.parseInt(idA.getText());
            for (GymMember gm : cone) {
                if (gm instanceof RegularMember && gm.getId() == inputId) {
                    ((RegularMember) gm).revertRegularMember(idC.getText());
                    JOptionPane.showMessageDialog(null, "Regular member reverted.");
                    return;
                } else if (gm instanceof PremiumMember && gm.getId() == inputId) {
                    ((PremiumMember) gm).revertPremiumMember();
                    JOptionPane.showMessageDialog(null, "Premium member reverted.");
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "Member not found.");
        } else if (e.getSource() == button10) { // Upgrade Plan / Pay Due
            int inputId = Integer.parseInt(idA.getText());
            for (GymMember gm : cone) {
                if (gm instanceof RegularMember && gm.getId() == inputId) {
                    String selectedPlan = (String) plan1.getSelectedItem();
                    String result = ((RegularMember) gm).upgradePlan(selectedPlan);
                    JOptionPane.showMessageDialog(null, result);
                    return;
                } else if (gm instanceof PremiumMember && gm.getId() == inputId) {
                    double amount = Double.parseDouble(textfield1.getText());
                    String result = ((PremiumMember) gm).payDueAmount(amount);
                    JOptionPane.showMessageDialog(null, result);
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "Member not found.");
        } else if (e.getSource() == button11) { // Save
            BufferedWriter bw = new BufferedWriter(new FileWriter("MemberDetails.txt"));
            for (GymMember gm : cone) {
                bw.write("ID: " + gm.getId() + ", Name: " + gm.getName() + ", Email: " + gm.getEmail() + "\n");
            }
            bw.close();
            JOptionPane.showMessageDialog(null, "Saved to file.");
        } else if (e.getSource() == button12) { // Read
            BufferedReader br = new BufferedReader(new FileReader("MemberDetails.txt"));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            br.close();
            JOptionPane.showMessageDialog(null, sb.toString());
        } else if (e.getSource() == button8) { // Display
            for (GymMember gm : cone) {
                gm.display();
            }
        } else if (e.getSource() == button9) { // Clear
            id2.setText(""); name2.setText(""); phone2.setText(""); email2.setText("");
            location2.setText(""); referralsource2.setText(""); personaltrainer2.setText("");
            textfield1.setText(""); idA.setText(""); idC.setText("");
            button1.setSelected(false); button2.setSelected(false);
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(null, "Please enter valid numeric values.");
    } catch (IOException io) {
        JOptionPane.showMessageDialog(null, "File error: " + io.getMessage());
    }
} 
public void regularmember(){
      obj = new JFrame("");
      obj.setTitle("Regular Rember");
      obj.setBounds(90,100,800,600);
      obj.setResizable(false);
      obj.setLayout(null);
      
      //Creating new JPanel
      abc = new JPanel();
      abc.setBounds(0,0,800,800);
      abc.setBackground(Color.GRAY);
      obj.add(abc);
      
      //Object of class: Color
      Color cc = new Color(102, 102, 153);//rgb value
      abc.setBackground(cc);
      abc.setLayout(null);
      
      
      //Creating the JLabel
      id1 = new JLabel("ID:");
      id3 = new JLabel("ID");
      id4 = new JLabel("ID");
      id5 = new JLabel("ID");
      id6 = new JLabel("Plan");
      location1 = new JLabel("Location:");
      email1 = new JLabel("Email:");
      name1 = new JLabel("Name:");
      phone1 = new JLabel("Phone:");
      dob1 = new JLabel("DOB:");
      membershipdate1 = new JLabel("Membershipdate:");
      gender1 = new JLabel("Gender:");
      referralsource1 = new JLabel("Referral Source:");
      regularmember1 = new JLabel("Regular Member");
      //Setting the Bounds
      id1.setBounds(60,50,110,50);
      id3.setBounds(280,350,100,30);
      id4.setBounds(280,400,100,30);
      id5.setBounds(280,450,120,30);
      id6.setBounds(570,290,150,30);
      location1.setBounds(60,90,110,50);
      email1.setBounds(60,130,110,50);
      name1.setBounds(500,50,110,50);
      phone1.setBounds(500,90,110,50);
      dob1.setBounds(60,170,110,50);
      membershipdate1.setBounds(380,200,120,50);
      gender1.setBounds(60,210,100,50);
      referralsource1.setBounds(460,140,130,50);
      regularmember1.setBounds(330,10,160,50);
      //Adding the Components
      abc.add(id1);
      abc.add(id3);
      abc.add(id4);
      abc.add(id5);
      abc.add(id6);
      abc.add(location1);
      abc.add(email1);
      abc.add(name1);
      abc.add(phone1);
      abc.add(dob1);
      abc.add(gender1);
      abc.add(membershipdate1);
      abc.add(referralsource1);
      abc.add(regularmember1);
      //Adding the Font
      Font Font1 = new Font("Arial", Font.PLAIN, 15);
      Font Font2 = new Font("Arial", Font.PLAIN, 15);
      Font Font3 = new Font("Arial", Font.PLAIN, 15);
      Font Font4 = new Font("Arial", Font.PLAIN, 15);
      Font Font5 = new Font("Arial", Font.PLAIN, 15);
      Font Font6 = new Font("Arial", Font.PLAIN, 15);
      Font Font7 = new Font("Arial", Font.PLAIN, 15);
      Font Font8 = new Font("Arial", Font.PLAIN, 15);
      Font Font9 = new Font("Arial", Font.PLAIN, 15);
      Font FontA= new Font("Arial",  Font.PLAIN, 15);
      Font FontB= new Font("Arial",  Font.PLAIN, 15);
      Font FontC= new Font("Arial",  Font.PLAIN, 15);
      Font FontD= new Font("Arial",  Font.PLAIN, 15);
      Font FontE= new Font("Arial",  Font.BOLD,  20);
      //Setting the Font
      id1.setFont(Font1);
      location1.setFont(Font2);
      email1.setFont(Font3);
      name1.setFont(Font4);
      phone1.setFont(Font5);
      dob1.setFont(Font6);
      gender1.setFont(Font7);
      membershipdate1.setFont(Font8);
      referralsource1.setFont(Font9);
      id3.setFont(FontA);
      id4.setFont(FontB);
      id5.setFont(FontC);
      id6.setFont(FontD);
      regularmember1.setFont(FontE);
      //Add components
      abc.add(id1);
      abc.add(id3);
      abc.add(id4);
      abc.add(id5);
      abc.add(id6);
      abc.add(location1);
      abc.add(email1);
      abc.add(name1);
      abc.add(phone1);
      abc.add(dob1); 
      abc.add(membershipdate1);
      abc.add(referralsource1);
      abc.add(regularmember1);
      //Object of a class:JTextField
      id2 = new JTextField("");
      idA = new JTextField("");
      idB = new JTextField("");
      idC = new JTextField("");
      location2 = new JTextField("");
      email2 = new JTextField("");
      name2 = new JTextField("");
      phone2 = new JTextField("");
      referralsource2 = new JTextField("");
      
      //Setting the Bounds
      id2.setBounds(140, 60, 120, 25);
      idA.setBounds(350,350,100,30);
      idB.setBounds(350,400,100,30);
      idC.setBounds(350,450,100,30);
      location2.setBounds(140, 100, 120, 25);
      email2.setBounds(140, 140,130, 25);
      name2.setBounds(600, 60, 120, 25);
      phone2.setBounds(600, 100, 120, 25);
      referralsource2.setBounds(600,150,120,25);
      
      //Add components
      abc.add(id2);
      abc.add(idA);
      abc.add(idB);
      abc.add(idC);
      abc.add(location2);
      abc.add(email2);
      abc.add(name2);
      abc.add(phone2);
      abc.add(referralsource2);
      
      //Object of JComboBox
      Integer [] date = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
      String [] months = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
      Integer [] years = {2001,2002,2003,2004,2005,2006,2007,2008,2009,2010};
      combo1 = new JComboBox(date);
      combo2 = new JComboBox(months);
      combo3 = new JComboBox(years);
      combo1.setBounds(140, 180, 60, 30); // Day combo box
      combo2.setBounds(200, 180, 70, 30); // Month combo box
      combo3.setBounds(270, 180, 100, 30); // Year combo box
      
      //Adding the Components
      abc.add(combo1);
      abc.add(combo2);
      abc.add(combo3);
      //JComboBox for Membershipdate
      combo4 = new JComboBox(date);
      combo5 = new JComboBox(months);
      combo6 = new JComboBox(years);
      combo4.setBounds(510, 210, 60, 30); // Day combo box
      combo5.setBounds(570, 210, 70, 30); // Month combo box
      combo6.setBounds(640, 210, 100, 30); // Year combo box
      //Adding the Components
      abc.add(combo4);
      abc.add(combo5);
      abc.add(combo6);
      
      // Add labels for each combo box
      label1 = new JLabel("Day:");
      label1.setBounds(140, 175, 60, 30); // Label for Day
      abc.add(label1);

      label2 = new JLabel("Month:");
      label2.setBounds(200, 175, 70, 30); // Label for Month
      abc.add(label2);

      label3 = new JLabel("Year:");
      label3.setBounds(270, 175, 100, 30); // Label for Year
      abc.add(label3);
      
      //Object of JComboBox for Plan
      String [] arr = {"Basic", "Standard", "Delux"};
      plan1 = new JComboBox(arr);
      plan1.setBounds(620,290,100,30);
      abc.add(plan1);
      
      //Object of class:JRadioButton
      button1 = new JRadioButton("Male");
      button2 = new JRadioButton("Female");
      button1.setBounds(140,225,60,20);
      button2.setBounds(210,225,70,20);
      abc.add(button1);
      abc.add(button2);
      
      //Object of class:ButtonGroup
       group = new ButtonGroup();
      group.add(button1);
      group.add(button2);
      
    
      //Object of class:JButton
      button3 = new JButton("Add Regular Member");
      button4 = new JButton("Activate");
      button5 = new JButton("Deactivate");
      button6 = new JButton("Mark Attendance");
      button7 = new JButton("Revert Regular Member");
      button8 = new JButton("Display");
      button9 = new JButton("Clear");
      button10 = new JButton("Upgrade Plan");
      button11 = new JButton("Save to File");
      button12 = new JButton("Read From File");
      button15 = new JButton("Change to Premium Member");
      //Setting the Bounds
      button3.setBounds(60,290,200,30); 
      button4.setBounds(90,350,100,30); 
      button5.setBounds(90,400,100,30);  
      button6.setBounds(70,450,140,30);  
      button7.setBounds(320,290,200,30); 
      button8.setBounds(620,350,100,30); 
      button9.setBounds(620,400,100,30); 
      button10.setBounds(600,450,150,30); 
      button11.setBounds(70,500,150,30);  
      button12.setBounds(320,500,150,30);  
      button15.setBounds(570,500,210,30);  
      //Setting the Font
      Font Font10 = new Font("Arial", Font.PLAIN, 15);
      Font Font11 = new Font("Arial", Font.PLAIN, 15);
      Font Font12 = new Font("Arial", Font.PLAIN, 15);
      Font Font13 = new Font("Arial", Font.PLAIN, 15);
      Font Font14 = new Font("Arial", Font.PLAIN, 15);
      Font Font15 = new Font("Arial", Font.PLAIN, 15);
      Font Font16 = new Font("Arial", Font.PLAIN, 15);
      Font Font17 = new Font("Arial", Font.PLAIN, 15);
      Font Font18 = new Font("Arial", Font.PLAIN, 15);
      Font Font19 = new Font("Arial", Font.PLAIN, 15);
      Font Font20 = new Font("Arial", Font.PLAIN, 15);
      Font Font21 = new Font("Arial", Font.PLAIN, 15);
      //Add components
      abc.add(button3);
      abc.add(button4);
      abc.add(button5);
      abc.add(button6);
      abc.add(button7);
      abc.add(button8);
      abc.add(button9);
      abc.add(button10);
      abc.add(button11);
      abc.add(button12);
      abc.add(button15);
      
      button3.addActionListener(this);
      button4.addActionListener(this);
      button5.addActionListener(this);
      button6.addActionListener(this);
      button7.addActionListener(this);
      button8.addActionListener(this);
      button9.addActionListener(this);
      button10.addActionListener(this);
      button11.addActionListener(this);
      button12.addActionListener(this);
 
      button15.addActionListener(this);
      
      obj.setVisible(true);
    
   }
   
     public void premiummember(){
    //Creating new JFrame
    obj = new JFrame("");
    obj.setTitle("Premium Rember");
    obj.setBounds(90,100,800,600);
    obj.setResizable(false);
    obj.setLayout(null);  
      
    //Creating new JPanel
    abc = new JPanel();
    abc.setBounds(0,0,800,800);  
    abc.setBackground(Color.GRAY);
    obj.add(abc);
      
    //Object of class: Color
    Color cc = new Color(102, 102, 153);//rgb value
    abc.setBackground(cc);
    abc.setLayout(null);
    
    
    //Creating the JLabel
    id1 = new JLabel("ID:");
    id3 = new JLabel("ID");
    id4 = new JLabel("ID");
    id5 = new JLabel("ID");
    labelA = new JLabel("Amount");
    location1 = new JLabel("Location:");
    email1 = new JLabel("Email:");
    name1 = new JLabel("Name:");
    phone1 = new JLabel("Phone:");
    dob1 = new JLabel("DOB:");
    membershipdate1 = new JLabel("Membershipdate:");
    gender1 = new JLabel("Gender:");
    personaltrainer1 = new JLabel("Personal Trainer:");
    premiummember1 = new JLabel("Premium Member");
    //Setting the Bounds
    id1.setBounds(60,50,110,50);
    id3.setBounds(210,350,100,30);
    id4.setBounds(400,400,100,30);
    id5.setBounds(400,450,120,30);
    labelA.setBounds(560,290,150,30);
    location1.setBounds(60,90,110,50);
    email1.setBounds(60,130,110,50);
    name1.setBounds(500,50,110,50);
    phone1.setBounds(500,90,110,50);
    dob1.setBounds(60,170,110,50);
    membershipdate1.setBounds(380,200,120,50);
    gender1.setBounds(60,210,100,50);
    personaltrainer1.setBounds(460,140,130,50);
    premiummember1.setBounds(330,10,190,50);
    
    //Adding the Components
    abc.add(id1);
    abc.add(id3);
    abc.add(id4);
    abc.add(id5);
    abc.add(labelA);
    abc.add(location1);
    abc.add(email1);
    abc.add(name1);
    abc.add(phone1);
    abc.add(dob1);
    abc.add(gender1);
    abc.add(membershipdate1);
    abc.add(personaltrainer1);
    abc.add(premiummember1);
    
    Font Font1 = new Font("Arial", Font.PLAIN, 15);
    Font Font2 = new Font("Arial", Font.PLAIN, 15);
    Font Font3 = new Font("Arial", Font.PLAIN, 15);
    Font Font4 = new Font("Arial", Font.PLAIN, 15);
    Font Font5 = new Font("Arial", Font.PLAIN, 15);
    Font Font6 = new Font("Arial", Font.PLAIN, 15);
    Font Font7 = new Font("Arial", Font.PLAIN, 15);
    Font Font8 = new Font("Arial", Font.PLAIN, 15);
    Font Font9 = new Font("Arial", Font.PLAIN, 15);
    Font FontA= new Font("Arial",  Font.PLAIN, 15);
    Font FontB= new Font("Arial",  Font.PLAIN, 15);
    Font FontC= new Font("Arial",  Font.PLAIN, 15);
    Font FontD= new Font("Arial",  Font.PLAIN, 15);
    Font FontE= new Font("Arial",  Font.BOLD,  20);
     
    //Setting the Font
    id1.setFont(Font1);
    location1.setFont(Font2);
    email1.setFont(Font3);
    name1.setFont(Font4);
    phone1.setFont(Font5);
    dob1.setFont(Font6);
    gender1.setFont(Font7);
    membershipdate1.setFont(Font8);
    personaltrainer1.setFont(Font9);
    id3.setFont(FontA);
    id4.setFont(FontB);
    id5.setFont(FontC);
    labelA.setFont(FontD);
    premiummember1.setFont(FontE);
      
    //Add components
    abc.add(id1);
    abc.add(id3);
    abc.add(id4);
    abc.add(id5);
    abc.add(labelA);
    abc.add(location1);
    abc.add(email1);
    abc.add(name1);
    abc.add(phone1);
    abc.add(dob1); 
    abc.add(membershipdate1);
    abc.add(personaltrainer1);
    abc.add(premiummember1);
      
    //Object of a class:JTextField
    id2 = new JTextField("");
    idA = new JTextField("");
    idB = new JTextField("");
    idC = new JTextField("");
    textfield1 = new JTextField("");
    location2 = new JTextField("");
    email2 = new JTextField("");
    name2 = new JTextField("");
    phone2 = new JTextField("");
    personaltrainer2 = new JTextField("");
      
    //Setting the Bounds
    id2.setBounds(140, 60, 120, 25);
    idA.setBounds(240,350,100,30);
    idB.setBounds(240,400,100,30);
    idC.setBounds(240,450,100,30);
    textfield1.setBounds(620,290,100,25);
    location2.setBounds(140, 100, 120, 25);
    email2.setBounds(140, 140,130, 25);
    name2.setBounds(600, 60, 120, 25);
    phone2.setBounds(600, 100, 120, 25);
    personaltrainer2.setBounds(600,150,120,25);
    
    
    //Add components
    abc.add(id2);
    abc.add(idA);
    abc.add(idB);
    abc.add(idC);
    abc.add(textfield1);
    abc.add(location2);
    abc.add(email2);
    abc.add(name2);
    abc.add(phone2);
    abc.add(personaltrainer2);
      
    //Object of JComboBox
    Integer [] date = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
    String [] months = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
    Integer [] years = {2001,2002,2003,2004,2005,2006,2007,2008,2009,2010};
    combo1 = new JComboBox(date);
    combo2 = new JComboBox(months);
    combo3 = new JComboBox(years);
    combo1.setBounds(140, 180, 60, 30); // Day combo box
    combo2.setBounds(200, 180, 70, 30); // Month combo box
    combo3.setBounds(270, 180, 100, 30); // Year combo box
      
    //Adding the Components
    abc.add(combo1);
    abc.add(combo2);
    abc.add(combo3);
    
    //JComboBox for Membershipdate
    combo4 = new JComboBox(date);
    combo5 = new JComboBox(months);
    combo6 = new JComboBox(years);
    combo4.setBounds(510, 210, 60, 30); // Day combo box
    combo5.setBounds(570, 210, 70, 30); // Month combo box
    combo6.setBounds(640, 210, 100, 30); // Year combo box
      
    //Adding the Components
    abc.add(combo4);
    abc.add(combo5);
    abc.add(combo6);
      
    // Add labels for each combo box
    label1 = new JLabel("Day:");
    label1.setBounds(140, 175, 60, 30); // Label for Day
    abc.add(label1);

    label2 = new JLabel("Month:");
    label2.setBounds(200, 175, 70, 30); // Label for Month
    abc.add(label2);

    label3 = new JLabel("Year:");
    label3.setBounds(270, 175, 100, 30); // Label for Year
    abc.add(label3);
      
      
    //Object of class:JRadioButton
    button1 = new JRadioButton("Male");
    button2 = new JRadioButton("Female");
    button1.setBounds(140,225,60,20);
    button2.setBounds(210,225,70,20);
    abc.add(button1);
    abc.add(button2);
    
    //Object of class:ButtonGroup
       group = new ButtonGroup();
      group.add(button1);
      group.add(button2);
      
    
    //Object of class:JButton
    button13 = new JButton("Add Premium Member");
    button4 = new JButton("Activate");
    button5 = new JButton("Deactivate");
    button6 = new JButton("Mark Attendance");
    button7 = new JButton("Revert Premium Member");
    button8 = new JButton("Display");
    button9 = new JButton("Clear");
    button10 = new JButton("Pay Due Amount");
    button11 = new JButton("Save to File");
    button12 = new JButton("Read From File");
    button16 = new JButton("Calculate Discount");
    button14 = new JButton("Change to Regular Member");
    
    //Setting the Bounds
      
    button13.setBounds(60,290,200,30); 
    button4.setBounds(90,350,100,30); 
    button5.setBounds(350,350,100,30);  
    button6.setBounds(75,400,140,30);  
    button7.setBounds(320,290,200,30); 
    button8.setBounds(620,350,100,30); 
    button9.setBounds(620,400,100,30); 
    button10.setBounds(600,450,150,30); 
    button11.setBounds(70,500,150,30);  
    button12.setBounds(320,500,150,30);  
    button16.setBounds(70,450,150,30);  
    button14.setBounds(570,500,210,30);  
   
    //Setting the Font
    Font Font10 = new Font("Arial", Font.PLAIN, 15);
    Font Font11 = new Font("Arial", Font.PLAIN, 15);
    Font Font12 = new Font("Arial", Font.PLAIN, 15);
    Font Font13 = new Font("Arial", Font.PLAIN, 15);
    Font Font14 = new Font("Arial", Font.PLAIN, 15);
    Font Font15 = new Font("Arial", Font.PLAIN, 15);
    Font Font16 = new Font("Arial", Font.PLAIN, 15);
    Font Font17 = new Font("Arial", Font.PLAIN, 15);
    Font Font18 = new Font("Arial", Font.PLAIN, 15);
    Font Font19 = new Font("Arial", Font.PLAIN, 15);
    Font Font20 = new Font("Arial", Font.PLAIN, 15);
    Font Font21 = new Font("Arial", Font.PLAIN, 15);
    Font Font22 = new Font("Arial", Font.PLAIN, 15);
    
    //Add components
    abc.add(button13);
    abc.add(button4);
    abc.add(button5);
    abc.add(button6);
    abc.add(button7);
    abc.add(button8);
    abc.add(button9);
    abc.add(button10);
    abc.add(button11);
    abc.add(button12);
    abc.add(button16);
    abc.add(button14);
    
    button13.addActionListener(this);
    button4.addActionListener(this);
    button5.addActionListener(this);
    button6.addActionListener(this);
    button7.addActionListener(this);
    button8.addActionListener(this);
    button9.addActionListener(this);
    button10.addActionListener(this);
    button11.addActionListener(this);
    button12.addActionListener(this);
    button16.addActionListener(this); 
    button14.addActionListener(this);   
     
    obj.setVisible(true);
    
   

  }
  public static void main(String[] args) {
    GymGUI gui = new GymGUI();
    gui.regularmember();
    gui.premiummember();
}
  
}
