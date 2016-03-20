import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Collections;

class student1 implements Comparable<student1> {
    @Override
    public int compareTo(student1 another) {
		
        return this.rollno-another.rollno;
    }
Scanner s=new Scanner(System.in);
int rollno;
String name,addr;

void setRoll()
{ 
	System.out.println("Enter roll no.:");
    rollno=s.nextInt();
}

void setName()
{ 
	System.out.println("Enter name:");
    name=s.next();
}

void setAddr()
{ 
	System.out.println("Enter address:");
    addr=s.next();
}

int getRoll()
{ 
	return rollno;
}

String getName()
{ 
	return name;
}

String getAddr()
{ 
	return addr;
}

}





class student 
{
	
	
	public static void main(String args[])
 { 
	 int ch=0;
	 Scanner sc=new Scanner(System.in);
     List<student1> list = new ArrayList<>();
     while(ch!=6)
     {
		 
     System.out.println("Enter 1 to add student details,2 to retreive student details,3 to delete,4 to print and 5 to sort and 6 to exit");
     ch=sc.nextInt();
     switch(ch)
     {
		 
		 case 1:
		         student1 s = new student1();
		         s.setName();
		         s.setRoll();
		         s.setAddr();
		         list.add(s);
		  break;
     
        case 2: 
                 student1 s1 = new student1();
                 System.out.println("Enter entry number");
                 int n = sc.nextInt();
                 s1=list.get(n-1);
                 System.out.println("name is"+s1.getName());
		         System.out.println("Roll no is"+s1.getRoll());
		         System.out.println("Address is"+s1.getAddr());
		  break;
		  
		  case 3: 
		         System.out.println("Enter entry number");
                 int n2 = sc.nextInt();
                 list.remove(n2-1);
          break;
          
          case 4: 
                 student1 s2 = new student1();
                 int n3=list.size();
                 for(int i=0;i<n3;++i)
                 {
					 s2=list.get(i);
					 System.out.println("name is"+s2.getName());
		             System.out.println("Roll no is"+s2.getRoll());
		             System.out.println("Address is"+s2.getAddr());
				 }
		  break;
		  
		  case 5: 
		           System.out.println("sorting....");
		            Collections.sort(list);
		            System.out.println("sorted!!!");
		           break;
		 
		 case 6:break;
		  
		}	 
       }
  }
}





