import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;


@RunWith(MockitoJUnitRunner.Silent.class)
public class BurgerTest {
    private Burger burger;
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredientSecond;

    @Before
    public void init() {
        burger = new Burger();
    }

    @Test
    public void checkSetBuns() {
        burger.setBuns(bun);
        Assert.assertNotNull(burger.bun);
    }

    @Test
    public void checkAddIngredient() {
        burger.addIngredient(ingredient);
        Assert.assertEquals(false, burger.ingredients.isEmpty());
    }

    @Test
    public void checkRemoveIngredientByIndex() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(burger.ingredients.indexOf(ingredient));
        Assert.assertEquals(true, burger.ingredients.isEmpty());
    }

    @Test
    public void checkMoveIngredient() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientSecond);

        Mockito.when(ingredient.getName()).thenReturn("firstIngredient");
        Mockito.when(ingredientSecond.getName()).thenReturn("secondIngredient");

        burger.moveIngredient(0, 1);
        Assert.assertEquals("firstIngredient", burger.ingredients.get(1).getName());
    }

    @Test
    public void checkGetPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientSecond);

        Mockito.when(bun.getPrice()).thenReturn((float) 100.20);
        Mockito.when(ingredient.getPrice()).thenReturn((float) 200.30);
        Mockito.when(ingredientSecond.getPrice()).thenReturn((float) 215.33);

        Assert.assertEquals((float) 616.03, burger.getPrice(), 0);
    }

    @Test
    public void checkGetReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientSecond);

        Mockito.when(bun.getName()).thenReturn("Bylka");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("List");
        Mockito.when(ingredientSecond.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredientSecond.getName()).thenReturn("Spicy");

        Mockito.when(bun.getPrice()).thenReturn((float) 100.20);
        Mockito.when(ingredient.getPrice()).thenReturn((float) 200.30);
        Mockito.when(ingredientSecond.getPrice()).thenReturn((float) 215.33);

        StringBuilder expected = new StringBuilder(String.format("(==== Bylka ====)%n= filling List =%n= sauce Spicy =%n(==== Bylka ====)%n%nPrice: 616,030029%n"));
        Assert.assertEquals(expected.toString(), burger.getReceipt());
    }
}
