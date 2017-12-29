import javax.swing.*;
import java.awt.*;

public class Rook 
{
	ChessGUI a;
	private int buttonNum;
	private JButton chessBoard [];
	private String possibleGameMoves;
	public Rook(ChessGUI c)
	{
		a = c;
		buttonNum=a.getButtonNumber();
		chessBoard = a.getGameBoard();
		possibleGameMoves="";
		
	}
	private void checkForUp()
	{
		// check for up buttons 
		
		int y= buttonNum;
		while (y>7&&chessBoard[y-8].getName().contains("ngp"))
		{
			chessBoard[y-8].setName(".");
			chessBoard[y-8].addActionListener(a);
			if (possibleGameMoves.length()==0)
			{
				possibleGameMoves+=a.getButtonLocation(y-8)+"";
			}
			else
			{
				possibleGameMoves+=","+a.getButtonLocation(y-8)  ;
			}
			y-=8;
		}
		// the below happens after the loop
	
		if ((y>7)&&(!chessBoard[y-8].getActionCommand().equals(chessBoard[buttonNum].getActionCommand()))) 
		{
			 chessBoard[y-8].setName(chessBoard[y-8].getName()+".");
			 chessBoard[y-8].addActionListener(a);
				if (possibleGameMoves.length()==0)
				{
					possibleGameMoves+=a.getButtonLocation(y-8)+"";
				}
				else
				{
					possibleGameMoves+=","+a.getButtonLocation(y-8)  ;
				}
		}
		 
	}
	private void checkForDown()
	{
		// check for down buttons 
		int y= buttonNum;
		while ( y<56 &&chessBoard[y+8].getName().contains("ngp"))
		{
			chessBoard[y+8].setName(".");
			chessBoard[y+8].addActionListener(a);
			 
			if (possibleGameMoves.length()==0)
			{
				possibleGameMoves+=a.getButtonLocation(y+8)+"";
			}
			else
			{
				possibleGameMoves+=","+a.getButtonLocation(y+8)  ;
			}
			y+=8;
		}
		if ((y<56)&& (!chessBoard[y+8].getActionCommand().equals(chessBoard[buttonNum].getActionCommand())))
		{
				chessBoard[y+8].setName(chessBoard[y+8].getName()+".");
				chessBoard[y+8].addActionListener(a);
				if (possibleGameMoves.length()==0)
				{
					possibleGameMoves+=a.getButtonLocation(y+8)+"";
				}
				else
				{
					possibleGameMoves+=","+a.getButtonLocation(y+8)  ;
				}
		
		}
	}
	private void checkForRight()
	{
		// check for right buttons 
			
				int y= buttonNum;
				while (y%8!=7&&chessBoard[y+1].getName().contains("ngp"))
				{	
					chessBoard[y+1].setName(".");
					chessBoard[y+1].addActionListener(a);
					if (possibleGameMoves.length()==0)
					{
						possibleGameMoves+=a.getButtonLocation(y+1)+"";
					}
					else
					{
						possibleGameMoves+=","+a.getButtonLocation(y+1)  ;
					}
					y++;
				}
				if ((y%8!=7)&&(!chessBoard[y+1].getActionCommand().equals(chessBoard[buttonNum].getActionCommand())))
				{
						chessBoard[y+1].setName(chessBoard[y+1].getName()+".");
						chessBoard[y+1].addActionListener(a);
						if (possibleGameMoves.length()==0)
						{
							possibleGameMoves+=a.getButtonLocation(y+1)+"";
						}
						else
						{
							possibleGameMoves+=","+a.getButtonLocation(y+1)  ;
						}
				
				}
	}
	private void checkForLeft()
	{
		// check for left buttons 
				int y= buttonNum;
			 
		
				while ((y%8!=0)&&(chessBoard[y-1].getName().contains("ngp")))
				{
					chessBoard[y-1].setName(".");
					chessBoard[y-1].addActionListener(a);
			 
					if (possibleGameMoves.length()==0)
					{
						possibleGameMoves+=a.getButtonLocation(y-1)+"";
					}
					else
					{
						possibleGameMoves+=","+a.getButtonLocation(y-1)  ;
					}
					y--;
				}
				if ((y%8!=0)&&(!chessBoard[y-1].getActionCommand().equals(chessBoard[buttonNum].getActionCommand())))
				{
						chessBoard[y-1].setName(chessBoard[y-1].getName()+".");
						chessBoard[y-1].addActionListener(a);
						if (possibleGameMoves.length()==0)
						{
							possibleGameMoves+=a.getButtonLocation(y-1)+"";
						}
						else
						{
							possibleGameMoves+=","+a.getButtonLocation(y-1)  ;
						}
			 
				}
			 
	}
	public void checkForPath()
	{
		  
					if ((buttonNum%8==0)||(buttonNum%8==7)||(buttonNum>=0&&buttonNum<=7)||(buttonNum>=56&&buttonNum<=63))
					{
						 
						if (buttonNum==0)
						{
							checkForRight();
							checkForDown();
						}
						else if (buttonNum==7)
						{
							checkForLeft();
							checkForDown();
							 
						}
						else if (buttonNum==56)
						{
							checkForUp();
							checkForRight();
						}
						else if (buttonNum==63)
						{
							checkForUp();
							checkForLeft();
						}
						else if ( buttonNum%8==0)
						{
							checkForRight();
							checkForUp();
							checkForDown();
								
						}
						else if ( buttonNum%8==7)
						{
						 
								checkForLeft();
								checkForUp();
								checkForDown();
						}
						else 	if (buttonNum>0&&buttonNum< 7)
						{
							checkForDown();
							checkForLeft();
							checkForRight();
						}
						else 	if (buttonNum> 56&&buttonNum< 63)
						{
							checkForUp();
							checkForLeft();
							checkForRight();
						}
					}
					else 
					{
						checkForUp();
						checkForDown();
						checkForRight();
						checkForLeft();
					}
					if (possibleGameMoves.length()!=0)
					{
						 a.setMoveablePlace( chessBoard[buttonNum].getActionCommand()+" rook can move to "+possibleGameMoves);
					}
					else
					{
						 a.setMoveablePlace( chessBoard[buttonNum].getActionCommand()+" rook can't be moved because other game pieces are blocking it's path.");
					}
					 
				 
					  a.resetButtonImage();
					a.setGameBoard(chessBoard); 

	}
	 
	 
}

