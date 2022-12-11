import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class Day8 {

    public static void part1(){
        List<String> list = Collections.emptyList();
        int visibleTrees = 0;
        try{
            list = Files.readAllLines(Paths.get("src\\resources\\input8.txt"));
        } catch (IOException e){
            e.printStackTrace();
        }
        String[] rows = list.toArray(new String[0]);
        int[][] arr2D = new int[rows.length][rows.length];
        for(int i = 0; i < rows.length; i++){
            for(int j = 0; j < rows.length; j++){
                arr2D[i][j] = Integer.parseInt(String.valueOf(rows[i].charAt(j)));
            }
        }
        for(int row = 0; row < arr2D[0].length; row++){
            for(int col = 0; col < arr2D[1].length; col++){
                if(isVisible(arr2D,row,col)){
                    visibleTrees++;
                }
            }
        }
        System.out.println("Answer: "+ visibleTrees + " trees are visible from outside the grid");
    }

    public static void part2(){
        int highestScenicScore = 0;
        int currentScenicScore;
        List<String> list = Collections.emptyList();
        try{
            list = Files.readAllLines(Paths.get("src\\resources\\input8.txt"));
        } catch (IOException e){
            e.printStackTrace();
        }
        String[] rows = list.toArray(new String[0]);
        int[][] arr2D = new int[rows.length][rows.length];
        for(int row = 0; row < rows.length; row++){
            for(int col = 0; col < rows.length; col++){
                arr2D[row][col] = Integer.parseInt(String.valueOf(rows[row].charAt(col)));
            }
        }
        for(int row = 0; row < arr2D[0].length; row++){
            for(int col = 0; col < arr2D[1].length; col++){
                currentScenicScore = calcScenicScore(arr2D,row,col);
                if(highestScenicScore < currentScenicScore){
                    highestScenicScore = currentScenicScore;
                }
            }
        }
        System.out.println("Answer: The highest scenic score possible is " + highestScenicScore);
    }

    public static int calcScenicScore(int[][] input, int row, int col){
        int currentTree = input[row][col];
        int treesSeenUp = 0;
        int treesSeenLeft = 0;
        int treesSeenDown = 0;
        int treesSeenRight = 0;
        // Looking up
        for(int r = row-1; r >= 0; r--){
            treesSeenUp++;
            int nextTree = input[r][col];
            if(nextTree >= currentTree){
                break;
            }
        }
        // Looking left
        for(int c = col-1; c >= 0; c--){
            treesSeenLeft++;
            int nextTree = input[row][c];
            if(nextTree >= currentTree){
                break;
            }
        }
        // Looking down
        for(int r = row+1; r < input[0].length; r++){
            treesSeenDown++;
            int nextTree = input[r][col];
            if(nextTree >= currentTree){
                break;
            }
        }
        // Looking right
        for(int c = col+1; c < input[1].length; c++){
            treesSeenRight++;
            int nextTree = input[row][c];
            if(nextTree >= currentTree){
                break;
            }
        }
        return treesSeenUp * treesSeenLeft * treesSeenDown * treesSeenRight;
    }

    public static boolean isVisible(int[][] input, int row, int col){
        int nextTree;
        int currentTree = input[row][col];
        boolean isVisibleRight = true;
        boolean isVisibleLeft = true;
        boolean isVisibleTop = true;
        boolean isVisibleBottom = true;
        // IsVisibleRight
        for(int c = col+1; c < input[1].length; c++){
            nextTree = input[row][c];
            if(nextTree >= currentTree){
                isVisibleRight = false;
            }
        }
        // isVisibleLeft
        for(int c = col-1; c >= 0; c--){
            nextTree = input[row][c];
            if(nextTree >= currentTree){
                isVisibleLeft = false;
            }
        }
        // isVisibleTop
        for(int r = row-1; r >= 0; r--){
            nextTree = input[r][col];
            if(nextTree >= currentTree){
                isVisibleTop = false;
            }
        }

        // isVisibleBottom
        for(int r = row+1; r < input[0].length; r++){
            nextTree = input[r][col];
            if(nextTree >= currentTree){
                isVisibleBottom = false;
            }
        }
        return isVisibleRight || isVisibleLeft || isVisibleTop || isVisibleBottom;
    }

    public static void main(String[] args){
        part1();
        part2();
    }
}
