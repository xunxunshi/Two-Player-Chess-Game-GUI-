import javax.swing.JButton;
 

public class King 
{
	private ChessGUI a;
	private JButton chessBoard [];
	private int buttonNum; 
	private String movablePieces,unmovablePieces;
	private boolean ifBlack;
	private String unMoveableReason; 
	public King(ChessGUI c)
	{
		a = c;
		buttonNum=a.getButtonNumber();
		chessBoard = a.getGameBoard();
		movablePieces="";
		unMoveableReason="";
		unmovablePieces="";
		ifBlack=a.getIfBlack();
	}
	private void checkButton(int checkingNum)
	{	
		if (checkForIfMovablePiece(checkingNum)==true)
		{
			if (!chessBoard[checkingNum].getName().equalsIgnoreCase("ngp")&&(!chessBoard[checkingNum].getActionCommand().equals(chessBoard[buttonNum].getActionCommand())))
			{
				chessBoard[checkingNum].setName(chessBoard[checkingNum].getName()+".");
				chessBoard[checkingNum].addActionListener(a);
				if (movablePieces.length()== 0 )
				{
					movablePieces+=a.getButtonLocation(checkingNum);
				}
				else
				{
					movablePieces+=", "+a.getButtonLocation(checkingNum);
				}
			}
			else if (chessBoard[checkingNum].getName().equalsIgnoreCase("ngp")) 
			{
				chessBoard[checkingNum].setName(".");
				chessBoard[checkingNum].addActionListener(a);
				if (movablePieces.length()== 0 )
				{
					movablePieces+=a.getButtonLocation(checkingNum);
				}
				else
				{
					movablePieces+=", "+a.getButtonLocation(checkingNum);
				}
			}
		}
		else
		{
			
		}
	}
	/**
	 * this method will check if a game piece is a movable game piece for the king , in other words, it will check if king can move to that game piece altho 
	 * that game piece may be consisted within the surrounding squares of king , it may also not be a movable game piece since that the king can not move
	 * to anywhere ,where it could get eaten  by the opponent 
	 *e.g : if pawn was at two units up and 1 unit to the left of the king, then king can not move up one, because if it moved up one it will get eaten
	 * therefore it must detect if the location of where the pawn can eat will interfere with the king's movable game piece and if it does
	 * then it is require to make that game button disabled
	 * this method will detects backwards and try to find if a single button called checkingNum ( a button that is around the king -- king can go to any space around it self) can be edible 
	 * it will check all vertical, horizontal and diagonal lines that crosses the checkingNum to detect for a  rook, queen and Bishop
	 * then it will check in the shape of a backward L  for knights and backward diagonally for a pawn
	 *  it will also check all the 9 surrounding boxes of the button to see if the another king if nearby and can eat the king 
	 * this method will return a boolean called ifMoveablePiece 
	 * if it detects an opponents game piece that can eat the king if the king was moved to this new location the it would return  false 
	 * and using true or false in the checkButton method, it will make that game button a click-able button or a non click-able button
	 * (false = can not move to that new game location, true = able to move to new location)
	 *
	*  
	 * @param checkingNum
	 * @return ifMovablePiece
	 */
	private boolean checkForIfMovablePiece(int checkingNum)
	{
		
		boolean ifMovablePiece=true;
		unMoveableReason="";// reset the reason to nothing again to detect upon a new button ( 9 buttons to detect)
		//used a boolean instead of directly returning true or false
		// becauuse that after returning a value it would end this loop and it would not name the rest of the reasons why the king can not move to that new location
		// for example, if false is returned because a pawn is detected, if return false right away it would print that " this location is invalid because pawn can eat it "
		// however, this location can also be invalide because that, there might be a queen to eat it. Therefore the discription would be inaccurate. 
	
		// check for all pawns and kings 
		if (checkingNum==0)// corner button left up --> button at first row first column
		{		
			if(!ifBlack)// if white's turn  
				//white pawn  can only move from up to down , since white pawn starts at second row, no white pawn is able to move upwards to eat king. therefore 
				// if it is black's turn, since the checkingNum is at first row,  if would not matter if theres a white pawn diagonal from it since it will not be able to eat it 
				// however if it was a white's turn, then this would be useful for detecting any black pawns that are coming near the king 
			{

				 if (checkForIfEdibleNum(  checkingNum+9, "pawn")== false)
				 {
					 ifMovablePiece=false;
					 
				 }
				 if ((checkForIfEdibleNum(  checkingNum+9, "king")== false)&&(checkForIfEdibleNum(  checkingNum+1, "king")== false)&&(checkForIfEdibleNum(  checkingNum+8, "king")== false))
				 {
					 ifMovablePiece=false;
				 }
			}
		}
		else if (checkingNum==7)// corner button right up---> first row last column 
		{
			if (!ifBlack)// if white's turn  
				//checkingNum at first row, therefore same logic as above
			{
					if (checkForIfEdibleNum(  checkingNum+7, "pawn")== false)
				 {
					 ifMovablePiece=false;
				 }
			}
			 if ((checkForIfEdibleNum(  checkingNum-1, "king")== false)&&(checkForIfEdibleNum(  checkingNum+7, "king")== false)&&(checkForIfEdibleNum(  checkingNum+8, "king")== false))
						 {
							 ifMovablePiece=false;
						 }
		}
		else if (checkingNum==56)// corner button left down 
		{
			if (ifBlack)// // if black's turn  
				//black pawn  can only move from down to up , since black pawn starts at second  last row, so black pawn is unable to move downwards to last row  to eat king. therefore 
				// if it is white's turn, since the checkingNum is at last row,  if would not matter if theres a black pawn diagonal from it since it will not be able to eat it 
				// however if it was a black's turn, then this would be useful for detecting any white pawns that are coming near the king 
			{
				if (checkForIfEdibleNum(  checkingNum-7, "pawn")== false)
				 {
					 ifMovablePiece= false;
				 }
			}
			 if ((checkForIfEdibleNum(  checkingNum-7, "king")== false)&&(checkForIfEdibleNum(  checkingNum+1, "king")== false)&&(checkForIfEdibleNum(  checkingNum-8, "king")== false))
			 {
				 ifMovablePiece= false;
			 }
		}
		else if (checkingNum==63)// corner button right down 
		{
			if (ifBlack)// last row , therefore same logic as above
			{
				if (checkForIfEdibleNum(  checkingNum-9, "pawn")== false)
				 {
					 ifMovablePiece= false;
				 }
			}
			 if ((checkForIfEdibleNum(  checkingNum-9, "king")== false)||( checkForIfEdibleNum(  checkingNum-1, "king")== false)&&(checkForIfEdibleNum(  checkingNum-8, "king")== false))
			 {
				 ifMovablePiece= false;
			 }
		}
	 
	
		else  if (checkingNum%8==0)//first column
		 {
			if (ifBlack)
			{
				 if ((checkForIfEdibleNum(  checkingNum-7, "pawn")== false))// only need to check for black pawns that are above it( balck goes from down to to up, only the ones that are coming towards it
					 																	// are able to eat it) . 
					 																	//since pawn can only move straight forward, if it was white pawn (only white pawn can eat black king) then
					 																	// it it eats down (+7 or +9) since you are checking backward,(check opposite way of eating) therefore the number checking should be
					 																	// -7 or -9. since this is at the first column, there is no button to the left diagonal of it so 
					 																	 // only 7 should be considered 
				 {
					 ifMovablePiece= false;
				 }
				 
			}
			else
			{
				 if ((checkForIfEdibleNum(  checkingNum+9, "pawn")== false) )// only need to check for white pawn that are below it ( white pawns goes from down to up, only the ones that are coming towards it 
					 																	//are able to eat it).
					 																	// since pawn can only move straight forward,if it was black pawn (only black pawn can eat a white king) then
																						// it it eats down (-7 or -9) since you are checking backward, therefore the number checking should be
																						// +7 or +9. since this is at the first column, there is no button to the left diagonal of it so 
																						 // only 9 should be considered 
				 {
					 ifMovablePiece= false;
				 }
			}
		
			 if ((checkForIfEdibleNum(  checkingNum-7, "king")== false)||(checkForIfEdibleNum(  checkingNum+9, "king")== false)||(checkForIfEdibleNum(  checkingNum+1, "king")== false)
					 ||(checkForIfEdibleNum(  checkingNum-8, "king")== false)||(checkForIfEdibleNum(  checkingNum+8, "king")== false))
			 {
				 ifMovablePiece= false;
			 }
		 }
		// if black's turn , then check for white pawn 
		// if checking for a white pawn, because of the logic explained above --- white pawn moves from up to down (+7 or +9), therefore when it'a  blacks turn and 
		// when trying to check it , it must go upwards too detect that white pawn , so (-7 or -9)
		
		// if white's turn , then check for black pawn 
		// if checking for a black pawn, because of the logic explained above as well-- black pawn moves from down to up(-7 or -9) therefore when it's a white turns and 
		//when checking it, it must detect it downwards for a black pawn , so (+7 or +9)
		else if ( checkingNum%8==7)// last column
		 {
			if (ifBlack)
			{
				if ((checkForIfEdibleNum(  checkingNum-9, "pawn")== false))
				 {
					 ifMovablePiece=false;
				 }
			}
			else
			{
				if ((checkForIfEdibleNum(  checkingNum+7, "pawn")== false))
				 {
					 ifMovablePiece=false;
				 }
				 
			}
			
			 if ((checkForIfEdibleNum(  checkingNum-9, "king")== false)||(checkForIfEdibleNum(  checkingNum-8, "king")== false)||(checkForIfEdibleNum(  checkingNum+8, "king")== false)
					 ||(checkForIfEdibleNum(  checkingNum+7, "king")== false)||(checkForIfEdibleNum(  checkingNum-1, "king")== false))
			 {
				 ifMovablePiece= false;
			 }
			
		 }
		 
		else if ( checkingNum>0&&checkingNum<7)// first row
		 {
			if (!ifBlack)
			{
				if ((checkForIfEdibleNum(  checkingNum+7, "pawn")== false)||(checkForIfEdibleNum(  checkingNum+9, "pawn")== false))
				 {
					 ifMovablePiece= false;
				 }
			}
			 if ((checkForIfEdibleNum(  checkingNum+9, "king")== false)||(checkForIfEdibleNum(  checkingNum+7, "king")== false)||(checkForIfEdibleNum(  checkingNum+8, "king")== false)
					 ||(checkForIfEdibleNum(  checkingNum+1, "king")== false)||(checkForIfEdibleNum(  checkingNum-1, "king")== false))
			 {
				 ifMovablePiece= false;
			 }
		 }
		else if ( checkingNum>56&&checkingNum<63)// last row
		 {
			if (ifBlack)
			{
				if ((checkForIfEdibleNum(  checkingNum-9, "pawn")== false)||(checkForIfEdibleNum(  checkingNum-7, "pawn")== false))
				 {
					 ifMovablePiece= false;
				 }
			}
			 if ((checkForIfEdibleNum(  checkingNum-7, "king")== false)||(checkForIfEdibleNum(  checkingNum-9, "king")== false)||(checkForIfEdibleNum(  checkingNum-8, "king")== false)
					 ||(checkForIfEdibleNum(  checkingNum+1, "king")== false)||(checkForIfEdibleNum(  checkingNum-1, "king")== false))
			 {
				  ifMovablePiece= false;
			 }
		 }
		else // center buttons 
		{ 
			if (ifBlack)
			{
				if ((checkForIfEdibleNum(  checkingNum-9, "pawn")== false)||(checkForIfEdibleNum(  checkingNum-7, "pawn")== false)) 
			 {
					 ifMovablePiece=false;
			 } 	
			}
			else// !ifBlack 
			{
				if ((checkForIfEdibleNum(  checkingNum+7, "pawn")== false)||(checkForIfEdibleNum(  checkingNum+9, "pawn")== false)) 
			 {
					 ifMovablePiece=false;
			 } 	
			}
			
			if ((checkForIfEdibleNum(  checkingNum-7, "king")== false)||(checkForIfEdibleNum( checkingNum-9, "king")== false)||(checkForIfEdibleNum( checkingNum-8, "king")== false)
					 ||(checkForIfEdibleNum( checkingNum+1, "king")== false)||(checkForIfEdibleNum(  checkingNum-1, "king")== false)||(checkForIfEdibleNum(  checkingNum+7, "king")== false)
					 ||(checkForIfEdibleNum( checkingNum+8, "king")== false)||(checkForIfEdibleNum(  checkingNum+9, "king")== false))
			 {
				 ifMovablePiece=false;
			 }
		}
		
		// check for knight 
		 if (checkingNum>47)// last two rows 
		 {
			 if (checkingNum%8==7)// last  column
			 {
				 if ((checkForIfEdibleNum(  checkingNum-10, "knight")== false)||(checkForIfEdibleNum(  checkingNum-17, "knight")== false)) 
				 {
					 ifMovablePiece=false;
				 } 	
			 }
			 else if (checkingNum%8==6)// second last column
			 {
				 if ((checkForIfEdibleNum(  checkingNum-10, "knight")== false)||(checkForIfEdibleNum( checkingNum-17, "knight")== false) ||(checkForIfEdibleNum(   checkingNum-15, "knight")== false))
				 {
					 ifMovablePiece=false;
				 } 	
			 }
			 else if (checkingNum%8==0 )// first  column
			 {
				 if ((checkForIfEdibleNum(   checkingNum-6, "knight")== false)||(checkForIfEdibleNum( checkingNum-15, "knight")== false)) 
				 {
					 ifMovablePiece=false;
				 } 	
			 }
			 else if (checkingNum%8==1)// second column
			 {
				 if ((checkForIfEdibleNum(  checkingNum-6, "knight")== false)||(checkForIfEdibleNum(   checkingNum-15, "knight")== false)||(checkForIfEdibleNum(  checkingNum-17, "knight")== false))
				 {
					 ifMovablePiece= false;
				 } 	
			 
			 }
			 else
			 {
				 if ((checkForIfEdibleNum(    checkingNum-6, "knight")== false)||(checkForIfEdibleNum(  checkingNum-15, "knight")== false)||
						 (checkForIfEdibleNum( checkingNum-17, "knight")== false)||(checkForIfEdibleNum(   checkingNum-10, "knight")== false))
				 {
					 ifMovablePiece= false;
				 } 	
			 }
		 }
		 else if (checkingNum<16)// first two row 
		 {
			 if ((checkingNum%8 ==7))// last  column
			 {
				 if ((checkForIfEdibleNum(  checkingNum+15, "knight")== false)||(checkForIfEdibleNum( checkingNum+6, "knight")== false)) 
				 {
					 ifMovablePiece= false;
				 } 	
			 }
			 if ((checkingNum%8 ==6))// second last   column
			 {
				 if ((checkForIfEdibleNum(  checkingNum+6, "knight")== false)||(checkForIfEdibleNum(    checkingNum+15, "knight")== false)||(checkForIfEdibleNum(  checkingNum+17, "knight")== false))
				 {
					 ifMovablePiece= false;
				 } 	
				 
			 }
			 else if (checkingNum%8==0)// first column
			 {
				 if ((checkForIfEdibleNum(  checkingNum+10, "knight")== false)||(checkForIfEdibleNum( checkingNum+17, "knight")== false) )
				 {
					 ifMovablePiece=false;
				 } 	
			 }
			 else if (checkingNum%8==1)//second last column
			 {
				 if ((checkForIfEdibleNum(    checkingNum+10, "knight")== false)||(checkForIfEdibleNum(  checkingNum+15, "knight")== false)||(checkForIfEdibleNum( checkingNum+17, "knight")== false))
				 {
					 ifMovablePiece= false;
				 } 	
			 }
			 else
			 {
				 if ((checkForIfEdibleNum(    checkingNum+6, "knight")== false)||(checkForIfEdibleNum(   checkingNum+15, "knight")== false)||
						 (checkForIfEdibleNum(    checkingNum+17, "knight")== false)||(checkForIfEdibleNum(    checkingNum+10, "knight")== false))
				 {
					 ifMovablePiece=false;
				 } 	
			 }
		 }
		 else if (checkingNum%8==6||checkingNum%8==7)// check for last two columns 
		 {
			 // the buttons on the corner do not need to be considered because they are already considered 
			 // in the scenario of them being in the last/first two rows
			 if ((checkForIfEdibleNum(  checkingNum+6, "knight")== false)||(checkForIfEdibleNum(   checkingNum+15, "knight")== false)||
					 (checkForIfEdibleNum(    checkingNum-17, "knight")== false)||(checkForIfEdibleNum(   checkingNum-10, "knight")== false))
			 {
				 ifMovablePiece=false;
			 } 	
		 }
		 else if (checkingNum%8==0||checkingNum%8==1)// first two column
		 {
			 if ((checkForIfEdibleNum(   checkingNum-6, "knight")== false)||(checkForIfEdibleNum(   checkingNum-15, "knight")== false)||
					 (checkForIfEdibleNum(  checkingNum+17, "knight")== false)||(checkForIfEdibleNum(   checkingNum+10, "knight")== false))
			 {
				 ifMovablePiece= false;
			 } 	
		 }
		 else// the middle buttons that has been pressed
		 {
			 if ((checkForIfEdibleNum(   checkingNum-6, "knight")== false)||(checkForIfEdibleNum(  checkingNum-15, "knight")== false)||
					 (checkForIfEdibleNum(   checkingNum-17, "knight")== false)||(checkForIfEdibleNum(   checkingNum-10, "knight")== false)
				 ||(checkForIfEdibleNum(    checkingNum+10, "knight")== false)||(checkForIfEdibleNum( checkingNum+15, "knight")== false)||
				 (checkForIfEdibleNum(    checkingNum+17, "knight")== false)||(checkForIfEdibleNum(  checkingNum+6, "knight")== false))
			 {
				 ifMovablePiece=false;
			 } 			 
		 }
	 
		// check for queen and rook and bishop 
		int checkForLeft=checkingNum;
		while (checkForLeft%8!=0)// first column
		{
			if (!chessBoard[checkForLeft].getName().contains("ngp"))
			{
				if ((chessBoard[checkForLeft].getName().contains("queen"))||(chessBoard[checkForLeft].getName().contains("rook")))
				{ 
					if (!chessBoard[checkForLeft].getActionCommand().equals(chessBoard[buttonNum].getActionCommand()))
					{  
							if(unMoveableReason.length()==0)
							 {
								 unMoveableReason+=" because king will get eaten by the "+ chessBoard[checkForLeft].getName()+" at "+a.getButtonLocation(checkForLeft);
							 }
							 else
							 {
								 unMoveableReason+=", also  because king will get eaten by the "+ chessBoard[checkForLeft].getName()+" at "+a.getButtonLocation(checkForLeft);
							 } 
						 ifMovablePiece=false;
					}
					else
					{
						break;// the game piece is the player's own game piece
					}
				}
				else// the game piece is a game piece which can not eat the king 
				{
				break;
				}
			}
			checkForLeft--;
		}
		int checkForRight= checkingNum;
		while (checkForRight%8!=7)// last column
		{
			if (!chessBoard[checkForRight].getName().contains("ngp"))
			{
				if ((chessBoard[checkForRight].getName().contains("queen"))||(chessBoard[checkForRight].getName().contains("rook")))
				{
					if (!chessBoard[checkForRight].getActionCommand().equals(chessBoard[buttonNum].getActionCommand()))
					{
						if(unMoveableReason.length()==0)
						 {
							 unMoveableReason+=" because king will get eaten  by the "+chessBoard[checkForRight].getName()+" at "+a.getButtonLocation(checkForRight);
						 }
						 else
						 {
							 unMoveableReason+=", also  because king will get eaten by the "+chessBoard[checkForRight].getName()+" at "+a.getButtonLocation(checkForRight);
						 }
						 ifMovablePiece= false;
					}
					break;
				}
				else 
				{
					break;
				}
			}
			checkForRight++;
		}
		
	 int checkForDown= checkingNum;
 
		while (checkForDown <56)// last row 
		{
			if (!chessBoard[checkForDown].getName().contains("ngp"))
			{
				if ((chessBoard[checkForDown].getName().contains("queen"))||(chessBoard[checkForDown].getName().contains("rook")))
				{
					if (!chessBoard[checkForDown].getActionCommand().equals(chessBoard[buttonNum].getActionCommand()))
					{
						if(unMoveableReason.length()==0)
						 {
							 unMoveableReason+=" because king will get eaten by the "+chessBoard[checkForDown].getName()+" at "+a.getButtonLocation(checkForDown)  ;
						 }
						 else
						 {
							 unMoveableReason+=", also  because king will get eaten by the "+chessBoard[checkForDown].getName()+" at "+a.getButtonLocation(checkForDown) ;
						 }
						 ifMovablePiece=false;
					}
					break;
				}
				else 
				{
					break;
				}
			}
			checkForDown+=8;
		}
	int checkForUp=checkingNum;
	while (checkForUp >7)// first row 
	{
		if (!chessBoard[checkForUp].getName().contains("ngp"))
		{
			 System.out.println("entered if statement 1");
			if ((chessBoard[checkForUp].getName().contains("queen"))||(chessBoard[checkForUp].getName().contains("rook")))
			{
				if (!chessBoard[checkForUp].getActionCommand().equals(chessBoard[buttonNum].getActionCommand()))
				{
					if(unMoveableReason.length()==0)
					 {
						 unMoveableReason+=" because king will get eaten  by the "+chessBoard[checkForUp].getName()+" at "+a.getButtonLocation(checkForUp);
					 }
					 else
					 {
						 unMoveableReason+=", also  because king will get eaten by the "+chessBoard[checkForUp].getName()+" at "+a.getButtonLocation(checkForUp) ;
					 }
					 ifMovablePiece=false;
				
				}
				break;
			}
			else 
			{
				break;
			}
		}
		checkForUp-=8;
	}
	int checkForUpLeft=checkingNum;
	  
	 while (  (checkForUpLeft%8!=0)&&(checkForUpLeft>7))
	 {
		 if (!chessBoard[checkForUpLeft].getName().contains("ngp"))
			{
			 if (!chessBoard[checkForUpLeft].getActionCommand().equals(chessBoard[buttonNum].getActionCommand()))
				{
				  
					if ((chessBoard[checkForUpLeft].getName().contains("queen"))|| (chessBoard[checkForUpLeft].getName().contains("bishop")))
					{
							 
						if(unMoveableReason.length()==0)
						 {
							 unMoveableReason+=" because king will get eaten by the chessBoard[checkForUpLeft].getName()"+" at "+a.getButtonLocation(checkForUpLeft) ;
						 }
						 else
						 {
							 unMoveableReason+=", also  because king will get eaten  by the chessBoard[checkForUpLeft].getName()"+" at "+a.getButtonLocation(checkForUpLeft) ;
						 }
					 
						 ifMovablePiece=false;
					}
				}
				break;
			}
			checkForUpLeft-=9;
	 }
	
	 int checkForUpRight= checkingNum;
	 while (  (checkForUpRight%8!=7)&&(checkForUpRight>7))
	 {
		 
		 if (!chessBoard[checkForUpRight].getName().contains("ngp"))
			{
			 
			 if (!chessBoard[checkForUpRight].getActionCommand().equals(chessBoard[buttonNum].getActionCommand()))
				{
					if ((chessBoard[checkForUpRight].getName().contains("queen"))||(chessBoard[checkForUpRight].getName().contains("bishop") ))
					{
						 
						if(unMoveableReason.length()==0)
						 {
							 unMoveableReason+=" because king will get eaten by the "+chessBoard[checkForUpRight].getName()+" at "+a.getButtonLocation(checkForUpRight)  ;
						 }
						 else
						 {
							 unMoveableReason+=", also  because king will get eaten by the "+chessBoard[checkForUpRight].getName()+" at "+a.getButtonLocation(checkForUpRight)  ;
						 }
						 ifMovablePiece=false;
					}
					break;
				}
				break;
			}
		 checkForUpRight-=7;
	 }
	 
	 int checkForDownRight= checkingNum;
	 while (  (checkForDownRight%8!=7)&&(checkForDownRight<56))
	 {
		 if (!chessBoard[checkForDownRight].getName().contains("ngp"))
			{
			 
					if (!chessBoard[checkForDownRight].getActionCommand().equals(chessBoard[buttonNum].getActionCommand()))
					{
						if ((chessBoard[checkForDownRight].getName().contains("queen"))||(chessBoard[checkForDownRight].getName().contains("bishop")) )
						{
							 
								if(unMoveableReason.length()==0)
								 {
									 unMoveableReason+=" because king will get eaten by the "+ chessBoard[checkForDownRight].getName()+" at "+a.getButtonLocation(checkForDownRight)  ;
								 }
								 else
								 {
									 unMoveableReason+=", also  because king will get eaten by the "+ chessBoard[checkForDownRight].getName()+" at "+a.getButtonLocation(checkForDownRight)  ;
								 }
								 ifMovablePiece=false;
							 
							 
						}
						 
							break;
					}
					break;
			}
		 checkForDownRight+=9;
	 }
	 
	 int checkForDownLeft= checkingNum; 
	 while (  (checkForDownLeft%8!=0)&&(checkForDownLeft<56))
	 {
		 if (!chessBoard[checkForDownLeft].getName().contains("ngp"))
			{ 
			 if (!chessBoard[checkForDownLeft].getActionCommand().equals(chessBoard[buttonNum].getActionCommand()))
				{
					if ((chessBoard[checkForDownLeft].getName().contains("queen"))||(chessBoard[checkForDownLeft].getName().contains("bishop")) )
					{ 
							if(unMoveableReason.length()==0)
							 {
								 unMoveableReason+=" because king will get eaten by the "+chessBoard[checkForDownLeft].getName() +" at "+a.getButtonLocation(checkForDownLeft) ;
							 }
							 else
							 {
								 unMoveableReason+=", also  because king will get eaten by the "+chessBoard[checkForDownLeft].getName() +" at "+a.getButtonLocation(checkForDownLeft) ;
							 }
						 ifMovablePiece=false;
					}
				}
				break;
			}
		 checkForDownLeft+=7;
	 }

	 	if (ifMovablePiece==false)
	 	{
	 		unmovablePieces+=" king can not move to "+a.getButtonLocation(checkingNum)+ unMoveableReason+".";
	 	}
		return 	 ifMovablePiece;
	}
	/**
	 * this method checks if two game piece are opposite colors, therefore belongs to different people
	 * and it checks if that game piece is the game piece that can eat the original game piece
	 * @param checkingNum
	 * @return
	 */
	  private boolean checkForIfEdibleNum(  int checkIfEdiblePiece, String gamePieceName)
	  {
			if ((chessBoard[checkIfEdiblePiece].getName().contains(gamePieceName)))
			{
				if ((!chessBoard[checkIfEdiblePiece].getActionCommand().equals(chessBoard[buttonNum].getActionCommand())) )
				{
					if(unMoveableReason.length()==0)
					 {
						 unMoveableReason+=" because king will get eaten  by the  "+ gamePieceName+" at "+a.getButtonLocation(checkIfEdiblePiece);
					 }
					 else
					 {
						 unMoveableReason+=", also because king will  get eaten by the  "+ gamePieceName+" at "+a.getButtonLocation(checkIfEdiblePiece);
					 }
				 
					return false;
				}
			} 		
		return true;
	  }
 
	private void checkForUp()
	{
		checkButton(buttonNum-8);
	 
	}
	private void checkForDown()
	{
		checkButton(buttonNum+8);
		 
	}
	private void checkForRight()
	{
		checkButton(buttonNum+1);
	
	}
	private void checkForLeft()
	{
		checkButton(buttonNum-1);
	}
	private void checkForUpRight ()
	{	
		checkButton(buttonNum-7);
		
	}
	private  void checkForUpLeft ()
	{
		checkButton(buttonNum-9);
		 
	}
	private void checkForDownRight ()
	{
		checkButton(buttonNum+9);
		 
	}
	private void checkForDownLeft ()
	{
		checkButton(buttonNum+7);
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
	 
	 if (movablePieces.length()==0)
	 { 
		  a.setMoveablePlace(chessBoard[buttonNum].getActionCommand()+" king can't be moved because  because other game piece are blocking it's path.");
	 }
	 else
	 {
		 if (unmovablePieces.length()!=0)
		 {
			 a.setMoveablePlace(" King can move to "+movablePieces+ ". \n"+unmovablePieces);
		 }
		 else
		 {
			 a.setMoveablePlace(" King can move to "+movablePieces+ ".");
		 }
		 
	 }
	  
		
		
	  
	  a.resetButtonImage();
			a.setGameBoard(chessBoard);
	 }

}

