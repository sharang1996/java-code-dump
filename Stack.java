import java.util.Scanner;
public class Stack 
{
	LinkedList stack;
	Node top;
	
	Stack(){
		stack = new LinkedList();
		top=null;
	}
	
	public boolean isEmpty()
	{
		if(top==null) return true;
		else return false;
	}
	
	public void push(int d)
	{
		
		if(top==null)
		{
			stack.start=new Node(d);
			top=stack.start;
		}
		else
		stack.insert(d,1);	
	}
	 
	public void pop()
	{   
		if(top==null){
			 System.out.println("empty!!");
			 return;
		 }	
		System.out.println(top.data+" popped!");
		top=top.next;
		stack.delete(1);
	}
       
       public void printStack()
       {
		  stack.print();
       }	
	
	public static void main (String args[])
	 {
		 Scanner s = new Scanner(System.in);
		 Stack obj =new Stack();
		
		int ch=0;
		while(ch!=4)
	  {
		System.out.println("Enter 1 to push data,2 to pop,3 to print and 4 to exit");
		ch=s.nextInt();
		
		switch(ch)
		{
			case 1: System.out.println("Enter data to push");
			        int d=s.nextInt();
			        obj.push(d);
			        break;
			
			case 2: obj.pop();
			        break;
			        
			case 3: obj.printStack();
			        break;
			        
			case 4: break;
			        
			
		}
	  }	
	}
	}
