package Chapter10_Interface.No4_application_interface;
import java.util.ArrayList;

public class Shelf {
    protected ArrayList<String> shelf;

    public Shelf() {
        shelf = new ArrayList<String>();
    }

    public int getCount() {
        return shelf.size();
    }
}
