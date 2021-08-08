package ru.otus;

public class Main {

    public static void main(String[] args) {
        Sort sort = new Sort(1_000_00);

        sort.countTheTimeSelectionSort();
        sort.resetList();

        sort.countTheTimeBubbleSort();
        sort.resetList();

        sort.countTheTimeInsertSort();
        sort.resetList();

        sort.countTheTimeQuickSort();
    }
}
