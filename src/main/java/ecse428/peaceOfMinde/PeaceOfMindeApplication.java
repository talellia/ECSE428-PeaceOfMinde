package ecse428.peaceOfMinde;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;

@SpringBootApplication
public class PeaceOfMindeApplication {

  @RequestMapping("/test")
  public String root(){
      return "Index Page";
  }

    public static void main(String[] args) {
        SpringApplication.run(PeaceOfMindeApplication.class, args);
    }

}
