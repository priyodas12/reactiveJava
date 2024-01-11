/*
 * Author:  Priyobrato.Das
 * Generated: 11/01/24, 10:17 pm IST
 * Copyright (c)  2014-2024 priyodas12
 */

package learn.reactive.monoImpl.faker;

import com.github.javafaker.Faker;

public class FakerDemo {


  public static void main(String[] args) {

    for (int i = 0; i < 10 ; i++) {
      System.out.println(Faker.instance().address().country());
    }

  }

}
