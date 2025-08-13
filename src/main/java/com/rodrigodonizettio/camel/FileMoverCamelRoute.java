package com.rodrigodonizettio.camel;


import jakarta.inject.Singleton;

@Singleton
public class FileMoverCamelRoute extends org.apache.camel.builder.RouteBuilder {

    @Override
    public void configure() {
        from("file:/home/rodrigo-ubuntu24/Documents/Projects/ApacheCamel/CamelCore/MyCamel/file-mover/tmp/input?noop=true")
            .to("file:/home/rodrigo-ubuntu24/Documents/Projects/ApacheCamel/CamelCore/MyCamel/file-mover/tmp/output")
            .log("File processed: ${header.CamelFileName}");
    }
}
