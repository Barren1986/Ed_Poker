package cards;

// StandardCard.java
public class StandardCard extends Card {
	// Attributes unique to StandardCard
	private String suit;
	private int suitIndex;
	private int cardRank;


	public StandardCard(int cardNumber) {  	// Constructor
		super(cardNumber);
		createCard();
	}

	// Override createCard() method
	@Override
	public void createCard() {
		String[] suitsNames = {"H", "D", "C", "S"};
		this.suit = suitsNames[(cardNumber - 1)/13];
		this.suitIndex = calculateSuitIndex();
    	calculateCardRank();

	}

	private int calculateSuitIndex() {
		return switch (suit) {
			case "H" -> 0;
			case "D" -> 1;
			case "C" -> 2;
			case "S" -> 3;
			default -> -1; // Handle invalid suit
		};
	}

	// Each suit has 13 cards, so we can calculate cardRank based on cardNumber, similar to the Card class
	private void calculateCardRank() {
		int calculatedRank = ((cardNumber - 1) % 13) + 1;
		cardRank = calculatedRank;
	}

		// Override toString() method
		@Override
		public String toString() {
			String rank;
			switch (cardRank) {
				case 11:
					rank = "J";
					break;
				case 12:
					rank = "Q";
					break;
				case 13:
					rank = "K";
					break;
				case 1:
					rank = "A";
					break;
				default:
					rank = String.valueOf(cardRank);
					break;
			}
			return rank + suit;
		}

		// Getter methods
		public String getSuit() {
			return suit;
		}

		public int getSuitIndex () {
			return suitIndex;
		}

		public int getCardRank() {
			return cardRank;
		}
	}
