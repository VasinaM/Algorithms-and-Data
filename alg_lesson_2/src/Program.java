import java.util.Random;

public class Program {
    public static void main(String[] args) {


    MyArrayList<Character> list = new MyArrayList<>();

       Random random = new Random();

        for (int i = 0; i < list.size(); i++) {
            int a = (int) (Math.random() * 10 + 1);
            list.add((char) a);
            //list.add((char) random.nextInt(100));
        }
//    list.add('d');
//    list.add('c');
//    list.add('a');
//    list.add('b');
//        System.out.println(list);
//        System.out.println(list.size());
//        System.out.println((list.indexOf('c')));
//        System.out.println(list.contains('x'));
//        //System.out.println(list.remove('b'));
//        //System.out.println(list.remove('x'));
//        System.out.println(list);
//
//    list.add('f');
//    list.add('t');
        System.out.println(list);

        list.selectionSort(new MyCharacterComparator());
        //list.insertoinSort(new MyCharacterComparator());
        System.out.println(list);

        System.currentTimeMillis(); //получает текущее время в милисек
        //рисовать табл в консоли







    }
}
