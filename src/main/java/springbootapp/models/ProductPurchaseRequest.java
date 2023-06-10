package springbootapp.models;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ProductPurchaseRequest {
    private String orderId;
    private Timestamp dateTime;
    private Boolean isDeleted;
    private Integer paymentType;
    private Integer productId;
    private Integer userId;
}
