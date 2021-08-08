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
    void selectionSort() {
        sort.selectionSort(expected);
        assertEquals(expected, actual);
    }

    @Test
    void bubbleSort() {
        sort.bubbleSort(expected);
        assertEquals(expected, actual);
    }

    @Test
    void insertSort() {
        sort.insertSort(expected);
        assertEquals(expected, actual);
    }
}