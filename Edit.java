import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Edit extends JFrame implements ActionListener{
	
	//Edit==update
	private TextField email,pass;
	private JButton signupButton,cancelButton;
	private JLabel l,l2,msg;
	private Frame parent;
	public Edit(){
		super("Java Edit Window");
		l=new JLabel("Email: ");
		email=new TextField(10);
		l2=new JLabel("New Password: ");
		pass=new TextField(10);
		signupButton=new JButton("Confirm");
		cancelButton=new JButton("Back");
		msg=new JLabel("msg box");
		add(l);add(email);
		add(l2);add(pass);
		add(signupButton);add(cancelButton);
		add(msg);
		
		signupButton.setBackground(new Color(0x000000));
		signupButton.setForeground(Color.white);
		
		cancelButton.setBackground(new Color(0x000000));
		cancelButton.setForeground(Color.white);
		
		l.setBounds(10,60,50,30);
		email.setBounds(115,60,200,30);
		l2.setBounds(10,95,100,30);
		pass.setBounds(115,95,200,30);
		signupButton.setBounds(115,130,100,30);
		cancelButton.setBounds(220,130,100,30);
		msg.setBounds(115,170,200,30);
		
		signupButton.addActionListener(this);
		cancelButton.addActionListener(this);
		setLayout(null);
		setSize(400,500);
		
		JFrame frame= new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private boolean isEmpty(TextField s){
		boolean flag=false;
		if(s.getText().length()==0)flag=true;
		//System.out.println(s.getText()+":"+flag);
		return flag;
	}
	public void setParent(Frame p){
		parent=p;
	}
	private boolean isValidEmail(String e){
		boolean flag=true;
		int atIdx=e.indexOf("@");
		int dotIdx=e.indexOf(".");
		if(dotIdx<atIdx)flag=false;
		return flag;
	}
	public void actionPerformed(ActionEvent e){
		//System.out.println(e.getActionCommand());
		String sig=e.getActionCommand();
		
		if(sig.equals("Confirm")){
			String sql="update information set Email='"+email.getText()+"' where Password='"+pass.getText()+"'";
			System.out.println(sql);
			DataAccess da=new DataAccess();
			if(isEmpty(email) || isEmpty(pass)){
				JOptionPane.showMessageDialog(this,"All fields are mandatory");
			}
			else if(!isValidEmail(email.getText())){
				msg.setText("Invalid email");
				JOptionPane.showMessageDialog(this,"Invalid email");
			}
			else{
				if(da.updateDB(sql)>0){
					JOptionPane.showMessageDialog(this,"Data Updated");
					msg.setText("Data Updated");
				}
				else{
					msg.setText("Update Error");
					JOptionPane.showMessageDialog(this,"Update Error!");
				}
			}
		}
		else if(sig.equals("Back")){
			parent.setVisible(true);
			this.setVisible(false);
		}
	}
}
