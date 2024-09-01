//This page is same as the deposit page

package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener{
    
    JTextField amount;
    JButton withdraw,back;
    String pinnumber;
        
    Withdrawl(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT); //Image class from awt
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("ENTER THE AMOUNT YOU WANT TO WITHDRAW");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 14));
        text.setBounds(170,300,400,20);
        image.add(text);
        
        amount=new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170,350,320,25);
        image.add(amount);
        
        withdraw = new JButton("WITHDRAW");
        withdraw.setBounds(355,485,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);  
        
        
        setSize(900,900);
        
        setLocation(300,0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==withdraw){
            
            String number= amount.getText();  //to get the amount entered
            Date date = new Date();
            
            if(number.equals("")){  //if no amount is entered
                JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
            }
            else{
              try{
                //if amount is entered than bouild connection and write query
                Conn conn = new Conn();
                //nextline is query table 'bank' created in mysql
                String query="insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+number+"')";
                conn.s.executeUpdate(query);
                //if deposit is successful than below
                JOptionPane.showMessageDialog(null, "Rs. "+number+" Withdraw Successfully");
                setVisible(false);  
              }
              catch(Exception e){
                  System.out.println(e);
                    
              }
            }
        }
        else if(ae.getSource()==back){  //to go back to transaction page
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);           
        }
    
    }    
    
    public static void main(String[] args){
        new Withdrawl(""); //putting empty strimg using ""
    }   
}
