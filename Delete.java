import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Delete extends JFrame implements ActionListener{
	private TextField email;
	private JButton confirmButton,cancelButton;
	private JLabel l,msg;
	private Frame parent;
	public Delete(){
		super("Delete Window");
		l=new JLabel("Email: ");
		email=new TextField(10);
		confirmButton=new JButton("Confirm");
		cancelButton=new JButton("Back");
		msg=new JLabel("msg box");
		add(l);add(email);
		add(confirmButton);add(cancelButton);
		add(msg);
		
		confirmButton.setBackground(new Color(0x000000));
		confirmButton.setForeground(Color.white);
		
		cancelButton.setBackground(new Color(0x000000));
		cancelButton.setForeground(Color.white);
		
		l.setBounds(10,60,50,30);
		email.setBounds(115,60,200,30);
		confirmButton.setBounds(120,130,100,30);
		cancelButton.setBounds(220,130,100,30);
		msg.setBounds(115,170,200,30);
		
		confirmButton.addActionListener(this);
		cancelButton.addActionListener(this);
		setLayout(null);
		setLocation(200,50);
		setSize(400,500);
	}
	private boolean isEmpty(TextField s){
		boolean flag=false;
		if(s.getText().length()==0)flag=true;
		return flag;
	}
	public void setParent(Frame p){
		parent=p;
	}
	public void actionPerformed(ActionEvent e){
		String sig=e.getActionCommand();
		String m="";
		if(sig.equals("Confirm")){
			String sql="delete from information where Email='"+email.getText()+"'";
			m=sql;
			DataAccess da=new DataAccess();
			if(isEmpty(email)){
				m="All fields are mandatory";
			}
			else{
				if(da.updateDB(sql)>0){
					m="Data Deleted";
				}
				else{
					m="Delete Error!";
				}
			}
		}
		else if(sig.equals("Back")){
			//parent.setVisible(true);
			FirstPage.home.loadData();
			this.setVisible(false);
		}
		if(m.length()>0){
			msg.setText(m);
			JOptionPane.showMessageDialog(this,m);
		}
	}
}