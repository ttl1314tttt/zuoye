package Game.Java2;

public class Poker {
    PokerNumber numberObj;
    PokerSuit suitObj;

    public Poker(PokerNumber numberObj, PokerSuit suitObj) {
    this.numberObj=numberObj;
    this.suitObj=suitObj;
    }
    public PokerNumber getNumber(){
        return  numberObj;
    }
    public PokerSuit getSuit(){
        return suitObj;
    }
    public boolean compareTo(Poker other){
        //boolean result;
        if(this.numberObj.tag==other.numberObj.tag){
            if(this.suitObj.tag>other.suitObj.tag){
                return true;
            }else return false;
        }else{
            if(this.numberObj.tag>other.numberObj.tag){
                return true;
            }else return false;
        }
    }
}