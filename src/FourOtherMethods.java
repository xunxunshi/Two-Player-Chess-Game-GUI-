import javax.swing.JButton;
import java.awt.*;
import java.awt.event.*;

public class FourOtherMethods 
{

 private ChessGUI a;

 private JButton chessBoard [];
 private int buttonNum;
 private int previousGamePieceButton;
 
 private boolean ifBlack;

 private String moveablePieces;
 public FourOtherMethods(ChessGUI c)
 {
  a = c;
  buttonNum=a.getButtonNumber();
  
  chessBoard = a.getGameBoard();
  previousGamePieceButton=a.getPreviousGamePieceButtonNum();
  ifBlack=a.getIfBlack();
   
 }
 public void checkForAte()
 {
  // check if king was eaten the game has won 
  if (chessBoard[buttonNum].getName().contains("king"))
  {
   a.setWon( );
  }
  // check for castling 
  else if (chessBoard[buttonNum].getName().contains("castling.")) 
  {
   
   if(ifBlack)
    
   { a.setBlackCastled();
    // set original position of the king to blank
    a.setMovesInTheGame(" Black has performed castling");
     a.setMovesInTheGame(" Black king is moved from "+a.getButtonLocation(59)+" to "+a.getButtonLocation(buttonNum)+".");// black king starts at 59 
    chessBoard[59].setName("ngp");
    chessBoard[59].setActionCommand("ngp");
    chessBoard[buttonNum].setActionCommand("black");
    
   }
   else// ifBlack== false
   { a.setWhiteCastled();
    // set original postition of the king to blank
    a.setMovesInTheGame("white has performed castling");
     a.setMovesInTheGame(" White king is moved from "+a.getButtonLocation(3)+" to "+a.getButtonLocation(buttonNum)+".");// black king starts at 59 
    chessBoard[3].setName("ngp");
    chessBoard[3].setActionCommand("ngp");
    chessBoard[buttonNum].setActionCommand("white");
    
   }
    // NEEDS TO SET THE TEXT/NAME ACCORDING TO THE OBJECT BESIDE KING 
   
    
     chessBoard[buttonNum].setName("king");
     
    if ((buttonNum==1)||(buttonNum==2)||(buttonNum==57)||(buttonNum==58))
    {
     
     // set the  the rook button it self to ngp and the button on the kings right  to the new rook
      
     chessBoard[buttonNum+1].setName("rook");
     if (ifBlack)
     {
      a.setMovesInTheGame("Black rook moved from "+a.getButtonLocation(56)+" to "+a.getButtonLocation(buttonNum+1)+".");// black rook starts off at button 56
      chessBoard[56].setName("ngp");
      chessBoard[56].setActionCommand("blank");
      chessBoard[buttonNum+1].setActionCommand("black");
     }
     else// !ifBlack
     { 
       
      a.setMovesInTheGame("White rook is moved from  "+a.getButtonLocation(0)+a.getButtonLocation(buttonNum+1)+".");// white rook starts off at button 0
      chessBoard[0].setName("ngp");
      chessBoard[0].setActionCommand("blank");
      chessBoard[buttonNum+1].setActionCommand("white");
     }
    }
    else if ((buttonNum == 60)||(buttonNum==61)||(buttonNum==4)||(buttonNum==5 ) )
    {
     // set the  the rook button it self to ngp and the button on the kings left to the new rook
    
     chessBoard[buttonNum-1].setName("rook");
    
     if (ifBlack)
     {
       
       a.setMovesInTheGame("Black rook moved from "+a.getButtonLocation(56)+" to "+a.getButtonLocation(buttonNum-1)+".");// black rook starts off at button 56
      chessBoard[63].setName("ngp");
      chessBoard[63].setActionCommand("blank");
      
      chessBoard[buttonNum-1].setActionCommand("black");
     }
     else
     {  
      a.setMovesInTheGame("White rook is moved from  "+a.getButtonLocation(0)+a.getButtonLocation(buttonNum-1)+".");// white rook starts off at button 0
      chessBoard[7].setName("ngp");
      chessBoard[7].setActionCommand("blank");
      chessBoard[buttonNum-1].setActionCommand("white");
     }
    }
    
  }
  else 
  { 
   if (chessBoard[previousGamePieceButton].getName().contains("pawn")&&((buttonNum<=7)||buttonNum>=56))
   {
    chessBoard[buttonNum].setName("queen");
    if (chessBoard[buttonNum].getName().equals("."))// if the game piece only moved 
    {
     if(buttonNum<=7)
     { 
      a.setMovesInTheGame("  Black pawn has moved from "+  a.getButtonLocation(previousGamePieceButton)+"to "+a.getButtonLocation(buttonNum)+".");
       a.setMovesInTheGame("Because black pawn successfully reached to opposite side, it has been upgraded to a queen ");
       
     }
     else//buttonNum>=56
     { 
      a.setMovesInTheGame(" white pawn has moved from "+  a.getButtonLocation(previousGamePieceButton)+"to "+a.getButtonLocation(buttonNum)+".");
       a.setMovesInTheGame("Because white pawn successfully reached to opposite side, it has been upgraded to a queen ");
      
     }
    }
    else// if the game piece ate 
    {
     
     if(buttonNum<=7)
     { 
      a.setMovesInTheGame("  Black pawn from "+  a.getButtonLocation(previousGamePieceButton)+" has ate white "+ chessBoard[previousGamePieceButton].getName()+" at "+a.getButtonLocation(buttonNum));
       a.setMovesInTheGame("Because black pawn successfully reached to opposite side, it has been upgraded to a queen ");
       
     }
     else//buttonNum>=56
     { 
      a.setMovesInTheGame("  White pawn from "+  a.getButtonLocation(previousGamePieceButton)+" has ate white "+ chessBoard[previousGamePieceButton].getName()+"at"+a.getButtonLocation(buttonNum));
      a.setMovesInTheGame(" white  "+chessBoard[buttonNum].getName()+" has moved from "+  a.getButtonLocation(previousGamePieceButton)+"to "+a.getButtonLocation(buttonNum));
      
     }
    }
    
     
   }
   else  
   {
     
    if (chessBoard[buttonNum].getName().equals("."))// if the game piece only moved
    {
     if(ifBlack)
     {
      a.setMovesInTheGame("  Black  "+chessBoard[previousGamePieceButton].getName()+" has moved from "+  a.getButtonLocation(previousGamePieceButton)+"to "+a.getButtonLocation(buttonNum));
        }
     else
        {
      a.setMovesInTheGame(" White  "+chessBoard[previousGamePieceButton].getName()+" has moved from "+  a.getButtonLocation(previousGamePieceButton)+"to "+a.getButtonLocation(buttonNum));
        }
     
    }
    else// if the game piece ate 
    {
     if(ifBlack)
     {
      a.setMovesInTheGame("  Black " +chessBoard[previousGamePieceButton].getName()+" from "+  a.getButtonLocation(previousGamePieceButton)+" has ate white "+ chessBoard[buttonNum].getName()+" at "+a.getButtonLocation( buttonNum));
        
     }   
     else
     {
      System.out.println("fdsa");
      a.setMovesInTheGame("  white " +chessBoard[previousGamePieceButton].getName()+" from "+  a.getButtonLocation(previousGamePieceButton)+" has ate black "+ chessBoard[buttonNum].getName()+" at "+a.getButtonLocation(buttonNum));
     } 
    }
    chessBoard[buttonNum].setName(chessBoard[previousGamePieceButton].getName());
    
   
   } 
    chessBoard[buttonNum].setActionCommand(chessBoard[previousGamePieceButton].getActionCommand());
    chessBoard[previousGamePieceButton].setActionCommand("blank");
     chessBoard[previousGamePieceButton].setName("ngp");
    
    
  }
   
   a.resetButtonImage(); 
   
 }
 public void refreshAllButtons()
 {   
   for (int x=0;x<64;x++)
   {
    
    if (chessBoard[x].getName().contains("."))
    {
     if ((chessBoard[x].getName().length()==1)||(chessBoard[x].getName().contains("castling")))
     {
      chessBoard[x].setName("ngp");
      chessBoard[x].setActionCommand("blank");
     }

     else 
     {
        
      chessBoard[x].setName(chessBoard[x].getName().substring(0, chessBoard[x].getName().length()-1));
       
     }
    }   
   
     if (chessBoard[x].getName().contains("ngp"))
     {
      chessBoard[x].removeActionListener(a);
     }
 
   }
     a.resetButtonImage();
 }
  public void  Castling( )
  { 
  
   // NEEDS TO CHECK FOR THE GAME PIECE BESIDE THE KINGS NEW POSTION 
   refreshAllButtons();
   String moveablePlaces="";
   String unmoveablePlaces="";
   if ( ifBlack) 
   { 
   for ( int x=0;x<64;x++ )
   {
    if ( chessBoard[x].getActionCommand().equals("white")||chessBoard[x].getActionCommand().equals("blank"))
    { 
     chessBoard[x].removeActionListener(a);
     
    }
   }
   if (chessBoard[61].getName().contains("ngp")&& chessBoard[60].getName().contains("ngp"))
   {
    chessBoard[61].setName("castling."+chessBoard[61].getName());
    chessBoard[61].addActionListener(a);
    moveablePlaces+=" Black King can castle at " +a. getButtonLocation(61)+".";
   }
   else
   {
    if ( !chessBoard[60].getName().contains("ngp") ||(!chessBoard[60].getName().contains("ngp")&&!chessBoard[61].getName().contains("ngp")))
    {
     unmoveablePlaces+="King can not move to "+a.getButtonLocation(61)+" because "+ chessBoard[60].getName() +" is at " +a. getButtonLocation(60)+
       " ,no space to move rook. \n "+"King can not move to "+a.getButtonLocation(60)+" because "+ chessBoard[60].getName()+" is at "+a.getButtonLocation(60)+
       " . No space to move king ";
     
    }
    else if (!chessBoard[61].getName().contains("ngp"))
    {
     moveablePieces+="Black King can castle at "+a.getButtonLocation(60);
     unmoveablePlaces+="King can not move to "+a.getButtonLocation(61)+" because "+ chessBoard[61].getName()+ "is at "+a. getButtonLocation(61) +". No space to move king. ";
    
    }
    
   }
   // don't need to check for 59 because the king is at 59 right now and the rook will take the kings place 
   
   if (chessBoard[60].getName().contains("ngp"))
   {
    chessBoard[60].setName("castling."+chessBoard[60].getName());
    chessBoard[60].addActionListener(a);
    moveablePlaces+="\n Black King can castle at " +a. getButtonLocation(60)+".";
   }
   // does not need to print anything if chessBoard[60].getActionCommand() does not equal to "ngp"
   // because chessBoard[60] has been checked in the else loop of 
   // if (chessBoard[61].getActionCommand().equals("ngp")&& chessBoard[60].getActionCommand().equals("ngp"))
 
   if (chessBoard[57].getName().contains("ngp")&& chessBoard[58].getName().contains("ngp"))
   {
    chessBoard[57].setName("castling."+chessBoard[57].getName());
    chessBoard[57].addActionListener(a);
    moveablePlaces+="\n Black King can castle at " +a. getButtonLocation(57);
    
   } 
   else
   {
    if (!chessBoard[58].getName().contains("ngp") ||(!chessBoard[57].getName().contains("ngp") &&!chessBoard[58].getName().contains("ngp") ) )
    {
     unmoveablePlaces+="\n King can not move to "+a.getButtonLocation(57)+" because "+ chessBoard[58].getName()+" is at " +a.getButtonLocation(58)+
          " , no space to move rook . \n"+"King can not move to "+a.getButtonLocation(58)+" because "+ chessBoard[58].getName()+" is at "+
          a.getButtonLocation(58)+", no space to move king .";
    }
     
    else if (!chessBoard[57].getName().contains("ngp"))// and  if chessBoard[58].getName.contains("ngp")
    {
     moveablePlaces="\n Black King can castle at " +a. getButtonLocation(58);
     unmoveablePlaces+="\n"+"King can not move to "+a.getButtonLocation(57)+" because "+ chessBoard[57].getName()+" is at " +a.getButtonLocation(57)+
       ". No space to move rook. ";
    }
    
   }
   if (chessBoard[58].getName().contains("ngp"))
   {
    chessBoard[58].setName("castling."+chessBoard[58].getName());
    chessBoard[58].addActionListener(a);
    moveablePlaces+="\n Black King can castle at " +a. getButtonLocation(58)+".";
   } 
   }
   
   else  // checks for white
   {
    for (int x=0;x<64;x++)
    {
     if ( chessBoard[x].getActionCommand().equals("black")||chessBoard[x].getActionCommand().equals("blank"))
     {
      chessBoard[x].removeActionListener(a);
     }
 
    }
    if ((chessBoard[2].getName().contains("ngp"))&&(chessBoard[1].getName().contains("ngp")))
    {
     chessBoard[1].setName("castling."+chessBoard[1].getName());
     chessBoard[1].addActionListener(a);
     moveablePlaces+=" White King can castle at " +a. getButtonLocation(1)+".";
    }
    else
    {
     if ( !chessBoard[2].getName().contains("ngp") ||(!chessBoard[2].getName().contains("ngp")&&!chessBoard[1].getName().contains("ngp")))
     {
      unmoveablePlaces+="King can not move to "+a.getButtonLocation(1)+" because "+ chessBoard[2].getName()+" is at " +a.getButtonLocation(2)+
           " , no space to move rook .\n  King can not move to "+a.getButtonLocation(2)+" because " +chessBoard[2].getName()+" is at "+
           a.getButtonLocation(2)+", no space to move king. ";
     }
     else if (!chessBoard[1].getName().contains("ngp"))
     {
      moveablePlaces+="White King can castle at "+a.getButtonLocation(2);
      unmoveablePlaces+=  "King can not move to "+a.getButtonLocation(1 )+" because "+ chessBoard[1].getName()+" is at "+a.getButtonLocation(1)+". No space to move rook.";
     
     }
      
    }
    if (chessBoard[2].getName().contains("ngp"))
    {
     chessBoard[2].setName("castling."+chessBoard[2].getName());
     moveablePlaces+="\n White King can castle at " +a. getButtonLocation(2)+".";
     chessBoard[2].addActionListener(a);
    }
    
    if ((chessBoard[5].getName().contains("ngp"))&&(chessBoard[4].getName().contains("ngp")))
    {
     chessBoard[5].setName("castling."+chessBoard[5 ].getName());
     moveablePlaces+="\n White King can castle at " +a. getButtonLocation(5)+".";
     chessBoard[5].addActionListener(a);
     
    } 
    else
    {
     if ( !chessBoard[4 ].getName().contains("ngp")||(!chessBoard[4].getName().contains("ngp")&&!chessBoard[5].getName().contains("ngp")) )
     { 
      unmoveablePlaces+="\n King can not move to "+a.getButtonLocation(5)+" because "+chessBoard[4].getName()+" is at " +a.getButtonLocation(4)+
        " , no space to move rook .\n  King can not move to  "+a.getButtonLocation(4)+"because"+chessBoard[4].getName()+"is at"+
        a.getButtonLocation(4)+", no space to move king ";
     }
     else if (!chessBoard[5].getName().contains("ngp"))
     { 
      moveablePlaces+="White King can castle at "+a.getButtonLocation(4);
      unmoveablePlaces+=  "\n King can not move to "+a.getButtonLocation(5)+" because "+chessBoard[5].getName()+" is at "+a.getButtonLocation(4)+". No space to move king.";
      
     }
      
     
    }
    // don't need to check for chessBoard[4].getActionCommand
    // already checked in  
    //if (!chessBoard[57].getActionCommand().equals("ngp")&& !chessBoard[58].getActionCommand().equals("ngp") )
    if (chessBoard[4].getName().contains("ngp"))
    {
     chessBoard[4].setName("castling."+chessBoard[4].getName());
     chessBoard[4].addActionListener(a);
     moveablePlaces+="\n White King can castle at " +a. getButtonLocation(4);
    }
    
   }
   a.setMoveablePlace(moveablePlaces+"\n"+unmoveablePlaces);
   
   a.setGameBoard(chessBoard);
  }
  
  
 public void reOrganizePreviousButtons()
 {
  for (int x=0;x<64;x++)
  {
   
   if ( ifBlack )
   {
     
    if (chessBoard[x].getActionCommand().contains("white"))
    {
     chessBoard[x].removeActionListener(a);
    }
    if (chessBoard[x].getActionCommand().contains("black"))
    {
     chessBoard[x].addActionListener(a);
    }
   }
   else 
   {
     
     if (chessBoard[x].getActionCommand().contains("black"))
    {
     chessBoard[x].removeActionListener(a);
    }
     if (chessBoard[x].getActionCommand().contains("white"))
    {
       
      chessBoard[x].addActionListener(a);
    }
   }

  }
  a.setGameBoard(chessBoard);
 }
}
