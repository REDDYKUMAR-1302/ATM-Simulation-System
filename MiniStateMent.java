package bank.management.systems;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class MiniStateMent extends JFrame implements ActionListener
{
    JButton Back;
    String pinnumber;
    MiniStateMent(String pinnumber)
    {
        this.pinnumber=pinnumber;
        setTitle("MINI STATEMENT");
        JLabel text =new JLabel();
        add(text);
        JLabel bank=new JLabel("INDIAN BANK");
        bank.setFont(new Font("Raleway",Font.BOLD,30));
        bank.setBounds(180,50,500,40);
        add(bank);
        JLabel card=new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        JLabel mini=new JLabel();
        mini.setBounds(20,140,400,600);
        add(mini);
        JLabel balance=new JLabel();
        balance.setBounds(20,450,100,20);
           
           try
           {
               Connec con=new Connec();
               ResultSet rs=con.S.executeQuery("select *from login where pin='"+pinnumber+"'");
               while(rs.next())
               {
                   card.setText("Card number:"+rs.getString("cardnumber").substring(0,4)+"XXXXXXXX"+rs.getString("cardnumber").substring(12));
               }
           }
            catch(Exception e)
            {
                System.out.println(e);
            }
            try
           {
              Connec con=new Connec();

               int bal=0;
               ResultSet rs1=con.S.executeQuery("select *from bank where pin='"+pinnumber+"'");
               while(rs1.next())
               {
                   mini.setText(mini.getText()+ "<html>" +rs1.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +rs1.getString("type") +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs1.getString("amount")+"<br><br><br><br>");
                    if(rs1.getString("type").equals("Deposit"))
                   {
                       bal+=Integer.parseInt(rs1.getString("amount"));
                   }
                   else
                   {
                       bal-=Integer.parseInt(rs1.getString("amount"));
                   }               
               }
                balance.setText("Your current Balance is Rs"+bal);
            }
           
            catch(Exception e)
            {
                System.out.println(e);
            }
            
            
            
        setLayout(null);
        setVisible(true);
        setLocation(300,0);
        setSize(600,900);
    }
    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
    public static void main(String args[]) 
    {
        new MiniStateMent("");
    }
}
