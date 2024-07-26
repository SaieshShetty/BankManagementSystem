
package bankmanagementsystem;

import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;


public class Transactions extends JFrame implements ActionListener{
    JButton deposit , withdrawal , fastcash , ministat , pinchange , balenq , exit ;
    String pinnumber , cardnumber;
    Transactions(String pinnumber , String cardnumber)
    {
        this.pinnumber = pinnumber ;
        this.cardnumber = cardnumber ;
        setLayout(null) ;
        
        ImageIcon I1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg")) ;
        Image I2 = I1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT) ;
        ImageIcon I3 = new ImageIcon(I2) ;
        JLabel Image = new JLabel(I3) ;
        Image.setBounds(0, 0, 900, 900);
        add(Image) ;
        
        JLabel text = new JLabel("Please Select Your Transactions") ;
        text.setBounds(215, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        Image.add(text) ;
        
        deposit = new JButton("Deposit") ;
        deposit.setBounds(170,415,150,30) ;
        deposit.addActionListener(this);
        Image.add(deposit) ;
        
        withdrawal = new JButton("Withdrawal") ;
        withdrawal.setBounds(355,415,150,30) ;
        withdrawal.addActionListener(this);
        Image.add(withdrawal) ;
        
        fastcash = new JButton("FastCash") ;
        fastcash.setBounds(170,450,150,30) ;
        fastcash.addActionListener(this);
        Image.add(fastcash) ;
        
        ministat = new JButton("Mini-Statement") ;
        ministat.setBounds(355,450,150,30) ;
        ministat.addActionListener(this);
        Image.add(ministat) ;
        
        pinchange = new JButton("Pin Change") ;
        pinchange.setBounds(170,485,150,30) ;
        pinchange.addActionListener(this);
        Image.add(pinchange) ;
        
        balenq = new JButton("Balance Enquiry") ;
        balenq.setBounds(355,485,150,30) ;
        balenq.addActionListener(this);
        Image.add(balenq) ;
        
        exit = new JButton("Exit") ;
        exit.setBounds(355,520,150,30) ;
        exit.addActionListener(this);
        Image.add(exit) ;
        
        setSize(900,900) ;
        setLocation(900,0) ;
        setUndecorated(true) ;
        setVisible(true) ;
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == exit){
            System.exit(0);
        }
        else if(e.getSource() == deposit){
            setVisible(false) ;
            new Deposit(pinnumber,cardnumber).setVisible(true) ;
        }
        else if(e.getSource() == withdrawal)
        {
            setVisible(false) ;
            new Withdraw(pinnumber,cardnumber).setVisible(true);
        }
        else if(e.getSource() == fastcash)
        {
            setVisible(false) ;
            new Fastcash(pinnumber,cardnumber).setVisible(true); 
        }
        else if(e.getSource() == pinchange)
        {
            setVisible(false) ;
            new PinChange(pinnumber,cardnumber).setVisible(true); 
        }
        else if(e.getSource() == balenq)
        {
            setVisible(false) ;
            new BalanceEnquiry(pinnumber,cardnumber).setVisible(true); 
        }
        else if(e.getSource() == ministat)
        {
            new Ministatement(pinnumber).setVisible(true) ;
        }
    }
    
    public static void main(String args[])
    {
        new Transactions("","") ;
    }
}
