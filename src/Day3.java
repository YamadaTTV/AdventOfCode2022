import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day3 {

    public static void part1(List<String> list){
        list = Collections.emptyList();
        try{
            list = Files.readAllLines(Paths.get("C:\\Users\\liamm\\Documents\\AdventOfCode\\src\\resources\\input3.txt"), StandardCharsets.UTF_8);
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(list);
        for(int i = 0; i < list.size(); i++){
            String firstCompartment = list.get(i).substring(0,13);
            String secondCompartment = list.get(i).substring(13);
            for(int j = 0; j < firstCompartment.length(); j++){
                for(int k = 0; k < secondCompartment.length(); k++){
                    if(firstCompartment.charAt(j) == secondCompartment.charAt(k)){
                        // Both compartments share an item type
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        List<String> test = new ArrayList<>();
        part1(test);
    }
}
