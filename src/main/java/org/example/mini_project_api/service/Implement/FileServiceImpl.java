package org.example.mini_project_api.service.Implement;

import org.example.mini_project_api.service.FileService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    Path path = Paths.get("src/main/resources/files");

    @Override
    public String uploadFile(MultipartFile file) throws IOException {

//        String originalFileName = file.getOriginalFilename();
//        String newFileName = UUID.randomUUID() + "." + StringUtils.getFilenameExtension(originalFileName);
        String newFileName = UUID.randomUUID() + ".png";

        if(!Files.exists(path)) {
            Files.createDirectories(path);
        }

        Files.copy(file.getInputStream(), path.resolve(newFileName));

        return newFileName;
    }

    @Override
    public Resource viewFileByFileName(String fileName) throws IOException {

        Path filePath = Paths.get("src/main/resources/files/" + fileName);

        Resource resource = new InputStreamResource(Files.newInputStream(filePath));

        return resource;
    }

    @Override
    public Resource downloadFileByFileName(String fileName) throws IOException {
        Path filePath = Paths.get("src/main/resources/files/" + fileName);

        Resource resource = new InputStreamResource(Files.newInputStream(filePath));
        return resource;
    }
}
