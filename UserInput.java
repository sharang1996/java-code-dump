import java.util.*;
import java.io.*;
import java.lang.Math;
class UserInput{
	public static void main(String args[ ]){
		int ch,i=0;
		String s=null;
           int n;
		Scanner sa=new Scanner(System.in);
   do
   {
		System.out.println("Methods\n1.Scanner(for calculating   factorial)\n2.Buffered Reader\n3.Console\n4.Data Input Stream\n5.Command line agrs[]\nEnter Your Choice");
		ch=sa.nextInt();
		switch(ch){
			case 1: Scanner in = new Scanner(System.in);
                         System.out.println("Enter Number");
					n = in.nextInt();
					if(n!=0)
                                                                                   {    i=n*(n-1);
                                                                                       n--;
 }
System.out.println("Factorial is " + i);
break;
case 2: BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
try{
s = br.readLine();
}catch(Exception e){}
System.out.println("your input was " + s);
break;
case 3: Console cn = System.console();

System.out.println("Enter Input");	
  s = cn.readLine();
         


char[ ] pwdChars = cn.readPassword("Password: ");
String pwdString = new String(pwdChars);

     
        if(pwdString.equals("p"))
        {                    
        System.out.println("your input was " + s);
         break;
        }
        else System.out.println("your input was " + s);

        break;

case 4: DataInputStream d = new DataInputStream(System.in); 
try{		
s=d.readLine();
}catch(Exception e){}
System.out.println("your input was " + s);
break;
	case 5:                          
                                                                                            s=args[0];	
			 	System.out.println("your input was " + s);
                                                                             default: System.out.println("Wrong Input");
		}
}while(true);
	}
}

