/*
 * Author:  Priyobrato.Das
 * Generated: 12/02/24, 11:21 pm IST
 * Copyright (c)  2014-2024 priyodas12
 */

package learn.reactive.fluximpl;

import java.util.List;
import java.util.stream.Stream;

public class _04FluxFromStream {

  public static void main(String[] args) {

    List<Integer> integerList= List.of(1,2,3,4,5);

    Stream<Integer> stream=integerList.stream();

    stream.forEach(System.out::println);
    /**Stream is for one time usage*/
    //stream.forEach(System.out::println);
  }

}
