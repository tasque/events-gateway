package konchennye.sheregesh.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public/api")
@Slf4j
public class EventsApiController {

    @GetMapping("/accept")
    public void acceptEventGet(EventRecord eventRecord) {
        System.out.println(eventRecord);
    }

    @PostMapping("/accept")
    public void acceptEventPost(@RequestBody EventRecord eventRecord) {
        System.out.println(eventRecord);
    }

}
