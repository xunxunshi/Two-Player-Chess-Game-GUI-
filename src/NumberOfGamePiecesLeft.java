import javax.swing.JButton;

public class NumberOfGamePiecesLeft 
{
	private ChessGUI a;
	private JButton chessBoard [];
	 
	public NumberOfGamePiecesLeft(ChessGUI c)
	{
		a = c;
		 
		chessBoard = a.getGameBoard(); 
	}
	public int getNumberOfButtons(  String gamePieceName, boolean ifCheckingForBlackPiece)
	{
		int totalNumOfGamePiece=0;
		for (int x=0;x<64;x++)
		{
			String nameOfButton = chessBoard[x].getName().toLowerCase();
		
			if (ifCheckingForBlackPiece)
			{
				if (nameOfButton.contains(gamePieceName)&&(chessBoard[x].getActionCommand().equals("black")))
				{
					totalNumOfGamePiece++;
				}
			}
			else
			{
				if (nameOfButton.contains(gamePieceName)&&(chessBoard[x].getActionCommand().equals("white")))
				{
					totalNumOfGamePiece++;
				}
				
			}
 
		
		}
		return totalNumOfGamePiece;
	}
	
 
}
