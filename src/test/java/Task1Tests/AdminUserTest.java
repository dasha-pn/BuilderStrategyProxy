package Task1Tests;

import org.junit.jupiter.api.Test;

import java.util.List;
import lab11.Task1.AdminUser;
import lab11.Task1.Gender;
import lab11.Task1.User;

import static org.junit.jupiter.api.Assertions.*;

class AdminUserTest {

    @Test
    void adminUserSuperBuilderShouldInheritUserFieldsAndAddPermissions() {
        AdminUser admin = AdminUser.builder()
                .name("Admin")
                .age(30)
                .gender(Gender.MALE)
                .weight(80.0)
                .height(185.0)
                .role("ADMIN")
                .permissions("ALL")
                .build();

        assertEquals("Admin", admin.getName());
        assertEquals(30, admin.getAge());
        assertEquals(Gender.MALE, admin.getGender());
        assertEquals(80.0, admin.getWeight());
        assertEquals(185.0, admin.getHeight());
        assertEquals(List.of("ADMIN"), admin.getRoles());

        assertEquals("ALL", admin.getPermissions());

        assertTrue(admin instanceof User);
    }

    @Test
    void adminUserToStringShouldContainParentInfo() {
        AdminUser admin = AdminUser.builder()
                .name("Root")
                .age(40)
                .gender(Gender.FEMALE)
                .weight(60.0)
                .height(170.0)
                .role("ADMIN")
                .permissions("ROOT")
                .build();

        String s = admin.toString();
        assertTrue(s.contains("Root"));
        assertTrue(s.contains("permissions=ROOT"));
    }
}
