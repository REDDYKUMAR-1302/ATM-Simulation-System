package bank.management.systems;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{
    JLabel l1,card,cardde,Acctype,number,pin,pinno,pindet,Serv;
    JRadioButton type1,type2,type3;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    SignupThree(String formno)
    {
        formno=this.formno;
        System.out.println(formno);
        setLayout(null);
         l1=new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        add(l1);
        l1.setBounds(280,40,400,40);
        Acctype=new JLabel("Account Type:");
        Acctype.setFont(new Font("Raleway",Font.BOLD,20));
        add(Acctype);
        Acctype.setBounds(80,200,400,40);
        type1=new JRadioButton("Savings");
        type1.setFont(new Font("Raleway",Font.BOLD,20));
        type1.setBackground(java.awt.Color.WHITE);
        type1.setBounds(285,200,150,40);
        add(type1);
        type2=new JRadioButton("Fixed Deposit");
        type2.setFont(new Font("Raleway",Font.BOLD,20));
        type2.setBackground(java.awt.Color.WHITE);
        type2.setBounds(430,200,270,40);
        add(type2);
        type3=new JRadioButton("Current");
        type3.setFont(new Font("Raleway",Font.BOLD,20));
        type3.setBackground(java.awt.Color.WHITE);
        type3.setBounds(700,200,280,40);
        add(type3);
        ButtonGroup bg=new ButtonGroup();
        bg.add(type1);
        bg.add(type2);
        bg.add(type3);
        card=new JLabel("Card :");
        card.setFont(new Font("Raleway",Font.BOLD,20));
        card.setBounds(80,300,400,40);
        add(card);
        cardde=new JLabel("(your 16 digit card number)");
        cardde.setFont(new Font("Raleway",Font.BOLD,15));
        cardde.setBounds(80,330,400,40);
        add(cardde);
        number=new JLabel("XXXX-XXXX-XXXX-4642");
        number.setBackground(java.awt.Color.WHITE);
        number.setFont(new Font("Raleway",Font.BOLD,20));
        number.setBounds(310,300,400,40);
        add(number);
        pin=new JLabel("PinNumber :");
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setBounds(80,380,400,40);
        add(pin);
        pinno=new JLabel("XXXX");
        pinno.setFont(new Font("Raleway",Font.BOLD,20));
        pinno.setBounds(310,380,400,40);
        add(pinno);
        pindet=new JLabel("your 4 digit password ");
        pindet.setFont(new Font("Raleway",Font.BOLD,15));
        pindet.setBounds(80,410,400,40);
        add(pindet);
        Serv=new JLabel("ServicesRequired :");
        Serv.setFont(new Font("Raleway",Font.BOLD,20));
        Serv.setBounds(80,480,400,40);
        add(Serv);
        c1=new JCheckBox("ATM CARD");
        c1.setBackground(java.awt.Color.WHITE);
        c1.setBounds(310,480,200,40);
        c1.setFont(new Font("Raleway",Font.BOLD,20));
        add(c1);
        c2=new JCheckBox("InternetBanking");
        c2.setBackground(java.awt.Color.WHITE);
        c2.setBounds(520,480,200,40);
        c2.setFont(new Font("Raleway",Font.BOLD,20));
        add(c2);
        c3=new JCheckBox("MobileBanking");
        c3.setBackground(java.awt.Color.WHITE);
        c3.setBounds(310,520,200,40);
        c3.setFont(new Font("Raleway",Font.BOLD,20));
        add(c3);
        c4=new JCheckBox("SMS and Email alerts");
        c4.setBackground(java.awt.Color.WHITE);
        c4.setBounds(520,520,280,40);
        c4.setFont(new Font("Raleway",Font.BOLD,20));
        add(c4);
        c5=new JCheckBox("Cheque Book");
        c5.setBackground(java.awt.Color.WHITE);
        c5.setBounds(310,560,200,40);
        c5.setFont(new Font("Raleway",Font.BOLD,20));
        add(c5);
        c6=new JCheckBox("E-Statement");
        c6.setBackground(java.awt.Color.WHITE);
        c6.setBounds(520,560,280,40);
        c6.setFont(new Font("Raleway",Font.BOLD,20));
        add(c6);
        c7=new JCheckBox("I here by declare that the above entered details are correct as best of my Knowldege");
        c7.setBackground(java.awt.Color.WHITE);
        c7.setBounds(80,600,700,40);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        add(c7);
        submit=new JButton("Submit");
        submit.setBackground(java.awt.Color.BLACK);
        submit.setForeground(java.awt.Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,20));
        submit.setBounds(500,700,150,40);
        submit.addActionListener(this);
        add(submit);
        cancel=new JButton("Cancel");
        cancel.setBackground(java.awt.Color.BLACK);
        cancel.setForeground(java.awt.Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,20));
        cancel.setBounds(670,700,150,40);
        cancel.addActionListener(this);
        add(cancel);
        getContentPane().setBackground(java.awt.Color.WHITE);
        setSize(850,920);
        setLocation(350,0);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==submit)
        {
            String accountType=null;
            if(type1.isSelected())
            {
                accountType="Savings";
            }
            else if(type2.isSelected())
            {
                accountType="Fixed Deposit";
            }
            else if(type3.isSelected())
            {
                accountType="Current";
            }
            Random rand=new Random();
            String cardnumber=""+Math.abs((rand.nextLong()%90000000L)+504093600000000L);
            String pinnumber=""+Math.abs((rand.nextLong()%9000L)+1000L);
            String facility="";
            if(c1.isSelected())
            {
                facility=facility+"ATM card";
            }
            else if(c2.isSelected())
            {
                facility=facility+"InternetBanking";
            }
            else if(c3.isSelected())
            {
                facility=facility+"MobileBanking";
            }
            else if(c5.isSelected())
            {
                facility=facility+"Cheque Book";
            }
            else if(c4.isSelected())
            {
                facility=facility+"SMS and EMAIL alerts";
            }
            else if(c6.isSelected())
            {
                facility=facility+"E-Statement";
            }
            try
            {
                if(accountType.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"AccountType is Required");
                }
                else
                {
                Connec c=new Connec();
                String query="insert into signup3 values('"+formno+"' ,'"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                String query2="insert into login values('"+formno+"',"+cardnumber+",'"+pinnumber+"')";
                c.S.executeUpdate(query);
                c.S.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null,"Card Number"+cardnumber+"\n"+"PIN:"+pinnumber);
                setVisible(false);
                new Deposit(pinnumber).setVisible(true);
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(ae.getSource()==cancel)
        {
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String args[])
    {
       new SignupThree("");
    }

   
    
}
