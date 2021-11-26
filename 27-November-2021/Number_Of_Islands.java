class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int noOfIslands = 0;
        for(int x = 0; x< rows; x++){
            for(int y = 0; y<cols; y++){
                if(grid[x][y] == '1'){
                    markIslandAsVisited(grid, rows, cols, x, y);
                    noOfIslands++;
                }
            }
        }    
        return noOfIslands;
    }
    
    public static void markIslandAsVisited(char[][] grid, int rows, int cols, int x, int y){
        
        //Boundary case, Water case
        if(x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] != '1'){
            return;
        }
        
        //Mark land part visit
        grid[x][y]='2';
        
        //Visit whole island by going into four direction
        markIslandAsVisited(grid, rows, cols, x-1, y);
        markIslandAsVisited(grid, rows, cols, x+1, y);
        markIslandAsVisited(grid, rows, cols, x, y-1);
        markIslandAsVisited(grid, rows, cols, x, y+1);        
    }
}