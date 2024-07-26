package bankmanagementsystem;

import javax.swing.* ;
import java.awt.*;
import java.awt.event.* ;   // Has Action Listener in it
import java.sql.* ;

public class Login extends JFrame implements ActionListener //ActionListener implements actions to buttons or will provide functionality
{
    JButton Signup , clear , login ;
    JTextField cardtextfield ;
    JPasswordField pintextfield ;
    Login()
    {
        setTitle("AUTOMATED TELLER MACHINE");

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg")) ;
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT) ;
        ImageIcon i3 = new ImageIcon(i2) ;
        JLabel label = new JLabel(i3) ;
        label.setBounds(70, 10, 100, 100);
        add(label) ;

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40) ;
        add(text) ;

        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(200,150,150,40) ;
        add(cardno) ;
        cardtextfield = new JTextField() ;
        cardtextfield.setFont(new Font("Arial",Font.BOLD,15));
        cardtextfield.setBounds(360,160,250,30);
        add(cardtextfield) ;
        
        JLabel Pin = new JLabel("Pin:");
        Pin.setFont(new Font("Osward",Font.BOLD,28));
        Pin.setBounds(200,220,150,40) ;
        add(Pin) ;
        pintextfield = new JPasswordField() ;
        pintextfield.setFont(new Font("Arial",Font.BOLD,15));
        pintextfield.setBounds(360,220,250,30);
        add(pintextfield) ;

        login = new JButton("SIGN IN") ;
        login.setBounds(360,300,100,30) ;
        login.setBackground(Color.BLACK) ;
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login) ;
        
        clear = new JButton("CLEAR") ;
        clear.setBounds(510,300,100,30) ;
        clear.setBackground(Color.BLACK) ;
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear) ;
        
        Signup = new JButton("SIGN UP") ;
        Signup.setBounds(360,350,250,30) ;
        Signup.setBackground(Color.BLACK) ;
        Signup.setForeground(Color.WHITE);
        Signup.addActionListener(this);
        add(Signup) ;

        getContentPane().setBackground(Color.WHITE); //selects the whole background and sets the background colour to white

        setSize(800, 480); //To Set size of Login Page
        setVisible(true);//To make the page visible    
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == clear)
        {
            cardtextfield.setText("");
            pintextfield.setText("");
        }
        else if(e.getSource() == login)
        {
            Conn conn = new Conn() ;
            String cardnumber = cardtextfield.getText() ;
            String pinnumber = pintextfield.getText() ;
            String query = "select * from login where cardnumber ='"+cardnumber+"' and pinnumber = '"+pinnumber+"'" ;
            try{
                ResultSet rs = conn.s.executeQuery(query) ;
                if(rs.next())
                {
                    setVisible(false) ;
                    new Transactions(pinnumber,cardnumber).setVisible(true) ;
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Incorrect Cardnumber or Pin.");
                }
            }catch(Exception f){
                System.out.println(f);
            }
        }
        else if(e.getSource() == Signup)
        {
            setVisible(false) ;
            new SignupOne().setVisible(true) ;
        }
    } 

    public static void main(String[] args) {
        new Login() ;
    }
}