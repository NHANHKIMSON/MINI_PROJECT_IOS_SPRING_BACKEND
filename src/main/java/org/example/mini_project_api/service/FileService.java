package org.example.mini_project_api.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    String uploadFile(MultipartFile file) throws IOException;

    Resource viewFileByFileName(String fileName) throws IOException;

    Resource downloadFileByFileName(String fileName) throws IOException;
}
