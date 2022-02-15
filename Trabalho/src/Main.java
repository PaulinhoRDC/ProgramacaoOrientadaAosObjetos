public class Main {

    public static void main(String[] args) throws Exception {
        Global g = new Global();
        Parser.parse(g);
        Menu.menu(g);
    }
}