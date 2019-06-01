import java.util.*;

public class Search1{

	public static void main(String[] args) {
		int runstate=-1;
		Scanner sc1=new Scanner(System.in);
		while(runstate!=2)
		{
		System.out.println("Welcome to Maps of Destruction:");
		System.out.print("Pick a map from 1 to 9 :");
		int mapnumberchoice = sc1.nextInt();
		Agent ag =new Agent();
		int[][] inputmapchoice=ag.mapChoice(mapnumberchoice,sc1);
		ag.searchExecution(inputmapchoice,sc1);
		System.out.print("Do you want to run again: 1)Yes 2)No,Exit: " );
		runstate=sc1.nextInt();
		}
		sc1.close();
	  
	  System.out.println("\nThank You for using Maps of Destruction.");
	}

}

class Agent extends Node
{
	public int[][] mapChoice(int mapchoice,Scanner sc1)
	{

		int[][] map1 = new int [][] {
	       	{0, 5, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
	       	{5, 0, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
	       	{5, 5, 0, 5, 5, 10, 10, 10, 10, 5, 10, 5, 10, 10, 10 },
	       	{10, 10, 5, 2, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
	       	{10, 10, 5, 10, 0, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
	       	{10, 10, 10, 10, 5, 0, 5, 5, 10, 10, 10, 10, 10, 10, 10 },
	       	{10, 10, 10, 10, 10, 5, 0, 10, 10, 10, 5, 10, 10, 10, 10 },
	       	{10, 10, 10, 10, 10, 5, 10, 0, 5, 5, 5, 10, 10, 10, 10 },
	       	{10, 10, 10, 10, 10, 10, 10, 5, 0, 5, 10, 10, 10, 10, 10 },
	       	{10, 10, 5, 10, 10, 10, 10, 5, 5, 0, 10, 5, 5, 10, 10 },
	       	{10, 10, 10, 10, 10, 10, 5, 5, 10, 10, 0, 10, 10, 5, 10 },
	       	{10, 10, 5, 10, 10, 10, 10, 10, 10, 5, 10, 0, 10, 10, 5 },
	       	{10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 0, 5, 10 },
	       	{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 5, 8, 10 },
	       	{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 0 }
	       	};
	       	
	int[][] map2 = new int [][] {
	       {0, 5, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, 
	       {5, 0, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, 
	       {5, 5, 0, 5, 5, 10, 10, 10, 10, 5, 10, 5, 10, 10, 10}, 
	       {10, 10, 5, 2, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, 
	       {10, 10, 5, 10, 0, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, 
	       {10, 10, 10, 10, 10, 8, 5, 5, 10, 10, 10, 10, 10, 10, 10}, 
	       {10, 10, 10, 10, 10, 5, 0, 10, 10, 10, 5, 10, 10, 10, 10}, 
	       {10, 10, 10, 10, 10, 5, 10, 0, 5, 5, 5, 10, 10, 10, 10}, 
	       {10, 10, 10, 10, 10, 10, 10, 5, 0, 5, 10, 10, 10, 10, 10}, 
	       {10, 10, 5, 10, 10, 10, 10, 5, 5, 0, 10, 5, 5, 10, 10}, 
	       {10, 10, 10, 10, 10, 10, 5, 5, 10, 10, 0, 10, 10, 5, 10}, 
	       {10, 10, 5, 10, 10, 10, 10, 10, 10, 5, 10, 0, 10, 10, 5}, 
	       {10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 0, 5, 10}, 
	       {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 5, 0, 10}, 
	       {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 0}
	       };
	        
	int[][] map3 = new int [][] {	
	       {0, 5, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
	       {5, 0, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
	       {5, 5, 0, 5, 5, 10, 10, 10, 10, 5, 10, 5, 10, 10, 10},
	       {10, 10, 5, 2, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
	       {10, 10, 5, 10, 0, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10},
	       {10, 10, 10, 10, 5, 0, 5, 5, 10, 10, 10, 10, 10, 10, 10},
	       {10, 10, 10, 10, 10, 5, 0, 10, 10, 10, 5, 10, 10, 10, 10},
	       {10, 10, 10, 10, 10, 5, 10, 0, 5, 5, 5, 10, 10, 10, 10},
	       {10, 10, 10, 10, 10, 10, 10, 5, 0, 5, 10, 10, 10, 10, 10},
	       {10, 10, 5, 10, 10, 10, 10, 5, 5, 0, 10, 5, 5, 10, 10},
	       {10, 10, 10, 10, 10, 10, 5, 5, 10, 10, 0, 10, 10, 5, 10},
	       {10, 10, 5, 10, 10, 10, 10, 10, 10, 5, 10, 0, 10, 10, 10},
	       {10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 0, 5, 10},
	       {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 5, 0, 10},
	       {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 8}
	       };
	       
	int[][] map4 = new int [][] {	
	       {2, 5, 5, 10, 10, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10},
	       {5, 0, 5, 10, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
	       {5, 5, 0, 5, 5, 10, 10, 10, 5, 5, 10, 5, 10, 10, 10},
	       {10, 10, 5, 0, 10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 5},
	       {10, 5, 5, 10, 0, 5, 10, 5, 10, 10, 10, 10, 10, 10, 10},
	       {5, 10, 10, 10, 5, 0, 5, 5, 10, 10, 10, 10, 10, 10, 10},
	       {10, 10, 10, 10, 10, 5, 0, 10, 10, 10, 5, 10, 10, 10, 10},
	       {10, 10, 10, 10, 5, 5, 10, 0, 5, 5, 5, 10, 10, 10, 10},
	       {10, 10, 5, 10, 10, 10, 10, 5, 0, 5, 10, 5, 10, 5, 10},
	       {10, 10, 5, 10, 10, 10, 10, 5, 5, 0, 10, 5, 5, 10, 10},
	       {10, 10, 10, 10, 10, 10, 5, 5, 10, 10, 0, 10, 10, 5, 10},
	       {10, 10, 5, 5, 10, 10, 10, 10, 5, 5, 10, 0, 10, 10, 10},
	       {10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 8, 5, 5},
	       {10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 5, 10, 5, 0, 5},
	       {10, 10, 10, 5, 10, 10, 10, 10, 10, 10, 10, 10, 5, 5, 0}
	       };
	       
	int[][] map5 = new int [][] {	
	       {0, 5, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
	       {5, 0, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
	       {5, 5, 0, 5, 5, 10, 10, 10, 10, 10, 10, 5, 10, 10, 10},
	       {10, 10, 5, 2, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
	       {10, 10, 5, 10, 0, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10},
	       {10, 10, 10, 10, 5, 0, 5, 5, 10, 10, 10, 10, 10, 10, 10},
	       {10, 10, 10, 10, 10, 5, 0, 10, 10, 10, 10, 10, 10, 10, 10},
	       {10, 10, 10, 10, 10, 5, 10, 0, 5, 10, 5, 10, 10, 10, 10},
	       {10, 10, 10, 10, 10, 10, 10, 5, 0, 5, 10, 10, 10, 10, 10},
	       {10, 10, 10, 10, 10, 10, 10, 10, 5, 0, 10, 10, 5, 10, 10},
	       {10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 0, 10, 10, 5, 10},
	       {10, 10, 5, 10, 10, 10, 10, 10, 10, 10, 10, 0, 10, 10, 5},
	       {10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 0, 5, 10},
	       {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 5, 8, 10},
	       {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 0}
	       };
	       
	int[][] map6 = new int [][] {	
	       	{2, 5, 10, 10, 5, 10, 10},
	       	{5, 0, 5, 10, 10, 10, 10},
	       	{10, 5, 0, 5, 10, 10, 10},
	       	{10, 10, 5, 8, 10, 10, 5},
	       	{5, 10, 10, 10, 0, 5, 10},
	       	{10, 10, 10, 10, 5, 0, 5},
	       	{10, 10, 10, 5, 10, 5, 0}
		};
	       	
	int[][] map7 = new int [][] {	
	       {0, 5, 10, 10, 10, 10, 10},
	       {5, 0, 5, 10, 10, 10, 10},
	       {10, 5, 2, 5, 10, 10, 10},
	       {10, 10, 5, 0, 10, 10, 5},
	       {10, 10, 10, 10, 8, 10, 10},
	       {10, 10, 10, 10, 10, 0, 5},
	       {10, 10, 10, 5, 10, 5, 0}
	       };
	       
	int[][] map8 = new int [][] {	
	       {0, 5, 10, 10, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
	       {5, 8, 5, 10, 10, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
	       {10, 5, 0, 5, 10, 10, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10},
	       {10, 10, 5, 0, 10, 10, 10, 5, 10, 10, 10, 10, 10, 10, 10, 10},
	       {5, 10, 10, 10, 0, 5, 10, 10, 5, 10, 10, 10, 10, 10, 10, 10},
	       {10, 5, 10, 10, 5, 0, 5, 10, 10, 5, 10, 10, 10, 10, 10, 10},
	       {10, 10, 5, 10, 10, 5, 0, 5, 10, 10, 5, 10, 10, 10, 10, 10},
	       {10, 10, 10, 5, 10, 10, 5, 0, 10, 10, 10, 5, 10, 10, 10, 10},
	       {10, 10, 10, 10, 5, 10, 10, 10, 0, 5, 10, 10, 5, 10, 10, 10},
	       {10, 10, 10, 10, 10, 5, 10, 10, 5, 0, 5, 10, 10, 5, 10, 10},
	       {10, 10, 10, 10, 10, 10, 5, 10, 10, 5, 0, 5, 10, 10, 5, 10},
	       {10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 5, 0, 10, 10, 10, 5},
	       {10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 10, 0, 5, 10, 10},
	       {10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 5, 0, 5, 10},
	       {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 5, 2, 5},
	       {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 5, 0}
	       };
	       
	int[][] map9 = new int [][] {
	       {0, 5, 10, 10, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
	       {5, 0, 5, 10, 10, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
	       {10, 5, 0, 5, 10, 10, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10},
	       {10, 10, 5, 0, 10, 10, 10, 5, 10, 10, 10, 10, 10, 10, 10, 10},
	       {5, 10, 10, 10, 0, 5, 10, 10, 5, 10, 10, 10, 10, 10, 10, 10},
	       {10, 5, 10, 10, 5, 0, 10, 10, 10, 5, 10, 10, 10, 10, 10, 10},
	       {10, 10, 5, 10, 10, 10, 0, 5, 10, 10, 5, 10, 10, 10, 10, 10},
	       {10, 10, 10, 5, 10, 10, 5, 2, 10, 10, 10, 5, 10, 10, 10, 10},
	       {10, 10, 10, 10, 5, 10, 10, 10, 0, 5, 10, 10, 5, 10, 10, 10},
	       {10, 10, 10, 10, 10, 5, 10, 10, 5, 8, 10, 10, 10, 10, 10, 10},
	       {10, 10, 10, 10, 10, 10, 5, 10, 10, 10, 0, 5, 10, 10, 5, 10},
	       {10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 5, 0, 10, 10, 10, 5},
	       {10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 10, 0, 5, 10, 10},
	       {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 0, 5, 10},
	       {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 5, 0, 5},
	       {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 5, 0}
	       };
	       
	       int input=0;
	       
	       do {
	       switch (mapchoice)
			{
	       case 1 : input=1;return map1;
	       case 2 : input=1;return map2;
	       case 3 : input=1;return map3;
	       case 4 : input=1;return map4;
	       case 5 : input=1;return map5;
	       case 6 : input=1;return map6;
	       case 7 : input=1;return map7;
	       case 8 : input=1;return map8;
	       case 9 : input=1;return map9;
	       default : System.out.print("Invalid Number, Enter again:");
	       
	       mapchoice = sc1.nextInt();break;	       
			} 
	       }while(input==0);
		return null;
	}
	public void searchExecution(int[][] inputmapchoice, Scanner sc1)
	{
		
		int execrunstate=-1;
		
		   System.out.print("Select Search Algorithm: 1)BFS 2)DFS 3)Compare Both 4)Exit: ");
		   execrunstate=sc1.nextInt();
	       while(execrunstate!=4)
	       {   
	    	   
	    	   
		       
	       switch(execrunstate)
	       {	
	       
	       case 1:   
	    	   breadthFirstSearch(createRootNode(inputmapchoice),createGoalNode(inputmapchoice),inputmapchoice);
	    	   System.out.println();
	    	   System.out.print("\nSelect Search Algorithm: 1)BFS 2)DFS 3)Compare Both 4)Exit: ");
			   execrunstate=sc1.nextInt();break;
	       
	       case 2:   
	    	  depthFirstSearch(createRootNode(inputmapchoice),createGoalNode(inputmapchoice),inputmapchoice);
	    	   System.out.println();
	    	   System.out.print("\nSelect Search Algorithm: 1)BFS 2)DFS 3)Compare Both 4)Exit: ");
			   execrunstate=sc1.nextInt();break;
	 
	       case 3:   
	    	   breadthFirstSearch(createRootNode(inputmapchoice),createGoalNode(inputmapchoice),inputmapchoice);
	    	   System.out.println();
	    	   depthFirstSearch(createRootNode(inputmapchoice),createGoalNode(inputmapchoice),inputmapchoice);
	    	   System.out.println();
	    	   System.out.print("\nSelect Search Algorithm: 1)BFS 2)DFS 3)Compare Both 4)Exit: ");
			   execrunstate=sc1.nextInt();break;
			   
	       case 4: 
	    	   execrunstate=4;break;
	       
	       default : System.out.print("Invalid Number, Enter again:");
	       	   execrunstate = sc1.nextInt();break;
	       	  
	       }
	      
	       }
	   
	}
	public void breadthFirstSearch(Node rootNode,Node goalNode,int[][] map)
	{
		Queue<Node> frontier = new LinkedList<Node>();
		char[] explored = new char[(map.length)];
		ArrayList<Node> nodelist=new ArrayList<Node>();
		Node goalnode=goalNode;
		Node currentnode=rootNode;
		frontier.add(currentnode);
		int currentiteration=0;
		while(!frontier.isEmpty())
		{
			//Printing the current state of the elements
			 System.out.print("\nIteration "+currentiteration+": ");
			 System.out.print("\nCurrent Node: "+frontier.peek().state);
			 displayQueue(frontier);
			 displayArray(explored);
			 if(goalTest(currentnode,goalnode))
			 {
				 goalnode=currentnode;
				 pathTraversal(goalnode);break;
			 }
			 nodelist=expandBFS(currentnode,map,frontier,explored);
			 displayExpandedNodes(nodelist);
			 explored[currentiteration]=currentnode.state;
			 frontier.remove();
			 frontier.addAll(nodelist);
			 currentiteration++;
			 if(!frontier.isEmpty()) 
				 currentnode=frontier.peek();
					else
					{
					System.out.println("\n\nNo Path exists from Initial State to Goal State thru BFS.");break;
					}			 
			 System.out.println();
			 
		}
		
	}
	public void depthFirstSearch(Node rootNode,Node goalNode,int[][] map)
	{
		Stack<Node> frontier = new Stack<Node>();
		char[] explored = new char[(map.length)];
		ArrayList<Node> nodelist=new ArrayList<Node>();
		Node goalnode=goalNode;
		Node currentnode=rootNode;
		frontier.add(currentnode);
		int currentiteration=0;
		while(!frontier.isEmpty())
		{
			//Printing the current state of the elements
			 System.out.print("\nIteration "+currentiteration+": ");
			 System.out.print("\nCurrent Node: "+frontier.peek().state);
			 displayStack(frontier);
			 displayArray(explored);
			 if(goalTest(currentnode,goalnode))
			 {
				 goalnode=currentnode;
				 pathTraversal(goalnode);break;
			 }
			 nodelist=expandDFS(currentnode,map,frontier,explored);
			 displayExpandedNodes(nodelist);
			 explored[currentiteration]=currentnode.state;
			 frontier.pop();
			 frontier.addAll(nodelist);
			 currentiteration++;
			 if(!frontier.isEmpty()) 
				 currentnode=frontier.peek();
					else
					{
					System.out.println("\n\nNo Path exists from Initial State to Goal State thru DFS.");break;
					}
			 System.out.println();
			 
		}
	}
}




class Node
{
	char state;
	Node parentNode;
	int pathCost;
	
	public char indexToState(int i)
	{
		return (char)(i+65);
	}
	
	public int stateToIndex(char state)
	{
		return (((int)state)-65);
	}
	
	
	 public Node makeNode(char state, Node pn)
	{
		Node n= new Node();
		n.state= state;
		n.parentNode=pn;
		if(pn==null)
			n.pathCost=0;
		else
			n.pathCost=pn.pathCost+1;
		return n;
	}
	 public ArrayList<Node> expandBFS(Node n1, int[][] map,Queue<Node> inputFrontier,char[] inputExplored)
	 {
		 int currentlocation=stateToIndex(n1.state);
		 ArrayList<Node> nodes=new ArrayList<Node>();
		 for(int i=0;i<map[currentlocation].length;i++)
			{
			 if(map[currentlocation][i]==5&&(!checkQueue(inputFrontier,i))&&(!checkArray(inputExplored,i)))
				{
				  nodes.add(makeNode(indexToState(i),n1));
				}
			 
			}
		 return nodes;
	 }
	 public ArrayList<Node> expandDFS(Node n1, int[][] map,Stack<Node> inputFrontier,char[] inputExplored)
	 {
		 int currentlocation=stateToIndex(n1.state);
		 ArrayList<Node> nodes=new ArrayList<Node>();
		 for(int i=map[currentlocation].length-1;i>=0;i--)
			{
			 if(map[currentlocation][i]==5&&(!checkStack(inputFrontier,i))&&(!checkArray(inputExplored,i)))
				{
				  nodes.add(makeNode(indexToState(i),n1));
				}
			 
			}
		 return nodes;
	 }
	 public void displayExpandedNodes(ArrayList<Node> nodelist)
	 {   if(nodelist.size()!=0)
	 {
		 System.out.print("\nThe Expanded nodes in this iteration are:"+nodelist.get(0).state );
		 for(int i=1;i<nodelist.size();i++)
		 {
			 System.out.print(","+nodelist.get(i).state);
		 }
	 }
	 }
	 public boolean checkQueue(Queue<Node> inputQueue, int i)
	 {
		Iterator<Node> itr= inputQueue.iterator();
		int counter=0;
		while(itr.hasNext()) {
			if(itr.next().state==indexToState(i))
				counter++;}
		if(counter>0)
			return true;
		else 
			return false;
	 }
	 public boolean checkStack(Stack<Node> inputStack, int i)
	 {
		Iterator<Node> itr= inputStack.iterator();
		int counter=0;
		while(itr.hasNext()) {
			if(itr.next().state==indexToState(i))
				counter++;}
		if(counter>0)
			return true;
		else 
			return false;
	 }
	 public boolean checkArray(char[] inputArray,int index)
	 {
	       for(int i=0;i<inputArray.length;i++)
	       {
	    	   if(inputArray[i]==indexToState(index))
	    		   return true;
	    	  
	       }
		return false;
	       
	 }
	 public void displayQueue(Queue<Node> inputQueue)
	 {
		Iterator<Node> itr= inputQueue.iterator();
		System.out.print("\nThe Frontier Elements are:" + itr.next().state);
		while(itr.hasNext()) {
		System.out.print(","+itr.next().state);
		}
	 }
	 public void displayStack(Stack<Node> inputStack)
	 {  
		Iterator<Node> itr= inputStack.iterator();
		if(itr.hasNext())
		{
		System.out.print("\nThe Frontier Elements are:" + itr.next().state);
		while(itr.hasNext()) {
		System.out.print(","+itr.next().state);
		}
		}
		else System.out.print("Frontier Elements:null");
	 }
	 public void displayArray(char[] inputArray)
	 {
		 System.out.print("\nThe Explored States are: "+inputArray[0]);
	       for(int i=1;i<inputArray.length;i++)
	       {
	    	      if(inputArray[i]!='\u0000')
	    		   System.out.print(","+inputArray[i]);
	       }
	    	   	
	 }
	 
	 public void pathTraversal(Node n1)
	 {
		 ArrayList<Character> path=new ArrayList<Character>();
		 
		Node temp=n1;
		
		while (temp!=null)
		 {
			path.add(temp.state);
	
			temp=temp.parentNode;
			 
		 }
		 System.out.print("\n\nThe Path traversed to reach goal state is : "+ path.get(path.size()-1));
		 for(int j=path.size()-2;j>=0;j--)
		 {
			 System.out.print("->"+path.get(j));
		 }
		 System.out.print("\nThe Path Cost is:"+n1.pathCost);
	 }
	
	 public boolean goalTest(Node n1,Node goalNode)
	 {
		 if (n1.state==goalNode.state)
			 return true;
		 else
			 return false;
	 }
	  public Node createRootNode(int [][] inputmap)
	  {
		  Node n1=null;
		  for(int i=0;i<inputmap.length;i++)
		   	 {
		   		 if(inputmap[i][i]==2)
		   		 {
		   			 n1=makeNode(indexToState(i),null);
		   		 }
		   	 }
			 return n1;
			
	  }
	  public Node createGoalNode(int [][] inputmap)
	  {
		  Node n1=null;
		  for(int i=0;i<inputmap.length;i++)
		   	 {
		   		 if(inputmap[i][i]==8)
		   		 {
		   			 n1=makeNode(indexToState(i),null);
		   		 }
		   	 }
			 return n1;
			
	  }
	  
	
	 
}
