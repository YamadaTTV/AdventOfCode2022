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

    public static void part2(List<String> list){
        int sumOfPriorities = 0;
        list = Collections.emptyList();
        try{
            list = Files.readAllLines(Paths.get("C:\\Users\\liamm\\Documents\\AdventOfCode\\src\\resources\\input3.txt"), StandardCharsets.UTF_8);
        } catch (IOException e){
            e.printStackTrace();
        }
        // We want to find one common character between three lines (a.k.a one group)
        char isCommon = ' ';
        for(int i = 2; i < list.size(); i = i + 3){
            char[] elf1 = list.get(i-2).toCharArray();
            char[] elf2 = list.get(i-1).toCharArray();
            char[] elf3 = list.get(i).toCharArray();
            for(char c: elf1){
                for(char c2: elf2){
                    if(c == c2){
                        for(char c3: elf3){
                            if(c3 == c2){
                                isCommon = c3;
                            }
                        }
                    }
                }
            }
            if(Character.isUpperCase(isCommon)){
                sumOfPriorities += ((int)isCommon) - 38;
            } else {
                sumOfPriorities += ((int)isCommon) - 96;
            }
        }
        System.out.println("Answer: Sum of priorities is " + sumOfPriorities);
    }

    public static void main(String[] args){
        List<String> test = new ArrayList<>();
        /* Part 1 */
        part1(test);
        /* Part 2 */
        part2(test);
    }
}
