/**
 * Created by TangBin on 21/10/2016.
 */

public interface Food{
    enum Appetizer implements Food{
        SOLAD, SOOUP, SPRING_ROLLS;
    }

    enum MainCourse implements Food{
        LASAGNE, BURRITO, PAD_THAI, LENTLS, HUMMOUS, VIMDALOO;
    }

    enum Dessert implements Food{
        TIRAMISU, GELATO, BLACK_FOREST_CAKE,FRUIT, CREME_CARMEL;
    }

    enum Coffee implements Food{
        BLACK_COFFEE, DECAF_COFFEE, ESPRESSO, LATTE, CAPPUCCINO, TEA, HERB_TEA;
    }
}
