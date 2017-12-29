import javax.swing.JButton;


public class Bishop
{
	private ChessGUI a;
	private int buttonNum;
	private JButton chessBoard [];
	private boolean ifBlack;
	private String possibleGameMoves;
	public Bishop(ChessGUI c)
	{
		a = c;
		ifBlack=a.getIfBlack();
		buttonNum=a.getButtonNumber();
		chessBoard = a.getGameBoard();
		possibleGameMoves= "";
	}
	
	private void determineIfPossibleMove ( int num)
	{
		if (possibleGameMoves.length()==0)
		{
			possibleGameMoves+=a.getButtonLocation(num)+"";
		}
		else
		{
			possibleGameMoves+=","+a.getButtonLocation(num)  ;
		}
			
	}
	 private void checkForUpRight()
	 {
		 int y = buttonNum;
		 while (  (y%8!=7)&&(y>7))
		{
			 if(chessBoard[y-7].getName().contains("ngp"))
			{
				 chessBoard[y-7].setName( ".");
				chessBoard[y-7].addActionListener(a);
				determineIfPossibleMove ( y-7);
				y-=7;
			}
			 else 
			 {
				 break;
			 }
		}
		
		 if (( y %8!=7)&&(y>7)&&(!chessBoard[y-7].getActionCommand().equals(chessBoard[buttonNum].getActionCommand())))
			{ 
			 determineIfPossibleMove ( y-7);
					chessBoard[y-7].setName(chessBoard[y-7].getName()+".");
					chessBoard[y-7].addActionListener(a);
				 
			}
			
	}
	 private void checkForUpLeft()
	 {
		 int y = buttonNum;
		 while ( (y%8!=0)&&(y>7))
		{
			 if (chessBoard[y-9].getName().contains("ngp"))
			 {
				chessBoard[y-9].setName( ".");
				chessBoard[y-9].addActionListener(a);
				determineIfPossibleMove ( y-9);
				y-=9;
			 }
			 else
			 {
				 break;
			 }
			 
		}
		 if (( y%8!=0)&&( y >7)&&(!chessBoard[y-9 ].getActionCommand().equals(chessBoard[buttonNum].getActionCommand())))
			{ 
			 determineIfPossibleMove ( y-9);
					chessBoard[y-9].setName(chessBoard[y-9 ].getName()+".");
					chessBoard[y-9].addActionListener(a);
				 
			}
	 }
	 private void checkForDownRight()
		{ 
		 int y = buttonNum;
		 while (  (y%8!=7)&&(y<56))
		 {
			 if ((chessBoard[y+9].getName().contains("ngp")))
			 {
				chessBoard[y+9].setName( ".");
				chessBoard[y+9].addActionListener(a);
				determineIfPossibleMove ( y+9);
				y+=9;
			 }
			 else 
			 {
				 break;
			 }
			 
		 }
		 if (( y %8!=7)&&( y <56)&&(!chessBoard[y+9 ].getActionCommand().equals(chessBoard[buttonNum].getActionCommand())))
			{  
			 determineIfPossibleMove ( y+9);
					chessBoard[y+9].setName(chessBoard[y+9 ].getName()+".");
					chessBoard[y+9 ].addActionListener(a);
				 
			}
			  
	 }
	 private void checkForDownLeft()
	 {
		 int y = buttonNum;
		 while ( (y%8!=0)&&(y<56))
		{
			 if (chessBoard[y+7].getName().contains("ngp"))
			 {
				 determineIfPossibleMove ( y+7);
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
			 	determineIfPossibleMove ( y+7);
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
				 
			}
			else if (buttonNum==7)
			{
				checkForDownLeft();
			}
			else if (buttonNum==56)
			{
				checkForUpRight();
			}
			else if (buttonNum==63)
			{
				checkForUpLeft();
				
			}
			else if ( buttonNum%8==0)
			{
				checkForUpRight();
				checkForDownRight();
			}
			else if ( buttonNum%8==7)
			{
				checkForUpLeft();
				checkForDownLeft();
			}
			else 	if (buttonNum>0&&buttonNum< 7)
			{
				checkForDownRight();
				checkForDownLeft();
			}
			else 	if (buttonNum> 56&&buttonNum< 63)
			{
				checkForUpRight();
				checkForUpLeft();
			}
		}
		else 
		{
			checkForUpRight();
			checkForUpLeft();
			checkForDownRight();
			checkForDownLeft();
		}
 
	 
		 if (possibleGameMoves.length()!=0)
		 {
			 a.setMoveablePlace ( chessBoard[buttonNum].getActionCommand()+ " bishop can move to "+possibleGameMoves);
		 }
	 
		 else
		 {
			 a.setMoveablePlace ( chessBoard[buttonNum].getActionCommand()+" bishop can not be moved because other game piece are blocking it's path." );
	
		 }
	 
	  a.resetButtonImage();
			a.setGameBoard(chessBoard);
	 }
	 
	 
}
