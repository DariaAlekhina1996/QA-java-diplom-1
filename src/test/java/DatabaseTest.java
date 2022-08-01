import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Database;

public class DatabaseTest {
    private Database database;

    @Before
    public void init() {
        database = new Database();
    }

    @Test
    public void checkAvailableBuns() {
        Assert.assertEquals(3,  database.availableBuns().size());
    }

    @Test
    public void checkAvailableIngredients() {
        Assert.assertEquals(6, database.availableIngredients().size());
    }

}
