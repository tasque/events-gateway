package konchennye.sheregesh.api;

import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class KafkaService {
    private final KafkaTemplate<String, EnrichedData> kafkaTemplate;

    
    public Mono<ServerResponse> sendToKafka(ServerRequest request) {
        return request.bodyToMono(ObjectNode.class)
                .flatMap(event -> Mono.fromFuture(kafkaTemplate.send("topic", "key", new EnrichedData().setData(event))))
                .flatMap(response -> ServerResponse.created(URI.create("/public/api/accept"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(response)));
    }
}
