import java.util.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dealer dealer = new Dealer();
		System.out.println("Welcome to Card Dealer!");
		
		dealer.resetDeckOfCards();
		dealer.shuffle();
		
		try {
			Scanner sc = new Scanner(System.in);
			int res = 100;
			while(res > 0) {
				printMenu();
				res = sc.nextInt();
				if(res == 1) {
					if(dealer.DeckOfCards.size() >= 1) {
						System.out.println("Dealer deals: [" + dealer.dealOneCard()+ "]\n");
					}
					else {
						printNotEnoughMessage(dealer);
					}
					
				}
				else if(res == 2) {
					if(dealer.DeckOfCards.size() >= 5) {
						List<Card> myHand = dealer.dealNCards(5);
						System.out.print("Dealer deals: [");
						for(Card card : myHand) {
							System.out.print(card.toString()+ ", ");
						}
						System.out.println("]\n");
					}
					else {
						printNotEnoughMessage(dealer);
					}
				
				}
				else if(res == 3) {
					System.out.println("How many cards do you want?");
					Scanner scn = new Scanner(System.in);
					int num = scn.nextInt();
					if(num <= dealer.DeckOfCards.size()) {
						List<Card>myHand;myHand = dealer.dealNCards(num);
						System.out.print("Dealer deals: [");
						for(Card card : myHand) {
							System.out.print(card.toString()+ ", ");
						}
						System.out.println("]\n");
					}
					else {
						printNotEnoughMessage(dealer);
					}
					
				}
				else if(res == 4) {
					dealer.showCardsLeft();
				}
				else if(res == 5) {
					dealer.shuffle();
					System.out.println("Deck has been shuffled...");
				}
				else if(res == 6){
					dealer.resetDeckOfCards();
				}
				
			}
		}
		catch(Exception e) {
			System.out.println("Error: Invalid Entry!");
		}
		finally {
			System.out.println("Thank you for playing!");
		}
	}
	
	private static void printMenu() {
		System.out.println("Please make your selection");
		System.out.println("(1) To deal ONE card.");
		System.out.println("(2) To deal a hand (five cards).");
		System.out.println("(3) To deal N amount of cards.");
		System.out.println("(4) To show All the cards remaining of the deck.");
		System.out.println("(5) To SHUFFLE the deck.");
		System.out.println("(6) To RESET the deck.");
		System.out.println("(0) To Exit.");
	}
	
	private static void printNotEnoughMessage(Dealer dealer) {
		System.out.println("Not enough Cards! ");
		System.out.println("Dealer has " + dealer.DeckOfCards.size() +" cards left.\n");
	}
	
	private static int convertInput(String input) {
		int res = Integer.parseInt(input);
		
		return res;
	}
	
	

}
