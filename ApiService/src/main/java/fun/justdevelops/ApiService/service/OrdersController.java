package fun.justdevelops.ApiService.service;

import fun.justdevelops.ApiService.model.OrderModel;
import fun.justdevelops.proto.OrderServiceGrpc;
import fun.justdevelops.proto.UserOrdersRequest;
import fun.justdevelops.proto.UserOrdersResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class OrdersController {

    @GetMapping(value = "/user-orders/{userId}", produces = "application/json")
    public static ArrayList<OrderModel> getUserOrders(@PathVariable int userId) {
        ArrayList<OrderModel> result = new ArrayList<>();
        try {
            ManagedChannel channel = ManagedChannelBuilder.forAddress("orderservice", 22285).usePlaintext().build();
            OrderServiceGrpc.OrderServiceBlockingStub stub = OrderServiceGrpc.newBlockingStub(channel);
            UserOrdersResponse response = stub.getUserOrders(UserOrdersRequest.newBuilder().setUserId(userId).build());
            response.getOrdersList().forEach(order -> result.add(
                    new OrderModel(
                        order.getId(),
                        order.getUserId(),
                        order.getSum(),
                        order.getTitle(),
                        order.getTimestamp()
                    )
            ));

        } catch (Exception e) {}

        return result;
    }
}
