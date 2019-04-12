package Stack;

//реализация стека с помощью стпуктуры данных массив

import java.util.NoSuchElementException;

public class MyArrayStack <Item>{
    private Object [] stack = new Object[1];
    private int size = 0;  //изначально стек пуст

    //метод, который возвращает количество элементов
    public int size(){
        return size;
    }

    //метод, который сообщает пуст стек или нет
    public boolean isEmpty(){
        return size == 0;
    }

    //вспомогательный метод, который изменяет размер массива, в котором хранится стек
    private void resize(int capacity){ // параметр - новая вместимость массива
        Object[] tmp = new Object[capacity];  //вспомогательный массив для новой вместимости
        for (int i = 0; i < size; i++) {      //в который поэлементно копируем все эл-ты стека
            tmp[i] = stack[i];
        }
        stack = tmp;  //после чего делаем замену ссылкой
    }

    //метод добавления элемента в стек
    public void push (Item item) {   //в качестве параметра передаем эл-т, который хотим добавить
        if (size == stack.length){
            resize(stack.length * 2);
        }
        stack[size] = item;
        size++;
    }

    //метод возвращает эл-т на вершине стека
    public Item pop () {
        if(isEmpty()){
            throw new NoSuchElementException("Stack is empty");
        }
        Item item = (Item) stack[size - 1];
        size --;
        if(size == stack.length / 4 && size > 0){
            resize (stack.length / 2);
        }
        return item;  //возвращаем эл-т, который мы хотели извлечь
    }

    //метод, который возвращает эл-т без удаления его из стека
    public Item peek(){
        if(isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return (Item) stack[size - 1];
    }

    public String toString (){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) {
            s.append(stack[i] + "  ");
        }
        return s.toString();
    }



}
