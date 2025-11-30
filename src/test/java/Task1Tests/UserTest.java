package Task1Tests;

import org.junit.jupiter.api.Test;

import lab11.Task1.User;
import lab11.Task1.Gender;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void userSuperBuilderShouldSetAllFields() {
        User user = User.builder()
                .name("Daryna")
                .age(20)
                .gender(Gender.FEMALE)
                .weight(52.5)
                .height(170.0)
                .role("USER")
                .role("STUDENT")
                .build();

        assertEquals("Daryna", user.getName());
        assertEquals(20, user.getAge());
        assertEquals(Gender.FEMALE, user.getGender());
        assertEquals(52.5, user.getWeight());
        assertEquals(170.0, user.getHeight());
        assertEquals(List.of("USER", "STUDENT"), user.getRoles());
    }

    @Test
    void rolesListShouldBeUnmodifiable() {
        User user = User.builder()
                .name("Test")
                .age(18)
                .gender(Gender.MALE)
                .role("ONE")
                .role("TWO")
                .build();

        List<String> roles = user.getRoles();
        assertThrows(UnsupportedOperationException.class, () -> roles.add("THREE"));
    }

    @Test
    void toStringShouldContainKeyFields() {
        User user = User.builder()
                .name("Daryna")
                .age(20)
                .gender(Gender.FEMALE)
                .weight(50.0)
                .height(165.0)
                .role("USER")
                .build();

        String s = user.toString();
        assertTrue(s.contains("Daryna"));
        assertTrue(s.contains("FEMALE"));
        assertTrue(s.contains("age=20"));
    }
}
