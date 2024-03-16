import java.util.Arrays;

public class recursionTest1 {
    public static void printNumber(int n) {
        if (n == 0)
            return;
        System.out.println("Number :" + n);
        printNumber(n - 1);

    }

    public static void printSum(int n1, int i, int sum) {
        if (i == n1 + 1) {
            System.out.println(sum);
            return;
        }
        sum += i;
        printSum(n1, i + 1, sum);
        System.out.println(i);
    }

    public static int calcFac(int n) {
        if (n == 1 || n == 0)
            return 1;
        int fact1 = calcFac(n - 1);
        int fact2 = n * fact1;
        return fact2;
    }

    public static void fib(int a, int b, int s) {
        if (s == 0 || s == 1)
            return;
        int c = a + b;
        System.out.println(c);
        fib(b, c, s - 1);

    }

    public static int xPowerN(int x, int n) {
        if (x == 0)
            return 0;
        if (n == 0)
            return 1;
        /*int xPnm = xPowerN(x, n-1);
        int xPn = x*xPnm;
        return xPn;*/
        if (n % 2 == 0) {
            return xPowerN(x, n / 2) * xPowerN(x, n / 2);
        } else
            return xPowerN(x, n / 2) * xPowerN(x, n / 2) * x;
    }

    public static StringBuilder reverseString(StringBuilder str) {
        for (int i = 0; i < str.length() / 2; i++) {
            int front = i;
            int back = str.length() - 1 - i;
            char frontChar = str.charAt(front);
            char backChar = str.charAt(back);

            str.setCharAt(front, backChar);
            str.setCharAt(back, frontChar);
        }
        return str;
    }

    public static void main(String args[]) {
//        printSum(5,1,0);
//        calculate factorial
/*
        int fact = calcFac(4);
        System.out.println(fact);
*/
//        Print Fib series
/*
        int a= 0,b =1;
        int s = 7;
        System.out.println(a);
        System.out.println(b);
        fib(a,b,s-1);
*/
//      Calculate X power N
/*
        int x = 5, n = 4;
        System.out.println(xPowerN(x,n));
*/
//      Reverse String using StringBuilder
/*
        StringBuilder str = new StringBuilder("somData");
        System.out.println(reverseString(str));
*/
        String str1 = "    dasds3 wsdsadfc ef s     ";
        String str2 = str1.trim();
        String[] str3 = str2.split("a");
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(Arrays.toString(str3));


    }
}
