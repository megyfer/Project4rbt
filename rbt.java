//meg fernandez myf140030
import java.util.Scanner;

public class rbt {
	RBTreeNode root;
	static Scanner in = new Scanner(System.in);
		private static class RBTreeNode {
			int element;
			RBTreeNode left;
			RBTreeNode Right;
			boolean isRed;
				public RBTreeNode(int e, boolean r){
					this.element=e;
					this.isRed=r;
					this.left=null;
					this.Right=null;
				}	
				private boolean isRed(RBTreeNode n){
					if(n==null) return false;
					return n.isRed;
				}
			}
		public rbt(){}

	
	private boolean isRed(RBTreeNode x){
		if(x==null) return false;
		return x.isRed;
	}
	public boolean contains(int e){
		return contains(root, e);
	}
	private boolean contains(RBTreeNode n, int e){
		if(n==null){
			return false;
		}
			if(n.element<e){
				return contains(n.Right, e);
			}
			else if(n.element>e){
				return contains(n.left,e);
			}
			else if(n.element == e){
				return true;
			}
			
		return false;
	}
	public void insert(int e){
		root = insert(root, e);
		root.isRed=false;
	}
	private RBTreeNode insert(RBTreeNode n, int e){
		if(n==null){
			return new RBTreeNode(e, true);
			
		}
		if(n.element<e){
			n.Right=insert(n.Right,e);
		}
		else if(n.element>e){
			n.left = insert(n.left,e);
		}
		else{
			n.element=e;
		}
		
		
		if(n.left!=null&&n.left.left!=null){
		if((n.left.isRed)&&(n.left.left.isRed)){
			return balance(n.left.left, n.left, n, n.left.left.Right,n.left.Right);
		}}
		else if(n.left!=null&&n.left.Right!=null){
		if(n.left.isRed&&n.left.Right.isRed){
			return balance(n.left, n.left.Right, n, n.left.Right.left, n.left.Right.Right);
		}}
		else if(n.Right!=null&&n.Right.left!=null){
		if(n.Right.isRed&&n.Right.left.isRed){
			return balance(n, n.Right.left, n.Right, n.Right.left.left, n.Right.left.Right);
		}}
		else if(n.Right!=null&&n.Right.Right!=null){
		if(n.Right.isRed&&n.Right.Right.isRed){
			return balance(n, n.Right, n.Right.Right, n.Right.left, n.Right.Right.left);
		}}
		
		return n;
		
	}
	private RBTreeNode balance(RBTreeNode a, RBTreeNode b, RBTreeNode c, RBTreeNode d, RBTreeNode e){
		a.Right=d;
		b.left=a;
		b.Right=c;
		c.left=e;
		a.isRed=false;
		b.isRed=true;
		c.isRed=false;
		return b;
	}
	private RBTreeNode rotater(RBTreeNode n){
		RBTreeNode x = n.left;
		n.left = x.Right;
		x.Right = n;
		x.isRed=x.Right.isRed;
		x.Right.isRed=true;
		return x;
	}
	private RBTreeNode rotatel(RBTreeNode n){
		RBTreeNode x = n.Right;
		n.Right = x.left;
		x.left = n;
		x.isRed=x.left.isRed;
		x.left.isRed=true;
		return x;
	}
	private void flip(RBTreeNode n){
		n.isRed=true;
		n.left.isRed=false;
		n.Right.isRed=false;
		
	}
	void InOrderTreeTraversal(){
		
			inOrder(root);
		}
		void inOrder(RBTreeNode t){
			if(t!=null){
				inOrder(t.left);
				if(t.isRed==true){
					System.out.println("*"+t.element+" ");
				}
				else{
					System.out.println(t.element+" ");
				}
				inOrder(t.Right);
			}
		}
		public static void main(String[] args)
		   { rbt RBT = new rbt();
		   String s = "p";
		   while(!(s.equalsIgnoreCase("quit"))){
			   System.out.println("Red-Black Tree:\n"+"1.Insert\n"+
					   "2.Contains\n"+"3.Print tree\n"+"Please enter a number.\n");
		  
		   
			   s = in.nextLine();
		   
			   if(s.equalsIgnoreCase("1")){
				   System.out.println("What would you like to insert?");
				   s=in.nextLine();
				   RBT.insert(Integer.parseInt(s));
				   System.out.println("Done\n");
			   }
			   else if(s.equalsIgnoreCase("2")){
				   System.out.println("What are you looking for?");
				   s=in.nextLine();
				   System.out.println(RBT.contains(Integer.parseInt(s)));
			   }
			   else if(s.equalsIgnoreCase("3")){
				   RBT.InOrderTreeTraversal();}
		   		
		   
		   		else if(s.equalsIgnoreCase("quit")){
		   			System.exit(0);
		   		}
		   		else{
		   			System.out.println("Command invalid.\n");
		   		}
		   }
		   }
		
}
