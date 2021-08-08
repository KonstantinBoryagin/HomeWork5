package ru.otus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Sort {
    /** Поле - ArrayList целых чисел */
    private ArrayList<Integer> list;

    /**
     * Конструктор, создает и заполняет случайными числами (0-90) ArrayList
     * @param size - размер ArrayList
     */
    public Sort(int size) {
        this.list = new ArrayList<Integer>();
        fillTheList(size);
    }


    /**
     * Очищает и заново заполняет ArrayList числами
     */
    public void resetList () {
        int size = list.size();
        list.clear();
        fillTheList(size);
    }

    /**
     * Заполняет ArrayList случайными значениями от 0 до 90
     * @param size - размер ArrayList
     * @return отсортированный ArrayList чисел
     */
    private List<Integer> fillTheList(int size) {
        for (int i = 0; i < size; i++) {
            list.add((int) (Math.random() * 90));
        }
        return list;
    }

    @Override
    public String toString() {
        return "{" + list + '}';
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
     * Метод реализации сортировки "выбором"
     * @return - отсортированный ArrayList чисел
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
     * Метод сортирует ArrayList чисел "пузырьковой" сортировки
     * @return - отсортированный ArrayListList чисел
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

    /**
     * Метод реализует ArrayList чисел сортировку "вставкой"
     * @return отсортированный ArrayList чисел
     */
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
     * Выводит в консоль время выполнения сортировки "выбором"
     */
    public void countTheTimeSelectionSort() {
        Date start = new Date();
        selectionSort(list);
        Date end = new Date();
        long timeInSec = (end.getTime() - start.getTime()) / 1000;
        System.out.println("Selection Sort for " + list.size() + " numbers - " + timeInSec + " sec");
    }

    /**
     * Выводит в консоль время выполнения "пузырьковой" сортировки
     */
    public void countTheTimeBubbleSort() {
        Date start = new Date();
        bubbleSort(list);
        Date end = new Date();
        long timeInSec = (end.getTime() - start.getTime()) / 1000;
        System.out.println("Bubble Sort for " + list.size() + " numbers - " + timeInSec + " sec");
    }

    /**
     * Выводит в консоль время выполнения сортировки "вставкой"
     */
    public void countTheTimeInsertSort() {
        Date start = new Date();
        insertSort(list);
        Date end = new Date();
        long timeInSec = (end.getTime() - start.getTime()) / 1000;
        System.out.println("Insert Sort for " + list.size() + " numbers - " + timeInSec + " sec");
    }

    /**
     * Выводит в консоль время выполнения быстрой сортировки
     */
    public void countTheTimeQuickSort() {
        Date start = new Date();
        Collections.sort(list);
        Date end = new Date();
        long timeInSec = (end.getTime() - start.getTime()) / 1000;
        System.out.println("Quick Sort for " + list.size() + " numbers - " + timeInSec + " sec");
    }
}
