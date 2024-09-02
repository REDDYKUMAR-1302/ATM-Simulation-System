package bank.management.systems;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;
public class WithDrawl extends JFrame implements ActionListener
{
    JLabel Atext;
    JTextField amount;
    JButton WithDraw,back;
    String pinnumber;
    WithDrawl(String pinnumber)
    {
        this.pinnumber=pinnumber;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);
        
        Atext=new JLabel("Enter the amount to be Withdraw:");
        Atext.setBounds(175,300,500,35);
        Atext.setFont(new Font("Raleway",Font.BOLD,15));
        Atext.setForeground(java.awt.Color.WHITE);
        image.add(Atext);
        amount=new JTextField();
        amount.setBounds(175,330,100,35);
        image.add(amount);
        WithDraw =new JButton("WithDraw");
        WithDraw.setBounds(200,400,150,35);
        WithDraw.setFont(new Font("Raleway",Font.BOLD,15));
       
        WithDraw.addActionListener(this);
        image.add(WithDraw);
        back =new JButton("Back");
        back.setBounds(200,440,150,35);
        back.setFont(new Font("Raleway",Font.BOLD,15));
        
        back.addActionListener(this);
        image.add(back);
        
        
        
        setLayout(null);
        setLocation(200,0);
        setVisible(true);
        setBackground(java.awt.Color.WHITE);
        setSize(800,800);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==WithDraw)
        {
           String depositam=amount.getText();
           Date date=new Date();
           if(depositam.equals(""))
           {
               JOptionPane.showMessageDialog(null,"please enter the amount to WithDraw");
           }
           else
           {
               try
               {
               Connec con=new Connec();
               
               ResultSet rs=con.S.executeQuery("select *from bank where pin='"+pinnumber+"'");
               int balance=0;
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
               if(balance<Integer.parseInt(amount.getText()))
               {
                   JOptionPane.showMessageDialog(null,"Insufficient Balance");
                   return;
               }
               String query4="insert into bank values('"+pinnumber+"','"+date+"','WithDrawl','"+depositam+"')";
               con.S.executeUpdate(query4);
               JOptionPane.showMessageDialog(null,"Rs"+depositam+"WithDrawl Successfully");
               setVisible(false);
               new Transactions(pinnumber).setVisible(true);
               }
               catch(Exception e)
               {
                   System.out.println(e);
               }
           }
        }
        else if(ae.getSource()==back)
        {
           setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        
    }
   
    public static void main(String args[]) 
    {
        new WithDrawl("");
    }
}
