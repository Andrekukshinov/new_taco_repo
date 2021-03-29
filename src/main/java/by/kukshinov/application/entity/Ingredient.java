package by.kukshinov.application.entity;


import by.kukshinov.application.entity.enums.Type;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
public class Ingredient {
    private final String id;
    private final String name;
    private final Type type;
}
