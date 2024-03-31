import java.util.*;
import java.sql.*;

public class Q4{
    public static void main(String args[]) throws Exception
    {
        try{
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost/ri_db";
            String user = "test";
            String pwd = "test123";
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pwd);
            Statement stmt = con.createStatement();
            String query = "SELECT lower(Department_Name) FROM department";
            ResultSet res = stmt.executeQuery(query);
            while(res.next())
            {
                System.out.println(res.getString(1));
            }
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
    }
}
 {
    
}
