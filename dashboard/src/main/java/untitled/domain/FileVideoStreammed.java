package untitled.domain;

import java.util.*;
import lombok.Data;
import untitled.infra.AbstractEvent;

@Data
public class FileVideoStreammed extends AbstractEvent {

    private Long id;
    private String VideoURL;
    private Long fileId;
}
