import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.net.BindException;
import java.net.InetAddress;
import java.net.ServerSocket;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class init_Application {
	
	private static final int PORT = 3115;
	private static ServerSocket socket;  
	public static final String startupPath = System.getProperty("user.dir");
		
	public static void main(String[] args){
		
		UIManager.put("OptionPane.background", Color.BLACK);
		UIManager.put("Panel.background", Color.BLACK);
		UIManager.put("Button.background",Color.BLACK);
		UIManager.put("Button.foreground", Color.WHITE);
		UIManager.put("Label.foreground", Color.WHITE);
		UIManager.put("ComboBox.foreground", Color.WHITE);
		UIManager.put("ComboBox.background", Color.BLACK);
		UIManager.put("OptionPane.messageForeground", Color.WHITE);
		
		init_Application.checkIfRunning();
		File testDir = new File (startupPath + "\\Data\\");
		File screenDir = new File (startupPath + "\\Data\\Screens\\");
		
		if (!testDir.exists() && !testDir.isDirectory()){
			 
			testDir.mkdirs();
						
		}
		
		if (!screenDir.exists() && !screenDir.isDirectory()){
			 
			screenDir.mkdirs();
						
		}
		
		
		
		GUIData g = new GUIData();
		g.showLoginForm();
		
				
	}
	
		
	private static void checkIfRunning() {
	  try {
	    init_Application.socket = new ServerSocket(PORT,0,InetAddress.getByAddress(new byte[] {127,0,0,1}));
	    System.out.println(init_Application.socket.toString());
	   	 }
	  catch (BindException e) {
		  JOptionPane.showMessageDialog(null, "Error: Application Already Running. Please Close Any Instances Of The Application That Are Running & Restart The Application!", "Error: Double Instance!", JOptionPane.ERROR_MESSAGE);
		  System.exit(0);
	   	  }
	  catch (IOException e) {
		  JOptionPane.showMessageDialog(null, "Error: "+e, "Error: IO Exception Caught", JOptionPane.ERROR_MESSAGE);
		  System.exit(0);
	  }
	    
	}

}
