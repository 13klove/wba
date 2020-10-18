package web.boostcourse.api.wba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
//https://webfirewood.tistory.com/m/115?category=694472
public class WbaApplication {

    public static void main(String[] args) {
        SpringApplication.run(WbaApplication.class, args);
    }

}
