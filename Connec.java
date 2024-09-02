package bank.management.systems;
import java.sql.*;
public class Connec 
{
    Connection C;
    Statement S;
   public Connec()
    {
        try
        {
          C=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","SpaRK@06");
          S=C.createStatement();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
