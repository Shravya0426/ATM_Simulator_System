package bank.management.system;
import javax.swing.*;
import java.awt.*; //for background color and all
import java.awt.event.*;


public class SignupTwo extends JFrame implements ActionListener{
    
    
    JTextField pan,aadhar;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion,category,occupation,education,income;
    String formno;  //using it as a common thing 
    
    SignupTwo(String formno){
        this.formno=formno;
        
        setLayout(null);//by default it will be border layout and aligned center..which has to be changed
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        JLabel additionalDetails=new JLabel("Page 2: Addditional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));  
        additionalDetails.setBounds(290,80,400,40); 
        add(additionalDetails);       
        
        JLabel rel=new JLabel("Religion:");
        rel.setFont(new Font("Raleway",Font.BOLD,20));  
        rel.setBounds(100,140,100,30); 
        add(rel);
        
        String valReligion[]={"Hindu","Muslim","SIkh","Christian","Other"};
        religion=new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
       
               
        JLabel cate=new JLabel("Category:");
        cate.setFont(new Font("Raleway",Font.BOLD,20));  
        cate.setBounds(100,190,200,30); 
        add(cate);
        
        String valcategory[] = {"General","OBC","SC","ST","Other"};
        category = new JComboBox(valcategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);
        
        
        JLabel inc=new JLabel("Income:");
        inc.setFont(new Font("Raleway",Font.BOLD,20));  
        inc.setBounds(100,240,100,30); 
        add(inc);
        
        String incomecategory[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
        income = new JComboBox(incomecategory);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);
        
        
        JLabel edu=new JLabel("Educational:");
        edu.setFont(new Font("Raleway",Font.BOLD,20));  
        edu.setBounds(100,290,200,30); 
        add(edu);
        
        
        JLabel quali=new JLabel("Qualification:");
        quali.setFont(new Font("Raleway",Font.BOLD,20));  
        quali.setBounds(100,315,200,30); 
        add(quali);
        
        String eduactionValues[] = {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
        education = new JComboBox(eduactionValues);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.WHITE);
        add(education);
        
                
        JLabel occu=new JLabel("Occupation:");
        occu.setFont(new Font("Raleway",Font.BOLD,20));  
        occu.setBounds(100,390,200,30); 
        add(occu);
        
        String occupationValues[] =  {"Salaried","Self-Employmed","Business","Student","Retired","Others"};
        occupation = new JComboBox(occupationValues);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
                
        JLabel panno=new JLabel("PAN Number:");
        panno.setFont(new Font("Raleway",Font.BOLD,20));  
        panno.setBounds(100,440,200,30); 
        add(panno);
        
        pan=new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300,440,400,30);
        add(pan);
 
        
        JLabel aadh=new JLabel("Aadhar Number:");
        aadh.setFont(new Font("Raleway",Font.BOLD,20));  
        aadh.setBounds(100,490,200,30); 
        add(aadh);
        
        aadhar=new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);
        
        
        JLabel senior=new JLabel("Senior Citizen:");
        senior.setFont(new Font("Raleway",Font.BOLD,20));  
        senior.setBounds(100,540,200,30); 
        add(senior);
        
        syes=new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno=new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);
                
        ButtonGroup seniorgroup=new ButtonGroup();
        seniorgroup.add(syes);
        seniorgroup.add(sno);
        
              
        JLabel verify=new JLabel("Existing Account:");
        verify.setFont(new Font("Raleway",Font.BOLD,20));  
        verify.setBounds(100,590,200,30); 
        add(verify);

        eyes=new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno=new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);
               
        ButtonGroup verifygroup=new ButtonGroup();
        verifygroup.add(eyes);
        verifygroup.add(eno);
        
        
        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD, 14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){ 
        String sreligion = (String) religion.getSelectedItem(); //typecasting to convert to string
        String scategory = (String) category.getSelectedItem(); //this function is used to select the items from the dropdown
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String)occupation.getSelectedItem();
        String seniorcitizen=null;
        if(syes.isSelected()){
           seniorcitizen="Yes";
        }else if(sno.isSelected()){
            seniorcitizen="No";
        }
        
        String existingaccount=null;
        if(eyes.isSelected()){
           existingaccount="Yes";
        }else if(eno.isSelected()){
            existingaccount="No";
        }
        
        
        String span=pan.getText();
        String saadhar=aadhar.getText();
       
        
        try{
                Conn c=new Conn();
                String query="insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+existingaccount+"','"+seniorcitizen+"')";
                c.s.executeUpdate(query); //to run the query in mysql
                
                //Signup3 object
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            
        }
        catch(Exception e){
           System.out.println(e);
            
        }
       
    }
    
    
    
    public static void main(String args[]){
        new SignupTwo("");
        
    }
    
}
