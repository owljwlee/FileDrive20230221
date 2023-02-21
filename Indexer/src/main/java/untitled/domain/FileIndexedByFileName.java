package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

@Data
@ToString
public class FileIndexedByFileName extends AbstractEvent {

    private Long id;
    private List<String> keywords;
    private Long fileId;

    public FileIndexedByFileName() {
        super();
    }
}
