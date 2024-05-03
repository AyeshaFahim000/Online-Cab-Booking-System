/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.createaccount;

/**
 *
 * @author prompt computer
 */
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static sun.security.jgss.GSSUtil.login;

public class Login extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4;
    JTextField tf1;
    JTextField pass;
    JButton b1, b2, b3;
    JPanel p1, p2, p3, p4;
    Choice c1;

    Login() {

        //Creating j frame:
        super("Login Page");
        setLayout(null);
        getContentPane().setBackground(Color.lightGray);
        setSize(640, 300);
        setLocation(600, 300);

        //username:
        l1 = new JLabel("Username");
        l1.setBounds(300, 20, 100, 20);
        add(l1);
        tf1 = new JTextField(15);
        tf1.setBounds(400, 20, 150, 20);
        add(tf1);

        //Password
        l2 = new JLabel("Password");
        l2.setBounds(300, 60, 100, 20);
        add(l2);
        pass = new JPasswordField();
        pass.setBounds(400, 50, 150, 20);
        add(pass);

        //login button 
        b1 = new JButton("Login");
        b1.setBounds(330, 160, 100, 20);
        add(b1);
        Color fgcolorb1 = new Color(255, 255, 255);
        b1.setForeground(fgcolorb1);
        Color bgcolorb1 = new Color(102, 102, 255);
        b1.setBackground(bgcolorb1);

        //cancel button 
        b2 = new JButton("Cancel");
        b2.setBounds(450, 160, 100, 20);
        add(b2);
        Color fgcolorb2 = new Color(255, 255, 255);
        b2.setForeground(fgcolorb2);
        Color bgcolorb2 = new Color(255, 0, 0);
        b2.setBackground(bgcolorb2);

        //Signup button 
        b3 = new JButton("Signup");
        b3.setBounds(380, 200, 130, 20);
        add(b3);
        Color fgcolorb3 = new Color(255, 255, 255);
        b3.setForeground(fgcolorb3);
        Color bgcolorb3 = new Color(102, 102, 255);
        b3.setBackground(bgcolorb3);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        //setting jframe visiblity:
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        String line;
        String userName = tf1.getText();
        String password = pass.getText();
        if (ae.getSource() == b1) {
            this.setVisible(false);
            new Location_page().setVisible(true);
            
            //new NewWindow().setVisible(true);
           
            try {
                
                FileReader fr = new FileReader("info.txt");
                BufferedReader br = new BufferedReader(fr);

                while ((line = br.readLine()) != null) {
                    String[] a = line.split("9");
                    System.out.println(a);
                    if (a[0] == userName) {
                        if (a[1] == password) {
                            JOptionPane.showMessageDialog(null, "Login successfully");
                        } else {
                            JOptionPane.showMessageDialog(null, "error");
                        }
                    }
                    else if (userName == "" && password == "") {
                    JOptionPane.showMessageDialog(null, "Please fill ");

                }
                }
            } catch (FileNotFoundException ex) {
                System.out.println(ex);
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            } 

        } else if (ae.getSource() == b2) {
            this.setVisible(false);
        } else if (ae.getSource() == b3) {
            this.setVisible(false);
            new CreateAccount().setVisible(true);
        }
        

           
        
    }

    public static void main(String[] args) {
        Login o = new Login();
    }

}
