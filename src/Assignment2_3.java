import cards.Card;
import cards.StandardCard;
import deck.Deck;
import player.Dealer;
import player.Player;

import java.util.Arrays;

public class Assignment2_3 {

	public static void main(String[] args) {
		// Instantiate a new Deck object
		Deck deck = new Deck(52);

		// Instantiate a new Dealer object and send it the deck
		Dealer dealer = new Dealer(deck);

		Player player = new Player();

		// Print the Deck (get it from the dealer)
		System.out.print("Before dealing ");
		System.out.println(dealer.getDeck());

		// Deal 5 cards to player and dealer
		for (int i = 0; i < 5; i++) {
			dealer.dealCard(player);
			dealer.dealCard(dealer);
		}

		// Print the Deck again. Check for missing cards
		System.out.print("After dealing ");
		System.out.print(dealer.getDeck());
		System.out.println();

		// Evaluate score and determine the winner
		player.getHand().evaluateHand();    // Player Hand
		String playerHandDescr = player.getHand().getHandDescr();

		dealer.getHand().evaluateHand();    // Dealer Hand
		String dealerHandDescr = dealer.getHand().getHandDescr();

		// Print each player's name, hand, and hand description
		System.out.println("\nPlayer 1: " + player.getName() + "'s Hand - " + Arrays.toString(player.getHand().getCards()) + " - " + playerHandDescr);
		System.out.println("\nPlayer 2: " + dealer.getName() + "'s Hand - " + Arrays.toString(dealer.getHand().getCards()) + " - " + dealerHandDescr);
		System.out.println("\n");

		// Display cardRank values for each card in players' hands
		displayCardRanks(player.getHand().getCards());
		displayCardRanks(dealer.getHand().getCards());

		// Compare hands to determine the winner or if it's a tie - 5 Card Poker
		int comparisonResult = player.getHand().compareHand(dealer.getHand());
		// Print the result
		if (comparisonResult == 1) {
			System.out.println("Winner: " + player.getName());
		} else if (comparisonResult == -1) {
			System.out.println("Winner: " + dealer.getName());
		} else {
			System.out.println("It's a tie!");
		}

		System.out.println();

		// Send the player and dealer cards to the usedCards pile
		int playerCardCount = player.getHand().getCards().length;
		int dealerCardCount = dealer.getHand().getCards().length;

		for (int i = 0; i < 5; i++) {
			if (i < playerCardCount) {
				dealer.takeUsedCard(player, i);
			}
			if (i < dealerCardCount) {
				dealer.takeUsedCard(dealer, i);
			}
		}

		// Print the deck again, cards in deck and used cards
		System.out.print("After discard ");
		System.out.print(dealer.getDeck());
		System.out.println();

		// Restack the Deck
		deck.restack();

		// Print the deck and this would be a new deck
		System.out.println();
		System.out.print("After restack ");
		System.out.println(dealer.getDeck());
	}

	// Method to display cardRank values for each card
	private static void displayCardRanks(Card[] cards) {
		System.out.println("Card Ranks:");
		for (Card card : cards) {
			if (card instanceof StandardCard) {
				System.out.println("Card Rank: " + ((StandardCard) card).getCardRank());
			}
		}
		System.out.println();
	}
}
