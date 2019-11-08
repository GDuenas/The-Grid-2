import java.util.ArrayList;

public class Testing {

    static ArrayList<Integer> test = new ArrayList<>();

    public static void display(){
        for (int i = 0; i < test.size(); i++){
            System.out.print(test.get(i) + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        test.add(0);
        display();
        test.add(0, 1);
        display();
        test.add(0, 2);
        display();
    }

}
