import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;

public class Day4 {

    public static void part1(List<String> list){
        list = Collections.emptyList();
        try{
            list = Files.readAllLines(Paths.get("src\\resources\\input4.txt"), StandardCharsets.UTF_8);
        } catch (IOException e){
            e.printStackTrace();
        }
        int containTheOther = 0;
        for(int i = 0; i < list.size(); i++){
            String[] pairSplit = list.get(i).split(",");
            String[] firstPair = pairSplit[0].split("-");
            String[] secondPair = pairSplit[1].split("-");

            int beginFirstInterval = Integer.parseInt(firstPair[0]);
            int endFirstInterval = Integer.parseInt(firstPair[1]);
            int beginLastInterval = Integer.parseInt(secondPair[0]);
            int endLastInterval = Integer.parseInt(secondPair[1]);

            if(DoesContain(beginFirstInterval,endFirstInterval,beginLastInterval,endLastInterval) || DoesContain(beginLastInterval,endLastInterval, beginFirstInterval, endFirstInterval)){
                containTheOther = containTheOther + 1;
            }

        }
        System.out.println("Answer: " + containTheOther);
    }

    public static void part2(List<String> list){
        list = Collections.emptyList();
        try{
            list = Files.readAllLines(Paths.get("src\\resources\\input4.txt"));
        } catch (IOException e){
            e.printStackTrace();
        }
        int overlaps = 0;
        for(int i = 0; i < list.size(); i++){
            String[] pairSplit = list.get(i).split(",");
            String[] firstPair = pairSplit[0].split("-");
            String[] secondPair = pairSplit[1].split("-");

            int beginFirstInterval = Integer.parseInt(firstPair[0]);
            int endFirstInterval = Integer.parseInt(firstPair[1]);
            int beginLastInterval = Integer.parseInt(secondPair[0]);
            int endLastInterval = Integer.parseInt(secondPair[1]);

            if(Overlaps(beginFirstInterval,endFirstInterval,beginLastInterval,endLastInterval) || Overlaps(beginLastInterval,endLastInterval,beginFirstInterval,endFirstInterval)){
                overlaps = overlaps + 1;
            }
        }
        System.out.println("Answer: The number of overlaps is: " + overlaps);
    }


    private static boolean DoesContain(int x1, int x2, int y1, int y2){
        if(y1 <= x1 && x2 <= y2){
            return true;
        }
        return false;
    }

    public static boolean Overlaps(int x1, int x2, int y1, int y2){
        if((x1 >= y1 && x1 <= y2) || (x2 >= y1 && x2 <= y2)){
            return true;
        }
        return false;
    }


    public static void main(String[] args){
        List<String> test = new ArrayList<>();
        /* Part 1 */
        part1(test);
        /* Part 2 */
        part2(test);
    }
}
