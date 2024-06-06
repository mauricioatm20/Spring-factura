package com.mauricio.curso.di.factura.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@Component
@RequestScope
//@JsonIgnoreProperties({"targetSource","advisors"})
public class Invoice {

    @Autowired
    private Client client;

    @Value("${invoice.description.office}")
    private String description;

    @Autowired
    @Qualifier("default")
    private List<Item> items;


    @PostConstruct
    public void init(){// creando el componente de la factura
        client.setName(client.getName().concat(" Mateo"));
        description=description.concat(" señor ").concat(client.getName()).concat(" ").concat(client.getLastname());
    }
    @PreDestroy
    public void destroy(){

    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

//    public int getTotal(){
//
//        int total = 0;
//        for (Item item : items) {
//            total += item.getImporte();
//        }
//        return total;
//    }

    public int getTotal(){
        return items.stream().map(item -> item.getImporte()).reduce(0,(sum, importe)-> sum + importe);
    }
}
