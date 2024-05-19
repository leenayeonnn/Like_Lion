package sample.bean;

import java.util.List;

public class Game {
    private List<Player> list;

    public Game(){
        System.out.println("Game generate");
    }

    public Game(List<Player> list) {
        System.out.println("Game generate with players");
        this.list = list;
    }

    public void play(){
        for(Player player:list){
            player.play();
        }
    }
}