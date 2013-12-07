package ua.com.sourceit.baboons;

/**
 * User: alexkorotkikh
 * Date: 11/9/13
 * Time: 11:46 AM
 */
public class Color2 {

    public static final Color2 BLACK = new Color2("чёрный");
    public static final Color2 GREY = new Color2("серый");
    public static final Color2 WHITE = new Color2("белый");

    String russianName;

    private Color2(String russianName) {
        this.russianName = russianName;
    }

    public String getRussianName() {
        return russianName;
    }

}
