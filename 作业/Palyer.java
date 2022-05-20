package Game;

import Game.Java2.Poker;

import java.util.Scanner;

public class Palyer {
    String name;
    int total;
    Poker poker;
    int zhu;

    public Palyer(String name, int total) {
        this.name = name;
        this.total = total;
    }
    public Palyer(String name, int total,Poker poker) {
        this.name = name;
        this.total = total;
        this.poker = poker;
    }

    public Palyer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    //public void xiazhu(Palyer p2,Palyer p3)
    public int xiazhu()
    {System.out.println(this.name+"请输入你要下注的金额");
        Scanner sc=new Scanner(System.in);
        this.zhu = sc.nextInt();
        //this.total = 2000-this.zhu;
        System.out.println(this.name+"你要下注"+this.zhu);
        //System.out.println(this.name+"你的余额是"+(this.total-this.zhu));
        return this.zhu;
//        while(true){
//        int a = sc.nextInt();
//        if (a>= this.zhu){
//            p2.zhu = a;
//            break;
//        } else  System.out.println("您所下注数必须大于玩家一");
//        }
//        while(true) {
//            int b = sc.nextInt();
//            if (b >= p2.zhu) {
//                p3.zhu = b;
//                break;
//            } else System.out.println("您所下注数必须大于玩家二");
//        }
    }
    public int allin(){
        this.zhu=this.total;
        //this.total=0;
        System.out.println(this.name+"你已下注你目前的全部金币"+this.zhu);
        //System.out.println("你的余额是"+this.total);
        return this.zhu;
    }


}
