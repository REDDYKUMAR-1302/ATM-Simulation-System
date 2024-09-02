package bank.management.systems;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class Pinchange extends JFrame implements ActionListener
{
    JTextField Pin,Rpin;
    JButton Change,Back;
    String pinnumber;
    Pinchange(String pinnumber)
    {
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        JLabel text =new JLabel("Change Your Pin");
        text.setBounds(250,300,500,35);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        text.setForeground(java.awt.Color.WHITE);
        image.add(text);
        JLabel Ptext =new JLabel("New Pin:");
        Ptext.setBounds(160,350,100,35);
        Ptext.setFont(new Font("Raleway",Font.BOLD,20));
        Ptext.setForeground(java.awt.Color.WHITE);
        image.add(Ptext);
        JLabel Rtext =new JLabel("Re-Enter Pin:");
        Rtext.setBounds(160,390,150,35);
        Rtext.setFont(new Font("Raleway",Font.BOLD,20));
        Rtext.setForeground(java.awt.Color.WHITE);
        image.add(Rtext);
        Pin=new JTextField();
        Pin.setBounds(300,350,200,35);
        image.add(Pin);
        Rpin=new JTextField();
        Rpin.setBounds(300,390,200,35);
        image.add(Rpin);
        Change =new JButton("Change");
        Change.setBounds(380,460,100,30);
        Change.addActionListener(this);
        image.add( Change);
        Back=new JButton("Back");
        Back.setBounds(380,500,100,30);
        Back.addActionListener(this);
        image.add( Back);
        
        
        
        
        setSize(900,900);
        setLocation(100,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource().equals(Change))
        {
            try
            {
                String npin=Pin.getText();
                String rpin=Rpin.getText();
                if(!npin.equals(rpin))
                {
                    JOptionPane.showMessageDialog(null,"Entered Pin does not match");
                }
                if(npin.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Please enter Your pin");
                    return;
                }
                Connec con=new Connec();
                String query6 ="update bank set pin='"+rpin+"' where pin='"+pinnumber+"'";
                String query7="update login set pin='"+rpin+"' where pin='"+pinnumber+"'";
                String query8="update signup3 set pinnumber='"+rpin+"' where pinnumber='"+pinnumber+"'";
                con.S.executeUpdate(query6);
                con.S.executeUpdate(query7);
                con.S.executeUpdate(query8);
                JOptionPane.showMessageDialog(null,"PIn Changed Succesfully");
                setVisible(false);
                new Login().setVisible(true);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else
        {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
            
        }
        
                
    }
    
    public static void main(String args[]) 
    {
        new Pinchange("");
    }
}
