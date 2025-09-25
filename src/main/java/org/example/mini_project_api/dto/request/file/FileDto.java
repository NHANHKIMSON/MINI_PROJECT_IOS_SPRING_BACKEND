package org.example.mini_project_api.dto.request.file;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FileDto {
    private String fileName;
    private String fileUrl;
    private String fileType;
    private Long fileSize;
}
