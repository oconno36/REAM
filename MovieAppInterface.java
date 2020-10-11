import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;

public class ColorFrame extends JFrame implements ActionListener
{
	private JButton but1;
	private JButton but2;
	private JButton but3;
	private JPanel panel;
	JLabel movieList = new JLabel("List of Movies");
	/**
	 * constructor creates all components of a ColorFrame 
	 */
	public ColorFrame()
	{
	but1 = new JButton("Movies");
	but1.addActionListener(this);
	but2= new JButton("Genres");
	but2.addActionListener(this);
	
	
	panel= new JPanel();
	panel.add(but1);
	panel.add(but2);
	//panel.add(but3);
	
	JFrame frame = new JFrame();
	frame.add(panel);
	frame.setSize(300, 400);
	frame.setTitle("Colors");
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
			panel.add(movieList);
		if(event.getActionCommand().equals("Genres"))
			panel.setBackground(Color.GREEN);
		//if(event.getActionCommand().equals("Blue"))
		//	panel.setBackground(Color.BLUE);
			
	}
	
	/**
	 * 
	 * @param args sets the new ColorFrame visible 
	 */
	public static void main(String[] args)
	{
		ColorFrame color = new ColorFrame();
		
		color.setVisible (true);
	}
}
