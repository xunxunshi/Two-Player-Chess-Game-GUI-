import javax.swing.JButton;


public class Queen
{
	private ChessGUI a;
	private int buttonNum;
	private JButton chessBoard [];
	private boolean ifBlack;
	private String possibleGameMoves;
	public Queen(ChessGUI c)
	{
		
		a = c;
		buttonNum=a.getButtonNumber();
		chessBoard = a.getGameBoard();
		possibleGameMoves="";
		ifBlack=a.getIfBlack();
	}
	private void checkForUp()
	{
		
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
		// check for up buttons 
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
		// check for up buttons 
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
					if (possibleGameMoves.length()==0)
					{
						possibleGameMoves+=a.getButtonLocation(y+1)+"";
					}
					else
					{
						possibleGameMoves+=","+a.getButtonLocation(y+1)  ;
					}
						chessBoard[y+1].setName(chessBoard[y+1].getName()+".");
						chessBoard[y+1].addActionListener(a);
				}
	}
	private void checkForLeft()
	{
		// check for up buttons 
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
					if (possibleGameMoves.length()==0)
					{
						possibleGameMoves+=a.getButtonLocation(y-1)+"";
					}
					else
					{
						possibleGameMoves+=","+a.getButtonLocation(y-1)  ;
					}
						chessBoard[y-1].setName(chessBoard[y-1].getName()+".");
						chessBoard[y-1].addActionListener(a);
					
					 
				}
	}
	 private void checkForUpRight()
	 {
		 int y = buttonNum;
		 while (  (y%8!=7)&&(y>7))
		{
			 if(chessBoard[y-7].getName().equalsIgnoreCase("ngp"))
			{
				 chessBoard[y-7].setName( ".");
				chessBoard[y-7].addActionListener(a);
				if (possibleGameMoves.length()==0)
				{
					possibleGameMoves+=a.getButtonLocation(y-7)+"";
				}
				else
				{
					possibleGameMoves+=","+a.getButtonLocation(y-7)  ;
				}
				y-=7;
			}
			 else 
			 {
				 break;
			 }
		}
		
		 if (( y %8!=7)&&(y>7)&&(!chessBoard[y-7].getActionCommand().equals(chessBoard[buttonNum].getActionCommand())))
			{ 
			 if (possibleGameMoves.length()==0)
				{
					possibleGameMoves+=a.getButtonLocation(y-7)+"";
				}
				else
				{
					possibleGameMoves+=","+a.getButtonLocation(y-7)  ;
				}
					chessBoard[y-7].setName(chessBoard[y-7].getName()+".");
					chessBoard[y-7].addActionListener(a);
					 
			}
			
	}
	 private void checkForUpLeft()
	 {
		 int y = buttonNum;
		 while ( (y%8!=0)&&(y>7))
		{
			 if (chessBoard[y-9].getName().equalsIgnoreCase("ngp"))
			 {if (possibleGameMoves.length()==0)
				{
					possibleGameMoves+=a.getButtonLocation(y-9)+"";
				}
				else
				{
					possibleGameMoves+=","+a.getButtonLocation(y-9)  ;
				}
				chessBoard[y-9].setName( ".");
				chessBoard[y-9].addActionListener(a);
				 
				y-=9;
			 }
			 else
			 {
				 break;
			 }
		}
		 if (( y%8!=0)&&( y >7)&&(!chessBoard[y-9 ].getActionCommand().equals(chessBoard[buttonNum].getActionCommand())))
			{  
			 	if (possibleGameMoves.length()==0)
				{
					possibleGameMoves+=a.getButtonLocation(y-9)+"";
				}
				else
				{
					possibleGameMoves+=","+a.getButtonLocation(y-9)  ;
				}
					chessBoard[y-9].setName(chessBoard[y-9 ].getName()+".");
					chessBoard[y-9].addActionListener(a);
					 
			}
	 }
	 private void checkForDownRight()
		{ 
		 int y = buttonNum;
		 while (  (y%8!=7)&&(y<56))
		 {
			 if ((chessBoard[y+9].getName().equalsIgnoreCase("ngp")))
			 {
				chessBoard[y+9].setName( ".");
				chessBoard[y+9].addActionListener(a);
				if (possibleGameMoves.length()==0)
				{
					possibleGameMoves+=a.getButtonLocation(y+9)+"";
				}
				else
				{
					possibleGameMoves+=","+a.getButtonLocation(y+9)  ;
				}
				y+=9;
			 }
			 else 
			 {
				 break;
			 }
		 }
		 if (( y %8!=7)&&( y <56)&&(!chessBoard[y+9 ].getActionCommand().equals(chessBoard[buttonNum].getActionCommand())))
			{  
			 if (possibleGameMoves.length()==0)
				{
					possibleGameMoves+=a.getButtonLocation(y+9)+"";
				}
				else
				{
					possibleGameMoves+=","+a.getButtonLocation(y+9)  ;
				}
					chessBoard[y+9].setName(chessBoard[y+9 ].getName()+".");
					chessBoard[y+9 ].addActionListener(a);
					  
			}
			  
	 }
	 private void checkForDownLeft()
	 {
		 int y = buttonNum;
		 while ( (y%8!=0)&&(y<56))
		{
			 if (chessBoard[y+7].getName().equalsIgnoreCase("ngp"))
			 {
				 if (possibleGameMoves.length()==0)
					{
						possibleGameMoves+=a.getButtonLocation(y+7)+"";
					}
					else
					{
						possibleGameMoves+=","+a.getButtonLocation(y+7)  ;
					}
				 	chessBoard[y+7].setName( ".");
				 	chessBoard[y+7].addActionListener(a);
				 	 
				 	y+=7;
			 }
			 else 
			 {
				 break;
			 }
		
		}
		 if ((y %8!=0)&&( y  <56)&&(!chessBoard[y+7 ].getActionCommand().equals(chessBoard[buttonNum].getActionCommand())))
			{ 
			 if (possibleGameMoves.length()==0)
				{
					possibleGameMoves+=a.getButtonLocation(y+7)+"";
				}
				else
				{
					possibleGameMoves+=","+a.getButtonLocation(y+7)  ;
				}
					chessBoard[y+7].setName(chessBoard[y+7].getName()+".");
					chessBoard[y+7].addActionListener(a);
					 
			}
	 }
	 public void checkForPath()
	 {if ((buttonNum%8==0)||(buttonNum%8==7)||(buttonNum>=0&&buttonNum<=7)||(buttonNum>=56&&buttonNum<=63))
		{
			 
			if (buttonNum==0)
			{
				checkForDownRight();
				checkForRight();
				checkForDown();
				 
			}
			else if (buttonNum==7)
			{
				checkForDownLeft();
				checkForLeft();
				checkForDown();
			}
			else if (buttonNum==56)
			{
				checkForUpRight();
				checkForUp();
				checkForRight();
				
			}
			else if (buttonNum==63)
			{
				checkForUpLeft();
				checkForUp();
				checkForLeft();
				
			}
			else if ( buttonNum%8==0)
			{
				checkForUpRight();
				checkForDownRight();
				checkForRight();
				checkForUp();
				checkForDown();
			}
			else if ( buttonNum%8==7)
			{
				checkForUpLeft();
				checkForDownLeft();
				checkForLeft();
				checkForUp();
				checkForDown();
			}
			else 	if (buttonNum>0&&buttonNum< 7)
			{
				checkForDownRight();
				checkForDownLeft();
				checkForDown();
				checkForLeft();
				checkForRight();
			}
			else 	if (buttonNum> 56&&buttonNum< 63)
			{
				checkForUpRight();
				checkForUpLeft();
				checkForUp();
				checkForLeft();
				checkForRight();
			}
		}
		else 
		{
			checkForUpRight();
			checkForUpLeft();
			checkForDownRight();
			checkForDownLeft();
			checkForUp();
			checkForDown();
			checkForRight();
			checkForLeft();
		}
	 
		 if (possibleGameMoves.length()==0)
		 {
			 a.setMoveablePlace ( chessBoard[buttonNum].getActionCommand()+ " queen not be moved because other game piece are blocking it's path.  " );
		 }
		 else
		 {
			 a.setMoveablePlace ( chessBoard[buttonNum].getActionCommand()+ " queen can move to "+possibleGameMoves);
		 }
	
	  a.resetButtonImage();
			a.setGameBoard(chessBoard);
	 }
	 
	 
}
