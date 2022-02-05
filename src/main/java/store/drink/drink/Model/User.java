package store.drink.drink.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Slf4j
public class User {

    @Id
    @NotNull(message = "Username must be set")
    @NotEmpty(message = "This field cannot be empty")
    private String username;

    @NotNull
    @NotEmpty(message = "This field cannot be empty")
    private String password;

    @Past(message = "Must be a date before today")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
   //Must be after '01/01/1900'
    private LocalDate birthday;

}