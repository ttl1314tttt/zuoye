package Game;

import Game.Java2.Poker;
import Game.Java2.PokerManager;

import java.util.ArrayList;
import java.util.Scanner;

public class HappyBattle {
    Boolean result;
    Palyer palyer;

    public HappyBattle() {
    }
    public HappyBattle(Palyer palyer) {//构造函数
        System.out.println("欢迎来到欢乐比拼小游戏");
        //System.out.println("请选择桌号：A.200注 B.400注 C.600注");
        //Scanner sc=new Scanner(System.in);
        //String zhuohao= sc.nextLine();
        //switch (zhuohao){
        //case "A":
        //case "B":
        //case "C":
        System.out.println("落座成功，正在为你匹配队友……");
        PokerManager manager1=new PokerManager();
        Palyer p2=new Palyer("李四",2000, manager1.getPoker());
        Palyer p3=new Palyer("王五",2000, manager1.getPoker());//这俩是为他匹配的队友
        ArrayList<Palyer>players = new ArrayList<>();
        players.add(palyer);
        players.add(p2);
        players.add(p3);
        System.out.println("匹配成功，游戏开始");
        System.out.print(palyer.poker.getNumber().getNumber());
        System.out.println(" "+palyer.poker.getSuit().getSuit());
        System.out.println("你的选择是A.下注 B.弃牌 C.allin D.比牌  !!若已有玩家选择allin，则您只能选择allin或弃牌!!");


        Scanner sc =new Scanner(System.in);
        String choose1 = sc.nextLine();
        System.out.print(p2.poker.getNumber().getNumber());
        System.out.println(" "+p2.poker.getSuit().getSuit());
        System.out.println(p2.name+"你的选择是A.下注 B.弃牌 C.allin D.比牌  !!若已有玩家选择allin，则您只能选择allin或弃牌!!");
        String choose2 = sc.nextLine();
        System.out.print(p3.poker.getNumber().getNumber());
        System.out.println(" "+p3.poker.getSuit().getSuit());
        System.out.println(p3.name+"你的选择是A.下注 B.弃牌 C.allin D.比牌  !!若已有玩家选择allin，则您只能选择allin或弃牌!!");
        String choose3 = sc.nextLine();
       int money = 0;
       int money1 = 0;
        switch (choose1){
           //第一次
            case("A"): {
               money = palyer.xiazhu();
               money1 = money;

                switch (choose2){
                    case ("C"):System.out.println("您不可选择此项操作,请下注");
                    case ("A"):{
                        while (true)
                        {   int a = p2.xiazhu();
                        if (a >= money){
                            money = a;
                            break;
                        }else {
                            System.out.println("你所下注的数量必须大于前面玩家");
                        }
                        }break;
                    }
                    case ("B"):{players.remove(p2);
                        break;}

                    case ("D"):{
                        System.out.println(p2.getName()+"请选择你要比牌的对象 A."+palyer.getName()+" B."+p3.getName());
                        Scanner scanner = new Scanner(System.in);
                        String choose4 = sc.nextLine();
                        switch (choose4){
                            case("A"):
                            {  p2.poker.compareTo(palyer.poker);
                                if(true){
                                    players.remove(palyer);
                                }else {
                                    players.remove(p2);
                                }break;}
                            case("B"): {
                                palyer.poker.compareTo(p3.poker);
                                if(true){
                                    players.remove(p3);
                                }else {
                                    players.remove(palyer);
                                }}break;}break;}
                }


                switch (choose3){
                    case ("C"):System.out.println("您不可选择此项操作,请下注");
                    case("A"):{while (true)
                    {   int a = p3.xiazhu();
                        if (a > money){
                            money = a;
                            break;
                        }else System.out.println("你所下注的数量必须大于前面玩家");
                    }break;}
                    case ("B"):{players.remove(p3);break;}

                    case ("D"):{
                        System.out.println(p3.getName()+"请选择你要比牌的对象 A."+palyer.getName()+" B."+p2.getName());
                        Scanner scanner = new Scanner(System.in);
                        String choose4 = sc.nextLine();
                        switch (choose4){
                            case("A"):
                            {p3.poker.compareTo(palyer.poker);
                                if(true){
                                    players.remove(palyer);
                                }else {
                                    players.remove(p3);
                                }break;}
                            case("B"): {
                                p3.poker.compareTo(p2.poker);
                                if(true){
                                    players.remove(p2);
                                }else {
                                    players.remove(p3);
                                }break;}}break;}
                }break;
            }

//第一次
            case("B"): {
                players.remove(palyer);
                switch (choose2){
                    case("A"):{
                        money = p2.xiazhu();
                        money1 = money;
                        //p2.xiazhu();
                        break;}
                    case("B"):{players.remove(p2);break;}
                    case("C"):{p2.allin();break;}
                    case("D"):{
                        System.out.println("一号玩家已弃牌，请"+p2.getName()+"与"+p3.getName()+"比牌");
                        p2.poker.compareTo(p3.poker);
                        if(true){
                            players.remove(p3);
                        }else {
                            players.remove(p2);
                       }break;
                }
            }
            switch (choose3){
                case("A"):{
                    while (true)
                    {   int a = p3.xiazhu();
                        if (a> money){
                            money = a;
                            break;
                        }else {System.out.println("你所下注的数量必须大于前面玩家");
                        }
                    }break;
                }
                case("B"):{
                    players.remove(p3);
                    break;
                }
                case("C"):
                {
                    p3.allin();
                    break;
                }
                case ("D"):
                {if(players.contains(p2)){
                    System.out.println("一号玩家已弃牌，请"+p3.getName()+"与"+p2.getName()+"比牌");
                    boolean a = p3.poker.compareTo(p2.poker);
                    if(a==true){
                        players.remove(p2);
                    }else if (a==false){
                        players.remove(p3);
                    }}

                break;}
            }
            break;}
//第一次
            case("C"):{
               money = palyer.allin();
                switch (choose2){
                    case ("A"):{
                        System.out.println("您不能选择此项操作");
                    }
                    case ("D"):{
                        System.out.println("您不能选择此项操作");
                    }

                    case("C"):{
                        if(p2.total>=money){
                            money1 = money;
                            money= p2.total;
                            p2.allin();
                        }else {
                            players.remove(p2);
                        }break;}
                    case ("B"):{
                        players.remove(p2);
                        break;
                    }
                }
            switch (choose3){
                case ("A"):{
                    System.out.println("您不能选择此项操作");
                }
                case ("D"):{
                    System.out.println("您不能选择此项操作");
                }

                case("C"):{
                    if(p3.total>=money){
                        money= p3.total;
                        p3.allin();
                    }else {
                        players.remove(p3);
                    }break;}
                case ("B"):{
                    players.remove(p3);
                    break;
                }}break;
            }
//第一次
            case("D"): {
            System.out.println(palyer.getName()+"请选择你要比牌的对象 A."+p2.getName()+" B."+p3.getName());
            Scanner scanner = new Scanner(System.in);
            String choose4 = sc.nextLine();
            switch (choose4){
                case("A"):
                { palyer.poker.compareTo(p2.poker);
                if(true){
                    players.remove(p2);
                }else {
                    players.remove(palyer);
                }break;}
                case("B"): {
                    palyer.poker.compareTo(p3.poker);
                    if(true){
                        players.remove(p3);
                    }else {
                        players.remove(palyer);
                    }break;
                }
            }
                switch (choose2){
                    case ("C"):{
                        System.out.println("您不可做此操纵");
                    }
                    case("A"):
                    {   money = p2.xiazhu();
                        money1 = money;
                        break;
                    }
                    case ("B"):{
                        players.remove(p2);
                        break;
                    }
                    case ("D"):{
                        System.out.println(p2.getName()+"请选择你要比牌的对象 A."+palyer.getName()+" B."+p3.getName());
                        Scanner scanner1 = new Scanner(System.in);
                        String choose5 = sc.nextLine();
                        switch (choose5){
                            case("A"):
                            {  p2.poker.compareTo(palyer.poker);
                                if(true&&players.contains(palyer)){
                                    players.remove(palyer);
                                }else if (false&&players.contains(p2)){
                                    players.remove(p2);
                                }break;}
                            case("B"): {
                                palyer.poker.compareTo(p3.poker);
                                if(true&&players.contains(p3)){
                                    players.remove(p3);
                                }else if (false&&players.contains(palyer)){
                                    players.remove(palyer);
                                }}break;}break;
                    }
                }
                switch (choose3){
                    case ("A"):{
                        while (true)
                        {   int a = p3.xiazhu();
                            if (a > money){
                                money = a;
                                break;
                            }else System.out.println("你所下注的数量必须大于前面玩家");
                        }break;
                    }
                    case ("B"):{
                        players.remove(p3);
                        break;
                    }
                    case ("D"):{
                        System.out.println(p2.getName()+"请选择你要比牌的对象 A."+palyer.getName()+" B."+p2.getName());
                        Scanner scanner1 = new Scanner(System.in);
                        String choose5 = sc.nextLine();
                        switch (choose5){
                            case("A"):
                            {  p3.poker.compareTo(palyer.poker);
                                if(true&&players.contains(palyer)){
                                    players.remove(palyer);
                                }else if (false&&players.contains(p2)){
                                    players.remove(p3);
                                }break;}
                            case("B"): {
                                p3.poker.compareTo(p2.poker);
                                if(true&&players.contains(p2)){
                                    players.remove(p2);
                                }else if (false&&players.contains(palyer)){
                                    players.remove(p3);
                                }}break;}break;
                    }


                }
break;


            }



        }
        if(players.size()==1){
            System.out.println("恭喜"+players.get(0).getName()+"获胜!");
        }
        if(players.size()==2){
            //System.out.println(players.get(0).getName()+players.get(1).getName());
            if(players.get(0).poker.compareTo(players.get(1).poker))
            {System.out.println("恭喜"+players.get(0).getName()+"获胜!!");
            int win = players.get(0).getTotal()+money1;
            int lo = players.get(1).getTotal()-money1;
                System.out.println(players.get(0).getName()+"的余额1是"+win);
                System.out.println(players.get(1).getName()+"的余额2是"+lo);
            }
            else if (players.get(1).poker.compareTo(players.get(0).poker)){
                System.out.println("恭喜"+players.get(1).getName()+"获胜!!!");
                int win = players.get(1).getTotal()+money1;
                int lo = players.get(0).getTotal()-money1;
                System.out.println(players.get(1).getName()+"的余额3是"+win);
                System.out.println(players.get(0).getName()+"的余额4是"+lo);
            }else {System.out.println(players.get(0).getName()+"与"+players.get(1).getName()+"打成平手");
                System.out.println(players.get(1).getName()+"的余额5是"+players.get(1).getTotal());
                System.out.println(players.get(0).getName()+"的余额6是"+players.get(0).getTotal());
            }
        }
        if (players.size()==3){
            bipai(palyer, p2, p3);
            for (int j=0;j<3;j++){
       if(players.get(j).poker==poker_max){
           System.out.println("恭喜"+players.get(j).getName()+"获胜!!!!");
       }}

for (int i=0;i<3;i++){
    if(players.get(i).poker==poker_max){
        System.out.println(players.get(i).getName()+"的余额7是"+(players.get(i).getTotal()+money1));
    }else if(players.get(i).poker==poker_min){
        System.out.println(players.get(i).getName()+"的余额8是"+(players.get(i).getTotal()-money1));
    }else if (players.get(i).poker!=poker_max&&players.get(i).poker!=poker_min){
        System.out.println(players.get(i).getName()+"的余额9是"+(players.get(i).getTotal()));
    }
//    for (int j=0;j<3;j++){
//        if(players.get(j).poker==poker_max){
//            System.out.println("恭喜"+players.get(j).getName()+"获胜!!!!");
//        }
//    }
}
        }


        }
   // }

    Poker poker_max ;
    Poker poker_min ;
    public void bipai(Palyer p1,Palyer p2,Palyer p3) {
        Poker poker_1=p1.poker;
        Poker poker_2=p2.poker;
        Poker poker_3=p3.poker;
        boolean a = poker_3.compareTo(poker_2);
        if(a==true){
            poker_max = poker_3;
            poker_min = poker_2;

        }else{
            poker_max = poker_2;
            poker_min = poker_3;

        }
        boolean b = poker_max.compareTo(poker_1);
        if(b==false){
            poker_max = poker_1;
        }
        boolean c = poker_min.compareTo(poker_1);
        if(c==true){
            poker_min = poker_1;
        }

    }
}
