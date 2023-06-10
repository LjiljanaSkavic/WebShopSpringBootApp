package springbootapp.models;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ProductPurchase {
    private Integer id;
    private String orderId;
    private Timestamp dateTime;
    private Boolean isDeleted;
    private Integer paymentType;
    private Product product;
}
