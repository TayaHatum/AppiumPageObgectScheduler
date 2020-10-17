package com.hatum;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class taskMain {

    public static void main(String[] args) {

      int[] temp = new int[]{1,2,3,4,5,6};
      TaskEvenIterator itr = new TaskEvenIterator(temp);
      while (itr.hasNext()){
          System.out.println(itr.next());
      }


    }
}
