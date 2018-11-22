import java.util.ArrayList;
import java.util.Scanner;
public class Player {

	private String name;
    private int chips;
    private int bet;
    private ArrayList<Card> oneRoundCard = new ArrayList<Card>();
    Scanner keyboard = new Scanner(System.in);
    
    public Player(String name,int chips)
    {
    	this.name=name;
    	this.chips=chips;
    }
    
	public String getName(){
	    return name;
	}
	
	public int makeBet(){
		if(chips ==0)
		{
			System.out.print("run out of chips");
			bet=0;
		}
		else
		{
			bet=1;
			chips--;
		}
        
		return bet;
	}
	
	public void setOneRoundCard(ArrayList<Card> player1Card){
		oneRoundCard=player1Card;
		
	}
	
	public boolean hitMe(){
	
		if(getTotalValue()<17)
		{
			return true;
		}
		else return false;
	}
	public int getTotalValue() {
		int sum=0;
		for(Card card :oneRoundCard) {
			sum+= card.getRank();
			if(card.getRank()>=11||card.getRank()<=13) {
				sum+=10;
			}
			
			else if(card.getRank()==1) {
				if(sum<10) {
					sum+=10;
				}
				else {
					sum+=11;
				}
			}
		}
		
		return sum;

	}
	
    public int getCurrentChips(){
		return chips;
	}

	public void increaseChips(int p1Bet){
		chips+=p1Bet;
	}
	
	public void sayHello(){
		System.out.print("Hello,i am"+name+".");
		System.out.print("i have"+chips+"chips.");
	}
	
}
