import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Home extends JFrame implements ActionListener, WindowListener{
	private JTextField tf,pf;
	private JButton logoutButton,exitButton,updateButton,deleteButton;
	private JTextArea ta;
	private Frame parent;
	public Home(){
		super("Java Home Window");
		logoutButton=new JButton("Logout");
		exitButton=new JButton("Exit");
		updateButton=new JButton("Update");
		deleteButton=new JButton("Delete");
		ta=new JTextArea(10,50);
		ta.setEditable(false);
		
		
		logoutButton.addActionListener(this);
		exitButton.addActionListener(this);
		updateButton.addActionListener(this);
		deleteButton.addActionListener(this);
		addWindowListener(this);
		
		logoutButton.setBackground(new Color(0x000000));
		logoutButton.setForeground(Color.white);
		
		exitButton.setBackground(new Color(0xFFC300));
		exitButton.setForeground(Color.white);
		
		updateButton.setBackground(new Color(0x00FF00));
		updateButton.setForeground(Color.white);
		
		deleteButton.setBackground(new Color(0x000080));
		deleteButton.setForeground(Color.white);
		

		//setBounds
		
		ta.setBounds(10,30,1200,400);
		logoutButton.setBounds(10,500,100,25);
		exitButton.setBounds(110,500,100,25);
		updateButton.setBounds(210,500,100,25);
		deleteButton.setBounds(310,500,100,25);
		
		
		
		
		add(ta);
		add(logoutButton);add(exitButton);
		add(updateButton);add(deleteButton);
		
		
		setLayout(null);
		//setLayout(new FlowLayout());
		setSize(500,600);
	}
	public void loadData(){
		String sql="select * from information";
		try{
			DataAccess da=new DataAccess();
			ResultSet rs=da.getData(sql);
			String data="";
			while(rs.next()){
				data=data+rs.getString("FirstName")+"-";
				data=data+rs.getString("LastName")+"-";
				data=data+rs.getString("Email")+"-";
				//data=data+rs.getString("Password")+"\n";
				data=data+rs.getString("PhoneNo")+"-";
				data=data+rs.getString("PresentAddress")+"-";
				data=data+rs.getString("PermanentAddress")+"-";
				data=data+rs.getString("NationalID")+"-";
				data=data+rs.getString("DateOfBirth")+"-";
				data=data+rs.getString("PassportNumber")+"-";
				data=data+rs.getString("BloodGroup")+"-";
				data=data+rs.getString("Age")+"-";
				data=data+rs.getString("Gender")+"\n";
			}
			ta.setText(data);
		}
		catch(Exception ex){
			System.out.println("Exception in home");
		}
	}
	public void setParent(Frame f){
		parent=f;
	}
	public void actionPerformed(ActionEvent e){	
		if(e.getSource()==logoutButton){
			this.setVisible(false);
			parent.setVisible(true);
		}
		else if(e.getSource()==exitButton){
			System.exit(0);
		}
		else if(e.getSource()==updateButton){
			FirstPage.edit.setVisible(true);
			FirstPage.edit.setParent(this);
			this.setVisible(false);
		}
		else if(e.getSource()==deleteButton){
			FirstPage.delete.setVisible(true);
			FirstPage.delete.setParent(this);
			//this.setVisible(false);
		}
	}
	public void windowActivated(WindowEvent e){	}
	public void windowClosed(WindowEvent e){}
	public void windowClosing(WindowEvent e){
		this.setVisible(false);
		parent.setVisible(true);
	}
	public void windowDeactivated(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowOpened(WindowEvent e){}
}