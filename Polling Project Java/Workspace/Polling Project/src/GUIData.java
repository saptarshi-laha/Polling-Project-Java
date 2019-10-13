import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import rik.jdatepicker.impl.JDatePanelImpl;
import rik.jdatepicker.impl.JDatePickerImpl;
import rik.jdatepicker.impl.UtilDateModel;


public class GUIData {
	
	
	public static int tries;
	public static boolean printing = false;
	public static String Current_User = null;
	public static String Current_User_Password = null;
	public static String Current_User_DBName = null;
	public static int Login_Type = 0;
	public static int Entries_Caught = -1;
	public static String ENR_NO = null;
	public static int IDSelected = -1;
	public static int IDSelected_VoterListCount = -1;
	public static int IDSelected_VoterList = -1;
	public static boolean VOTES_PAGE_OPEN = false;
	public static String Current_User_House = null;
	
	public DBMethods DBM;
		
	private JFrame frame1;
	private JLabel lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb9, lb10, lb11, lb12, lb15, lb16;
	private  JLabel lb13 = new JLabel("" + GUIData.tries);
	private  JLabel lb14 = new JLabel("" + GUIData.tries);
	private JRadioButton rb1; 
	public static JRadioButton rb2 = new JRadioButton("Polling");
	private JTextField tf1, tf3, tf4;
	private JPasswordField tf2, tf5;
	private JButton b1, b2, b3, b4;
	private ButtonGroup bg1;
	private JComboBox<String> cb2, cb3, cb5;
	public static JComboBox<String> cb4 = new JComboBox<String>();
		
	private JFrame frame2;
	private JLabel lb17, lb18, lb19, lb20, lb21, lb22, lb23;
	private JTextField tf6, tf7, tf8;
	private JPasswordField pf1;
	private JButton b5, b6, b7;
	private UtilDateModel model1;
	private JDatePanelImpl dp1;
	private JDatePickerImpl dpi1;
	
	private JFrame frame3;
	private JLabel lb24, lb25, lb26, lb27, lb28, lb30;
	private JLabel lb29 = new JLabel("" + GUIData.tries);
	private JTextField tf9, tf10, tf11;
	private JButton b8, b9;
	private JScrollPane jsp1;
	private UtilDateModel model2;
	private JDatePanelImpl dp2;
	private JDatePickerImpl dpi2;
	public static Thread t1;
	
	private JFrame frame4;
	private JLabel lb31, lb32, lb33, lb34, lb35, lb36, lb37, lb38;
	private JComboBox<String> cb6 = new JComboBox<String>();
	private JButton b10, b11;
	
	private JFrame frame5;
	private JButton b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25;
	private JScrollPane jsp2, jsp3, jsp4;
	public static JList<String> l1 = new JList<String>();
	private JList<String> l2;
	private JLabel lb39, lb40, lb41, lb42, lb43, lb44, lb45, lb46, lb47, lb48, lb49, lb50, lb51, lb52;
	private JTextField tf12;
	private JTextArea ta1;
	private JComboBox<String> cb7;
	private UtilDateModel model3;
	private JDatePanelImpl dp3;
	private JDatePickerImpl dpi3;
	public static DefaultListModel<String> cr = new DefaultListModel<String>();
	public static DefaultListModel<String> ca = new DefaultListModel<String>();
	
	private JFrame frame6;
	private JButton b26, b27, b28;
	public static JComboBox<String> cb8 = new JComboBox<String>();
	public static JList<String> l3 = new JList<String>(); 
	public static JList<String> l4 = new JList<String>();
	private JScrollPane jsp5, jsp6, jsp7;
	private JTextArea ta2;
	public static DefaultListModel<String> vccr = new DefaultListModel<String>();
	public static DefaultListModel<String> vcca = new DefaultListModel<String>();
	private JLabel lb53, lb54, lb55, lb57, lb59, lb61, lb62, lb63, lb64, lb66;
	private JTextField tf13, tf14, tf15, tf16;
	
	private JFrame frame7;
	private JButton b29;
	private JScrollPane jsp8, jsp9, jsp10;
	public static JList<String> l5 = new JList<String>();
	public static JList<String> l6 = new JList<String>();
	private JTextArea ta3;
	private JTextField tf17, tf18, tf19;
	private JLabel lb67, lb68, lb69, lb70, lb71, lb72, lb73, lb74, lb75, lb76, lb77, lb78;
	public static DefaultListModel<String> vcr = new DefaultListModel<String>();
	public static DefaultListModel<String> vca = new DefaultListModel<String>();
	
	public static ArrayList<Integer> VotedIDList = new ArrayList<Integer>();
	
	public void updateTextFields(){
		
		this.lb29.setText("" +GUIData.tries);
		this.lb13.setText("" +GUIData.tries);
		this.lb14.setText("" +GUIData.tries);
			
	
	}
			
	public class Listen_Action implements ActionListener{
			
			public void actionPerformed(ActionEvent e){
				
				if (e.getActionCommand().equals("RadioButton1")){
					
					frame1.setSize(328, 308);
					
					lb2.setVisible(true);
					lb3.setVisible(true);
					tf1.setVisible(true);
					tf2.setVisible(true);
					//lb8.setVisible(true);
					//cb1.setVisible(true);
					b1.setVisible(true);
					b4.setVisible(true);
					b3.setVisible(true);
					lb4.setVisible(true);
					lb13.setVisible(true);
										
					lb5.setVisible(false);
					cb2.setVisible(false);
					lb15.setVisible(false);
					cb3.setVisible(false);
					lb11.setVisible(false);
					cb4.setVisible(false);
					lb12.setVisible(false);
					tf3.setVisible(false);
					b2.setVisible(false);
					
					lb6.setVisible(false);
					lb7.setVisible(false);
					lb16.setVisible(false);
					tf4.setVisible(false);
					tf5.setVisible(false);
					cb5.setVisible(false);
					lb9.setVisible(false);
					lb14.setVisible(false);
					
				}
				else if (e.getActionCommand().equals("RadioButton2")){
					
					frame1.setSize(328, 150);
					
					lb2.setVisible(false);
					lb3.setVisible(false);
					tf1.setVisible(false);
					tf2.setVisible(false);
					//lb8.setVisible(false);
					//cb1.setVisible(false);
					b1.setVisible(false);
					b4.setVisible(false);
					b3.setVisible(false);
					lb4.setVisible(false);
					lb13.setVisible(false);
					
					lb5.setVisible(true);
					cb2.setVisible(true);
					lb15.setVisible(false);
					cb3.setVisible(false);
					lb11.setVisible(false);
					cb4.setVisible(false);
					lb12.setVisible(false);
					tf3.setVisible(false);
					b2.setVisible(false);
					
					lb6.setVisible(false);
					lb7.setVisible(false);
					lb16.setVisible(false);
					tf4.setVisible(false);
					tf5.setVisible(false);
					cb5.setVisible(false);
					lb9.setVisible(false);
					lb14.setVisible(false);
					
				}
				else if (e.getActionCommand().equals("Criteria")){
					
					if (cb2.getSelectedItem().toString().equals("Teacher")){
						
						frame1.setSize(328, 308);
						
						lb15.setVisible(false);
						cb3.setVisible(false);
						lb11.setVisible(false);
						cb4.setVisible(false);
						lb12.setVisible(false);
						tf3.setVisible(false);
						b2.setVisible(true);
						
						lb6.setVisible(true);
						lb7.setVisible(true);
						lb16.setVisible(true);
						tf4.setVisible(true);
						tf5.setVisible(true);
						cb5.setVisible(true);
						lb9.setVisible(true);
						lb14.setVisible(true);
						
					}
					else{
						
						frame1.setSize(328, 308);
						
						lb15.setVisible(true);
						cb3.setVisible(true);
						lb11.setVisible(true);
						cb4.setVisible(true);
						lb12.setVisible(true);
						tf3.setVisible(true);
						b2.setVisible(true);
						
						lb6.setVisible(false);
						lb7.setVisible(false);
						lb16.setVisible(false);
						tf4.setVisible(false);
						tf5.setVisible(false);
						cb5.setVisible(false);
						lb9.setVisible(false);
						lb14.setVisible(false);
						
					}
					
				}
				else if(e.getActionCommand().equals("REGISTER_NEW_USER")){
					
					frame1.setVisible(false);
					DBM.initiateUserData();
					showRegisterForm();		
					frame1.dispose();							
					
				}
				else if(e.getActionCommand().equals("BACK_REGISTER_FORM")){
					
					frame2.setVisible(false);
					showLoginForm();
					frame2.dispose();					
					
				}
				else if(e.getActionCommand().equals("RESET_VALUES_REGISTER_FORM")){
					
					tf6.setText("");
					tf7.setText("");
					tf8.setText("");
					pf1.setText("");
										
				}
				else if(e.getActionCommand().equals("CREATE_ACCOUNT")){
					
					String pwd = new String(pf1.getPassword());
					String[] ic = { "/", "\n", "\r", "\t", "\0", "\f", "`", "?", "*", "\\", "<", ">", "|", "\"", ":" };
					
					if(!tf6.getText().isEmpty() && !tf7.getText().isEmpty() && !tf8.getText().isEmpty() && !pwd.isEmpty() && !tf6.getText().contains(" ") && !tf7.getText().contains(" ") && !tf8.getText().contains(" ")){
						
						if(lb18.getText().equals("Username Available!")){
							if(lb23.getText().equals("Database Name Available!")){
							
							int contains = -1;
							
							for(int j =0; j<ic.length; j++){
								if (tf7.getText().contains(ic[j])){
									contains = 1;
								}
							}
							
							if(contains != 1){
							
							SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
							Date selectedDate = ((Date) dpi1.getModel().getValue());
							String s = null;
							try{
							s = dateFormat.format(selectedDate);
							}
							catch(Exception e1){
								JOptionPane.showMessageDialog(null, "Date Not Valid Or Date Area Is Not Filled", "Date Error!", JOptionPane.INFORMATION_MESSAGE);
								return;
							}
							
							Date dummyDate = new Date();
							String dummyDateStr = dateFormat.format(dummyDate);
							
							if(selectedDate.compareTo(dummyDate)>0){
								JOptionPane.showMessageDialog(null, "Date Not Valid! Specified Date Is In The Future!", "Date Error!", JOptionPane.INFORMATION_MESSAGE);
								return;
				        	}else if(s.compareTo(dummyDateStr)==0){
				        		JOptionPane.showMessageDialog(null, "Date Not Valid! Specified Date Is Today!", "Date Error!", JOptionPane.INFORMATION_MESSAGE);
								return;
				        	}
							
							int success = DBM.add_User(tf6.getText(), pwd, tf7.getText(), tf8.getText(), s);
							
							if(success == 0){
								
								JOptionPane.showMessageDialog(null, "User Successfully Registered!", "Registered!", JOptionPane.INFORMATION_MESSAGE);								
								frame2.setVisible(false);
								showLoginForm();
								frame2.dispose();								
								
							}	
							
							}
							else{
								
								JOptionPane.showMessageDialog(null, "Invalid File Name!", "Invalid Entry", JOptionPane.INFORMATION_MESSAGE);
								return;
								
							}
						}
							else{
								
								JOptionPane.showMessageDialog(null, "Database Name Is Already Taken!", "Database Name Taken", JOptionPane.INFORMATION_MESSAGE);
								return;
								
							}
							
						}
						else{
							
							JOptionPane.showMessageDialog(null, "Username Is Already Taken!", "Username Taken", JOptionPane.INFORMATION_MESSAGE);
							return;
						}
						
					}
					else{
						
						JOptionPane.showMessageDialog(null, "Entry Field Are Empty Or Spaces Are Present!!", "Empty Fields", JOptionPane.INFORMATION_MESSAGE);
						return;
						
					}
					
					
				}
				
				else if(e.getActionCommand().equals("FORGOT_PASSWORD")){
					
					frame1.setVisible(false);
					showForgotPasswordForm();
					frame1.dispose();					
					
				}
				
				else if(e.getActionCommand().equals("BACK_FORGOT_PWD")){
					
					frame3.setVisible(false);
					showLoginForm();
					frame3.dispose();				
					
				}
				
				else if(e.getActionCommand().equals("GET_PWD")){
					
					if (!tf9.getText().isEmpty() && !tf10.getText().isEmpty() && !tf11.getText().isEmpty() && !tf9.getText().contains(" ") && !tf10.getText().contains(" ") && !tf11.getText().contains(" ")){
						
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						Date selectedDate = ((Date) dpi2.getModel().getValue());
						String s = null;
						try{
						s = dateFormat.format(selectedDate);
						}
						catch(Exception e1){
							JOptionPane.showMessageDialog(null, "Date Not Valid Or Date Area Is Not Filled", "Date Error!", JOptionPane.INFORMATION_MESSAGE);
							return;
						}
						
						String PWD = DBM.checkIfExists(tf9.getText(), tf10.getText(), tf11.getText(), s);
						
						if(PWD != null){
							
							lb30.setText(PWD);
							jsp1.setVisible(true);
							GUIData.printing = false;
							GUIData.tries = 5;
							DBM.resetTries();
							updateTextFields();
							
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Invalid Details Entered", "Forbidden Access!", JOptionPane.INFORMATION_MESSAGE);
							GUIData.tries = GUIData.tries - 1;
							
							
							if(GUIData.tries != 0){
								updateTextFields();
								DBM.updateTriesEntry();
							
							GUIData.t1 = new Thread(new ExtraMethods());
								
							if(!GUIData.printing){
								
							GUIData.printing = true;
							t1.start();
																					
							}
							}
							
							else {
								
								updateTextFields();
								DBM.updateTriesEntry();
								
								String date1 = null, date2 = null;
								
								try{
								date1 = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
								date2 = date1;
								
								SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
								Date myDate = format.parse(date2);
								Calendar cal = Calendar.getInstance();
						        cal.setTime(myDate);
						        cal.add(Calendar.DATE, 1);
						        date2 = format.format(cal.getTime());
								}
								catch(Exception exc){
									
									JOptionPane.showMessageDialog(null, "Error: "+exc.getMessage(), "The Program Has Encountered An Error!", JOptionPane.ERROR_MESSAGE);
								    JOptionPane.showMessageDialog(null, "Please Restart The Application & Make Sure MySQL Server Is Up And Running", "Program Will Now Close!", JOptionPane.INFORMATION_MESSAGE);
								    System.exit(0);
									
								}
								
								DBM.updateLockInfo(date1, date2);
								JOptionPane.showMessageDialog(null, "Application Is Locked Now! Please Contact System Admin Or Wait For 24 Hours To Gain Access", "Application Locked!", JOptionPane.INFORMATION_MESSAGE);
								System.exit(0);
								
							}
							
						}
						
					}
					else{
						
						JOptionPane.showMessageDialog(null, "Entry Field Are Empty Or Spaces Are Present!", "Empty Fields", JOptionPane.INFORMATION_MESSAGE);
						return;
						
					}
					
				}
				else if(e.getActionCommand().equals("LOGIN_SETTINGS")){
					
					if(!tf1.getText().isEmpty()){
						
						String s = new String(tf2.getPassword());
						
						if(!s.isEmpty()){
							
							boolean exists = DBM.checkEntry(tf1.getText(), s);		
							
							if(exists){
										
								
								GUIData.printing = false;
								GUIData.tries = 5;
								DBM.resetTries();
								updateTextFields();
								GUIData.Current_User = tf1.getText();
								GUIData.Current_User_Password = s;
								GUIData.Current_User_DBName = DBM.DefaultDBName(GUIData.Current_User);
								GUIData.Current_User_House = "**Admin**";
								//GUIData.Current_User_House = cb1.getSelectedItem().toString();
								cb6.removeAllItems();
								DBM.initiateTableData(GUIData.Current_User);
								for(int i = 0; i < DBMethods.al8.size(); i++){
									
									cb6.addItem(DBMethods.al8.get(i));
									
								}
								GUIData.Entries_Caught = DBMethods.al8.size();
								GUIData.Login_Type = 1;
								frame1.setVisible(false);
								showDatabaseSelectionForm();
								frame1.dispose();
								
							}
							else{
								
								JOptionPane.showMessageDialog(null, "Invalid Login Details Entered", "Forbidden Access!", JOptionPane.INFORMATION_MESSAGE);
								GUIData.tries = GUIData.tries - 1;
								
								if(GUIData.tries != 0){
									updateTextFields();
									DBM.updateTriesEntry();
								
								GUIData.t1 = new Thread(new ExtraMethods());
									
								if(!GUIData.printing){
									
								GUIData.printing = true;
								t1.start();
																						
								}
								}
								
								else {
									
									updateTextFields();
									DBM.updateTriesEntry();
									
									String date1 = null, date2 = null;
									
									try{
									date1 = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
									date2 = date1;
									
									SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
									Date myDate = format.parse(date2);
									Calendar cal = Calendar.getInstance();
							        cal.setTime(myDate);
							        cal.add(Calendar.DATE, 1);
							        date2 = format.format(cal.getTime());
									}
									catch(Exception exc){
										
										JOptionPane.showMessageDialog(null, "Error: "+exc.getMessage(), "The Program Has Encountered An Error!", JOptionPane.ERROR_MESSAGE);
									    JOptionPane.showMessageDialog(null, "Please Restart The Application & Make Sure MySQL Server Is Up And Running", "Program Will Now Close!", JOptionPane.INFORMATION_MESSAGE);
									    System.exit(0);
										
									}
									
									DBM.updateLockInfo(date1, date2, tf1.getText());
									JOptionPane.showMessageDialog(null, "Application Is Locked Now! Please Contact System Admin Or Wait For 24 Hours To Gain Access", "Application Locked!", JOptionPane.INFORMATION_MESSAGE);
									System.exit(0);
									
								}
								
								
							}
							
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Password Empty!", "Empty Fields", JOptionPane.INFORMATION_MESSAGE);
							return;
						}
						
					}else{
						JOptionPane.showMessageDialog(null, "Username Empty!", "Empty Fields", JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					
				}
				else if(e.getActionCommand().equals("LOGIN_VOTING")){
					if (cb2.getSelectedItem().toString().equals("Teacher")){
					if(!tf4.getText().isEmpty()){
						
						String s = new String(tf5.getPassword());
						
						if(!s.isEmpty()){
							
							boolean exists = DBM.checkEntry(tf4.getText(), s);		
							
							if(exists){
										
								GUIData.printing = false;
								GUIData.tries = 5;
								DBM.resetTries();
								updateTextFields();
								GUIData.Current_User = tf4.getText();
								GUIData.ENR_NO = "***ADMIN ENTRY***";
								GUIData.Current_User_House = cb5.getSelectedItem().toString();
								cb6.removeAllItems();
								DBM.initiateTableData(GUIData.Current_User);
								for(int i = 0; i < DBMethods.al8.size(); i++){
									
									cb6.addItem(DBMethods.al8.get(i));
									
								}
								GUIData.Entries_Caught = DBMethods.al8.size();
								GUIData.Login_Type = 2;
								frame1.setVisible(false);
								showDatabaseSelectionForm();
								frame1.dispose();
								
							}
							else{
								
								JOptionPane.showMessageDialog(null, "Invalid Login Details Entered", "Forbidden Access!", JOptionPane.INFORMATION_MESSAGE);
								GUIData.tries = GUIData.tries - 1;
								
								if(GUIData.tries != 0){
									updateTextFields();
									DBM.updateTriesEntry();
								
								GUIData.t1 = new Thread(new ExtraMethods());
									
								if(!GUIData.printing){
									
								GUIData.printing = true;
								t1.start();
																						
								}
								}
								
								else {
									
									updateTextFields();
									DBM.updateTriesEntry();
									
									String date1 = null, date2 = null;
									
									try{
									date1 = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
									date2 = date1;
									
									SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
									Date myDate = format.parse(date2);
									Calendar cal = Calendar.getInstance();
							        cal.setTime(myDate);
							        cal.add(Calendar.DATE, 1);
							        date2 = format.format(cal.getTime());
									}
									catch(Exception exc){
										
										JOptionPane.showMessageDialog(null, "Error: "+exc.getMessage(), "The Program Has Encountered An Error!", JOptionPane.ERROR_MESSAGE);
									    JOptionPane.showMessageDialog(null, "Please Restart The Application & Make Sure MySQL Server Is Up And Running", "Program Will Now Close!", JOptionPane.INFORMATION_MESSAGE);
									    System.exit(0);
										
									}
									
									DBM.updateLockInfo(date1, date2, tf4.getText());
									JOptionPane.showMessageDialog(null, "Application Is Locked Now! Please Contact System Admin Or Wait For 24 Hours To Gain Access", "Application Locked!", JOptionPane.INFORMATION_MESSAGE);
									System.exit(0);
									
								}
								
								
							}
							
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Password Empty!", "Empty Fields", JOptionPane.INFORMATION_MESSAGE);
							return;
						}
						
					}else{
						JOptionPane.showMessageDialog(null, "Username Empty!", "Empty Fields", JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					
				}
					else if(cb2.getSelectedItem().toString().equals("Student")){
						
						 try { 
						        Integer.parseInt(tf3.getText()); 
						    } catch(NumberFormatException nme) { 
						    	JOptionPane.showMessageDialog(null, "Enrollment Number Entered Is Not A Number!", "Bad Data Entry", JOptionPane.INFORMATION_MESSAGE);
						    	return; 
						    }
						
						GUIData.ENR_NO = tf3.getText();
						GUIData.Current_User = "Student";
						GUIData.Current_User_House = cb3.getSelectedItem().toString();
						cb6.removeAllItems();
						DBM.initiateTableData(cb4.getSelectedItem().toString());
						for(int i = 0; i < DBMethods.al8.size(); i++){
							
							cb6.addItem(DBMethods.al8.get(i));
							
						}
						GUIData.Entries_Caught = DBMethods.al8.size();
						GUIData.Login_Type = 3;
						frame1.setVisible(false);
						showDatabaseSelectionForm();
						frame1.dispose();
						
					}
				}
				else if(e.getActionCommand().equals("BACK_DATABASE_SELECTION")){
					
					frame4.setVisible(false);
					showLoginForm();
					frame4.dispose();
					
				}
				else if(e.getActionCommand().equals("CONNECT_DATABASE_SELECTION")){
					
					if(GUIData.Login_Type == 1){
						DBMethods.CONNECT_TABLE_NAME = "CANDIDATELIST_" + cb6.getSelectedItem().toString();
						frame4.setVisible(false);
						showDetailsArea();
						frame4.dispose();
					}
					else if(GUIData.Login_Type == 2){		
						DBMethods.CONNECT_TABLE_NAME = "CANDIDATELIST_" + cb6.getSelectedItem().toString();
						frame4.setVisible(false);
						showVotesArea();
						frame4.dispose();
					}
					else if(GUIData.Login_Type == 3){
						DBMethods.CONNECT_TABLE_NAME = "VOTERLIST_STUDENTS_" + cb6.getSelectedItem().toString();
						boolean exists = DBM.checkENRNo();
						if(exists){
							JOptionPane.showMessageDialog(null, "Enrollment Number Already Exists! Duplicate Entries Not Allowed!", "Duplicate Entries", JOptionPane.ERROR_MESSAGE);
							return;
						}
						DBMethods.CONNECT_TABLE_NAME = "CANDIDATELIST_" + cb6.getSelectedItem().toString();
						frame4.setVisible(false);
						showVotesArea();
						frame4.dispose();
					}
					
				}
				else if(e.getActionCommand().equals("LOGOUT_DATABASE")){
					
					cb6.removeAllItems();
					DBM.initiateTableData(GUIData.Current_User);
					for(int i = 0; i < DBMethods.al8.size(); i++){
						
						cb6.addItem(DBMethods.al8.get(i));
						
					}
					GUIData.Entries_Caught = DBMethods.al8.size();
					GUIData.Login_Type = 1;
					frame5.setVisible(false);
					showDatabaseSelectionForm();
					frame5.dispose();
					
				}
				else if(e.getActionCommand().equals("LOGOUT")){
					
					frame5.setVisible(false);
					showLoginForm();
					frame5.dispose();
					
				}
				else if(e.getActionCommand().equals("WATCH_SCREENS")){
					
					try {
						Runtime.getRuntime().exec("explorer " + init_Application.startupPath + "\\Data\\Screens\\");
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Error : " + e1.getMessage(), "Empty Fields", JOptionPane.INFORMATION_MESSAGE);
						return;						
					}
					
				}
				else if(e.getActionCommand().equals("DELETE_ACCOUNT")){
					
					int finalconf = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Delete The User Entry And All The Related Databases And Entries ?", "Final Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
					
					if(finalconf == JOptionPane.YES_OPTION){
					
						frame5.setVisible(false);
						DBM.initiateAccountDeletion();
						JOptionPane.showMessageDialog(null, "Account Name : " + GUIData.Current_User + " And All Its Related Databases Are Successfully Deleted", "Account Deletion Successful", JOptionPane.INFORMATION_MESSAGE);
						showLoginForm();
					}
					
				}
				else if(e.getActionCommand().equals("ADD_CRITERIA")){
					
					String s = JOptionPane.showInputDialog(null, "Enter Criteria : ", "Criteria Input", JOptionPane.PLAIN_MESSAGE);
					
					if(s != null && !s.isEmpty()){
					GUIData.cr.addElement(s);
					l1.setModel(cr);
					}
					
				}
				else if(e.getActionCommand().equals("ADD_NEW_CANDIDATE")){
					
					String s = JOptionPane.showInputDialog(null, "Enter Candidate Name : ", "Candidate Input", JOptionPane.PLAIN_MESSAGE);;
					
					if(s != null && !s.isEmpty()){
					GUIData.ca.addElement(s);
					l2.setModel(ca);
					}
					
				}
				else if(e.getActionCommand().equals("BROWSE")){
					
					JFileChooser jfc = new JFileChooser();
										
					jfc.setAcceptAllFileFilterUsed(false);
					
					FileFilter jpgFilter = new FileNameExtensionFilter("JPG/JPEG File", "jpg");
					FileFilter pngFilter = new FileNameExtensionFilter("PNG File", "png");
					FileFilter bmpFilter = new FileNameExtensionFilter("BMP File", "bmp"); 
					
					jfc.addChoosableFileFilter(jpgFilter);
					jfc.addChoosableFileFilter(pngFilter);
					jfc.addChoosableFileFilter(bmpFilter);
												
					if(jfc.showOpenDialog(new JFrame()) == JFileChooser.APPROVE_OPTION){
					File f = jfc.getSelectedFile();
					
					lb52.setIcon(new ImageIcon(getImageFromRes.getImage(f, 255, 295)));
					
					}
					else{
						
						lb52.setIcon(new ImageIcon(getImageFromRes.getImage("NA.jpg")));
						
					}
																				
				}
				else if(e.getActionCommand().equals("SAVE")){
					
					if(GUIData.IDSelected == -1){
					if(!tf12.getText().isEmpty() && !ta1.getText().isEmpty()){
												
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						Date selectedDate = ((Date) dpi3.getModel().getValue());
						String s = null;
						try{
						s = dateFormat.format(selectedDate);
						}
						catch(Exception e1){
							JOptionPane.showMessageDialog(null, "Date Not Valid Or Date Area Is Not Filled", "Date Error!", JOptionPane.INFORMATION_MESSAGE);
							return;
						}
						
						Date dummyDate = new Date();
						String dummyDateStr = dateFormat.format(dummyDate);
						
						if(selectedDate.compareTo(dummyDate)>0){
							JOptionPane.showMessageDialog(null, "Date Not Valid! Specified Date Is In The Future!", "Date Error!", JOptionPane.INFORMATION_MESSAGE);
							return;
			        	}else if(s.compareTo(dummyDateStr)==0){
			        		JOptionPane.showMessageDialog(null, "Date Not Valid! Specified Date Is Today!", "Date Error!", JOptionPane.INFORMATION_MESSAGE);
							return;
			        	}
						
						if (lb52.getIcon().getIconHeight() > 0){
						Icon ico = new ImageIcon();
						ico = lb52.getIcon();
						BufferedImage bi = new BufferedImage(ico.getIconWidth(), ico.getIconHeight(), BufferedImage.TYPE_INT_RGB);
						Graphics g = bi.createGraphics();
						ico.paintIcon(null, g, 0, 0);
						g.dispose();
						DBM.injectData(tf12.getText(), l1.getSelectedValue().toString(), cb7.getSelectedItem().toString(), s, ta1.getText(), bi);
						}
						else{
							
							lb52.setIcon(new ImageIcon(getImageFromRes.getImage("NA.jpg")));
							
							Icon ico = new ImageIcon();
							ico = lb52.getIcon();
							BufferedImage bi = new BufferedImage(ico.getIconWidth(), ico.getIconHeight(), BufferedImage.TYPE_INT_RGB);
							Graphics g = bi.createGraphics();
							ico.paintIcon(null, g, 0, 0);
							g.dispose();
							DBM.injectData(tf12.getText(), l1.getSelectedValue().toString(), cb7.getSelectedItem().toString(), s, ta1.getText(), bi);
						}
						DBM.loadEntries();
					}
					else{
						
						JOptionPane.showMessageDialog(null, "Field Are Empty!", "Invalid Input!", JOptionPane.INFORMATION_MESSAGE);
												
					}
					
					}
					else{
						
						if(!tf12.getText().isEmpty() && !ta1.getText().isEmpty()){
							
							SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
							Date selectedDate = ((Date) dpi3.getModel().getValue());
							String s = null;
							try{
							s = dateFormat.format(selectedDate);
							}
							catch(Exception e1){
								JOptionPane.showMessageDialog(null, "Date Not Valid Or Date Area Is Not Filled", "Date Error!", JOptionPane.INFORMATION_MESSAGE);
								return;
							}
							
							Date dummyDate = new Date();
							String dummyDateStr = dateFormat.format(dummyDate);
							
							if(selectedDate.compareTo(dummyDate)>0){
								JOptionPane.showMessageDialog(null, "Date Not Valid! Specified Date Is In The Future!", "Date Error!", JOptionPane.INFORMATION_MESSAGE);
								return;
				        	}else if(s.compareTo(dummyDateStr)==0){
				        		JOptionPane.showMessageDialog(null, "Date Not Valid! Specified Date Is Today!", "Date Error!", JOptionPane.INFORMATION_MESSAGE);
								return;
				        	}
							
							if (lb52.getIcon().getIconHeight() > 0){
							Icon ico = new ImageIcon();
							ico = lb52.getIcon();
							BufferedImage bi = new BufferedImage(ico.getIconWidth(), ico.getIconHeight(), BufferedImage.TYPE_INT_RGB);
							Graphics g = bi.createGraphics();
							ico.paintIcon(null, g, 0, 0);
							g.dispose();
							DBM.updateData(tf12.getText(), l1.getSelectedValue().toString(), cb7.getSelectedItem().toString(), s, ta1.getText(), bi);
							}
							else{
								
								lb52.setIcon(new ImageIcon(getImageFromRes.getImage("NA.jpg")));
								
								Icon ico = new ImageIcon();
								ico = lb52.getIcon();
								BufferedImage bi = new BufferedImage(ico.getIconWidth(), ico.getIconHeight(), BufferedImage.TYPE_INT_RGB);
								Graphics g = bi.createGraphics();
								ico.paintIcon(null, g, 0, 0);
								g.dispose();
								DBM.updateData(tf12.getText(), l1.getSelectedValue().toString(), cb7.getSelectedItem().toString(), s, ta1.getText(), bi);
							}
							DBM.loadEntries();
						}
						else{
							
							JOptionPane.showMessageDialog(null, "Field Are Empty!", "Invalid Input!", JOptionPane.INFORMATION_MESSAGE);
													
						}
						
					}
				}
				else if(e.getActionCommand().equals("DELETE")){
					
					DBM.initiateDelete(GUIData.IDSelected);
					DBM.loadEntries();
					
				}
				
				else if(e.getActionCommand().equals("DELETE_CRITERIA")){
										
					DBM.deleteCriteria(l1.getSelectedValue().toString());
					DBM.loadEntries();
					
				}
				
				else if(e.getActionCommand().equals("DELETE_DATABASE")){
				
					if(GUIData.Entries_Caught == 1){
						
						JOptionPane.showMessageDialog(null, "Only One Database Registered With This Account!\nPlease Delete The Account To Delete The Last Database Or Create A New Database To Delete The Existing One!", "Current Database Under Use!", JOptionPane.INFORMATION_MESSAGE);
						
					}
					else if(GUIData.Entries_Caught > 1){
						
						JComboBox<String> dblist = new JComboBox<String>();
						DBM.reLoadDatabases();						
						
						String s = DBMethods.CONNECT_TABLE_NAME.replace("CANDIDATELIST_", "");
						
						for(int i = 0; i<DBMethods.al18.size(); i++){
							
							if(!(s.equals(DBMethods.al18.get(i)))){
							dblist.addItem(DBMethods.al18.get(i));
							}
							
						}
						
						Object[] combo = {
								"Select Database To Delete : ", dblist
			 						};
						
						int finalconf1 = JOptionPane.showConfirmDialog(null, combo, "Change Password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
						
						if(finalconf1 == JOptionPane.OK_OPTION){
							
						if(!(dblist.getSelectedItem().toString().equals(GUIData.Current_User_DBName))){
						DBM.deleteDatabase(dblist.getSelectedItem().toString());
						lb50.setText("" + (--GUIData.Entries_Caught));
						JOptionPane.showMessageDialog(null, "Database Successfully Deleted!", "Deletion Successful", JOptionPane.INFORMATION_MESSAGE);
						}
						else{
							int finalconf2 = JOptionPane.showConfirmDialog(null, "This Database Is Your Default Database And Cannot Be Deleted Without Deleting Your Account\nAre You Sure You Want To Reset The Database(Reset Removes All Data)?","Reset Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
							if(finalconf2 == JOptionPane.YES_OPTION){
							DBM.resetDatabase(dblist.getSelectedItem().toString());
							JOptionPane.showMessageDialog(null, "Database Successfully Reset!", "Reset Successful", JOptionPane.INFORMATION_MESSAGE);
							}
						}
						}					
					}				
				}
				
				else if(e.getActionCommand().equals("CHANGE_PWD")){
					
					JPasswordField pwd1 = new JPasswordField();
					JPasswordField pwd2 = new JPasswordField();
					JPasswordField pwd3 = new JPasswordField();
					
					Object[] pwdFields = {
							"Enter Current Password : ", pwd1,
							"Enter New Password : ", pwd2,
							"Re-Enter New Password : ", pwd3
					};
					
					int finalconf = JOptionPane.showConfirmDialog(null, pwdFields, "Change Password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
					String s1 = new String(pwd1.getPassword());
					String s2 = new String(pwd2.getPassword());
					String s3 = new String(pwd3.getPassword());
					
					if(finalconf == JOptionPane.OK_OPTION){
					if(!s1.isEmpty() && !s2.isEmpty() && !s3.isEmpty()){
					if (s1.equals(GUIData.Current_User_Password)){
					if(s2.equals(s3)){
							
						DBM.changePWD(s2);
						JOptionPane.showMessageDialog(null, "Password Successfully Changed!", "Change Successful", JOptionPane.INFORMATION_MESSAGE);
						
						}
						else
						{							
							JOptionPane.showMessageDialog(null, "New Passwords Do Not Match!", "Incorrect Input", JOptionPane.INFORMATION_MESSAGE);													
						}
						
					}
					else{						
						JOptionPane.showMessageDialog(null, "Incorrect Old Password Entered!", "Input Mismatch", JOptionPane.INFORMATION_MESSAGE);						
					}
					
					}
					else {						
						JOptionPane.showMessageDialog(null, "Fields Are Empty!", "Empty Input", JOptionPane.INFORMATION_MESSAGE);						
					}
					}
				}
				else if(e.getActionCommand().equals("ADD_NEW_DATABASE")){
					
					final JTextField dbtf = new JTextField();
					final JLabel dblb1 = new JLabel("Availability Status : ");
					final JLabel dblb2 = new JLabel("Empty!");
					final JPanel dbp = new JPanel();
					
					dbp.setLayout(new GridLayout(1,1));
					dbp.add(dblb1);
					dbp.add(dblb2);
					
					dbtf.addKeyListener(new KeyListener(){

						
						public void keyPressed(KeyEvent arg0) {
							
							
						}

						
						public void keyReleased(KeyEvent arg0) {
							
							String s = dbtf.getText();
							s = s.trim();
							s = s.toLowerCase();
							
						if(!s.equals("")){
							int exists = DBM.checkDBEntry(s);
								
								if(exists == 1){
								
								dblb2.setText("Available!");
								
								}
								else if(exists == -1){
								
								dblb2.setText("Already Taken!");
								
								}					
							
						}
						else{
							
							dblb2.setText("Empty!");
							
						}
													
						}
						
						public void keyTyped(KeyEvent arg0) {
							
							
						}
						
						
						
					});
					
					Object[] newDatabaseCreationFields = {
							"Enter Database Name : ", dbtf,
							dbp
					};
					
					int finalconf = JOptionPane.showConfirmDialog(null, newDatabaseCreationFields, "Add New Database", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
					
					if(finalconf == JOptionPane.OK_OPTION){
						
						if(dblb2.getText().equals("Available!")){
						DBM.addDatabaseEntry(GUIData.Current_User, dbtf.getText());
						lb50.setText("" + (++GUIData.Entries_Caught));
						JOptionPane.showMessageDialog(null, "Database Successfully Added!", "Addition Successful", JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Database Name Is Empty Or Already Taken!", "Error Adding Database", JOptionPane.INFORMATION_MESSAGE);
						}
					}
					
				}
				else if(e.getActionCommand().equals("VOTES_COUNT_PAGE")){
										
					if(!GUIData.VOTES_PAGE_OPEN){
						GUIData.VOTES_PAGE_OPEN = true;
						showVotesCountPage();
					}
					else{
						
						JOptionPane.showMessageDialog(null, "Votes Count Window Already Open!", "Duplicate Windows", JOptionPane.INFORMATION_MESSAGE);
						
					}
					
				}
				else if(e.getActionCommand().equals("RELOAD_VOTES_COUNT")){
					DBM.populateVoterCountBox();
				}
				else if(e.getActionCommand().equals("CONNECT_VOTES_COUNT")){
					l3.setEnabled(true);
					l4.setEnabled(true);
					b26.setEnabled(false);
					b28.setEnabled(false);
					b27.setEnabled(true);
					GUIData.cb8.setEnabled(false);
					DBMethods.CONNECT_TABLE_NAME_VOTESCOUNT = "CANDIDATELIST_" + GUIData.cb8.getSelectedItem().toString();
					DBM.Connect_VoterCount();
				}
				else if(e.getActionCommand().equals("DISCONNECT_VOTES_COUNT")){
					l4.setModel(new DefaultListModel<String>());
					l3.setModel(new DefaultListModel<String>());
					lb63.setIcon(new ImageIcon());
					ta2.setText("");
					tf13.setText("");
					tf14.setText("");
					tf15.setText("");
					tf16.setText("");
					l3.setEnabled(false);
					l4.setEnabled(false);
					b26.setEnabled(true);
					b28.setEnabled(true);
					b27.setEnabled(false);
					GUIData.cb8.setEnabled(true);
					DBMethods.CONNECT_TABLE_NAME_VOTESCOUNT = null;
				}
				else if(e.getActionCommand().equals("VOTE")){
					
					int confirm = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To VOTE For This Person?", "Final Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
					
					if(confirm == JOptionPane.YES_OPTION){
						
						GUIData.VotedIDList.add(GUIData.IDSelected_VoterList);
						GUIData.vcr.remove(GUIData.l5.getSelectedIndex());
						GUIData.l5.setModel(vcr);
						
						if(vcr.getSize() == 0){
							DBM.addVotes();
							if(GUIData.Login_Type == 2){
							String s = DBMethods.CONNECT_TABLE_NAME;
							String replaced = s.replace("CANDIDATELIST_", "");
							DBMethods.CONNECT_TABLE_NAME = "VOTERLIST_TEACHERS_" + replaced;
							DBM.addVoterEntry(GUIData.Current_User_House);
							DBMethods.CONNECT_TABLE_NAME = s;
							}
							else if(GUIData.Login_Type == 3){
							String s = DBMethods.CONNECT_TABLE_NAME;
							String replaced = s.replace("CANDIDATELIST_", "");
							DBMethods.CONNECT_TABLE_NAME = "VOTERLIST_STUDENTS_" + replaced;
							DBM.addVoterEntry(GUIData.Current_User_House, GUIData.ENR_NO);
							DBMethods.CONNECT_TABLE_NAME = s;
							}
							frame7.dispose();
							showLoginForm();
							frame7.setVisible(false);							
						}
						
					}
					
				}
												
				}
				
			}
	
	public void showVotesArea(){
		
		GUIData.VotedIDList.clear();
		
		Listen_Action la = new Listen_Action();
		
		boolean b = DBM.initializeVotesArea(DBMethods.CONNECT_TABLE_NAME);
		
		if(!b){
			
			JOptionPane.showMessageDialog(null, "No Candidate Present In Database At The Moment, Please Try Again Later.", "Redirecting To Login Page!", JOptionPane.INFORMATION_MESSAGE);
			showLoginForm();
			return;
		}
		
		this.frame7 = new JFrame();
		this.frame7.setTitle("Voting Page");
		this.frame7.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);// TO BE CHANGED TO DO_NOTHING_ON_CLOSE
		this.frame7.setLayout(null);
		this.frame7.getContentPane().setBackground(Color.BLACK);
		this.frame7.setIconImage(getImageFromRes.getImage("icon.png"));
		
		this.b29 = new JButton("Vote!");
		this.b29.setActionCommand("VOTE");
		this.b29.addActionListener(la);
		this.b29.setBackground(Color.BLACK);
		this.b29.setForeground(Color.WHITE);
		this.b29.setEnabled(false);
		
		this.jsp8 = new JScrollPane();
		this.jsp9 = new JScrollPane();
		this.jsp10 = new JScrollPane();
		
		//GUIData.l5 = new JList<String>();
		GUIData.l5.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		GUIData.l5.setBackground(Color.BLACK);
		GUIData.l5.setForeground(Color.WHITE);
		
		GUIData.l5.addListSelectionListener(new ListSelectionListener(){

			public void valueChanged(ListSelectionEvent le1) {
				
				GUIData.IDSelected_VoterList = -1;
				l6.clearSelection();
				l6.setModel(new DefaultListModel<String>());
				lb73.setIcon(new ImageIcon());
				ta3.setText("");
				tf17.setText("");
				tf18.setText("");
				tf19.setText("");
				b29.setEnabled(false);
								
				GUIData.vca.clear();
				l6.setModel(GUIData.vca);
				if(l5.getSelectedIndex() != -1){
				for(int i = 0; i<DBMethods.al34.size(); i++){
					if (l5.getSelectedValue().toString().equals(DBMethods.al34.get(i))){
						GUIData.vca.addElement(DBMethods.al29.get(i));
					}
				}				
				l6.setModel(GUIData.vca);
			}				

				
			}	
			
		});
		
		//GUIData.l6 = new JList<String>();
		GUIData.l6.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		GUIData.l6.setBackground(Color.BLACK);
		GUIData.l6.setForeground(Color.WHITE);
		
		GUIData.l6.addListSelectionListener(new ListSelectionListener(){

			public void valueChanged(ListSelectionEvent le2) {
				
				GUIData.IDSelected_VoterList = -1;
				DBMethods.position_Voter = -1;
				DBMethods.item_Voter = -1;						
				
				if(l6.getSelectedIndex() != -1){
									
					lb73.setIcon(new ImageIcon());
					ta3.setText("");
					tf17.setText("");
					tf18.setText("");
					tf19.setText("");
												
					DBMethods.positions_Voter.clear();
					DBMethods.IDpos_Voter.clear();
					DBMethods.position_Voter = l6.getSelectedIndex();
					for(int i = 0; i<l6.getModel().getSize(); i++){
						if (l6.getSelectedValue().toString().equals(l6.getModel().getElementAt(i))){
							
							DBMethods.positions_Voter.add(i);
													
						}
					}
					
					for(int i = 0; i<DBMethods.al34.size(); i++){
						if (l6.getSelectedValue().toString().equals(DBMethods.al29.get(i)) && l5.getSelectedValue().toString().equals(DBMethods.al34.get(i))){
							
							DBMethods.IDpos_Voter.add(i);
							
						}}			
					
					for(int i = 0; i<DBMethods.al34.size(); i++){
						if (l6.getSelectedValue().toString().equals(DBMethods.al29.get(i)) && l5.getSelectedValue().toString().equals(DBMethods.al34.get(i))){
							
							for(int j=0; j<DBMethods.positions_Voter.size(); j++){
								
								if(DBMethods.positions_Voter.get(j) == DBMethods.position_Voter){
									DBMethods.item_Voter = j;
								}
								
							}
							
							if(!(DBMethods.item_Voter>=DBMethods.IDpos_Voter.size())){		
				
							tf17.setText(DBMethods.al29.get(DBMethods.IDpos_Voter.get(DBMethods.item_Voter)));
							ta3.setText(DBMethods.al30.get(DBMethods.IDpos_Voter.get(DBMethods.item_Voter)));
							tf19.setText(DBMethods.al31.get(DBMethods.IDpos_Voter.get(DBMethods.item_Voter)));
							tf18.setText(DBMethods.al32.get(DBMethods.IDpos_Voter.get(DBMethods.item_Voter)));
							GUIData.IDSelected_VoterList = Integer.parseInt(DBMethods.al28.get(DBMethods.IDpos_Voter.get(DBMethods.item_Voter)));
							
							String location = DBMethods.CONNECT_TABLE_NAME.replace("CANDIDATELIST_", "");
							
							File f = new File(init_Application.startupPath + "\\Data\\" + location +"\\"+location+"_ImageData\\" + DBMethods.al28.get(DBMethods.IDpos_Voter.get(DBMethods.item_Voter)) + ".jpg");
							if (f.isFile() && f.canRead()) {
							
								lb73.setIcon(new ImageIcon(getImageFromRes.getImage(f, 255, 295)));
								
							}
							b29.setEnabled(true);
						}
						}
					}
					
					}
				else{
					lb73.setIcon(new ImageIcon());
					ta3.setText("");
					tf17.setText("");
					tf18.setText("");
					tf19.setText("");
					b29.setEnabled(false);
				
				}
			}
			
			
		});
		
		this.ta3 = new JTextArea();
		this.ta3.setEnabled(false);
		this.ta3.setDisabledTextColor(Color.BLACK);
		
		this.jsp8.setViewportView(ta3);
		this.jsp9.setViewportView(l5);
		this.jsp10.setViewportView(l6);
		
		this.tf17 = new JTextField();
		this.tf17.setEnabled(false);
		this.tf17.setDisabledTextColor(Color.BLACK);
		
		this.tf18 = new JTextField();
		this.tf18.setEnabled(false);
		this.tf18.setDisabledTextColor(Color.BLACK);
		
		this.tf19 = new JTextField();
		this.tf19.setEnabled(false);
		this.tf19.setDisabledTextColor(Color.BLACK);
		
		this.lb67 = new JLabel("Criteria :");
		this.lb67.setForeground(Color.WHITE);
		this.lb68 = new JLabel("Candidate :");
		this.lb68.setForeground(Color.WHITE);
		this.lb69 = new JLabel("Name : ");
		this.lb69.setForeground(Color.WHITE);
		this.lb70 = new JLabel("Date Of Birth : ");
		this.lb70.setForeground(Color.WHITE);
		this.lb71 = new JLabel("House : ");
		this.lb71.setForeground(Color.WHITE); 
		this.lb72 = new JLabel("About Me : ");
		this.lb72.setForeground(Color.WHITE);
		this.lb73 = new JLabel();
		this.lb73.setIcon(new ImageIcon());
		this.lb74 = new JLabel("Enrollment Number : ");
		this.lb74.setForeground(Color.WHITE);
		this.lb75 = new JLabel("House : ");
		this.lb75.setForeground(Color.WHITE);
		this.lb76 = new JLabel("" + GUIData.Current_User_House);
		this.lb76.setForeground(Color.WHITE);
		this.lb77 = new JLabel("" + GUIData.ENR_NO);
		this.lb77.setForeground(Color.WHITE);
		this.lb78 = new JLabel("---------------------------------------------Candidate Bio---------------------------------------------");
		this.lb78.setForeground(Color.WHITE);
		
		
		this.lb67.setBounds(10, 5, 50, 13);
		this.frame7.add(lb67);
		
		this.lb68.setBounds(195, 5, 65, 13);
		this.frame7.add(lb68);
		
		this.jsp9.setBounds(10, 20, 150, 500);
		this.frame7.add(jsp9);
		
		this.jsp10.setBounds(195, 20, 150, 500);
		this.frame7.add(jsp10);
		
		this.lb78.setBounds(360, 5, 500, 13);
		this.frame7.add(lb78);
		
		this.lb73.setBounds(440, 25, 295, 255);
		this.frame7.add(lb73);
		
		this.lb69.setBounds(438, 295, 50, 13);
		this.frame7.add(lb69);
		
		this.tf17.setBounds(485, 292, 247, 20);
		this.frame7.add(tf17);
		
		this.lb70.setBounds(438, 325, 100, 13);
		this.frame7.add(lb70);
		
		this.tf18.setBounds(525, 322, 207, 20);
		this.frame7.add(tf18);
		
		this.lb71.setBounds(438, 355, 50, 13);
		this.frame7.add(lb71);
		
		this.tf19.setBounds(488, 352, 244, 20);
		this.frame7.add(tf19);
		
		this.lb72.setBounds(438, 385, 100, 13);
		this.frame7.add(lb72);
		
		this.jsp8.setBounds(525, 385, 207, 40);
		this.frame7.add(jsp8);
		
		this.lb74.setBounds(10, 540, 200, 13);
		this.frame7.add(lb74);
		
		this.lb75.setBounds(650, 540, 200 ,13);
		this.frame7.add(lb75);
		
		this.lb77.setBounds(140, 540, 400, 13);
		this.frame7.add(lb77);
		
		this.lb76.setBounds(705, 540, 200, 13);
		this.frame7.add(lb76);
		
		this.b29.setBounds(438, 468, 294, 50);
		this.frame7.add(b29);
		
		this.frame7.setSize(825, 585);
		this.frame7.setResizable(false);
		this.frame7.setVisible(true);
		
	}
	
	public void showVotesCountPage(){
		
		Listen_Action la = new Listen_Action();
		
		DBM.populateVoterCountBox();
		
		this.frame6 = new JFrame();
		
		this.frame6.addWindowListener(new WindowListener(){

			public void windowActivated(WindowEvent arg0) {
								
			}

			public void windowClosed(WindowEvent arg0) {
								
			}

			public void windowClosing(WindowEvent we) {
					
				GUIData.VOTES_PAGE_OPEN = false;
				
			}

			public void windowDeactivated(WindowEvent we) {
								
			}

			public void windowDeiconified(WindowEvent we) {
								
			}

			public void windowIconified(WindowEvent we) {
								
			}

			public void windowOpened(WindowEvent we) {
								
			}
			
		});
		
		this.frame6.setTitle("Votes Count Page");
		this.frame6.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.frame6.setLayout(null);
		this.frame6.getContentPane().setBackground(Color.BLACK);
		this.frame6.setIconImage(getImageFromRes.getImage("icon.png"));
		
		this.tf13 = new JTextField();
		this.tf13.setEnabled(false);
		this.tf13.setDisabledTextColor(Color.BLACK);
		this.tf14 = new JTextField();
		this.tf14.setEnabled(false);
		this.tf14.setDisabledTextColor(Color.BLACK);
		this.tf15 = new JTextField();
		this.tf15.setEnabled(false);
		this.tf15.setDisabledTextColor(Color.BLACK);
		this.tf16 = new JTextField();
		this.tf16.setEnabled(false);
		this.tf16.setDisabledTextColor(Color.BLACK);
		
		this.b26 = new JButton("Connect");
		this.b26.setActionCommand("CONNECT_VOTES_COUNT");
		this.b26.addActionListener(la);
		this.b26.setBackground(Color.BLACK);
		this.b26.setForeground(Color.WHITE);
		
		this.b27 = new JButton("Disconnect");
		this.b27.setActionCommand("DISCONNECT_VOTES_COUNT");
		this.b27.addActionListener(la);
		this.b27.setEnabled(false);
		this.b27.setBackground(Color.BLACK);
		this.b27.setForeground(Color.WHITE);
		
		this.b28 = new JButton("Reload Databases");
		this.b28.setActionCommand("RELOAD_VOTES_COUNT");
		this.b28.addActionListener(la);
		this.b28.setBackground(Color.BLACK);
		this.b28.setForeground(Color.WHITE);
		
		this.jsp5 = new JScrollPane();
		this.jsp6 = new JScrollPane();
		this.jsp7 = new JScrollPane();
		
		this.ta2 = new JTextArea();
		this.ta2.setEnabled(false);
		this.ta2.setDisabledTextColor(Color.BLACK);
		
		GUIData.l3 = new JList<String>();
		GUIData.l3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		GUIData.l3.setEnabled(false);
		GUIData.l4 = new JList<String>();
		GUIData.l4.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		GUIData.l4.setEnabled(false);
				
		this.jsp5.setBackground(Color.BLACK);
		this.jsp6.setBackground(Color.BLACK);
		this.jsp7.setBackground(Color.BLACK);
		this.jsp5.setForeground(Color.WHITE);
		this.jsp6.setForeground(Color.WHITE);
		this.jsp7.setForeground(Color.WHITE);
				
		GUIData.l3.setBackground(Color.BLACK);
		GUIData.l4.setBackground(Color.BLACK);
		GUIData.l3.setForeground(Color.WHITE);
		GUIData.l4.setForeground(Color.WHITE);
		
		GUIData.l3.addListSelectionListener(new ListSelectionListener(){
			
			public void valueChanged(ListSelectionEvent lse) {
				
				GUIData.IDSelected_VoterListCount = -1;
				l4.clearSelection();
				l4.setModel(new DefaultListModel<String>());
				lb63.setIcon(new ImageIcon());
				ta2.setText("");
				tf13.setText("");
				tf14.setText("");
				tf15.setText("");
				tf16.setText("");
				
				GUIData.vcca.clear();
				l4.setModel(GUIData.vcca);
				if(l3.getSelectedIndex() != -1){
				for(int i = 0; i<DBMethods.al26.size(); i++){
					if (l3.getSelectedValue().toString().equals(DBMethods.al26.get(i))){
						GUIData.vcca.addElement(DBMethods.al21.get(i));
					}
				}				
				l4.setModel(GUIData.vcca);
			}				
			}			
			
		});
		
		GUIData.l4.addListSelectionListener(new ListSelectionListener(){

			
			public void valueChanged(ListSelectionEvent lse) {
				
				GUIData.IDSelected_VoterListCount = -1;
				DBMethods.position_VoterCount = -1;
				DBMethods.item_VoterCount = -1;						
				
				if(l4.getSelectedIndex() != -1){
									
					lb63.setIcon(new ImageIcon());
					ta2.setText("");
					tf13.setText("");
					tf14.setText("");
					tf15.setText("");
					tf16.setText("");
							
					DBMethods.positions_VoterCount.clear();
					DBMethods.IDpos_VoterCount.clear();
					DBMethods.position_VoterCount = l4.getSelectedIndex();
					for(int i = 0; i<l4.getModel().getSize(); i++){
						if (l4.getSelectedValue().toString().equals(l4.getModel().getElementAt(i))){
							
							DBMethods.positions_VoterCount.add(i);
													
						}
					}
					
					for(int i = 0; i<DBMethods.al26.size(); i++){
						if (l4.getSelectedValue().toString().equals(DBMethods.al21.get(i)) && l3.getSelectedValue().toString().equals(DBMethods.al26.get(i))){
							
							DBMethods.IDpos_VoterCount.add(i);
							
						}}			
					
					for(int i = 0; i<DBMethods.al26.size(); i++){
						if (l4.getSelectedValue().toString().equals(DBMethods.al21.get(i)) && l3.getSelectedValue().toString().equals(DBMethods.al26.get(i))){
							
							for(int j=0; j<DBMethods.positions_VoterCount.size(); j++){
								
								if(DBMethods.positions_VoterCount.get(j) == DBMethods.position_VoterCount){
									DBMethods.item_VoterCount = j;
								}
								
							}
							
							if(!(DBMethods.item_VoterCount>=DBMethods.IDpos_VoterCount.size())){		
				
							tf13.setText(DBMethods.al21.get(DBMethods.IDpos_VoterCount.get(DBMethods.item_VoterCount)));
							ta2.setText(DBMethods.al22.get(DBMethods.IDpos_VoterCount.get(DBMethods.item_VoterCount)));
							tf14.setText(DBMethods.al24.get(DBMethods.IDpos_VoterCount.get(DBMethods.item_VoterCount)));
							tf16.setText(DBMethods.al25.get(DBMethods.IDpos_VoterCount.get(DBMethods.item_VoterCount)));
							tf15.setText(DBMethods.al23.get(DBMethods.IDpos_VoterCount.get(DBMethods.item_VoterCount)));
							GUIData.IDSelected_VoterListCount = Integer.parseInt(DBMethods.al20.get(DBMethods.IDpos_VoterCount.get(DBMethods.item_VoterCount)));
							
							String location = DBMethods.CONNECT_TABLE_NAME.replace("CANDIDATELIST_", "");
							
							File f = new File(init_Application.startupPath + "\\Data\\" + GUIData.Current_User +"\\"+location+"_ImageData\\" + DBMethods.al20.get(DBMethods.IDpos_VoterCount.get(DBMethods.item_VoterCount)) + ".jpg");
							if (f.isFile() && f.canRead()) {
							
								lb63.setIcon(new ImageIcon(getImageFromRes.getImage(f, 255, 295)));
								
							}
						}
						}
					}
					
					}
				else{
					lb63.setIcon(new ImageIcon());
					ta2.setText("");
					tf13.setText("");
					tf14.setText("");
					tf15.setText("");
					tf16.setText("");
				
				}
			}
					
		});
		
		this.jsp5.setViewportView(l3);
		this.jsp6.setViewportView(l4);
		this.jsp7.setViewportView(ta2);
	
		this.lb53 = new JLabel("Criteria : ");
		this.lb53.setForeground(Color.WHITE);
		this.lb54 = new JLabel("Candidate : ");
		this.lb54.setForeground(Color.WHITE);
		this.lb55 = new JLabel("Name : ");
		this.lb55.setForeground(Color.WHITE);
		this.lb57 = new JLabel("Date Of Birth : ");
		this.lb57.setForeground(Color.WHITE);
		this.lb59 = new JLabel("House : ");
		this.lb59.setForeground(Color.WHITE);
		this.lb61 = new JLabel("About Me : ");
		this.lb61.setForeground(Color.WHITE);
		this.lb62 = new JLabel("---------------------------------------------Candidate Bio---------------------------------------------");
		this.lb62.setForeground(Color.WHITE);
		this.lb63 = new JLabel();
		this.lb63.setIcon(new ImageIcon());
		this.lb64 = new JLabel("Votes : ");
		this.lb64.setForeground(Color.WHITE);
		this.lb66 = new JLabel("Select Database : ");
		this.lb66.setForeground(Color.WHITE);
		
		GUIData.cb8.setBackground(Color.BLACK);
		GUIData.cb8.setForeground(Color.WHITE);
		
		this.lb66.setBounds(5, 5, 150, 20);
		this.frame6.add(lb66);
		
		GUIData.cb8.setBounds(5, 25, 500, 20);
		this.frame6.add(cb8);
		
		this.b26.setBounds(510, 25, 150, 20);
		this.frame6.add(b26);
		
		this.b27.setBounds(665, 25, 150, 20);
		this.frame6.add(b27);
		
		this.b28.setBounds(510, 5, 305, 20);
		this.frame6.add(b28);
		
		this.lb53.setBounds(5, 75, 60, 13);
		this.frame6.add(lb53);
		
		this.lb54.setBounds(170, 75, 80, 13);
		this.frame6.add(lb54);
		
		this.jsp5.setBounds(5, 90, 150, 400);
		this.frame6.add(jsp5);
		
		this.jsp6.setBounds(170, 90, 150, 400);
		this.frame6.add(jsp6);
		
		this.lb62.setBounds(360, 50, 500, 13);
		this.frame6.add(lb62);
		
		this.lb63.setBounds(440, 80, 295, 255);
		this.frame6.add(lb63);
		
		this.lb55.setBounds(438, 350, 50, 13);
		this.frame6.add(lb55);
		
		this.tf13.setBounds(485, 347, 247, 20);
		this.frame6.add(tf13);
		
		this.lb57.setBounds(438, 380, 100, 13);
		this.frame6.add(lb57);
		
		this.tf14.setBounds(525, 377, 207, 20);
		this.frame6.add(tf14);
		
		this.lb59.setBounds(438, 410, 50, 13);
		this.frame6.add(lb59);
		
		this.lb61.setBounds(438, 440, 100, 13);
		this.frame6.add(lb61);
		
		this.jsp7.setBounds(525, 440, 207, 40);
		this.frame6.add(jsp7);
		
		this.tf15.setBounds(488, 407, 244, 20);
		this.frame6.add(tf15);
		
		this.lb64.setBounds(438, 490, 50, 13);
		this.frame6.add(lb64);
		
		this.tf16.setBounds(488, 487, 244, 20);
		this.frame6.add(tf16);
		
		this.frame6.setSize(825, 550);
		this.frame6.setResizable(false);
		this.frame6.setVisible(true);	
		
	}
	
	public void showDetailsArea(){
		
		Listen_Action la = new Listen_Action();
		
		DBM.loadEntries();
		
		this.frame5 = new JFrame();
		this.frame5.setTitle("Details Area");
		this.frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame5.setLayout(null);
		this.frame5.getContentPane().setBackground(Color.BLACK);
		this.frame5.setIconImage(getImageFromRes.getImage("icon.png"));
		
		this.b12 = new JButton("Logout Of Database");
		this.b12.setActionCommand("LOGOUT_DATABASE");
		this.b12.addActionListener(la);
		this.b12.setBackground(Color.BLACK);
		this.b12.setForeground(Color.WHITE);
		
		this.b13 = new JButton("Logout");
		this.b13.setActionCommand("LOGOUT");
		this.b13.addActionListener(la);
		this.b13.setBackground(Color.BLACK);
		this.b13.setForeground(Color.WHITE);
		
		this.b14 = new JButton("Add New Criteria");
		this.b14.setActionCommand("ADD_CRITERIA");
		this.b14.addActionListener(la);
		this.b14.setBackground(Color.BLACK);
		this.b14.setForeground(Color.WHITE);
		
		this.b15 = new JButton("Add New Candidate");
		this.b15.setActionCommand("ADD_NEW_CANDIDATE");
		this.b15.addActionListener(la);
		this.b15.setBackground(Color.BLACK);
		this.b15.setForeground(Color.WHITE);
		
		this.b16 = new JButton("Delete Criteria");
		this.b16.setActionCommand("DELETE_CRITERIA");
		this.b16.addActionListener(la);
		this.b16.setBackground(Color.BLACK);
		this.b16.setForeground(Color.WHITE);
		
		this.b17 = new JButton("Browse");
		this.b17.setActionCommand("BROWSE");
		this.b17.addActionListener(la);
		this.b17.setBackground(Color.BLACK);
		this.b17.setForeground(Color.WHITE);
		
		this.b18 = new JButton("Save");
		this.b18.setActionCommand("SAVE");
		this.b18.addActionListener(la);
		this.b18.setBackground(Color.BLACK);
		this.b18.setForeground(Color.WHITE);
		
		this.b19 = new JButton("Delete");
		this.b19.setActionCommand("DELETE");
		this.b19.addActionListener(la);
		this.b19.setBackground(Color.BLACK);
		this.b19.setForeground(Color.WHITE);
		
		this.b20 = new JButton("Change Password");
		this.b20.setActionCommand("CHANGE_PWD");
		this.b20.addActionListener(la);
		this.b20.setBackground(Color.BLACK);
		this.b20.setForeground(Color.WHITE);
		
		this.b21 = new JButton("Votes Count Page");
		this.b21.setActionCommand("VOTES_COUNT_PAGE");
		this.b21.addActionListener(la);
		this.b21.setBackground(Color.BLACK);
		this.b21.setForeground(Color.WHITE);
		
		this.b22 = new JButton("Add New Database");
		this.b22.setActionCommand("ADD_NEW_DATABASE");
		this.b22.addActionListener(la);
		this.b22.setBackground(Color.BLACK);
		this.b22.setForeground(Color.WHITE);
		
		this.b23 = new JButton("Delete Database");
		this.b23.setActionCommand("DELETE_DATABASE");
		this.b23.addActionListener(la);
		this.b23.setBackground(Color.BLACK);
		this.b23.setForeground(Color.WHITE);
		
		this.b24 = new JButton("Watch Invalid Entry Screens");
		this.b24.setActionCommand("WATCH_SCREENS");
		this.b24.addActionListener(la);
		this.b24.setBackground(Color.BLACK);
		this.b24.setForeground(Color.WHITE);
		
		this.b25 = new JButton("Delete Account");
		this.b25.setActionCommand("DELETE_ACCOUNT");
		this.b25.addActionListener(la);
		this.b25.setBackground(Color.BLACK);
		this.b25.setForeground(Color.WHITE);
		
		this.jsp2 = new JScrollPane();
		this.jsp3 = new JScrollPane();
		this.jsp4 = new JScrollPane();
		
		//GUIData.l1 = new JList<String>();
		this.l2 = new JList<String>();
		
		GUIData.l1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.l2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		this.tf12 = new JTextField();
		
		this.ta1 = new JTextArea();
				
		this.cb7 = new JComboBox<String>();
		this.cb7.setBackground(Color.BLACK);
		this.cb7.setForeground(Color.WHITE);
		this.cb7.addItem("Ruby");
		this.cb7.addItem("Sapphire");
		this.cb7.addItem("Emerald");
		this.cb7.addItem("Topaz");
		
		this.model3 = new UtilDateModel();
		this.dp3 = new JDatePanelImpl(model3);
		this.dpi3 = new JDatePickerImpl(dp3);
		
		GUIData.l1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.l2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		this.jsp2.setBackground(Color.BLACK);
		this.jsp3.setBackground(Color.BLACK);
		this.jsp2.setForeground(Color.WHITE);
		this.jsp3.setForeground(Color.WHITE);
		
		GUIData.l1.setBackground(Color.BLACK);
		this.l2.setBackground(Color.BLACK);
		GUIData.l1.setForeground(Color.WHITE);
		this.l2.setForeground(Color.WHITE);
		
		this.jsp2.setViewportView(GUIData.l1);;
		this.jsp3.setViewportView(l2);
		this.jsp4.setViewportView(ta1);
		
		GUIData.l1.addListSelectionListener(new ListSelectionListener(){

			
			public void valueChanged(ListSelectionEvent lse) {
				
				GUIData.IDSelected = -1;
				l2.clearSelection();
				l2.setModel(new DefaultListModel<String>());
				lb52.setIcon(new ImageIcon());
				cb7.setEnabled(false);
				b17.setEnabled(false);
				b18.setEnabled(false);
				b19.setEnabled(false);
				dpi3.setState(false);
				model3.setSelected(false);
				tf12.setEnabled(false);
				ta1.setEnabled(false);
				ta1.setText("");
				tf12.setText("");
				
				GUIData.ca.clear();
				l2.setModel(GUIData.ca);
				if(l1.getSelectedIndex() != -1){
				for(int i = 0; i<DBMethods.al16.size(); i++){
					if (l1.getSelectedValue().toString().equals(DBMethods.al16.get(i))){
						GUIData.ca.addElement(DBMethods.al11.get(i));
					}
				}
				
				l2.setModel(GUIData.ca);
								
				b15.setEnabled(true);
				}
				else{
					dpi3.setState(false);
					}
			}
			
		});
		
	   this.l2.addListSelectionListener(new ListSelectionListener(){

			
			public void valueChanged(ListSelectionEvent lse) {
				
				GUIData.IDSelected = -1;
				DBMethods.position = -1;
				DBMethods.item = -1;						
				
				if(l2.getSelectedIndex() != -1){
					cb7.setEnabled(true);
					b17.setEnabled(true);
					b18.setEnabled(true);
					b19.setEnabled(true);
					dpi3.setState(true);
					tf12.setEnabled(true);
					ta1.setEnabled(true);
					dpi3.setState(true);
					model3.setSelected(false);
					
					lb52.setIcon(new ImageIcon());
					ta1.setText("");
					tf12.setText("");
							
					DBMethods.positions.clear();
					DBMethods.IDpos.clear();
					DBMethods.position = l2.getSelectedIndex();
					for(int i = 0; i<l2.getModel().getSize(); i++){
						if (l2.getSelectedValue().toString().equals(l2.getModel().getElementAt(i))){
							
							DBMethods.positions.add(i);
													
						}
					}
					
					for(int i = 0; i<DBMethods.al16.size(); i++){
						if (l2.getSelectedValue().toString().equals(DBMethods.al11.get(i)) && l1.getSelectedValue().toString().equals(DBMethods.al16.get(i))){
							
							DBMethods.IDpos.add(i);
							
						}}			
					
					for(int i = 0; i<DBMethods.al16.size(); i++){
						if (l2.getSelectedValue().toString().equals(DBMethods.al11.get(i)) && l1.getSelectedValue().toString().equals(DBMethods.al16.get(i))){
							
							for(int j=0; j<DBMethods.positions.size(); j++){
								
								if(DBMethods.positions.get(j) == DBMethods.position){
									DBMethods.item = j;
								}
								
							}
							
							if(!(DBMethods.item>=DBMethods.IDpos.size())){		
				
							tf12.setText(DBMethods.al11.get(DBMethods.IDpos.get(DBMethods.item)));
							ta1.setText(DBMethods.al12.get(DBMethods.IDpos.get(DBMethods.item)));
							cb7.setSelectedItem(DBMethods.al13.get(DBMethods.IDpos.get(DBMethods.item)));
							GUIData.IDSelected = Integer.parseInt(DBMethods.al10.get(DBMethods.IDpos.get(DBMethods.item)));
							
							
							SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
							Calendar c = Calendar.getInstance();
							
							try{
							c.setTime(formatter.parse(DBMethods.al14.get(DBMethods.IDpos.get(DBMethods.item))));
							model3.setDate(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
							model3.setSelected(true);							
							}
							catch(Exception e){
								
							}
							
							String location = DBMethods.CONNECT_TABLE_NAME.replace("CANDIDATELIST_", "");
							
							File f = new File(init_Application.startupPath + "\\Data\\" + GUIData.Current_User +"\\"+location+"_ImageData\\" + DBMethods.al10.get(DBMethods.IDpos.get(DBMethods.item)) + ".jpg");
							if (f.isFile() && f.canRead()) {
							
								lb52.setIcon(new ImageIcon(getImageFromRes.getImage(f, 255, 295)));
								
							}
						}
						}
					}
					
					}
				else{
					cb7.setEnabled(false);
					b17.setEnabled(false);
					b18.setEnabled(false);
					b19.setEnabled(false);
					dpi3.setState(false);
					tf12.setEnabled(false);
					ta1.setEnabled(false);
					model3.setSelected(false);
					
					lb52.setIcon(new ImageIcon());
					ta1.setText("");
					tf12.setText("");
				}
			}
			
		});
		
		this.lb39 = new JLabel("Criteria : ");
		this.lb39.setForeground(Color.WHITE);
		this.lb40 = new JLabel("Candidate : "); 
		this.lb40.setForeground(Color.WHITE);
		this.lb41 = new JLabel("User : ");
		this.lb41.setForeground(Color.WHITE);
		this.lb42 = new JLabel("House : ");
		this.lb42.setForeground(Color.WHITE);
		this.lb43 = new JLabel("Database Entries : ");
		this.lb43.setForeground(Color.WHITE);
		this.lb44 = new JLabel("Name : ");
		this.lb44.setForeground(Color.WHITE);
		this.lb45 = new JLabel("Date Of Birth : ");
		this.lb45.setForeground(Color.WHITE);
		this.lb46 = new JLabel("House : ");
		this.lb46.setForeground(Color.WHITE);
		this.lb47 = new JLabel("About Me : ");
		this.lb47.setForeground(Color.WHITE);
		this.lb48 = new JLabel("" + GUIData.Current_User);
		this.lb48.setForeground(Color.WHITE);
		this.lb49 = new JLabel("" + GUIData.Current_User_House);
		this.lb49.setForeground(Color.WHITE);
		this.lb50 = new JLabel("" + GUIData.Entries_Caught);
		this.lb50.setForeground(Color.WHITE);
		this.lb51 = new JLabel("---------------------------------------------Candidate Bio---------------------------------------------");
		this.lb51.setForeground(Color.WHITE);
		this.lb52 = new JLabel();
		this.lb52.setForeground(Color.WHITE);
				
		lb52.setIcon(new ImageIcon());
		cb7.setEnabled(false);
		b17.setEnabled(false);
		b18.setEnabled(false);
		b19.setEnabled(false);
		dpi3.setState(false);
		tf12.setEnabled(false);
		ta1.setEnabled(false);
		b15.setEnabled(false);
		
		this.b12.setBounds(5, 5, 155, 20);
		this.frame5.add(b12);
		
		this.b13.setBounds(170, 5, 145, 20);
		this.frame5.add(b13);
		
		this.lb39.setBounds(5, 30, 60, 13);
		this.frame5.add(lb39);
		
		this.lb40.setBounds(170, 30, 80, 13);
		this.frame5.add(lb40);
		
		this.jsp2.setBounds(5, 50, 150, 500);
		this.frame5.add(jsp2);
		
		this.jsp3.setBounds(170, 50, 150, 500);
		this.frame5.add(jsp3);
		
		this.b14.setBounds(5, 555, 145, 20);
		this.frame5.add(b14);
		
		this.b15.setBounds(170, 555, 145, 20);
		this.frame5.add(b15);
		
		this.b16.setBounds(5, 590, 145, 20);
		this.frame5.add(b16);
		
		this.lb51.setBounds(360, 5, 500, 13);
		this.frame5.add(lb51);
		
		this.lb41.setBounds(170, 593, 50, 13);
		this.frame5.add(lb41);
		
		this.lb48.setBounds(210, 593, 170, 13);
		this.frame5.add(lb48);
		
		this.lb46.setBounds(400, 593, 70, 13);
		this.frame5.add(lb46);
		
		this.lb49.setBounds(450, 593, 70, 13);
		this.frame5.add(lb49);
		
		this.lb43.setBounds(630, 593, 120, 13);
		this.frame5.add(lb43);
		
		this.lb50.setBounds(750, 593, 80, 13);
		this.frame5.add(lb50);
		
		this.lb52.setBounds(440, 30, 295, 255);
		this.frame5.add(lb52);
		
		this.b17.setBounds(438, 300, 295, 20);
		this.frame5.add(b17);
		
		this.b18.setBounds(438, 470, 295, 20);
		this.frame5.add(b18);
		
		this.b19.setBounds(438, 500, 295, 20);
		this.frame5.add(b19);
		
		this.lb44.setBounds(438, 340, 50, 13);
		this.frame5.add(lb44);
		
		this.tf12.setBounds(490, 337, 240, 20);
		this.frame5.add(tf12);
		
		this.lb45.setBounds(400, 371, 120, 13);
		this.frame5.add(lb45);
		
		this.dpi3.setBounds(490, 368, 240, 20);
		this.frame5.add(dpi3);
		
		this.lb42.setBounds(435, 401, 50, 13);
		this.frame5.add(lb42);
		
		this.cb7.setBounds(490, 398, 240, 20);
		this.frame5.add(cb7);
		
		this.lb47.setBounds(418, 431, 80 ,13);
		this.frame5.add(lb47);
		
		this.jsp4.setBounds(490, 431, 240, 30);
		this.frame5.add(jsp4);
		
		this.b20.setBounds(340, 530, 140, 20);
		this.frame5.add(b20);
		
		this.b21.setBounds(490, 530, 140, 20);
		this.frame5.add(b21);
		
		this.b22.setBounds(640, 530, 160, 20);
		this.frame5.add(b22);
		
		this.b23.setBounds(340, 555, 130, 20);
		this.frame5.add(b23);
		
		this.b24.setBounds(477, 555, 195, 20);
		this.frame5.add(b24);
		
		this.b25.setBounds(680, 555, 120, 20);
		this.frame5.add(b25);
		
		this.frame5.setSize(825, 673);
		this.frame5.setResizable(false);
		this.frame5.setVisible(true);		
	}
	
	public void showDatabaseSelectionForm(){
		
		Listen_Action la = new Listen_Action();
		
		this.frame4 = new JFrame();
		this.frame4.setTitle("Database Selection");
		this.frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame4.setLayout(null);
		this.frame4.getContentPane().setBackground(Color.BLACK);
		this.frame4.setIconImage(getImageFromRes.getImage("icon.png"));
		
		this.lb31 = new JLabel("Select Database : ");
		this.lb31.setForeground(Color.WHITE);
		this.lb32 = new JLabel("--------------------------------INFORMATION--------------------------------"); 
		this.lb32.setForeground(Color.WHITE);
		this.lb33 = new JLabel("User : ");
		this.lb33.setForeground(Color.WHITE);
		this.lb34 = new JLabel("House : "); 
		this.lb34.setForeground(Color.WHITE);
		this.lb35 = new JLabel("Entries Caught : ");
		this.lb35.setForeground(Color.WHITE);
		this.lb36 = new JLabel("" + GUIData.Current_User);
		this.lb36.setForeground(Color.WHITE);
		this.lb37 = new JLabel("" + GUIData.Current_User_House);
		this.lb37.setForeground(Color.WHITE);
		this.lb38 = new JLabel("" + GUIData.Entries_Caught);
		this.lb38.setForeground(Color.WHITE);
				
		this.b10 = new JButton("Back"); 
		this.b10.setActionCommand("BACK_DATABASE_SELECTION");
		this.b10.addActionListener(la);
		this.b10.setBackground(Color.BLACK);
		this.b10.setForeground(Color.WHITE);
		this.b11 = new JButton("Connect");
		this.b11.setActionCommand("CONNECT_DATABASE_SELECTION");
		this.b11.addActionListener(la);
		this.b11.setBackground(Color.BLACK);
		this.b11.setForeground(Color.WHITE);
		
		this.lb31.setBounds(12, 22, 120, 13);
		this.frame4.add(lb31);
		
		this.cb6.setBounds(125, 20, 220, 20);
		this.frame4.add(cb6);
		
		this.b10.setBounds(12, 45, 165, 20);
		this.frame4.add(b10);
		
		this.b11.setBounds(180, 45, 165, 20);
		this.frame4.add(b11);
		
		this.lb32.setBounds(12, 78, 340, 13);
		this.frame4.add(lb32);
		
		this.lb33.setBounds(12, 100, 60, 13);
		this.frame4.add(lb33);
		
		this.lb36.setBounds(50, 100, 200, 13);
		this.frame4.add(lb36);
		
		this.lb34.setBounds(250, 100, 50, 13);
		this.frame4.add(lb34);
		
		this.lb37.setBounds(300, 100, 60, 13);
		this.frame4.add(lb37);
		
		this.lb35.setBounds(100, 130, 120, 13);
		this.frame4.add(lb35);
		
		this.lb38.setBounds(200, 130, 60, 13);
		this.frame4.add(lb38);
		
		this.frame4.setSize(380, 190);
		this.frame4.setResizable(false);
		this.frame4.setVisible(true);
				
	}
		
	public void showForgotPasswordForm(){
		
		Listen_Action la = new Listen_Action();
		DBM.reInitData();
		
		this.frame3 = new JFrame();
		this.frame3.setTitle("Forgot Password");
		this.frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame3.setLayout(null);
		this.frame3.getContentPane().setBackground(Color.BLACK);
		this.frame3.setIconImage(getImageFromRes.getImage("icon.png"));
		
		this.lb29.setText("" + GUIData.tries);
		
		this.lb24 = new JLabel("Username : ");
		this.lb24.setForeground(Color.WHITE);
		this.lb25 = new JLabel("Default Database Name : ");
		this.lb25.setForeground(Color.WHITE);
		this.lb26 = new JLabel("First Name : ");
		this.lb26.setForeground(Color.WHITE);
		this.lb27 = new JLabel("Date Of Birth : ");
		this.lb27.setForeground(Color.WHITE);
		this.lb28 = new JLabel("No. Of Tries Left : ");
		this.lb28.setForeground(Color.WHITE);
		//this.lb29 = new JLabel("" + GUIData.tries);
		this.lb29.setForeground(Color.WHITE);
		this.lb30 = new JLabel("");
		this.lb30.setForeground(Color.WHITE);
		this.lb30.setBackground(Color.BLACK);
		
		this.jsp1 = new JScrollPane(lb30, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.jsp1.getViewport().setBackground(Color.BLACK);
		this.jsp1.getVerticalScrollBar().setBackground(Color.BLACK);
		
		this.tf9 = new JTextField();
		this.tf10 = new JTextField();
		this.tf11 = new JTextField();
		
		this.b8 = new JButton("Back");
		this.b8.setActionCommand("BACK_FORGOT_PWD");
		this.b8.addActionListener(la);
		this.b8.setBackground(Color.BLACK);
		this.b8.setForeground(Color.WHITE);
		this.b9 = new JButton("Get Password");
		this.b9.setActionCommand("GET_PWD");
		this.b9.addActionListener(la);
		this.b9.setBackground(Color.BLACK);
		this.b9.setForeground(Color.WHITE);
			
		this.model2 = new UtilDateModel();
		this.dp2 = new JDatePanelImpl(model2);
		this.dpi2 = new JDatePickerImpl(dp2);
		
		this.lb24.setBounds(12, 15, 70, 13);
		this.frame3.add(lb24);
		
		this.tf9.setBounds(90, 12, 180, 20);
		this.frame3.add(tf9);
		
		this.lb25.setBounds(12, 50, 150, 13);
		this.frame3.add(lb25);
		
		this.tf10.setBounds(160, 47, 150, 20);
		this.frame3.add(tf10);
		
		this.lb26.setBounds(12, 85, 70, 13);
		this.frame3.add(lb26);
		
		this.tf11.setBounds(90, 82, 180, 20);
		this.frame3.add(tf11);
		
		this.lb27.setBounds(12, 120, 130, 20);
		this.frame3.add(lb27);
		
		this.dpi2.setBounds(105, 118, 180, 20);
		this.frame3.add(dpi2);
		
		this.jsp1.setBounds(170, 155, 150 ,40);
		this.frame3.add(jsp1);
		this.jsp1.setVisible(false);
		
		this.b9.setBounds(12, 155, 150, 40);
		this.frame3.add(b9);
		
		this.b8.setBounds(9, 210, 305, 30);
		this.frame3.add(b8);
		
		this.lb28.setBounds(75, 250, 130, 13);
		this.frame3.add(lb28);
		
		this.lb29.setBounds(200, 250, 75, 13);
		this.frame3.add(lb29);
		
		this.frame3.setSize(328, 310);
		this.frame3.setResizable(false);
		this.frame3.setVisible(true);
		
		
	}
		
	public void showRegisterForm(){
		
		Listen_Action la = new Listen_Action();
		DBM.reInitData();
		
		this.frame2 = new JFrame();
		this.frame2.setTitle("Register New User");
		this.frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame2.setLayout(null);
		this.frame2.getContentPane().setBackground(Color.BLACK);
		this.frame2.setIconImage(getImageFromRes.getImage("icon.png"));
		
		this.model1 = new UtilDateModel();
		this.dp1 = new JDatePanelImpl(model1);
		this.dpi1 = new JDatePickerImpl(dp1);
		
		this.lb17 = new JLabel("Username : ");
		this.lb17.setForeground(Color.WHITE);
		this.lb18 = new JLabel("Empty!"); 
		
		this.lb18.setForeground(Color.WHITE);
		this.lb19 = new JLabel("Password : ");
		this.lb19.setForeground(Color.WHITE);
		this.lb20 = new JLabel("Default Database Name : ");
		this.lb20.setForeground(Color.WHITE);
		this.lb21 = new JLabel("First Name : ");
		this.lb21.setForeground(Color.WHITE);
		this.lb22 = new JLabel("Date Of Birth : ");
		this.lb22.setForeground(Color.WHITE);
		this.lb23 = new JLabel("Empty!");
		this.lb23.setForeground(Color.WHITE);
		
		this.tf6 = new JTextField();
		this.tf6.addKeyListener(new KeyListener(){

			
			public void keyPressed(KeyEvent e) {
				
				
			}

			
			public void keyReleased(KeyEvent e) {
				
				String s = tf6.getText();
				s = s.trim();
				s = s.toLowerCase();
				
			if(!s.equals("") && !s.toLowerCase().equals("screens")){
				int exists = DBM.checkUsernameEntry(s);
					
					if(exists == 1){
					
					lb18.setText("Username Available!");
					
					}
					else if(exists == -1){
					
					lb18.setText("Username Already Taken!");
					
					}					
				
			}
			else if(s.toLowerCase().equals("screens")){
				
				lb18.setText("System Name!");
				
			}
			
			else{
					
					lb18.setText("Empty!");
					
			}
				
			}
			
			public void keyTyped(KeyEvent e) {
				
				
			}
			
			
			
		});		
		
		this.tf7 = new JTextField();
		this.tf7.addKeyListener(new KeyListener(){

			
			public void keyPressed(KeyEvent arg0) {
			
				
			}

		
			public void keyReleased(KeyEvent arg0) {
			
				String s = tf7.getText();
				s = s.trim();
				s = s.toLowerCase();
				
			if(!s.equals("")){
				int exists = DBM.checkDBEntry(s);
					
					if(exists == 1){
					
					lb23.setText("Database Name Available!");
					
					}
					else if(exists == -1){
					
					lb23.setText("Database Name Already Taken!");
					
					}					
				
			}
			
			else{
					
					lb23.setText("Empty!");
					
			}
				
			}

			
			public void keyTyped(KeyEvent arg0) {
				
				
			}
			
			
			
		});
		
		this.tf8 = new JTextField();
		
		this.pf1 = new JPasswordField();

		this.b5 = new JButton("Create Account");
		this.b5.setBackground(Color.BLACK);
		this.b5.setForeground(Color.WHITE);
		this.b5.setActionCommand("CREATE_ACCOUNT");
		this.b5.addActionListener(la);
		
		this.b6 = new JButton("Reset Values");
		this.b6.setBackground(Color.BLACK);
		this.b6.setForeground(Color.WHITE);
		this.b6.setActionCommand("RESET_VALUES_REGISTER_FORM");
		this.b6.addActionListener(la);
		
		this.b7 = new JButton("Back");
		this.b7.setBackground(Color.BLACK);
		this.b7.setForeground(Color.WHITE);
		this.b7.setActionCommand("BACK_REGISTER_FORM");
		this.b7.addActionListener(la);
		
		this.lb17.setBounds(12, 15, 75, 13);
		this.frame2.add(lb17);
		
		this.tf6.setBounds(95, 12, 180, 20);
		this.frame2.add(tf6);
		
		this.lb18.setBounds(95, 36, 175, 13);
		this.frame2.add(lb18);
		
		this.lb19.setBounds(12, 55, 75, 13);
		this.frame2.add(lb19);
		
		this.pf1.setBounds(95, 52, 180, 20);
		this.frame2.add(pf1);
		
		this.lb20.setBounds(12, 90, 145, 13);
		this.frame2.add(lb20);
		
		this.tf7.setBounds(160, 87, 130, 20);
		this.frame2.add(tf7);
		
		this.lb23.setBounds(160, 109, 200, 13);
		this.frame2.add(lb23);
		
		this.lb21.setBounds(12, 145, 145, 13);
		this.frame2.add(lb21);
		
		this.tf8.setBounds(95, 142, 180, 20);
		this.frame2.add(tf8);
		
		this.lb22.setBounds(12, 180, 120, 13);
		this.frame2.add(lb22);
		
		this.dpi1.setBounds(115, 176, 180, 20);
		this.frame2.add(dpi1);
		
		this.b5.setBounds(65, 220, 200, 20);
		this.frame2.add(b5);
		
		this.b6.setBounds(65, 240, 200, 20);
		this.frame2.add(b6);
		
		this.b7.setBounds(65, 260, 200, 20);
		this.frame2.add(b7);		
		
		this.frame2.setSize(350, 320);
		this.frame2.setResizable(false);
		this.frame2.setVisible(true);
		
	}
		
		
	public void showLoginForm(){
		
		this.DBM = new DBMethods();
		Listen_Action la = new Listen_Action();
		DBM.reInitData();
						
		this.frame1 = new JFrame();
		this.frame1.setTitle("Start Screen");
		this.frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame1.setLayout(null);
		this.frame1.getContentPane().setBackground(Color.BLACK);
		this.frame1.setIconImage(getImageFromRes.getImage("icon.png"));
		
		this.lb13.setText("" + GUIData.tries);
		this.lb14.setText("" + GUIData.tries);
		
		this.lb1 = new JLabel("Select Criteria : ");
		this.lb1.setForeground(Color.WHITE);
		this.lb2 = new JLabel("Username : ");
		this.lb2.setForeground(Color.WHITE);
		this.lb3 = new JLabel("Password : ");
		this.lb3.setForeground(Color.WHITE);
		this.lb4 = new JLabel("No. Of Tries Left : ");
		this.lb4.setForeground(Color.WHITE);
		this.lb5 = new JLabel("Criteria : ");
		this.lb5.setForeground(Color.WHITE);
		this.lb6 = new JLabel("Username : ");
		this.lb6.setForeground(Color.WHITE);
		this.lb7 = new JLabel("Password : ");
		this.lb7.setForeground(Color.WHITE);
		//this.lb8 = new JLabel("House : ");
		//this.lb8.setForeground(Color.WHITE);
		this.lb9 = new JLabel("No. Of Tries Left : ");
		this.lb9.setForeground(Color.WHITE);
		this.lb10 = new JLabel("House : ");
		this.lb10.setForeground(Color.WHITE);
		this.lb11 = new JLabel("Database Owner : ");
		this.lb11.setForeground(Color.WHITE);
		this.lb12 = new JLabel("Enrollment Number : ");
		this.lb12.setForeground(Color.WHITE);
		this.lb15 = new JLabel("House : ");
		this.lb15.setForeground(Color.WHITE);
		this.lb16 = new JLabel("House : ");
		this.lb16.setForeground(Color.WHITE);
		//this.lb13 = new JLabel(""+GUIData.tries);
		this.lb13.setForeground(Color.WHITE);
		//this.lb14 = new JLabel(""+GUIData.tries);
		this.lb14.setForeground(Color.WHITE);
		
		this.tf1 = new JTextField();
		this.tf2 = new JPasswordField();
		this.tf3 = new JTextField();
		this.tf4 = new JTextField();
		this.tf5 = new JPasswordField();
		
		//this.cb1 = new JComboBox<String>();
		//this.cb1.setBackground(Color.BLACK);
		//this.cb1.setForeground(Color.WHITE);
		//this.cb1.addItem("Ruby");
		//this.cb1.addItem("Sapphire");
		//this.cb1.addItem("Emerald");
		//this.cb1.addItem("Topaz");
		
		this.cb2 = new JComboBox<String>();
		this.cb2.setBackground(Color.BLACK);
		this.cb2.setForeground(Color.WHITE);
		this.cb2.addItem("Teacher");
		this.cb2.addItem("Student");
		
		this.cb3 = new JComboBox<String>();
		this.cb3.setBackground(Color.BLACK);
		this.cb3.setForeground(Color.WHITE);
		this.cb3.addItem("Ruby");
		this.cb3.addItem("Sapphire");
		this.cb3.addItem("Emerald");
		this.cb3.addItem("Topaz");
		
		this.cb5 = new JComboBox<String>();
		this.cb5.setBackground(Color.BLACK);
		this.cb5.setForeground(Color.WHITE);
		this.cb5.addItem("Ruby");
		this.cb5.addItem("Sapphire");
		this.cb5.addItem("Emerald");
		this.cb5.addItem("Topaz");
		this.cb5.addItem("No House");
		
		//GUIData.cb4 = new JComboBox();
		GUIData.cb4.setBackground(Color.BLACK);
		GUIData.cb4.setForeground(Color.WHITE);
				
		this.b1 = new JButton("Login");
		this.b1.setActionCommand("LOGIN_SETTINGS");
		this.b1.addActionListener(la);
		this.b1.setBackground(Color.BLACK);
		this.b1.setForeground(Color.WHITE);
		this.b2 = new JButton("Login");
		this.b2.setActionCommand("LOGIN_VOTING");
		this.b2.addActionListener(la);
		this.b2.setBackground(Color.BLACK);
		this.b2.setForeground(Color.WHITE);
		this.b3 = new JButton("Forgot Password");
		this.b3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.b3.setActionCommand("FORGOT_PASSWORD");
		this.b3.addActionListener(la);
		this.b3.setBackground(Color.BLACK);
		this.b3.setForeground(new Color(245, 155, 0));
		this.b4 = new JButton("Register New User");
		this.b4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.b4.setActionCommand("REGISTER_NEW_USER");
		this.b4.addActionListener(la);
		this.b4.setBackground(Color.BLACK);
		this.b4.setForeground(new Color(245, 155, 0));
		
		this.rb1 = new JRadioButton("Settings & Others");
		this.rb1.setBackground(Color.BLACK);
		this.rb1.setForeground(Color.WHITE);
		//GUIData.rb2 = new JRadioButton("Polling");
		GUIData.rb2.setBackground(Color.BLACK);
		GUIData.rb2.setForeground(Color.WHITE);
		
		this.rb1.addActionListener(la);
		GUIData.rb2.addActionListener(la);
		this.rb1.setActionCommand("RadioButton1");
		GUIData.rb2.setActionCommand("RadioButton2");
				
		this.lb1.setBounds(12, 16, 100, 13);
		this.frame1.add(lb1);
		
		this.rb1.setBounds(137, 12, 150, 17);
		this.frame1.add(rb1);
		
		GUIData.rb2.setBounds(137, 35, 135, 17);
		this.frame1.add(rb2);
		
		this.bg1 = new ButtonGroup();
		this.bg1.add(rb1);
		this.bg1.add(rb2);
				
		
		this.lb2.setBounds(12, 80, 75, 13);
		this.frame1.add(lb2);
		this.lb2.setVisible(false);
		
		this.lb3.setBounds(12, 110, 75, 13);
		this.frame1.add(lb3);
		this.lb3.setVisible(false);
		
		this.tf1.setBounds(122, 75, 151, 20);
		this.frame1.add(tf1);
		this.tf1.setVisible(false);;
		
		this.tf2.setBounds(122, 105, 151, 20);
		this.frame1.add(tf2);
		this.tf2.setVisible(false);;
		
		//this.lb8.setBounds(12, 140, 75, 13);
		//this.frame1.add(lb8);
		//this.lb8.setVisible(false);
		
		//this.cb1.setBounds(122, 135, 151, 20);
		//this.frame1.add(cb1);
		//this.cb1.setVisible(false);
		
		this.b1.setBounds(198, 165, 75, 23);
		this.frame1.add(b1);
		this.b1.setVisible(false);
		
		this.b4.setBounds(15, 180, 150, 20);
		this.b4.setBorder(null);
		this.b4.setHorizontalAlignment(SwingConstants.LEFT);
		this.frame1.add(b4);
		this.b4.setVisible(false);
		
		this.b3.setBounds(15, 205, 150, 20);
		this.b3.setBorder(null);
		this.b3.setHorizontalAlignment(SwingConstants.LEFT);
		this.frame1.add(b3);
		this.b3.setVisible(false);
		
		this.lb4.setBounds(51, 240, 100, 13);
		this.frame1.add(lb4);
		this.lb4.setVisible(false);
		
		this.lb13.setBounds(170, 240, 100, 13);
		this.frame1.add(lb13);
		this.lb13.setVisible(false);
					
		this.lb5.setBounds(12, 80, 75, 13);
		this.frame1.add(lb5);
		this.lb5.setVisible(false);
		
		this.cb2.setBounds(100, 78, 110, 20);
		this.cb2.setActionCommand("Criteria");
		this.cb2.addActionListener(la);
		this.frame1.add(cb2);
		this.cb2.setVisible(false);
		
		this.lb15.setBounds(12, 130, 75, 13);
		this.frame1.add(lb15);
		this.lb15.setVisible(false);
		
		this.cb3.setBounds(100, 128, 110, 20);
		this.frame1.add(cb3);
		this.cb3.setVisible(false);
		
		this.lb11.setBounds(12, 170, 150, 13);
		this.frame1.add(lb11);
		this.lb11.setVisible(false);
		
		GUIData.cb4.setBounds(130, 168, 170, 20);
		this.frame1.add(cb4);
		GUIData.cb4.setVisible(false);
		
		this.lb12.setBounds(12, 220, 150, 13);
		this.frame1.add(lb12);
		this.lb12.setVisible(false);
		
		this.tf3.setBounds(150, 218, 100, 20);
		this.frame1.add(tf3);
		this.tf3.setVisible(false);
		
		this.b2.setBounds(50, 245, 200, 20);
		this.frame1.add(b2);
		this.b4.setVisible(false);
					
		this.lb6.setBounds(12, 120, 150, 13);
		this.frame1.add(lb6);
		this.lb6.setVisible(false);
		
		this.lb7.setBounds(12, 150, 150, 13);
		this.frame1.add(lb7);
		this.lb7.setVisible(false);
		
		this.lb16.setBounds(12, 180, 150, 13);
		this.frame1.add(lb16);
		this.lb16.setVisible(false);
		
		this.tf4.setBounds(85, 118, 200, 20);
		this.frame1.add(tf4);
		this.tf4.setVisible(false);
		
		this.tf5.setBounds(85, 148, 200, 20);
		this.frame1.add(tf5);
		this.tf5.setVisible(false);
		
		this.cb5.setBounds(85, 178, 100, 20);
		this.frame1.add(cb5);
		this.cb5.setVisible(false);
		
		this.lb9.setBounds(85, 215, 100, 20);
		this.frame1.add(lb9);
		this.lb9.setVisible(false);
		
		this.lb14.setBounds(205, 215, 100, 20);
		this.frame1.add(lb14);
		this.lb14.setVisible(false);
		
		this.frame1.setSize(328, 98);
		this.frame1.setResizable(false);
		this.frame1.setVisible(true);
		
	}
	
}
