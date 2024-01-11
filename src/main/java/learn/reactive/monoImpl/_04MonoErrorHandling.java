/*
 * Author:  Priyobrato.Das
 * Generated: 11/01/24, 10:31 pm IST
 * Copyright (c)  2014-2024 priyodas12
 */

package learn.reactive.monoImpl;

import java.util.Random;
import learn.reactive.monoImpl.faker.FakerUtil;
import reactor.core.publisher.Mono;

public class _04MonoErrorHandling {

  public static void main(String[] args) {

    Random random=new Random();

    for (int i = 0; i < 3; i++) {
      Integer userId=random.nextInt(21);
      System.out.println("*************"+userId+"***********");
      addressRepo(userId).subscribe(
          FakerUtil.onNext(),
          FakerUtil.onError(),
          FakerUtil.onComplete()
      );
    }

  }


  /**Random publisher or DB instance response*/
  public static Mono<String> addressRepo(Integer userId){
    if(userId%5==0){
      return Mono.just(FakerUtil.getFakeInstance().address().fullAddress());
    }else if(userId%7==0){
      return Mono.error(new RuntimeException("Address Not Found!"));
    }else{
      return Mono.empty();
    }

  }
}
