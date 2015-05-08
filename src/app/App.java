package app;
import java.util.*;
import javax.swing.*;
public class App {
 static final char x='x';
 static final char o='O';
 static final char BLANK=' ';
 static char b[]=new char[19];
 static int turn=1,end=0,ans;
 static boolean victory;
 public static void main(String[] args)
 {
   System.out.println("Numbers used to select a move");
   System.out.println("0 | 1 | 2");
   System.out.println("--+---+---");
   System.out.println("3 | 4 | 5");
   System.out.println("--+---+---");
   System.out.println("6 | 7 | 8\n");
   reset();
   Confirm(); // check if you are ready to play
 }
 
static void reset()
 {
  for(int i = 0; i<b.length; i++)
   b[i]=BLANK;
  turn=1;
  victory=false;
  end=0;
 }
 
static void Display()
 {
  System.out.println(" "+b[0]+" | "+b[1]+ " | "+b[2]);
  System.out.println("-----------");
  System.out.println(" "+b[3]+" | "+b[4]+ " | "+b[5]);
  System.out.println("-----------");
  System.out.println(" "+b[6]+" | "+b[7]+ " | "+b[8]+"\n");
 }
 
static void Confirm()
 {
   ans = JOptionPane.showConfirmDialog(null, "Ready to play?");
   switch (ans)
   {
   case JOptionPane.YES_OPTION: 
   {
    Roll(); 
    break;
   }
   case JOptionPane.NO_OPTION: Confirm();
   case JOptionPane.CANCEL_OPTION: End();
   }
   
 }
 
static void Roll() // Roll and see who play first
 {
   Random n = new Random();
   int r = n.nextInt(2);
   if (r==0)
    {
    JOptionPane.showMessageDialog(null, "You first!" );
    youFirst();
    }
    
   else 
    {
    JOptionPane.showMessageDialog(null, "Com first!" );
    comFirst();
    }
 }
 
static void youFirst()
 {
  youGo();
  while(turn<=b.length && end==0)
  {
   if (turn%2==1)     
    youGo();
   else if (turn%2==0)     
    comGoh();
     
  }
  
 }
 
static void comFirst()
 {
  comGoh();
  while(turn<=b.length && end==0)
  {
   if (turn%2==1)
    
     comGoh();
   else if (turn%2==0)
     youGo();
  }
  
 }
 
 static void youGo()
 {
  int p1;
  
  do
  {
   p1 = getPosi();     
  }while(checkPosi(p1)==0);     
  
  b[p1]=x;
  Display();
  checkWin();
  turn++;
 }
 
 static int getPosi()    // get the position and return 
 {
  int a;
  a = Integer.parseInt(JOptionPane.showInputDialog("Show your step(0-8):"));
  if (a>=0&&a<=8)
   return a;
  else if(a==-1)
  {
   End();
   return 0;
  }
   else
   {
    JOptionPane.showMessageDialog(null, "Don't go out the board!");
    return getPosi();
   }
  
 }
 
 static int checkPosi(int i)    //check if the position is occupy
 {
  
  if(!(b[i]==BLANK))
  {
   JOptionPane.showMessageDialog(null, "Oh! You cannot go here!");
   return 0;
  }
  else 
   return 1;
 }
 
 
 static int checkPosi1(int i)      //check if the position is blank
 {
  if(b[i]==BLANK)
   return 1;
  else
   return 0;
 }
 
 
static void comGoh()     //computer plays under hard difficulty
 { 
 
 
 if(turn<=3)
 {
  the1Step();
 }
 else if(turn==4&&b[4]==o&&((b[0]==x&&b[8]==x)||(b[2]==x&&b[6]==x)))
  
  {
  Random r = new Random();   // in order to get a random NO. in 4 specific digits
  int c = r.nextInt(4);
  switch (c)
  {
  case 0: {if(checkPosi1(1)==1) {b[1]=o;Display();turn++;break;}}
  case 1: {if(checkPosi1(3)==1) {b[3]=o;Display();turn++;break;}}
  case 2: {if(checkPosi1(5)==1) {b[5]=o;Display();turn++;break;}}
  case 3: {if(checkPosi1(7)==1) {b[7]=o;Display();turn++;break;}}
  }
  }
 else
  check();
 }
 
static void the1Step()    //the first step the computer goes
 {
  if(b[4]==BLANK)
  {
  b[4]=o;
  Display();
  turn++;
  }
 else 
  {
   Random r = new Random();   // in order to get a random NO. in 4 specific digits
   int c = r.nextInt(4);
   switch (c)
   {
   case 0: {if(checkPosi1(0)==1) {b[0]=o;Display();turn++;break;} }
   case 1: {if(checkPosi1(2)==1) {b[2]=o;Display();turn++;break;}}
   case 2: {if(checkPosi1(6)==1) {b[6]=o;Display();turn++;break;}}
   case 3: {if(checkPosi1(8)==1) {b[8]=o;Display();turn++;break;}}
   }
  }
 }
 
static void check()
{
 if((b[0]==o&&b[4]==o)&&checkPosi1(8)==1)
 {
  b[8]=o;
     Display();
     checkWin();
 }
 else if((b[1]==o&&b[4]==o)&&checkPosi1(7)==1)
 {
  b[7]=o;
     Display();
     checkWin();
 }
 else if((b[2]==o&&b[4]==o)&&checkPosi1(6)==1)
 {
  b[6]=o;
     Display();
     checkWin();
 }
 else if((b[3]==o&&b[4]==o)&&checkPosi1(5)==1)
 {
  b[5]=o;
     Display();
     checkWin();
 }
 else if((b[5]==o&&b[4]==o)&&checkPosi1(3)==1)
 {
  b[3]=o;
     Display();
     checkWin();
 } 
 else if((b[6]==o&&b[4]==o)&&checkPosi1(2)==1)
 {
  b[2]=o;
     Display();
     checkWin();
 }
 else if((b[7]==o&&b[4]==o)&&checkPosi1(1)==1)
 {
  b[1]=o;
     Display();
     checkWin();
 }
 else if((b[8]==o&&b[4]==o)&&checkPosi1(0)==1)
 {
  b[0]=o;
     Display();
     checkWin();
 }
 else if((b[0]==o&&b[6]==o)&&checkPosi1(3)==1)
 {
  
    b[3]=o;
    Display();
    checkWin();
 }
 else if((b[2]==o && b[8]==o)&& checkPosi1(5)==1)
 {
  
    b[5]=o;
    Display();
    checkWin();
 }
 else if((b[0]==o&&b[1]==o)&& checkPosi1(2)==1)
 {
   b[2]=o;
   Display();
   checkWin();
 }
 
 else if((b[1]==o&&b[2]==o)&&checkPosi1(0)==1)
 {
   b[0]=o;
   Display();
   checkWin();
 }
 
 else if((b[6]==o&&b[8]==o)&&checkPosi1(7)==1)
 {
   b[7]=o;
   Display();
   checkWin();
 }
 
 else if((b[0]==o&&b[2]==o)&&checkPosi1(1)==1)
 {
  b[1]=o;
  Display();
  checkWin();
 }
 else if((b[0]==o&&b[3]==o)&&checkPosi1(6)==1)
 {
  b[6]=o;
  Display();
  checkWin();
 }
 else if((b[5]==o&&b[2]==o)&&checkPosi1(8)==1)
 {
  b[8]=o;
  Display();
  checkWin();
 }
 else if((b[5]==o&&b[8]==o)&&checkPosi1(2)==1)
 {
  b[2]=o;
  Display();
  checkWin();
 }
 else if((b[3]==o&&b[6]==o)&&checkPosi1(0)==1)
 {
  b[0]=o;
  Display();
  checkWin();
 }
 else if((b[6]==o&&b[7]==o)&& checkPosi1(8)==1)
 {
  
   b[8]=o;
   Display();
   checkWin();
 }
 else if((b[7]==o&&b[8]==o)&& checkPosi1(6)==1)
 {
  
   b[6]=o;
   Display();
   checkWin();
 }
 else if((b[0]==x&&b[4]==x)&&checkPosi1(8)==1)
 {
	  b[8]=o;
	     Display();
	     checkWin();
	     turn++;
	 }
	 else if((b[1]==x&&b[4]==x)&&checkPosi1(7)==1)
	 {
	  b[7]=o;
	     Display();
	     checkWin();
	     turn++;
	 }
	 else if((b[2]==x&&b[4]==x)&&checkPosi1(6)==1)
	 {
	  b[6]=o;
	     Display();
	     checkWin();
	     turn++;
	 }
	 else if((b[3]==x&&b[4]==x)&&checkPosi1(5)==1)
	 {
	  b[5]=o;
	     Display();
	     checkWin();
	     turn++;
	 }
	 else if((b[5]==x&&b[4]==x)&&checkPosi1(3)==1)
	 {
	  b[3]=o;
	     Display();
	     checkWin();
	     turn++;
	 } 
	 else if((b[6]==x&&b[4]==x)&&checkPosi1(2)==1)
	 {
	  b[2]=o;
	     Display();
	     checkWin();
	     turn++;
	 }
	 else if((b[7]==x&&b[4]==x)&&checkPosi1(1)==1)
	 {
	  b[1]=o;
	     Display();
	     checkWin();
	     turn++;
	 }
	 else if((b[8]==x&&b[4]==x)&&checkPosi1(0)==1)
	 {
	  b[0]=o;
	     Display();
	     checkWin();
	     turn++;
	 }
	 else if((b[0]==x&&b[6]==x)&&checkPosi1(3)==1)
	 {
	  
	    b[3]=o;
	    Display();
	    checkWin();
	    turn++;
	   
	 }
	 else if((b[2]==x && b[8]==x)&& checkPosi1(5)==1)
	 {
	  
	    b[5]=o;
	    Display();
	    checkWin();
	    turn++;
	 }
	 else if((b[0]==x&&b[1]==x)&& checkPosi1(2)==1)
	 {
	   b[2]=o;
	   Display();
	   checkWin();
	   turn++;
	 }
	 
	 else if((b[1]==x&&b[2]==x)&&checkPosi1(0)==1)
	 {
	   b[0]=o;
	   Display();
	   checkWin();
	   turn++;
	  
	 }
	 
	 else if((b[6]==x&&b[8]==x)&&checkPosi1(7)==1)
	 {
	   b[7]=o;
	   Display();
	   checkWin();
	   turn++;
	 }
	 
	 else if((b[0]==x&&b[2]==x)&&checkPosi1(1)==1)
	 {
	  b[1]=o;
	  Display();
	  checkWin();
	  turn++;
	 }
	 else if((b[0]==x&&b[3]==x)&&checkPosi1(6)==1)
	 {
	  b[6]=o;
	  Display();
	  checkWin();
	  turn++;
	 }
	 else if((b[5]==x&&b[2]==x)&&checkPosi1(8)==1)
	 {
	  b[8]=o;
	  Display();
	  checkWin();
	  turn++;
	 }
	 else if((b[5]==x&&b[8]==x)&&checkPosi1(2)==1)
	 {
	  b[2]=o;
	  Display();
	  checkWin();
	  turn++;
	 }
	 else if((b[3]==x&&b[6]==x)&&checkPosi1(0)==1)
	 {
	  b[0]=o;
	  Display();
	  checkWin();
	  turn++;
	 }
	 else if((b[6]==x&&b[7]==x)&& checkPosi1(8)==1)
	 {
	  
	   b[8]=o;
	   Display();
	   checkWin();
	   turn++;
	 }
	 else if((b[7]==x&&b[8]==x)&& checkPosi1(6)==1)
	 {
	  
	   b[6]=o;
	   Display();
	   checkWin();
	   turn++;
	 }
 else 
  goRan();
}

static void goRan()
{
 int i;
 for(i=0;i<=b.length;i++)
  {
  if(b[i]==BLANK)
  {
   b[i]=o;
   Display();
   checkWin();
   turn++;
   break;
  }
  }
}
 
static void checkWin()   //check if some1 wins
{
 if(b[0]+b[1]+b[2]==3*x || b[0]+b[3]+b[6]==3*x || b[0]+b[4]+b[8]==3*x || b[1]+b[4]+b[7]==3*x
   || b[2]+b[5]+b[8]==3*x || b[6]+b[7]+b[8]==3*x || b[3]+b[4]+b[5]==3*x || b[2]+b[4]+b[6]==3*x)
  {
  JOptionPane.showMessageDialog(null, "You Win!");
  victory=true;
  end=1;
  playAgain();
  }
 else
  if(b[0]+b[1]+b[2]==3*o || b[0]+b[3]+b[6]==3*o || b[0]+b[4]+b[8]==3*o || b[1]+b[4]+b[7]==3*o
    || b[2]+b[5]+b[8]==3*o || b[6]+b[7]+b[8]==3*o || b[3]+b[4]+b[5]==3*o || b[2]+b[4]+b[6]==3*o)
   {
   JOptionPane.showMessageDialog(null, "You Lose!");
   victory=true;
   end=1;
   playAgain();
   }
  else
   if(turn==9 && victory==false)
   {
    JOptionPane.showMessageDialog(null, "Draw Game!");
    end=1;
    playAgain();
   }
   
}
static void playAgain()
{
 int ans;
 ans = JOptionPane.showConfirmDialog(null, "Do you want to play again?");
 switch (ans)
 {
 case JOptionPane.YES_OPTION: 
 {
  reset();
  Confirm();
 }
 case JOptionPane.NO_OPTION:    End();
 case JOptionPane.CANCEL_OPTION:  End();
 }
 
}
static void End()
{
 System.out.println("Bye!");
 System.exit(0);
}
}
