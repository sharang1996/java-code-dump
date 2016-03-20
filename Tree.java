import java.util.Scanner;
class Node
{
	Node left,right;
	int data;
	public Node(int d)
	{
		left=right=null;
		data=d;
	}
}

class Stack
{
	Node stack[]=new Node[50];
	int top;
	
	Stack()
	{
		top=-1;
	}
	
	boolean isEmpty()
	{
		if(top==-1) return true;
		else return false;
	}
	
	void push(Node d)
	{
		stack[++top]=d;
	}
	
	Node pop()
	{
		return stack[top--];
	}
	
	Node topElement()
	{
		if(top==-1) return null;
		else
		return stack[top];
	}
}

class Queue {

    Node queue[]=new Node[100];
    int start;
    int end;

    Queue()
    {
        start=end=-1;
    }

    boolean isEmpty()
    {
        if(start==end && end==-1) return true;
        else return false;
    }

    void enqueue(Node d)
    {
        queue[++end]=d;
        if(start==-1) ++start;
    }

    Node dequeue()
    {
        Node n;
        if(start+1==end)
        {
            n = queue[start++];
            start=end=-1;
        }
        else
            n = queue[start++];
        return n;
    }
}


public class Tree {

    Node root,temp;
    Scanner sc = new Scanner(System.in);
    static int count = 0;
    static int countleaf = 0;

    public Tree()
    {
        root=temp=null;
    }

    public Tree(Node d)
    {
        root=d;
    }


    public void create()
    {

        int ch=0;
        int d=0;

        System.out.println("Enter root node data");
        d = sc.nextInt();

        root=new Node(d);

        while(ch!=2)
        {
            System.out.println("Enter 1 to enter data and 2 to exit");
            ch=sc.nextInt();

            if(ch==1)
            {
                System.out.println("Enter data");
                d=sc.nextInt();
            }
            else break;

            System.out.println("Enter l to insert at left and r to insert at right");
            String n=sc.next();

            temp=root;

            while(true)
            {
                //insert at left
                if(n.contentEquals("l"))
                {
                    if(temp.left==null)
                    {
                        temp.left=new Node(d);
                        break;
                    }
                    else temp=temp.left;
                }

                //insert at right
                if(n.contentEquals("r"))
                {
                    if(temp.right==null)
                    {
                        temp.right=new Node(d);
                        break;
                    }
                    else temp=temp.right;
                }

            }//end of while

        }//end of outer while
    }

    void inorder(){
        inorder(root);
    }

    void inorder(Node start)
    {
        if(start!=null)
        {
            inorder(start.left);
            System.out.println(start.data);
            inorder(start.right);
        }
    }

    void preorder(){
        preorder(root);
    }

    void preorder(Node start)
    {
        if(start!=null)
        {
            System.out.println(start.data);
            preorder(start.left);
            preorder(start.right);
        }
    }

    void postorder(){
        postorder(root);
    }

    void postorder(Node start)
    {
        if(start!=null)
        {
            postorder(start.left);
            postorder(start.right);
            System.out.println(start.data);
        }
    }

    void preOrderNonRec()
    {
        Stack s = new Stack();
        Node temp=root;
        while(true)
        {
            while(temp!=null)
            {
                s.push(temp);
                System.out.println(temp.data);   //printing during first touch
                temp=temp.left;
            }
            if(s.isEmpty()) break;

            temp=s.pop();                        //second touch
            temp=temp.right;

        }
    }

    void inOrderNonRec()
    {
        Stack s = new Stack();
        Node temp=root;
        while(true)
        {
            while(temp!=null)
            {
                s.push(temp);          //first touch
                temp=temp.left;
            }
            if(s.isEmpty()) break;

            temp=s.pop();
            System.out.println(temp.data);    //printing during second touch
            temp=temp.right;

        }
    }

    void postOrderNonRec()
    {
        Stack s = new Stack();
        Node temp=root;
        do
        {
            while(temp!=null)
            {
                if(temp.right!=null)
                    s.push(temp.right);
                s.push(temp);
                temp=temp.left;
            }

            temp=s.pop();
            if(temp.right!=null && temp.right==s.topElement())
            {
                Node temp2=s.pop();
                s.push(temp);
                temp=temp.right;
            }
            else
            {
                System.out.println(temp.data);
                temp=null;
            }
        }while(!s.isEmpty());
    }

    Node copy()
    {
        Node node;
        node=copy(root);
        return node;
    }

    Node copy(Node root1)
    {
        Node root2;
        if(root1!=null)
        {
            root2 = new Node(root1.data);
            root2.left = copy(root1.left);
            root2.right = copy(root1.right);
            return root2;
        }
        else return null;
    }

    Node mirror()
    {
        Node node= mirror(root);
        return node;

    }

    Node mirror(Node root1)
    {
        Node root2;
        if(root1!=null)
        {
            root2 = new Node(root1.data);
            root2.right = mirror(root1.left);
            root2.left = mirror(root1.right);
            return root2;
        }
        else return null;
    }

    int countNodes()
    {
        return countNodes(root);
    }

    int countNodes(Node root)
    {

        if(root==null) return count;
        else
        {
            ++count;
            count=countNodes(root.left);
            count=countNodes(root.right);
        }
        return count;
    }

    int countLeafNodes()
    {
        countleaf = 0;
        return countLeafNodes(root);
    }

    int countLeafNodes(Node root)
    {
        if(root == null) return countleaf;
        if(root.left == null && root.right == null) ++countleaf;
        countLeafNodes(root.left);
        countLeafNodes(root.right);
        return countleaf;
    }

    void bfs()
    {
        Queue q=new Queue();
        Node temp=root;
        Node dummy=null;
        q.enqueue(temp);
        q.enqueue(dummy);
        while(!q.isEmpty())
        {
            temp=q.dequeue();
            if(temp==dummy)
            {
                System.out.println("level increased \n");
                q.enqueue(dummy);
            }
            else
            {
                System.out.println(temp.data);
                if(temp.left!=null) q.enqueue(temp.left);
                if(temp.right!=null) q.enqueue(temp.right);
            }

        }

    }

    public static void main (String args[]) {


        Tree obj=new Tree();
        obj.create();

        System.out.println("");
        System.out.println("inorder");
        System.out.println("");

        obj.inorder();

        System.out.println("");
        System.out.println("preorder");
        System.out.println("");

        obj.preorder();

        System.out.println("");
        System.out.println("postorder");
        System.out.println("");

        obj.postorder();

        System.out.println("");
        System.out.println("Non recursive preorder");
        System.out.println("");

        obj.preOrderNonRec();

        System.out.println("");
        System.out.println("Non recursive inorder");
        System.out.println("");

        obj.inOrderNonRec();

        System.out.println("");
        System.out.println("Non recursive postorder");
        System.out.println("");

        obj.postOrderNonRec();
        System.out.println("");

        System.out.println("no of nodes"+obj.countNodes());
        System.out.println("no of leaf nodes"+obj.countLeafNodes());
        System.out.println("");

        System.out.println("printing copied tree...\n");
        Node cp = obj.copy();
        Tree obj2 = new Tree(cp);
        obj2.preorder();

        System.out.println("printing mirrored tree...\n");
        Node mrr=obj.mirror();
        Tree obj3=new Tree(mrr);
        obj3.preorder();

        System.out.println("");

       // obj.bfs();
    }

}
