import java.util.Scanner;
class math
{
public int sum(int a,int b)
{
return a+b;
}
public int difference(int a,int b)
{
return a-b;
}
public int product(int a,int b)
{
return a*b;
}
public int division(int a,int b)
{
return (int)a/b;
}
}


class calculator
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);
System.out.println("enter 2 numbers");
//int a= sc.nextInt();
//int b= sc.nextInt();
//int c= sc.nextInt();
int a=Integer.parseInt(args[0]);
int b=Integer.parseInt(args[1]);
//int c=Integer.parseInt(args[2]);
math m = new math();
System.out.println("the sum is"+m.sum(a,b));
System.out.println("the difference is"+m.difference(a,b));
System.out.println("the product is"+m.product(a,b));
System.out.println("the quotient is"+m.division(a,b));
}
}

