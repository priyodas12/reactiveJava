/*
 * Author:  Priyobrato.Das
 * Generated: 11/01/24, 10:21 pm IST
 * Copyright (c)  2014-2024 priyodas12
 */

package learn.reactive.util.faker;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.github.javafaker.Faker;

public class FakerUtil {

  private final static Faker faker = Faker.instance ();

  public static Consumer<Object> onNext () {
    return obj -> System.out.println ("Received:  " + obj);
  }

  public static Consumer<Throwable> onError () {
    return obj -> System.out.println ("Error :  " + obj);
  }

  public static Runnable onComplete () {
    return () -> System.out.println ("Completed");
  }

  public static Faker getFakeInstance () {
    return faker;
  }

  public static List<String> getNames () {
    return IntStream.rangeClosed (1, 10)
        .mapToObj (n -> Faker.instance ().funnyName ().name ())
        .collect (Collectors.toList ());
  }

}
