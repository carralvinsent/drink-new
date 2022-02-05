package store.drink.drink.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Slf4j
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Pattern(regexp = "[0-9]+", message = "Position should contain only digits")
    private String position;

    private int price;

    private String name;

    private int quantity;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//////    @JoinColumn(foreignKey = @ForeignKey(name = "item_id"), name = "item_id",nullable = false)
//    @JoinColumn(name="item_id", nullable = false)
//    @JsonIgnore
//    private Orders orders;

}
