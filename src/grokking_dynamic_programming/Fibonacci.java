package grokking_dynamic_programming;

public class Fibonacci {
    //0, 1 ,1, 2, 3, 5, 8, 13, 21
    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();
        System.out.println("5th Fibonacci is ---> " + fib.fibonacciRec(5));
        System.out.println("6th Fibonacci is ---> " + fib.fibonacciRec(6));
        System.out.println("7th Fibonacci is ---> " + fib.fibonacciRec(7));

        System.out.println("5th Fibonacci is ---> " + fib.fibonacciMemo(5));
        System.out.println("6th Fibonacci is ---> " + fib.fibonacciMemo(6));
        System.out.println("7th Fibonacci is ---> " + fib.fibonacciMemo(7));

        System.out.println("5th Fibonacci is ---> " + fib.fibonacciTab(5));
        System.out.println("6th Fibonacci is ---> " + fib.fibonacciTab(6));
        System.out.println("7th Fibonacci is ---> " + fib.fibonacciTab(7));
    }

    public int fibonacciRec(int n) {
        if (n < 2) {
            return n;
        }
        return fibonacciRec(n - 1) + fibonacciRec(n - 2);
    }

    public int fibonacciMemo(int n) {
        int result[] = new int[n + 1];
        return fibonacciMemoUtil(result, n);
    }

    private int fibonacciMemoUtil(int[] result, int n) {
        if (n < 2) {
            return n;
        }
        if (result[n] != 0) {
            return result[n];
        }
        result[n] = fibonacciMemoUtil(result, n - 1) + fibonacciMemoUtil(result, n - 2);
        return result[n];
    }

    private int fibonacciTab(int n) {
        if (n < 2) {
            return n;
        }
        int res[] = new int[n + 1];
        res[0] = 0;
        res[1] = 1;
        for (int i = 2; i <= n; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n];
    }
}
