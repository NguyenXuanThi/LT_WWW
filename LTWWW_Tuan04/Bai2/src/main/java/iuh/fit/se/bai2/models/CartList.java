package iuh.fit.se.bai2.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartList {
    private Product product;
    private int quantity;
}
