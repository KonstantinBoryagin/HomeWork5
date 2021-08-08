package ru.otus;

import java.util.*;

public class Sorting {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        Sorting sort = new Sorting();

        /** Заполняем значениями листы */
        sort.fillTheList(list);
        sort.fillTheList(list2);
        sort.fillTheList(list3);

        sort.countTheTimeSelectionSorting(list);
        sort.countTheTimeBubbleSorting(list2);
        sort.countTheTimeQuickSorting(list3);

//        System.out.println(list);
//        System.out.println(list2);
//        System.out.println(list3);
    }

    /**
     * Заполняет полученный List случайными значениями от 0 до 90
     * @param list - List чисел
     * @return - отсортированный List чисел
     */
    public List<Integer> fillTheList(List<Integer> list) {
        for (int i = 0; i < 1_000_000; i++) {
            list.add((int) (Math.random() * 90));
        }
        return list;
    }

    /**
     * Метод возвращающий List чисел отсортированных с помощью сортировки "выбором"
     * @param list - List чисел
     * @return - отсортированный List чисел
     */
    public List<Integer> selectionSorting(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {

                if (list.get(i) > list.get(j)) {
                    swap(list, i, j);
                }
            }
        }
        return list;
    }

    /**
     * Метод возвращающий List чисел отсортированных с помощью "пузырьковой" сортировки
     * @param list - List чисел
     * @return - отсортированный List чисел
     */
    public List<Integer> bubbleSorting(List<Integer> list) {
        for (int i = list.size() - 1; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {

                if (list.get(j) > list.get(j+1)) {
                 swap(list, j, j+1);
                }
            }
        }
        return list;
    }

    /**
     * Метод меняет местами числа в передаваемом листе
     * @param list - List чисел
     * @param indexOfLeftNumber - индекс первого элемента
     * @param indexOfRightNumber - индекс второго элемента
     */
    private void swap(List<Integer> list, int indexOfLeftNumber, int indexOfRightNumber) {
        int leftNumer = list.get(indexOfLeftNumber);
        int rightNumer = list.get(indexOfRightNumber);
        list.set(indexOfLeftNumber, rightNumer);
        list.set(indexOfRightNumber, leftNumer);
    }

    private void countTheTimeSelectionSorting(List<Integer> list) {
        Date start = new Date();
        selectionSorting(list);
        Date end = new Date();
        long timeInSec = (end.getTime() - start.getTime()) / 1000;
        long timeInMin = timeInSec / 60;
        System.out.println("Selection Sort - " + timeInSec + " sec or " + timeInMin + " min");
    }

    private void countTheTimeBubbleSorting(List<Integer> list) {
        Date start = new Date();
        bubbleSorting(list);
        Date end = new Date();
        long timeInSec = (end.getTime() - start.getTime()) / 1000;
        long timeInMin = timeInSec / 60;
        System.out.println("Bubble Sort - " + timeInSec + " sec or " + timeInMin + " min");
    }

    private void countTheTimeQuickSorting(List<Integer> list) {
        Date start = new Date();
        Collections.sort(list);
        Date end = new Date();
        long timeInSec = (end.getTime() - start.getTime()) / 1000;
        long timeInMin = timeInSec / 60;
        System.out.println("Quick Sort - " + timeInSec + " sec or " + timeInMin + " min");
    }
}
