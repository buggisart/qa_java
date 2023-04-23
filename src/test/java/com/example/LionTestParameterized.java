package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class LionTestParameterized {
    private final String lionSex;

    private final boolean hasMane;


    public LionTestParameterized(String lionSex, boolean hasMane) {
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
}
