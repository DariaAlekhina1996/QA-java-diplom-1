import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    private Bun bun;

    @Before
    public void init() {
        bun = new Bun("a", 110);
    }

    @Test
    public void checkGetName() {
        Assert.assertEquals("a", bun.getName());
    }

    @Test
    public void checkGetPrice() {
        Assert.assertEquals(110, bun.getPrice(), 0);
    }
}
