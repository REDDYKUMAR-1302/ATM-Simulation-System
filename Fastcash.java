package bank.management.systems;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class Fastcash extends JFrame implements ActionListener{
    JButton Hun,Back,Fhun,Thou,Tthou,Fthou,Tethou;
    String pinnumber;
    Fastcash(String pinnumber) 
    {
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image);
        JLabel text =new JLabel("please select your WithDrawl amount");
        text.setBounds(165,300,500,35);
        text.setFont(new Font("Raleway",Font.BOLD,20));
        text.setForeground(java.awt.Color.WHITE);
        image.add(text);
        Hun=new JButton("Rs100");
        Hun.setBounds(170,350,150,30);
        Hun.addActionListener(this);
        image.add(Hun);
        Fhun=new JButton("Rs500");
        Fhun.setBounds(350,350,150,30);
        Fhun.addActionListener(this);
        image.add( Fhun);
        Thou=new JButton("Rs1000");
        Thou.setBounds(170,385,150,30);
        Thou.addActionListener(this);
        image.add( Thou);
        Tthou=new JButton("Rs2000");
        Tthou.setBounds(350,385,150,30);
        Tthou.addActionListener(this);
        image.add( Tthou);
        Fthou=new JButton("Rs5000");       
        Fthou.setBounds(170,420,150,30);
        Fthou.addActionListener(this);
        image.add( Fthou);
        Tethou=new JButton("Rs10000");
        Tethou.setBounds(350,420,150,30);
        Tethou.addActionListener(this);
        image.add( Tethou);
        Back=new JButton("Back");
        Back.addActionListener(this);
        Back.setBounds(380,500,100,30);
        image.add( Back);
        
        setLocation(300,100);
        setSize(800,700);
        image.setBounds(0,0,900,900);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==Back)
        {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
       
        else
        {
           String amount=((JButton)ae.getSource()).getText().substring(2);
           Connec con=new Connec();
           try
           {
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
               if(ae.getSource()!=Back && balance<Integer.parseInt(amount))
               {
                   JOptionPane.showMessageDialog(null,"Insufficient Balance");
                   return;
               }
               Date date=new Date();
               String query5="insert into bank values('"+pinnumber+"','"+date+"','Withdraw','"+amount+"')";
               con.S.executeUpdate(query5);
               JOptionPane.showMessageDialog(null,"Rs"+amount+"Debited successfully");
               setVisible(false);
               new Transactions(pinnumber).setVisible(true);
           }
           catch(Exception e)
           {
               System.out.println(e);
           }
        }
    }
    public static void main(String args[])
    {
       new Fastcash("");
    }
}
