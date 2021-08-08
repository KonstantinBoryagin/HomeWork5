package ru.otus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SortTest {

    Sort sort;
    List<Integer> expected;
    List<Integer> actual;


    @BeforeEach
    void init() {
        sort = new Sort(1);
        expected = Arrays.asList(3, 4, 1, 2, 6, 5);
        actual = Arrays.asList(1, 2, 3, 4, 5, 6);
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