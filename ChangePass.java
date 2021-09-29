import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class ChangePass extends JFrame implements ActionListener{
	private FirstPage f;
	private JTextField email,pass;
	private JButton signupButton,BackButton;
	private JLabel l1,l2,msg;
	
	public ChangePass(FirstPage f1){
		super("Pass Change");
		
		setVisible(true);
		f = f1;
	
		l2=new JLabel("Email");
		email=new JTextField(30);
		l1=new JLabel("Password");
		pass=new JTextField(10);
		signupButton=new JButton("Confirm");
		BackButton=new JButton("Back");
		msg=new JLabel("msg box");
		
		
		add(l2);add(email);add(l1);add(pass);
		add(signupButton);add(BackButton);
		add(msg);
		
		signupButton.setBackground(new Color(0x000000));
		signupButton.setForeground(Color.white);
		
		BackButton.setBackground(new Color(0xFF0000));
		BackButton.setForeground(Color.white);
		
		
		l2.setBounds(60,60,45,25);
		email.setBounds(140,60,205,25);
		l1.setBounds(60,95,60,25);
		pass.setBounds(140,95,205,25);
		signupButton.setBounds(140,130,100,25);
		BackButton.setBounds(245,130,100,25);
		msg.setBounds(140,170,200,30);
		
		signupButton.addActionListener(this);
		BackButton.addActionListener(this);
		
		setLayout(null);
		setSize(500,500);
		
		JFrame frame= new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private boolean isEmpty(TextField s){
		boolean flag=false;
		if(s.getText().length()==0)flag=true;
		return flag;
	}
	
	public void actionPerformed(ActionEvent e){
		
		String sig=e.getActionCommand();
		
		if(sig.equals("Confirm")){
			String sql="update information set Password='"+pass.getText()+"' where Email='"+email.getText()+"'";
			System.out.println(sql);
			DataAccess da=new DataAccess();
	
			if(da.updateDB(sql)>0){
					JOptionPane.showMessageDialog(this,"Data Updated");
					msg.setText("Data Updated");
			}
			else{
				    msg.setText("Update Error");
					JOptionPane.showMessageDialog(this,"Update Error!");
				}
		}
		else if(sig.equals("Back")){
			this.setVisible(false);
			f.setVisible(true);
		}
	}
}