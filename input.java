import java.util.Scanner;
class input
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);
System.out.println("enter 3 numbers");
//int a= sc.nextInt();
//int b= sc.nextInt();
//int c= sc.nextInt();
int a=Integer.parseInt(args[0]);
int b=Integer.parseInt(args[1]);
int c=Integer.parseInt(args[2]);
System.out.println("the maximum is"+Math.max(a,(Math.max(b,c))));
}
}
