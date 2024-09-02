package bank.management.systems;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
public class Signuptwo extends JFrame implements ActionListener
{
    JTextField Atext,Otext,Ptext,pincodetext,statetext ;
    JRadioButton yes,no;
    JLabel AdditionalDetails,Religion,Education,Occupation,PAN,Adhar,Category,Income,sac;
    JButton next;
    String[] religions={"HINDHU","MUSLIM","CHRISTIAN","OTHER"};
    String[] catval={"General","OBC","SC","ST","Other"};
    String[] incomeval={"below 1-lakh","between 1-lakh to 2.5lakh","between 2.5 to 4lakh","between 4 to 6.5lakh ","morethan 6.5 lakh"};
    String[] Eval={"Non-gradute","Graduate","Post graduate","Doctrate","Other"};
    JComboBox religiontext,Catval,Incomeval,Eduval;
    long random;
    String formno;

    Signuptwo(String formno)
    {
        this.formno=formno;
        System.out.println(formno);
        setLayout(null);
        setTitle("New Application form 2");
        
        getContentPane().setBackground(java.awt.Color.GREEN);
        AdditionalDetails=new JLabel("page2:Additional Details");
        AdditionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        AdditionalDetails.setBounds(200,80,300,30);
        add(AdditionalDetails);
       Religion=new JLabel("Religion:");
        Religion.setFont(new Font("Raleway",Font.BOLD,20));
        Religion.setBounds(100,120,100,30);
        add(Religion);
        religiontext=new JComboBox(religions);
        religiontext.setFont(new Font("Raleway",Font.BOLD,14));
        religiontext.setBounds(270, 120, 400,30);
        religiontext.setBackground(java.awt.Color.WHITE);
        add(religiontext);
        Education=new JLabel("Education:");
        Education.setFont(new Font("Raleway",Font.BOLD,20));
        Education.setBounds(100,160,250,30);
        add(Education);
        Eduval=new JComboBox(Eval);
        Eduval.setFont(new Font("Raleway",Font.BOLD,14));
        Eduval.setBounds(270, 160, 400,30);
        Eduval.setBackground(java.awt.Color.WHITE);
        add(Eduval);
        Occupation=new JLabel("Occupation:");
        Occupation.setFont(new Font("Raleway",Font.BOLD,20));
        Occupation.setBounds(100,200,250,30);
        add(Occupation);
        Otext=new JTextField();
        Otext.setFont(new Font("Raleway",Font.BOLD,14));
        Otext.setBounds(270, 200, 400,30);
        add(Otext);
        
        PAN=new JLabel("PAN:");
        PAN.setFont(new Font("Raleway",Font.BOLD,20));
        PAN.setBounds(100,240,250,30);
        add(PAN);
        Ptext=new JTextField();
        Ptext.setFont(new Font("Raleway",Font.BOLD,14));
        Ptext.setBounds(270, 240, 400,30);
        add(Ptext);
        
        Adhar=new JLabel("Adhar");
        Adhar.setFont(new Font("Raleway",Font.BOLD,20));
        Adhar.setBounds(100,280,250,30);
        add(Adhar);
        Atext=new JTextField();
        Atext.setFont(new Font("Raleway",Font.BOLD,14));
        Atext.setBounds(270, 280, 400,30);
        add(Atext);
        Category=new JLabel("Category");
        Category.setFont(new Font("Raleway",Font.BOLD,20));
        Category.setBounds(100,360,250,30);
        add(Category);
        Catval=new JComboBox(catval);
        Catval.setFont(new Font("Raleway",Font.BOLD,14));
        Catval.setBounds(270, 360, 400,30);
        Catval.setBackground(java.awt.Color.WHITE);
        add(Catval);
        sac=new JLabel("DO you Have Existing account:");
        sac.setFont(new Font("Raleway",Font.BOLD,20));
        sac.setBounds(100,400,400,30);
        add(sac);
        yes=new JRadioButton("Yes");
        yes.setFont(new Font("Raleway",Font.BOLD,14));
        yes.setBounds(450, 400, 70,30);
        add(yes);
        no=new JRadioButton("No");
        no.setFont(new Font("Raleway",Font.BOLD,14));
        no.setBounds(520, 400, 50,30);
        add(no);
        ButtonGroup sgroup=new ButtonGroup();
        sgroup.add(yes);
        sgroup.add(no);
        Income=new JLabel("Income:");
        Income.setFont(new Font("Raleway",Font.BOLD,20));
        Income.setBounds(100,440,250,30);
        add(Income);
        Incomeval=new JComboBox(incomeval);
        Incomeval.setFont(new Font("Raleway",Font.BOLD,14));
        Incomeval.setBounds(270, 440, 400,30);
        Incomeval.setBackground(java.awt.Color.WHITE);
        add(Incomeval);
        next=new JButton("Next");
        next.setBackground(java.awt.Color.BLACK);
        next.setForeground(java.awt.Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,500,100,40);
        next.addActionListener(this);
        add(next);
        getContentPane().setBackground(java.awt.Color.WHITE);
        getContentPane().setBackground(java.awt.Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
         String formno =""+random;
         String Religion = (String)religiontext.getSelectedItem();
         String Education= (String)Eduval.getSelectedItem();
         String Ocupation=Otext.getText();
         String PAN=Ptext.getText();
         String Adhar=Atext.getText();
         String Category=(String)Catval.getSelectedItem();
         String sac=null;
         
         if(yes.isSelected())
         {
             sac="Yes";
         }
         else if(no.isSelected())
         {
             sac="No";
         }
         String  Income=(String)Incomeval.getSelectedItem();
         try
         {
                 Connec c=new Connec();
                   String query="insert into signuptwo values('"+formno+"' ,'"+Religion+"','"+Education+"','"+Ocupation+"','"+PAN+"','"+Adhar+"','"+Category+"','"+sac+"','"+Income+"')";
                   c.S.executeUpdate(query);
                   setVisible(false);
                   new SignupThree(formno).setVisible(true);
         }
         catch(Exception e)
         {
             System.out.println(e);
         }
    }
    public static void main(String args[])
    {
        new Signuptwo("");
    }
}
