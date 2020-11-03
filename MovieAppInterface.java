 import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.Color;
import javax.swing.JLabel;

public class MovieAppInterface extends JFrame implements ActionListener
{
	private JButton but1;
	private JButton but2;
	private JButton but3;
	private JButton gBut4;
	private JButton gBut5;
	private JButton gBut6;
	private JButton gBut7;
	private JButton gBut8;
	private JButton gBut9;
	private JPanel panel;
	JLabel prompt = new JLabel();
	JTextArea movies = new JTextArea();
	// images
	JLabel label;
	JLabel label2;
	boolean moviePicUp = false;
	static ArrayList<String> movieArray = new ArrayList();
	/**
	 * constructor creates all components of a ColorFrame! 
	 */
	public MovieAppInterface()
	{
		but1 = new JButton("Movies");
		but1.addActionListener(this);
		but2= new JButton("Genres");
		but2.addActionListener(this);
		but3 = new JButton("Profile");
		but3.addActionListener(this);
		gBut4 = new JButton("Fantasy");
		gBut5 = new JButton("Comedy");
		gBut6 = new JButton("Romance");
		gBut7 = new JButton("Sci-Fi");
		gBut8 = new JButton("Mystery");
		gBut9 = new JButton("Feel-Good");
		gBut4.addActionListener(this);
		gBut5.addActionListener(this);
		gBut6.addActionListener(this);
		gBut7.addActionListener(this);
		gBut8.addActionListener(this);
		gBut9.addActionListener(this);
		panel= new JPanel();
		panel.add(but1);
		panel.add(but2);
		panel.add(but3);

		JFrame frame = new JFrame();
		frame.add(panel);
		frame.setSize(300, 400);
		frame.setTitle("MovieApp");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	/**
	 * gives each of the buttons an action 
	 */
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent event) 
	{ 
		if(event.getActionCommand().equals("Movies")) {
			// Removes Genres buttons
			panel.remove(gBut4);
			panel.remove(gBut5);
			panel.remove(gBut6);
			panel.remove(gBut7);
			panel.remove(gBut8);
			panel.remove(gBut9);
			//panel.setBackground(Color.LIGHT_GRAY);
			// Movie list
			panel.add(prompt);
			prompt.setText("This is a list of movies: ");
			movies.setText("Maleficent \t \t \t \nParasite");
			for(int i = 0; i < movieArray.size(); i++) {
				movies.setText(movies.getText() + "\n" + movieArray.get(i));
			}
			panel.add(movies);
			
			try {
				if(!moviePicUp) {
					BufferedImage image = ImageIO.read(new File("./LordOfTheRings.png"));
					label = new JLabel(new ImageIcon(image));
					panel.add(label);

					BufferedImage image2 = ImageIO.read(new File("./HarryPotter.png"));
					label2 = new JLabel(new ImageIcon(image2));
					panel.add(label2);

					moviePicUp = true;
				}
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(event.getActionCommand().equals("Genres")) {
			movies.setText("");
			prompt.setText("This is a list of genres\n");
			panel.remove(label);
			panel.remove(label2);
			moviePicUp = false;
			
			panel.add(prompt);
			panel.add(gBut4);
			panel.add(gBut5);
			panel.add(gBut6);
			panel.add(gBut7);
			panel.add(gBut8);
			panel.add(gBut9);
		}
		
		if(event.getActionCommand().equals("Fantasy")) {
			//movies.setLocation(150, 300);
			movies.setText("Lord of the Ring \t \t \nHarry Potter");
		}
		
		if(event.getActionCommand().equals("Comedy")) {
			//movies.setLocation(150, 300);
			movies.setText("A Goofy Movie \t \t \nMegamind");
		}
		
		if(event.getActionCommand().equals("Romance")) {
			//movies.setLocation(150, 300);
			movies.setText("The Pricess Bride \t \t \nCinderella");
		}
		
		if(event.getActionCommand().equals("Sci-Fi")) {
			//movies.setLocation(150, 300);
			movies.setText("The Martian \t \t \nEnder's Game");
		}
		
		if(event.getActionCommand().equals("Mystery")) {
			//movies.setLocation(150, 300);
			movies.setText("The Hound of the Baskerville \t \t \nA Study in Scarlet");
		}
		
		if(event.getActionCommand().equals("Feel-Good")) {
			//movies.setLocation(150, 300);
			movies.setText("Zootopia \t \t \nRatatouille");
		}
		
		//panel.setBackground(Color.GREEN);
		//if(event.getActionCommand().equals("Blue"))
		//	panel.setBackground(Color.BLUE);
		//
	}

	/**
	 * 
	 * @param args sets the new ColorFrame visible 
	 */
	public static void main(String[] args)
	{
		MovieAppInterface color = new MovieAppInterface();
		movieArray.add("Lord of the Rings");
		movieArray.add("Harry Potter");
		movieArray.add("The Martian");
		movieArray.add("Ender's Game");
		movieArray.add("The Pricess Bride");
		movieArray.add("A Goofy Movie");
		movieArray.add("Megamind");
		movieArray.add("Cinderella");
		movieArray.add("The Hound of the Baskerville");
		movieArray.add("A Study in Scarlet");
		movieArray.add("Zootopia");
		movieArray.add("Rataouille");

		color.setVisible (true);
	}
}
