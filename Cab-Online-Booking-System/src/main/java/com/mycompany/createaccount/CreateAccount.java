/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.createaccount;

/**
 *
 * @author prompt computer
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class CreateAccount extends JFrame implements ActionListener {

    JLabel label, label1, label2, label3, label4, label5,label6;
    JTextField t1, t2;
    JRadioButton male, female;
    JComboBox day, month, year;
    JTextArea tal;
    JTextField pass; 
    JCheckBox terms;
    JButton submit;
    JButton Signin;
    JLabel msg;

    JTextArea screen;

    CreateAccount() {
        setTitle(" ");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);


        label = new JLabel("ACCOUNT");
        label.setBounds(20, 10, 120, 20);
        c.add(label);
        
        
        

        label1 = new JLabel("USERNAME");
        label1.setBounds(20, 50, 100, 20);
        c.add(label1);
        t1 = new JTextField();
        t1.setBounds(130, 50, 100, 20);
        c.add(t1);

        label2 = new JLabel("MOBILE_NUMBER");
        label2.setBounds(20, 100, 100, 20);
        c.add(label2);
        t2 = new JTextField();
        t2.setBounds(130, 100, 100, 20);
        c.add(t2);

        label3 = new JLabel("Gender");
        label3.setBounds(20, 150, 100, 20);
        c.add(label3);

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        male.setBounds(130, 150, 80, 20);
        female.setBounds(220, 150, 80, 20);
        male.setSelected(true);
        c.add(male);
        c.add(female);

        ButtonGroup gen = new ButtonGroup();
        gen.add(male);
        gen.add(female);

        label4 = new JLabel("DOB");
        label4.setBounds(20, 200, 100, 20);
        c.add(label4);
        String days[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        String months[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String years[] = {"2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012",
             "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001"};
        day = new JComboBox(days);
        month = new JComboBox(months);
        year = new JComboBox(years);

        day.setBounds(130, 200, 50, 20);
        month.setBounds(190, 200, 50, 20);
        year.setBounds(250, 200, 60, 20);

        c.add(day);
        c.add(month);
        c.add(year);

        label5 = new JLabel("Address");
        label5.setBounds(20, 250, 100, 20);
        c.add(label5);

        tal = new JTextArea();
        tal.setBounds(130, 240, 200, 50);
        c.add(tal);
        
        label6=new JLabel("Password");
        label6.setBounds(20,300,100,20);
        c.add(label6);
        
        pass=new JPasswordField();
        pass.setBounds(130,300,100,20);
        c.add(pass);

        terms = new JCheckBox("Please accept terms and condition");
        terms.setBounds(50, 350, 250, 20);
        c.add(terms);

        submit = new JButton("submit");
        submit.setBounds(150, 400, 80, 20);
        c.add(submit);
        Color fgcolorsubmit=new Color(255,255,255);
        submit.setForeground(fgcolorsubmit);
        Color bgcolorsubmit = new Color(102,102,255);
        submit.setBackground(bgcolorsubmit);    
        submit.addActionListener(this);

        Signin = new JButton("Signin");
        Signin.setBounds(150, 440, 80, 20);
        c.add(Signin);
        Color fgcolorSignin=new Color(255,255,255);
        Signin.setForeground(fgcolorSignin);
        Color bgcolorSignin = new Color(102,102,255);
        Signin.setBackground(bgcolorSignin);  
        Signin.addActionListener(this);

        screen = new JTextArea();
        screen.setBounds(350, 50, 300, 300);
        c.add(screen);

        msg = new JLabel("");
        msg.setBounds(20, 520, 250, 20);
        c.add(msg);
        c.setBackground(Color.LIGHT_GRAY);

        setVisible(true);
    }

    @Override
    @SuppressWarnings("override")
    public void actionPerformed(ActionEvent e) {
        if (terms.isSelected()) {
            try {
                msg.setText("Successfully Registered !!");
                String name = t1.getText();
                String mobile = t2.getText();
                String gender = "male";
                if (female.isSelected()) {
                    gender = "female";
                }
                String dob = day.getSelectedItem() + "-" + month.getSelectedItem() + "-" + year.getSelectedItem();
                String address = tal.getText();
                String password=pass.getText();

                screen.setText("Name  : " + name + "\n" + "Mobile_Number  : " + mobile + "\n" + "Gender  : " + gender + "\n"
                        + "DOB  : " + dob + "\n" + "Address  : " + address+"\n"+"Password  :"+password);

                File myfile = new File("info.txt");
                myfile.createNewFile();
                FileWriter o = new FileWriter("info.txt", true);
                o.write(name);
                o.write(mobile+"\n");
                o.write(gender+"\n");
                o.write(dob+"\n");
                o.write(address+"\n");
                o.write(password+"\n"+"\n\n");
            o.close();
            } catch (IOException ex) {
                System.out.println(ex);
               
            }
            try{
                FileReader r=new FileReader("info.txt");
                int i;
                while((i=r.read())!=-1){
                    System.out.println(i);
                }
            }
            catch(IOException ex){
                System.out.println(ex);
                
            }  if (e.getSource() == Signin) {
            this.setVisible(false);
            new Login().setVisible(true);
        } 
            
            
        }
       
    }   
    public static void main(String[] args) {
        CreateAccount w = new CreateAccount();
    }
        
    }


