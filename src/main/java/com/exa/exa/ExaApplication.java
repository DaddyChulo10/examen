package com.exa.exa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDate;  
import java.util.Scanner; 

@SpringBootApplication
public class ExaApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExaApplication.class, args);
        Scanner reader = new Scanner(System.in);
        double amount, rate, monto, porcentaje, semanas;
        Integer terms, payment_number;
        System.out.println("Monto: ");      
        amount = reader.nextInt();
        System.out.println("Terms: ");      
        terms = reader.nextInt();
        System.out.println("Rate: ");      
        rate = reader.nextInt();
        if(amount<=1.00 || amount>=999999.00 ){
          System.out.println("El monto debe ser superior a 1.00 e inferior a 999,999.00");
        }else if(terms <= 3 || terms >= 53){
          System.out.println("El plazo debe ser superior o igual a 4 e inferior o igual a 52");
        }else if(rate <= 1 || rate >= 100) {
          System.out.println("La taza debe ser superior a 1 e inferior a 100");
        }else {
        payment_number = terms;
        porcentaje = ((rate * 100)/amount);
        monto = porcentaje + amount ;
        semanas = monto / payment_number;
        System.out.println("Semanas totales: " + payment_number);
        System.out.println("Monto a pagar en total: $" + monto );
        System.out.println("Cada semana pagará: $" + semanas );
        LocalDate today = LocalDate.now();
        for(int i = 0; i < terms; i ++){
          LocalDate fecha = today.plusDays(i * 7);
          System.out.println("Dias a Págar: " + fecha + " Pago: $"+ semanas);
        }
      }
    }
}
