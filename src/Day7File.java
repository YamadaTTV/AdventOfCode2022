
public class Day7File {

    private int size;
    private String name;

    public Day7File(String name, int size){
        this.size = size;
        this.name = name;
    }

    public static Day7File parseFile(String input){
        String[] split = input.split(" ");
        return new Day7File(split[1], Integer.parseInt(split[0]));
    }

    public static boolean isParseable(String input){
        String[] split = input.split(" ");
        return split.length == 2 && isInteger(split[0]);
    }

    private static boolean isInteger(String s) {
        try{
            int num = Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    public int getSize(){
        return size;
    }

}
