package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility <T> {
    private T[] inputArray;

   public ArrayUtility(T[] inputArray) {
       this.inputArray = inputArray;
   }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        List<T> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(arrayToMerge));
        arrayList.addAll(Arrays.asList(inputArray));
       return Collections.frequency(arrayList, valueToEvaluate);
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
       Integer mostCommon = Integer.MIN_VALUE;
        List<T> arrayList = new ArrayList<>();
        T mostCommonObject = null;
        arrayList.addAll(Arrays.asList(arrayToMerge));
        arrayList.addAll(Arrays.asList(inputArray));
        for (T t : arrayList) {
           Integer current = Collections.frequency(arrayList, t);
            if(current > mostCommon) {
                mostCommon = current;
                mostCommonObject = t;
            }
        }
        return mostCommonObject;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        List<T> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(inputArray));
        return Collections.frequency(arrayList, valueToEvaluate);
    }

    public T[] removeValue(T valueToRemove) {
        int numberOfOccurrences = getNumberOfOccurrences(valueToRemove);
        T[] result = Arrays.copyOf(inputArray, inputArray.length - numberOfOccurrences);
        for (int i = 0, j = 0; i < inputArray.length; i++) {
            if (inputArray[i] != valueToRemove) {
                result[j] = inputArray[i];
                j++;
            }
        }
        return result;
    }
}
