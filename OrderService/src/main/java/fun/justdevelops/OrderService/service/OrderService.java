package fun.justdevelops.OrderService.service;
import fun.justdevelops.OrderService.repo.LocalStorage;
import fun.justdevelops.OrderService.repo.Repo;
import fun.justdevelops.proto.*;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import java.util.List;


@GrpcService
public class OrderService extends OrderServiceGrpc.OrderServiceImplBase {

    Repo repo;

    public OrderService() {
        super();
        repo = new LocalStorage();
    }

    @Override
    public void getUserOrders(UserOrdersRequest request, StreamObserver<UserOrdersResponse> responseObserver) {
        List<Order> userOrders = repo.getUserOrders(request.getUserId()).stream()
                .map(om -> Order.newBuilder()
                        .setUserId(om.getUserId())
                        .setId(om.getId())
                        .setSum(om.getSum())
                        .setTimestamp(om.getTimestamp())
                        .setTitle(om.getTitle())
                        .build())
                .toList();

        responseObserver.onNext(UserOrdersResponse.newBuilder().addAllOrders(userOrders).build());
        responseObserver.onCompleted();
    }
}
