public class Day7File {

    private int size;
    private String name;

    public Day7File(int size, String name){
        this.size = size;
        this.name = name;
    }

    public Day7File(String name){
        this.size = 0;
        this.name = name;
    }

    public int getSize(){
        return size;
    }

    public String getName(){
        return name;
    }
}
