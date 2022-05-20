package Game.Java2;

import java.util.ArrayList;
import java.util.Random;

public class PokerManager {
    ArrayList<Poker>pokers = new ArrayList<>();
    String[] numbers ={"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
    String[] suits =  {"♦","♣","♥","♠"};
    public PokerManager(){
        for (int i=0;i< numbers.length;i++){
            for(int j=0;j< suits.length;j++){
                PokerNumber numberObj=new PokerNumber(numbers[i],i);
                PokerSuit suitObj=new PokerSuit(suits[j],j);
                Poker poker=new Poker(numberObj,suitObj);
                pokers.add(poker);
            }
        }
    }
    public Poker getPoker(){
        Random rd=new Random();
        int index = rd.nextInt(pokers.size());
        Poker poker = pokers.get(index);
        pokers.remove(index);
        //取了第一张牌后，再取下一张牌时应该把第一张牌从整张牌中移除，从剩余的51张牌中去取
        return poker;
    }
}
