import java.util.*;
public class Demo1 {
     static int fib(int n)
    {
        if (n == 0)
        { return 0;
        }
        else if (n == 1)
        {
            return 1;
        }
            return fib(n - 1) + fib(n - 2);

    }

    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.print(fib(n));


        }

    }


