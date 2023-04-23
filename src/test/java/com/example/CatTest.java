package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void checkCatConstructorSuccess() {
        Cat cat = new Cat(feline);
        Assert.assertTrue(cat.predator == feline);
    }

    @Test
    public void getCatFoodSuccess() throws Exception {
        Cat cat = new Cat(feline);
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expectedResult);
        List<String> actualResult = cat.getFood();
        assertEquals("Должен быть список: Животные, Птицы, Рыба", expectedResult, actualResult);
    }

    @Test
    public void getCatSoundSuccess() {
        Cat cat = new Cat(feline);
        String expectedResult = "Мяу";
        String actualResult = cat.getSound();
        assertEquals("Должно быть Мяу", expectedResult, actualResult);
    }
}
