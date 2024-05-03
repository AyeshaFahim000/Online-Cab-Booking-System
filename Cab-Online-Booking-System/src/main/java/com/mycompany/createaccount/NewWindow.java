/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.createaccount;

/**
 *
 * @author prompt computer
 */
import java.awt.Container;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
public class NewWindow extends JFrame implements ActionListener{
    JRadioButton luxaryButton;
    JRadioButton miniButton;
   // JLabel label;
  
    JButton myButton = new JButton ("BOOKING");
    
    NewWindow(){
           setLocation(100,100);  
        myButton.setBounds(100,160,200,40);
        myButton.setFocusable(false);
        myButton.addActionListener((ActionListener) this);
        setSize(420,420);
        setLocation(200,200);
        
//        Container c = getContentPane();
//        
//        label = new JLabel("BOOKING");
//        label.setBounds(20, 10, 120, 20);
//        c.add(label);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        luxaryButton =new JRadioButton("MINI");
        miniButton =new JRadioButton("LUXARY");
        
        ButtonGroup group = new ButtonGroup();
        group.add(luxaryButton);
        group.add(miniButton);
        myButton.setBounds(130, 150, 80, 20);
        myButton.setFocusable(false);
        myButton.addActionListener((ActionListener) this);
        
        luxaryButton.addActionListener(this);
        
        miniButton.addActionListener(this);
        
        this.add(luxaryButton);
        this.add(miniButton);
       
        this.setVisible(true);
        
    }
    
    @Override
    public void actionPerformed (ActionEvent e){
        if(e.getSource()==luxaryButton){
            
            Mini_Page mymini = new Mini_Page();
            new Mini_Page().setVisible(true);
            this.setVisible(false);
            
        }else{
            Luxury_Page l=new Luxury_Page();
            new Luxury_Page().setVisible(true);
            this.setVisible(false);
        }
    }
}
