package Game;

import java.util.Objects;
import java.util.Scanner;

public class GameGround {
    //Palyer palyer;

    public GameGround(Palyer palyer) {//构造函数

        System.out.println("欢迎来到游戏大厅，选择你要玩的小游戏：A.欢乐比拼 B.四川麻将 C.退出游戏大厅" );
        Scanner sc=new Scanner(System.in);
        String chiooce= sc.nextLine();
        switch (chiooce){
            case "A":
                new HappyBattle(palyer);//如果选A就创建HappyBattle对象
                break;
            case "B":
                System.out.println("游戏开发中，暂无数据:A.重新选择 B.退出");
                String rechiooce=sc.nextLine();
                if (Objects.equals(rechiooce, "A")){
                    Palyer p2=new Palyer("张一",2000);
                    new GameGround(p2);//?????
                }else {
                    break;
                }
            case "C":
                break;
        }

    }
}
