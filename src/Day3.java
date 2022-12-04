import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Day3 {

    public static String substring(int a, int b, String temp){
        String res = "";
        for(int i = a; i < b; i++){
            char ch1 = temp.charAt(i);
            res = res + ch1;
        }
        return res;
    }


    public static void part1(List<String> list){
        int sumOfPriorities = 0;
        list = Collections.emptyList();
        try{
            list = Files.readAllLines(Paths.get("C:\\Users\\liamm\\Documents\\AdventOfCode\\src\\resources\\input3.txt"), StandardCharsets.UTF_8);
        } catch (IOException e){
            e.printStackTrace();
        }
        for(int i = 0; i < list.size(); i++){
            String firstCompartment = substring(0, (list.get(i).length()/2), list.get(i));
            String secondCompartment = substring((list.get(i).length()/2), list.get(i).length(), list.get(i));
            int duplicate = 0;
            for(int j = 0; j < firstCompartment.length(); j++){
                for(int k = 0; k < secondCompartment.length(); k++){
                    if(firstCompartment.charAt(j) == secondCompartment.charAt(k)){
                        duplicate = secondCompartment.charAt(k);
                    }
                }
            }
            if(Character.isUpperCase(duplicate)){
                sumOfPriorities += duplicate - 38;
            } else {
                sumOfPriorities += duplicate - 96;
            }
        }
        System.out.println("Answer: Sum of priorities is " + sumOfPriorities);
    }

    public static void main(String[] args){
        List<String> test = new ArrayList<>();
        part1(test);
    }
}
