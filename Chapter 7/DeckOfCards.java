class CardDeck {
    final int cardsPerDeck = 52;
    final static String[] suits = {"Clubs, Diamonds, Hearts, Spades"};
    final static String[] rankings = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    final static int suitsPerDeck = suits.length;
    final static int cardsPerSuit = rankings.length;
    Card[] cards = new Card[cardsPerDeck];

    public CardDeck() {
        for (int i = 0; i < suitsPerDeck; i++) {
            for (int j = 0; j < cardsPerSuit; j++) {
                cards[cardsPerSuit*i+j] = new Card(suits[i], rankings[j]);
            }
        }
    }

    public Card[] getCards() {
        return cards;
    }

    public void printCards() {
        for (int i = 0; i < suitsPerDeck; i++) {
            for (int j = 0; j < cardsPerSuit; j++) {
                Card card = cards[cardsPerSuit*i+j];
                System.out.println(card.getRanking() + " of " + card.getSuit());
            }
        }
    }

}

class BlackjackCardDeck extends CardDeck{
    BlackjackCard[] cards = new BlackjackCard[cardsPerDeck];

    public BlackjackCardDeck() {
        for (int i = 0; i < suitsPerDeck; i++) {
            for (int j = 0; j < cardsPerSuit; j++) {
                cards[cardsPerSuit*i+j] = new BlackjackCard(suits[i], rankings[j]);
            }
        }
    }

    public void printCards() {
        for (int i = 0; i < suitsPerDeck; i++) {
            for (int j = 0; j < cardsPerSuit; j++) {
                BlackjackCard card = cards[cardsPerSuit*i+j];
                String altValueString = card.getValue() == 1 ? " or " + String.valueOf(card.getAltValue()) : "";
                System.out.println(card.getRanking() + " of " + card.getSuit() + " with value " + String.valueOf(card.getValue()) + altValueString);
            }
        }
    }
}

class Card {
    String suit;
    String ranking;

    public Card(String suit, String ranking) {
        this.suit = suit;
        this.ranking = ranking;
    }

    public String getSuit() {
        return this.suit;
    }

    public String getRanking() {
        return this.ranking;
    }
}

class BlackjackCard extends Card {
    int value;
    int altValue = 0;

    public int getValue() {
        return this.value;
    }

    public int getAltValue() {
        return this.altValue;
    }

    public BlackjackCard(String suit, String ranking) {
        super(suit, ranking);
        if (this.ranking == "Jack" || this.ranking == "Queen" || this.ranking == "King") {
            this.value = 10;
        }
        else if (this.ranking == "Ace") {
            this.value = 1;
            this.altValue = 11;
        }
        else {
            this.value = Integer.parseInt(this.ranking);
        }
    }
}

class Main {
    public static void main(String[] args) {
        BlackjackCardDeck deck = new BlackjackCardDeck();
        deck.printCards();
    }
}