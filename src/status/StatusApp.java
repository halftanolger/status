
package status;

import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;



public class StatusApp extends JFrame {

	static Logger logger = Logger.getLogger(status.StatusApp.class);

	static String appNameAndVersion = "StatusApp v.0.0.0";

	public static void main(String args[]){

		BasicConfigurator.configure();
		logger.info("Starter opp " + appNameAndVersion); 

        	/* Set the Nimbus look and feel */
        	/* If Nimbus (introduced in Java SE 6) is not available, */
		/* stay with the default look and feel.*/
        	try {
            	javax.swing.UIManager.LookAndFeelInfo[] installedLookAndFeels=javax.swing.UIManager.getInstalledLookAndFeels();
            		for (int idx=0; idx<installedLookAndFeels.length; idx++)
                		if ("Nimbus".equals(installedLookAndFeels[idx].getName())) {
                    			javax.swing.UIManager.setLookAndFeel(installedLookAndFeels[idx].getClassName());
                    			break;
                		}
        	} catch (ClassNotFoundException ex) {
			logger.error(ex);
        	} catch (InstantiationException ex) {
            		logger.error(ex);
        	} catch (IllegalAccessException ex) {
                        logger.error(ex);
        	} catch (javax.swing.UnsupportedLookAndFeelException ex) {
            	        logger.error(ex);
        	}

        	/* Create and display the form */
        	SwingUtilities.invokeLater(new Runnable() {
            		public void run() {
                		new StatusApp().setVisible(true);
            		}
        	});
		
		
	}

	public StatusApp() {
	
		initComponents();

		this.setTitle(appNameAndVersion);
		this.pack();
		this.setSize(800,600);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = getSize();
        	this.setLocation(new Point((screenSize.width - frameSize.width) / 2,
					(screenSize.height - frameSize.width) / 2));
		
		this.setVisible(true);

	}

	private void initComponents() {

        	addWindowListener(new java.awt.event.WindowAdapter() {
            		public void windowClosing(java.awt.event.WindowEvent evt) {
                		exitForm(evt);
            		}
        	});



		mainPanel = new javax.swing.JPanel();
        	mainPanel.setLayout(new java.awt.BorderLayout());
        	mainPanel.setBorder(new javax.swing.border.EmptyBorder(new java.awt.Insets(12, 12, 12, 12)));
 
                statusComponent = new StatusComponent();
		mainPanel.add(statusComponent, BorderLayout.CENTER);

		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(mainPanel, BorderLayout.CENTER);

	}


	private void exitForm(java.awt.event.WindowEvent evt) {

		logger.info("Avslutter " + appNameAndVersion); 
        	System.exit(0);

    	}


	//
	// Private variabler
	//
	
	private javax.swing.JPanel mainPanel;
	private status.StatusComponent statusComponent;


}

