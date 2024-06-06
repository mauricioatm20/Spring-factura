package com.mauricio.curso.di.factura.controllers;

import com.mauricio.curso.di.factura.models.Client;
import com.mauricio.curso.di.factura.models.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private Invoice invoice;

    @GetMapping("/show")
    public Invoice show(){
        Invoice i = new Invoice();
        Client client = new Client();

        client.setLastname(invoice.getClient().getLastname());
        client.setName(invoice.getClient().getName());

        i.setClient(client);
        i.setDescription(invoice.getDescription());
        i.setItems(invoice.getItems());
    return i;
    }
}
