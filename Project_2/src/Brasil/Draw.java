package Brasil;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
//import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")

public class Draw extends JPanel implements ActionListener {

	public static String[][] tab_data = new String[20][2]; // table which save the temperature and the time
	public static int condition = 0;
	public JTextField cdelai=new JTextField("1");
	public JLabel lab=new JLabel("Delai in s");
	public static String str=null;
	public static int delai=1;
	public static JButton openButton = new JButton("Switch mode");
	public static int mode=0;
	
	public Draw() {
		super();
		cdelai.setPreferredSize(new Dimension(100,30));
		this.add(openButton);
		this.cdelai.setBounds(1000, 100, 90, 20);
		this.add(openButton);
		this.add(cdelai);
		this.add(lab);
		openButton.addActionListener(this);
		cdelai.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Switch mode")) 
		{
			mode++;
			if (mode==0)
			{
				this.setBackground(Color.WHITE);
			}
			if (mode==1)
			{
				this.setBackground(Color.BLACK);
			}
			if (mode==2)
			{
				this.setBackground(Color.WHITE);
				mode=0;
			}
			System.out.println("aaa");}
		str=cdelai.getText();
		if(Integer.parseInt(str)>0)
			delai=Integer.parseInt(str);
		System.out.println(delai);
		
	}

	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		
		float time; // X->time
		float temp; // Y->temperature
		int X; // X->time
		int Y; // Y->temperature
		String Chaine1; // will be used for string float conversion
		String Chaine2; // will be used for string float conversion

		lab.setForeground(Color.blue);
		lab.setText("delai : "+String.valueOf(delai)+" s");
		/// DRAWING
		// The abscissa represent the time and the ordinate represent the temperature at
		/// this moment
		// COORDINATE SYSTEM
		g.setColor(Color.BLUE);
		g.drawLine(50, 50, 50, 500); // coordinate system - ordinate
		g.drawLine(50, 50, 40, 60); // cross - ordinate
		g.drawLine(50, 50, 60, 60); // cross - ordinate
		g.drawLine(50, 500, 750, 500); // coordinate system - abscissa
		g.drawLine(750, 500, 740, 490); // cross- abscissa
		g.drawLine(750, 500, 740, 510); // cross - abscissa
		
		for(int counter=1; counter<20; counter++)
		{
			g.drawLine(50+counter*35, 500, 50+counter*35, 510); 
			g.drawLine(50, 50+counter*(45/2), 60, 50+counter*(45/2));
		}
		//POINTS ON THE CURVE
		if (condition < 20)
		{
			float avg=0;
			for (int i = 0; i < condition; i++) {
				Chaine1 = tab_data[i][0];
				Chaine2 = tab_data[i][1];
				time = Float.parseFloat(Chaine1);
				temp = Float.parseFloat(Chaine2);
				X = (int) time;	//convert the time to int, easier for the graph
				Y = (int) temp;	//convert the temperature to int, easier for the graph
				Color Color1 = new Color(0, 6, 255); // blue
				g.setColor(Color1);
				g.fillOval(45+i*35, 495-Y/200, 10, 10);
				avg=avg+temp/1000;
			}
			avg=avg/condition;
			System.out.println("avg" +avg);
			System.out.println("Tmax" +Temperature.Tmax);
			System.out.println("Tmin" +Temperature.Tmin);
			g.drawLine(50,495-(int) Temperature.Tmax*5, 750,495-(int) Temperature.Tmax*5);
			g.drawLine(50, 495-(int)Temperature.Tmin*5, 750,495-(int) Temperature.Tmin*5);
			g.drawLine(50, 495-(int) avg*5, 750,495-(int) avg*5);
			g.drawString("AVG: " + avg + "   -   Tmax: " + Temperature.Tmax + "   -   Tmin: "+ Temperature.Tmin, 500,550);
		}
		else
		{
			float avg=0;
			for (int i = 0; i < 20; i++) {
				Chaine1 = tab_data[i][0];
				Chaine2 = tab_data[i][1];
				time = Float.parseFloat(Chaine1);
				temp = Float.parseFloat(Chaine2);
				X = (int) time;
				Y = (int) temp;
				Color Color1 = new Color(0, 6, 255); // blue
				g.setColor(Color1);
				//g.fillOval(X, Y, 10, 10);
				g.fillOval(45+i*35, 495-Y/200, 10, 10);
				avg=avg+temp/1000;
			}
			avg=avg/20;
			g.drawLine(50,495-(int) Temperature.Tmax*5, 750,495-(int) Temperature.Tmax*5);
			g.drawLine(50, 495-(int)Temperature.Tmin*5, 750,495-(int) Temperature.Tmin*5);
			g.drawLine(50, 495-(int) avg*5, 750,495-(int) avg*5);
			g.drawString("AVG: " + avg + "   -   Tmax: " + Temperature.Tmax + "   -   Tmin: "+ Temperature.Tmin, 500,550);
		}
	}
	
	public void update(Graphics g) {
		paint(g);
	}
}