package bank.management.systems;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Balance extends JFrame implements ActionListener
{
        JButton Back;
        String pinnumber;

        Balance(String pinnumber)
        {
            this.pinnumber=pinnumber;
            ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
            Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
            ImageIcon i3=new ImageIcon(i2);
            JLabel image=new JLabel(i3);
            image.setBounds(0,0,900,900);
            add(image);
            Back=new JButton("Back");
            Back.setBounds(380,500,100,30);
            Back.addActionListener(this);
            image.add( Back);
            Connec con=new Connec();
            int balance=0;

           try
           {
               ResultSet rs=con.S.executeQuery("select *from bank where pin='"+pinnumber+"'");
               while(rs.next())
               {
                   if(rs.getString("type").equals("Deposit"))
                   {
                       balance+=Integer.parseInt(rs.getString("amount"));
                   }
                   else
                   {
                       balance-=Integer.parseInt(rs.getString("amount"));
                   }
               }
           }
            catch(Exception e)
            {
                System.out.println(e);
            }
            
            JLabel text =new JLabel("Your current account Balance is Rs: "+balance);
            text.setBounds(180,350,500,40);
            text.setFont(new Font("Raleway",Font.BOLD,16));
            text.setForeground(java.awt.Color.WHITE);
            image.add(text);
            
            
            
            setLayout(null);
            setVisible(true);
            setLocation(300,0);
            setSize(900,900);
        }
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getSource().equals(Back))
            {
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }
        }
    
    public static void main(String args[]) 
    {
        new Balance("");
    }
}
