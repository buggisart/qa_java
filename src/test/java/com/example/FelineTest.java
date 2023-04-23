package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Mock
    Animal animal;
    Feline feline = new Feline(animal);
    @Spy
    Feline felineSpy = new Feline(animal);
    @Test
    public void felineEatMeatSuccess() throws Exception {
        Feline feline = new Feline(animal);
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(animal.getFood("Хищник")).thenReturn(expectedResult);
        List<String> actualResult = feline.eatMeat();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void felineGetFamilySuccess() {
        String expectedResult = "Кошачьи";

        String actualResult = feline.getFamily();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void felineGetKittensNoParamsSuccess() {
        int expectedResult = 1;
        Mockito.when(felineSpy.getKittens(1)).thenReturn(expectedResult);
        int actualResult = felineSpy.getKittens();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void felineGetKittensWithParamSuccess() {
        int expectedResult = 3;
        int actualResult = feline.getKittens(expectedResult);
        assertEquals(expectedResult, actualResult);
    }
}
