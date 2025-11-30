package lab11.Task1;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.Singular;
import java.util.List;

@Builder
@Getter
@ToString
public class Product {

    private String name;
    private double price;
    private String category;

    @Singular
    private List<String> tags;
}
