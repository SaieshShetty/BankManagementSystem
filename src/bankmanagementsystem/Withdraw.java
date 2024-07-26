
package bankmanagementsystem;

import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
import java.util.* ;

public class Withdraw extends JFrame implements ActionListener {
    JButton withdraw , back ;
    String pinnumber , cardnumber;
    JTextField amount ;
    
    Withdraw(String pinnumber , String cardnumber)
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
     
     JLabel text = new JLabel("Enter The Amount you want to deposit :") ;
     text.setForeground(Color.WHITE);
     text.setFont(new Font("System",Font.BOLD,16));
     text.setBounds(170,300,400,20) ;
     Image.add(text) ;
     
     amount = new JTextField() ;
     amount.setFont(new Font("Raleway",Font.BOLD,22));
     amount.setBounds(170,350,320,25);
     Image.add(amount) ;
    
     withdraw = new JButton("Withdraw") ;
     withdraw.setBounds(355, 485, 150, 30);
     withdraw.addActionListener(this);
     Image.add(withdraw);
     
     back = new JButton("Back") ;
     back.setBounds(355, 520, 150, 30);
     back.addActionListener(this);
     Image.add(back) ;
     
     setSize(900,900) ;
     setLocation(900,0) ;
//     setUndecorated(true) ;
     setVisible(true) ;
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == withdraw){
            String number = amount.getText() ;
            Date date = new Date() ;
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter the Amount you want to withdraw");
            }else{
                try{
                Conn conn = new Conn() ;
                String query = "insert into bank values('"+cardnumber+"','"+pinnumber+"' , '"+date+"' , 'Withdraw' , '"+number+"')" ;
                conn.s.executeUpdate(query) ;
                JOptionPane.showMessageDialog(null, "Rs "+number+" Withdrawn Successfully.!") ;
                setVisible(false) ;
                new Transactions(pinnumber,cardnumber).setVisible(true);
                }catch(Exception f){
                    System.out.println(f);
                }
            }
        }else if(e.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber,cardnumber).setVisible(true);
        }
    }
    
     public static void main(String[] args) {
        new Withdraw("","") ;
    }
}
