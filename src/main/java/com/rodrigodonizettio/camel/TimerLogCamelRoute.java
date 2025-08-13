package com.rodrigodonizettio.camel;


import jakarta.inject.Singleton;


@Singleton
public class TimerLogCamelRoute extends org.apache.camel.builder.RouteBuilder {

    @Override
    public void configure() {
        from("timer:myTimer?period=2000")
            .setBody(constant("Hello from my Camel Route"))
            .to("log:info");
    }
    
}