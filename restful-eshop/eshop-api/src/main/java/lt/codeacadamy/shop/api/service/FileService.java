package lt.codeacadamy.shop.api.service;

import lombok.extern.slf4j.Slf4j;
import lt.codeacadamy.shop.api.exception.FileException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * @author Andrius Baltrunas
 */
@Service
@Slf4j
public class FileService {

    private static final int MAX_SIZE = 10000000; //10MB
    private final Set<String> types;
    private final Path fileLocation;

    public FileService() {
        fileLocation = Paths.get("./files").toAbsolutePath().normalize();
        types = Set.of(MediaType.IMAGE_GIF_VALUE, MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_JPEG_VALUE, "image/svg+xml");
    }

    public void saveFileInFileSystem(MultipartFile multipartFile) {
        validateFile(multipartFile);
        createDirectory();

        try {
            Path newFilePath = fileLocation.resolve(getUniqueFileName(multipartFile));
            Files.copy(multipartFile.getInputStream(), newFilePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            log.error("Cannot create file ", e);
        }
    }

    public InputStream getFileByNameFromFileSystem(String fileName){
        try {
            Path path = fileLocation.resolve(fileName);
            return Files.newInputStream(path);
        } catch (Exception e) {
            throw new FileException("Cannot get file ");
        }
    }

    private String getUniqueFileName(MultipartFile file) {
        return String.format("%s_%s", LocalDateTime.now().getNano(), file.getOriginalFilename());
    }

    private void createDirectory() {
        try {
            if (!Files.exists(fileLocation)) {
                Files.createDirectory(fileLocation);
            }
        } catch (Exception e) {
            log.error("Cannot create directory ", e);
            throw new FileException("Cannot create directory");
        }
    }

    private void validateFile(MultipartFile file) {
        if (file.getSize() > MAX_SIZE) {
            throw new FileException("File is to big");
        }

        if (!types.contains(file.getContentType())) {
            throw new FileException("File media type not allowed");
        }
    }
}
