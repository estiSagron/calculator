package calculator;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserInput {

    private Integer x;
    private Integer y;
    private OperationType operationType;



}
