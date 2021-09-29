import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


class FirstPage extends JFrame implements ActionListener{
	private JTextField t,tf;
	private JLabel email,pass;
	private JButton b1,b2,b3;
	public static Home home;
	public static Edit edit;
	public static Delete delete;
	private Frame parent;
	private TextArea ta;
	
	
	
    public FirstPage(){
	super("WELCOME");
	home=new Home();
	edit=new Edit();
	delete=new Delete();
	
	
	email= new JLabel("Email");
	t=new JTextField(30);
	pass= new JLabel("Password");
	tf=new JPasswordField(30);
	
	b1= new JButton("Log In");
	
	b2= new JButton("Signup");
	b3= new JButton("Forgot Password?");


	
	///****** SEQUENCE ******//
	add(email);add(t);add(pass);add(tf);add(b1);add(b3);add(b2);
	
	
	// DESIGN //
		
		b1.setBackground(new Color(0xFFBE33));
		b1.setForeground(Color.white);
		
		b2.setBackground(new Color(0x33FFE6));
		b2.setForeground(Color.white);
		
		b3.setBackground(new Color(0x3339FF));
		b3.setForeground(Color.white);
		
		email.setBounds(20,125,125,30);
		t.setBounds(125,125,205,30);
		
		pass.setBounds(20,160,125,30);
		tf.setBounds(125,160,205,30);
		
		
		b1.setBounds(125,205,105,30);
		b2.setBounds(225,205,105,30);
		b3.setBounds(125,250,205,30);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		setLayout(null);
		setSize(500,500);
	
	//*CLOSE THE WINDOW//
	
	JFrame frame= new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
}
public void setParent(Frame f){
		parent=f;
	}
private boolean checkAuth(){
		boolean flag=false;
		String e=t.getText();
		String p=tf.getText();
		String sql="select * from information where email='"+e+"' and password='"+p+"'";
		System.out.println(sql);
		try{
			DataAccess da=new DataAccess();
			ResultSet rs=da.getData(sql);
			while(rs.next()){
					flag=true;
			}
		}
		catch(Exception ex){
			System.out.println("Exception occurred");
		}
		return flag;
	}
public void actionPerformed(ActionEvent a){
		
		String s = a.getActionCommand();
		if(s.equals("Log In")){
			if(checkAuth()){
				System.out.println("Success");
				FirstPage.home.setVisible(true);
				FirstPage.home.setParent(this);
				FirstPage.home.loadData();
				this.setVisible(false);
			}
			else{
				JOptionPane.showMessageDialog(this,"Incorrect");
			}
		}
		if(s.equals("Signup")){
			ChoiceUser c= new ChoiceUser(this);
			setVisible(false);
		}
		if(s.equals("Forgot Password?")){
			ChangePass cp = new ChangePass(this);
			setVisible(false);
		}
	}
	
}
