import java.util.Scanner;
class Rational{
	
	int a;
	int b;
	
	public Rational(int a,int b)
	{
	this.a=a;
	this.b=b;	
	}
	
	public void add(Rational num2)
	{
		int numer = a*num2.b + num2.a*b ;
		int denom = b*num2.b;
		System.out.println(numer+"/"+denom);
	}
	
	public void multiply(Rational num2)
	{
		int numer = a*num2.a ;
		int denom = b*num2.b;
		System.out.println(numer+"/"+denom);
	}
}

public class Demo{
	
	
	public static void main(String args[]){
		
		Rational num1,num2;
		int n,d;
		Scanner sc = new Scanner(System.in);
	    System.out.println("Enter number 1 numerator and denominator");
	    num1=new Rational(sc.nextInt(),sc.nextInt());
	    System.out.println("Enter number 2 numerator and denominator");
	    num2=new Rational(sc.nextInt(),sc.nextInt());
	    
	    num1.add(num2);
	    num1.multiply(num2);
		
	   
	
}	
}
