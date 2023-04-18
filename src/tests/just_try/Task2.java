package tests.just_try;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class Task2 {
    public static void main(String[] args) {
        System.out.println(isEqual("I#lovee#", "love", '#'));
        System.out.println("////////////////////////////////////////////");
        System.out.println(isEqual("aaja#va####", "a", '#'));
        System.out.println("////////////////////////////////////////////");
        System.out.println(isEqual("#ja#va#", "plplpl", '#'));
        System.out.println("////////////////////////////////////////////");
        System.out.println(isEqual("####", "", '#'));
    }


    public static boolean isEqual(String s1, String s2, Character inputChar) {
        if (s1.equals(s2)) {
            return true;
        }

        StringBuilder strAfterDelete = new StringBuilder();
        boolean isDelete = false;

        System.out.println("     input:");
        System.out.print("1- " + s1);

        //добавляем в ArrayList s1 разложив на Character
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            list.add(s1.toCharArray()[i]);
        }

        //создаем какой-то синхронизированный итератор(с обычным при удалении выкидывает ConcurrentModificationException)
        ListIterator<Character> synchronizedIterator = Collections.synchronizedList(list).listIterator();

        //прогоняем цикл
        while (synchronizedIterator.hasNext()) {
            //поиск '#' и его удаление
            if (synchronizedIterator.next().equals(inputChar)) {
                synchronizedIterator.remove();

                //при нахождении '#' удаляем предыдущий символ
                while (synchronizedIterator.hasPrevious() && !isDelete) {
                    if (!synchronizedIterator.previous().equals(' ')) {
                        synchronizedIterator.remove();
                        isDelete = true;
                    }
                }
                isDelete = false;
            }
        }

        //соединяем символы из обработанного ArrayList в строку
        for (Character c : list) {
            strAfterDelete.append(String.valueOf(c));
        }

        System.out.println(" --> " + strAfterDelete);
        System.out.println("2- " + s2);
        System.out.println("    isEqual:");

        return strAfterDelete.toString().equals(s2);
    }
}
