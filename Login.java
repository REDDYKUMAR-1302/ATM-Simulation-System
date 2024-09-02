package bank.management.systems;
import java.awt.*;
import javax.swing.*; 
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements  ActionListener       
{
    JButton login,signup,clear;
    JTextField Cardtext;
    JPasswordField Pintext;
    Login()
    {
        setTitle("Automated Teller Machine");
        setLayout(null);
        ImageIcon I1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image I2=I1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon I3=new ImageIcon(I2);
        JLabel label=new JLabel(I3);
        label.setBounds(70,10,100,100);
        add(label);
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
        JLabel text=new JLabel("Welcome to Atm");
        add(text);
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        JLabel cardno=new JLabel("Card No   :");
        cardno.setFont(new Font("Raleway",Font.BOLD,20));
        cardno.setBounds(120,150,150,20);
        add(cardno);
         Cardtext=new JTextField();
        Cardtext.setBounds(230,150,250,30);
        add(Cardtext);
        JLabel pin=new JLabel("PIN          :");
        add(pin);
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setBounds(120,220,400,20);
        Pintext=new JPasswordField();
        Pintext.setBounds(230,220,250,30);
        add(Pintext);
      login=new JButton("Sign In");
        login.setBounds(220,300,100,30);
        add(login);
        login.addActionListener(this);
        login.setBackground(java.awt.Color.BLACK);
        login.setForeground(java.awt.Color.WHITE);
      clear=new JButton("Clear");
        clear.setBounds(350,300,100,30);
        clear.addActionListener(this);
        add(clear);
        clear.setBackground(java.awt.Color.BLACK);
        clear.setForeground(java.awt.Color.WHITE);
         signup=new JButton("Sign up");
        signup.setBounds(220,350,230,30);
        signup.addActionListener(this);
        add(signup);
        signup.setBackground(java.awt.Color.BLACK);
        signup.setForeground(java.awt.Color.WHITE);
        
        
        getContentPane().setBackground(java.awt.Color.WHITE);

        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==clear)
        {
            Cardtext.setText(" ");
            Pintext.setText("");
            
        }
        else if(ae.getSource()==login)
        {
            Connec c=new Connec();
            String cardnumber=Cardtext.getText();
            String pinnumber=Pintext.getText();
            String query3="select *from login where cardnumber='"+cardnumber+"' and pin='"+pinnumber+"'";
            try
            {
                ResultSet rs=c.S.executeQuery(query3);
                if(rs.next())
                {
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Incorrect password or card number" );
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        } 
        else if(ae.getSource()==signup)
        {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
   public static void main(String args[])
   {
       new Login();
   }
}
