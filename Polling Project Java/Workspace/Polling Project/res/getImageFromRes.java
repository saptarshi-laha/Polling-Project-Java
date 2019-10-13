import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class getImageFromRes
{

	public static getImageFromRes gi = new getImageFromRes();
	
	public static Image getImage(int WIDTH, int HEIGHT, String filename){
	
	Image i = Toolkit.getDefaultToolkit().getImage(gi.getClass().getResource(filename));
	Image ifinal = i.getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH);
	return ifinal;
	}

	public static Image getImage(String filename){

	Image i = Toolkit.getDefaultToolkit().getImage(gi.getClass().getResource(filename));
	return i;
	}

	public static Image getImage(File f, int HEIGHT, int WIDTH){
		
		try{
		Image i = ImageIO.read(f);
		Image ifinal = i.getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH);
		return ifinal;
		}
		catch(Exception e){
			
			JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "The Program Has Encountered An Error!", JOptionPane.ERROR_MESSAGE);
		    System.exit(0);
			
		}
		
		return null;
		
	}
	
}