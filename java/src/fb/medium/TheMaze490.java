package fb.medium;
//There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
//
//        Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.
//
//        The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.
//
//        Example 1
//
//        Input 1: a maze represented by a 2D array
//
//        0 0 1 0 0
//        0 0 0 0 0
//        0 0 0 1 0
//        1 1 0 1 1
//        0 0 0 0 0
//
//        Input 2: start coordinate (rowStart, colStart) = (0, 4)
//        Input 3: destination coordinate (rowDest, colDest) = (4, 4)
//
//        Output: true
//        Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.
//
//        Example 2
//
//        Input 1: a maze represented by a 2D array
//
//        0 0 1 0 0
//        0 0 0 0 0
//        0 0 0 1 0
//        1 1 0 1 1
//        0 0 0 0 0
//
//        Input 2: start coordinate (rowStart, colStart) = (0, 4)
//        Input 3: destination coordinate (rowDest, colDest) = (3, 2)
//
//        Output: false
//        Explanation: There is no way for the ball to stop at the destination.
//
//        Note:
//        There is only one ball and one destination in the maze.
//        Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
//        The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.
//        The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.

public class TheMaze490 {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int n=maze.length;
        int m=maze[0].length;
        boolean[][] visited=new boolean[n][m];
        if(maze[start[0]][start[1]]==1  || maze[destination[0]][destination[1]]==1){return false;}
        return dfs(maze , start[0] , start[1] , destination[0] , destination[1] , visited , n , m);
    }
    private boolean dfs(int[][] maze  , int i , int j , int x , int y , boolean[][] visited , int n , int m){
        visited[i][j]=true;
        if(i==x&&j==y){
            return true;
        }
        int[][] directions={{1 , 0} , {-1 , 0} , {0 , -1} , {0 , 1}};
        for(int[] d:directions){
            int nextI=i+d[0];
            int nextJ=j+d[1];
            while(nextI>-1&&nextJ>-1&&nextI<n&&nextJ<m&&maze[nextI][nextJ]==0){
                nextI+=d[0];
                nextJ+=d[1];
            }
            nextI-=d[0];
            nextJ-=d[1];
            if(!visited[nextI][nextJ]){
                if(dfs(maze , nextI , nextJ , x , y , visited , n , m)){
                    return true;
                }
            }
        }
        return false;
    }
}
