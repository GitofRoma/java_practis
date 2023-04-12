package tests.homework3.myHW3;

import java.util.List;

import static tests.homework3.myHW3.Player.*;

public class Demo {
    /**
     * - класс лига (1 2 3 4)
     * - класс игроки(имя возраст лига кол-во балов)
     * - класс игра <>
     * - класс генератор 5 игроков с именами и возрастом
     * - класс игшра с методом где каждый игрок одной лиги играет с каждым
     * если победа то 1 балл ничья 0,5 проигрыш - 0
     * далее вывести на экран лидеров из каждой лиги
     *
     * - если кол-во баллов будет одиноковое то переигрываем
     */
    public static void main(String[] args) {
        List<Player> liga1=Player.generateRandomPlayers(5,Liga.ONE);
        List<Player> liga2=Player.generateRandomPlayers(5,Liga.TWO);
        List<Player> liga3=Player.generateRandomPlayers(5,Liga.THREE);
        List<Player> liga4=Player.generateRandomPlayers(5,Liga.FOUR);

        printListOfPlayers("до игры:",liga1);
        Game.play(liga1);
        printListOfPlayers("после игры:",liga1);

        printListOfPlayers("до игры:",liga2);
        Game.play(liga2);
        printListOfPlayers("после игры:",liga2);

    }
}
