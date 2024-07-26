
package bankmanagementsystem;


import javax.swing.* ;
import java.awt.* ;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.* ;


public class SignupTwo extends JFrame implements ActionListener{
    
    JTextField panTextField , aadharTextField ;
    JComboBox religionBox , Category , Income , Education , Occupation ;
    JButton next ;
    JRadioButton Yes , No , Yes1 , No1 ;
    String formno ;
     
        SignupTwo(String formno)
        {
            this.formno = formno ;
            setLayout(null);

            setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2") ;

            JLabel additional = new JLabel("Page 2 : Additional Details") ;
            additional.setBounds(250, 80, 400, 30);
            additional.setFont(new Font("Arial",Font.BOLD,25));
            add(additional) ;

            JLabel religion = new JLabel("Religion: ") ;
            religion.setBounds(100, 130, 100, 30);
            religion.setFont(new Font("Arial",Font.BOLD,22));
            add(religion) ;
            String relibox[] = {"Hindu","Christian","Muslim","Sikh","Other"} ;
            religionBox = new JComboBox(relibox) ;
            religionBox.setBounds(320, 130, 400, 30);
            religionBox.setBackground(Color.WHITE) ;
            add(religionBox) ;

            JLabel category = new JLabel("Category: ") ;
            category.setBounds(100, 180, 200, 30);
            category.setFont(new Font("Arial",Font.BOLD,22));
            add(category) ;
            String catebox[] = {"General","OBC","SC","ST","Other"} ;
            Category = new JComboBox(catebox) ;
            Category.setBounds(320, 180, 400, 30);
            Category.setBackground(Color.WHITE) ;
            add(Category) ;

            JLabel income = new JLabel("Income: ") ;
            income.setBounds(100, 230, 200, 30);
            income.setFont(new Font("Arial",Font.BOLD,22));
            add(income) ;
            String Incbox[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"} ;
            Income = new JComboBox(Incbox) ;
            Income.setBounds(320,230,400,30);
            Income.setBackground(Color.WHITE) ;
            add(Income) ;

            JLabel gender = new JLabel("Educational ") ;
            gender.setBounds(100, 280, 200, 30);
            gender.setFont(new Font("Arial",Font.BOLD,22));
            add(gender) ;        
            
            JLabel marital = new JLabel("Qualification: ") ;
            marital.setBounds(100, 310, 200, 30);
            marital.setFont(new Font("Arial",Font.BOLD,22));
            add(marital) ;
            
            String Educat[] = {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Other"} ;
            Education = new JComboBox(Educat) ;
            Education.setBounds(320, 290, 250, 30);
            Education.setBackground(Color.WHITE) ;
            add(Education) ;

            JLabel occupation = new JLabel("Occupation: ") ;
            occupation.setBounds(100, 380, 200, 30);
            occupation.setFont(new Font("Arial",Font.BOLD,22));
            add(occupation) ;
            
            String Occup[] = {"Salaried","Self-Employed","Bussinessman","Student","Retired","Other Profession"} ;
            Occupation = new JComboBox(Occup) ;
            Occupation.setBounds(320, 380, 400, 30);
            Occupation.setBackground(Color.WHITE) ;
            add(Occupation) ;
        

            JLabel pan = new JLabel("PAN Number: ") ;
            pan.setBounds(100, 430, 200, 30);
            pan.setFont(new Font("Arial",Font.BOLD,22));
            add(pan) ;
            panTextField = new JTextField() ;
            panTextField.setFont(new Font("Raleway",Font.BOLD,22));
            panTextField.setBounds(320, 430, 400, 30);
            add(panTextField) ;

            JLabel city = new JLabel("Aadhar Number: ") ;
            city.setBounds(100, 480, 200, 30);
            city.setFont(new Font("Arial",Font.BOLD,22));
            add(city) ;
            aadharTextField = new JTextField() ;
            aadharTextField.setFont(new Font("Raleway",Font.BOLD,22));
            aadharTextField.setBounds(320, 480, 400, 30);
            add(aadharTextField) ;

            JLabel state = new JLabel("Senior Citizen: ") ;
            state.setBounds(100, 530, 200, 30);
            state.setFont(new Font("Arial",Font.BOLD,22));
            add(state) ;
            Yes = new JRadioButton("YES") ;
            Yes.setBounds(310,530,120,30) ;
            Yes.setBackground(Color.WHITE);
            add(Yes) ;
            
            No = new JRadioButton("NO") ;
            No.setBounds(440,530,120,30) ;
            No.setBackground(Color.WHITE);
            add(No) ;
            
            ButtonGroup statusGroup = new ButtonGroup() ;
            statusGroup.add(Yes);
            statusGroup.add(No);

            JLabel pincode = new JLabel("Existing Account: ") ;
            pincode.setBounds(100, 580, 200, 30);
            pincode.setFont(new Font("Arial",Font.BOLD,22));
            add(pincode) ;
            Yes1 = new JRadioButton("YES") ;
            Yes1.setBounds(310,580,120,30) ;
            Yes1.setBackground(Color.WHITE);
            add(Yes1) ;
            
            No1 = new JRadioButton("NO") ;
            No1.setBounds(440,580,120,30) ;
            No1.setBackground(Color.WHITE);
            add(No1) ;
            
            ButtonGroup existGroup = new ButtonGroup() ;
            existGroup.add(Yes1);
            existGroup.add(No1);
            
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
            String formno = "" ;
            String sreligion = (String) religionBox.getSelectedItem() ;
            String scategory = (String) Category.getSelectedItem() ;
            String sincome = (String) Income.getSelectedItem() ;
            String seducation = (String) Education.getSelectedItem() ;
            String soccupation = (String) Occupation.getSelectedItem() ;
            String seniorcitizen = null ;
            if(Yes.isSelected())
            {
                seniorcitizen = "Yes" ;
            }
            else if(No.isSelected())
            {
                seniorcitizen = "No" ;
            }
            
            String email = aadharTextField.getText() ;
            String existingaccount = null ;
            if(Yes1.isSelected())
            {
                existingaccount = "Yes" ;
            }
            else if(No1.isSelected())
            {
                existingaccount = "No" ;
            }
            
            String span = panTextField.getText() ;
            String saadhar = aadharTextField.getText() ;
            
            try
            {
                Conn c = new Conn() ;
                String query = "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+seniorcitizen+"','"+span+"','"+saadhar+"','"+existingaccount+"')" ;
                c.s.executeUpdate(query) ;
                
                //SignupThree Object 
                setVisible(false) ;
                new SignupThree(formno).setVisible(true) ;
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            
        }
        
        public static void main(String[] args)
        {
            new SignupTwo("") ;
        }
}

