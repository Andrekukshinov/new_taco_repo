package by.kukshinov.application.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Taco {

    @NotNull
    @Size(min = 3, message = "min mane length must be more than 3 symbols!")
    private String name;
    @Size(min = 1)
    private List<String> ingredients;

}
