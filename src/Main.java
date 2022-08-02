import model.warehouse.Warehouse;
import model.warehouse.service.Menu;

public class Main {
    public static void main(String[] args) throws Exception {
        Warehouse.run();
        Menu.start();
    }
}
