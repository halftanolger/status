
package status;

import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

import javax.swing.JFram;

public class StatusApp {

	static Logger logger = Logger.getLogger(status.StatusApp.class);


	public static void main(String args[]){

		BasicConfigurator.configure();
		logger.info("StatusApp v.0.0.0");

		System.out.println("StatusApp v.0.0.0");
		JFrame frame = new JFrame("StatusApp");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
		
	}



}
