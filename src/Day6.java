import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Day6 {

    public static void part1(List<String> list){
        int charProcessed = 0;
        int end = 4;
        list = Collections.emptyList();
        try{
            list = Files.readAllLines(Paths.get("src\\resources\\input6.txt"), StandardCharsets.UTF_8);
        } catch (IOException e){
            e.printStackTrace();
        }
        for(int i = 0; i < list.size(); i++){
            String line = list.get(i);
            // Since we add four slots in the "createWindow" function, we need to remove them to avoid index out of bounds
            for(int j = 0; j < line.length() - end; j++){
                String window = createWindow(line, j, end);
                if(isUnique(window)){
                    // Report the location
                    charProcessed = j + end; // Since we removed 4 index from the counter, we add them back
                    break;
                }
            }

        }
        System.out.println("Answer: The number of characters that needs to be processed are " + charProcessed);
    }

    public static String createWindow(String input, int start, int end){
        StringBuilder res = new StringBuilder();
        for(int i = start; i < start + end; i++){
            res.append(input.charAt(i));
        }
        return res.toString();
    }

    public static boolean isUnique(String input){
        for(int i = 0; i < input.length(); i++){
            for(int j = i + 1; j < input.length(); j++){
                if(input.charAt(i) == input.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args){
        List<String> test = new ArrayList<>();
        part1(test);
    }
}
