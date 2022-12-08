import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day7 {

    public static void part1(List<String> list){
        List<Day7Directory> directories = new ArrayList<>();
        List<Day7File> files = new ArrayList<>();
        list = Collections.emptyList();
        try{
            list = Files.readAllLines(Paths.get("src\\resources\\input7.txt"));
        } catch (IOException e){
            e.printStackTrace();
        }
        for(int i = 0; i < list.size(); i++){

        }
    }

    public static void main(String[] args){
        List<String> test = new ArrayList<>();
        part1(test);
    }
}
