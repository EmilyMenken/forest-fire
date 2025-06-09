import java.util.*;
public class Fire {
    /**
     * Returns how long it takes for all vulnerable trees to be set on fire if a
     * match is lit at a given location.
     * 
     * The forest is represented via a rectangular 2d char array where t represents a tree
     * and . represents an empty space.
     * 
     * At time 0, the tree at location [matchR, matchC] is set on fire. At every subsequent
     * time step, any tree that is adjacent (up/down/left/right) to a burning tree is also
     * set on fire. 
     * 
     * 
     * EXAMPLE 
     * forest:
     * 
     * t..tttt.t
     * ..tt....t
     * ..ttttttt
     * tttt.....
     * 
     * matchR: 2
     * matchC: 6
     * 
     * Result: 8
     * 
     * Explanation:
     * At time 0, the tree at (2, 6) is set on fire. At time 1, its adjacent trees also catch on fire
     * At time 2, the trees adjacent to those catch as well. At time 8, the last tree to catch is at
     * (0,6). In this example, there is one tree that never burns, so it is not included in the time calculation.
     * 
     * 
     * @param forest a 2d array where t represents a tree and . represents the ground
     * @param matchR The row the match is lit at
     * @param matchC The column the match is lit at
     * @return the time at which the final tree to be incinerated starts burning
     */
    public static int timeToBurn(char[][] forest, int matchR, int matchC) {
        // HINT: when adding to your BFS queue, you can include more information than
        // just a location. What other information might be useful?

        //BFS
        //int[] = [r ,c, time]
        //return time
        boolean[][] visited = new boolean[forest.length][forest[0].length];
        int[] initialBurnTime = {matchR, matchC, 0};

        int[][] directions = {
            {-1,0}, //up
            {1,0}, //down
            {0,-1}, //left
            {0,1} //right
        };

        int burnTime = 0;

        Queue<int[]> q = new LinkedList<>();
        q.add(initialBurnTime);
        int[] currBurningTree = new int[3];
        while(!q.isEmpty())
        {
            currBurningTree = q.poll();
            if(visited[currBurningTree[0]][currBurningTree[1]])
            {
                continue;
            }

            visited[currBurningTree[0]][currBurningTree[1]] = true;

            if(forest[currBurningTree[0]][currBurningTree[1]] == 't')
            {
                burnTime = Math.max(burnTime, currBurningTree[2]);
            }

            //find other burning trees method call here
            List<int[]> treeNeighbors = getTreeNeighbors(currBurningTree[0], currBurningTree[1], directions, forest, currBurningTree[2]);
            q.addAll(treeNeighbors);
        }
        return burnTime;
    }

    //MORE HINT: current depth for third variable
    //keep track of the depth for each movement
    //return last depth element in the q for the burn time
    

    public static List<int[]> getTreeNeighbors(int r, int c, int[][] directions, char[][] forest, int currTime)
    {
        List<int[]> possibleTrees = new ArrayList<>();

        for(int[] d : directions)
        {   
            int rr = r + d[0];
            int cc = c + d[1];

            
        if (rr >= 0 && cc >= 0 && rr < forest.length 
        && cc < forest[0].length && forest[rr][cc] == 't') {

            possibleTrees.add(new int[]{rr, cc, currTime + 1});

        }//end if
    }//end for
        
        return possibleTrees;
    }//end getTreeNeighbors


        //check if in bounds
        //check base case (epmty space)
        //loop over directions and as long as trees contiue to burn increase time

        //{current row, current column, current time}, put time in and take time back out

}