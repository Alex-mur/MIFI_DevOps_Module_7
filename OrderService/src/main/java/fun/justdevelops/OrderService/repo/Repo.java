package fun.justdevelops.OrderService.repo;
import fun.justdevelops.OrderService.model.OrderModel;
import java.util.ArrayList;

public interface Repo {
    ArrayList<OrderModel> getUserOrders(int userId);
}
