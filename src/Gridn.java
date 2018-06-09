


import edu.princeton.cs.introcs.StdDraw;

import java.util.ArrayList;


public class Gridn {
	private int grid[][] ;
    static int prof=1;
	static int i=0;
	static int j=0;
    static double t=1000;
    static double a=t/3;



	public Gridn (int[][] grid) {
		
		this.grid = grid;
	}

	public void setGridn (int[][] grid,int x, int y) {
		for (int row = 0; row < x; ++row) {
	         for (int col = 0; col < y; ++col) {
	            grid[row][col] = 0;
	         }
	      }
		this.grid = grid;
	}

	public int[][] getGrid() {
		return this.grid;
	}
	
	
	public String Display() {
		for (int row = 0; row < grid.length; ++row) {
			System.out.println("");
	         for (int col = 0; col < grid.length; ++col) {
	        	if(this.grid[row][col]==1) {
	            System.out.print( " X " );
	            System.out.print(" ");
	        	}
	        	if(this.grid[row][col]==2) {
		            System.out.print( " 0 " );
		            System.out.print(" ");
		        	}
	        	if(this.grid[row][col]==0) {
		            System.out.print( " O " );
		            System.out.print(" ");
		        	}
	        
	         }
	         System.out.println("");
	      }
         return "";
	}
	
	public int Verify2() {
			   
		 for (int row = 0; row < grid.length; ++row) {
			  int rowcount =0;
		         for (int col = 0; col < grid.length; ++col) {
		            if(grid[row][col] == 1) {
		            	rowcount++;
		            	if(rowcount== 3) {System.out.println("c1");return 1;}
		            }else { rowcount = 0;}
		 				}
		         
		 }
		 for (int row = 0; row < grid.length; ++row) {
			  int rowcount =0;
		         for (int col = 0; col < grid.length; ++col) {
		            if(grid[row][col] == 2) {
		            	rowcount++;
		            	if(rowcount== 3) {System.out.println("c2");return 2;}
		            }else { rowcount = 0;}
		 				}
		         
		 }
		    
		         	
		 for (int row = 0; row < grid.length; ++row) {
			  int rowcount =0;
		         for (int col = 0; col < grid.length; ++col) {
		            if(grid[col][row] == 1) {
		            	rowcount++;
		            	if(rowcount== 3) {System.out.println("l1");return 1;}
		            }else { rowcount = 0;}
		 				}
		         
		 }
		 for (int row = 0; row < grid.length; ++row) {
			  int rowcount =0;
		         for (int col = 0; col < grid.length; ++col) {
		            if(grid[col][row] == 2) {
		            	rowcount++;
		            	if(rowcount== 3) {System.out.println("l2");return 2;}
		            }else { rowcount = 0;}
		 				}
		         
		 }
		 int c1 =0;
		 for (int row = 0; row < grid.length; ++row) {
		         for (int col = 0; col < grid.length; ++col) {
		            if(grid[row][col] == 2 && row == col) {
		            	c1++;
		            	if(c1== 3) {System.out.println("d2");return 2;}
		            }
		 }}
		 int c2 =0;
		 for (int row = 0; row < grid.length; ++row) {
		         for (int col = 0; col < grid.length; ++col) {
		            if(grid[row][col] == 1 && row == col) {
		            	c2++;
		            	if(c2== 3) {System.out.println("d1");return 1;}
		            }
		 				}
		         
		 }
		 int c3 =0;
		 for (int row = 0; row < grid.length; ++row) {
		         for (int col = 0; col < grid.length; ++col) {
		            if(grid[row][col] == 1 && ((row ==1 &&col ==1 )|| (row==0 && col==2) ||(col==0 && row==2))) {
		            	c3++;
		            	
		            	if(c3== 3) {System.out.println("c3");return 1;}
		            }
		 				}
		         
		 }
		 int c4 =0;
		 for (int row = 0; row < grid.length; ++row) {
		         for (int col = 0; col < grid.length; ++col) {
		            if(grid[row][col] == 2 && ((row ==1 &&col ==1) || (row==0 && col==2) ||(col==0 && row==2))) {
		            	c4++;
		            	
		            	if(c4== 3) {System.out.println("c4");return 2;}
		            }
		 				}
		         
		 }
			 int count =0 ;
			 for (int row = 0; row < grid.length; ++row) {
		         for (int col = 0; col < grid.length; ++col) {
		            if (grid[row][col] == 2 || grid[row][col]==1) {count++;}
		           
		         }
		      }
			 
			 if (count==(grid.length)*(grid.length)) { 
				System.out.println("plein");
			 	return -1;}else {return 0;}
			 
			         }

	public boolean Fill(int x,int y) {
		if (this.grid[x][y] == 0) {
			return false;
		}else {
			return true;
		}
	} 
	public int[][] Insert(int x, int y,int p) {
		this.grid[x][y]= p;
		return this.grid;
	}
	public boolean contain(String list[],String b){
	    for(i=0;i<list.length;i++) {
	        if (list[i] == b){
	            return true;
	        }
	    }return false;
	}
	public String[] Coups(){
		int i=0;
		String[] coups = {"","","","","","","","","","","","","",""};
		for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 3; ++col) {

				if (grid[row][col] == 0){
					coups[i]=Integer.toString(row) + Integer.toString(col);
				}
				i++;
		}
	}return coups;

	}

	
	 ArrayList<String> list = new ArrayList<String>();
	public void disG() {

        StdDraw.enableDoubleBuffering();


        for (int row = 0; row < grid.length; ++row) {
            for (int col = 0; col < grid.length; ++col) {

                int[] co = {row + 1, col + 1};
                if (! list.contains( Integer.toString(row) + Integer.toString(col))) {


                        switch (this.grid[row][col]) {
                            case 1:
                                list.add( Integer.toString(row) + Integer.toString(col));
                                for (double u = 0.0; true; u += 0.05) {
                                    double x = t/20 * u;
                                    StdDraw.picture(a * co[1] - a / 2, a * co[0] - a / 2, "croix.png", x, x);//32 15 ,5
                                    if (x > t/4) break;
                                    StdDraw.show();
                                }break;

                            case 2:
                                list.add( Integer.toString(row) + Integer.toString(col));
                                for (double u = 0.0; true; u += 0.05) {
                                    double x = t/20 * u;
                                    StdDraw.setPenColor(StdDraw.BLUE);
                                    StdDraw.filledCircle(a * co[1] - a / 2, a * co[0] - a / 2, x / 3);//32 15 ,5
                                    StdDraw.setPenColor(StdDraw.WHITE);
                                    StdDraw.filledCircle(a * co[1] - a / 2, a * co[0] - a / 2, x / 3 - x / 9);//32 15 ,5
                                    if (x > t/4) break;
                                    StdDraw.show();
                                }break;
                        }





                    }
                }

            }


        }

		public int Verify(){
			for (int i =0;i<grid.length;i++) {
				if (grid[i][0]==grid[i][1]&&grid[i][0]==grid[i][2] &&grid[i][0]!=0) {//col
					return grid[i][0];
				}
				if (grid[0][i]==grid[1][i]&&grid[0][i]==grid[2][i] &&grid[0][i]!=0) {//row
					return grid[0][i];
				}
			}
			if (grid[0][0]==grid[1][1]&&grid[0][0]==grid[2][2] &&grid[0][0]!=0) {//d1
				return grid[0][0];
			}
			if (grid[0][2]==grid[1][1]&&grid[0][2]==grid[2][0] &&grid[0][2]!=0) {//d2
				return grid[0][2];
			}
			
			return -1;
		}
		

}
	
		
	
	
	
	
	
