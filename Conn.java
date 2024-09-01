package bank.management.system;

import java.sql.*;

//for connecting..by using jdbc connectivity
public class Conn {
    Statement s;
    Connection c;
    public Conn(){
        try{//mysql is an external entity...so to handle the runtime errors
              
            c=DriverManager.getConnection("jdbc:mysql:/bankmanagementsystem","root","Shravya_26"); //creating connection
            s=c.createStatement();  //creating the statement
            
        }catch(Exception e){
            System.out.println(e);    
        }
        
    }
}
