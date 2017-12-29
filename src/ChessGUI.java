import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.io.IOException;
import java.lang.*;
/**
 * In this class, it is a GUI class which will interact with methods in the other classes to make a 2 player chess game.
 * This game 
 * @author Xunxun Shi
 *
 */
public class ChessGUI extends JFrame implements ActionListener
{
 
 private JFrame gameFrame= new JFrame();// gameFrame 
 private JFrame instructionFrame= new JFrame();// insturctionFrame 
private JFrame scoreFrame= new JFrame();// scoreFrame 
 private JPanel gamePanel ;// the gamePanel
 private JPanel instructionPanel ; // insturction Panel 
 private JPanel scorePanel;// score Panel 
 
 
 private int numOfMoves ;// keeps track of how many moves there are, can be used to determine score and turn 
 private int buttonNum;// keeps track of the game piece that was pressed 
 private int previousGamePieceButtonNum=0; /// the game piece's number which was pressed which caused it to move to the new location
            //  so if a button was clicked the first time, it is stored as buttonNum. If the user succesfully 
            // moved that game piece to a new location ( so somewhere where that game piece can go, 
            //was clicked, and then the user moved that game piece to a new game location( for ex king moved one up) 
            // Then, the buttonNum will store the new location where as the previousGamePieceButtonNum will be the old location 
            // however, if the game piece did not successfully get moved to a new location, then buttonNum will still be buttonNum and nothing will be changed
 
 // remenber how many game pieces of each are left over on the gameboard
 private int bKnightLeft,bQueenLeft,bRookLeft,bBishopLeft,bPawnLeft,bKingLeft;// b= black
 private int wKnightLeft,wQueenLeft,wRookLeft,wBishopLeft,wPawnLeft,wKingLeft;// w= white
                  
 
 private boolean ifWon;// if game has won
 private boolean ifBlack;// if black's turn
 
 // remembers if black has castled or if white has castled 
 private boolean ifWhiteCastled;  
 private boolean ifBlackCastled; 
 
  private JRadioButton beginner,advanced;// ask the user for beginner version or advanced version 
  // the beginner version will provide a  text box  that tell the user where the player can put their game pieces in the game and why they can't put them in a certain spot 
  // in the beginner version it will also set dots on the game board of the spaces where they can lay their game pieces
  // advanced will not have any of that. 
  
 private JTextArea introduction;//  tell the user interesting facts about chess
 private JScrollPane introductionScrollPane;
 private JTextArea instructionBox;// tell the user about the game's instructions , this will be in insturction panels 
 private JTextArea moveablePlace;// display where a game piece can be moved on to
 private JTextArea movesInTheGame; // display specificly what happens in each turn 
 private JScrollPane movesInTheGameScrollBar,moveablePlaceScrollBar;//shows the moves in the game 
 private JTextArea beginnerHighScores, advancedHighScores;// display the two high scores of the game 
 private JScrollPane beginnerHighScrollBar,advancedHighScrollBar;// the scroll bars for them
 private JTextField player1 ,player2 ;// the players' name

 private JLabel displayAdvancedScore,displayBeginnerScore;// display advanced and beginner high score 
 private JLabel saveScore;// will Display saveScore?
 private JLabel numberOfMoves;//display :" number of moves"+numOfMoves
 private JLabel title,title2;// display "chess"
 private JLabel theRuleOfChess;//display " the rule of chess:"
 private JLabel  pleaseEnter;// display "please enter " 
 
 private JLabel displayPlayer1Name;// says " Player 1" to identify which text area asks for player1's name
 private JLabel displayPlayer2Name;// says" Player 2" to identify which text area asks for player2's name
 
 private JLabel displayWhoWon;// displays who won
 private JLabel displayTurn;// display who's players turn is it
 
 private JLabel[]gamepieceTypeLeftOver= new JLabel[7];// displays what game piece is leftover 
 private JLabel[]player1LeftOverGamePieces= new JLabel[7];
 private JLabel[]player2LeftOverGamePieces= new JLabel[7];// displays the player's name and how many game pieces of a player is left over 
 
 
 private JLabel askToSaveScore;// asks if the user wants it's score to be saved
 private JLabel displayButtonYLocation[]= new JLabel[8];// helps identitfy where a game piece is, for example, a game piece at first row first column will be " 1, a" 
               // displayButtonYLocation will say 1 on row 1, 2 on row 2, 3 on row 3 etc
 private JLabel displayButtonHLocation[]= new JLabel[8];// displayButtonHLocation will say 1 on column 1 , 2 on column 2, 3 on column 3 etc
 private JLabel gameScore;// display the player's score

 
 private JButton chessInstructions;// leads from gameFrame to instruction Frame 
 private JButton readInterstingFacts;// prints out interesting facts on the introduction textarea 
 private JButton startButton;// start the game
 private JButton gameBoard[]=new JButton[64];// the game board 
 private JButton gamePieceInstructionButtons[]=new JButton[6];// inside instruction panel , display the individual instruction of the game pieces if a game piece was pressed
 private JButton mainInstruction;// inside instruction panel , display the main instructions
 private JButton ySaveScore;// ask the user to save score or discard it 
 private JButton nSaveScore; //ask the user to save score or discard it
 private JButton blackCastling, whiteCastling;// if these buttons were clicked it allows the user to perform  castle.
             // if there was space to castle and the user did castle, then theose button will not appear anymore   
 
 // the following gets the icons for all the game pieces
 private Icon blackPawn = new ImageIcon("blackpawn.gif");
 private Icon blackPawnDot = new ImageIcon("blackpawndot.gif");
 private Icon blackBishop = new ImageIcon("blackbishop.gif");
 private Icon blackBishopDot = new ImageIcon("blackbishopdot.gif");
 private Icon blackRook = new ImageIcon("blackrook.gif"); 
 private Icon blackRookDot = new ImageIcon("blackrookdot.gif");
 private Icon blackKnight = new ImageIcon("blackknight.gif");
 private Icon blackKnightDot = new ImageIcon("blackknightdot.gif");
 private Icon blackQueen= new ImageIcon("blackqueen.gif");
 private Icon blackQueenDot= new ImageIcon("blackqueendot.gif");
 private Icon blackKing = new ImageIcon("blackking.gif");
 private Icon blackKingDot= new ImageIcon("blackkingdot.gif");
 private Icon whiteBishop = new ImageIcon("whitebishop.gif");
 private Icon whiteBishopDot = new ImageIcon("whitebishopdot.gif");
 private Icon whiteRook = new ImageIcon("whiterook.gif");
 private Icon whiteRookDot = new ImageIcon("whiterookdot.gif");
 private Icon whiteKnight= new ImageIcon("whiteknight.gif");
 private Icon whiteKnightDot = new ImageIcon("whiteknightdot.gif");
 private Icon whiteQueen = new ImageIcon("whitequeen.gif");
 private Icon whiteQueenDot = new ImageIcon("whitequeendot.gif");
 private Icon whiteKing = new ImageIcon("whiteking.gif");
 private Icon whiteKingDot = new ImageIcon("whitekingdot.gif");
 private Icon whitePawn = new ImageIcon("whitepawn.gif");
 private Icon whitePawnDot = new ImageIcon("whitepawndot.gif");
 private Icon blackDot =new ImageIcon("blackdot.gif");
 private Icon whiteDot =new ImageIcon("whitedot.gif");
 
 
 /**
  * this constructor will  initialize all the global variables 
  */
 public ChessGUI()
 { 
  // intialize some of the global variables 
  numOfMoves=0;
  ifBlackCastled=false;
  ifWhiteCastled=false;
  ifBlack=true;
  
  // intailize the panels 
  gamePanel=new JPanel(null);
   Color backgroundColor =new Color( 162,238,231);// set the background color
  gamePanel.setBackground(backgroundColor) ;
  scorePanel = new JPanel(null);
  instructionPanel= new JPanel(null);
  instructionPanel.setBackground(Color.red);
  
  // intailize the frames 
   scoreFrame.setVisible(false);
   scoreFrame.setTitle("scores ");
   scoreFrame.setSize(800, 700);
   scoreFrame.add(scorePanel);
   scoreFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
  
  gameFrame.setVisible(true);
  gameFrame.setTitle("Two Player Chess");
  gameFrame.setSize(800, 826);
  gameFrame.add(gamePanel);
  gameFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
 
  
  instructionFrame.setSize(800, 550);
  instructionFrame.setTitle("Chess Instructions");
  instructionFrame.add(instructionPanel);
  instructionFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
  
  // intialize introduction text area 
  introduction = new JTextArea (outputAnInterestingFact()); 
  introduction.setFont(new Font("Georgia", Font.BOLD , 25)); 
  introduction.setBounds(100,130,550,250); 
  introduction.setLineWrap(true);
  introduction.setWrapStyleWord(true);
  introduction.setEditable(false); 
  introductionScrollPane = new JScrollPane(introduction);
  introductionScrollPane.setLocation(introduction.getLocation());
  introductionScrollPane.setSize(550,250);
  introductionScrollPane.setVisible(true);
  gamePanel.add(introductionScrollPane);
 
  
  title=new JLabel("CHESS" );
  title.setFont( new Font("Georgia", Font.BOLD , 80));
  title.setBounds(190,30,400,70);
  title.setHorizontalAlignment(SwingConstants.CENTER);
  title.setVisible(true);
  gamePanel.add(title);
  
  Font font1= new Font("Georgia", Font.BOLD , 25);
  displayPlayer1Name=new JLabel("player 1's name ");
  displayPlayer1Name.setBounds(120,440,240,40) ;
  displayPlayer1Name.setFont(font1);
  gamePanel.add(displayPlayer1Name);
  
  displayPlayer2Name=new JLabel("player 2's name ") ;
  displayPlayer2Name.setBounds(420,440,240,40);
  displayPlayer2Name.setFont(font1);
  gamePanel.add(displayPlayer2Name);
  
  pleaseEnter=new JLabel("please Enter" );
  pleaseEnter.setFont(font1);
  pleaseEnter.setBounds(300,400,240,40);
  gamePanel.add(pleaseEnter); 
  
  player1 = new JTextField();
  player1.setText("");
  player1.addActionListener(this);
  player1.setHorizontalAlignment(JTextField.CENTER);
  player1.setBackground(Color.white);
  player1.setBounds(160,500,150,40);
  gamePanel.add(player1);
  
  
  player2 = new JTextField();
  player2.addActionListener(this);
  player2.setHorizontalAlignment(JTextField.CENTER);
  player2.setBackground(Color.white);
  player2.setBounds(450,500,150,40);
  gamePanel.add(player2);
  
  
  readInterstingFacts = new JButton("READ OTHER FACTS");
  readInterstingFacts.setBounds(250,730,200,40);
  readInterstingFacts.setVisible(true);
  readInterstingFacts.setBackground(Color.white);
  readInterstingFacts.addActionListener(this);
  gamePanel.add(readInterstingFacts);
  
  startButton = new JButton("start");
  startButton.addActionListener(this);
  startButton.setBackground(Color.white);
  startButton.setBounds(130,730,100,40);
  gamePanel.add(startButton);
  
  chessInstructions= new JButton("Instructions");
  chessInstructions.setBounds(230,650,300,40);
  chessInstructions.setBackground(Color.black);
  chessInstructions.setForeground(Color.white);
  chessInstructions.addActionListener(this);
  gamePanel.add(chessInstructions);  
  
  title2 = new JLabel("CHESS");// ask david why the the same label can not be added to two panels
  title2.setFont(new Font("Georgia", Font.BOLD , 60));
  title2.setHorizontalAlignment(JLabel.CENTER);
  title2.setBounds (190,20,400,50);
  title2.setVisible(true);
  instructionPanel.add(title2);
  
  theRuleOfChess=new JLabel("the Rule of Chess");
  theRuleOfChess.setBounds(220,180,400,50);
  theRuleOfChess.setVisible(true);
  theRuleOfChess.setFont( new Font("Georgia", Font.BOLD , 40));
  instructionPanel.add(theRuleOfChess);
 
  int iBStartingHPos=40;//instruction buttons starting horizontal postition 
  String iBText="king";
  for (int x=0;x<6;x++)
  {
   gamePieceInstructionButtons[x]= new JButton();
   switch(x)
   {
   case 0:
    iBText="King";
    gamePieceInstructionButtons[x].setIcon(blackKing);
    gamePieceInstructionButtons[x].setBackground(Color.white);
    break;
   case 1:
    iBText="Queen";
    gamePieceInstructionButtons[x].setIcon(whiteQueen);
    gamePieceInstructionButtons[x].setBackground(Color.black);
    break;
   case 2:
    iBText="Pawn";
    gamePieceInstructionButtons[x].setIcon(blackPawn);
    gamePieceInstructionButtons[x].setBackground(Color.white);
    break;
   case 3:
    iBText="Rook";
    gamePieceInstructionButtons[x].setIcon(whiteRook);
    gamePieceInstructionButtons[x].setBackground(Color.black);
    break;
   case 4:
    iBText="Knight";
    gamePieceInstructionButtons[x].setIcon(blackKnight);
    gamePieceInstructionButtons[x].setBackground(Color.white);
    break;
   case 5:
    iBText="Bishop";
    gamePieceInstructionButtons[x].setIcon(whiteBishop);
    gamePieceInstructionButtons[x].setBackground(Color.black);
    break;
   }  
   gamePieceInstructionButtons[x].setBounds(iBStartingHPos,90,80,80);
   iBStartingHPos+=120;
   gamePieceInstructionButtons[x].setName(iBText+"");
   gamePieceInstructionButtons[x].addActionListener(this);
   instructionPanel.add(gamePieceInstructionButtons[x]); 
   
  }
  
  mainInstruction = new JButton("MAIN INSTURCTIONS");
  mainInstruction.setBounds(350 ,460,200,50);
  mainInstruction.setVisible(false);
  mainInstruction.addActionListener(this);
  instructionPanel.add(mainInstruction);
  
  instructionBox = new JTextArea (" Chess is a game played by two players. One player plays with the white pieces, and the other player plays with the black pieces. " +
     "Each player has sixteen pieces in the beginning of the game: one king, one queen, two rooks, two bishops, two knights, and eight pawns.\n Click on any of" +
     "the game pieces for insturctions upon individual game pieces ");// this creates a new JTextArea
 
  instructionBox.setFont(new Font("Georgia", Font.BOLD , 30));
  instructionBox.setLineWrap(true);
  instructionBox.setWrapStyleWord(true); 
  instructionBox.setBounds(20,250,750,250); 
  instructionBox.setEditable(false);// can not edit words in this textArea
  instructionPanel.add( instructionBox);// add it to instruction panel 
    
 
  int gPStartingHpos=70;// gamepiece starting horizontal position
  int gPStartingYpos=100;/// gamepiece starting vertical postion 
  int columnNum=0;
  Color yellow=new Color( 239,234,41);
  Color lime= new Color(171,230,49);
  
  for (int x=0;x<64;x++)
  {
   gameBoard[x]=new JButton();
   
   if (x%8==0 || x == 0)
   {
      columnNum++;
      gPStartingHpos=70;
      gPStartingYpos+=70;
   }
   else
   {
     gPStartingHpos+=70;
   }
   if (columnNum%2==0)
   {
    if (x%2==0)
    {
     gameBoard[x].setBackground(yellow);
    }
    else 
    {  
     gameBoard[x].setBackground(lime);
    }
   }
   else // columnNum%2!=0
   {
    if (x%2==0)
    {
     gameBoard[x].setBackground(lime);
    } 
    else
    {
     gameBoard[x].setBackground(yellow);
    }
   }
     
   if ((columnNum==1)||(columnNum==2))
   {
    gameBoard[x].setActionCommand("white");

     
   }
   else if ((columnNum==7)||columnNum==8)
   {
    gameBoard[x].addActionListener(this);
    gameBoard[x].setActionCommand("black"); 
   }
   else 
   {
     
    gameBoard[x].setActionCommand("blank");
   }
   // initialize all the buttons starting pos( e.g button 0= rook) 
   if (x==0||x==7||x==56||x==63)
   {
    gameBoard[x].setName("rook");
    
    
    if(gameBoard[x].getActionCommand().equals("white"))
     gameBoard[x].setIcon(whiteRook);
    else
     gameBoard[x].setIcon(blackRook);
   }
   else if (x==1||x==6||x==57||x==62)
   {
    gameBoard[x].setName("knight");
     
    if(gameBoard[x].getActionCommand().equals("white"))
     gameBoard[x].setIcon(whiteKnight);
    else
     gameBoard[x].setIcon(blackKnight);
   }
   else if (x==2||x==5||x==58||x==61)
   {
    gameBoard[x].setName("bishop");
    
    if(gameBoard[x].getActionCommand().equals("white"))
     gameBoard[x].setIcon(whiteBishop);
    else
     gameBoard[x].setIcon(blackBishop);
   }
   else if (x==4||x==60)
   { 
    gameBoard[x].setName("queen");
    if(gameBoard[x].getActionCommand().equals("white"))
     gameBoard[x].setIcon(whiteQueen);
    else
     gameBoard[x].setIcon(blackQueen);
   }
   else if (x==3||x==59)
   {
    gameBoard[x].setName("king");
    if(gameBoard[x].getActionCommand().equals("white"))
     gameBoard[x].setIcon(whiteKing);
    else
     gameBoard[x].setIcon(blackKing);
   }
   else if(columnNum==2||columnNum ==7)
   {
    gameBoard[x].setName("pawn");
    if(gameBoard[x].getActionCommand().equals("white"))
     gameBoard[x].setIcon(whitePawn);
    else 
     gameBoard[x].setIcon(blackPawn);
   }
   else 
   {
    gameBoard[x].setName("ngp");// ngp= no game piece 
   }
   
   gameBoard[x].setBounds(gPStartingHpos,gPStartingYpos,70,70);
   gameBoard[x].setVisible(false);
   gamePanel.add(gameBoard[x]);
     
  }

  
  beginner= new JRadioButton("Beginner" ,true );
  advanced= new JRadioButton("Advanced" ,false);
  beginner.setBounds(230,550,140,80 );
  advanced.setBounds( 390,550,140,80);
  beginner.setBackground(backgroundColor);
  beginner.setFont((new Font("Georgia", Font.BOLD , 20)));
  advanced.setFont((new Font("Georgia", Font.BOLD , 20)));
  advanced.setBackground(backgroundColor);
  ButtonGroup bgroup = new ButtonGroup();
  beginner.addActionListener(this);
  advanced.addActionListener(this);
  bgroup.add(beginner );
  bgroup.add(advanced);
  gamePanel.add(beginner);
  gamePanel.add(advanced); 
  // intializing displayYButtonLocation
  // display " a " under the last button of column 1 
  // display " b" under  the last button of column 2
  //... thus displaying the  vertical position of each button 
  gPStartingHpos=30;
  for (int x=0;x<8;x++)
  {
  String text=""; 
  switch(x)
  {
  case 0:
   text="a";
   break;
  case 1:
   text="b";
   break;
  case 2:
   text="c";
   break;
  case 3:
   text="d";
   break;
  case 4:
   text="e";
   break;
  case 5:
   text="f";
   break;
  case 6:
   text="g";
   break;
  case 7:
   text="h";
   break;
  }
  displayButtonYLocation[x]=new JLabel(text);
  gPStartingHpos+=70;
  displayButtonYLocation[x].setBounds(gPStartingHpos,gPStartingYpos+70,70,70);
  displayButtonYLocation[x].setVisible(false);
  gamePanel.add(displayButtonYLocation[x]);
  
  
  }
  //intializing displayHButtonLocation
  // before first button of row 1, it will say 1
  // before second button of row 2, it will say 2
  //.... and thus intializing the horizontal position of each button 
    
  gPStartingYpos=100; 
  int num=1;
  for (int x=0;x<8;x++)
  {
 
   displayButtonHLocation[x]=new JLabel(num+"");
   displayButtonHLocation[x].setVisible(false);
   gPStartingYpos+=70;
   displayButtonHLocation[x].setBounds(35,gPStartingYpos,70,70);
   num++;
   gamePanel.add(displayButtonHLocation[x]);
   
  }
  
  
  String gamePieceType="";
 
  int gamepieceYpos=125; 
  for (int o=0;o<7;o++)
  {
   gamepieceTypeLeftOver[o]= new JLabel();
   switch(o)
   {
   case 0:
    gamePieceType="Pieces Left:";
    break;
   case 1:
    gamePieceType ="King";
    break;
   case 2:
    gamePieceType="Queen";
    break;
   case 3:
    gamePieceType="Pawn";
    break;
   case 4:
    gamePieceType="Rook";
    break;
   case 5:
    gamePieceType="Knight";
    break;
   case 6:
    gamePieceType="Bishop";
    break;
   }  
   gamepieceTypeLeftOver[o].setBounds(640,gamepieceYpos,85,30);
   gamepieceYpos+=35;
   gamepieceTypeLeftOver[o].setText( gamePieceType);
   gamepieceTypeLeftOver[o].setVisible(false); 
   gamePanel.add(gamepieceTypeLeftOver[o]); 
  }
  
   int p1LeftOverGamePiecesYpos=125;
  for (int o=0;o<7;o++)
  {
    player1LeftOverGamePieces[o]= new JLabel( "");
    
   player1LeftOverGamePieces[o].setBounds(800,p1LeftOverGamePiecesYpos,155,30);
   p1LeftOverGamePiecesYpos+=35;
   player1LeftOverGamePieces[o].setVisible(false);
   gamePanel.add(player1LeftOverGamePieces[o]); 
  }
  
   
    
   int p2LeftOverGamePiecesYpos=125;
  for (int o=0;o<7;o++)
  {
    
    if(o==0)
    {
     player2LeftOverGamePieces[o]= new JLabel(   player2.getText());
    }
    else
    {
      
    player2LeftOverGamePieces[o]= new JLabel(  "" );
    
    }
   player2LeftOverGamePieces[o].setBounds(960,p2LeftOverGamePiecesYpos ,155,30);
   p2LeftOverGamePiecesYpos+=35;
   player2LeftOverGamePieces[o].setVisible(false);
  
   gamePanel.add(player2LeftOverGamePieces[o]); 
  }
   
  numberOfMoves=new JLabel("total turns:" );
  numberOfMoves.setFont(new Font("Georgia", Font.BOLD , 45));
  numberOfMoves.setBounds(670,670,320,100);
  numberOfMoves.setVisible(false);
  gamePanel.add(numberOfMoves);
  
  
  displayTurn=new JLabel(" ");
  displayTurn.setFont(new Font("Georgia", Font.BOLD , 35));
  displayTurn.setBounds( 670,10,420,100);
  displayTurn.setVisible( false );
  gamePanel.add(displayTurn);

  
  
  Font movesFont= new  Font("Georgia", Font.BOLD , 20);
  movesInTheGame = new JTextArea ("                  MOVE HISTORY: ") ;
  movesInTheGame.setToolTipText("This Text Box describes  move histories in the game ");
  movesInTheGame.setWrapStyleWord(true); 
  movesInTheGame.setLineWrap(true);// when the words exceed the xpos of this box it will go on to the next line 
  movesInTheGame.setBounds(660,380,400,190); 
  movesInTheGame.setFont(movesFont);
  //movesInTheGame.setBackground(Color.BLACK);  
  movesInTheGame.setEditable(false); 
   movesInTheGameScrollBar= new JScrollPane(movesInTheGame);// makes outputBoxScrollBarScrollBar the same as the outputBoxScrollBar text area 
  // outputBoxScrollBar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);---> default method for horizontal scroll
  // since lineWrap is set, no horizontal Scroll will ever be displayed because it is never needed
  // outputBoxScrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);----> default method for vertical scroll
  // a vertical scroll bar will appear when the text touch the bottom border of the outputBox 
   movesInTheGameScrollBar.setLocation(movesInTheGame.getLocation());// set the location the same as the outputBox 
   movesInTheGameScrollBar.setSize(400,190); 
   movesInTheGameScrollBar.setVisible(false); // set the scrollBar to visible
  gamePanel.add( movesInTheGameScrollBar); // add the userInputScrollBar to the gamePanel
  // because userInputScrollBar thing is the same as the outputBox, only one needs to be added
  
   
  moveablePlace= new JTextArea("                 MOVEABLE PLACE ");
  moveablePlace.setToolTipText("This Text Box discribes where your game piece can move");
  moveablePlace.setWrapStyleWord(true);
  moveablePlace.setLineWrap(true);
  moveablePlace.setBounds(660,580,400,120);
  moveablePlace.setFont(movesFont);
  moveablePlace.setEditable(false);
  moveablePlaceScrollBar = new JScrollPane(moveablePlace);
  moveablePlaceScrollBar.setLocation(moveablePlace.getLocation());
  moveablePlaceScrollBar.setSize(400,120);
  moveablePlaceScrollBar.setVisible(false);
  gamePanel.add(moveablePlaceScrollBar);
   
  blackCastling = new JButton("BLACK CASTLING");
  blackCastling.setBounds(700 ,755,140,30);
  blackCastling.setBackground(Color.black);
  blackCastling.setForeground(Color.white);
  blackCastling.setVisible(false);
  blackCastling.addActionListener(this);
  gamePanel.add( blackCastling);
  
  whiteCastling = new JButton("WHITE CASTLING");
  whiteCastling.setBounds(900 ,755,140,30);
  whiteCastling.setBackground(Color.white);
  whiteCastling.setForeground(Color.black);
  whiteCastling.setVisible(false);
  whiteCastling.addActionListener(this);
  gamePanel.add( whiteCastling);
   
  
   
    displayWhoWon=new JLabel( ""  );
    
     displayWhoWon.setFont(movesFont);
    displayWhoWon.setBounds(40,120,300,60);
   displayWhoWon.setVisible(true);
   scorePanel.add(displayWhoWon);

   ySaveScore = new JButton("YES ");
   ySaveScore.setBounds(10,350,100,100);
   ySaveScore.setVisible(true);
   ySaveScore.addActionListener(this);
   scorePanel.add(ySaveScore);
   
   gameScore=new JLabel(" " );
   gameScore.setBounds(10,150,300,100);
   gameScore.setFont(movesFont);
   gameScore.setVisible(true);
   scorePanel.add(gameScore);

   nSaveScore = new JButton("NO");
   nSaveScore.setBounds(150,350,100,100);
   nSaveScore.setVisible(true);
   nSaveScore.addActionListener(this);
   scorePanel.add(nSaveScore);
   
   saveScore =new JLabel("SAVE SCORE?");
   saveScore.setFont(movesFont);
   saveScore.setBounds(45,210,300,100);
   saveScore.setVisible(true);
   scorePanel.add(saveScore);
   
   beginnerHighScores= new JTextArea();
   beginnerHighScores.setWrapStyleWord(true); 
   beginnerHighScores.setLineWrap(true); 
   beginnerHighScores.setBounds(350,70,400,250); 
   beginnerHighScores.setEditable(false); 
   beginnerHighScrollBar= new JScrollPane(beginnerHighScores); 
   beginnerHighScrollBar.setLocation(beginnerHighScores.getLocation()); 
   beginnerHighScrollBar.setSize(400,250); 
   beginnerHighScrollBar.setVisible(true); 
   scorePanel.add(beginnerHighScrollBar);  
   
   advancedHighScores = new JTextArea ("");  
   advancedHighScores.setWrapStyleWord(true); 
   advancedHighScores.setLineWrap(true); 
   advancedHighScores.setBounds(350,370,400,250); 
   advancedHighScores.setEditable(false);
   advancedHighScrollBar= new JScrollPane(advancedHighScores); 
   advancedHighScrollBar.setLocation(advancedHighScores.getLocation()); 
   advancedHighScrollBar.setSize(400,250); 
   advancedHighScrollBar.setVisible(true);  
   scorePanel.add(advancedHighScrollBar);  
    
   displayAdvancedScore=new JLabel(" Advanced High Score " );
   displayAdvancedScore.setBounds(350,340,400,25);
   displayAdvancedScore.setVisible(true);
   scorePanel.add(displayAdvancedScore);
  
   displayBeginnerScore=new JLabel(" Beginner High Score " );
   displayBeginnerScore.setBounds(350,40,400,25);
   displayBeginnerScore.setVisible(true );
   scorePanel.add(displayBeginnerScore);
   
  gameFrame.repaint();
  gameFrame.validate();
  gamePanel.repaint();
  gamePanel.validate();
 }// end of constructor 
 
 
 public void recalculateHowManyGamePiecesLeft()
 {
  NumberOfGamePiecesLeft gamePiecesLeft= new NumberOfGamePiecesLeft (this);
  bPawnLeft=gamePiecesLeft.getNumberOfButtons("pawn",true);
  wPawnLeft=gamePiecesLeft.getNumberOfButtons("pawn",false);
  
  bRookLeft=gamePiecesLeft.getNumberOfButtons("rook",true);
  wRookLeft=gamePiecesLeft.getNumberOfButtons("rook",false);
  
  bQueenLeft=gamePiecesLeft.getNumberOfButtons("queen",true);
  wQueenLeft=gamePiecesLeft.getNumberOfButtons("queen",false);
  
  bBishopLeft=gamePiecesLeft.getNumberOfButtons("bishop",true);
  wBishopLeft=gamePiecesLeft.getNumberOfButtons("bishop",false);
  
  bKingLeft=gamePiecesLeft.getNumberOfButtons("king",true);
  wKingLeft=gamePiecesLeft.getNumberOfButtons("king",false);
  
  bKnightLeft=gamePiecesLeft.getNumberOfButtons("knight",true);
  wKnightLeft=gamePiecesLeft.getNumberOfButtons("knight",false);
 }
 /**
  * set the game as a win 
  */
 public JFrame getGameFrame()
 {
  return gameFrame;
 }
 public JPanel getGamePanel()
 {
  return gamePanel;
 }
 
public void setWon()
 {
  ifWon=true;
   gameScore.setText("GameScore"+numOfMoves);

   if(ifBlack)
   {
    displayWhoWon.setText(player2.getText()+" WON ! " );
   }
   else
   {
    displayWhoWon.setText(player1.getText()+" WON ! "  );
   }
  scoreFrame.setVisible(true);
   gamePanel.setVisible(false);
   scorePanel.setVisible(true); 
    
  
    
//    get the text from notepad and set them into the JTextArea below 
//   advancedHighScores
//   beginnerHighScores
    
 }
 public String outputAnInterestingFact()
 {
  String interstingFact="";
  IO.openInputFile("intersting facts.txt");
  int random=(int)(Math.random() * ((20 - 0) + 1));
  for (int x=0; x<random;x++)
  {
   try {
    interstingFact=IO.readLine();
   } catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   }
  }
  interstingFact ="                 INTERSTING FACT \n\n             DO YOU KNOW THAT.... \n\n"+interstingFact;
  return interstingFact;
 }


 public String firstPlayerName()
 {
  return player1.getText();
 }
 public String secondPlayerName()
 {
  return player2.getText();
 }
 public void setMovesInTheGame(String whatHappened)
 {
  movesInTheGame.setText(movesInTheGame.getText()+"\n"+whatHappened);
 }
 /** 
  * get the value of the  previousGamePieceButtonNum 
  *in order to check for which two buttons to swap
  */
 public void setMoveablePlace(String moveables)
 {
  moveablePlace.setText("                 MOVEABLE PLACE \n"+ moveables);
 }
 public int getPreviousGamePieceButtonNum()
 {
  return  previousGamePieceButtonNum; 
 }

 /**
  * the following method will get the location a game piece which was pressed and this will help out with chekcing for win/moves of that button
  */
 public int  getButtonNumber()
 {
  return buttonNum;
 }

 public int getNumOfMoves()
 {
  return numOfMoves;
 }
  
 public boolean getIfBlack()
 {
  
  return ifBlack;
 }
 
 public void setIfBlack(boolean ifBlackOrWhite)
 {
   ifBlack= ifBlackOrWhite;
 }
 
 public String getButtonLocation(int buttonNum)
 {
  String o="";
  if (buttonNum%8==0)
  {
   o ="a";
  }
  else if (buttonNum%8==1)
  {
   o="b";
  }
  else if (buttonNum%8==2)
  {
   o="c";
  }
  else if (buttonNum%8==3)
  {
   o="d";
  }
  else if (buttonNum%8==4)
  {
   o="e";
  }
  else if (buttonNum%8==5)
  {
   o="f";
  }
  else if (buttonNum%8==6)
  {
   o="g";
  }
  else //buttonNum%8==7
  {
   o="h";
  }
  if (buttonNum<=7)
  {
   o+="1";
  }
  else if (buttonNum>7&&buttonNum<=15)
  {
   o+="2";
  }
  else if (buttonNum>15&&buttonNum<=23)
  {
   o+="3";
  }
  else if (buttonNum>23&&buttonNum<=31)
  {
   o+="4";
  }
  else if (buttonNum>31&&buttonNum<=39)
  {
   o+="5";
  }
  else if (buttonNum>39&&buttonNum<=47)
  {
   o+="6";
  }
  else if (buttonNum>47&&buttonNum<=55)
  {
   o+="7";
  }
  else 
  {
   o+="8";
  }
  return o;
 }
 
 public JButton[] getGameBoard()
 {
  return gameBoard;
 }
 
 public void setGameBoard(JButton buttons[])
 {
  for (int x=0;x<64;x++)
  {
   gameBoard[x]=buttons[x];
  }
 }
 
 public void setWhiteCastled()
 {
  
    ifWhiteCastled=true;
 }
 
  
 public void setBlackCastled()
 {
    ifBlackCastled= true;
 }
  
  public void ClearConsole() {
         //for (int i = 0; i < 64; i++)
                 //System.out.println("\n");
  } 
 public void resetButtonImage()
 {  
  ClearConsole();
  for (int i=0;i<64;i++)
  {
     
   
   if(!gameBoard[i].getActionCommand().equalsIgnoreCase("blank"))
   { 
        if(gameBoard[i].getActionCommand().equalsIgnoreCase("black")&&(gameBoard[i].getName().contains(".")))
        { 
          
           if(beginner.isSelected())
           {
          if (gameBoard[i].getName().contains("rook"))
          {
           gameBoard[i].setIcon( blackRookDot);
          } 
          else if (gameBoard[i].getName().contains("knight"))
          {
           gameBoard[i].setIcon( blackKnightDot);
          }
          else if (gameBoard[i].getName().contains("bishop"))
          {
           gameBoard[i].setIcon( blackBishopDot); 
          }
          else if (gameBoard[i].getName().contains("queen"))
          {
           gameBoard[i].setIcon( blackQueenDot);
          }
          else if (gameBoard[i].getName().contains("king"))
          { 
           gameBoard[i].setIcon( blackKingDot);
          }
          else if (gameBoard[i].getName().contains("pawn"))
          {
           gameBoard[i].setIcon( blackPawnDot);
          }
          
           }
        }// end of if  (gameBoard[i].getName().contains(".")&& gameBoard[i].getActionCommand().equalsIgnoreCase("black")&&( ifShowPlaceableMoves))
       
          else 
         {
               
           if (gameBoard[i].getActionCommand().equalsIgnoreCase("black"))
           {
           
            
            if (gameBoard[i].getName().contains("rook") )
            {
             gameBoard[i].setIcon( blackRook );
            } 
            else if (gameBoard[i].getName().contains("knight"))
            {
             gameBoard[i].setIcon( blackKnight );
            }
            else if (gameBoard[i].getName().contains("bishop"))
            {
             gameBoard[i].setIcon( blackBishop ); 
            }
            else if (gameBoard[i].getName().contains("queen"))
            {
             gameBoard[i].setIcon( blackQueen );
            }
            else if (gameBoard[i].getName().contains("king"))
            { 
             gameBoard[i].setIcon( blackKing );
            }
            else if (gameBoard[i].getName().contains("pawn"))
            {
             gameBoard[i].setIcon( blackPawn );
            }
             
           }
          
         }// end of else no dot 
      
       if(gameBoard[i].getActionCommand().equalsIgnoreCase("white")&&(gameBoard[i].getName().contains(".")))
      {
        
         if( beginner.isSelected())
         {
         if (gameBoard[i].getName().contains("rook"))
         {
          gameBoard[i].setIcon( whiteRookDot);
         } 
         else if (gameBoard[i].getName().contains("knight"))
         {
          gameBoard[i].setIcon( whiteKnightDot);
         }
         else if (gameBoard[i].getName().contains("bishop"))
         {
          gameBoard[i].setIcon( whiteBishopDot); 
         }
         else if (gameBoard[i].getName().contains("queen"))
         {
          gameBoard[i].setIcon( whiteQueenDot);
         }
         else if (gameBoard[i].getName().contains("king"))
         { 
          gameBoard[i].setIcon( whiteKingDot);
         }
         else if (gameBoard[i].getName().contains("pawn"))
         {
          gameBoard[i].setIcon( whitePawnDot);
         }
          
         }
         
      }// end of if gameBoard[i].getName().contains(".")
      else 
      {
        
       if( gameBoard[i].getActionCommand().equalsIgnoreCase("white"))
       {
        if (gameBoard[i].getName().contains("rook"))
        {
         gameBoard[i].setIcon( whiteRook );
        } 
        else if (gameBoard[i].getName().contains("knight"))
        {
         gameBoard[i].setIcon( whiteKnight );
        }
        else if (gameBoard[i].getName().contains("bishop"))
        {
         gameBoard[i].setIcon( whiteBishop ); 
        }
        else if (gameBoard[i].getName().contains("queen"))
        {
         gameBoard[i].setIcon( whiteQueen );
        }
        else if (gameBoard[i].getName().contains("king"))
        { 
         gameBoard[i].setIcon( whiteKing );
        }
        else if (gameBoard[i].getName().contains("pawn"))
        {
         gameBoard[i].setIcon( whitePawn );
        }
       }
        
      }// end of else  !gameBoard[i].getName().contains(".")
     
      
    }// end of !gameBoard[i].getActionCommand().equalsIgnoreCase("blank")
   
    
   else// if (gameBoard[i].getName().contains("ngp"))
   {
    
     if (beginner.isSelected())
     {  
      if(gameBoard[i].getName().contains("."))
      {
       if (ifBlack)
       {
         
        gameBoard[i].setIcon(blackDot);
        
       }
       else 
       {
        gameBoard[i].setIcon(whiteDot);
        
       }
      }
      
     }
     if(gameBoard[i].getName().contains("ngp"))
     {
      
      gameBoard[i].setIcon(null);

     }
   }
  } 
     
 }
 
  
 public void actionPerformed( ActionEvent e) 
 {
   
   if (e.getSource()== ySaveScore)
  {
    
    String loser="";
    String winner ="";
    if (ifBlack)
    {
     winner=player1.getText();
     loser=player2.getText();
    }
    else
    {
     winner= player2.getText();
     loser=player1.getText();
    }
    
      
    if (beginner.isSelected())
    {
     beginnerHighScores.setText("");
    }
    else
    {
     advancedHighScores.setText("");
    }
     ySaveScore.setVisible(false);
     nSaveScore.setVisible(false);
     saveScore.setText("score is saved");
  }
   else if (e.getSource()==readInterstingFacts)
   {
    introduction.setText(outputAnInterestingFact());
   }
  else if (e.getSource()== nSaveScore)
  {
    ySaveScore.setVisible(false);
     nSaveScore.setVisible(false);
     saveScore.setText("score is discard");
  }
  else if (e.getSource()==startButton)// if start button was pressed 
   { 
    if (e.getSource()==advanced)
    {
     System.out.println("advanced was chosen");
      advanced.setVisible(false);
      beginner.setVisible(false);
    }
    else if (e.getSource()==beginner)
    {
     System.out.println("beginner was chosen");
     beginner.setVisible(false);
      advanced.setVisible(false);
    }
    String name1="";
    String name2="";
    int shortestName;
    
    if (player1.getText().length()==0)
    {
     if (player2.getText().length()==0)// if both player's have not entered a name 
     {
      JOptionPane.showMessageDialog(null, "PLEASE ENTER PLAYER ONE AND TWO's NAME ","ERROR",0);
     }
     else 
     {
      JOptionPane.showMessageDialog(null, "PLEASE ENTER PLAYER's NAME ","ERROR",0);
     }// end of else player2.getText().length!=0
    }// end of if (player1.getText().length()==0)
    else if (player2.getText().length()==0)
    {
     JOptionPane.showMessageDialog(null, "PLEASE ENTER PLAYER TWO'S NAME ","ERROR",0);
    }//end of else  (player2.getText().length()==0)
    
    else if (player1.getText().length()>10)
    {
     if (player2.getText().length()>10)
     {
      JOptionPane.showMessageDialog(null, "PLAYER 1 AND PLAYER 2's NAMES ARE TOO LONG. \n ONLY 10 CHARACTORS PLEASE","ERROR",0);
     }// end of if player2.getText().length()>10
     else
     {
      JOptionPane.showMessageDialog(null, "PLAYER 1'S NAME IS TOO LONG. \n PLEASE RE-ENTER A NAME WITH \n ONLY 10 CHARACTORS PLEASE","ERROR",0);
      
     }// end of else only player 1.getText.length()>10
    }// end of else if  (player1.getText().length()>10 )
    else if (player2.getText().length()>10)
    {
     JOptionPane.showMessageDialog(null, "PLAYER 2'S NAME IS TOO LONG. \n PLEASE RE-ENTER A NAME WITH \n ONLY 10 CHARACTORS PLEASE","ERROR",0);
    }// end of else if  ( player2.getText().length()>10) 
    else// both player 1 and player 2's name is more then 0 letters long and less then 10 letters long
    { 
     if (player1.getText().trim().equals(player2.getText().trim() ))// they are the same name 
     {
      JOptionPane.showMessageDialog(null, "THIS IS A TWO PLAYER GAME, PLAYER 1'S NAME IS THE SAME AS PLAYER 2'S. \n RE ENTER A DIFFERENT NAME PLEASE","ERROR",0);
     }
     else
     {
        if (player1.getText().length()>5||player2.getText().length()>5)
      {
       displayTurn.setFont(new Font("Georgia", Font.BOLD , 24));
      }
      System.out.println(player1.getText());
      System.out.println(player2.getText());
      gameFrame.resize(1100,826);
      // make everything on the first page disappear
      player1.setVisible(false);
      player2.setVisible(false);
      displayPlayer1Name.setVisible(false);
      displayPlayer2Name.setVisible(false);
      startButton.setVisible(false);
      chessInstructions.setVisible(false);
      introductionScrollPane.setVisible(false);
      pleaseEnter.setVisible(false);
      displayTurn.setText(player1.getText()+"(BLACK)'s turn");
      setMovesInTheGame(player1.getText()+" : ");
      
      whiteCastling.setVisible(true);
       
       if (beginner.isSelected())
       {
        moveablePlaceScrollBar.setVisible(true);// because this shows where a game piece can move to , and ifShowIfMovablePiece determines whether or not the players wants to see where the game piece can go
                   // therefore , this should only be visible if the player wants to see where a game piece can be moved
       }
       
      for (int x=0;x<64;x++)
      {
       if (x>=0&&x<8)
       {
        displayButtonYLocation[x].setVisible(true);// those two arrays only go up to 8
        displayButtonHLocation[x].setVisible(true);
        if (x>=0&&x<7)
        {
         gamepieceTypeLeftOver[x].setVisible(true);// this array only goes up to 7
         player1LeftOverGamePieces[x].setVisible(true);
         player2LeftOverGamePieces[x].setVisible(true);
          
        }
       } 
       gameBoard[x].setVisible(true);
      }
      displayTurn.setVisible( true );
      displayTurn.setText(player1.getText()+"'s turn");
      numberOfMoves.setVisible(true);
       movesInTheGameScrollBar.setVisible(true); 
       
      blackCastling.setVisible(true);
      
     }
     
     
    }// end of else both  player1.getText.length and player2.getText.length is bigger then 0 and smaller then 10
   }// end of if startButton was pressed 
  
   else if (e.getSource()==chessInstructions)// if chessInsturctions button was pressed 
   { 
    instructionFrame.setVisible(true);
   }// end of else if chessInstructions button was pressed 
   else if (e.getSource()==mainInstruction)// if the main instructions from the instructionPanel was pressed 
   {
    
    instructionBox.setText("");
    // reset the bounds of all gamePiece Instruction buttons to identicate that no individual gamePieceButton has been pressed 
    int yPos=430;// vertical position, starting position ,from the lowest button to the first 
    for (int y=5;y>=0;y--)
    {
     gamePieceInstructionButtons[y].setBounds(20, yPos,150,70);
     yPos=yPos-80;
    }// end of for loop 
   }// end of if mainInstruction buttons was pressed 
   else if (e.getSource()==whiteCastling)
   {
    
     if(numOfMoves%2!=0)
     {
      FourOtherMethods checkForCastling= new FourOtherMethods(this);
     checkForCastling.Castling( );
     
     }
     resetButtonImage();
   }
   else if (e.getSource()==blackCastling)
   {
    
     if(numOfMoves%2==0)
     {
      FourOtherMethods checkForCastling= new FourOtherMethods(this);
      checkForCastling.Castling( ); 
      
     }
     resetButtonImage();
   }
   
   else
   {
     for ( int x=0;x<6;x++)
    {
     if (e.getSource()==gamePieceInstructionButtons[x])
     {
      
      // the following makes all the instruction game pieces except for the one pressed a smaller size and 
      // only displays the button text where as the button that was pressed would display a picture
      // and has bigger size so the user knows 
      // which  button was pressed and what the instruction displayed is on 
      //e.g:if king was pressed then the bigger button would be king and it would display an image of the king on the button rather then the text 
  
       int startingYpos=450;// the position of the last instruction button on the board
           // the starting postion of the whole buttons( counts from the last one to the first one ) 
       for (int y=5;y>=0;y--)// use a for loop to set the bounds of all the buttons 
       {
        if (y==5)// if the last button was pressed 
        {
         if (y==x)// if the last button is button that user has pressed 
           
         {
          startingYpos=360; // because the height of the pressed button is set as a larger number then the other buttons pressed 
              // since the button that is pressed needs to be a bigger size then the rest of the buttons
                 // therefore when the button was pressed was the middle buttons or the first button, the end button's height
             // is only 60, and it ends at 450+60=510. However, because that when the button is the same button that is pressed by the user 
             // then the height increases to 150 and the ending point would be 450+150=600. Which would go out of bounds of the applet 
             // Also ,since the other buttons are located based on the button below( counts from down to up), therefore when
             // the button that was pressed's height is 150, non of the buttons above's height would be 150, and would all be   
             // 60, so the first button's vertical position would be 450- 5x70=100 instead of 450-4x70-1x160= 10, so it looks 
             // as if everything was drifted down one. therefore it is important to set the starting position of the last 
             // last piece as 360, so that the ending point of the last button would be 360+150=510 and the starting postition would be
             // 360-5x70=10 still. 
          gamePieceInstructionButtons[y].setBounds(20,startingYpos,150,150);
         }// end of if (y==x)
         else// the fifth button is not that the user has pressed
         {
          gamePieceInstructionButtons[y].setBounds(20,startingYpos,150,60);// set the bounds of the last button, set the y postition as the starting postiton
         }// end of else (y==x)
        }// end of y==5
        else if  (y==x)// if the button that was pressed was not the last button  
        {
         
         startingYpos= gamePieceInstructionButtons[y+1].getY()-150-10;// set the starting postion as the next button's vertical postiton subtracting 
                        // the height of the button itself ( because the vertical position  of the button is the  
                        // top of the button ) and then subtracting 10 from it ( 10 for the space between
                        // the two buttons) 
         gamePieceInstructionButtons[y].setBounds(20,startingYpos,150,150);// set the bounds of the new button 
        
        }// end of if (y==x)
        else// the buttons that was not pressed nor was it the last button
        {  
         startingYpos= gamePieceInstructionButtons[y+1].getY()-60-10;// same logic above, expect subtracting 60 because the height of the button itself
                        // is 60 not 150 
         gamePieceInstructionButtons[y].setBounds(20,startingYpos,150,60);
        }// end of else statment      
       }// end of for loop 
       
       switch (x)// set the text of the instructionBox to the instruction of whichever game piece was pressed
       {
       case 0:
        instructionBox.setText("HOW TO WIN: \n hi");
        break;
       case 1:
        instructionBox.setText("");
        break;
       case 2:
        instructionBox.setText("");
        break;
       case 3:
        instructionBox.setText("");
        break;
       case 4:
        instructionBox.setText("");
        break;
       case 5:
        instructionBox.setText("");
        break;
       }// end of switch (x)
       theRuleOfChess.setText("The Rule Of "+ gamePieceInstructionButtons[x].getName());// set the label which display the rules of chess to the rule of 
                             // whatever game piece (button) that the user has pressed  
       theRuleOfChess.setBounds(240,70,400,50);
      instructionBox.setBounds(200,130,550,300);
      
      mainInstruction.setVisible(true);
     }// end of if gamePieceInstructionButtons[x] was pressed 
    } // end of for loop
  
   for (int x=0;x<64;x++)
   { 
   
    if(e.getSource()==gameBoard[x])
    { 
     
      buttonNum=x; 
        if (gameBoard[x].getName().contains("."))
      {
          FourOtherMethods check= new FourOtherMethods(this);
          check.checkForAte();
          System.out.println("asdf");
          numOfMoves++;
          
         
          if(numOfMoves%2==0)
        {
         ifBlack=true;
         setMovesInTheGame(player1.getText()+":");
         blackCastling.addActionListener(this);
         whiteCastling.removeActionListener(this);
          setMoveablePlace(" \n              Click a black game piece! ");// clear the movable place box because at this point the player just played and it is the other player's turn, however the other player has not   pressed anything
             
        }
        else 
        {
         whiteCastling.addActionListener(this);
         blackCastling.removeActionListener(this);
         ifBlack=false;
         setMovesInTheGame(player2.getText()+":");
          setMoveablePlace("\n              Click a white game piece!");// clear the movable place box because at this point the player just played and it is the other player's turn, however the other player has not   pressed anything
             
        }
          
          FourOtherMethods reOrganize= new FourOtherMethods(this);
           reOrganize.reOrganizePreviousButtons();
           reOrganize.refreshAllButtons();
          
           if (!ifBlackCastled)
           {
            if (gameBoard[ buttonNum].getActionCommand().equalsIgnoreCase("black"))
         {
              
            
            if(gameBoard[buttonNum].getName().contains("king"))
              {
                setBlackCastled();
                setMovesInTheGame("Because black king has moved,"+player1.getText()+"can no longer castle");
              }
            else if(gameBoard[buttonNum].getName().contains("rook"))
              {
                setBlackCastled();
                setMovesInTheGame("Because black Rook has moved, "+player1.getText()+"black can no longer castle");
              }
           
         }
           }
           if(!ifWhiteCastled)
           {
            
            if (gameBoard[ buttonNum].getActionCommand().equalsIgnoreCase("white"))
         {
              
            
            if(gameBoard[buttonNum].getName().contains("king"))
              {
                setWhiteCastled();
                setMovesInTheGame("Because white king has moved,"+player2.getText()+"can no longer castle");
              }
            else if(gameBoard[buttonNum].getName().contains("rook"))
              {
                setWhiteCastled();
                setMovesInTheGame("Because white Rook has moved, "+player2.getText()+"black can no longer castle");
              }
         }
           }
            
           
           
           resetButtonImage();
           
      }  
        else if(!gameBoard[x].getName().equalsIgnoreCase("ngp"))
        { 
         // needs to reset all buttons again so that if the user presses a gamepiece such as rook and then changed his/her mind and decided
         // to move another game piece such as pawn instead, the old directions needs to be got rid of  (the .  thats  
         // been set of where the user can place the old rook) and be changed into new directions.  
         FourOtherMethods reOrganize= new FourOtherMethods(this);
          reOrganize.refreshAllButtons();
          
         previousGamePieceButtonNum=x;
       
         
        // the game pieces are .equalsIgnoreCase because in order to check for win and not lose data
     // some gamepieces name must be set there name +"." such as bishop. , so to check for those buttons
        // i used .contains the charactor . and for the other game pieces it has to be exact 
      if (gameBoard[x].getName().equalsIgnoreCase("rook"))
       {
        Rook r= new Rook(this);
        r.checkForPath( ); 
        
      }
      else if ((gameBoard[x].getName().equalsIgnoreCase("bishop")))
      {
        Bishop b = new Bishop( this);
        b.checkForPath();
         
      }
      else if(gameBoard[x].getName().equalsIgnoreCase("king"))
      {
       King ki= new King(this);
       ki.checkForPath();
         
      }
      else if  (gameBoard[x].getName().equalsIgnoreCase("pawn"))
      {
       
        Pawn p= new Pawn (this);
        p.checkForPath();
        
        
      }
      else if  (gameBoard[x].getName().equalsIgnoreCase("queen"))
      {
        
        Queen q= new Queen(this);
        q.checkForPath();
        
      }
      else if  (gameBoard[x].getName().equalsIgnoreCase("knight"))
      { 
        Knight k = new Knight(this);
        k.checkForPath();
         
      }
        }// if any of the game piece buttons are pressed
        else
        {
           
        }
    }// end of buttons on the game board has been pressed
   }// end of for loop 
  }// end of else any other button has been pressed 
   if (ifBlackCastled==true)
   {
     blackCastling.setVisible(false);
   }
   
   if (ifWhiteCastled==true)
   {
    whiteCastling.setVisible(false);
   }
   
   
    recalculateHowManyGamePiecesLeft(); 
    int gamePieceLeft=0;
    for (int o=1;o<7;o++)
    {  
     
     if (o==0)
     {
      player1LeftOverGamePieces [o].setText( player1.getText()) ;
     }
       switch(o)
       {    
       case 1:// first player is black 
        gamePieceLeft =bKingLeft;
        break;
       case  2:
        gamePieceLeft =bQueenLeft;
        break;
       case 3:
        gamePieceLeft =bPawnLeft;
        break;
       case 4:
        gamePieceLeft =bRookLeft;
        break;
       case 5:
        gamePieceLeft =bKnightLeft;
        break;
       case 6:
        gamePieceLeft =bBishopLeft;
        break;
       }  
      player1LeftOverGamePieces [o].setText( gamePieceLeft+"");
      player1LeftOverGamePieces[o].repaint();
     
     }
    
    gamePieceLeft=0;   
   
    for (int o=1;o<7;o++)
    { 
      
     if (o==0)
     {
      player2LeftOverGamePieces [o].setText( player2.getText()+"");
     }
      switch(o)
      {
      case 1:// first player is black 
       gamePieceLeft =wKingLeft;
       break;
      case 2:
       gamePieceLeft =wQueenLeft;
       break;
      case 3:
       gamePieceLeft =wPawnLeft;
       break;
      case 4:
       gamePieceLeft =wRookLeft;
       break;
      case 5:
       gamePieceLeft =wKnightLeft;
       break;
      case 6:
       gamePieceLeft =wBishopLeft;
       break;
      }  
      player2LeftOverGamePieces [o].setText( gamePieceLeft+"");
      player2LeftOverGamePieces[o].repaint();
       
    }
    numberOfMoves.setText("total turns    "+numOfMoves);
   if (numOfMoves%2==0)
   {
    displayTurn.setText(player1.getText()+"( BLACK)'s turn");
   }
   else 
   {
    displayTurn.setText(player2.getText()+"(WHITE)'s turn");
   }
   gameFrame.repaint();
   gameFrame.validate();
   gamePanel.repaint();
   gamePanel.validate();
   
   
 }// end of actionPerformed
}// end of applet