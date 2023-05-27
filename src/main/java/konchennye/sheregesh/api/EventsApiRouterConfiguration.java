package konchennye.sheregesh.api;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;


@Configuration
public class EventsApiRouterConfiguration {



    @Bean
    public RouterFunction<ServerResponse> routerFunctions(KafkaService kafkaService) {
        return RouterFunctions.route()
                .POST("/public/api/accept", RequestPredicates.contentType(MediaType.APPLICATION_JSON), kafkaService::sendToKafka)
                .build();
    }

}
