
package bankmanagementsystem;

import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
import java.sql.* ;
import java.util.Date ;

public class Fastcash extends JFrame implements ActionListener{
    JButton deposit , withdrawal , fastcash , ministat , pinchange , balenq , exit ;
    String pinnumber , cardnumber ;
    Fastcash(String pinnumber , String cardnumber)
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
        
        JLabel text = new JLabel("Please Select Your Amount you want to Withdraw") ;
        text.setBounds(215, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        Image.add(text) ;
        
        deposit = new JButton("100") ;
        deposit.setBounds(170,415,150,30) ;
        deposit.addActionListener(this);
        Image.add(deposit) ;
        
        withdrawal = new JButton("500") ;
        withdrawal.setBounds(355,415,150,30) ;
        withdrawal.addActionListener(this);
        Image.add(withdrawal) ;
        
        fastcash = new JButton("1000") ;
        fastcash.setBounds(170,450,150,30) ;
        fastcash.addActionListener(this);
        Image.add(fastcash) ;
        
        ministat = new JButton("2000") ;
        ministat.setBounds(355,450,150,30) ;
        ministat.addActionListener(this);
        Image.add(ministat) ;
        
        pinchange = new JButton("5000") ;
        pinchange.setBounds(170,485,150,30) ;
        pinchange.addActionListener(this);
        Image.add(pinchange) ;
        
        balenq = new JButton("10000") ;
        balenq.setBounds(355,485,150,30) ;
        balenq.addActionListener(this);
        Image.add(balenq) ;
        
        exit = new JButton("Back") ;
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
            setVisible(false);
            new Transactions(pinnumber,cardnumber).setVisible(true) ;
        }
        else{
            String amount = ((JButton)e.getSource()).getText().substring(3) ;
            Conn c = new Conn() ;
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pinnumber = '"+pinnumber+"'") ;
                int balance = 0 ;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount")) ;
                    }
                    else{
                        balance -= Integer.parseInt(rs.getString("amount")) ;
                    }
                }
                if(e.getSource()!= exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return ;
                }
                
                Date date = new Date() ;
                String query = "insert into bank values('"+cardnumber+"','"+pinnumber+"' , '"+date+"' , 'Withdraw' , '"+amount+"')" ;
                c.s.executeUpdate(query) ;
                JOptionPane.showMessageDialog(null, "Rs "+amount+" Debited Successfully");
                
                setVisible(false) ;
                new Transactions(pinnumber,cardnumber).setVisible(true);
            }catch(Exception f){
                System.out.println(f);
            }
        }
    }
    
    public static void main(String args[])
    {
        new Fastcash("","") ;
    }
}
