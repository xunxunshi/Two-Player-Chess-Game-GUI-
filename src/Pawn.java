import java.awt.Font;

import javax.swing.JButton;


public class Pawn 
{

	private ChessGUI a;
	private JButton chessBoard [];
	private int buttonNum; 
	private String possibleGameMoves;
	private int numOfMoves;// this is needed because the  pawn can move two spaces on first turn
	private boolean ifBlack;// this is needed to keep track of direction since this game piece will have two different directions since it can only go straight , 
							// towards the opponents game pieces
	public Pawn(ChessGUI c)
	{
		a = c;
		buttonNum=a.getButtonNumber();
		chessBoard = a.getGameBoard();
	
		numOfMoves=a.getNumOfMoves();
		ifBlack=a.getIfBlack();
		 possibleGameMoves="";
		 
	}
	private void checkForUp()
	{
		 
		if(chessBoard[buttonNum-8].getName().contains("ngp"))
		{
			chessBoard[buttonNum-8].setName(".");
			chessBoard[buttonNum-8].addActionListener(a);
			if (possibleGameMoves.length()==0)
			{
				possibleGameMoves+=a.getButtonLocation(buttonNum-8)+"";
			}
			else
			{
				possibleGameMoves+=","+a.getButtonLocation(buttonNum-8)  ;
			}
			 System.out.println("POSSIBLE GAME MOVES"+possibleGameMoves);
		
		}
		if (numOfMoves==0)
		{
			chessBoard[buttonNum-16].setName(".");
			chessBoard[buttonNum-16].addActionListener(a);
			if (possibleGameMoves.length()==0)
			{
				possibleGameMoves+=a.getButtonLocation(buttonNum-16)+"";
			}
			else
			{
				possibleGameMoves+=","+a.getButtonLocation(buttonNum-16)  ;
			}
		}
	}
	private void checkForDown()
	{ 
		 
		if(chessBoard[buttonNum+8].getName().contains("ngp"))
		{
			chessBoard[buttonNum+8].setName(".");
			chessBoard[buttonNum+8].addActionListener(a);
		
			if (possibleGameMoves.length()==0)
			{
				possibleGameMoves+=a.getButtonLocation(buttonNum+8)+"";
			}
			else
			{
				possibleGameMoves+=","+a.getButtonLocation(buttonNum+8)  ;
			}
			// the first time the pawn can go up to two spaces ahead
			// numOfMoves must equal to 1 because since it goes down it must be white's turn
			// since the first turn is black 
			if (numOfMoves==1)
			{
				chessBoard[buttonNum+16].setName(".");
				chessBoard[buttonNum+16].addActionListener(a);
				if (possibleGameMoves.length()==0)
				{
					possibleGameMoves+=a.getButtonLocation(buttonNum+16)+"";
				}
				else
				{
					possibleGameMoves+=","+a.getButtonLocation(buttonNum+16)  ;
				}
			}
		}
	}
	private void checkForUpRightAte()
	{	
		
		if (!chessBoard[buttonNum-7].getName().equals("ngp")&&(!chessBoard[buttonNum-7].getActionCommand().equals(chessBoard[buttonNum].getActionCommand())))
		{
			chessBoard[buttonNum-7].setName(chessBoard[buttonNum-7].getName()+".");
			chessBoard[buttonNum-7].addActionListener(a);
	
			if (possibleGameMoves.length()==0)
			{
				possibleGameMoves+=a.getButtonLocation(buttonNum-7)+"";
			}
			else
			{
				possibleGameMoves+=","+a.getButtonLocation(buttonNum-7)  ;
			}
		}
		
	}
	private  void checkForUpLeftAte()
	{
		if (!chessBoard[buttonNum-9].getName().equals("ngp")&&(!chessBoard[buttonNum-9].getActionCommand().equals(chessBoard[buttonNum].getActionCommand())))
		{ 	
			chessBoard[buttonNum-9].setName(chessBoard[buttonNum-9].getName()+".");
			chessBoard[buttonNum-9].addActionListener(a);
			if (possibleGameMoves.length()==0)
			{
				possibleGameMoves+=a.getButtonLocation(buttonNum-9)+"";
			}
			else
			{
				possibleGameMoves+=","+a.getButtonLocation(buttonNum-9)  ;
			}
			
		}
	}
	private void checkForDownRightAte()
	{
		if (!chessBoard[buttonNum+9].getName().equals("ngp")&&(!chessBoard[buttonNum+9].getActionCommand().equals(chessBoard[buttonNum].getActionCommand())))
		{
			chessBoard[buttonNum+9].setName(chessBoard[buttonNum+9].getName()+".");
			chessBoard[buttonNum+9].addActionListener(a);
			if (possibleGameMoves.length()==0)
			{
				possibleGameMoves+=a.getButtonLocation(buttonNum+9)+"";
			}
			else
			{
				possibleGameMoves+=","+a.getButtonLocation(buttonNum+9)  ;
			}
		}
	}
	private void checkForDownLeftAte()
	{
		if (!chessBoard[buttonNum+7].getName().equals("ngp")&&(!chessBoard[buttonNum+7].getActionCommand().equals(chessBoard[buttonNum].getActionCommand())))
		{
			chessBoard[buttonNum+7].setName(chessBoard[buttonNum+7].getName()+".");
			chessBoard[buttonNum+7].addActionListener(a);
			if (possibleGameMoves.length()==0)
			{
				possibleGameMoves+=a.getButtonLocation(buttonNum+7)+"";
			}
			else
			{
				possibleGameMoves+=","+a.getButtonLocation(buttonNum+7)  ;
			}
			
		}
	}
	public void checkForPath()
	{ 
		Font font1=new Font("Georgia", Font.PLAIN , 18);
			if ( ifBlack)
			{
				
				// scenarios such as if pawn is on the last  row , do not need to be considered because it is not possible
				// since that pawn only goes straight forward and it starts off at the 7th row  (for black)
				 // it is also not possible for the pawn to be at the first row because as soon at it hits to the first row it becomes a queen
						  if ( buttonNum%8==0)
						{
							 
							checkForUp();
							checkForUpRightAte();
						 
						}
						else if ( buttonNum%8==7)
						{
								checkForUp();		 
								checkForUpLeftAte();
						}
					else 
					{
						checkForUp();
						checkForUpRightAte();
						checkForUpLeftAte();
					}
						 
			}
			else //ifBlack==false 
			{
				
					// scenarios such as if pawn is on the first row , do not need to be considered because it is not possible
					// since that pawn only goes straight forward and it starts off at the second row  (for white)
					 // it is also not possible for the pawn to be at the last row because as soon at it hits to the last row it becomes a queen 
				if ( buttonNum%8==0)
				{	 
					checkForDown();
					checkForDownRightAte();	
				}
				else if ( buttonNum%8==7)
				{
					checkForDown();		 
					checkForDownLeftAte();
				}
				 
				else 
				{ 
					checkForDown();
					checkForDownRightAte();
					checkForDownLeftAte();
				}
				
			}
			if (possibleGameMoves.length()!=0)
			{
				if (numOfMoves==0 || numOfMoves==1)
				{
					if (ifBlack)
					{
						a.setMoveablePlace (" black  pawn can move to "+possibleGameMoves+". It can move up to these two places because it is "+ a.firstPlayerName()+"'s first turn. ");
					}
					else
					{
						a.setMoveablePlace (" white pawn can move to "+possibleGameMoves+". It can move up to these two places because it is "+ a.secondPlayerName()+"'s first turn. ");
					}
					
				}
				else
				{
					a.setMoveablePlace ( chessBoard[buttonNum].getActionCommand()+"  pawn can move to "+possibleGameMoves);
				}
				
			}
			else
			{
				a.setMoveablePlace ( chessBoard[buttonNum].getActionCommand()+"  pawn can't be moved because because other game piece is blocking it's path." );
			}
			
			
			  a.resetButtonImage();
		a.setGameBoard(chessBoard);
	
	}
	 
}



