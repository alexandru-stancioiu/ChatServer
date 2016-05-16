package ro.pub.cs.idp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by stancioi on 4/30/2016.
 */

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("ro.pub.cs.idp")
public class Main {

    public static void main(String args[]) {
        ApplicationContext ctx = SpringApplication.run(Main.class, args);
    }
}
