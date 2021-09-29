import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


class General extends JFrame implements ActionListener{
	private int counter;
	private ChoiceUser ce;
	private JButton Submit,Cancel,Back;
	private JTextField FirstName,LastName,Email,Phone,PresentAddress,PermanentAddress,NationalId,DateOfBirth,PassportNumber,BloodGroup ,Age,Gender,Password;
	private JLabel L0, L1,L2,L3,L4,L5,L6,L7,L8,L9,L10,L11,L12,L13;
	public General(ChoiceUser cu){
		
		super("REG FOR GENERAL");
	
		
		setVisible(true);
		ce = cu;
		//--------------------------//
		FirstName=new JTextField(15);
		LastName=new JTextField(15);
		Email=new JTextField(15);
		Phone=new JTextField(15);
		PresentAddress=new JTextField(15);
		PermanentAddress=new JTextField(15);
		NationalId=new JTextField(15);
		DateOfBirth=new JTextField(15);
		PassportNumber=new JTextField(15);
		BloodGroup=new JTextField(15);
		Age=new JTextField(15);
		Gender=new JTextField(15);
		Password=new JTextField(15);
		Submit=new JButton("Submit");
		Cancel=new JButton("Cancel");
		Back=new JButton("Back");
		
		Submit.addActionListener(this);
		Cancel.addActionListener(this);
		FirstName.addActionListener(this);
		LastName.addActionListener(this);
		Email.addActionListener(this);
		Phone.addActionListener(this);
		PresentAddress.addActionListener(this);
		PermanentAddress.addActionListener(this);
		NationalId.addActionListener(this);
		DateOfBirth.addActionListener(this);
		PassportNumber.addActionListener(this);
		BloodGroup.addActionListener(this);
		Age.addActionListener(this);
		Gender.addActionListener(this);
		Password.addActionListener(this);
		Back.addActionListener(this);
		
		
		//---------------------------
		L0=new JLabel("General User Registration");
		L1=new JLabel("First name :");
		L2=new JLabel("Last name :");
		L3=new JLabel("Email :");
		L4=new JLabel("Phone :");
		L5=new JLabel("Present Address :");
		L6=new JLabel("Permanent Address: ");
		L7=new JLabel("National ID: ");
		L8=new JLabel("Date Of Birth: ");
		L9=new JLabel("Passport Number: ");
		L10=new JLabel("Blood Group :");
		L11=new JLabel("Age :");
		L12=new JLabel("Gender :");
		L13=new JLabel("Password :");
		
		
		
		//------------------------------///
		
		
		Submit.setBackground(new Color(0x000080));
		Submit.setForeground(Color.white);
		
		Cancel.setBackground(new Color(0x808000));
		Cancel.setForeground(Color.white);
		
		Back.setBackground(new Color(0xFF0000));
		Back.setForeground(Color.white);
		
		//*********** SET POSITION ***********//
		
		L0.setBounds(40,25,150,25);
		L1.setBounds(80,55,150,25);
		FirstName.setBounds(200,55,150,25);
		L2.setBounds(80,85,150,25);
		LastName.setBounds(200,85,150,25);
		L3.setBounds(80,115,150,25);
		Email.setBounds(200,115,150,25);
		L4.setBounds(80,145,150,25);
		Phone.setBounds(200,145,150,25);
		L5.setBounds(80,175,150,25);
		PresentAddress.setBounds(200,175,150,25);
		L6.setBounds(80,205,150,25);
		PermanentAddress.setBounds(200,205,150,25);
		L7.setBounds(80,235,150,25);
		NationalId.setBounds(200,235,150,25);
		L8.setBounds(80,265,150,25);
		DateOfBirth.setBounds(200,265,150,25);
		L9.setBounds(80,295,150,25);
		PassportNumber.setBounds(200,295,150,25);
		L10.setBounds(80,325,150,25);
		BloodGroup.setBounds(200,325,150,25);
		L11.setBounds(80,355,150,25);
		Age.setBounds(200,355,150,25);
		L12.setBounds(80,385,150,25);
		Gender.setBounds(200,385,150,25);
		L13.setBounds(80,415,150,25);
		Password.setBounds(200,415,150,25);
		Submit.setBounds(80,460,100,25);
		Cancel.setBounds(182,460,100,25);
		Back.setBounds(284,460,100,25);
		
		add(L0);add(L1);add(FirstName);add(L2);add(LastName);add(L3);add(Email);add(L4);add(Phone);add(L5);add(PresentAddress);add(L6);add(PermanentAddress);add(L7);
		add(NationalId);add(L8);add(DateOfBirth);add(L9);add(PassportNumber);add(L10);add(BloodGroup);add(L11);add(Age);add(L12);add(Gender);add(L13);add(Password);add(Submit);add(Cancel);add(Back);
		
		
		setLayout(null);
		setSize(500,600);
		//*****CLOSING****//
		
		JFrame frame= new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
	}
	
	private boolean isEmpty(JTextField s){
		boolean flag=false;
		if(s.getText().length()==0)flag=true;
		return flag;
	}
	private boolean isValidEmail(String e){
		boolean flag=true;
		int atIdx=e.indexOf("@");
		int dotIdx=e.indexOf(".");
		if(dotIdx<=atIdx)flag=false;
		return flag;
	}
	
	public void actionPerformed(ActionEvent e){
		String sig=e.getActionCommand();
		
		if(sig.equals("Submit")){
			if(isEmpty(FirstName) || isEmpty(LastName) || isEmpty(Email) || isEmpty(Phone) || isEmpty(PresentAddress) || isEmpty(PermanentAddress) || isEmpty(NationalId) || isEmpty(DateOfBirth) || isEmpty(PassportNumber) || isEmpty(BloodGroup) || isEmpty(Age) || isEmpty(Gender) || isEmpty(Password)){
				JOptionPane.showMessageDialog(this,"All fields are mandatory");
			}
			else if(!isValidEmail(Email.getText())){
				JOptionPane.showMessageDialog(this,"Invalid Email");
			}
			
			else{
				DataAccess da=new DataAccess();
				String sql = "INSERT INTO `information` (`FirstName`, `LastName`, `Email`, `PhoneNo`, `PresentAddress`, `PermanentAddress`, `NationalID`, `DateOfBirth`, `PassportNumber`, `BloodGroup`, `Age`, `Gender`, `Password`) VALUES ( '"+FirstName.getText()+"', '"+LastName.getText()+"', '"+Email.getText()+"', '"+Phone.getText()+"', '"+PresentAddress.getText()+"', '"+PermanentAddress.getText()+"', '"+NationalId.getText()+"', '"+DateOfBirth.getText()+"', '"+PassportNumber.getText()+"', '"+BloodGroup.getText()+"', '"+Age.getText()+"', '"+Gender.getText()+"', '"+Password.getText()+"')";
				
				if(da.updateDB(sql)>0){
					JOptionPane.showMessageDialog(this,"Signup Complete!");
				}
				System.out.println(sql);
			}
		}
		else if(sig.equals("Cancel")){
			System.exit(0);
		}
		else if(sig.equals("Back")){
			this.setVisible(false);
			ce.setVisible(true);
		}
	}
}
