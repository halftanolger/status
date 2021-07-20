package status;

import org.apache.log4j.Logger;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class StatusComponent extends JPanel {

	static Logger logger = Logger.getLogger(status.StatusComponent.class);

	private class ComputerData {

		String navn;
		String info;
		int status;
		double ax,ay;
		double bx,by;

		public ComputerData(double ax, 
					double ay, 
					double bx, 
					double by,
					int status,
					String navn,
					String info) {
			this.ax = ax;
			this.ay = ay;
			this.bx = bx;
			this.by = by;
			this.status = status;
			this.navn = navn;
			this.info = info;
		}

		public String getNavn() {
			return navn;
		}

		public String getInfo() {
			return info;
		}

		public int getStatus() {
			return status;
		}

		public double getAx() { 
			return ax; 
		}

	        public double getAy() { 
			return ay; 
		}

	        public double getBx() { 
			return bx; 
		}

	        public double getBy() { 
			return by; 
		}

	}

	private class StatusComponentData {

		String rom = "";
		double width  = 0;
		double height = 0;

		ArrayList<ComputerData> computers = new ArrayList<ComputerData>();

		public StatusComponentData() {

			rom = "Testrom";
			width = 30.0;
			height = 20.0;

			// TODO:
			// Selve størrelse på hovedviduet bør
			// maksimaliseres ut fra denne bredden
			// og høyden ...
			
			computers.add( new ComputerData(3,
						6,
						2,
						3,
						0,
						"SIM01",
						"30")
					);

			computers.add( new ComputerData(3,
						10,
						2,
						3,
						0,
						"SIM02",
						"30")
					);
		}	

		String getRom() { 
			return rom; 
		}

		double getWidth() { 
			return width; 
		}

		double getHeight() { 
			return height; 
		}

		ArrayList<ComputerData> getComputers() { 
			return computers; 
		}

	}

	private static final long serialVersionUID = 1L;
    	
	private StatusComponentData data = null;

	public StatusComponent() { 
	
		data = new StatusComponentData();
			
	}

    	public void paintComponent(Graphics g) {
        	super.paintComponent(g);

		Dimension dim = getSize();
		double by = dim.getHeight();
		double bx = dim.getWidth();

 	        //g.setColor(Color.red);
        	//g.drawRect(0, 0, (int)(bx), (int)(by));


		double ay = data.getHeight();
		double ax = data.getWidth();

                //g.setColor(Color.blue);
        	//g.drawRect(0, 0, (int)(ax), (int)(ay));

		double scale = 1.0;
                int doScaleStuff = doScale(ax,bx,ay,by);
		if (doScaleStuff == 1) {

			logger.debug("do scale");
			scale = getScale(ax,bx,ay,by);
		}
		
		ax *= scale;
		ay *= scale;

		g.setColor(Color.black);
        	g.drawRect(0, 0, (int)(ax-1.0), (int)(ay-1.0));
		g.drawString(data.getRom(),10,15);


		ArrayList<ComputerData> list = data.getComputers();
		for (ComputerData c:list) {

			double ai = (c.getAx() * scale);
			double bi = (c.getAy() * scale);
			double ci = (c.getBx() * scale);
			double di = (c.getBy() * scale);

              		g.drawRect((int)ai, 
					(int)bi, 
					(int)(ci-1.0), 
					(int)(di-1.0));


           		g.drawString(c.getNavn(),
					5+(int)ai,
					15+(int)bi);

		}

    	}


        private int doScale(double ax, double bx, double ay, double by) {

		if ( (bx - ax) > 0 && (by - ay) > 0) {
			return 1;
		} else {
			return 0;
		}
		
	}	

	private double getScale(double ax, double bx, double ay, double by) {

		double dx = bx / ax;
		double dy = by / ay;

                if (dx > dy) {
			return dy;
		} else {
			return dx;
		}

	}



}
