package tests.homework3.lesson;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Team<T extends Participant> {
    private String name;
    private List<T> participantList = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public void addNewPart(T participant) {
        participantList.add(participant);
    }

    public void play(Team<T> team) {
        String winner;
        Random random = new Random();
        int a = random.nextInt(2);

        if (a == 0) {
            winner = this.name;
        } else {
            winner = team.name;
        }
        System.out.println(winner);
    }
}