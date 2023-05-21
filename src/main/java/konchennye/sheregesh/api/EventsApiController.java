package konchennye.sheregesh.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public/api")
@Slf4j
@RequiredArgsConstructor
public class EventsApiController {


    private final KafkaTemplate<String, EventRecord> kafkaTemplate;

    @GetMapping("/accept")
    public void acceptEventGet(EventRecord eventRecord) {
        kafkaTemplate.send("topic", "key", eventRecord);
    }

    @PostMapping("/accept")
    public void acceptEventPost(@RequestBody EventRecord eventRecord) {
        kafkaTemplate.send("topic", "key", eventRecord);
    }

}
