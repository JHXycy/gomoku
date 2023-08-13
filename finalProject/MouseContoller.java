package finalProject;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.HashMap;

import javax.swing.JPanel;
import java.awt.Color;
 
public class MouseContoller extends MouseAdapter implements setting {
	HashMap<String, Integer> map = new HashMap<String, Integer>();
	private JPanel j;
	private Graphics g;
	private int x = 0;
	private int y = 0;
	//for 2D array;
	private int[][] newArray1 = new int[line + 2][line + 2];  
	private int[][] newArray2 = new int[line + 2][line + 2]; 
	

	public  MouseContoller(Graphics g, int[][] newArray1, JPanel j) {
		this.j = j; 
		this.g = g;
		this.newArray1 = newArray1;
		

		map.put("-1", 20);
		map.put("-1-1", 400);
		map.put("-1-1-1", 420);
		map.put("-1-1-1-1", 3000);
		map.put("-11", 4);
		map.put("-1-11", 40);
		map.put("-1-1-11", 400);
		map.put("-1-1-1-11", 10000);
		map.put("1-1-1-1-1", 10000);
		map.put("1", 8);
		map.put("11", 80);
		map.put("111", 1000);
		map.put("1111", 5000);
		map.put("1111-1", 5000);
		map.put("1111-1-1", 5000);
		map.put("1-1", 6);
		map.put("11-1", 60);
		map.put("111-1", 600);
		map.put("-11-1", 5);
		map.put("-111-1", 5);
		map.put("1-1-11", 5);
		map.put("1-11", 5);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void MouseContoller() {
		for (int i = 0; i < line; i++) {
			for (int j = 0; j < line; j++) {
				if (newArray1[i][j] == 0) {
					String str = " ";
					int num = 0;
					
					
					
					
					for (int x = i + 1; x < 15; x++) {
						if (newArray1[Math.abs(x)][j] == 0) {
							break;
						} else {
							if (num == 0) { 
								num = newArray1[Math.abs(x)][j]; 
								str =str + newArray1[Math.abs(x)][j]; 
							} else if (newArray1[Math.abs(x)][j] == num) {
								str= str +newArray1[Math.abs(x)][j]; 
							} else {
								str=str +  newArray1[Math.abs(x)][j]; 
								break;
							}
						}
						if (newArray1[i][j] != 0) {
							newArray2[i][j] = 0;
						}
					}
					Integer ans = map.get(str);
					if (ans != null) {
						newArray2[i][j] += ans;
					}
					if (ans != null) {
						newArray2[i][j] += ans;
					}
			/////////////////////////////////////////////////////////////////////////////////////////////////	
					
					// up
					
					str = "";
					num = 0;
					for (int x = j - 1; x >= 0; x--) {
						if (newArray1[i][Math.abs(x)] == 0) {
							break;
						} else {
							if (num == 0) { 
								num = newArray1[i][Math.abs(x)]; 
								str+= newArray1[i][Math.abs(x)]; 
							} else if (newArray1[i][Math.abs(x)] == num) {
								str += +newArray1[i][Math.abs(x)]; 
							} else {
								str+=newArray1[i][Math.abs(x)]; 
								break;
							}
						}

					}
					ans =map.get(str);
					if (ans != null) {
						newArray2[i][j] += ans;
					}
					if (newArray1[i][j] != 0) {
						newArray2[i][j] = 0;
					}
////////////////////////////////////////////////////////////////////////////////////////////////////					
					// down
					str = " ";
					num = 0;
					for (int x = j + 1; x< line; x++) {
						if (newArray1[i][Math.abs(x)] == 0) {
							break;
						} else {
							if (num == 0) { 
								num = newArray1[i][Math.abs(x)]; 
								str += newArray1[i][Math.abs(x)]; 
							} else if (newArray1[i][Math.abs(x)] == num) {
								str += newArray1[i][Math.abs(x)]; 
							} else {
								str +=newArray1[i][Math.abs(x)]; 
								break;
							}
						}

					}
					ans =map.get(str);
					if (ans != null) {
						newArray2[i][j] += ans;
					}
					if (newArray1[i][j] != 0) {
						newArray2[i][j] = 0;
					}
					
					
					
/////////////////////////////////////////////////////////////////////////////////////////////////////////					
					//left
					str = " ";
					num = 0;
					for (int x = i - 1; x >= 0; x--) {
						if (newArray1[Math.abs(x)][j] == 0) {
							break;
						} else {
							if (num == 0) { 
								num = newArray1[Math.abs(x)][j]; 
								str+= newArray1[Math.abs(x)][j]; 
							} else if (newArray1[Math.abs(x)][j] == num) {
								str += newArray1[Math.abs(x)][j]; 
							} else {
								str+=newArray1[Math.abs(x)][j]; 
								break;
							}
						}

					}
					ans = map.get(str);
					if (ans != null) {
						newArray2[i][j] += ans;
					}
					if (newArray1[i][j] != 0) {
						newArray2[i][j] = 0;
					}
					
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////					
					
					//upper right
					str = " ";
					num = 0;
					for (int x = i + 1, y = j - 1; x < line|| y >= 0; x++, y--) {
						if (newArray1[Math.abs(x)][Math.abs(y)] == 0) {
							break;
						} else {
							if (num == 0) { 
								num = newArray1[Math.abs(x)][Math.abs(y)]; 
								str += newArray1[Math.abs(x)][Math.abs(y)]; 
							} else if (newArray1[Math.abs(x)][Math.abs(y)] == num) {
								str  += newArray1[Math.abs(x)][Math.abs(y)]; 
							} else {
								str  += newArray1[Math.abs(x)][Math.abs(y)]; 
								break;
							}
						}

					}
					ans = map.get(str);
					if (ans != null) {
						newArray2[i][j] += ans;
					}
					if (newArray1[i][j] != 0) {
						newArray2[i][j] = 0;
					}
//////////////////////////////////////////////////////////////////////////////////////////////////////					
					
					//upper left
					str = " ";
					num = 0;
					for (int x = i - 1, y = j - 1; x >= 0 || y >= 0; x--, y--) {
						if (newArray1[Math.abs(x)][Math.abs(y)] == 0) {
							break;
						} else {
							if (num == 0) { 
								num = newArray1[Math.abs(x)][Math.abs(y)]; 
								str += newArray1[Math.abs(x)][Math.abs(y)]; 
							} else if (newArray1[Math.abs(x)][Math.abs(y)] == num) {
								str+=   newArray1[Math.abs(x)][Math.abs(y)]; 
							} else {
								str += newArray1[Math.abs(x)][Math.abs(y)]; 
								break;
							}
						}

					}
					ans = map.get(str);
					if (ans != null) {
						newArray2[i][j] += ans;
					}
					if (newArray1[i][j] != 0) {
						newArray2[i][j] = 0;
					}

					
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////					
					
					
					//right down
					str = " ";
					num = 0;
					for (int x = i + 1, y = j + 1; x < line || y < line; x++, y++) {
						if (newArray1[Math.abs(x)][Math.abs(y)] == 0) {
							break;
						} else {
							if (num == 0) { 
								num = newArray1[Math.abs(x)][Math.abs(y)]; 
								str += newArray1[Math.abs(x)][Math.abs(y)]; 
							} else if (newArray1[Math.abs(x)][Math.abs(y)] == num) {
								str += newArray1[Math.abs(x)][Math.abs(y)]; 
							} else {
								str += newArray1[Math.abs(x)][Math.abs(y)]; 
								break;
							}
						}

					}
					ans = map.get(str);
					if (ans != null) {
						newArray2[i][j] +=ans;
					}
					if (newArray1[i][j] != 0) {
						newArray2[i][j] = 0;
					}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////					
					
					// left downnn
					str = " ";
					num = 0;
					for (int x = i - 1, y = j + 1; x>= 0 || y < line; x--, y++) {
						if (newArray1[Math.abs(x)][Math.abs(y)] == 0) {
							break;
						} else {
							if (num == 0) { 
								num = newArray1[Math.abs(x)][Math.abs(y)]; 
								str+= newArray1[Math.abs(x)][Math.abs(y)]; 
							} else if (newArray1[Math.abs(x)][Math.abs(y)] ==num) {
								str+= newArray1[Math.abs(x)][Math.abs(y)]; 
							} else {
								str += newArray1[Math.abs(x)][Math.abs(y)]; 
								break;
							}
						}

					}
					ans = map.get(str);
					if (ans != null) {
						newArray2[i][j] += ans;
					}
					if (newArray1[i][j] != 0) {
						newArray2[i][j] = 0;
					}
				}
			}
		}
//////////////////////////////////////////////////////////////////////////////////////////
		for (int j = 0; j < line; j++) {
			for (int i = 0; i < line; i++) {
				System.out.print(newArray2[i][j] + "  ");
			}
			System.out.println();
		}
		for (int j = 0; j < line; j++) {
			for (int i = 0; i < line; i++) {
				System.out.print(newArray1[i][j] + "  ");
			}
			System.out.println();
		}
		// 判断权值最大的位置，并在该位置下棋。
		int maxv = 0;
		for (int i = 0; i < line; i++) {
			for (int j = 0; j <line; j++) {
				if (maxv < newArray2[i][j]) {
					maxv = newArray2[i][j];
					x = i;
					y = j;
				}
			}
		}
		//画白棋
		g.setColor(Color.WHITE);
		g.fillOval(x * size + xAix - chessSize / 2,y * size + yAix - chessSize / 2,chessSize, chessSize);
		newArray1[x][y] = 1;
		System.out.println("x" + x + "y" + y);
		for (int i = 0; i < line; i++) {
			for (int j = 0; j < line; j++) {
				newArray2[i][j] = 0;
			}
		}
	}
}
