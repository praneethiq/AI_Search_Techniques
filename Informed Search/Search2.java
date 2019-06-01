import java.util.*;

public class Search2 {

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
		int[][] inputlocchoice=ag.locChoice(mapnumberchoice, sc1);
		ag.searchExecution(inputmapchoice,inputlocchoice,sc1);
		System.out.print("\nDo you want to run again: 1)Yes 2)No,Exit: " );
		runstate=sc1.nextInt();
		}
		sc1.close();
	  
	  System.out.println("Thank You for using Maps of Destruction.");
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
	       default : System.out.println("Invalid Number, Enter again:");
	       
	       mapchoice = sc1.nextInt();break;	       
			} 
	       }while(input==0);
		return null;
	}
	public int[][] locChoice(int mapchoice,Scanner sc1)
	{
		   int[][] loc1 = new int [][] {	
               {0,2},	
               {2,0},	
               {4,3},	
               {7,0},	
               {2,4},	
               {0,6},	
               {0,9},	
               {2,7},	
               {5,8},	
               {5,5},	
               {2,9},	
               {7,4},	
               {8,7},	
               {9,9},	
               {9,4},
                };
        	
int[][] loc2 = new int [][] {	
               {0,2},	
               {2,0},	
               {4,3},	
               {7,0},	
               {2,4},	
               {0,6},	
               {0,9},	
               {2,7},	
               {5,8},	
               {5,5},	
               {2,9},	
               {7,4},	
               {8,7},	
               {9,9},	
               {9,4},
                };
           
int[][] loc3 = new int [][] {	
               {0,2},	
               {2,0},	
               {4,3},	
               {7,0},	
               {2,4},	
               {0,6},	
               {0,9},	
               {2,7},	
               {5,8},	
               {5,5},	
               {2,9},	
               {7,4},	
               {8,7},	
               {9,9},	
               {9,4},
                };
                
int[][] loc4 = new int [][] {	
               {0,2},	
               {2,0},	
               {4,3},	
               {7,0},	
               {2,4},	
               {0,6},	
               {0,9},	
               {2,7},	
               {5,8},	
               {5,5},	
               {2,9},	
               {7,4},	
               {8,7},	
               {9,9},	
               {9,4},
                };
int[][] loc5 = new int [][] {	
               {0,2},	
               {2,0},	
               {4,3},	
               {7,0},	
               {2,4},	
               {0,6},	
               {0,9},	
               {2,7},	
               {5,8},	
               {5,5},	
               {2,9},	
               {7,4},	
               {8,7},	
               {9,9},	
               {9,4},
                };
                
int[][] loc6 = new int [][] {	
               {0,0},
               {5,3},
               {8,5},
               {9,9},
               {2,5},
               {4,7},
               {6,8},
                };
                	
int[][] loc7 = new int [][] {	
               {0,0},
               {5,3},
               {8,5},
               {9,9},
               {2,5},
               {4,7},
               {6,8},
                };

int[][] loc8 = new int [][] {	
               {0,0},
               {3,0},
               {6,0},
               {9,0},
               {0,3},
               {3,3},
               {6,3},
               {9,3},
               {0,6},
               {3,6},
               {6,6},
               {9,6},
               {0,9},
               {3,9},
               {6,9},
               {9,9},    
                };
    int[][] loc9 = new int [][] {	
               {0,0},
               {3,0},
               {6,0},
               {9,0},
               {0,3},
               {3,3},
               {6,3},
               {9,3},
               {0,6},
               {3,6},
               {6,6},
               {9,6},
               {0,9},
               {3,9},
               {6,9},
               {9,9}, 
               };
               int input=0;
    	       
    	       do {
    	       switch (mapchoice)
    			{
    	       case 1 : input=1;return loc1;
    	       case 2 : input=1;return loc2;
    	       case 3 : input=1;return loc3;
    	       case 4 : input=1;return loc4;
    	       case 5 : input=1;return loc5;
    	       case 6 : input=1;return loc6;
    	       case 7 : input=1;return loc7;
    	       case 8 : input=1;return loc8;
    	       case 9 : input=1;return loc9;
    	       default : System.out.println("Invalid Number, Enter again:");
    	       
    	       mapchoice = sc1.nextInt();break;	       
    			} 
    	       }while(input==0);
    		return null;
    	}
	public void searchExecution(int[][] inputmapchoice, int[][] inputlocchoice,Scanner sc1)
	{
		
		int execrunstate=-1;
		
		   System.out.println();
		   System.out.print("Select Search Algorithm: 1)BestFS 2)A*Search 3)Compare Both 4)Exit: ");
		   execrunstate=sc1.nextInt();
	       while(execrunstate!=4)
	       {   
	    	   
	    	   
		       
	       switch(execrunstate)
	       {	
	       
	       case 1:   
	    	   bestFirstSearch(inputmapchoice,inputlocchoice);
	    	   System.out.println();
	    	   System.out.print("\nSelect Search Algorithm: 1)BestFS 2)A*Search 3)Compare Both 4)Exit: ");
			   execrunstate=sc1.nextInt();break;
	       
	       case 2:   
	    	   aStarSearch(inputmapchoice,inputlocchoice);
	    	   System.out.println();
	    	   System.out.print("\nSelect Search Algorithm: 1)BestFS 2)A*Search 3)Compare Both 4)Exit: ");
			   execrunstate=sc1.nextInt();break;
	 
	       case 3:   
	    	   bestFirstSearch(inputmapchoice,inputlocchoice);
	    	   System.out.println();
	    	   aStarSearch(inputmapchoice,inputlocchoice);
	    	   System.out.println();
	    	   System.out.print("\nSelect Search Algorithm: 1)BestFS 2)A*Search 3)Compare Both 4)Exit: ");
			   execrunstate=sc1.nextInt();break;
			   
	       case 4: 
	    	   execrunstate=4;break;
	       
	       default : System.out.print("Invalid Number, Enter again:");
	       	   execrunstate = sc1.nextInt();break;
	       	  
	       }
	      
	       }
	   
	}
	
	
	public void bestFirstSearch(int[][] map,int[][] loc)
	{   
		
		PriorityQueue<Node> frontier = new PriorityQueue<>();
		char[] explored = new char[(map.length)];
		ArrayList<Node> nodelist=new ArrayList<Node>();
		Node goalnode=createGoalNode(map,loc);
		Node currentnode=createRootNode(map,loc,goalnode);
		frontier.add(currentnode);
		int currentiteration=0;
		while(!frontier.isEmpty())
		{
			
			System.out.print("\nIteration "+currentiteration+": ");
			 System.out.print("\nCurrent Node: "+frontier.peek().state);
			 displayPQueue(frontier);
			 displayArray(explored);
			 if(goalTest(currentnode,goalnode))
			 {
				 goalnode=currentnode;
				 pathTraversal(goalnode);break;
			 }
			 nodelist=expandBFS(currentnode, goalnode, map, loc, frontier, explored);
			 displayExpandedNodes(nodelist);
			 explored[currentiteration]=currentnode.state;
			 frontier.poll();
			 frontier.addAll(nodelist);
			 currentiteration++;
			 if(!frontier.isEmpty()) 
				 currentnode=frontier.peek();
					else
					{
					System.out.println("\n\nNo Path exists from Initial State to Goal State thru Best First Search.");break;
					}
			 System.out.println();
			
		}
		
	
	}
	public void aStarSearch(int[][] map,int[][] loc)
	{
		PriorityQueue<Node> frontier = new PriorityQueue<>();
		char[] explored = new char[(map.length)];
		ArrayList<Node> nodelist=new ArrayList<Node>();
		Node goalnode=createGoalNode(map,loc);
		Node currentnode=createRootNode(map,loc,goalnode);
		frontier.add(currentnode);
		int currentiteration=0;
		while(!frontier.isEmpty())
		{
			
			System.out.print("\nIteration "+currentiteration+": ");
			 System.out.print("\nCurrent Node: "+frontier.peek().state);
			 displayPQueue(frontier);
			 displayArray(explored);
			 if(goalTest(currentnode,goalnode))
			 {
				 goalnode=currentnode;
				 pathTraversal(goalnode);break;
			 }
			 nodelist=expandAFS(currentnode, goalnode, map, loc, frontier, explored);
			 displayExpandedNodes(nodelist);
			 explored[currentiteration]=currentnode.state;
			 frontier.poll();
			 frontier.addAll(nodelist);
			 currentiteration++;
			 if(!frontier.isEmpty()) 
				 currentnode=frontier.peek();
					else
					{
					System.out.println("\n\nNo Path exists from Initial State to Goal State thru A* Search.");break;
					}
			 System.out.println();
			
		}
	}

	
}
class Node implements Comparable<Node>
{
	char state;
	Node parentnode;
	double x;
	double y;
	double heuristiccost;
	int depth;
	double pathcost;
	
	public char indexToState(int i)
	{
		return (char)(i+65);
	}
	
	public int stateToIndex(char state)
	{
		return (((int)state)-65);
	}
	
	 public Node makeNodeBFS(char state, Node pn,int[] loc,Node gn)
	{
		Node n= new Node();
		n.state= state;
		n.parentnode=pn;
		n.x=(double)loc[0];
		n.y=(double)loc[1];
		if(pn==null)
		{
			n.heuristiccost=0.0;n.depth=0;n.pathcost=0.0;
		}
		else
		{
			n.heuristiccost=Math.sqrt( (Math.pow((gn.x-n.x),2) ) + Math.pow((gn.y-n.y),2) );depth=n.depth+1;n.pathcost=pn.pathcost+Math.sqrt( (Math.pow((pn.x-n.x),2) ) + Math.pow((pn.y-n.y),2) );
		}
		
		
		return n;
	}

	 public Node makeNodeAFS(char state, Node pn,int[] loc,Node gn)
		{
			Node n= new Node();
			n.state= state;
			n.parentnode=pn;
			n.x=(double)loc[0];
			n.y=(double)loc[1];
			if(pn==null)
			{
				n.heuristiccost=0.0;n.depth=0;n.pathcost=0.0;
			}
			else
			{
				n.heuristiccost=((Math.sqrt( (Math.pow((gn.x-n.x),2) ) + Math.pow((gn.y-n.y),2) ))+(pn.pathcost+Math.sqrt( (Math.pow((pn.x-n.x),2) ) + Math.pow((pn.y-n.y),2) )));
				depth=pn.depth+1;
				n.pathcost=pn.pathcost+Math.sqrt( (Math.pow((pn.x-n.x),2) ) + Math.pow((pn.y-n.y),2) );
			}
			
			
			return n;
		}

	 public ArrayList<Node> expandBFS(Node n1, Node gn, int[][] map, int[][] loc, PriorityQueue<Node> inputFrontier,char[] inputExplored)
	 {
		 int currentlocation=stateToIndex(n1.state);
		 ArrayList<Node> nodes=new ArrayList<Node>();
		 for(int i=0;i<map[currentlocation].length;i++)
			{
			 
			 if(map[currentlocation][i]==5&&(!checkPQueue(inputFrontier,i)&&(!checkArray(inputExplored,i))))
				 nodes.add(makeNodeBFS(indexToState(i),n1,loc[i],gn));
				
			 
			}
		 return nodes;
	 }
	 public ArrayList<Node> expandAFS(Node n1, Node gn, int[][] map, int[][] loc, PriorityQueue<Node> inputFrontier,char[] inputExplored)
	 {
		 int currentlocation=stateToIndex(n1.state);
		 ArrayList<Node> nodes=new ArrayList<Node>();
		 for(int i=0;i<map[currentlocation].length;i++)
			{
			 
			 if(map[currentlocation][i]==5&&(!checkPQueue(inputFrontier,i)&&(!checkArray(inputExplored,i))))
				 nodes.add(makeNodeAFS(indexToState(i),n1,loc[i],gn));
				
			 
			}
		 return nodes;
	 }
		 public void displayExpandedNodes(ArrayList<Node> nodelist)
		 {  
			 if(nodelist.size()!=0)
		 {
			 System.out.print("\nThe Expanded nodes in this iteration are:"+nodelist.get(0).state );
			 for(int i=1;i<nodelist.size();i++)
			 {
				 System.out.print(","+nodelist.get(i).state);
			 }
		 }
		 }
	    public boolean equals(Node n1) {
	        if (this == n1) return true;
	        
	        return 
	                state==n1.state;
	    }
	    public String toString() {
	    	if (this.parentnode!=null)
	    	{
	        return "State{" +"name='" + state + '\'' +", heuristiccost=" + heuristiccost +
	                "parentState{" +"name='"+parentnode.state+'\'' +'}' + x+" "+y+" "+parentnode.x+" "+parentnode.y;}
	    	else return "no parentnode";
	
	    }
	    public int compareTo(Node n2) {
	        if(this.heuristiccost > n2.heuristiccost) {
	            return 1;
	        } else if (this.heuristiccost < n2.heuristiccost) {
	            return -1;
	        } else {
	            return 0;
	        }
	    
	} 
	    public void displayPQueue(PriorityQueue<Node> inputQueue)
		 {
			Iterator<Node> itr= inputQueue.iterator();
			Node n1 =itr.next();
			System.out.print("\nThe Frontier Elements are: {"+n1.state+","+n1.heuristiccost+"}");
			while(itr.hasNext()) {
				n1=itr.next();
			System.out.print(",{"+n1.state+","+n1.heuristiccost+"}");
			}
		 }
	    public boolean checkPQueue(PriorityQueue<Node> inputQueue, int i)
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
	    public boolean checkArray(char[] inputArray,int index)
		 {
		       for(int i=0;i<inputArray.length;i++)
		       {
		    	   if(inputArray[i]==indexToState(index))
		    		   return true;
		    	  
		       }
			return false;
		       
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
		
				temp=temp.parentnode;
				 
			 }
			 System.out.print("\n\nThe Path traversed to reach goal state is : "+ path.get(path.size()-1));
			 for(int j=path.size()-2;j>=0;j--)
			 {
				 System.out.print("->"+path.get(j));
			 }
			 System.out.print("\nThe Path Cost is:"+n1.pathcost);
		 }
		
		 public boolean goalTest(Node n1,Node goalNode)
		 {
			 if (n1.state==goalNode.state)
				 return true;
			 else
				 return false;
		 }
		  public Node createRootNode(int [][] inputmap,int[][] loc, Node gn)
		  {
			  Node n1=null;
			  for(int i=0;i<inputmap.length;i++)
			   	 {
			   		 if(inputmap[i][i]==2)
			   		 {
			   			 n1=makeNodeBFS(indexToState(i),null,loc[i],gn);
			   		 }
			   	 }
				 return n1;
				
		  }
		  public Node createGoalNode(int [][] inputmap,int[][] loc)
		  {
			  Node n1=null;
			  for(int i=0;i<inputmap.length;i++)
			   	 {
			   		 if(inputmap[i][i]==8)
			   		 {
			   			 n1=makeNodeBFS(indexToState(i),null,loc[i],null);
			   		 }
			   	 }
				 return n1;
				
		  }
}
