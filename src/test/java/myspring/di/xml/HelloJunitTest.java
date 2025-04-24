package myspring.di.xml;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

//Assertions에 포함된 모든 static method를 import 한다.
import static org.junit.jupiter.api.Assertions.*;

public class HelloJunitTest {
   @Test
   void helloBean() {
      //1. Container 객체 생성
      ApplicationContext context = new GenericXmlApplicationContext("classpath:hello-di.xml");
      
      //2. Container 객체가 생성한 Spring Bean을 요청하기! id와 type으로 해보자.
      Hello helloById = (Hello)context.getBean("hello");
      Hello helloByType = context.getBean("hello", Hello.class);
      
      //Spring Bean의 주소 비교
      System.out.println(helloById == helloByType);
      assertSame(helloById, helloByType);
      
   }
   
}