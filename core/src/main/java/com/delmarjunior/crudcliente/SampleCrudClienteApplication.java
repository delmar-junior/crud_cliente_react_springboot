package com.delmarjunior.crudcliente;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SampleCrudClienteApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleCrudClienteApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner commandLineRunner() {
//        return args -> {
//            System.out.println("========================");
//            System.out.println("funcionou");
//            System.out.println("========================");
//        };
//    }

}
