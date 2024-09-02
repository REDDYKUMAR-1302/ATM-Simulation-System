package bank.management.systems;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Transactions extends JFrame implements ActionListener{
    JButton Deposit,WithDraw,Fastcash,Mstate,Benq,Pchange,Exit;
    String pinnumber;
    Transactions(String pinnumber) 
    {
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image);
        JLabel text =new JLabel("please select your transaction");
        text.setBounds(175,300,500,35);
        text.setFont(new Font("Raleway",Font.BOLD,20));
        text.setForeground(java.awt.Color.WHITE);
        image.add(text);
        Deposit=new JButton("Deposit");
        Deposit.setBounds(170,350,150,30);
        Deposit.addActionListener(this);
        image.add(Deposit);
        WithDraw=new JButton("Cash WithDrawl");
        WithDraw.setBounds(350,350,150,30);
        WithDraw.addActionListener(this);
        image.add( WithDraw);
        Fastcash=new JButton("FastCash");
        Fastcash.setBounds(170,385,150,30);
        Fastcash.addActionListener(this);
        image.add( Fastcash);
        Mstate=new JButton("Ministatement");
        Mstate.setBounds(350,385,150,30);
        Mstate.addActionListener(this);
        image.add( Mstate);
        Benq=new JButton("Balance Enquiry");       
        Benq.setBounds(170,420,150,30);
        Benq.addActionListener(this);
        image.add( Benq);
        Pchange=new JButton("Pin Change");
        Pchange.setBounds(350,420,150,30);
        Pchange.addActionListener(this);
        image.add( Pchange);
        Exit=new JButton("Exit");
        Exit.addActionListener(this);
        Exit.setBounds(380,500,100,30);
        image.add( Exit);
        
        setLocation(300,100);
        setSize(800,700);
        image.setBounds(0,0,900,900);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==Exit)
        {
            System.exit(0);
        }
        else if(ae.getSource()==Deposit)
        {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==WithDraw)
        {
            setVisible(false);
            new WithDrawl(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==Fastcash)
        {
            setVisible(false);
            new Fastcash(pinnumber).setVisible(true);
        }
        else if(ae.getSource().equals(Pchange))
        {
            setVisible(false);
            new Pinchange(pinnumber).setVisible(true);
        }
        else if(ae.getSource().equals(Benq))
        {
            setVisible(false);
            new Balance(pinnumber).setVisible(true);
        }
        else if(ae.getSource().equals(Mstate))
        {
            setVisible(true);
            new MiniStateMent(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[])
    {
       new Transactions("");
    }
}
