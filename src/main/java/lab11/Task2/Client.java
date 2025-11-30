package lab11.Task2;

import java.util.concurrent.atomic.AtomicInteger;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Client {
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(0);

    private final int id;
    private final String name;
    private final int age;
    private final Sex sex;
    private final String email;

    public Client(String name, int age, Sex sex, String email) {
        this.id = ID_GENERATOR.getAndIncrement();
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.email = email;
    }
}
