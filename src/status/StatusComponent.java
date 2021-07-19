
package status;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class StatusComponent extends JPanel {


	private class StatusComponentData {

		double width  = 0;
		double height = 0;


		public StatusComponentData() {
			width = 30.0;
			height = 20.0;
		}	


		double getWidth() { return width; }
		double getHeight() { return height; }

	}

	private static final long serialVersionUID = 1L;
    	
	private StatusComponentData data = null;

	public StatusComponent() { 
	
		data = new StatusComponentData();
			
	}

    	public void paintComponent(Graphics g) {
        	super.paintComponent(g);

		Dimension dim = getSize();
		double height = dim.getHeight() - 1.0;
		double width = dim.getWidth() - 1.0;


		double sHeight = data.getHeight();
		double sWidth = data.getWidth();

		double dH = height - sHeight;
		double dW = width - sWidth;

		double drawFactor = 1.0;

		double scale;
		if (dH <= dW) {
			scale = width / sWidth;
		} else {
			scale = height / sHeight;
		}



		double drawHeight = sHeight * scale;
		double drawWidth = sWidth * scale;

        	g.setColor(Color.black);
        	g.drawRect(0, 0, ((int)drawWidth)-35, (int)drawHeight);

         	String info2 = "width="+width+" height="+height;
		g.drawString(info2, 20, 40);

                String info3 = "sWidth="+sWidth+" sHeight="+sHeight;
		g.drawString(info3, 20, 60);
                
		String info = "dH="+dH+" dW="+dW+" scale="+scale;
		g.drawString(info, 20, 80);



    	}


	


}
