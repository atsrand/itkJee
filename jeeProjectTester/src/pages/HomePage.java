package pages;

public class HomePage extends Pages {

    public HomePage() {
        getDriver().get("http://localhost:8080/jeeProject/");
    }

    public String getTitle() {
        return getDriver().getTitle();
    }

    public void selectAdd() {
        // TODO Auto-generated method stub

    }

    public Menu menu() {
        return new Menu();
    }

}
