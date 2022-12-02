import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day2 {

    public static void part1(List<String> list){
        int total_score = 0;
        list = Collections.emptyList();
        try {
            list = Files.readAllLines(Paths.get("C:\\Users\\liamm\\Documents\\AdventOfCode\\src\\resources\\input2.txt"), StandardCharsets.UTF_8);
        } catch (IOException e){
            e.printStackTrace();
        }
        for(int i = 0; i < list.size(); i++){
            String mine = list.get(i).substring(2);
            String ai = list.get(i).substring(0,1);
            // If you got rock, remember to add 1 point for choosing it
            if(mine.equals("X")){
                total_score = total_score + 1;
                if(ai.equals("A")){ // If there is a draw (AI choosing rock)
                    total_score = total_score + 3;
                } else if(ai.equals("C")){    // If there was a win (AI choosing scissors)
                    total_score = total_score + 6;
                }
                // If there is a loss (AI choosing paper)
            } else if(mine.equals("Y")){    // If you got paper, remember to add 2 points for choosing it
                total_score = total_score + 2;
                if(ai.equals("A")){     // If there is a win (AI choosing rock)
                    total_score = total_score + 6;
                } else if(ai.equals("B")){      // If there is a draw (AI choosing paper)
                    total_score = total_score + 3;
                }
                // If there is a loss (AI choosing scissors)
            } else if(mine.equals("Z")){    // If you got scissors, remember to add 3 points for choosing it
                total_score = total_score + 3;
                if(ai.equals("B")){    // If there is a win (AI choosing paper)
                    total_score = total_score + 6;
                } else if(ai.equals("C")){    // If there is a draw (AI choosing scissors)
                    total_score = total_score + 3;
                }
                // If there is a loss (AI choosing rock)
            }
        }
        System.out.println("Answer: My total score is " + total_score);
    }

    public static void main(String[] args){
        List<String> test = new ArrayList<>();
        /* Part 1 */
        part1(test);
    }
}
