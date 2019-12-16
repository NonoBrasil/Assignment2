package Brasil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;

public class Graphisme extends JFrame {
	public static Draw draw;

	public Graphisme() {	//constructor
		super();
		fenetre();
	}

	public void fenetre() {
		// https://openclassrooms.com/fr/courses/26832-apprenez-a-programmer-en-java/23108-creez-votre-premiere-fenetre
		this.setTitle("Assignment 2 - Noemie Pasquier"); // title of the window
		this.setSize(800, 650); // size of the window
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // we close the window when we click on the red cross
		this.setLocationRelativeTo(null); // put the object to the center
		//TITLE 
		//JLabel title = new JLabel("Graph: Temperature of the CPU of the raspberry"); //Title of thegraph 
		//this.add(title, BorderLayout.NORTH); //The title is on the top of thewindow
		
		draw=new Draw();
		this.setContentPane(draw);

		/*
		 * //BUTTON JPanel panelButtons = new JPanel(); //panel with 2 buttons
		 * pan.setLayout(new BorderLayout()); //set a layout
		 * //button.addActionListener(pan); panelButtons.add(button); //we add the
		 * button to the panel and the end of the window panelButtons.add(button2); //we
		 * add the button to the panel and the end of the window pan.add(panelButtons,
		 * BorderLayout.SOUTH); //button.addActionListener(?);
		 * 
		 * 
		 * //TEXT AREA - FREQUENCY //JTextArea frequency = new JTextArea(1,1);
		 * //pan.add(frequency,BorderLayout.CENTER);
		 * 
		 * this.setContentPane(pan); //the panel becomes vidible this.setVisible(true);
		 * //Window becomes visible
		 * 
		 * /*canvas= new Canvas(); canvas.setSize(400, 400); Graphics G =
		 * canvas.getGraphics(); frame.add(canvas); frame.setVisible(true);
		 */

	}

	/*public void actionPerformed(ActionEvent e) //
	{
		Object source = e.getSource();
		String classeSource = source.getClass().getName();
		if (classeSource.equals("JButton")) // action with the buttons
		{
			if (source == button) {
				// Daltoniens
				pan.getRootPane().setBackground(Color.black);
				JLabel title = new JLabel("Graph: Temperature of the CPU of the raspberry"); // Title of the graph
				pan.add(title, BorderLayout.CENTER); // The title is on the top of the window
			} else if (source == button2) {
				// format normal
			}
		}
	}*/

}