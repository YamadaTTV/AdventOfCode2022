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

        Stack<Character> from = new Stack<>();
        Stack<Character> to = new Stack<>();
        try{
            list = Files.readAllLines(Paths.get("src\\resources\\input5.txt"), StandardCharsets.UTF_8);
        } catch (IOException e){
            e.printStackTrace();
        }
        for (String line : list) {
            if (line.isEmpty() || line.charAt(1) == '1') {
                continue;
            }
            if (!line.startsWith("move")) {
                if (line.charAt(1) != ' ') {
                    stack1.add(stack1.size(), line.charAt(1));
                }
                if (line.charAt(5) != ' ') {
                    stack2.add(stack2.size(), line.charAt(5));
                }
                if (line.charAt(9) != ' ') {
                    stack3.add(stack3.size(), line.charAt(9));
                }
                if (line.charAt(13) != ' ') {
                    stack4.add(stack4.size(), line.charAt(13));
                }
                if (line.charAt(17) != ' ') {
                    stack5.add(stack5.size(), line.charAt(17));
                }
                if (line.charAt(21) != ' ') {
                    stack6.add(stack6.size(), line.charAt(21));
                }
                if (line.charAt(25) != ' ') {
                    stack7.add(stack7.size(), line.charAt(25));
                }
                if (line.charAt(29) != ' ') {
                    stack8.add(stack8.size(), line.charAt(29));
                }
                if (line.charAt(33) != ' ') {
                    stack9.add(stack9.size(), line.charAt(33));
                }
            } else {
                // Movement Control
                String[] movementControl = line.split(" ");
                switch (movementControl[3]) {
                    case "1" -> from = stack1;
                    case "2" -> from = stack2;
                    case "3" -> from = stack3;
                    case "4" -> from = stack4;
                    case "5" -> from = stack5;
                    case "6" -> from = stack6;
                    case "7" -> from = stack7;
                    case "8" -> from = stack8;
                    case "9" -> from = stack9;
                }

                switch (movementControl[5]) {
                    case "1" -> to = stack1;
                    case "2" -> to = stack2;
                    case "3" -> to = stack3;
                    case "4" -> to = stack4;
                    case "5" -> to = stack5;
                    case "6" -> to = stack6;
                    case "7" -> to = stack7;
                    case "8" -> to = stack8;
                    case "9" -> to = stack9;
                }
                System.out.println(Arrays.toString(movementControl));
                for (int j = 0; j < Integer.parseInt(movementControl[1]); j++) {
                    to.add(0, from.get(0));
                    from.remove(0);
                }
            }

        }

        StringBuilder answer = new StringBuilder();
        for(int i = 1; i <= 9; i++){
            if(answer.length() == 9){
                break;
            }
            String it = Integer.toString(i);
            switch (it){
                case "1":
                    answer.append(stack1.get(0));
                case "2":
                    answer.append(stack2.get(0));
                case "3":
                    answer.append(stack3.get(0));
                case "4":
                    answer.append(stack4.get(0));
                case "5":
                    answer.append(stack5.get(0));
                case "6":
                    answer.append(stack6.get(0));
                case "7":
                    answer.append(stack7.get(0));
                case "8":
                    answer.append(stack8.get(0));
                case "9":
                    answer.append(stack9.get(0));
            }
        }
        System.out.println("Answer: The elements on top of each stack is: " + answer);

    }


    public static void main(String[] args) {
        List<String> test = new ArrayList<>();
        /* Part 1 */
        part1(test);
    }
}
