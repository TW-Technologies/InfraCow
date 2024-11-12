package com.infracow.program.utils;

import com.infracow.program.models.Animal;

public class Util {

    public static void mergeSort(Animal[] array, int n){
        if(n < 2){
            return;
        }
        int middle = Math.floorDiv(n, 2);

        Animal[] left = new Animal[middle];
        Animal[] right = new Animal[n - middle];

        for (int i = 0; i < middle; i++) {
            left[i] = array[i];
        }
        for (int i = middle; i < n; i++) {
            right[i - middle] = array[i];
        }

    }

}
