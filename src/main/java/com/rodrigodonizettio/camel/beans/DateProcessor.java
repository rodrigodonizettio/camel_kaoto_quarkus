package com.rodrigodonizettio.camel.beans;


import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.util.Date;
import java.text.SimpleDateFormat;


@ApplicationScoped
@Named("dateProcessor")
public class DateProcessor implements Processor {

    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    private final SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);

    @Override
    public void process(Exchange exchange) throws Exception {
        Long fileEventDate = exchange.getIn().getHeader("CamelFileLastModified", Long.class);

        Date eventDate = new Date(fileEventDate);
        
        exchange.getIn().setHeader("CamelFileLastModified", formatter.format(eventDate));
    } 
}
