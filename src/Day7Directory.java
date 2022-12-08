import java.util.ArrayList;
import java.util.List;

public class Day7Directory {

    private String name;
    private List<Day7File> files;
    private List<Day7Directory> childrenDir;
    private Day7Directory root;

    public Day7Directory(String name, Day7Directory root){
        this.name = name;
        files = new ArrayList<>();
        if(root != null){
            root.childrenDir.add(root);
        }
    }

    public String getName() {
        return name;
    }

    public Day7Directory getRoot() {
        return root;
    }
}
