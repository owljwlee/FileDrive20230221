package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

@Data
@ToString
public class FileVideoStreammed extends AbstractEvent {

    private Long id;
    private String videoUrl;
    private Long fileId;
}
