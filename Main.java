package Game;

import Game.Java2.Poker;
import Game.Java2.PokerManager;

public class Main {
    public static void main(String[] args) {
        PokerManager manager1=new PokerManager();
        Palyer p1=new Palyer("张三",2000, manager1.getPoker() );
        new GameGround(p1);
    }
}
