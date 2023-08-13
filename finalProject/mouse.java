package finalProject;

import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;

public class mouse extends MouseAdapter implements setting, ActionListener { //mouseAdapter for moving and clicking the GUi
	private int x;
	private int y ;
	private int xinter;  //point intersection
	private int yinter; //point intersection
	private int count = 0; 
	private int[][] newArray = new int[line + 2][line + 2]; 
	private JPanel panel;
	private Graphics graphic;
	MouseContoller a;

	
	////yesss
	public void whiteCheeseWIn() {
		JFrame frame = new JFrame();
		FlowLayout layout = new FlowLayout();
		frame.setLayout(layout);
		JLabel label = new JLabel("White cheese Win");
		label.setFont(new Font("Times", 0, 20));
		
		frame.setSize(200, 200);
		frame.add(label);
		
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(3);
		frame.setVisible(true);
	}


	public void blackCheeseWin() {
		JFrame frame = new JFrame();
		FlowLayout layout = new FlowLayout();
		frame.setLayout(layout);
		JLabel label = new JLabel("black chesse win");
		label.setFont(new Font("Times", 0, 20));
		
		
		frame.setSize(200, 200);
		frame.add(label);
		
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(3);
		frame.setVisible(true);
	}

	
	
	public mouse(Graphics graphic, int[][] newArray, JPanel panel) {
		
		this.panel = panel;
		this.graphic = graphic;
		this.newArray = newArray;

	}

	
	
	
	//incline
		public int inclined(int x, int y) {
			int result = 0;
			for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
				if (newArray[i][j] == newArray[x][y]) {
					result++;
					System.out.println(result);
				} else {
					break;
				}
			}
			for (int i = x + 1, j = y + 1; i < line && j < line; i++, j++) {
				if (newArray[i][j] == newArray[x][y]) {
					result++;
				} else {
					break;
				}
			}
			return result;
			
		}
		
		//other way incline
		public int inclined2(int x, int y) {
			int result = 0;
			for (int i = x - 1, j = y + 1; i >= 0 && j < line; i--, j++) {
				if (newArray[i][j] == newArray[x][y]) {
					result++;
				} else {
					break;
				}
			}
			for (int i = x + 1, j = y - 1; i < line && j >= 0; i++, j--) {
				if (newArray[i][j] == newArray[x][y]) {
					result++;
				} else {
					break;
				}
			}
			return result;
		}
		
	
	
	
	
	
	
	
	
	// column
		public int column(int x, int y) {
			int ans = 0;
			for (int i = y + 1; i < 15; i++) {
				if (newArray[x][Math.abs(i)] == newArray[x][y]) {
					ans++;
				} else {
					break;
				}
			}
			
			for (int i = y; i >= 0; i--) {
				if (newArray[x][Math.abs(i)] == newArray[x][y]) {
					ans++;
				} else {
					break;
				}
			}

			return ans;
		}
	
	
	
	
	//row
	public int row(int x, int y) {
		int ans = 0;
		for (int i = x + 1; i < 15; i++) {
			if (newArray[Math.abs(i)][y] == newArray[x][y]) {
				ans++;
				System.out.println(ans);
			} else {
				break;
			}
		}
		for (int i = x; i >= 0; i--) {
			if (newArray[Math.abs(i)][y] == newArray[x][y]) {
				ans++;
			} else {
				break;
			}
		}

		return ans;
	}

	

	 
	
	
	//way to determine if it wins or lose
	public void winner(int x,int y){
		if(inclined(x, y)>=4||inclined2(x,y)>=4||column(x,y)>=5||row(x,y)>=5){
			if(newArray[x][y] == 1){
				whiteCheeseWIn();
			}else if(newArray[x][y] == -1){
				blackCheeseWin();
			}
		}
	}



	public void inter() {
		
		if ((x - xAix) % size > size / 2) {
			xinter = (x - xAix) / size + 1;
		} else {
			xinter = (x - xAix) / size;
		}
		if ((y - yAix) % size > size / 2) {
			yinter = (y - yAix) / size + 1;
		} else {
			yinter = (y - yAix) / size;
		}

		//cheeses will come out one color per time /////
		if (newArray[xinter][yinter] == 0) {
			if (count == 1) {
				graphic.setColor(Color.WHITE);
				newArray[xinter][yinter] = 1;
				count--;
			} else {
				graphic.setColor(Color.BLACK);
				newArray[xinter][yinter] = -1;
				count++;
			}
			
			//winner
			graphic.fillOval(xinter * size + xAix - chessSize / 2 , yinter * size + yAix - chessSize / 2,chessSize, chessSize);
			winner(xinter, yinter);
		}
	}

	public void inter2() {
		//intersection calulation
		if ((x - xAix) % size > size / 2) {
			xinter = (x - xAix) / size + 1;
		} else {
			xinter = (x - xAix) / size;
		}
		if ((y - yAix) % size > size / 2) {
			yinter = (y - yAix) / size + 1;
		} else {
			yinter = (y - yAix) / size;
		}

		if (newArray[xinter][yinter] == 0) {
			graphic.setColor(Color.BLACK);
			newArray[xinter][yinter] = -1;
			graphic.fillOval(xinter * size + xAix - chessSize / 2, yinter * size + yAix- chessSize / 2, chessSize, chessSize);
					
		}

	}
	// need MouseCliked for the event;
	//it has to be stay down; 
	public void mouseClicked(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		if (ans == 1) {
			inter();
		}
		if (ans == 2) {
			inter2();
			winner(xinter, yinter);
			try {
		    	  Thread.sleep(500);
		       }catch(Exception E) {}
			a.MouseContoller();
			winner(a.getX(), a.getY());
			
			
		}

	}


	public int ans;
	public void actionPerformed(ActionEvent e) {
		System.out.println("  " + e.getActionCommand());

		if (e.getActionCommand().equals("start")) {
			panel.addMouseListener(this);
		}
		if (e.getActionCommand().equals("players")) {
			
			ans = 1;
		}
		if (e.getActionCommand().equals("computer")) {
			a = new MouseContoller(graphic, newArray, panel);
			 ans= 2;
		}
		if (e.getActionCommand().equals("regret")) {
			for (int i = 0; i < line; i++) {
				for (int j = 0; j < line; j++) {
					newArray[xinter][yinter] = 0;
					count = 0;
				}
			}
			panel.repaint();

		}
		if (e.getActionCommand().equals("restart")) {
			
			for (int i = 0; i < line; i++) {
				for (int j = 0; j < line; j++) {
					newArray[i][j] = 0;
					count = 0;
				}
			}
			panel.repaint();
		}

	}

}
