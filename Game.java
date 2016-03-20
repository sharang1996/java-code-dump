import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
class Card 
{
	int suit;
	int rank;
	int set;
	
	public Card(int suit,int rank)
	{
		this.suit=suit;
		this.rank=rank;
		set=0;
	}
	
	public String toString()
	{
		return "this is a card";
	}
}


class Player
{

Card hand[]=new Card[20];
int coins=100;	
int count=0;	
boolean isBusted=false;

public int count(int n)
{
	
	int count=0;
	
	for(int i=0;i<n;++i)
	{
	if(hand[i].rank<10) count+=hand[i].rank;
	else
	if(hand[i].rank>=10) count+=10;
    }
    
    for(int i=0;i<n;++i)
    {
		if(hand[i].rank==1) 
		{
			if(count+10<=21) count+=10;
		}
	}
	
	return count;
}

public void cardDetails(int no)
{
	for(int i=0;i<no;++i)
	{
		if(hand[i].suit==0)
		{
			for(int j=1;j<14;++j)
			{
				if(hand[i].rank==j)
				{
				if(j==1) System.out.println("Ace of Spades");
				else if(j==11) System.out.println("jack of Spades");
				else if(j==12) System.out.println("Queen of Spades");
				else if(j==13) System.out.println("King of Spades");
				else
				System.out.println(j+" of Spades");
			     }
			}
	    }
	    else
	    if(hand[i].suit==1)
		{
			for(int j=1;j<14;++j)
			{
				if(hand[i].rank==j)
				{
				if(j==1) System.out.println("Ace of Hearts");
				else if(j==11) System.out.println("jack of Hearts");
				else if(j==12) System.out.println("Queen of Hearts");
				else if(j==13) System.out.println("King of Hearts");
				else
				System.out.println(j+" of Hearts");
			     }
			}
	    }
	    else
	    if(hand[i].suit==2)
		{
			for(int j=1;j<14;++j)
			{
				if(hand[i].rank==j)
				{
				if(j==1) System.out.println("Ace of Diamonds");
				else if(j==11) System.out.println("jack of Diamonds");
				else if(j==12) System.out.println("Queen of Diamonds");
				else if(j==13) System.out.println("King of Diamonds");
				else
				System.out.println(j+" of Diamonds");
			     }
			}
	    }
	    else
			if(hand[i].suit==3)
		{
			for(int j=1;j<14;++j)
			{
				if(hand[i].rank==j)
				{
				if(j==1) System.out.println("Ace of Clubs");
				else if(j==11) System.out.println("jack of Clubs");
				else if(j==12) System.out.println("Queen of Clubs");
				else if(j==13) System.out.println("King of Clubs");
				else
				System.out.println(j+" of Clubs");
			     }
			}
	    }
	}
	
	
}


}
class Game
{
	
	public static void main (String args[]) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome , get ready to play blackjack!!!");
	    String choice = new String();
	    int pool=0;
	    int bid=0;
	    
        Card deck[]=new Card[52];
     
        Player player1,player2,dealer;
	
	 player1=new Player();
	 player2=new Player();
	 dealer=new Player();
     
     int k=0;
     for(int i=1;i<14;i++)
		for(int j=0;j<4;j++)
			deck[k++]=new Card(j,i);    //initialization
			
	 ArrayList<Card> pack=new ArrayList<Card>();
	 for(int p=0;p<52;p++)
		pack.add(deck[p]);             //populating arraylist
	
	   Collections.shuffle(pack);        //shuffling the pack
       
     
     int pc=0;  //pack count
     int p1handi=1,p2handi=1,dhandi=1;
		while(player1.coins>0&&player2.coins>0)
		{
			player1.hand[0]=pack.get(pc);   ++pc;
		    player2.hand[0]=pack.get(pc);   ++pc;
		    dealer.hand[0]=pack.get(pc);    ++pc;
		 
		    player1.hand[1]=pack.get(pc);   ++pc;
		    player2.hand[1]=pack.get(pc);   ++pc;
		    dealer.hand[1]=pack.get(pc);    ++pc;
			
		  p1handi=1;p2handi=1;dhandi=1;pool=0;
		  
		  System.out.println("player 1 current coins: "+player1.coins);
		  System.out.println("How much would you like to bid player 1?(1,2,3,4,5) in multiples of 20 ");
		  bid=sc.nextInt();
		  player1.coins-=(bid*20);
		  pool+=(bid*20);
		 
		  System.out.println("player 2 current coins: "+player2.coins);
		  System.out.println("How much would you like to bid player 2?(1,2,3,4,5) in multiples of 20 ");
		  bid=sc.nextInt();
		  player2.coins-=(bid*20);
		  pool+=(bid*20);
		  
			while(true)
			{
			 
		        System.out.println("player 1 card details");
				player1.cardDetails(p1handi+1);
				System.out.println("player 1 count "+player1.count(p1handi+1));
		
				System.out.println();
		
				System.out.println("player 2 card details");
				player2.cardDetails(p2handi+1);
				System.out.println("player 2 count "+player2.count(p2handi+1));
		
				System.out.println();
		
				System.out.println("dealer card details");
				dealer.cardDetails(1);
				System.out.println("dealer card blind utill stand is taken");
		 
		            if(player1.isBusted&&player2.isBusted)
					{
						System.out.println("dealer wins round!!! \n");
						dealer.coins+=pool;
						break;
					}
		    
				System.out.println();
				System.out.println("What would you like to do player 1 ? hit or take a stand? ");  
				choice=sc.next();
				if(choice.compareTo("hit")==0)
				{
					player1.hand[++p1handi]=pack.get(pc++);
				
					System.out.println("player 1 card details");
					player1.cardDetails(p1handi+1);
					System.out.println("player 1 count "+player1.count(p1handi+1));
					System.out.println();
					
					if(player1.count(p1handi+1)>21) player1.isBusted=true;
				}
				else
				if(choice.compareTo("stand")==0)
				{
					System.out.println("dealer card details");
					dealer.cardDetails(dhandi+1);
					System.out.println("count "+dealer.count(dhandi+1));
		       
					if(player1.isBusted==false&&player2.isBusted==false)
					{
						while(dealer.count(dhandi+1)<=21 && dealer.count(dhandi+1)<=Math.max(player1.count(p1handi+1),player2.count(p2handi+1)))
						{
							dealer.hand[++dhandi]=pack.get(pc++);
					
							System.out.println("dealer card details");
							dealer.cardDetails(dhandi+1);
							System.out.println("count "+dealer.count(dhandi+1));
		            
							if(dealer.count(dhandi+1)>21) dealer.isBusted=true;
						}
					}
					else
					if(player1.isBusted==true)
					{
						while(dealer.count(dhandi+1)<=21 && dealer.count(dhandi+1)<=player2.count(p2handi+1))
						{
							dealer.hand[++dhandi]=pack.get(pc++);
					
							System.out.println("dealer card details");
							dealer.cardDetails(dhandi+1);
							System.out.println("count "+dealer.count(dhandi+1));
		            
							if(dealer.count(dhandi+1)>21) dealer.isBusted=true;
						}
					}
					else
					if(player2.isBusted==true)
					{
						while(dealer.count(dhandi+1)<=21 && dealer.count(dhandi+1)<=player1.count(p1handi+1))
						{
							dealer.hand[++dhandi]=pack.get(pc++);
					
							System.out.println("dealer card details");
							dealer.cardDetails(dhandi+1);
							System.out.println("count "+dealer.count(dhandi+1));
		            
							if(dealer.count(dhandi+1)>21) dealer.isBusted=true;
						}
					}
			   
					if(player1.isBusted&&player2.isBusted)
					{
						System.out.println("dealer wins round!!! \n");
						dealer.coins+=pool;
						break;
					}
					else if(dealer.isBusted)
			        {
						if(player1.isBusted==false && player1.count(p1handi+1)>player2.count(p2handi+1))
						{
							System.out.println("Player 1 wins round!!! \n");
			                player1.coins+=pool;
			                break;
						}
						else if(player1.isBusted==false && player1.count(p1handi+1)==player2.count(p2handi+1))
						{
							System.out.println("same count,pool to be divided... \n");
			                player1.coins+=pool/2;
			                player2.coins+=pool/2;
			                break;
						}
						else if(player2.isBusted==false)
						{
							
							System.out.println("Player 2 wins round!!! \n");
			                player2.coins+=pool;
			                break;
						}
						else if(player2.isBusted==true)
												{
							System.out.println("Player 1 wins round!!! \n");
			                player1.coins+=pool;
			                break;
						}
					}
				 else 
				   {
					 System.out.println("dealer wins round!!! \n");
					 dealer.coins+=pool;
					 break;
			       }
				}
			
		
		
		
		
					System.out.println();
					System.out.println("What would you like to do player 2 ? hit or take a stand? ");  
					choice=sc.next();
					if(choice.compareTo("hit")==0)
					{
						player2.hand[++p2handi]=pack.get(pc++);
				
						System.out.println("player 2 card details");
						player2.cardDetails(p2handi+1);
						System.out.println("player 2 count "+player2.count(p2handi+1));
						System.out.println();
						if(player2.count(p2handi+1)>21) player2.isBusted=true;
					}
					else
					if(choice.compareTo("stand")==0)
				  {
					System.out.println("dealer card details");
					dealer.cardDetails(dhandi+1);
					System.out.println("count "+dealer.count(dhandi+1));
		       
					if(player1.isBusted==false&&player2.isBusted==false)
					{
						while(dealer.count(dhandi+1)<=21 && dealer.count(dhandi+1)<=Math.max(player1.count(p1handi+1),player2.count(p2handi+1)))
						{
							dealer.hand[++dhandi]=pack.get(pc++);
					
							System.out.println("dealer card details");
							dealer.cardDetails(dhandi+1);
							System.out.println("count "+dealer.count(dhandi+1));
		            
							if(dealer.count(dhandi+1)>21) dealer.isBusted=true;
						}
					}
					else
					if(player1.isBusted==true)
					{
						while(dealer.count(dhandi+1)<=21 && dealer.count(dhandi+1)<=player2.count(p2handi+1))
						{
							dealer.hand[++dhandi]=pack.get(pc++);
					
							System.out.println("dealer card details");
							dealer.cardDetails(dhandi+1);
							System.out.println("count "+dealer.count(dhandi+1));
		            
							if(dealer.count(dhandi+1)>21) dealer.isBusted=true;
						}
					}
					else
					if(player2.isBusted==true)
					{
						while(dealer.count(dhandi+1)<=21 && dealer.count(dhandi+1)<=player1.count(p1handi+1))
						{
							dealer.hand[++dhandi]=pack.get(pc++);
					
							System.out.println("dealer card details");
							dealer.cardDetails(dhandi+1);
							System.out.println("count "+dealer.count(dhandi+1));
		            
							if(dealer.count(dhandi+1)>21) dealer.isBusted=true;
						}
					}
			   
					if(player1.isBusted&&player2.isBusted)
					{
						System.out.println("dealer wins round!!! \n");
						dealer.coins+=pool;
						break;
					}
					else if(dealer.isBusted)
			        {
						if(player1.isBusted==false && player1.count(p1handi+1)>player2.count(p2handi+1))
						{
							System.out.println("Player 1 wins round!!! \n");
			                player1.coins+=pool;
			                break;
						}
						else if(player1.isBusted==false && player1.count(p1handi+1)==player2.count(p2handi+1))
						{
							System.out.println("same count,pool to be divided... \n");
			                player1.coins+=pool/2;
			                player2.coins+=pool/2;
			                break;
						}
						else if(player2.isBusted==false)
						{
							
							System.out.println("Player 2 wins round!!! \n");
			                player2.coins+=pool;
			                break;
						}
						else if(player2.isBusted==true)
						{
							System.out.println("Player 1 wins round!!! \n");
			                player1.coins+=pool;
			                break;
						}
					}
				    else 
					{
						System.out.println("dealer wins round!!! \n");
						dealer.coins+=pool;
						break;
					}
			    }
		  
		    }
			
		
			System.out.println("Player 1 coins : "+player1.coins);
			System.out.println("Player 2 coins : "+player2.coins);
		    
			if(player2.coins<=0) System.out.println("Player 1 wins!!!");
			if(player1.coins<=0) System.out.println("Player 2 wins!!!");
		    
		   
		}
	
	}
}
