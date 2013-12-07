package ua.com.sourceit.baboons;

/**
 * User: alexkorotkikh
 * Date: 11/9/13
 * Time: 11:32 AM
 */
public enum Color {
    BLACK("чёрный"),
    GREY("серый"),
    WHITE("белый");

    String russianName;

    private Color(String russianName) {
        this.russianName = russianName;
    }

    public String getRussianName() {
        return russianName;
    }
}
