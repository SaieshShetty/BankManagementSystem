
package bankmanagementsystem;

import javax.swing.* ;
import java.awt.* ;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.* ;


public class SignupOne extends JFrame implements ActionListener{
    
    long random ;
    JTextField nameTextField , fnameTextField , emailTextField , cityTextField ;
    JTextField addTextField ,  stateTextField , pinTextField ;
    JDateChooser datechooser ;
    JButton next ;
    JRadioButton male , female , others , married , single ;
     
        SignupOne()
        {
            setLayout(null);
            Random ran = new Random() ;
            random = Math.abs((ran.nextLong()%9000L)%10000L) ;

            JLabel formno = new JLabel("APPLICATION FORM NO. "+random) ;
            formno.setBounds(140, 20, 600, 40);
            formno.setFont(new Font("Raleway",Font.BOLD,38));
            add(formno) ;

            JLabel Personal = new JLabel("Page 1 : Personal Details") ;
            Personal.setBounds(250, 80, 400, 30);
            Personal.setFont(new Font("Arial",Font.BOLD,25));
            add(Personal) ;

            JLabel name = new JLabel("Name: ") ;
            name.setBounds(100, 130, 100, 30);
            name.setFont(new Font("Arial",Font.BOLD,22));
            add(name) ;
            nameTextField = new JTextField() ;
            nameTextField.setFont(new Font("Raleway",Font.BOLD,22));
            nameTextField.setBounds(320, 130, 400, 30);
            add(nameTextField) ;


            JLabel fname = new JLabel("Father's Name: ") ;
            fname.setBounds(100, 180, 200, 30);
            fname.setFont(new Font("Arial",Font.BOLD,22));
            add(fname) ;
            fnameTextField = new JTextField() ;
            fnameTextField.setFont(new Font("Raleway",Font.BOLD,22));
            fnameTextField.setBounds(320, 180, 400, 30);
            add(fnameTextField) ;

            JLabel dob = new JLabel("Date Of Birth: ") ;
            dob.setBounds(100, 230, 200, 30);
            dob.setFont(new Font("Arial",Font.BOLD,22));
            add(dob) ;
            datechooser = new JDateChooser() ;
            datechooser.setBounds(320,230,400,30);
            datechooser.setForeground(Color.BLACK);
            add(datechooser) ;

            JLabel gender = new JLabel("Gender: ") ;
            gender.setBounds(100, 280, 200, 30);
            gender.setFont(new Font("Arial",Font.BOLD,22));
            add(gender) ;
            
            male = new JRadioButton("Male") ;
            male.setBounds(300,280,120,30) ;
            male.setBackground(Color.WHITE);
            add(male) ;
            
            female = new JRadioButton("Female") ;
            female.setBounds(440,280,120,30) ;
            female.setBackground(Color.WHITE);
            add(female) ;
            
            others = new JRadioButton("Others") ;
            others.setBounds(580,280,120,30) ;
            others.setBackground(Color.WHITE);
            add(others) ;
            
            ButtonGroup genderGroup = new ButtonGroup() ;
            genderGroup.add(male);
            genderGroup.add(female);
            genderGroup.add(others);
            
            JLabel marital = new JLabel("Marital Status: ") ;
            marital.setBounds(100, 330, 200, 30);
            marital.setFont(new Font("Arial",Font.BOLD,22));
            add(marital) ;
            
            single = new JRadioButton("Single") ;
            single.setBounds(300,330,120,30) ;
            single.setBackground(Color.WHITE);
            add(single) ;
            
            married = new JRadioButton("Married") ;
            married.setBounds(440,330,120,30) ;
            married.setBackground(Color.WHITE);
            add(married) ;
            
            ButtonGroup statusGroup = new ButtonGroup() ;
            statusGroup.add(single);
            statusGroup.add(married);

            JLabel email = new JLabel("Email Address: ") ;
            email.setBounds(100, 380, 200, 30);
            email.setFont(new Font("Arial",Font.BOLD,22));
            add(email) ;
            emailTextField = new JTextField() ;
            emailTextField.setFont(new Font("Raleway",Font.BOLD,22));
            emailTextField.setBounds(320, 380, 400, 30);
            add(emailTextField) ;

            JLabel address = new JLabel("Address: ") ;
            address.setBounds(100, 430, 200, 30);
            address.setFont(new Font("Arial",Font.BOLD,22));
            add(address) ;
            addTextField = new JTextField() ;
            addTextField.setFont(new Font("Raleway",Font.BOLD,22));
            addTextField.setBounds(320, 430, 400, 30);
            add(addTextField) ;

            JLabel city = new JLabel("City: ") ;
            city.setBounds(100, 480, 200, 30);
            city.setFont(new Font("Arial",Font.BOLD,22));
            add(city) ;
            cityTextField = new JTextField() ;
            cityTextField.setFont(new Font("Raleway",Font.BOLD,22));
            cityTextField.setBounds(320, 480, 400, 30);
            add(cityTextField) ;

            JLabel state = new JLabel("State: ") ;
            state.setBounds(100, 530, 200, 30);
            state.setFont(new Font("Arial",Font.BOLD,22));
            add(state) ;
            stateTextField = new JTextField() ;
            stateTextField.setFont(new Font("Raleway",Font.BOLD,22));
            stateTextField.setBounds(320, 530, 400, 30);
            add(stateTextField) ;

            JLabel pincode = new JLabel("PinCode: ") ;
            pincode.setBounds(100, 580, 200, 30);
            pincode.setFont(new Font("Arial",Font.BOLD,22));
            add(pincode) ;
            pinTextField = new JTextField() ;
            pinTextField.setFont(new Font("Raleway",Font.BOLD,22));
            pinTextField.setBounds(320, 580, 400, 30);
            add(pinTextField) ;
            
            next = new JButton("Next") ;
            next.setBackground(Color.BLACK);
            next.setForeground(Color.WHITE);
            next.setFont(new Font("Arial",Font.BOLD,14));
            next.setBounds(620,660,80,30) ;
            next.addActionListener(this) ;
            add(next) ;

            getContentPane().setBackground(Color.WHITE);
            setSize(850,800) ;
            setLocation(350, 10);
            setVisible(true);
        }
        
    @Override
        public void actionPerformed(ActionEvent ae)
        {
            String formno = ""+random ;
            String name = nameTextField.getText() ;
            String fname = fnameTextField.getText() ;
            String dob = ((JTextField) datechooser.getDateEditor().getUiComponent()).getText() ;
            String gender = null ;
            if(male.isSelected())
            {
                gender = "Male" ;
            }
            else if(female.isSelected())
            {
                gender = "Female" ;
            }
            else if(others.isSelected())
            {
                gender = "Others" ;
            }
            
            String email = emailTextField.getText() ;
            String marital = null ;
            if(married.isSelected())
            {
                marital = "Married" ;
            }
            else if(single.isSelected())
            {
                marital = "Unmarried" ;
            }
            
            String address = addTextField.getText() ;
            String city = cityTextField.getText() ;
            String state = stateTextField.getText() ;
            String pin = pinTextField.getText() ;
            
            try
            {
                if(name.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Name is Required");
                }
                else
                {
                    Conn c = new Conn() ;
                    String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+marital+"','"+email+"','"+address+"','"+city+"','"+state+"','"+pin+"')" ;
                    c.s.executeUpdate(query) ;
                    
                    setVisible(false) ;
                    new SignupTwo(formno).setVisible(true) ;
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            
        }
        
        public static void main(String[] args)
        {
            new SignupOne() ;
        }
}

