import java.util.*;
import java.sql.*;

public class Q3
{
    private static String url ="jdbc:mysql://localhost/ri_db";
    private static String user ="test";
    private static String pwd ="test123";
    private static Scanner scan = new Scanner(System.in);

    private static void print(Connection con) throws Exception
    {
        try{
            Statement printStmt = con.createStatement();
            String query = "SELECT * FROM customer";
            ResultSet res = printStmt.executeQuery(query);
            while(res.next())
            {
                System.out.println("ID: "+res.getInt(1)+", Name: "+res.getString(2)+", Contact Information: "+res.getString(3)+", Subscription Plan: "+res.getString(4)+", Payment History: "+res.getString(5));
            }
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
    }
    
    private static void update(Connection con) throws Exception
    {
        try
        {
            String query ="UPDATE customer SET name=?, contact_information=?,subscription_plan=?,payment_history=? WHERE customer_id=?";
            int cust_id = scan.nextInt();
            scan.nextLine();
            String name = scan.nextLine();
            String contact = scan.nextLine();
            String subscription = scan.nextLine();
            String paymentHistory = scan.nextLine();
            
            PreparedStatement updateStmt = con.prepareStatement(query);
                
            updateStmt.setString(1,name);
            updateStmt.setString(2,contact);
            updateStmt.setString(3,subscription);
            updateStmt.setString(4,paymentHistory);
            updateStmt.setInt(5,cust_id);
            int status = updateStmt.executeUpdate();
            if(status>0)
            {
                System.out.println("Customer record updated successfully.");
                print(con);
            }
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
    }
    private static void insert(Connection con) throws Exception
    {
        try
        {
            String query ="INSERT INTO customer VALUES(?,?,?,?,?)";
            int cust_id = scan.nextInt();
            scan.nextLine();
            String name = scan.nextLine();
            String contact = scan.nextLine();
            String subscription = scan.nextLine();
            String paymentHistory = scan.nextLine();
                
            PreparedStatement insertStmt = con.prepareStatement(query);
                
            insertStmt.setInt(1,cust_id);
            insertStmt.setString(2,name);
            insertStmt.setString(3,contact);
            insertStmt.setString(4,subscription);
            insertStmt.setString(5,paymentHistory);
            int status = insertStmt.executeUpdate();
            
            if(status>0)
            {
                System.out.println("Customer record inserted successfully.");
                print(con);
            }
            
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
    }
    
    public static void main(String args[]) throws Exception
    {
        Connection con = DriverManager.getConnection(url,user,pwd);
        try{
            
            int op = scan.nextInt();
            
            if(op==1)
            {
                insert(con);   
            }
            else if(op==2)
            {
                update(con);
            }
            else if(op==3)
            {
                print(con);
            }
            else{
                System.out.println("Invalid operation number. Please try again.");
            }
        }
        catch(Exception e)
        {
            System.out.print(e);
            
        }
    }
}