package tests.homework3.myHW3;

import java.util.List;
import java.util.Random;

import static tests.homework3.myHW3.Player.isWinner;
import static tests.homework3.myHW3.Player.sortScore;

public class Game {
    public static void play(List<Player> players) {
        Random random = new Random();
        float random1 = 0;
        float random2 = 0;
        do {
            for (int i = 0; i < players.size(); i++) {
                random1 = random.nextInt(3);
                for (int j = i + 1; j < players.size(); j++) {
                    random2 = random.nextInt(3);
                    if (random1 > random2) {
                        players.get(i).score += 1;
                    } else if (random1 < random2) {
                        players.get(j).score += 1;
                    } else {
                        players.get(i).score += 0.5;
                        players.get(j).score += 0.5;
                    }
                }
            }
            sortScore(players);
        } while (!isWinner(players));


    }


}
