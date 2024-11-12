package com.infracow.program.utils;

import com.infracow.program.models.Animal;

import java.util.Arrays;

public class Util {

    public static void mergeSort(Animal[] array, int n) {
        if (n < 2) {
            return;
        }
        int middle = n / 2;

        Animal[] left = new Animal[middle];
        Animal[] right = new Animal[n - middle];

        for (int i = 0; i < middle; i++) {
            left[i] = array[i];
            System.out.println("Left:");
            System.out.println(left[i].getIdade());
        }
        for (int i = middle; i < n; i++) {
            right[i - middle] = array[i];
            System.out.println("Right:");
            System.out.println(right[i - middle].getIdade());
        }
        for (int i = 0; i < n; i++) {
            System.out.println("Array:");
            System.out.println(array[i].getIdade());
        }

        mergeSort(left, middle);
        mergeSort(right, n - middle);

        merge(array, left, right, middle, n - middle);
    }

    public static void merge(Animal[] array, Animal[] left, Animal[] right, int leftSize, int rightSize) {
        int i = 0, j = 0, k = 0;

        while (i < leftSize && j < rightSize) {
            if (left[i].getIdade() <= right[j].getIdade()) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }

        }
        while (i < leftSize) {
            array[k++] = left[i++];
        }
        while (j < rightSize) {
            array[k++] = right[j++];
        }
    }
}
