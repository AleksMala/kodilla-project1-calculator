package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BigmacTestSuite {


    @Test
    public void testBigmac() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .roll("roll without sesame")
                .burgers(2)
                .sauce(Sauce.AVAILABLE_SAUCE.get(0))
                .ingredient("lettuce")
                .ingredient("tomato")
                .ingredient("pickle")
                .ingredient("beetroot")
                .build();
        System.out.println(bigmac);
        //When
        //Then
        Assert.assertEquals(Roll.ROLL_WITHOUT_SESAME, bigmac.getRoll());
        Assert.assertEquals(2, bigmac.getIngredients().size());
        Assert.assertTrue(Ingredients.PICKLE.equals("pickle"));
        Assert.assertFalse(Ingredients.LIST_OF_INGREDIENTS.contains("tomato"));
        Assert.assertFalse(Sauce.BARBECUE_DRESSING.equals(bigmac.getSauce()));
        Assert.assertNotNull(bigmac);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testThrowExceptionForSauce() {
        //Given
        thrown.expect(NullPointerException.class);
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .roll("roll without sesame")
                .burgers(2)
                .sauce(null)
                .ingredient("lettuce")
                .ingredient("tomato")
                .ingredient("pickle")
                .ingredient("beetroot")
                .build();
        System.out.println(bigmac);
        //When
        //Then
    }
}
