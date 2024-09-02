package bank.management.systems;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Deposit extends JFrame implements ActionListener
{
    JLabel Atext;
    JTextField amount1;
    JButton deposit,back;
    String pinnumber;
    Deposit(String pinnumber)
    {
        this.pinnumber=pinnumber;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);
        
        Atext=new JLabel("Enter the amount to be deposited:");
        Atext.setBounds(175,300,500,35);
        Atext.setFont(new Font("Raleway",Font.BOLD,15));
        Atext.setForeground(java.awt.Color.WHITE);
        image.add(Atext);
        amount1=new JTextField("");
        amount1.setBounds(175,330,100,35);
        image.add(amount1);
        deposit =new JButton("Deposit");
        deposit.setBounds(175,430,100,35);
        deposit.setFont(new Font("Raleway",Font.BOLD,15));
        deposit.setForeground(java.awt.Color.BLACK);
        deposit.setBackground(java.awt.Color.WHITE);
        deposit.addActionListener(this);
        image.add(deposit);
        back =new JButton("Back");
        back.setBounds(300,430,100,35);
        back.setFont(new Font("Raleway",Font.BOLD,15));
        back.setBackground(java.awt.Color.WHITE);
        back.setForeground(java.awt.Color.BLACK);
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
        if(ae.getSource()==deposit)
        {
           String amount=amount1.getText();
           Date date=new Date();
           if(amount.equals(""))
           {
               JOptionPane.showMessageDialog(null,"please enter the amount to deposit");
           }
           else
           {
               try
               {
               Connec con=new Connec();
               String query4="insert into bank values ('"+pinnumber+"','"+date+"','Deposit','"+amount+"')";
               con.S.executeUpdate(query4);
               JOptionPane.showMessageDialog(null,"Rs"+amount+"Deposited Successfully");
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
        new Deposit("");
    }
}
