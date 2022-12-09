import java.util.ArrayList;
import java.util.List;

public class Day7Directory {

    private String name;
    private Day7Directory parent;
    private List<Day7File> files;
    private List<Day7Directory> children;

    public Day7Directory(String name, Day7Directory parent){
        this.name = name;
        this.parent = parent;
        files = new ArrayList<>();
        children = new ArrayList<>();
        if(parent != null){
            parent.children.add(this);
        }
    }

    public void addFile(Day7File file){
        files.add(file);
    }

    public int size(){
        int size = 0;
        for(Day7File file: files){
            size += file.getSize();
        }
        for(Day7Directory child: children){
            size += child.size();
        }
        return size;
    }

    public List<Day7Directory> getChildren(){
        return children.stream().toList();
    }

    public Day7Directory getParent() { return parent; }

    public String getName() {
        return name;
    }

    public static Day7Directory parseDir(String input, Day7Directory parent){
        String[] split = input.split(" ");
        return new Day7Directory(split[1], parent);
    }

    public static boolean isParseable(String input){
        return input.startsWith("dir");
    }

}
