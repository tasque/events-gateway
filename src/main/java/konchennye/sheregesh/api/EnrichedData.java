package konchennye.sheregesh.api;

import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.Data;

@Data
public class EnrichedData {

    private ObjectNode data;

    private String nodejsHeader;
}
