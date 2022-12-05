import java.awt.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Day4 {

    public static void part1(List<String> list){
        list = Collections.emptyList();
        try{
            list = Files.readAllLines(Paths.get("C:\\Users\\liamm\\Documents\\AdventOfCode\\src\\resources\\input4.txt"), StandardCharsets.UTF_8);
        } catch (IOException e){
            e.printStackTrace();
        }
        int containTheOther = 0;
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
            String[] pairSplit = list.get(i).split(",");
            String[] firstPair = pairSplit[0].split("-");
            String[] secondPair = pairSplit[1].split("-");
            System.out.println(Arrays.toString(pairSplit));
            System.out.println(Arrays.toString(firstPair));
            System.out.println(Arrays.toString(secondPair));
            IntStream stream1 = IntStream.range(Integer.parseInt(firstPair[0]), Integer.parseInt(firstPair[1]));
            IntStream stream2 = IntStream.range(Integer.parseInt(secondPair[0]), Integer.parseInt(secondPair[1]));
            int[] arr1 = stream1.toArray();
            int[] arr2 = stream2.toArray();
            System.out.println(Arrays.toString(arr1));
            System.out.println(Arrays.toString(arr2));

        }
        System.out.println("Answer: " + containTheOther);
    }

    private static boolean isOverlap(int[] arr){
        for(int i = 1; i < arr.length; i++){
            if(arr[i] <= arr[i-i]){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        List<String> test = new ArrayList<>();
        part1(test);
    }
}
