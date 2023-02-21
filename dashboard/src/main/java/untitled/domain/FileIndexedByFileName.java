package untitled.domain;

import java.util.*;
import lombok.Data;
import untitled.infra.AbstractEvent;

@Data
public class FileIndexedByFileName extends AbstractEvent {

    private Long id;
    private List<String> Keywords;
    private Long fileId;
}
