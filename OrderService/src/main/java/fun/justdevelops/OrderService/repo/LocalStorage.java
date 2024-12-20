package fun.justdevelops.OrderService.repo;
import fun.justdevelops.OrderService.model.OrderModel;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class LocalStorage implements Repo
{
    private ArrayList<OrderModel> orders;

    public LocalStorage() {
        orders = new ArrayList<>();
        addDemoEntries();
    }

    @Override
    public ArrayList<OrderModel> getUserOrders(int userId) {
        return orders.stream().filter(o -> o.getUserId() == userId).collect(Collectors.toCollection(ArrayList::new));
    }

    private void addDemoEntries() {
        orders.add(new OrderModel(987,2,2345, "Test order 1", "2024-12-05T21:14:38"));
        orders.add(new OrderModel(4356,2,665, "Test order 2", "2024-12-01T17:31:38"));
        orders.add(new OrderModel(345,2,67787, "Test order 3", "2024-12-06T15:124:38"));
        orders.add(new OrderModel(56,3,233, "Test order 4", "2024-11-06T21:15:38"));
        orders.add(new OrderModel(76,3,66787, "Test order 5", "2024-12-03T09:37:38"));
        orders.add(new OrderModel(878,4,9867, "Test order 6", "2024-10-02T11:54:38"));
        orders.add(new OrderModel(456,5,454, "Test order 27", "2024-12-06T16:34:38"));
    }
}
