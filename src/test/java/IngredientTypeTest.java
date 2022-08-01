import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final IngredientType ingredientType;
    private final String expected;

    public IngredientTypeTest(IngredientType ingredientType, String expected) {
        this.ingredientType = ingredientType;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[] getIngredientType() {
        return new Object[][]{
                {IngredientType.SAUCE, "SAUCE"},
                {IngredientType.FILLING, "FILLING"}
        };
    }

    @Test
    public void checkIngredientType() {
        Assert.assertEquals(expected, ingredientType.name());
    }
}
