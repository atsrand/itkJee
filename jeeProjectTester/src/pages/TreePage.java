package pages;

public class TreePage extends Pages {

    public String getContents() {
        return element("tree").getText();
    }

}
