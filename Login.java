package bank.management.system;
import javax.swing.*;    //for importing JFrame
import java.awt.*;  //for images
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{

    JButton login,signup,clear;//globally declaring to use it different methods
    JTextField cardTextField;
    JPasswordField pinTextField;  //to hide the password from everyone like in bulletin


    Login(){     //constructor of the class......frame is created here
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg")); //to get the image from the computer resource
        //Cant put the image icon directly into the frame...Jlabel is used for this
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);//object of image class
        ImageIcon i3 = new ImageIcon(i2); //convert to image icon to insert into jlabel

        JLabel label=new JLabel(i3);
        label.setBounds(70, 10, 100, 100);//from left and top..thann the size of logo image
        add(label);

        JLabel text=new JLabel("Welcome to ATM");
        text.setFont(new Font("Raieway",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);

        JLabel cardno=new JLabel("Card No:");
        cardno.setFont(new Font("Raieway",Font.BOLD,28));
        cardno.setBounds(120,150,400,30);
        add(cardno);

        cardTextField=new JTextField();
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);

        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Osward",Font.BOLD,28));
        pin.setBounds(120,220,250,30);
        add(pin);

        pinTextField=new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);

        login=new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this); //to add function to button..to tell that button is clicked here
        add(login);


        clear=new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup=new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        getContentPane().setBackground(Color.WHITE);

        
        setSize(800,480); //frame is created with its length and breadth
        setVisible(true); //for visibility of the created frame
        setLocation(350,200); //frame location from left and top
    }
        //for implementing the interface..we need to overwrite its abstract methods
        public void actionPerformed(ActionEvent ae){ 
            if(ae.getSource()==clear){
                  cardTextField.setText("");
                  pinTextField.setText("");
            }
            else if(ae.getSource()==login){
                  Conn conn=new Conn();
                  String cardnumber=cardTextField.getText();
                  String pinnumber=pinTextField.getText();
                  
                  //Now we get the value from the database..so we use select command
                  String query="select * from login where cardnumber='"+cardnumber+"'and pin='"+pinnumber+"'";  //pin is column name and pinnumber is what i have given just now
                  try{
                     ResultSet rs=conn.s.executeQuery(query);  //store it here
                     
                     if(rs.next()){ //if it has the matching content
                         setVisible(false);
                         new Transactions(pinnumber).setVisible(true);
                     }else{         //if not
                         JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
                     }
                  }
                  catch(Exception e){
                      System.out.println(e);
                  }
            
            }
            else if(ae.getSource()==signup){
                setVisible(false); //to stop the current frame running and next we need to open the sign up page
                new SignupOne().setVisible(true);//as we create its object its constructor will be callleed an dits execute..by default it will be fals so make it true

            }
        }
    
    
    public static void main(String args[]){
        new Login();  //creating the object of the class...when this is called the constructor of the class is called
    }
    
}
