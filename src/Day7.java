import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Day7 {

    public static void part1(){
        List<String> list = Collections.emptyList();
        try{
            list = Files.readAllLines(Paths.get("src\\resources\\input7.txt"));
        } catch (IOException e){
            e.printStackTrace();
        }
        String[] rows = list.toArray(new String[0]);
        Day7Directory root = buildFileSystem(rows);
        List<Day7Directory> dirs = findAllDirectories(root);
        int sum = 0;
        for(Day7Directory dir: dirs){
            int size = dir.size();
            if(size <= 100000){
                sum += size;
            }
        }
        System.out.println("Answer: The sum of the total sizes is " + sum);
    }

    public static void part2(){
        List<String> list = Collections.emptyList();
        try {
            list = Files.readAllLines(Paths.get("src\\resources\\input7.txt"));
        } catch (IOException e){
            e.printStackTrace();
        }
        String[] rows = list.toArray(new String[0]);
        Day7Directory root = buildFileSystem(rows);
        List<Day7Directory> dirs = findAllDirectories(root);
        int totalSpace = 70000000;
        int currentSpace = totalSpace - root.size();
        int requiredSpace = 30000000 - currentSpace;
        int res = 0;
        dirs.sort(Comparator.comparingInt(Day7Directory::size));
        for(Day7Directory dir: dirs){
            if(dir.size() >= requiredSpace){
                res = dir.size();
                break;
            }
        }
        System.out.println("Answer: the total size is " + res);
    }

    public static void processDirectoryLine(Day7Directory currentDir, String input){
        Day7Directory.parseDir(input,currentDir);
    }

    public static void processFileLine(Day7Directory currentDir, String input){
        Day7File file = Day7File.parseFile(input);
        currentDir.addFile(file);
    }

    public static Day7Directory processChangeDirectory(Day7Directory currentDir, String input){
        String childName = input.split(" ")[2];
        switch (childName) {
            case ".." -> {
                return currentDir.getParent();
            }
            case "/" -> {
                return currentDir;
            }
            default -> {
                for (Day7Directory child : currentDir.getChildren()) {
                    if (child.getName().equals(childName)) {
                        return child;
                    }
                }
            }
        }
        return null;
    }

    public static Day7Directory buildFileSystem(String[] rows){
        Day7Directory root = new Day7Directory("/", null);
        Day7Directory currentDir = root;
        for(String input: rows){
            if(Day7File.isParseable(input)){
                processFileLine(currentDir, input);
            } else if(Day7Directory.isParseable(input)){
                processDirectoryLine(currentDir, input);
            } else if(input.startsWith("$ cd")){
                currentDir = processChangeDirectory(currentDir, input);
            }
        }
        return root;
    }

    public static List<Day7Directory> findAllDirectories(Day7Directory toSearch){
        List<Day7Directory> all = new ArrayList<>();
        all.add(toSearch);
        for(Day7Directory child: toSearch.getChildren()){
            all.addAll(all.size(), findAllDirectories(child));
        }
        return all;
    }

    public static void main(String[] args){
        part1();
        part2();
    }
}
