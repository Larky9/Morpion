import java.util.Random;
public class Player {
	
	private int pion;
	private String name;
	
	public Player(int pion, String name) {
		this.pion = pion;
		this.name = name;
	}
	public int getPion() {
		return pion;
	}
	public void setPion(int pion) {
		this.pion = pion;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int[][] calculIA( Gridn grid,int prof){
		Random rand = new Random();
	   int max=-100000;
	   int maxi=-1;int maxj=-1;int tmp;Gridn gridtest = new Gridn(grid.getGrid());
	   if(  prof!=0 ||gridtest.Verify()==2|| gridtest.Verify()==1){
		
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 3; ++col) {
                if(gridtest.getGrid()[row][col]==0){
                gridtest.Insert(row,col ,2);
                tmp=calcMin(gridtest,prof-1);

                if (tmp>max|| tmp==max && rand.nextBoolean()){
                    max=tmp;maxi=row;maxj=col;
                }

                }
			}
		}
        }return grid.Insert(maxi,maxj ,2);
    }
    public int calcMax(Gridn grid,int prof){
        int max=-100000;
		int tmp; 
		if (prof==0 || grid.Verify()==2|| grid.Verify()==1) return IAeval(grid);
       
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 3; ++col) {
                if(grid.getGrid()[row][col]==0){
					
                    grid.Insert(row,col ,2);
                    tmp=calcMin(grid,prof-1);
                    if(tmp>max){
                        max=tmp;
                    }
                }grid.Insert(row,col ,0);
            }
        }return max;
    }

    public int calcMin(Gridn grid,int prof){
        int min=100000;
        int tmp;
		if (prof==0 || grid.Verify()==2|| grid.Verify()==1) return IAeval(grid);
		
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 3; ++col) {
                if(grid.getGrid()[row][col]==0){
                    grid.Insert(row,col ,2);
                    tmp=calcMax(grid,prof-1);
                    if(tmp<min){
                        min=tmp;
                    }
                    }grid.Insert(row,col ,0);
                }
            }return min;
	}

    public int IAeval(Gridn grid){
		
		 int s =0;
		for (int i =0;i<grid.getGrid().length;i++) {
			if (
			grid.getGrid()[i][0]==grid.getGrid()[i][1] && grid.getGrid()[i][0]==1|| 
			grid.getGrid()[i][1]==grid.getGrid()[i][2] && grid.getGrid()[i][1]==1||
			grid.getGrid()[i][0]==grid.getGrid()[i][2] && grid.getGrid()[i][0]==1
			 ) {//col 2p adversaire
				s-=30;
			}
			if (
			grid.getGrid()[0][i]==grid.getGrid()[1][i]&&grid.getGrid()[0][i]==1||
			grid.getGrid()[0][i]==grid.getGrid()[2][i]&&grid.getGrid()[0][i]==1||
			grid.getGrid()[1][i]==grid.getGrid()[2][i]&&grid.getGrid()[0][i]==1
			) {//row 2p adversaire
				s-=30;
			}
			if (
			 grid.getGrid()[i][0]==1|| 
			 grid.getGrid()[i][1]==1||
			 grid.getGrid()[i][2]==1
			 ) {//col 1p adversaire
				s-=10;
			}
			if (
			grid.getGrid()[0][i]==1||
			grid.getGrid()[0][i]==1||
			grid.getGrid()[0][i]==1
			) {//row 1p adversaire
				s-=10;
			}
		}
		if (grid.getGrid()[0][0]==grid.getGrid()[1][1]&&grid.getGrid()[0][0]==1) {//d1 adversaire 2p
			 s-=30;
		}
		if (grid.getGrid()[0][2]==grid.getGrid()[1][1]&&grid.getGrid()[0][2]==1 ) {//d2 adversaire 2p
			 s-=30;
		}
		if (grid.getGrid()[0][0]==1) {//d1 adversaire 1p
			 s-=10;
		}
		if (grid.getGrid()[0][2]==1 ) {//d2 adversaire 1p
			 s-=10;
		}
		for (int i =0;i<grid.getGrid().length;i++) {
			if (
			grid.getGrid()[i][0]==grid.getGrid()[i][1] && grid.getGrid()[i][0]==2|| 
			grid.getGrid()[i][1]==grid.getGrid()[i][2] && grid.getGrid()[i][1]==2||
			grid.getGrid()[i][0]==grid.getGrid()[i][2] && grid.getGrid()[i][0]==2
			 ) {//col 2p adversaire
				s+=30;
			}
			if (
			grid.getGrid()[0][i]==grid.getGrid()[1][i]&&grid.getGrid()[0][i]==2||
			grid.getGrid()[0][i]==grid.getGrid()[2][i]&&grid.getGrid()[0][i]==2||
			grid.getGrid()[1][i]==grid.getGrid()[2][i]&&grid.getGrid()[0][i]==2
			) {//row 2p adversaire
				s+=30;
			}
			if (
			 grid.getGrid()[i][0]==2|| 
			 grid.getGrid()[i][1]==2||
			 grid.getGrid()[i][2]==2
			 ) {//col 1p adversaire
				s+=10;
			}
			if (
			grid.getGrid()[0][i]==2||
			grid.getGrid()[0][i]==2||
			grid.getGrid()[0][i]==2
			) {//row 1p adversaire
				s+=10;
			}
		}
		if (grid.getGrid()[0][0]==grid.getGrid()[1][1]&&grid.getGrid()[0][0]==2) {//d1 adversaire 2p
			 s+=30;
		}
		if (grid.getGrid()[0][2]==grid.getGrid()[1][1]&&grid.getGrid()[0][2]==2 ) {//d2 adversaire 2p
			 s+=30;
		}
		if (grid.getGrid()[0][0]==2) {//d1 adversaire 1p
			 s+=10;
		}
		if (grid.getGrid()[0][2]==2 ) {//d2 adversaire 1p
			 s+=10;
		}
		return s;

	 }
	 public static int[] Rand(Gridn grid){
		Random rand = new Random();
		   int x = rand.nextInt(3);
			 int y = rand.nextInt(3);
			while( grid.Fill(x,y)){ 
			 x = rand.nextInt(3);
			 y = rand.nextInt(3);
			 return new int[]  {x,y};} return new int[]  {x,y};
	}
	public  int[] IADUMB(Gridn grid){
		/*
		for (int row = 0; row < grid.getGrid().length; ++row) {
			int rowcount =0;
			   for (int col = 0; col < grid.getGrid().length; ++col) {
				  if(grid.getGrid()[row][col] !=0) {
					  rowcount++;
					  if(rowcount== 2) {System.out.println("c1");
				  }Rand(grid);
					   }
					   }
			   
	   }

	   for (int row = 0; row < grid.getGrid().length; ++row) {
			int rowcount =0;
			   for (int col = 0; col < grid.getGrid().length; ++col) {
				  if(grid.getGrid()[col][row] != 0) {
					  rowcount++;
					  if(rowcount== 2) {System.out.println("l2");
					  
				  }Rand(grid);
					   }Rand(grid);
			   
	   }}
	
	   int c2 =0;
	   for (int row = 0; row < grid.getGrid().length; ++row) {
			   for (int col = 0; col < grid.getGrid().length; ++col) {
				  if(grid.getGrid()[row][col] != 0 && row == col) {
					  c2++;
					  if(c2== 2) {
						  System.out.println("d1");
						  switch (Integer.toString(row) + Integer.toString(col)){
							case "11":
							if (grid.getGrid()[2][2]==0) return new int[] {2,2};
							else return new int[] {0,0};
							case "00":
							if (grid.getGrid()[1][1]==0) return new int[] {1,1};
							else return new int[] {2,2};
							case "22":
							if (grid.getGrid()[0][0]==0) return new int[] {0,0};
							else return new int[] {1,1};
						}return Rand(grid);
				  }return Rand(grid);
					   }return Rand(grid);
			   
	   }}
	   int c4 =0;
	   for (int row = 0; row < grid.getGrid().length; ++row) {
			   for (int col = 0; col < grid.getGrid().length; ++col) {
				  if(grid.getGrid()[row][col] != 0 && ((row ==1 &&col ==1) || (row==0 && col==2) ||(col==0 && row==2))) {
					  c4++;
					  
					  if(c4== 2) {
						  System.out.println("d4");
						switch (Integer.toString(row) + Integer.toString(col)){
							case "11":
							if (grid.getGrid()[2][0]==0) return new int[] {2,0};
							else return new int[] {0,2};
							case "20":
							if (grid.getGrid()[1][1]==0) return new int[] {1,1};
							else return new int[] {0,2};
							case "02":
							if (grid.getGrid()[1][1]==0) return new int[] {1,1};
							else return new int[] {2,0};
						}return Rand(grid);
					
					}
					}
				  }
				}*/
					   return Rand(grid);
			   
	   }

}
