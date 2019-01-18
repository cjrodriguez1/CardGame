import java.util.*;

public class Dealer {
	List<Card> DeckOfCards = new ArrayList<Card>();
	
	public void resetDeckOfCards() {
		String [] faces = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
		String [] suits = {"Clubs", "Hearts", "Spades", "Diamonds"};
		DeckOfCards.clear();
		for (String suit : suits) {
			for(String face : faces) {
				Card card = new Card(face, suit);
				DeckOfCards.add(card);
			}
		}
	}
	
	//This method will shuffle the deck of cards, 
	//given the cards left on the deck.
	public  void shuffle() {
		
		Random rand = new Random();
		for(int i=0; i<DeckOfCards.size(); i++) {
			int val = rand.nextInt(DeckOfCards.size()-1);
			swap(i, val);
		}
	}
	
	//This method returns the top card ofthe deck.
	public Card dealOneCard() {
		Card topCard = DeckOfCards.get(0);
		DeckOfCards.remove(0);
			
		return topCard;
	}
	
	public List<Card> dealNCards(int num){
		List<Card> hand = new ArrayList<Card>();
		for(int i=0; i<num; i++) {
			Card card = dealOneCard();
			hand.add(card);
		}
		return hand;
	}
	
	public void showCardsLeft() {
		System.out.print("Dealer has " + DeckOfCards.size() + " card(s) left: {");
		for(Card card : DeckOfCards) {
			System.out.println(card.toString());
		}
		System.out.println("}\n");
	}
	
	//This method moves a certain card 
	//into a random position in the deck
	private void swap(int loc1, int loc2) {
		Card card = DeckOfCards.get(loc1);
		DeckOfCards.remove(loc1);
		DeckOfCards.add(loc2, card);
		
	}

}
