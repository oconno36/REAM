import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;

public class UserInterface extends JFrame implements ActionListener
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
	/**
	 * constructor creates all components of a ColorFrame 
	 */
	public UserInterface()
	{
	but1 = new JButton("Movies");
	but1.addActionListener(this);
	but2= new JButton("Genres");
	but2.addActionListener(this);
	but3 = new JButton("Profile");
	but3.addActionListener(this);
	gBut4 = new JButton("Horror");
	gBut5 = new JButton("Comedy");
	gBut6 = new JButton("Romance");
	gBut7 = new JButton("Drama");
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
	public void actionPerformed(ActionEvent event) 
	{ 
		if(event.getActionCommand().equals("Movies"))
			// panel.setBackground(Color.RED);
			prompt.setText("This is a list of movies");
			panel.add(prompt);
		if(event.getActionCommand().equals("Genres"))
			prompt.setText("This is a list of genres");
			panel.add(prompt);
			panel.add(gBut4);
			panel.add(gBut5);
			panel.add(gBut6);
			panel.add(gBut7);
			panel.add(gBut8);
			panel.add(gBut9);
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
		UserInterface color = new UserInterface();
		
		color.setVisible (true);
	}
}
