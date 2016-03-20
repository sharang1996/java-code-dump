import java.util.Scanner;
interface Figure 
{
	public double area();
}
class circle implements Figure
{
	double r;
	public circle()
	{
		r=7;
	}
	public double area()
	{
		return (22*r*r)/7 ;
	}
}	
	
class quad implements Figure
{
	
	double l,b;
	
	public quad()
	{
		l=7;
		b=9;
	}
	public double area()
	{
		return l*b ;
	}
}
	
class FindArea
{
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1 for quadrilateral and 2 for circle");
		if(sc.nextInt()==1){
			quad obj1=new quad();
		System.out.println(obj1.area());
	}   else
	{
		circle obj2=new circle();
		System.out.println(obj2.area());
		
	}
		
	}
}

