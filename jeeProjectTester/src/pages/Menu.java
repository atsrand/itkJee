package pages;

public class Menu extends Pages {

    public FormPage clickAdd() {
        element("menuAdd").click();
        return new FormPage();
    }

    public TreePage clickTree() {
        element("menuTree").click();
        return new TreePage();
    }

}
