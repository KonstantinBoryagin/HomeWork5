package ru.otus;

import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SortingTest {

    Sorting sort;
    List<Integer> actual;
    List<Integer> expected;

    @BeforeEach
    void init() {
        sort = new Sorting();
        actual = Arrays.asList(1, 2, 3, 4, 5, 6);
        expected = Arrays.asList(3, 2, 6, 1, 5, 4);
    }

    @Test
    void selectionSorting() {
        sort.selectionSorting(expected);
        assertEquals(expected, actual);
    }

    @Test
    void bubbleSorting() {
        sort.bubbleSorting(expected);
        assertEquals(expected, actual);
    }
}