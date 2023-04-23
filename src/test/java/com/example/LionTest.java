package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionTest {

    private final String lionSex;

    private final boolean hasMane;


    public LionTest(String lionSex, boolean hasMane) {
        this.lionSex = lionSex;
        this.hasMane = hasMane;
    }
    @Mock
    Feline feline;


    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Parameterized.Parameters
    public static Object[][] setData() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void checkLionSexSuccess() throws Exception {
        Lion lion = new Lion(lionSex, feline);
        boolean expectedResult = hasMane;
        boolean actualResult = lion.hasMane;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void checkLionSexUndefinedThrowsExceptionSuccess() {
        try {
            new Lion("Средний род", feline);
            fail("Expected MyException to be thrown");
        } catch (Exception exception) {
        }
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
