package Stack;

import java.util.NoSuchElementException;

public class MyArrayDeque <Item> {
    Object [] deque = new Object[1];
    private int size = 0;
    private int left = 0;
    private int right = 0;  //right = 1;

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void resize (int capasity){
        Object[] tmp = new Object[capasity];
        for (int i = 0; i < size; i++) {

        }
    }

    public void insertLeft(Item item){
        if(size == deque.length){
            resize(2 * deque.length);
        }
        deque[left++]=item;
        left %= deque.length;
        size++;

    }

    public void insertRight(Item item){
        if(size == deque.length){
            resize(2 * deque.length);
        }
        deque[right++]=item;
        right %= deque.length;
        size++;

    }

    public Item removeLeft(){
        if(isEmpty()) {
            throw new NoSuchElementException("Deck is empty");
        }
        Item item = (Item) deque[left];
        deque[left] = null;
        size--;
        left++;
        left %= deque.length;
        if (size == deque.length / 4 && size > 0) {
            resize(deque.length / 2);
        }
        return item;

    }

    public Item removeRight (){
        if(isEmpty()) {
            throw new NoSuchElementException("Deck is empty");
        }
        Item item = (Item) deque[right];
        deque[left] = null;
        size--;
        right++;  //right --
        right %= deque.length;
        if (size == deque.length / 4 && size > 0) {
            resize(deque.length / 2);
        }
        return item;

    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) {
            s.append(deque[(left + i) % deque.length] + ", ");
        }
        return s.toString();
    }
}
