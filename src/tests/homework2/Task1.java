package tests.homework2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task1 {
//    Создать лист  А из 12 рандомных char
//    Создать стрингу В из 4 символов
//    Написать метод который проверяет можно ли составить из А слово В ,
//     причем если в стринге буквы повторяются то они должны повторяться и в листе

    public static void main(String[] args) {

        supermethod(12, 4);

        System.out.println();
        System.out.println("true в среднем один раз в " + avrStatisticInPersent(12, 4, 1000000) + " случаях");

    }

    public static List<Character> createRandomListOfChars(int size) {
        List<Character> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            Random r = new Random();
            Character c = (char) (r.nextInt(26) + 'a');
            list.add(c);
        }
        return list;
    }

    public static StringBuilder createRandomString(int lenght) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < lenght; i++) {
            Random r = new Random();
            Character c = (char) (r.nextInt(26) + 'a');
            str.append(c);
        }
        return str;
    }


    public static boolean isBuild(StringBuilder sb, List listInput) {
        List<Character> listChars = new ArrayList<Character>();
        int count = 0;
        for (char c : sb.toString().toCharArray()) {
            listChars.add(c);
        }
        for (Character listChar : listChars) {
            if (listInput.contains(listChar)) {
                listInput.remove(listChar);
                count++;
            }
        }
        return listChars.size() == count;
    }


    public static void printList(String message, List list) {
        System.out.println(message + list);
    }

    public static void printStringBuilder(String message, StringBuilder sb) {
        System.out.println(message + sb);
    }


    public static void supermethod(int sizeListChars, int lenghtString) {
        List<Character> list = createRandomListOfChars(sizeListChars);
        StringBuilder stringBuilder = createRandomString(lenghtString);
        printList("List :", list);
        printStringBuilder("String :", stringBuilder);
        System.out.println("can be builded :" + isBuild(stringBuilder, list));
    }


    public static float avrStatisticInPersent(int sizeListChars, int lenghtString, int count) {
        int count1 = 0;

        for (int i = 0; i < count; i++) {
            List<Character> list = createRandomListOfChars(sizeListChars);
            StringBuilder stringBuilder = createRandomString(lenghtString);

            if (isBuild(stringBuilder, list)) {
                count1++;
            }
        }

        return count / count1;
    }


}
