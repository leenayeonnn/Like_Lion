package sample.config;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import sample.bean.Dice;
import sample.bean.Game;
import sample.bean.Player;

@PropertySource({"classpath:game.properties"})
public class GameConfig {
    @Bean
    public Dice dice(@Value("${face}") int face) {
        return new Dice(face);
    }

    @Bean
    public Player kang(Dice dice) {
        Player player = new Player();
        player.setDice(dice); // dice 주입 - 설정자 방식 (setter)
        player.setName("kang");
        return player;
    }

    @Bean
    public Player lee(Dice dice) {
        Player player = new Player();
        player.setDice(dice); // dice 주입 - 설정자 방식 (setter)
        player.setName("lee");
        return player;
    }

    @Bean
    public Player kim(Dice dice) {
        Player player = new Player();
        player.setDice(dice); // dice 주입 - 설정자 방식 (setter)
        player.setName("kim");
        return player;
    }

    @Bean
    public Game game(List<Player> players) {
        return new Game(players); // 생성자 주입 방법
    }
}
