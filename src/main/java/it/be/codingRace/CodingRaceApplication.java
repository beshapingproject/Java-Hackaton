package it.be.codingRace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.TimeZone;


@ComponentScan(basePackages = {"it.be.codingRace.*"})
@EntityScan("it.be.codingRace.*")
@SpringBootApplication(exclude = SpringDataWebAutoConfiguration.class)
public class CodingRaceApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(CodingRaceApplication.class);

    public static void main(String[] args) { SpringApplication.run(CodingRaceApplication.class, args);}

    @Override
    public void run(String... args)  {


        log.info("                                                                                  \n" +
                "         /\\    \\                 /\\    \\                 /\\    \\                /::\\    \\        |\\    \\         \n" +
                "        /::\\    \\               /::\\____\\               /::\\    \\              /::::\\    \\       |:\\____\\        \n" +
                "       /::::\\    \\             /::::|   |               \\:::\\    \\            /::::::\\    \\      |::|   |        \n" +
                "      /::::::\\    \\           /:::::|   |                \\:::\\    \\          /::::::::\\    \\     |::|   |        \n" +
                "     /:::/\\:::\\    \\         /::::::|   |                 \\:::\\    \\        /:::/~~\\:::\\    \\    |::|   |        \n" +
                "    /:::/__\\:::\\    \\       /:::/|::|   |                  \\:::\\    \\      /:::/    \\:::\\    \\   |::|   |        \n" +
                "   /::::\\   \\:::\\    \\     /:::/ |::|   |                  /::::\\    \\    /:::/    / \\:::\\    \\  |::|   |        \n" +
                "  /::::::\\   \\:::\\    \\   /:::/  |::|   | _____   _____   /::::::\\    \\  /:::/____/   \\:::\\____\\ |::|___|______  \n" +
                " /:::/\\:::\\   \\:::\\    \\ /:::/   |::|   |/\\    \\ /\\    \\ /:::/\\:::\\    \\|:::|    |     |:::|    |/::::::::\\    \\ \n" +
                "/:::/__\\:::\\   \\:::\\____/:: /    |::|   /::\\____/::\\    /:::/  \\:::\\____|:::|____|     |:::|    /::::::::::\\____\\\n" +
                "\\:::\\   \\:::\\   \\::/    \\::/    /|::|  /:::/    \\:::\\  /:::/    \\::/    /\\:::\\    \\   /:::/    /:::/~~~~/~~      \n" +
                " \\:::\\   \\:::\\   \\/____/ \\/____/ |::| /:::/    / \\:::\\/:::/    / \\/____/  \\:::\\    \\ /:::/    /:::/    /         \n" +
                "  \\:::\\   \\:::\\    \\             |::|/:::/    /   \\::::::/    /            \\:::\\    /:::/    /:::/    /          \n" +
                "   \\:::\\   \\:::\\____\\            |::::::/    /     \\::::/    /              \\:::\\__/:::/    /:::/    /           \n" +
                "    \\:::\\   \\::/    /            |:::::/    /       \\::/    /                \\::::::::/    /\\::/    /            \n" +
                "     \\:::\\   \\/____/             |::::/    /         \\/____/                  \\::::::/    /  \\/____/             \n" +
                "      \\:::\\    \\                 /:::/    /                                    \\::::/    /                       \n" +
                "       \\:::\\____\\               /:::/    /                                      \\::/____/                        \n" +
                "        \\::/    /               \\::/    /                                        ~~                              \n" +
                "         \\/____/                 \\/____/                                                                         \n" +
                "                                                                                       ");

    }


    @PostConstruct
    public void init(){
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        System.out.println("Spring boot application running in UTC timezone: " + new Date());
    }


}
