package pages;

public class Menu extends Pages {

    public FormPage clickAdd() {
        element("menuAdd").click();
        return new FormPage();
    }

}
