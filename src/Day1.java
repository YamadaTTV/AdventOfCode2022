import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day1 {

    public static void part1(List<String> list) throws IOException {
        int max_calories = 0;
        int current_calories = 0;
        list = Collections.emptyList();
        try {
            list = Files.readAllLines(Paths.get("C:\\Users\\liamm\\Documents\\AdventOfCode\\src\\resources\\input.txt"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for(int i = 0; i < list.size(); i++){
            if(!list.get(i).equals("")){
                current_calories = current_calories + Integer.parseInt(list.get(i));
                if(max_calories < current_calories){
                    max_calories = current_calories;
                }
            } else if(list.get(i).equals("")){
                current_calories = 0;
            }
        }
        System.out.println("Answer: " + max_calories);
    }

    public static void part2(List<String> list){
        int total_calories = 0;
        int current_calories = 0;
        int top1 = 0;
        int top2 = 0;
        int top3 = 0;
        list = Collections.emptyList();
        try {
            list = Files.readAllLines(Paths.get("C:\\Users\\liamm\\Documents\\AdventOfCode\\src\\resources\\input.txt"), StandardCharsets.UTF_8);
        } catch (IOException e){
            e.printStackTrace();
        }
        for(int i = 0; i < list.size(); i++){
            if(!list.get(i).equals("")){
                current_calories = current_calories + Integer.parseInt(list.get(i));
                if(current_calories > top1 && current_calories > top2 && current_calories > top3){
                    top3 = top2;
                    top2 = top1;
                    top1 = current_calories;
                } else if(current_calories < top1 && current_calories > top2 && current_calories > top3){
                    top3 = top2;
                    top2 = current_calories;
                } else if(current_calories < top1 && current_calories < top2 && current_calories > top3){
                    top3 = current_calories;
                }
            } else if(list.get(i).equals("")){
                current_calories = 0;
            }
        }
        total_calories = top1 + top2 + top3;
        System.out.println("The top three elves are in total carrying: " + total_calories);
    }

    public static void main(String[] args) throws IOException {
        List<String> test = new ArrayList<String>();
        /* Part 1 */
        part1(test);
        /* Part 2 */
        part2(test);
    }
}
