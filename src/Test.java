public class Test {

    public static void main(String[] args) {
        GameFrame test = new GameFrame(1920, 1080, "Testing");
        test.add(new GamePanel(test.getWidth(), test.getHeight()));


    }

}
