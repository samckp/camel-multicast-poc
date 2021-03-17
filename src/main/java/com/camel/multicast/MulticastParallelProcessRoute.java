package com.camel.multicast;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class MulticastParallelProcessRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(16);

        from("{{inputFilePath1}}")
                .routeId("multicastParallelProcessRoute")
                .log(LoggingLevel.INFO, "Multicast Route with Parallel processing Starting !!")
                .multicast()
                .stopOnException()
                //.parallelProcessing()//by default thread pool size is 10
                .parallelProcessing()
                .timeout(1000)
                .executorService(executor)  // manually set executor pool size
                .to("{{toRoute11}}")
                .to("{{toRoute12}}")
                .to("{{toRoute13}}")
                ;
    }
}
