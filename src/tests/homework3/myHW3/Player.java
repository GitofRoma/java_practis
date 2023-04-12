package tests.homework3.myHW3;

import java.util.*;

public class Player {
    /**
     * - класс лига (1 2 3 4)
     * - класс игроки(имя возраст лига кол-во балов)
     * - класс игра <>
     * - класс генератор 5 игроков с именами и возрастом
     * - класс игшра с методом где каждый игрок одной лиги играет с каждым
     * если победа то 1 балл ничья 0,5 проигрыш - 0
     * далее вывести на экран лидеров из каждой лиги
     * <p>
     * - если кол-во баллов будет одиноковое то переигрываем
     */


    String name;
    int age;
    Liga liga;
    float score;


    public Player(String name, int age, Liga liga) {
        this.name = name;
        this.age = age;
        this.liga = liga;
    }

    public static List<Player> generateRandomPlayers(int countOfPlayers, Liga liga) {
        int minAge = 0, maxAge = 0;
        switch (liga) {
            case ONE:
                minAge = 6;
                maxAge = 11;
                break;
            case TWO:
                minAge = 12;
                maxAge = 17;
                break;
            case THREE:
                minAge = 18;
                maxAge = 35;
                break;
            case FOUR:
                minAge = 36;
                maxAge = 60;
                break;
        }

        List<Player> listPlayers = new ArrayList<>(countOfPlayers);
        Random random = new Random();
        String[] names = {"Mike", "Tom", "Alex", "Vasia", "Oleg", "Marry", "Kira", "Sveta", "Olga", "Jane"};

        for (int i = 0; i < countOfPlayers; i++) {
            listPlayers.add(new Player(names[random.nextInt(10)],
                    minAge + random.nextInt(maxAge - minAge + 1),
                    liga));
        }
        return listPlayers;
    }


    public static void printListOfPlayers(String massege,List<Player> players) {
        System.out.println(massege);
        for (Player player : players) {
            System.out.println(player.toString());
        }
    }

    public static void sortScore(List<Player> players){
        Collections.sort(players, new PlayerComparator());

    }

    public static boolean isWinner(List<Player> players){
        return players.get(0).score != players.get(1).score;
    }




    @Override
    public String toString() {
        return "liga=" + liga +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score+
                "";
    }


}

