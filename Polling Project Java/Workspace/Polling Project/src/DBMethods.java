import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class DBMethods {
	
	public Connection con1 = null;
	public Connection con2 = null;
	public Connection con3 = null;

	public Statement s1 = null;
	public Statement s2 = null;
	public Statement s3 = null;
	
	private ArrayList<String> al1 = new ArrayList<String>();
	private ArrayList<String> al2 = new ArrayList<String>();
	private ArrayList<String> al3 = new ArrayList<String>();
	private ArrayList<String> al4 = new ArrayList<String>();
	private ArrayList<String> al5 = new ArrayList<String>();
	private ArrayList<String> al6 = new ArrayList<String>();
	private ArrayList<String> al7 = new ArrayList<String>();
	private ArrayList<String> al9 = new ArrayList<String>();
	private ArrayList<String> al19 = new ArrayList<String>();
	
	public static ArrayList<String> al10 = new ArrayList<String>();
	public static ArrayList<String> al11 = new ArrayList<String>();
	public static ArrayList<String> al12 = new ArrayList<String>();
	public static ArrayList<String> al13 = new ArrayList<String>();
	public static ArrayList<String> al14 = new ArrayList<String>();
	public static ArrayList<String> al15 = new ArrayList<String>();
	public static ArrayList<String> al16 = new ArrayList<String>();	
	public static ArrayList<String> al17 = new ArrayList<String>();
	public static ArrayList<String> al18 = new ArrayList<String>();
	
	public static ArrayList<String> al20 = new ArrayList<String>();
	public static ArrayList<String> al21 = new ArrayList<String>();
	public static ArrayList<String> al22 = new ArrayList<String>();
	public static ArrayList<String> al23 = new ArrayList<String>();
	public static ArrayList<String> al24 = new ArrayList<String>();
	public static ArrayList<String> al25 = new ArrayList<String>();
	public static ArrayList<String> al26 = new ArrayList<String>();
	public static ArrayList<String> al27 = new ArrayList<String>();
	
	public static ArrayList<String> al28 = new ArrayList<String>();
	public static ArrayList<String> al29 = new ArrayList<String>();
	public static ArrayList<String> al30 = new ArrayList<String>();
	public static ArrayList<String> al31 = new ArrayList<String>();
	public static ArrayList<String> al32 = new ArrayList<String>();
	public static ArrayList<String> al33 = new ArrayList<String>();
	public static ArrayList<String> al34 = new ArrayList<String>();
	public static ArrayList<String> al35 = new ArrayList<String>();
	
	private ArrayList<Integer> al36 = new ArrayList<Integer>();
	private ArrayList<Integer> al37 = new ArrayList<Integer>();
	
	public static int position = -1;
	public static int item = -1;
	public static ArrayList<Integer> positions = new ArrayList<Integer>();
	public static ArrayList<Integer> IDpos = new ArrayList<Integer>();
	
	public static int position_VoterCount = -1;
	public static int item_VoterCount = -1;
	public static ArrayList<Integer> positions_VoterCount = new ArrayList<Integer>();
	public static ArrayList<Integer> IDpos_VoterCount = new ArrayList<Integer>();
	
	public static int position_Voter = -1;
	public static int item_Voter = -1;
	public static ArrayList<Integer> positions_Voter = new ArrayList<Integer>();
	public static ArrayList<Integer> IDpos_Voter = new ArrayList<Integer>();
	
	public static ArrayList<String> al8 = new ArrayList<String>();
	public static String CONNECT_TABLE_NAME = null;
	public static String CONNECT_TABLE_NAME_VOTESCOUNT = null;
	
	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	private final String DB_URL = "jdbc:mysql://localhost:3306/";
	   
	private final String USER = "root";
	private final String PASS = "encrypted";
			
	public DBMethods(){
		
		try{
		      
		      Class.forName(JDBC_DRIVER);

		      try{
		      con1 = DriverManager.getConnection(DB_URL, USER, PASS);
		      con2 = DriverManager.getConnection(DB_URL, USER, PASS);
		      }
		      catch(Exception e){
		    	 String error = e.getMessage();
		    	 if (error.contains("Communications link failure")){
		    		 JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "The Program Has Encountered An Error!", JOptionPane.ERROR_MESSAGE);
				     JOptionPane.showMessageDialog(null, "Please Restart The Application & Make Sure MySQL Server Is Up And Running", "Program Will Now Close!", JOptionPane.INFORMATION_MESSAGE);
				     System.exit(0);
		    	 }
		    	 else{
		    	  boolean x = true;
		    	  
		    	  JPasswordField dbpwd = new JPasswordField();
		    	  
		    	  Object [] pwdobj = {
		    			  "Enter MySQL Database Password : ", dbpwd
		    	  };
		    	  
		    	  do{
		    		  
		    		  int confirm = JOptionPane.showConfirmDialog(null, pwdobj, "Database Password Input", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
						
		    		  String s = new String(dbpwd.getPassword());
		    		  dbpwd.setText(null);
		    		  
		    		 	if(confirm == JOptionPane.OK_OPTION){
		    		 				    		  
		    		  try{		    			  
		    			  con3 = DriverManager.getConnection(DB_URL, USER, s);
				    	  x = false;		    			  
		    		  }
		    		  catch(Exception caught){
		    			 JOptionPane.showMessageDialog(null, "Error: Wrong Database Password, Please Retry!", "Invalid Password", JOptionPane.ERROR_MESSAGE);	    			  	    			  
		    		  }
		    		 	}
		    		 	else{
		    		 		
		    		 		System.exit(0);
		    		 		
		    		 	}
		    		     		  
		    	  }
		    	  while(x);
		    	 }
		    	  		    	  
		    	  s3 = con3.createStatement();
		    	  String sql = "UPDATE mysql.user SET Password=PASSWORD('encrypted') WHERE User='root'";
			      s3.executeUpdate(sql);
			      sql = "FLUSH PRIVILEGES";
			      s3.executeUpdate(sql);
			      
			      con3.close();
			      s3.close();
			      
			      con1 = DriverManager.getConnection(DB_URL, USER, PASS);
			      con2 = DriverManager.getConnection(DB_URL, USER, PASS);
			      
		      }
		     
		      s1 = con1.createStatement();
		      s2 = con2.createStatement();
		    
		      String sql = "CREATE DATABASE IF NOT EXISTS POLLING_DATABASE_INTERNALS";
		      s1.executeUpdate(sql);
		      sql = "CREATE DATABASE IF NOT EXISTS POLLING_DATABASE_EXTERNALS";
		      s1.executeUpdate(sql);	
		      sql = "USE POLLING_DATABASE_INTERNALS";
		      s1.executeUpdate(sql);
		      sql = "USE POLLING_DATABASE_EXTERNALS";
		      s2.executeUpdate(sql);
		      
		      
		      sql = "SELECT COUNT(*) FROM information_schema.tables WHERE table_schema = 'POLLING_DATABASE_INTERNALS' AND table_name = 'SOFTWARE_USERS'";
		      ResultSet rs = s1.executeQuery(sql);                  
		      rs.next();
		      boolean exists = rs.getInt("COUNT(*)") > 0;
		      
		      if(!exists){
		    	  
		    	  sql = "CREATE TABLE IF NOT EXISTS SOFTWARE_USERS (ID INT(10) NOT NULL PRIMARY KEY auto_increment, USERNAME VARCHAR(500), PASSWORD VARCHAR(500), DATEOFBIRTH DATE, DB_NAME VARCHAR(500), ORI_NAME VARCHAR(500))";
		          s1.executeUpdate(sql);
		    	  
		    	  sql = "INSERT INTO SOFTWARE_USERS(USERNAME, PASSWORD, DATEOFBIRTH, DB_NAME, ORI_NAME) VALUES (\"root\", \"toor\", NULL, \"root\", \"root\")";
				  s1.executeUpdate(sql);
		    	  
		      }
		      
		     sql = "SELECT COUNT(*) FROM information_schema.tables WHERE table_schema = 'POLLING_DATABASE_INTERNALS' AND table_name = 'LOCK_DATA'";
		     rs = s1.executeQuery(sql);
		     rs.next();
		     exists = rs.getInt("COUNT(*)") > 0;
		     
		     if(!exists){
		    	 
		    	  sql = "CREATE TABLE IF NOT EXISTS LOCK_DATA (ID INT(10) NOT NULL PRIMARY KEY auto_increment, DATEOFLOCK DATE, USERNAME VARCHAR(500), DATEOFUNLOCK DATE)";
		          s1.executeUpdate(sql);
		          
		          sql = "INSERT INTO LOCK_DATA(DATEOFLOCK, USERNAME, DATEOFUNLOCK) VALUES (NULL, \"root\", NULL)";
				  s1.executeUpdate(sql);
			    	  
		      }
		     
		     sql = "SELECT COUNT(*) FROM information_schema.tables WHERE table_schema = 'POLLING_DATABASE_INTERNALS' AND table_name = 'TRIES_DATA'";
		     rs = s1.executeQuery(sql);
		     rs.next();
		     exists = rs.getInt("COUNT(*)") > 0;
		     
		     if(!exists){
		    	 
		    	  sql = "CREATE TABLE IF NOT EXISTS TRIES_DATA (ID INT(10) NOT NULL PRIMARY KEY auto_increment, TRIES INT(10))";
		          s1.executeUpdate(sql);
		          
		          sql = "INSERT INTO TRIES_DATA(TRIES) VALUES (5)";
				  s1.executeUpdate(sql);
			    	  
		      }
		     
		     sql = "SELECT COUNT(*) FROM information_schema.tables WHERE table_schema = 'POLLING_DATABASE_INTERNALS' AND table_name = 'USER_DBLIST'";
		     rs = s1.executeQuery(sql);
		     rs.next();
		     exists = rs.getInt("COUNT(*)") > 0;
		     
		     if(!exists){
		    	 
		    	  sql = "CREATE TABLE IF NOT EXISTS USER_DBLIST(ID INT(10) PRIMARY KEY auto_increment, USERNAME VARCHAR(500), DB_NAMES VARCHAR(500))";
		          s1.executeUpdate(sql);
		          		    	  
		      }
		     
		     sql = "SELECT COUNT(*) FROM information_schema.tables WHERE table_schema = 'POLLING_DATABASE_INTERNALS' AND table_name = 'LOCK_STATUS'";
		     rs = s1.executeQuery(sql);
		     rs.next();
		     exists = rs.getInt("COUNT(*)") > 0;
		     
		     if(!exists){
		    	 
		    	  sql = "CREATE TABLE IF NOT EXISTS LOCK_STATUS (ID INT(10) NOT NULL PRIMARY KEY auto_increment, LOCK_CHECK VARCHAR(500))";
		          s1.executeUpdate(sql);
		          
		          sql = "INSERT INTO LOCK_STATUS(LOCK_CHECK) VALUES (\"FALSE\")";
				  s1.executeUpdate(sql);
		          		    	  
		      }
		     	          
		     this.setTriesAndLocked();
		     
		      }catch(Exception e){
		  
		     JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "The Program Has Encountered An Error!", JOptionPane.ERROR_MESSAGE);
		     JOptionPane.showMessageDialog(null, "Please Restart The Application & Make Sure MySQL Server Is Up And Running", "Program Will Now Close!", JOptionPane.INFORMATION_MESSAGE);
		     System.exit(0);
		   }
		   }

	private void setTriesAndLocked() {
		
		
		try {
			
			String sql = "SELECT * FROM TRIES_DATA";
			ResultSet rs = con1.prepareStatement(sql).executeQuery();
			
			rs.next();
			
			int tries = rs.getInt("TRIES");
			GUIData.tries = tries;
			
			if(GUIData.tries != 5){
				GUIData.t1 = new Thread(new ExtraMethods());
				
				if(!GUIData.printing){
					
					GUIData.printing = true;
					GUIData.t1.start();
										
					}			
			}
			
			sql = "SELECT * FROM LOCK_DATA";
			rs = con1.prepareStatement(sql).executeQuery();
			
				
			ArrayList<String> temp1 = new ArrayList<String>();
			ArrayList<String> temp2 = new ArrayList<String>();
				
			
			while(rs.next()){
								
				temp1.add(rs.getString("DATEOFLOCK"));
				temp2.add(rs.getString("DATEOFUNLOCK"));
				
			}
			
			if(temp1.size()>1){
				
				String tempDate = temp2.get(temp2.size() - 1);
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				
			    Date date1 = format.parse(tempDate);
			    Date date2 = format.parse(format.format(new Date()));
			    
			    if (date1.compareTo(date2) > 0) {
			    	 
			    	 JOptionPane.showMessageDialog(null, "Application Is Locked Till : " + tempDate + "\nLocked On : " + temp1.get(temp1.size() - 1), "Application Locked!", JOptionPane.ERROR_MESSAGE);
				     JOptionPane.showMessageDialog(null, "Please Restart Program When The Unlock Date Is Reached", "Program Will Now Close!", JOptionPane.INFORMATION_MESSAGE);
				     System.exit(0);
			        
			    }
			    else if(date1.compareTo(date2) <= 0){
			    	
			    	sql = "SELECT * FROM LOCK_STATUS";
					rs = con1.prepareStatement(sql).executeQuery();
			    	
					rs.next();
					
					String status = rs.getString("LOCK_CHECK");
					
					if(status.equals("TRUE")){
			    	GUIData.tries = 5;
			    	GUIData.printing = false;
			    	
			    	sql = "UPDATE LOCK_STATUS SET LOCK_CHECK=\"FALSE\" WHERE ID = 1";
					s1.executeUpdate(sql);
					
					sql = "UPDATE TRIES_DATA SET TRIES = " + GUIData.tries + " WHERE ID = 1";
					s1.executeUpdate(sql);
					}
			    	
			    }
			    				
			}
			
			
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "The Program Has Encountered An Error!", JOptionPane.ERROR_MESSAGE);
		    JOptionPane.showMessageDialog(null, "Please Restart The Application & Make Sure MySQL Server Is Up And Running", "Program Will Now Close!", JOptionPane.INFORMATION_MESSAGE);
		    System.exit(0);
			
		}	
		
	}

	public int checkUsernameEntry(String s) {
		
		String s1 = s;
		s1 = s1.trim();
		s1 = s1.toLowerCase();
		
		int found = -1;
		
		for(int i = 0; i<al1.size(); i++){
			
			if(s1.equals(al1.get(i).toLowerCase())){
				
				found = 1;
				
			}
			
		}
		
		if(found == 1){
			
			return -1;
			
		}
		else{
			
			return 1;
			
		}	
		
	}
	
	public int checkDBEntry(String s) {
		
		String s1 = s;
		s1 = s1.trim();
		s1 = s1.toLowerCase();
		
		int found = -1;
		
		for(int i = 0; i<al2.size(); i++){
			
			if(s1.equals(al2.get(i).toLowerCase())){
				
				found = 1;
				
			}
			
		}
		
		if(found == 1){
			
			return -1;
			
		}
		else{
			
			return 1;
			
		}	
		
	}

	public int add_User(String un, String pwd, String ddm, String name, String dob) {
		
		String sql = "INSERT INTO SOFTWARE_USERS(USERNAME, PASSWORD, DATEOFBIRTH, DB_NAME, ORI_NAME) VALUES (\""+un+"\",\"" +pwd+"\",\""+dob+"\", \""+ddm+"\",\""+name+"\")";
		
		try {
			s1.executeUpdate(sql);
			
			sql = "CREATE TABLE IF NOT EXISTS CANDIDATELIST_" + ddm + " (ID INT(10) PRIMARY KEY, Cand_Name VARCHAR(500), Cand_About VARCHAR(500), Cand_House VARCHAR(500), Cand_DOB DATE, Cand_Votes INT(200), Cand_Post VARCHAR(500))";
			s2.executeUpdate(sql);
			
			sql = "CREATE TABLE IF NOT EXISTS VOTERLIST_STUDENTS_" + ddm + " (ID INT(10) PRIMARY KEY, House VARCHAR(500))";
			s2.executeUpdate(sql);
			
			sql = "CREATE TABLE IF NOT EXISTS VOTERLIST_TEACHERS_" + ddm + " (ID INT(10) PRIMARY KEY auto_increment, House VARCHAR(500))";
			s2.executeUpdate(sql);
			
			sql = "INSERT INTO USER_DBLIST(USERNAME, DB_NAMES) VALUES(\"" + un + "\", \"" + ddm + "\")";
			s1.executeUpdate(sql);
			
			File testDir = new File (init_Application.startupPath + "\\Data\\" + un + "\\");
			
			if (!testDir.exists() && !testDir.isDirectory()){
				 
				testDir.mkdirs();
							
			}
			
			testDir = new File (init_Application.startupPath + "\\Data\\" + un + "\\" + ddm + "_ImageData\\");
						
			if (!testDir.exists() && !testDir.isDirectory()){
				 
				testDir.mkdirs();
							
			}
			
			return 0;
			
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "The Program Has Encountered An Error!", JOptionPane.ERROR_MESSAGE);
		    JOptionPane.showMessageDialog(null, "Please Restart The Application & Make Sure MySQL Server Is Up And Running", "Program Will Now Close!", JOptionPane.INFORMATION_MESSAGE);
		    System.exit(0);
		}	
		return -1;
				
	}

	public void initiateUserData() {
		
		al1.clear();
		al2.clear();
		
		try{
					
					String sql = "SELECT * FROM SOFTWARE_USERS";
					ResultSet rs = (con1.prepareStatement(sql)).executeQuery();
					
					while (rs.next()){
						
						String UN = rs.getString("USERNAME");
						al1.add(UN);
									
					}
					
					sql = "SELECT * FROM USER_DBLIST";
					 rs = con1.prepareStatement(sql).executeQuery();
										
					 while (rs.next()){				
										
							al2.add(rs.getString("DB_NAMES"));					
						
					}
					
					
			} catch (Exception e){
				JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "The Program Has Encountered An Error!", JOptionPane.ERROR_MESSAGE);
			    JOptionPane.showMessageDialog(null, "Please Restart The Application & Make Sure MySQL Server Is Up And Running", "Program Will Now Close!", JOptionPane.INFORMATION_MESSAGE);
			    System.exit(0);
				
			}
		
	}

	public void reInitData() {
	
		GUIData.cb4.removeAllItems();
		al2.clear();
		al3.clear();
		al4.clear();
		al5.clear();
		al6.clear();
		al7.clear();
		al9.clear();
		
		
		try{
			
			String sql = "SELECT * FROM SOFTWARE_USERS";
			ResultSet rs = (con1.prepareStatement(sql)).executeQuery();
			
			while (rs.next()){
				
				String UN = rs.getString("USERNAME");
				String PWD = rs.getString("PASSWORD");
				String DOB = rs.getString("DATEOFBIRTH");
				String DDN = rs.getString("DB_NAME");
				String ORN = rs.getString("ORI_NAME");
				al3.add(UN);
				al4.add(PWD);
				al5.add(DOB);
				al6.add(DDN);
				al7.add(ORN);
							
			}
						
			 sql = "SELECT * FROM USER_DBLIST";
			 rs = con1.prepareStatement(sql).executeQuery();
					
			 while (rs.next()){				
						
				 	al9.add(rs.getString("USERNAME")) ;
					al2.add(rs.getString("DB_NAMES"));					
	
			 }
			 
			ArrayList<String> tempList = new ArrayList<String>();
			tempList.addAll(al9);
			LinkedHashSet<String> hs = new LinkedHashSet<String>();
			hs.addAll(tempList);
			tempList.clear();
			tempList.addAll(hs);
			 		
			 int totalItems = 0;
			 
			 for(int i = 0; i<tempList.size(); i++){
				 	
				 GUIData.cb4.addItem(tempList.get(i));
				 totalItems = totalItems + 1;
				 
			 }			 
			
			 if(!(totalItems>0)){
				 
				 GUIData.rb2.setEnabled(false);
				 				 
			 }
			 else{
				 
				 GUIData.rb2.setEnabled(true);
				 
			 }
			 
			
	} catch (Exception e){
		JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "The Program Has Encountered An Error!", JOptionPane.ERROR_MESSAGE);
	    JOptionPane.showMessageDialog(null, "Please Restart The Application & Make Sure MySQL Server Is Up And Running", "Program Will Now Close!", JOptionPane.INFORMATION_MESSAGE);
	    System.exit(0);
		
	}
		
	}

	public String checkIfExists(String s1, String s2, String s3, String s4) {
		
		String PWD = null;
		
		for (int i =0; i<al3.size(); i++){
		if(s1.equals(al3.get(i)) && s2.equals(al6.get(i)) && s3.equals(al7.get(i)) && s4.equals(al5.get(i))){
			
			PWD = al4.get(i);
			
		}
		}
		
		return PWD;
	}

	public void updateTriesEntry() {
			
		try {
			String sql = "UPDATE TRIES_DATA SET TRIES = " + GUIData.tries + " WHERE ID = 1";
			s1.executeUpdate(sql);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "The Program Has Encountered An Error!", JOptionPane.ERROR_MESSAGE);
		    JOptionPane.showMessageDialog(null, "Please Restart The Application & Make Sure MySQL Server Is Up And Running", "Program Will Now Close!", JOptionPane.INFORMATION_MESSAGE);
		    System.exit(0);
		}
		
	}

	public void updateLockInfo(String date1, String date2) {
					
		try {
			String sql = "INSERT INTO LOCK_DATA(DATEOFLOCK, USERNAME, DATEOFUNLOCK) VALUES(\""+date1+"\",\"FORGOT.PASSWORD.FORM\",\"" +date2+"\")";
			s1.executeUpdate(sql);
			
			sql = "UPDATE LOCK_STATUS SET LOCK_CHECK=\"TRUE\" WHERE ID = 1";
			s1.executeUpdate(sql);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "The Program Has Encountered An Error!", JOptionPane.ERROR_MESSAGE);
		    JOptionPane.showMessageDialog(null, "Please Restart The Application & Make Sure MySQL Server Is Up And Running", "Program Will Now Close!", JOptionPane.INFORMATION_MESSAGE);
		    System.exit(0);
		}
		
	}
	
	public void updateLockInfo(String date1, String date2, String UN) {
		
		try {
			String sql = "INSERT INTO LOCK_DATA(DATEOFLOCK, USERNAME, DATEOFUNLOCK) VALUES(\""+date1+"\",\"" + UN + "\",\"" +date2+"\")";
			s1.executeUpdate(sql);
			
			sql = "UPDATE LOCK_STATUS SET LOCK_CHECK=\"TRUE\" WHERE ID = 1";
			s1.executeUpdate(sql);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "The Program Has Encountered An Error!", JOptionPane.ERROR_MESSAGE);
		    JOptionPane.showMessageDialog(null, "Please Restart The Application & Make Sure MySQL Server Is Up And Running", "Program Will Now Close!", JOptionPane.INFORMATION_MESSAGE);
		    System.exit(0);
		}
		
	}

	public void resetTries() {
		
		try {
			String sql = "UPDATE TRIES_DATA SET TRIES = " + GUIData.tries + " WHERE ID = 1";
			s1.executeUpdate(sql);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "The Program Has Encountered An Error!", JOptionPane.ERROR_MESSAGE);
		    JOptionPane.showMessageDialog(null, "Please Restart The Application & Make Sure MySQL Server Is Up And Running", "Program Will Now Close!", JOptionPane.INFORMATION_MESSAGE);
		    System.exit(0);
		}
		
	}

	public boolean checkEntry(String s1, String s2) {
		
		int found = -1;
		
		for(int i = 0; i< al3.size(); i++){
			
			if(s1.equals(al3.get(i)) && s2.equals(al4.get(i))){
				
				found = 1;
				
			}
			
		}
		
		if(found == 1){
			return true;
		}
		else{		
		return false;
		}
	}

	public void initiateTableData(String s1) {
			
		al8.clear();
		
		try {
			
			String sql = "SELECT * FROM USER_DBLIST";
			ResultSet rs = con1.prepareStatement(sql).executeQuery();
						
			while (rs.next()){
				
				String s = rs.getString("USERNAME");
				if(s.equals(s1)){
					
					al8.add(rs.getString("DB_NAMES"));
					
				}
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "The Program Has Encountered An Error!", JOptionPane.ERROR_MESSAGE);
		    JOptionPane.showMessageDialog(null, "Please Restart The Application & Make Sure MySQL Server Is Up And Running", "Program Will Now Close!", JOptionPane.INFORMATION_MESSAGE);
		    System.exit(0);
		}	
		
	}

	public void addVoterEntry(String house,	String eNR_NO) {
		
		try{
			String sql = "INSERT INTO " +DBMethods.CONNECT_TABLE_NAME+"(ID, HOUSE) VALUES(" + Integer.parseInt(GUIData.ENR_NO) + ",\""+GUIData.Current_User_House+"\")";
			s2.executeUpdate(sql);
			}
			catch(SQLException e){
				if (e.getErrorCode() == 1062)
				{
					
					JOptionPane.showMessageDialog(null, "Enrollment Number Already Present! Try A Different Database", "Duplicate Entry!", JOptionPane.ERROR_MESSAGE);
					return;
					
				}else{
				JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "The Program Has Encountered An Error!", JOptionPane.ERROR_MESSAGE);
			    JOptionPane.showMessageDialog(null, "Please Restart The Application & Make Sure MySQL Server Is Up And Running", "Program Will Now Close!", JOptionPane.INFORMATION_MESSAGE);
			    System.exit(0);
				}
			}
			catch(Exception e){			
			JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "The Program Has Encountered An Error!", JOptionPane.ERROR_MESSAGE);
		    JOptionPane.showMessageDialog(null, "Please Restart The Application & Make Sure MySQL Server Is Up And Running", "Program Will Now Close!", JOptionPane.INFORMATION_MESSAGE);
		    System.exit(0);			
			}
		
	}
	
	public void addVoterEntry(String house) {
		
		try{
		String sql = "INSERT INTO " +DBMethods.CONNECT_TABLE_NAME+"(HOUSE) VALUES(\""+GUIData.Current_User_House+"\")";
		s2.executeUpdate(sql);
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "The Program Has Encountered An Error!", JOptionPane.ERROR_MESSAGE);
		    JOptionPane.showMessageDialog(null, "Please Restart The Application & Make Sure MySQL Server Is Up And Running", "Program Will Now Close!", JOptionPane.INFORMATION_MESSAGE);
		    System.exit(0);			
		}
		
	}

	public void initiateAccountDeletion() {
		
		try{
			
			initiateTableData(GUIData.Current_User);
			
			String sql = "DELETE FROM SOFTWARE_USERS WHERE USERNAME = \'" +GUIData.Current_User+ "\'";
			s1.executeUpdate(sql);
			
			sql = "DELETE FROM USER_DBLIST WHERE USERNAME = \'" +GUIData.Current_User+ "\'";
			s1.executeUpdate(sql);
			
			for (int i = 0; i<al8.size(); i++){
				
				sql = "DROP TABLE IF EXISTS CANDIDATELIST_" + al8.get(i);
				s2.executeUpdate(sql);
				
				sql = "DROP TABLE IF EXISTS VOTERLIST_STUDENTS_" + al8.get(i);
				s2.executeUpdate(sql);
				
				sql = "DROP TABLE IF EXISTS VOTERLIST_TEACHERS_" + al8.get(i);
				s2.executeUpdate(sql);			
			}
			
			File directory = new File(init_Application.startupPath + "\\Data\\" + GUIData.Current_User);
			
			DBMethods.deleteDirectory(directory);
			
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "The Program Has Encountered An Error!", JOptionPane.ERROR_MESSAGE);
		    JOptionPane.showMessageDialog(null, "Please Restart The Application & Make Sure MySQL Server Is Up And Running", "Program Will Now Close!", JOptionPane.INFORMATION_MESSAGE);
		    System.exit(0);			
		}
		
	}

	public void loadEntries() {
		
		DBMethods.al10.clear();
		DBMethods.al11.clear();
		DBMethods.al12.clear();
		DBMethods.al13.clear();
		DBMethods.al14.clear();
		DBMethods.al15.clear();
		DBMethods.al16.clear();
		DBMethods.al17.clear();
		GUIData.cr.clear();
		GUIData.l1.setModel(GUIData.cr);
		
		try {
			
			String sql = "SELECT * FROM " + DBMethods.CONNECT_TABLE_NAME;
			ResultSet rs = con2.prepareStatement(sql).executeQuery();
						
			while (rs.next()){
				
				String ID = rs.getString("ID");
				String Name = rs.getString("CAND_NAME");
				String About = rs.getString("CAND_ABOUT");
				String House = rs.getString("CAND_HOUSE");
				String DOB = rs.getString("CAND_DOB");
				String Votes = rs.getString("CAND_VOTES");
				String Criteria = rs.getString("CAND_POST");
				DBMethods.al10.add(ID);
				DBMethods.al11.add(Name);
				DBMethods.al12.add(About);
				DBMethods.al13.add(House);
				DBMethods.al14.add(DOB);
				DBMethods.al15.add(Votes);
				DBMethods.al16.add(Criteria);
			}
			
			LinkedHashSet<String> lhs = new LinkedHashSet<String>();
			lhs.addAll(al16);
			DBMethods.al17.addAll(lhs);
			
			for(int i = 0; i<al17.size(); i++){
				GUIData.cr.addElement(al17.get(i));
			}
			
			GUIData.l1.setModel(GUIData.cr);
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "The Program Has Encountered An Error!", JOptionPane.ERROR_MESSAGE);
		    JOptionPane.showMessageDialog(null, "Please Restart The Application & Make Sure MySQL Server Is Up And Running", "Program Will Now Close!", JOptionPane.INFORMATION_MESSAGE);
		    System.exit(0);
		}
		
	}
	
	public void injectData(String name, String criteria, String house, String DOB, String about, BufferedImage i){
		
		try{
			
			int ID = -1;
			if(al10.size() == 0){
				ID = 1;
			}
			else{
				ID = Integer.parseInt(al10.get(al10.size() - 1)) + 1;
			}
			
			String sql = "INSERT INTO " + DBMethods.CONNECT_TABLE_NAME + "(ID, Cand_Name, Cand_About, Cand_House, Cand_DOB, Cand_Votes, Cand_Post) VALUES(\""+ID+"\",\""+name+"\",\"" + about + "\",\"" +house+"\",\""+DOB+"\",\""+0+"\",\""+criteria+"\")";
			s2.executeUpdate(sql);
			
			String location = DBMethods.CONNECT_TABLE_NAME.replace("CANDIDATELIST_", "");
			
			File outputfile = new File(init_Application.startupPath + "\\Data\\" + GUIData.Current_User +"\\"+location+"_ImageData\\" + ID + ".jpg");
		    ImageIO.write(i, "jpg", outputfile);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "The Program Has Encountered An Error!", JOptionPane.ERROR_MESSAGE);
		    JOptionPane.showMessageDialog(null, "Please Restart The Application & Make Sure MySQL Server Is Up And Running", "Program Will Now Close!", JOptionPane.INFORMATION_MESSAGE);
		    System.exit(0);
		}
		
	}
	
	public void initiateDelete(int ID){
		
		try{
		String sql = "DELETE FROM "+ DBMethods.CONNECT_TABLE_NAME + " WHERE ID = \'" +ID+ "\'";
		s2.executeUpdate(sql);
		
		String location = DBMethods.CONNECT_TABLE_NAME.replace("CANDIDATELIST_", "");
		
		File deletefile = new File(init_Application.startupPath + "\\Data\\" + GUIData.Current_User +"\\"+location+"_ImageData\\" + ID + ".jpg");
		if(deletefile.exists() && deletefile.canRead()){
			deletefile.delete();
		}
		
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "The Program Has Encountered An Error!", JOptionPane.ERROR_MESSAGE);
		    JOptionPane.showMessageDialog(null, "Please Restart The Application & Make Sure MySQL Server Is Up And Running", "Program Will Now Close!", JOptionPane.INFORMATION_MESSAGE);
		    System.exit(0);
		}
		
	}
	
	public void deleteCriteria(String criteria){
		
		try{
			
		ArrayList<String> tmp = new ArrayList<String>();
				
		for(int i=0; i<al16.size(); i++){
			if(al16.get(i).equals(criteria)){
				tmp.add(al10.get(i));
			}
		}
		
		for(int i =0; i<tmp.size(); i++){
			int ID = Integer.parseInt(tmp.get(i));
			String sql = "DELETE FROM " + DBMethods.CONNECT_TABLE_NAME + " WHERE ID = \'" +ID+ "\'";
			s2.executeUpdate(sql);
			
			String location = DBMethods.CONNECT_TABLE_NAME.replace("CANDIDATELIST_", "");
			
			File deletefile = new File(init_Application.startupPath + "\\Data\\" + GUIData.Current_User +"\\"+location+"_ImageData\\" + ID + ".jpg");
			if(deletefile.exists() && deletefile.canRead()){
				deletefile.delete();
			}
		}
			
		} catch(Exception e){
			
			JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "The Program Has Encountered An Error!", JOptionPane.ERROR_MESSAGE);
		    JOptionPane.showMessageDialog(null, "Please Restart The Application & Make Sure MySQL Server Is Up And Running", "Program Will Now Close!", JOptionPane.INFORMATION_MESSAGE);
		    System.exit(0);
			
		}
		
		
	}
	
	public void updateData(String name, String criteria, String house, String DOB, String about, BufferedImage i) {
		
		try{
			
			int ID = GUIData.IDSelected;
						
			String sql = "UPDATE " + DBMethods.CONNECT_TABLE_NAME + " SET CAND_NAME = \"" + name + "\", CAND_ABOUT = \"" + about + "\", CAND_HOUSE = \"" + house + "\", CAND_DOB = \"" + DOB + "\", CAND_POST = \"" + criteria + "\" WHERE ID = " + ID;
			s2.executeUpdate(sql);
									
			File outputfile = new File(init_Application.startupPath + "\\Data\\" + GUIData.Current_User +"\\"+GUIData.Current_User+"_ImageData\\" + ID + ".jpg");
		    
			if(outputfile.exists() && outputfile.canRead()){
				outputfile.delete();
			}
			
			ImageIO.write(i, "jpg", outputfile);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "The Program Has Encountered An Error!", JOptionPane.ERROR_MESSAGE);
		    JOptionPane.showMessageDialog(null, "Please Restart The Application & Make Sure MySQL Server Is Up And Running", "Program Will Now Close!", JOptionPane.INFORMATION_MESSAGE);
		    System.exit(0);
		}
		
	}
	
	public void changePWD(String pwd) {
		
		try{
									
			String sql = "UPDATE SOFTWARE_USERS SET PASSWORD = \"" + pwd + "\" WHERE USERNAME = \"" + GUIData.Current_User + "\"";
			s1.executeUpdate(sql);
					
			GUIData.Current_User_Password = pwd;
			reInitData();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "The Program Has Encountered An Error!", JOptionPane.ERROR_MESSAGE);
		    JOptionPane.showMessageDialog(null, "Please Restart The Application & Make Sure MySQL Server Is Up And Running", "Program Will Now Close!", JOptionPane.INFORMATION_MESSAGE);
		    System.exit(0);
		}
		
	}
	
	public void addDatabaseEntry(String username, String dbname) {
	
		try {
						
			String sql = "CREATE TABLE IF NOT EXISTS CANDIDATELIST_" + dbname + " (ID INT(10) PRIMARY KEY, Cand_Name VARCHAR(500), Cand_About VARCHAR(500), Cand_House VARCHAR(500), Cand_DOB DATE, Cand_Votes INT(200), Cand_Post VARCHAR(500))";
			s2.executeUpdate(sql);
			
			sql = "CREATE TABLE IF NOT EXISTS VOTERLIST_STUDENTS_" + dbname + " (ID INT(10) PRIMARY KEY, House VARCHAR(500))";
			s2.executeUpdate(sql);
			
			sql = "CREATE TABLE IF NOT EXISTS VOTERLIST_TEACHERS_" + dbname + " (ID INT(10) PRIMARY KEY auto_increment, House VARCHAR(500))";
			s2.executeUpdate(sql);
			
			sql = "INSERT INTO USER_DBLIST(USERNAME, DB_NAMES) VALUES(\"" + username + "\", \"" + dbname + "\")";
			s1.executeUpdate(sql);
			
			File testDir = new File (init_Application.startupPath + "\\Data\\" + username + "\\" + dbname + "_ImageData\\");
						
			if (!testDir.exists() && !testDir.isDirectory()){
				 
				testDir.mkdirs();
							
			}
			
			reInitData();
			initiateUserData();
						
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "The Program Has Encountered An Error!", JOptionPane.ERROR_MESSAGE);
		    JOptionPane.showMessageDialog(null, "Please Restart The Application & Make Sure MySQL Server Is Up And Running", "Program Will Now Close!", JOptionPane.INFORMATION_MESSAGE);
		    System.exit(0);
		}
		
	}   
	
	public void reLoadDatabases() {
		
		al18.clear();
		
		try{
			
		String sql = "SELECT * FROM USER_DBLIST";
		 ResultSet rs = con1.prepareStatement(sql).executeQuery();
							
		 while (rs.next()){				
							
			 	String UN = rs.getString("USERNAME");
			 	String DBN = rs.getString("DB_NAMES");
			 	
			 	if(GUIData.Current_User.equals(UN)){
				DBMethods.al18.add(DBN);					
			 	}
		}
		
		
	} catch (Exception e){
		
	JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "The Program Has Encountered An Error!", JOptionPane.ERROR_MESSAGE);
	JOptionPane.showMessageDialog(null, "Please Restart The Application & Make Sure MySQL Server Is Up And Running", "Program Will Now Close!", JOptionPane.INFORMATION_MESSAGE);
	System.exit(0);
	
	}
		
	}
	
	public void deleteDatabase(String dbname) {
		
		try{
						
			String sql = "DELETE FROM USER_DBLIST WHERE DB_NAMES = \'" +dbname+ "\'";
			s1.executeUpdate(sql);
							
				sql = "DROP TABLE IF EXISTS CANDIDATELIST_" + dbname;
				s2.executeUpdate(sql);
				
				sql = "DROP TABLE IF EXISTS VOTERLIST_STUDENTS_" + dbname;
				s2.executeUpdate(sql);
				
				sql = "DROP TABLE IF EXISTS VOTERLIST_TEACHERS_" + dbname;
				s2.executeUpdate(sql);			
			
			
			File directory = new File(init_Application.startupPath + "\\Data\\" + GUIData.Current_User + "\\" + dbname + "_ImageData");
			
			DBMethods.deleteDirectory(directory);
			
			reInitData();
			initiateUserData();
			
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "The Program Has Encountered An Error!", JOptionPane.ERROR_MESSAGE);
		    JOptionPane.showMessageDialog(null, "Please Restart The Application & Make Sure MySQL Server Is Up And Running", "Program Will Now Close!", JOptionPane.INFORMATION_MESSAGE);
		    System.exit(0);			
		}

		
	}
	
	public String DefaultDBName(String name){
		
		for(int i = 0; i<al3.size(); i++){
			
			if(name.equals(al3.get(i))){
				
				return al6.get(i);
				
			}
			
		}
		
		return null;
		
	}
	
	public void resetDatabase(String dbname) {
		
		try{
										
				String sql = "DROP TABLE IF EXISTS CANDIDATELIST_" + dbname;
				s2.executeUpdate(sql);
				
				sql = "DROP TABLE IF EXISTS VOTERLIST_STUDENTS_" + dbname;
				s2.executeUpdate(sql);
				
				sql = "DROP TABLE IF EXISTS VOTERLIST_TEACHERS_" + dbname;
				s2.executeUpdate(sql);			
			
			
			File directory = new File(init_Application.startupPath + "\\Data\\" + GUIData.Current_User + "\\" + dbname + "_ImageData");
			
			DBMethods.deleteDirectory(directory);
			
			
			sql = "CREATE TABLE IF NOT EXISTS CANDIDATELIST_" + dbname + " (ID INT(10) PRIMARY KEY, Cand_Name VARCHAR(500), Cand_About VARCHAR(500), Cand_House VARCHAR(500), Cand_DOB DATE, Cand_Votes INT(200), Cand_Post VARCHAR(500))";
			s2.executeUpdate(sql);
			
			sql = "CREATE TABLE IF NOT EXISTS VOTERLIST_STUDENTS_" + dbname + " (ID INT(10) PRIMARY KEY, House VARCHAR(500))";
			s2.executeUpdate(sql);
			
			sql = "CREATE TABLE IF NOT EXISTS VOTERLIST_TEACHERS_" + dbname + " (ID INT(10) PRIMARY KEY auto_increment, House VARCHAR(500))";
			s2.executeUpdate(sql);
			
			directory = new File(init_Application.startupPath + "\\Data\\" + GUIData.Current_User + "\\" + dbname + "_ImageData\\");
			
			if(!directory.exists() && !directory.isDirectory()){
				directory.mkdirs();
			}
			
			reInitData();
			initiateUserData();
			
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "The Program Has Encountered An Error!", JOptionPane.ERROR_MESSAGE);
		    JOptionPane.showMessageDialog(null, "Please Restart The Application & Make Sure MySQL Server Is Up And Running", "Program Will Now Close!", JOptionPane.INFORMATION_MESSAGE);
		    System.exit(0);			
		}

		
	}

	public void populateVoterCountBox() {
		
		al19.clear();
		
		try{
			
			String sql = "SELECT * FROM USER_DBLIST";
			ResultSet rs = con1.prepareStatement(sql).executeQuery();
								
			 while (rs.next()){				
								
				 	String UN = rs.getString("USERNAME");
				 	String DBN = rs.getString("DB_NAMES");
				 	
				 	if(GUIData.Current_User.equals(UN)){
					al19.add(DBN);					
				 	}
			}
			
			GUIData.cb8.removeAllItems();
			
			for(int i = 0; i<al19.size(); i++){
			GUIData.cb8.addItem(al19.get(i));
			}
			
		} catch (Exception e){
			
		JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "The Program Has Encountered An Error!", JOptionPane.ERROR_MESSAGE);
		JOptionPane.showMessageDialog(null, "Please Restart The Application & Make Sure MySQL Server Is Up And Running", "Program Will Now Close!", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
		
		}		
	}
	
	public void Connect_VoterCount(){
		
		DBMethods.al20.clear();
		DBMethods.al21.clear();
		DBMethods.al22.clear();
		DBMethods.al23.clear();
		DBMethods.al24.clear();
		DBMethods.al25.clear();
		DBMethods.al26.clear();
		DBMethods.al27.clear();
		GUIData.vccr.clear();
		GUIData.l3.setModel(GUIData.vccr);
		
		try {
			
			String sql = "SELECT * FROM " + DBMethods.CONNECT_TABLE_NAME_VOTESCOUNT;
			ResultSet rs = con2.prepareStatement(sql).executeQuery();
						
			while (rs.next()){
				
				String ID = rs.getString("ID");
				String Name = rs.getString("CAND_NAME");
				String About = rs.getString("CAND_ABOUT");
				String House = rs.getString("CAND_HOUSE");
				String DOB = rs.getString("CAND_DOB");
				String Votes = rs.getString("CAND_VOTES");
				String Criteria = rs.getString("CAND_POST");
				DBMethods.al20.add(ID);
				DBMethods.al21.add(Name);
				DBMethods.al22.add(About);
				DBMethods.al23.add(House);
				DBMethods.al24.add(DOB);
				DBMethods.al25.add(Votes);
				DBMethods.al26.add(Criteria);
			}
			
			LinkedHashSet<String> lhs = new LinkedHashSet<String>();
			lhs.addAll(al26);
			DBMethods.al27.addAll(lhs);
			
			for(int i = 0; i<al27.size(); i++){
				GUIData.vccr.addElement(al27.get(i));
			}
			
			GUIData.l3.setModel(GUIData.vccr);
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "The Program Has Encountered An Error!", JOptionPane.ERROR_MESSAGE);
		    JOptionPane.showMessageDialog(null, "Please Restart The Application & Make Sure MySQL Server Is Up And Running", "Program Will Now Close!", JOptionPane.INFORMATION_MESSAGE);
		    System.exit(0);
		}
	
		
	}
	
	public boolean initializeVotesArea(String DBName) {
	
		DBMethods.al28.clear();
		DBMethods.al29.clear();
		DBMethods.al30.clear();
		DBMethods.al31.clear();
		DBMethods.al32.clear();
		DBMethods.al33.clear();
		DBMethods.al34.clear();
		DBMethods.al35.clear();
		GUIData.vcr.clear();
		GUIData.l5.setModel(GUIData.vcr);
		
		try {
			
			String sql = "SELECT * FROM " + DBMethods.CONNECT_TABLE_NAME;
			ResultSet rs = con2.prepareStatement(sql).executeQuery();
						
			while (rs.next()){
				
				String ID = rs.getString("ID");
				String Name = rs.getString("CAND_NAME");
				String About = rs.getString("CAND_ABOUT");
				String House = rs.getString("CAND_HOUSE");
				String DOB = rs.getString("CAND_DOB");
				String Votes = rs.getString("CAND_VOTES");
				String Criteria = rs.getString("CAND_POST");
				DBMethods.al28.add(ID);
				DBMethods.al29.add(Name);
				DBMethods.al30.add(About);
				DBMethods.al31.add(House);
				DBMethods.al32.add(DOB);
				DBMethods.al33.add(Votes);
				DBMethods.al34.add(Criteria);
			}
			
			LinkedHashSet<String> lhs = new LinkedHashSet<String>();
			lhs.addAll(al34);
			DBMethods.al35.addAll(lhs);
			
			for(int i = 0; i<al35.size(); i++){
				GUIData.vcr.addElement(al35.get(i));
			}
			
			GUIData.l5.setModel(GUIData.vcr);
			
			if(al35.size() > 0){
				return true;
			}
			else{
				return false;
			}
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "The Program Has Encountered An Error!", JOptionPane.ERROR_MESSAGE);
		    JOptionPane.showMessageDialog(null, "Please Restart The Application & Make Sure MySQL Server Is Up And Running", "Program Will Now Close!", JOptionPane.INFORMATION_MESSAGE);
		    System.exit(0);
		}
	
		return false;
		
	}
	
	public void addVotes() {
		
		al36.clear();
		al37.clear();
		
		try {
			
			String sql = "SELECT * FROM " + DBMethods.CONNECT_TABLE_NAME;
			ResultSet rs = con2.prepareStatement(sql).executeQuery();
						
			while (rs.next()){
				
				int ID = Integer.parseInt(rs.getString("ID"));
				int Votes = Integer.parseInt(rs.getString("CAND_VOTES"));
				al36.add(ID);
				al37.add(Votes);
			}
			
			for(int i = 0; i<GUIData.VotedIDList.size(); i++){
				
				for(int j = 0; j<al36.size(); j++){
					
					if (GUIData.VotedIDList.get(i) == al36.get(j)){
						
						al37.set(j, al37.get(j) + 1);
						
					}
															
				}
				
			}
				
			for(int i=0; i<al36.size(); i++){
				
				sql = "UPDATE " + DBMethods.CONNECT_TABLE_NAME + " SET Cand_Votes = " + al37.get(i) + " WHERE ID = " + al36.get(i);
				s2.executeUpdate(sql);
				
			}
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "The Program Has Encountered An Error!", JOptionPane.ERROR_MESSAGE);
		    JOptionPane.showMessageDialog(null, "Please Restart The Application & Make Sure MySQL Server Is Up And Running", "Program Will Now Close!", JOptionPane.INFORMATION_MESSAGE);
		    System.exit(0);
		}
	
	}
	
	public boolean checkENRNo() {
		
		try{
			
		String sql = "SELECT * FROM " + DBMethods.CONNECT_TABLE_NAME;
		ResultSet rs = con2.prepareStatement(sql).executeQuery();
				
		ArrayList<Integer> enrnolist = new ArrayList<Integer>();
		
		while (rs.next()){
			
			int ID = Integer.parseInt(rs.getString("ID"));
			enrnolist.add(ID);
			
		}
		
		boolean found = false;
		
		for(int i = 0; i<enrnolist.size(); i++){
			
			if(Integer.parseInt(GUIData.ENR_NO) == enrnolist.get(i)){
				found = true;
			}
			
		}
		
		if(found){
			return true;
		}
		else{
			return false;
		}
		
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "The Program Has Encountered An Error!", JOptionPane.ERROR_MESSAGE);
		    JOptionPane.showMessageDialog(null, "Please Restart The Application & Make Sure MySQL Server Is Up And Running", "Program Will Now Close!", JOptionPane.INFORMATION_MESSAGE);
		    System.exit(0);		
		}
		return false;
		
	}


	
    public static void deleteDirectory(File directory) {  
        if (directory.exists()) {  
               File[] files = directory.listFiles();  
               if (null != files) {  
                     for (int i = 0; i < files.length; i++) {  
                            if (files[i].isDirectory()) {  
                                   deleteDirectory(files[i]);  
                            } else {  
                                   files[i].delete();  
                            }  
                     }  
               }  
               
               directory.delete();
        }          
 }

}


