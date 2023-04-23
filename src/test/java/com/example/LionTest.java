package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    private final String lionSex = "Самец";
   @Mock
   Feline feline;

    @Test(expected = Exception.class)
    public void checkLionSexUndefinedThrowsExceptionSuccess() throws Exception {
        new Lion("Средний род", feline);
    }
    @Test
    public void checkLionGetKittensSuccess() throws Exception {
        Lion lion = new Lion(lionSex, feline);
        int expectedResult = 1;
        Mockito.when(feline.getKittens()).thenReturn(expectedResult);
        int actualResult = lion.getKittens();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void checkLionDoesHaveManeSuccess() throws Exception {
        Lion lion = new Lion(lionSex, feline);
        boolean actualResult = lion.doesHaveMane();
        assertEquals(lion.hasMane, actualResult);
    }

    @Test
    public void checkLionGetFoodSuccess() throws Exception {
        Lion lion = new Lion(lionSex, feline);
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedResult);
        List<String> actualResult = lion.getFood();
        assertEquals(expectedResult, actualResult);
    }
}
