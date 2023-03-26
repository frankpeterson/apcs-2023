package unit10;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Maze {
    private boolean solution;
    private char[][] maze;
    private char checked;

    /**
     * Instantiates a Maze instance based on the provided arguments
     * 
     * @param rows the number of rows
     * @param cols the number of columns
     * @param line the values to be placed in the maze.
     */
    public Maze(int rows, int cols, String line) {
        char[] word = line.toCharArray();
        int count = 0;
        maze = new char[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                maze[r][c] = word[count];
                count++;
            }
        }
    }

    /**
     * @return the starting coordinates as "r c"
     */
    public String getStart() { /* Not shown, plz ignore implementation */
        int z = Arrays.stream(maze).map(String::new).collect(Collectors.joining("")).indexOf('@');
        return "" + z / maze[0].length + " " + z % maze[0].length;
    }

    /**
     * @return the ending coordinates as "r c"
     */
    public String getEnd() { /* Not shown, plz ignore implementation */
        int z = Arrays.stream(maze).map(String::new).collect(Collectors.joining("")).indexOf('$');
        return "" + z / maze[0].length + " " + z % maze[0].length;
    }

    /**
     * Uses recursion to see if the maze has a solution or not.
     * 
     * Suggested algorithm:
     * if R and C are in bounds and spot is !#
     * - if you are at $:
     * - - set has a solution
     * - else:
     * - - mark spot as checked
     * - - recur up
     * - - recur down
     * - - recur left
     * - - recur right
     * 
     * @param r current row index
     * @param c current column index
     */
    private boolean check(int r, int c) {
            if (r >= 0 && r < maze.length) {
                if (c >= 0 && c < maze[r].length) {
                    if (maze[r][c] != 'c') {
                    if (maze[r][c] != '#') {
                        maze[r][c] = 'c';
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean explore(int r, int c) {
        boolean a = true;
            if (check(r, c) == true) {
                if (maze[r][c] != '$') {
                a = false;
                explore(r + 1, c);
                explore(r - 1, c);
                explore(r, c + 1);
                explore(r, c - 1);
            }
        }
        return a;
    }

    /**
     * Determines if there is a solution (a path of '.') for this maze.
     * 
     * @return true if the maze has a path from Start (@) to End ($).
     */
    public boolean hasSolution() {
        int ival = 0;
        int kval = 0;

    // for (int i = 0; i < maze.length; i++){
    //     for (int k = 0; k < maze[i].length; k++){
    //         if(maze[i][k] == '@'){
    //             ival = i;
    //             kval = k;
    //         }
    //     }
    // }
    
        if (explore(ival, kval) == false)
            return false;
        return true;

    }

    // HINT overriding toString may be handy. :)

    public static void check(boolean test) throws AssertionError {
        if (!test)
            throw new AssertionError("sad panda");
    }

    public static void main(String[] args) {
        Maze example = new Maze(3, 3, "#.@.....$");
        check(example.hasSolution());

    Maze case1 = new Maze(5, 7, ".#.#....#.#.##@.....$#...#.##..#...");
    check(case1.hasSolution());

        Maze case2 = new Maze(4, 4, ".#.$.##..##.@..#");
        check(!case2.hasSolution());

        Maze test = new Maze(3, 3, "#.@.....$");
        check(test.hasSolution());

        test = new Maze(3, 3, "##@#####$");
        check(!test.hasSolution());

        test = new Maze(3, 3, "##@#..#.$");
        check(test.hasSolution());

        test = new Maze(3, 3, "#.@#.##.$");
        check(test.hasSolution());

        test = new Maze(3, 3, "##@#.##.$");
        check(!test.hasSolution());

        System.out.println("Happy Panda! \uD83D\uDC3C");

    }

}
