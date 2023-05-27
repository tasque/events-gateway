package konchennye.sheregesh.api;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springdoc.core.fn.builders.apiresponse.Builder.responseBuilder;
import static org.springdoc.core.fn.builders.requestbody.Builder.requestBodyBuilder;
import static org.springdoc.webflux.core.fn.SpringdocRouteBuilder.route;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RequestPredicates.contentType;

@Configuration
public class EventsApiRouterConfiguration {


    @Bean
    public RouterFunction<ServerResponse> routerFunctions(KafkaService kafkaService) {
        return RouterFunctions.route()
                .POST("/public/api/accept", RequestPredicates.contentType(MediaType.APPLICATION_JSON), kafkaService::sendToKafka)
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> docRoute(KafkaService kafkaService) {
        return route().POST("/public/api/accept", accept(APPLICATION_JSON).and(contentType(APPLICATION_JSON)), kafkaService::sendToKafka,
                ops -> ops.tag("accept")
                        .operationId("accept")
                        .requestBody(requestBodyBuilder().implementation(EventRecord.class))
                        .response(responseBuilder().responseCode("200"))).build();
    }

}
