package com.camel.multicast;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MultiRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("{{inputFilePath}}")
                .routeId("mutliRouteId")
                .log(LoggingLevel.INFO, "Multicast Route Starting !!")
                .multicast()
                .to("{{toRoute}}")
//                .to("")
//                .to("")
                ;
    }
}
