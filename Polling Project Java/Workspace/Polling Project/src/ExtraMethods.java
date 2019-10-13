import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class ExtraMethods implements Runnable {
		
		public void printScreen(){
			
			String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
			
			File screenDir = new File (init_Application.startupPath + "\\Data\\Screens\\" + date + "\\");
			
			if (!screenDir.exists() && !screenDir.isDirectory()){
				 
				screenDir.mkdirs();
							
			}
			
		
			
			try {
				BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
				String dateTime = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss").format(new Date());
				ImageIO.write(image, "jpg", new File(init_Application.startupPath + "\\Data\\Screens\\" + date + "\\" + dateTime +".jpg"));
			} catch (Exception e) {
			
				JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "The Program Has Encountered An Error!", JOptionPane.ERROR_MESSAGE);
			    JOptionPane.showMessageDialog(null, "Please Restart The Application", "Program Will Now Close!", JOptionPane.INFORMATION_MESSAGE);
			    System.exit(0);
				
			}
			
			
		}
		
		public void run() {
			while(GUIData.printing){
			this.printScreen();			
			}
		}
		
	}