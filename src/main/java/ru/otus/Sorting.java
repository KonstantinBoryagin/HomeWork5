package ru.otus;

import java.util.*;

public class Sorting {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        ArrayList<Integer> list4 = new ArrayList<>();
        Sorting sort = new Sorting();

        /** Заполняем значениями листы */
        sort.fillTheList(list, 1_000_00);
        sort.fillTheList(list2, 1_000_00);
        sort.fillTheList(list3, 1_000_00);
        sort.fillTheList(list4, 1_000_00);

        /** Сортируем листы с получением времени выполнения сортировок */
        sort.countTheTimeSelectionSort(list);
        sort.countTheTimeBubbleSort(list2);
        sort.countTheTimeInsertSort(list3);
        sort.countTheTimeQuickSort(list4);

//        System.out.println(list);
//        System.out.println(list2);
//        System.out.println(list3);
    }

    /**
     * Заполняет полученный List случайными значениями от 0 до 90
     * @param list - List чисел
     * @param size - размер List
     * @return отсортированный List чисел
     */
    private List<Integer> fillTheList(List<Integer> list, int size) {
        for (int i = 0; i < size; i++) {
            list.add((int) (Math.random() * 90));
        }
        return list;
    }

    /**
     * Метод возвращающий List чисел отсортированных с помощью сортировки "выбором"
     *
     * @param list - List чисел
     * @return - отсортированный List чисел
     */
    List<Integer> selectionSort(List<Integer> list) {
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
    List<Integer> bubbleSort(List<Integer> list) {
        for (int i = list.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {

                if (list.get(j) > list.get(j + 1)) {
                    swap(list, j, j + 1);
                }
            }
        }
        return list;
    }

    List<Integer> insertSort(List<Integer> list){
        int in, out;
        for (out = 1; out < list.size() ; out++) {
            int temp = list.get(out);
            in = out;

            while (in > 0 && list.get(in - 1) >= temp) {
                list.set(in, list.get(in - 1));
                --in;
            }
            list.set(in, temp);
        }
        return list;
    }

    /**
     * Метод меняет местами числа в передаваемом листе
     * @param list               - List чисел
     * @param indexOfLeftNumber  - индекс первого элемента
     * @param indexOfRightNumber - индекс второго элемента
     */
    private void swap(List<Integer> list, int indexOfLeftNumber, int indexOfRightNumber) {
        int leftNumber = list.get(indexOfLeftNumber);
        int rightNumber = list.get(indexOfRightNumber);
        list.set(indexOfLeftNumber, rightNumber);
        list.set(indexOfRightNumber, leftNumber);
    }

    /**
     * Выводит в консоль время выполнения сортировки "выбором"
     * @param list - List чисел
     */
    private void countTheTimeSelectionSort(List<Integer> list) {
        Date start = new Date();
        selectionSort(list);
        Date end = new Date();
        long timeInSec = (end.getTime() - start.getTime()) / 1000;
        System.out.println("Selection Sort - " + timeInSec + " sec");
    }

    /**
     * Выводит в консоль время выполнения "пузырьковой" сортировки
     * @param list - List чисел
     */
    private void countTheTimeBubbleSort(List<Integer> list) {
        Date start = new Date();
        bubbleSort(list);
        Date end = new Date();
        long timeInSec = (end.getTime() - start.getTime()) / 1000;
        System.out.println("Bubble Sort - " + timeInSec + " sec");
    }

    /**
     * Выводит в консоль время выполнения сортировки "вставкой"
     * @param list - List чисел
     */
    private void countTheTimeInsertSort(List<Integer> list) {
        Date start = new Date();
        insertSort(list);
        Date end = new Date();
        long timeInSec = (end.getTime() - start.getTime()) / 1000;
        System.out.println("Insert Sort - " + timeInSec + " sec");
    }

    /**
     * Выводит в консоль время выполнения быстрой сортировки
     * @param list - List чисел
     */
    private void countTheTimeQuickSort(List<Integer> list) {
        Date start = new Date();
        Collections.sort(list);
        Date end = new Date();
        long timeInSec = (end.getTime() - start.getTime()) / 1000;
        System.out.println("Quick Sort - " + timeInSec + " sec");
    }
}
