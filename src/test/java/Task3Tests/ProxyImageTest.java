package Task3Tests;

import lab11.Task3.MyImage;
import lab11.Task3.ProxyImage;
import lab11.Task3.RealImage;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class ProxyImageTest {
    private RealImage getRealImageFromProxy(ProxyImage proxy) throws Exception {
        Field f = ProxyImage.class.getDeclaredField("realImage");
        f.setAccessible(true);
        return (RealImage) f.get(proxy);
    }

    @Test
    void proxyShouldNotCreateRealImageInConstructor() throws Exception {
        ProxyImage proxy = new ProxyImage("test.png");

        RealImage real = getRealImageFromProxy(proxy);

        assertNull(real, "RealImage should not be created in ProxyImage constructor");
    }

    @Test
    void proxyShouldCreateRealImageOnFirstDisplayCall() throws Exception {
        ProxyImage proxy = new ProxyImage("test.png");

        assertNull(getRealImageFromProxy(proxy),
                "Before display() realImage must be null");

        proxy.display();

        RealImage realAfter = getRealImageFromProxy(proxy);
        assertNotNull(realAfter,
                "After first display() realImage must be created");
    }

    @Test
    void proxyShouldReuseSameRealImageOnSubsequentDisplayCalls() throws Exception {
        ProxyImage proxy = new ProxyImage("test.png");

        proxy.display();
        RealImage firstInstance = getRealImageFromProxy(proxy);

        proxy.display();
        RealImage secondInstance = getRealImageFromProxy(proxy);

        assertSame(firstInstance, secondInstance,
                "ProxyImage must not create a new RealImage on subsequent display() calls");
    }

    @Test
    void proxyImplementsMyImageInterface() {
        MyImage img = new ProxyImage("another.png");
        assertNotNull(img);
        assertDoesNotThrow(img::display);
    }
}
