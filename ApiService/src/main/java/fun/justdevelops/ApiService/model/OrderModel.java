package fun.justdevelops.ApiService.model;

public class OrderModel {
    int id;
    int userId;
    int sum;
    String title;
    String timestamp;

    public OrderModel(int id, int userId, int sum, String title, String timestamp) {
        this.id = id;
        this.userId = userId;
        this.sum = sum;
        this.title = title;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
