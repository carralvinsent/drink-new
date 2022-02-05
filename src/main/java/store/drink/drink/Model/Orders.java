package store.drink.drink.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Slf4j
//@NamedEntityGraph(name = "Order.orderItems",
//        attributeNodes = @NamedAttributeNode("orderItems")
//)
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @Min(value = 1,message = "Value must be greater than Zero")
    private String totalPrice;

//    @OneToMany(mappedBy = "orders", fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//    private List<OrderItem> orderItems=new ArrayList<>();

}