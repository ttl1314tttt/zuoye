package Game.Java2;

public class PokerSuit {
    String suit;
    int tag;

    public String getSuit() {
        return suit;
    }
    public void setSuit(String suit) {
        this.suit = suit;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public PokerSuit(String suit, int tag){
        this.suit=suit;
        this.tag=tag;
    }
}
