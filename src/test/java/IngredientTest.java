import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTest {
    private Ingredient ingredient;
    private final IngredientType ingredientType;
    private final String expected;

    public IngredientTest(IngredientType ingredientType, String expected) {
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

    @Before
    public void init() {
        ingredient = new Ingredient(ingredientType, "ab", 1500);
    }

    @Test
    public void checkGetPrice() {
        Assert.assertEquals(1500, ingredient.getPrice(), 0);
    }

    @Test
    public void checkGetName() {
        Assert.assertEquals("ab", ingredient.getName());
    }

    @Test
    public void checkGetType() {
        Assert.assertEquals(expected, ingredient.getType().name());
    }
}
