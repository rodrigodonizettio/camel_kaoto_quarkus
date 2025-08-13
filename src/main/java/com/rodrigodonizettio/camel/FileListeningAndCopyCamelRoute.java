package com.rodrigodonizettio.camel;


import jakarta.inject.Singleton;

@Singleton
public class FileListeningAndCopyCamelRoute extends org.apache.camel.builder.RouteBuilder {

    @Override
    public void configure() {
        from("file:my/desired/listening/file/path?noop=true")
            .to("file:my/desired/new-copy/target/file/path")
            .log("File processed: ${header.CamelFileName}");
    }
}