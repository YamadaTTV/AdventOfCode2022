import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Day5 {


    public static void part1(List<String> list){
        list = Collections.emptyList();
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        Stack<Character> stack3 = new Stack<>();
        Stack<Character> stack4 = new Stack<>();
        Stack<Character> stack5 = new Stack<>();
        Stack<Character> stack6 = new Stack<>();
        Stack<Character> stack7 = new Stack<>();
        Stack<Character> stack8 = new Stack<>();
        Stack<Character> stack9 = new Stack<>();
        try{
            list = Files.readAllLines(Paths.get("src\\resources\\input5.txt"), StandardCharsets.UTF_8);
        } catch (IOException e){
            e.printStackTrace();
        }
        for(int i = 0; i < list.size(); i++){
            String line = list.get(i);
            if(line.isEmpty() || line.charAt(1) == '1'){
                continue;
            }
            if(!line.startsWith("move")){
                if(line.charAt(1) != ' '){
                    stack1.add(stack1.size(), line.charAt(1));
                }
                if(line.charAt(5) != ' '){
                    stack2.add(stack2.size(), line.charAt(5));
                }
                if(line.charAt(9) != ' '){
                    stack3.add(stack3.size(), line.charAt(9));
                }
                if(line.charAt(13) != ' '){
                    stack4.add(stack4.size(), line.charAt(13));
                }
                if(line.charAt(17) != ' '){
                    stack5.add(stack5.size(), line.charAt(17));
                }
                if(line.charAt(21) != ' '){
                    stack6.add(stack6.size(), line.charAt(21));
                }
                if(line.charAt(25) != ' '){
                    stack7.add(stack7.size(), line.charAt(25));
                }
                if(line.charAt(29) != ' '){
                    stack8.add(stack8.size(), line.charAt(29));
                }
                if(line.charAt(33) != ' '){
                    stack9.add(stack9.size(), line.charAt(33));
                }
            } else {
                // Movement Control
                String[] movementControl = line.split(" ");
                System.out.println(Arrays.toString(movementControl));
                for(int j = 1; i < Integer.parseInt(movementControl[1]); i++){

                }
            }

        }
        System.out.println(stack1);
        System.out.println(stack2);
        System.out.println(stack3);
        System.out.println(stack4);
        System.out.println(stack5);
        System.out.println(stack6);
        System.out.println(stack7);
        System.out.println(stack8);
        System.out.println(stack9);
    }


    public static void main(String[] args) throws FileNotFoundException {
        List<String> test = new ArrayList<>();
        part1(test);
    }
}
