package untitled.domain;

import java.util.*;
import lombok.Data;
import untitled.infra.AbstractEvent;

@Data
public class FileUploaded extends AbstractEvent {

    private Long id;
    private String FileName;
    private String FilePath;
    private Long FileSize;
}
