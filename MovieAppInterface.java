import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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
	JTextArea info = new JTextArea();
	JTextField search = new JTextField(20);
	JLabel movie1 = new JLabel();
	JLabel movie2 = new JLabel();
	private JButton searchButton;
	// images
	JLabel label;
	JLabel label2;
	boolean moviePicUp = false;
	static ArrayList<Movie> movieArray = new ArrayList();
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
		searchButton = new JButton("Search");
		gBut4.addActionListener(this);
		gBut5.addActionListener(this);
		gBut6.addActionListener(this);
		gBut7.addActionListener(this);
		gBut8.addActionListener(this);
		gBut9.addActionListener(this);
		searchButton.addActionListener(this);
		panel = new JPanel();
		
		panel.add(but1);
		panel.add(but2);
		panel.add(but3);

		JFrame frame = new JFrame();
		frame.add(panel);
		frame.setSize(350, 400);
		frame.setTitle("MovieApp");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
		String[] actors = {"Actor Name","",""};
		movieArray.add(new Movie("The Hobbit", "Fantasy", 8, actors, new File("./TheHobbit.png")));
		String[] actors2 = {"Actor Name","",""};
		movieArray.add(new Movie("Maleficent", "Fantasy", 8, actors2, new File("./Maleficent.png")));
		String[] actors3 = {"Actor Name","",""};
		movieArray.add(new Movie("Lord of the Rings", "Fantasy", 8, actors3, new File("./LordOfTheRings.png")));
		String[] actors4 = {"Actor Name","",""};
		movieArray.add(new Movie("Harry Potter", "Fantasy", 8, actors4, new File("./HarryPotter.png")));
		String[] actors5 = {"Actor Name","",""};
		movieArray.add(new Movie("The Martian", "Sci-Fi", 8, actors5, new File("./TheMartian.png")));
		String[] actors6 = {"Actor Name","",""};
		movieArray.add(new Movie("Ender's Game", "Sci-Fi", 8, actors6, new File("./Ender'sGame.png")));
		String[] actors7 = {"Actor Name","",""};
		movieArray.add(new Movie("The Pricess Bride", "Romance", 8, actors7, new File("./ThePricessBride.png")));
		String[] actors8 = {"Actor Name","",""};
		movieArray.add(new Movie("A Goofy Movie", "Comedy", 8, actors8, new File("./AGoofyMovie.png")));
		String[] actors9 = {"Actor Name","",""};
		movieArray.add(new Movie("Megamind", "Comedy", 8, actors9, new File("./Megamind.png")));
		String[] actors10 = {"Actor Name","",""};
		movieArray.add(new Movie("Cinderella", "Romance", 8, actors10, new File("./Cinderella.png")));
		String[] actors11 = {"Actor Name","",""};
		movieArray.add(new Movie("The Hound of the Baskerville", "Mystery", 8, actors11, new File("./TheHoundOfTheBaskervilles.png")));
		String[] actors12 = {"Actor Name","",""};
		movieArray.add(new Movie("A Study in Scarlet", "Mystery", 8, actors12, new File("./AStudyInScarlet.png")));
		String[] actors13 = {"Actor Name","",""};
		movieArray.add(new Movie("Zootopia", "Feel-Good", 8, actors13, new File("./Zootopia.png")));
		String[] actors14 = {"Actor Name","",""};
		movieArray.add(new Movie("Ratatouille", "Feel-Good", 8, actors14, new File("./Ratatouille.png")));
	}

	/**
	 * gives each of the buttons an action 
	 */
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent event) 
	{ 
		if(event.getActionCommand().equals("Profile"))
		{
			// Removes Genres buttons
			panel.remove(gBut4);
			panel.remove(gBut5);
			panel.remove(gBut6);
			panel.remove(gBut7);
			panel.remove(gBut8);
			panel.remove(gBut9);
			panel.remove(info);
			// Removes Movie features
			prompt.setText("Profile Information:\n");
			panel.remove(search);
			panel.remove(searchButton);
			panel.remove(info);
			moviePicUp = false;
			for(int i = 0; i < movieArray.size(); i++) {
				panel.remove(movieArray.get(i).getMovieTitle());
				panel.remove(movieArray.get(i).getMovieImage());
			}
			
			Scanner obj = null;
			File users = null;

			try 
			{
				users=new File("users.txt");
				obj = new Scanner(users);
				String s = "";

				while(obj.hasNextLine()) 
				{
					s = obj.nextLine() + "\n";
				}
				int i= s.indexOf(", ");
				String start= s.substring(0,i);
				String end=s.substring(i+2,s.length());
				info.setText("Username: " + start + "\nPassword: " + end);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			finally
			{
				obj.close();
			}
			panel.add(info);
		}
		
		if(event.getActionCommand().equals("Movies")) {
			// Removes Genres buttons
			panel.remove(gBut4);
			panel.remove(gBut5);
			panel.remove(gBut6);
			panel.remove(gBut7);
			panel.remove(gBut8);
			panel.remove(gBut9);
			panel.remove(info);
			for(int i = 0; i < movieArray.size(); i++) {
				panel.remove(movieArray.get(i).getMovieTitle());
				panel.remove(movieArray.get(i).getMovieImage());
			}
			
			// Search feature
			panel.add(search);
			panel.add(searchButton);
			
			// Movie list
			/*
			panel.add(prompt);
			prompt.setText("This is a list of movies: ");
			movies.setText("\t \t \t");
			
			for(int i = 0; i < movieArray.size(); i++) {
				movies.setText(movies.getText() + "\n" + movieArray.get(i));
			}
			panel.add(movies);
			*/
			
			// Movie Labels with pictures
			//panel.setLayout(new GridLayout(14, 2));
			
			try {
				if(!moviePicUp) {
					for(int i = 0; i < movieArray.size(); i++) {
						BufferedImage image = ImageIO.read(movieArray.get(i).getImageFile());
						Image scaledImage = image.getScaledInstance(50, 75, Image.SCALE_SMOOTH);
						movieArray.get(i).movieImage = new JLabel(new ImageIcon(scaledImage));
					}
					moviePicUp = true;
				}
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for(int i = 0; i < movieArray.size(); i++) {
				movieArray.get(i).getMovieTitle().setText(movieArray.get(i).getName());
				panel.add(movieArray.get(i).getMovieTitle());
				panel.add(movieArray.get(i).getMovieImage());
			}
		}
		
		if(event.getActionCommand().equals("Search")) {
			for(int i = 0; i < movieArray.size(); i++) {
				panel.remove(movieArray.get(i).getMovieTitle());
				panel.remove(movieArray.get(i).getMovieImage());
			}
			
			for(int i = 0; i < movieArray.size(); i++) {
				if(movieArray.get(i).getName().contains(search.getText())) {
					panel.add(movieArray.get(i).getMovieTitle());
					panel.add(movieArray.get(i).getMovieImage());
				}
			}
			
			/*
			movies.setText("");
			for(int i = 0; i < movieArray.size(); i++) {
				if(movieArray.get(i).contains(search.getText())) {
					movies.setText(movies.getText() + "\n" + movieArray.get(i));
				}
			}
			movies.setText(movies.getText() + "\n\t\t\t");
			*/
		}
		
		if(event.getActionCommand().equals("Genres")) {
			// Remove Movie features
			prompt.setText("This is a list of genres\n");
			panel.remove(search);
			panel.remove(searchButton);
			panel.remove(info);
			moviePicUp = false;
			for(int i = 0; i < movieArray.size(); i++) {
				panel.remove(movieArray.get(i).getMovieTitle());
				panel.remove(movieArray.get(i).getMovieImage());
			}
			
			panel.add(prompt);
			panel.add(gBut4);
			panel.add(gBut5);
			panel.add(gBut6);
			panel.add(gBut7);
			panel.add(gBut8);
			panel.add(gBut9);
		}
		
		if(event.getActionCommand().equals("Fantasy")) {
			for(int i = 0; i < movieArray.size(); i++) {
				panel.remove(movieArray.get(i).getMovieTitle());
				panel.remove(movieArray.get(i).getMovieImage());
			}
			for(int i = 0; i < movieArray.size(); i++) {
				if(movieArray.get(i).getGenre().equals("Fantasy")) {
					panel.add(movieArray.get(i).getMovieTitle());
					panel.add(movieArray.get(i).getMovieImage());
				}
			}
			//movies.setText("Lord of the Ring \t \t \nHarry Potter");
			//movies.setText(movies.getText() + "\nMaleficent \nThe Hobbit");
		}
		
		if(event.getActionCommand().equals("Comedy")) {
			for(int i = 0; i < movieArray.size(); i++) {
				panel.remove(movieArray.get(i).getMovieTitle());
				panel.remove(movieArray.get(i).getMovieImage());
			}
			for(int i = 0; i < movieArray.size(); i++) {
				if(movieArray.get(i).getGenre().equals("Comedy")) {
					panel.add(movieArray.get(i).getMovieTitle());
					panel.add(movieArray.get(i).getMovieImage());
				}
			}
			//movies.setText("A Goofy Movie \t \t \nMegamind");
		}
		
		if(event.getActionCommand().equals("Romance")) {
			for(int i = 0; i < movieArray.size(); i++) {
				panel.remove(movieArray.get(i).getMovieTitle());
				panel.remove(movieArray.get(i).getMovieImage());
			}
			for(int i = 0; i < movieArray.size(); i++) {
				if(movieArray.get(i).getGenre().equals("Romance")) {
					panel.add(movieArray.get(i).getMovieTitle());
					panel.add(movieArray.get(i).getMovieImage());
				}
			}
			//movies.setText("The Pricess Bride \t \t \nCinderella");
		}
		
		if(event.getActionCommand().equals("Sci-Fi")) {
			for(int i = 0; i < movieArray.size(); i++) {
				panel.remove(movieArray.get(i).getMovieTitle());
				panel.remove(movieArray.get(i).getMovieImage());
			}
			for(int i = 0; i < movieArray.size(); i++) {
				if(movieArray.get(i).getGenre().equals("Sci-Fi")) {
					panel.add(movieArray.get(i).getMovieTitle());
					panel.add(movieArray.get(i).getMovieImage());
				}
			}
			//movies.setText("The Martian \t \t \nEnder's Game");
		}
		
		if(event.getActionCommand().equals("Mystery")) {
			for(int i = 0; i < movieArray.size(); i++) {
				panel.remove(movieArray.get(i).getMovieTitle());
				panel.remove(movieArray.get(i).getMovieImage());
			}
			for(int i = 0; i < movieArray.size(); i++) {
				if(movieArray.get(i).getGenre().equals("Mystery")) {
					panel.add(movieArray.get(i).getMovieTitle());
					panel.add(movieArray.get(i).getMovieImage());
				}
			}
			//movies.setText("The Hound of the Baskerville \t \t \nA Study in Scarlet");
		}
		
		if(event.getActionCommand().equals("Feel-Good")) {
			for(int i = 0; i < movieArray.size(); i++) {
				panel.remove(movieArray.get(i).getMovieTitle());
				panel.remove(movieArray.get(i).getMovieImage());
			}
			for(int i = 0; i < movieArray.size(); i++) {
				if(movieArray.get(i).getGenre().equals("Feel-Good")) {
					panel.add(movieArray.get(i).getMovieTitle());
					panel.add(movieArray.get(i).getMovieImage());
				}
			}
			//movies.setText("Zootopia \t \t \nRatatouille");
		}
		
		//
	}

	/**
	 * 
	 * @param args sets the new ColorFrame visible 
	 */
	public static void main(String[] args)
	{
		MovieAppInterface color = new MovieAppInterface();
		color.setVisible (true);
	}
}
