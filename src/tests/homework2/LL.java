package tests.homework2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class LL {
    // 1, 2, 5, 2, 1, 5, 5 -- 10
    //Написать метод, который
    // генерирует числа ( 20 штук диапазоном до 20 )
    // принимает число Х
    // пройтись по вашему листу и вернуть лист, который содержит нужные последовательности чисел, которые в сумме дают Х
    // вывести длину минимальной последовательности


    public static void main(String[] args) {
        supermethod(50, 20, 30);
    }


    public static void supermethod(int size, int bound, int searchSum) {
        List<Integer> list = generateArrayList(size, bound);
        System.out.println("List: " + list);
        System.out.println("Ищем сумму: " + searchSum);
        List<List> poolOfLists = findAllOrders(list, searchSum);
        System.out.println("Варианты: " + poolOfLists);
        int minSize = findShortestOrder(poolOfLists);
        System.out.println("====================");
        System.out.println("длина минимальной последовательности: " + minSize);
    }


    public static List<List> findAllOrders(List<Integer> list, int searchingSum) {
        List<List> resultLists = new ArrayList<>();
        List<Integer> tmptList = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                sum += list.get(j);
                tmptList.add(list.get(j));
                if (sum == searchingSum) {
                    resultLists.add(clone(tmptList));
                    tmptList.clear();
                    sum = 0;
                    break;
                }
                if (sum > searchingSum) {
                    tmptList.clear();
                    sum = 0;
                    break;
                }
            }
            tmptList.clear();
            sum = 0;
        }
        return resultLists;
    }


    public static int findShortestOrder(List<List> list) {
        int index = 0;
        if (list.size() > 0) {
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i).size() < list.get(i - 1).size()) {
                    index = i;
                }
            }
        } else return 0;
        return list.get(index).size();
    }


    public static <T> List<T> clone(List<T> original) {
        List<T> copy = new ArrayList<>(original);
        return copy;
    }


    public static List<Integer> generateArrayList(int size, int bound) {
        List<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(new Random().nextInt(bound));
        }
        return list;
    }

}

