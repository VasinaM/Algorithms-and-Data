package Stack;

//реализация очереди с помощью массива

import java.util.NoSuchElementException;

public class MyArrayQueue <Item> {
    Object [] queue = new Object[1];
    private int size = 0;
    private int start = 0;
    private int end = 0;


    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void resize(int capacity) {
        Object [] tmp = new Object[capacity];
        for (int i = 0; i < size; i++) {
            tmp[i] = queue[(start + i) % queue.length]; //x%n = [0; n-1]
        }
        queue = tmp;
        start = 0;
        end = size;
    }

    public void enqueue (Item item){
        if(size == queue.length){
            resize(2 * queue.length);
        }
        queue[end++]=item; //if (end == queue.length) {end = 0;}
        end %= queue.length;
        size++;
    }

    public Item dequeue () {
        if(isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        Item item = (Item) queue[start];
        queue[start] = null;
        size--;
        start++;
        start %= queue.length;
        if (size == queue.length / 4 && size > 0) {
            resize(queue.length / 2);
        }
        return item;
    }

    public Item peekFront () {
        if (isEmpty()){
            throw new NoSuchElementException("Queue is empty");
        }
        return (Item) queue[start];
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) {
            s.append(queue[(start + i) % queue.length] + ", ");
        }
        return s.toString();
    }
}
