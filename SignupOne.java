package bank.management.systems;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
public class SignupOne extends JFrame implements ActionListener
{
    long random;
    JTextField nametext,fnametext,dobtext,emailtext,addresstext,citytext,pincodetext,statetext ;
    JRadioButton male,female,other;
    JLabel formno,personalDetails,name,fname,dob,email,address,city,pincode,state,gender;
    JButton next;
    SignupOne()
    {
        setLayout(null);
        Random rand=new Random();
        random=Math.abs((rand.nextLong()%9000L)+1000L) ;
        formno=new JLabel("APPLICATION FORM NO:"+random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,10,600,40);
        add(formno);
        getContentPane().setBackground(java.awt.Color.GREEN);
        personalDetails=new JLabel("page1:Personal Details");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personalDetails.setBounds(200,80,300,30);
        add(personalDetails);
        name=new JLabel("NAME:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,120,100,30);
        add(name);
        nametext=new JTextField();
        nametext.setFont(new Font("Raleway",Font.BOLD,14));
        nametext.setBounds(270, 120, 400,30);
        add(nametext);
        fname=new JLabel("FATHER NAME:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,160,250,30);
        add(fname);
        fnametext=new JTextField();
        fnametext.setFont(new Font("Raleway",Font.BOLD,14));
        fnametext.setBounds(270, 160, 400,30);
        add(fnametext);
        dob=new JLabel("Date Of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,200,250,30);
        add(dob);
        dobtext=new JTextField();
        dobtext.setFont(new Font("Raleway",Font.BOLD,14));
        dobtext.setBounds(270, 200, 400,30);
        add(dobtext);
        
        gender=new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,240,250,30);
        add(gender);
         male=new JRadioButton("Male");
        female=new JRadioButton("female");
        female.setBounds(270,240,150,30);
        male.setBounds(420,240,150,30);
        other=new JRadioButton("Other");
        other.setBounds(570,240,150,30);
        male.setBackground(java.awt.Color.WHITE);
        female.setBackground(java.awt.Color.WHITE);
        other.setBackground(java.awt.Color.WHITE);
       add(other);
       add(female);
       add(male);
       ButtonGroup gengroup=new ButtonGroup();
       gengroup.add(male);
       gengroup.add(female);
       gengroup.add(other);
       
        email=new JLabel("Email");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,280,250,30);
        add(email);
        emailtext=new JTextField();
        emailtext.setFont(new Font("Raleway",Font.BOLD,14));
        emailtext.setBounds(270, 280, 400,30);
        add(emailtext);
        address=new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,320,250,30);
        add(address);
        addresstext=new JTextField();
        addresstext.setFont(new Font("Raleway",Font.BOLD,14));
        addresstext.setBounds(270, 320, 400,30);
        add(addresstext);
        city=new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,360,250,30);
        add(city);
        citytext=new JTextField();
        citytext.setFont(new Font("Raleway",Font.BOLD,14));
        citytext.setBounds(270, 360, 400,30);
        add(citytext);
        state=new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,400,250,30);
        add(state);
         statetext=new JTextField();
        statetext.setFont(new Font("Raleway",Font.BOLD,14));
        statetext.setBounds(270, 400, 400,30);
        add(statetext);
        pincode=new JLabel("Pincode:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,440,250,30);
        add(pincode);
        pincodetext=new JTextField();
        pincodetext.setFont(new Font("Raleway",Font.BOLD,14));
        pincodetext.setBounds(270, 440, 400,30);
        add(pincodetext);
        next=new JButton("Next");
        next.setBackground(java.awt.Color.BLACK);
        next.setForeground(java.awt.Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,500,100,40);
        next.addActionListener(this);
        add(next);
        getContentPane().setBackground(java.awt.Color.WHITE);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
         String formno =""+random;
         String name = nametext.getText();
         String fname= fnametext.getText();
         String dob=dobtext.getText();
         String email=emailtext.getText();
         String state=statetext.getText();
         String city=citytext.getText();
         String pincode =pincodetext.getText();
         String gender=null;
         if(male.isSelected())
         {
             gender="Male";
         }
         else if(female.isSelected())
         {
             gender="Female";
         }
         else
         {
             gender="Other";
         }
         
         String address=addresstext.getText();
         try
         {
            if(name.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Name is Required");
            }
            else
            {
                   Connec c=new Connec();
                   String query="insert into signup values('"+formno+"' ,'"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
                   c.S.executeUpdate(query);
                   setVisible(false);
                   new Signuptwo(formno).setVisible(true);
              }
         }
         catch(Exception e)
         {
             System.out.println(e);
         }
    }
    public static void main(String args[])
    {
        new SignupOne();
        
    }
}
