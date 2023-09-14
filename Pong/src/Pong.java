import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Pong extends Frame {
	
	//movement for the ball
	int speedX = 10, speedY = 10;
	
	//positioning for the ball
	int ballX = 711, ballY = 431, ballW = 20;
	
	//left paddle variables
	int lpX = 70, lpY = 365;
	
	
	//right paddle
	int rpX = 1352, rpY = 365;
	
	//paddle height & width
	int pW = 20, pH = 175;
	

	//score
	int pS1 = 0;
	int pS2 = 0;
	
	//ball color & paddle color
	Color ballColor = (Color.RED);
	Color pColor = (Color.BLACK);
	
	
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		
	//background
		g.setColor (new Color(96,185,34));
		g.fillRect(0, 0, 1440, 900); //draw a rectangle roughly the size of the frame
		
		
	//left paddle
		g.setColor(Color.WHITE);
		g.fillRect(lpX, lpY, pW, pH);
	
	//right paddle
		g.setColor(Color.WHITE);
		g.fillRect(rpX, rpY, pW, pH);
		
	
//field design
		
	//center circle
	g.setColor(Color.WHITE);
	g.drawOval(645, 370, 150, 150); 
	
	//center dot
	g.setColor(Color.WHITE);
	g.fillOval(717, 440, 8, 8); 
	
	//mid line
	g.fillRect(720, 50, 2, 800); 
	
	//touch line
	g.fillRect(100, 50, 1240, 2); //top
	g.fillRect(100, 850, 1240, 2); //bottom
	
	//goal line
	g.fillRect(100, 50, 2, 800); //left 
	g.fillRect(1340, 50, 2, 800); //right
	
	//goal area
	g.fillRect(100, 350, 60, 2); //left top
	g.fillRect(100, 550, 60, 2); //left bottom
	g.fillRect(160, 350, 2, 202); //left right
	g.fillRect(1280, 350, 60, 2); //right top
	g.fillRect(1280, 550, 60, 2); //right bottom
	g.fillRect(1280, 350, 2, 202); //right left
	
	//penalty area
	g.fillRect(100, 215, 175, 2); //left top
	g.fillRect(100, 685, 175, 2); //left bottom
	g.fillRect(275, 215, 2, 470); //left right
	g.fillRect(1165, 215, 175, 2); //right top
	g.fillRect(1165, 685, 175, 2); //right bottom
	g.fillRect(1165, 215, 2, 470); //right right
	
	//penalty dot
	g.fillOval(215, 440, 8, 8); //left 
	g.fillOval(1220, 440, 8, 8); //right
	
	//corner arc
	g.drawArc(52, 2, 100, 100, 270, 90); //top left
	g.drawArc(52, 800, 100, 100, 0, 90); // bottom left
	g.drawArc(1290, 2, 100, 100, 180, 90); //top right
	g.drawArc(1290, 800, 100, 100, 90, 90); // bottom right
	
	
	
	//scoring text
		Font biggerFont = new Font("Permanent Marker", Font.ITALIC, 88);
		
		g.setFont(biggerFont);
	
	//left side score
		g.setColor(Color.WHITE);
		g.drawString(""+pS1, 474, 90);
	
	//right side score
		g.setColor(Color.WHITE);
		g.drawString(""+pS2, 900, 90);
		


	//paint the pong ball
		g.setColor(ballColor);
		g.fillOval(ballX, ballY, ballW, ballW);
		
	
	
			
		ballX += speedX; //can also be written as "ballX = ballX + speedX"
		ballY += speedY;
	
	
	//ceiling & ground bounce
		if(ballY > 875) {
		speedY = -speedY;
		}
	
		if(ballY < 0) {
		speedY = -speedY;
		}
		
	//left paddle collision
		if(ballX >= lpX  && ballX <= (lpX + pW)
			&& ballY >= lpY && ballY <= lpY + pH) {
			System.out.println(speedX);
			speedX = (int)(-speedX * 1.25);
			System.out.println(speedX);
		}
		
	
	//right paddle collision
		if(ballX + ballW >= rpX && ballX <= rpX
			&& ballY >= rpY && ballY <= rpY + pH) {
			System.out.println(speedX);
			speedX = (int) (-speedX * 1.25);
			System.out.println(speedX);
		
		}
		
		//ball reset
		if(ballX >= 1400) {
		
			pS1++;
		
			ballX = 711;
			ballY = 431;
		
			speedX = (int)(Math.random()*(11-3+1))+3;
			System.out.println(speedX);
			if(Math.random() < .75 ) {
				speedX *= -1;
			
			}
		
			speedY = (int)(Math.random()*(11-3+1))+3;
			System.out.println(speedY);
			if(Math.random() < .75) {
				speedY *= -1;
				}
		
			}
	
			else if(ballX <= 0) {
		
				pS2++;
		
				ballX = 711;
				ballY = 431;
		
				speedX = (int)(Math.random()*(11-3+1))+3;
				if(Math.random() < .75 ) {
					speedX *= -1;
				}
			
				speedY = (int)(Math.random()*(11-3+1))+3;
				if(Math.random() < .75) {
					speedY *= -1;
				}
			}
	}

	
	

	public void keyPressed(KeyEvent key) {
		System.out.println(key.getKeyCode());
	
	//up & down
		if(key.getKeyCode() == 83) {
			lpY += 100;
		}
			if (lpY > 900) { 
				lpY = 365;
			}
		
		if(key.getKeyCode()== 87) {
            lpY -= 100; 
		}
			if(lpY < -200) {
			   lpY = 365;
			}
			
        if(key.getKeyCode()== 38) {
            rpY -= 100; 
        }
        
        	if(rpY < -200) {
        	   rpY = 365;
        	}
        	
        if(key.getKeyCode()== 40) {
            rpY += 100; 
        }
        
        	if(rpY > 900) {
        	   rpY = 365;
        	}
        	//left & right
            if(key.getKeyCode() == 68) {
        		lpX += 100;
            }
            
        		if (lpX > 720) { 
        			lpX = 70;
        		}			
        		
        	if(key.getKeyCode()== 65) {
        		lpX -= 100; 
        	}
        		if(lpX < 70) {
        		   lpX = 70;
        		}
        			
            if(key.getKeyCode()== 37) {
            	rpX -= 100; 
            }
                if(rpX < 720) {
                	rpX = 1352;
                }
                	
            if(key.getKeyCode()== 39) {
            	rpX += 100; 
            }
            	if(rpX > 1440) {
            	   rpX = 1352;
                }          	
            if(key.getKeyCode()== 32) {
            		speedX = 0;
            		speedY = 0;
            	
            	}else if(key.getKeyCode()== 77) {
            		speedX = 4;
            		speedY = 4;
            		
                
            
            	}
            }
	



	public void keyReleased(KeyEvent arg0) {
		
		
	}


	public void keyTyped(KeyEvent arg0) {
		
		
	}
	public static void main(String[] arg) {
		Pong p = new Pong();
	}
	
}
