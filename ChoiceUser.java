import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;



class ChoiceUser extends JFrame implements ActionListener{
	private FirstPage f;
	private JLabel lb;
	private JButton General,Student,Police,BackButton;
	public ChoiceUser(FirstPage f1){
		
			super("CHOICE");
			setSize(500,500);
			setVisible(true);
			f = f1;
			lb= new JLabel("User Categories");
		
			General= new JButton("General");
			Student= new JButton("Student");
			Police= new JButton("Police");
			BackButton=new JButton("Back");
		
			
			add(lb);add(General);add(Student);add(Police);add(BackButton);
			
			
			General.setBackground(new Color(0x000000));
			General.setForeground(Color.white);
			
			Student.setBackground(new Color(0x008000));
			Student.setForeground(Color.white);
			
			Police.setBackground(new Color(0xFF0000));
			Police.setForeground(Color.white);
			
			
			BackButton.setBackground(new Color(0xFF00FF));
			BackButton.setForeground(Color.white);
			
			
			//^^^^^^^^ SET POSITION^^^^^^^^^//
			
			lb.setBounds(80,35,95,25);
			General.setBounds(190,70,170,25);
			Student.setBounds(190,100,170,25);
			Police.setBounds(190,130,170,25);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
			BackButton.setBounds(375,130,70,25);
			
			
			General.addActionListener(this);
			Student.addActionListener(this);
			Police.addActionListener(this);
			BackButton.addActionListener(this);
			
			
			
			setLayout(null);
			//****CLOSING****//
			JFrame frame= new JFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						
	}
	public void actionPerformed(ActionEvent a2){
		String st= a2.getActionCommand();
		if(st.equals("General")){
			General fg= new General(this);
		}
		if(st.equals("Student")){
			Student fs= new Student(this);
		}
		if(st.equals("Police")){
			Police fp= new Police(this);
		}
		if(st.equals("Back")){
			this.setVisible(false);
			f.setVisible(true);
		}
	}
	
}
	
