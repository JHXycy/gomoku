package finalProject;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;




public class showgui extends JFrame  implements setting {
	private int[][] newArray = new int[line+2][line+2]; 
	
	Image img = Toolkit.getDefaultToolkit().getImage("C:\\Users\\justi\\Desktop");
	//set the background img
	//public showgui() throws IOException {
		//set the background picture of GUi
		//this.setContentPane (new JPanel());
		
		
				
	//}
	
	
	
	
	
	
	public void showgui () {
		JPanel panel=new JPanel();
		JFrame frame = new JFrame();

		
		// menu bar to exit the file;
		JMenuBar menuBar = new JMenuBar();     
	      frame.setJMenuBar(menuBar);
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener((e) -> System.exit(0));
		fileMenu.add(exitItem);
		frame.setSize(300,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
	
		
		FlowLayout layout=new FlowLayout(10,10,60);
		panel.setLayout(layout);
		Dimension d=new Dimension(120,0);
		panel.setPreferredSize(d);
		
		//make a title
		frame.setTitle("five in a row");
		frame.setSize(800, 700);
		
		frame.setDefaultCloseOperation(3);
		
		frame.setLocationRelativeTo(null);
		playpanel playpanel = new playpanel(newArray);
		
		frame.add(playpanel,BorderLayout.CENTER);
		frame.add(panel,BorderLayout.EAST);
		
		
		
		
		
		//start
		JButton j1=new JButton("start");
		Dimension d1=new Dimension(100,60);
		j1.setPreferredSize(d1);
		panel.add(j1);
		
		//player vs player
		JButton j2=new JButton("players");
		Dimension d2=new Dimension(100,60);
		j2.setPreferredSize(d2);
		panel.add(j2);
		
		//computer against me 
		JButton j3=new JButton("computer");
		Dimension d3=new Dimension(100,60);
		j3.setPreferredSize(d3);
		panel.add(j3);
		
		// regret
		JButton j4=new JButton("regret");
		Dimension d4=new Dimension(100,60);
		j4.setPreferredSize(d4);
		panel.add(j4);
		
		//restart
		JButton j5=new JButton("restart");
		Dimension d5=new Dimension(100,60);
		j5.setPreferredSize(d5);
		panel.add(j5);
		frame.setVisible(true);
		
		Graphics g = playpanel.getGraphics();
		mouse mouse = new mouse(g,newArray,playpanel);
		
		j1.addActionListener(mouse);
		j2.addActionListener(mouse);
		j3.addActionListener(mouse);
		j4.addActionListener(mouse);
		j5.addActionListener(mouse);
	
	
	}

	public static void main(String[] args) {
		showgui gui = new showgui();
		gui.showgui();
	}



}
