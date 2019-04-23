package Stack;

public class Program {
    public static void main(String[] args) {
        MyArrayDeque<Character> deque = new MyArrayDeque<>();
        deque.insertLeft('a');
        deque.insertLeft('b');
        deque.insertRight('2');
        deque.insertRight('1');
        System.out.println(deque);


        MyArrayStack<Character> stack = new MyArrayStack<>();
        stack.push('h');
        stack.push('e');
        stack.push('l');
        stack.push('l');
        stack.push('o');
        System.out.println(stack);
        System.out.println();
        System.out.print(stack.pop());
        System.out.print(stack.pop());
        System.out.print(stack.pop());
        System.out.print(stack.pop());
        System.out.print(stack.pop()); //извлекаешь, записываешь в массив и выводишь в цикле


    }
}
