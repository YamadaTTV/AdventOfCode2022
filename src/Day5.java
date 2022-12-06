import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Day5 {



    public static void part1(List<String> list){
        Stack<Character> stack1 = new Stack<>();
        list = Collections.emptyList();
        try{
            list = Files.readAllLines(Paths.get("src\\resources\\input5.txt"), StandardCharsets.UTF_8);
        } catch (IOException e){
            e.printStackTrace();
        }
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }

    public static void main(String[] args){
        List<String> test = new ArrayList<>();
        part1(test);
    }
}
