package org.example.mini_project_api.controller;


import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.example.mini_project_api.dto.request.file.FileDto;
import org.example.mini_project_api.dto.response.ApiResponse;
import org.example.mini_project_api.service.FileService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/file")
@RequiredArgsConstructor
public class FileController {
    private final FileService fileService;
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "Upload New Image")
    public ResponseEntity<?> uploadFile(@RequestParam MultipartFile file) throws IOException {

        String fileName = fileService.uploadFile(file);

        String fileUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("api/v1/file/view/" + fileName)
                .toUriString();

        FileDto fileDto = FileDto.builder()
                .fileName(fileName)
                .fileUrl(fileUrl)
                .fileType(file.getContentType())
                .fileSize(file.getSize())
                .build();

        ApiResponse response = ApiResponse.builder()
                .message("Uploaded file successfully!")
                .status(HttpStatus.CREATED)
                .payload(fileDto)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/view/{fileName}")
    @Operation(summary = "Get Image By Image Name")
    public ResponseEntity<?> viewFileByFileName(@PathVariable String fileName) throws IOException {

        Resource resource = fileService.viewFileByFileName(fileName);

        MediaType mediaType = MediaType.APPLICATION_OCTET_STREAM;

        if(fileName.endsWith(".png")) {
            mediaType = MediaType.IMAGE_PNG;
        }
        else if(fileName.endsWith(".jpg") || fileName.endsWith(".jpeg")) {
            mediaType = MediaType.IMAGE_JPEG;
        }
        else if(fileName.endsWith(".pdf")) {
            mediaType = MediaType.APPLICATION_PDF;
        }
        else if(fileName.endsWith(".gif")) {
            mediaType = MediaType.IMAGE_GIF;
        }
        else if(fileName.endsWith(".mp4")) {
            mediaType = MediaType.valueOf("video/mp4");
        }

        return ResponseEntity.status(HttpStatus.OK)
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                .contentType(mediaType)
                .body(resource);
    }


    @GetMapping(value = "/download/{fileName}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @Operation(summary = "Download Image by Image Name")
    public ResponseEntity<?> downloadFileByFileName(@PathVariable String fileName) throws IOException {

        Resource resource = fileService.downloadFileByFileName(fileName);

        return ResponseEntity.status(HttpStatus.OK)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
}
