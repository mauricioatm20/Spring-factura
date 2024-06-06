package com.mauricio.curso.di.factura;

import com.mauricio.curso.di.factura.models.Item;
import com.mauricio.curso.di.factura.models.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;
import java.util.List;

@Configuration
@PropertySource("classpath:data.properties")
public class AppConfig {

    @Bean("default")
    List<Item> itemsInvoive (){
        Product p1 = new Product("Airpods",279);
        Product p2 = new Product("MacBook",1300);
        Product p3 = new Product("Iphone 15",1150);

       return  Arrays.asList(
               new Item(p1,2),
               new Item(p2,3),
               new Item(p3,4));

    }
// para cambiar la inyeccion se cambia el default o usar @Primary con el @Bean que se quiera inyectar
    @Bean
    List<Item> itemsInvoiveOffice (){
        Product p1 = new Product("Monitor Asus",279);
        Product p2 = new Product("NoteBook",900);
        Product p3 = new Product("Impresosa HP",600);
        Product p4 = new Product("Escritorio Oficina",300);

       return  Arrays.asList(
               new Item(p1,3),
               new Item(p2,2),
               new Item(p3,2),
               new Item(p4,5));

    }
}
