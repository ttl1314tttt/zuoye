package Game.Java2;

public class Test {
    public static void main(String[] args) {
        PokerManager manager=new PokerManager();
        Poker poker1 = manager.getPoker();
        Poker poker2 = manager.getPoker();
        boolean result= poker1.compareTo(poker2);
        if(result==true){
            System.out.println(poker1.numberObj.number+poker1.suitObj.suit+">"
                    +poker2.numberObj.number+poker2.suitObj.suit);
        }else{
            System.out.println(poker1.numberObj.number+poker1.suitObj.suit+"<"
                    +poker2.numberObj.number+poker2.suitObj.suit);
        }
    }
}
