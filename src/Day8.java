import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
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
        System.out.println(Arrays.toString(rows));
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
        System.out.println(visibleTrees);
    }

    public static void part2(){

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
    }
}
