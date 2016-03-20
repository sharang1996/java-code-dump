import java.util.Scanner;
class Node {
	
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
	Node(){
		data=-999;
		next=null;
	}
}

public class LinkedList
{
	
	Node start,temp,current;
	Scanner sc=new Scanner(System.in);
	int n;
	
	public LinkedList()
	{
		start= null;
	}
	
	public void create()
	{
		
		System.out.println("Enter the number of nodes");
		n=sc.nextInt();
		for(int i=0;i<n;++i)
		{

			System.out.println("Enter data");
		    int d=sc.nextInt();
			
			if(start==null)
			{
				start=new Node(d);
				current=start;
			}
			else
			{
				while(current.next!=null)
				{
					current=current.next;
				}
				current.next=new Node(d);
			}
		}
	}
	
	public void insert(int d,int pos) 
	{
		current=start;
		int tempdata=0;
		if(pos==1)
		{
			tempdata=start.data;
			start.data=d;
			temp=start.next;
			start.next=new Node(tempdata);
			start.next.next=temp;
		}
		else
		{
		   for(int i=1;i<pos-1;++i)
		   {
			current=current.next;
		   }
		   temp=current.next;
		   current.next=new Node(d);
		   current.next.next=temp;
	    }
	}
	
	public void delete(int pos)
	{
		current=start;
		if(pos==1)
		{
			start=start.next;
		}
		else
		{
		   for(int i=1;i<pos-1;++i)
		   {
			current=current.next;
		   }
		   temp=current.next.next;
		   current.next.next=null;
		   current.next=temp;
		}
	}
	
	public void print()
       {
		   temp=start;
		   
		   while(temp!=null)
		{
			System.out.println(temp.data);
			temp=temp.next;
		}
	
	
       }

	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		LinkedList obj = new LinkedList();
		int ch=0,pos;
		while(ch!=5)
	  {
		System.out.println("Enter 1 to create the list,2 to insert,3 to delete,4 to print and 5 to exit");
		ch=sc.nextInt();
		
		switch(ch)
		{
			case 1: obj.create();
			        break;
			
			case 2: System.out.println("Enter data position to insert data at");
			        int d=sc.nextInt();
			        pos=sc.nextInt();
			        obj.insert(d,pos);
			        break;
			        
			case 3: System.out.println("Enter position to delete data from");
			        pos=sc.nextInt();
			        obj.delete(pos);
			        break;
			        
			case 4: obj.print();
			        break;
			        
			case 5: break;
		}
	  }	
	}
}
