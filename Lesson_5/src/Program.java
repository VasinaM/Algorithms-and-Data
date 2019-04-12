public class Program {
    public static void main(String[] args) {

        //возводим а в степень b

        System.out.println(exponentiation(2,4));
        System.out.println(expRec(2, 4));

    }

    public static int exponentiation(int a, int b){
      if(a!=0 && b==0){
          return 1;
      } else if (b == 1){
          return a;
          } else {
          int exp = 1;
        for (int i = 0; i < b; i++) {
            exp *= a;
        }
        return exp;
      }
    }

    // возведение числа в степень с помощью рекурсии
    // a*a*a*a = (a*(b-1))*a

    public static int expRec(int a, int b){
        if(a!=0 && b==0){
            return 1;
        } else if (b == 1){
            return a;
        } else if(b%2 == 0){
            return expRec(a, b/2) * expRec(a, b/2);
        }
        else {
            return expRec(a, b-1) * a;
        }
    }
}
