package tests.homework6;

public class Queue {
    private int[] arr;      // массив для хранения элементов queue
    private int head;       // head указывает на первый элемент в queue
    private int tail;       // tail часть указывает на последний элемент в queue
    private int capacity;   // максимальная емкость queue
    private int count;      // текущий размер queue

    public Queue(int size) {
        arr = new int[size];
        capacity = size;
        head = 0;
        tail = -1;
        count = 0;
    }


    public void pushToEnd(int data) {
        if (count == capacity) {
            System.out.println("Queue is full. Cannot insert element.");
            return;
        }
        arr[count] = data;
        count++;
        tail++;
        System.out.println("Element " + data + " inserted to the end of the queue.");
    }


    public int remove() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot remove element.");
            return -1;
        }
        int removedElement = arr[head];
        head++;
        count--;
        System.out.println("Element " + removedElement + " removed from the queue.");
        return 1;
    }


    public int peek() {
        if (count == 0) {
            System.out.println("Queue is empty. No element to peek.");
            return -1;
        }
        return arr[head];
    }


    public boolean isEmpty() {
        return count == 0;
    }


    public int size() {
        return count;
    }


    /**
     *        pushToEnd(int data) - вставляет элемент в конец queue
     *     remove() - удаляет элемент из начала queue
     *        peek() - возвращает элемент из начала не удаляя его
     *        isEmpty()
     *     size()
     */

}
