package finalProject;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class playpanel extends JPanel implements setting {
	// create a 2D array
	private int [][] array;
	
	public playpanel(int[][] array){
		this.array = array;
	}
	
	// draw the line for chessboard
	
	// put chessboard
	public void paintC(Graphics graphic){
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array[i].length;j++){
				if(array[i][j] == 1){
					graphic.setColor(Color.WHITE);
					graphic.fillOval(i * size + xAix - chessSize / 2, j * size + yAix - chessSize / 2, chessSize, chessSize);
				}else if(array[i][j] == -1){
					graphic.setColor(Color.BLACK);
					graphic.fillOval(i * size + xAix - chessSize / 2, j * size + yAix - chessSize / 2, chessSize, chessSize);
				}
			}
		}
	}

	//draw line for board
	public void paint(Graphics graphic){
		super.paint(graphic);
		// line for the board
		for(int i=0;i<line;i++){
			graphic.drawLine(xAix, yAix+i*size, (line-1)*size+xAix, yAix+i*size);
			graphic.drawLine(xAix+i*size, yAix, xAix+i*size, (line-1)*size+yAix);
		}
		paintC(graphic);
	}

	
}
