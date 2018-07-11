package testowy1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import testowy1.cqrs.Command;
import testowy1.cqrs.CommandProcessor;
import testowy1.cqrs.TestowaCommand;
import testowy1.cqrs.UpdateCommand;
import testowy1.model.Transaction;
import testowy1.model.TransactionCategoryTags;
import testowy1.model.TransactionRepository;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
