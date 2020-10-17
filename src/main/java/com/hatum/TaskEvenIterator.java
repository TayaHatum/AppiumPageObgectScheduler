package com.hatum;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TaskEvenIterator implements Iterator<Integer> {

    private int[] arr;
    private int curr;

    public TaskEvenIterator(int[] arr){
        this.arr = arr;
        for(int i=0; i<arr.length;i++){
            if(arr[i]%2==0){
                curr=i;
                break;
            }
        }
    }

    @Override
    public boolean hasNext() {

        return curr < arr.length;
    }

    @Override
    public Integer next() {
        if(!hasNext()) {
            throw new NoSuchElementException();
        }
        int res = arr[curr++];
       for(;curr<arr.length;curr++){
           if(arr[curr]%2==0){
               break;
           }
       }

      return res;
    }



}
