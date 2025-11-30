package Task1Tests;

import org.junit.jupiter.api.Test;

import lab11.Task1.Product;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void productBuilderShouldSetAllFields() {
        Product product = Product.builder()
                .name("Laptop")
                .price(1500.0)
                .category("Electronics")
                .tag("tech")
                .tag("gaming")
                .build();

        assertEquals("Laptop", product.getName());
        assertEquals(1500.0, product.getPrice());
        assertEquals("Electronics", product.getCategory());
        assertEquals(List.of("tech", "gaming"), product.getTags());
    }

    @Test
    void tagsListShouldBeUnmodifiable() {
        Product product = Product.builder()
                .name("Phone")
                .price(800.0)
                .category("Electronics")
                .tag("mobile")
                .build();

        List<String> tags = product.getTags();
        assertThrows(UnsupportedOperationException.class, () -> tags.add("new-tag"));
    }

    @Test
    void toStringShouldContainKeyFields() {
        Product product = Product.builder()
                .name("Mouse")
                .price(25.0)
                .category("Peripherals")
                .tag("accessory")
                .build();

        String s = product.toString();
        assertTrue(s.contains("Mouse"));
        assertTrue(s.contains("25.0"));
        assertTrue(s.contains("Peripherals"));
    }
}
