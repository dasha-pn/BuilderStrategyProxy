package lab11.Task1;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@ToString(callSuper = true)
public
class AdminUser extends User {
    private String permissions;
}
