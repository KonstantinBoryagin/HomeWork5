package ru.otus;

import java.lang.reflect.Array;
import java.util.*;

public class Sorting {


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        Sorting sort = new Sorting();

        sort.fillTheList(list);
        sort.fillTheList(list2);
        sort.fillTheList(list3);

        Date start = new Date();
        sort.selectionSorting(list);
        Date end = new Date();
        System.out.println("Selection Sort - " + (end.getTime() - start.getTime()) + " ms");

        long start2 = System.currentTimeMillis();
        System.out.println(start2);
        sort.bubbleSorting(list2);
        long end2 = System.currentTimeMillis();
        System.out.println(end2);
        System.out.println("Bubble Sort - " + (end2 - start2)  + " ms");


        long start3 = System.currentTimeMillis();
        System.out.println(start3);
        Collections.sort(list3);
        long end3 = System.currentTimeMillis();
        System.out.println(end3);
        System.out.println("Quick Sort - " + (end3 - start3)  + " ms");
    }

    public List<Integer> fillTheList(List<Integer> list) {
        for (int i = 0; i < 1_000_000; i++) {
            list.add((int) (Math.random() * 40));
        }
        return list;
    }

    public List<Integer> selectionSorting(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int min = list.get(i);
                int current = list.get(j);
                if (min > current) {
                    list.set(i, current);
                    list.set(j, min);
                }
            }
        }
        return list;
    }

    public List<Integer> bubbleSorting(List<Integer> list) {
        for (int i = list.size() - 1; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                int left = list.get(j);
                int right = list.get(j+1);

                if (left > right) {
                    int temp = left;
                    list.set(j+1, left);
                    list.set(j, right);
                }
            }
        }
        return list;
    }
}
