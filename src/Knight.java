import javax.swing.JButton;


public class Knight
{
	private ChessGUI a;
	private int buttonNum;
	private JButton chessBoard [];
	private boolean ifBlack;
	String movableGamePieces;
 
	public Knight(ChessGUI c)
	{
		a = c;
		buttonNum=a.getButtonNumber();
		chessBoard = a.getGameBoard();
		movableGamePieces="";
		ifBlack= a.getIfBlack();
	}
	private void checkButton(int checkingNum)
	{	 
		if (!chessBoard[checkingNum].getName().equals("ngp")&&(!chessBoard[checkingNum].getActionCommand().equals(chessBoard[buttonNum].getActionCommand())))
		{
			chessBoard[checkingNum].setName(chessBoard[checkingNum].getName()+".");
			chessBoard[checkingNum].addActionListener(a);
			if (movableGamePieces.length()==0)
			{
				movableGamePieces=a.getButtonLocation(checkingNum);
			}
			else
			{
				movableGamePieces+=","+a.getButtonLocation(checkingNum);
			}
		}
		else if (chessBoard[checkingNum].getName().equalsIgnoreCase("ngp")) 
		{

			chessBoard[checkingNum].setName(  ".");
			chessBoard[checkingNum].addActionListener(a);
			if (movableGamePieces.length()==0)
			{
				movableGamePieces=a.getButtonLocation(checkingNum);
			}
			else
			{
				movableGamePieces+=","+a.getButtonLocation(checkingNum);
			}
		
		}
	}
	private void check2Left1Up()
	{
		checkButton(buttonNum-10);
	}
	 private void check2Left1Down()
	 {
		 checkButton(buttonNum+6);
	 
	 }
	 
	 private void check1Left2Up()
	 {
		 checkButton(buttonNum-17);
		 
	 }
	 private void check1Left2Down()
	 {
		 checkButton(buttonNum+15);
 
	 }
	 private void check1Right2Up()
	 {
		 checkButton(buttonNum-15);
	 }
	 private void check1Right2Down()
	 {
		 checkButton(buttonNum+17);
	 }
	 private void check2Right1Up()
	 {
		 checkButton(buttonNum-6);
	 }
	 private void check2Right1Down()
	 {
		 checkButton(buttonNum+10);
	 }
	 public void checkForPath()
	 {	
		 if (buttonNum>47)// last two rows 
		 {
			 if (buttonNum%8==7)// last  column
			 {
				 check2Left1Up();
				 check1Left2Up();
			 }
			 else if (buttonNum%8==6)// second last column
			 {
				 check2Left1Up();
				 check1Left2Up();
				 check1Right2Up();
			 }
			 else if (buttonNum%8==0 )// first  column
			 {
				 check2Right1Up();
				 check1Right2Up();
			 }
			 else if (buttonNum%8==1)// second column
			 {
				 check2Right1Up();
				 check1Right2Up();
				 check1Left2Up(); 
			 }
			 else
			 {
				 check2Left1Up();
				 check1Left2Up();
				 check2Right1Up();
				 check1Right2Up();
			 }
		 }
		 else if (buttonNum<16)// first two row 
		 {
			 if ((buttonNum%8 ==7))// last  column
			 {
				
				 check1Left2Down();
				 check2Left1Down();
			 }
			 if ((buttonNum%8 ==6))// second last   column
			 {
				
				 check1Left2Down();
				 check2Left1Down();
				 check1Right2Down();
			 }
			 else if (buttonNum%8==0)// first column
			 {
				 check2Right1Down();
				 check1Right2Down();
			 }
			 else if (buttonNum%8==1)//second last column
			 {
				 check2Right1Down();
				 check1Right2Down();
				 check1Left2Down();
			 }
			 else
			 {
				 check2Left1Down();
				 check1Left2Down();
				 check2Right1Down();
				 check1Right2Down();
			 }
		 }
		 else if (buttonNum%8==6||buttonNum%8==7)// check for last two columns 
		 {
			 // the buttons on the corner do not need to be considered because they are already considered 
			 // in the scenario of them being in the last/first two rows
			 check2Left1Down();
			 check1Left2Down();
			 check2Left1Up();
			 check1Left2Up();
		 }
		 else if (buttonNum%8==0||buttonNum%8==1)
		 {
			 check2Right1Down();
			 check1Right2Down();
			 check2Right1Up();
			 check1Right2Up();
		 }
		 else// the middle buttons that has been pressed
		 {
			 check2Right1Down();
			 check1Right2Down();
			 check2Right1Up();
			 check1Right2Up();
			 check2Left1Down();
			 check1Left2Down();
			 check2Left1Up();
			 check1Left2Up();
		 }
		 
			 if (movableGamePieces.length()==0)
			 {
				 	 a.setMoveablePlace(chessBoard[buttonNum].getActionCommand()+" Knight can not be moved because other game piece are blocking it's path.   " );
			 }
			 else
			 {
				 a.setMoveablePlace(chessBoard[buttonNum].getActionCommand()+" Knight can move to "+ movableGamePieces);
			 }
 
		 
		  a.resetButtonImage();
		 a.setGameBoard(chessBoard);
	 }
}
