package bank.management.system;

import java.awt.*;  //images
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;


public class FastCash extends JFrame implements ActionListener{
    
    JButton b1, b2, b3, b4, b5, b6,back;
    String pinnumber;
    FastCash(String pinnumber){
        this.pinnumber=pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text=new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(212,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        b1= new JButton("Rs 100");
        b1.setBounds(170,415,150,30);
        b1.addActionListener(this);  //to perform action
        image.add(b1);
        
        b2=new JButton("Rs 500");
        b2.setBounds(355,415,150,30);
        b2.addActionListener(this);
        image.add(b2);
        
        b3= new JButton("Rs 1000");
        b3.setBounds(170,450,150,30);
        b3.addActionListener(this);
        image.add(b3);
        
        b4=new JButton("Rs 2000");
        b4.setBounds(355,450,150,30);
        b4.addActionListener(this);
        image.add(b4);
        
        b5= new JButton("Rs 5000");
        b5.setBounds(170,485,150,30);
        b5.addActionListener(this);
        image.add(b5);
        
        b6=new JButton("Rs 10000");
        b6.setBounds(355,485,150,30);
        b6.addActionListener(this);
        image.add(b6);
        
        back= new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);      
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true); //to remove that top part of the frame 
        setVisible(true);//it should always be below  bcoz anything after this will not be visible
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else{
            //If some amount is entered to be withdrawn than substract 3 from the string and directly take that amount from there and withdraw it
            String amount = ((JButton)ae.getSource()).getText().substring(3); 
            Conn c = new Conn();
            try{
                //to ge the transactions done from that particular pinnumber and store it in rs
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while (rs.next()) { //to loop over all the transaction of that particular pinnumber
                    if (rs.getString("type").equals("Deposit")) { //if that transaction is a deposit add to balance or else substract
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                } 
                //if balance is less than the amount to be withdrawn
                if (ae.getSource() !=back && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insuffient Balance");
                    return;
                }
                //if balance is sufficient
                Date date = new Date();//create date class object
                String query="insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+amount+" Debited Successfully");
                //to go back to transaction page   
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);

                
                
            }catch(Exception e){
                System.out.println(e);
            }

        }
        
    
    }
    
   
    
    public static void main(String args[]){
        new FastCash("");
    }
}
