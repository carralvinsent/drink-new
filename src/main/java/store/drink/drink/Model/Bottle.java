package store.drink.drink.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Slf4j
public class Bottle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Name must be set")
    @NotEmpty(message = "Name cannot be empty")
    @Pattern(regexp = "[A-Za-z0-9]+", message = "Name can have only letters and digits")
    private String name;

    @Pattern(regexp = "(http(s?):).*\\\\*.(?:jpg|gif|png)",message = "Must be a valid URL to a picture")
    private String bottlePic;

    @Min(value = 1,message = "Volume must be greater than Zero")
    private double volume;

    private Boolean isAlcoholic;

//    @Min(value = 1,message = "Value must be greater than Zero") //if isAlcoholic is true
    private double volumePercent;

    @Min(value = 1,message = "Price must be greater than Zero")
    private int price;

    @NotNull(message = "Supplier name must be set")
    @NotEmpty(message = "Supplier name cannot be empty")
    private String supplier;

    @Min(value = 0,message = "Stock value must be greater than or equal to Zero")
    private int inStock;

}