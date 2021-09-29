import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


class DataAccess{
    Connection conn;
    String JDBC_DRIVER;  
    String DB_URL;
    Statement stmt;
    String USER;
    String PASS;
    ResultSet rs;
    public DataAccess(){
        JDBC_DRIVER = "com.mysql.jdbc.Driver";
        DB_URL = "jdbc:mysql://localhost:3306/citizen";
        USER = "root";
        PASS = "";
		
		/*JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
        DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
        USER = "scott";
        PASS = "tiger";*/
        try{
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void close()throws SQLException{
        if(rs!=null)rs.close();
        if(rs!=null)stmt.close();
    }
    public ResultSet getData(String query) {
        try{
            stmt = conn.createStatement();
            rs= stmt.executeQuery(query);
            //System.out.println("Info from DB");
        }
        catch(Exception ex){
            System.out.println("DB Read Error !");
            //ex.printStackTrace();
        }
        return rs;
   }
    public int updateDB(String sql){
        int numOfRowsUpdated=0;
        try{
            stmt = conn.createStatement(); 
            numOfRowsUpdated=stmt.executeUpdate(sql);
            System.out.println(numOfRowsUpdated+" row(s) updated");
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return numOfRowsUpdated;
    }
}
