package lt.codeacadamy.shop.api.service;

import lombok.extern.slf4j.Slf4j;
import lt.codeacadamy.shop.api.exception.FileException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;

/**
 * @author Andrius Baltrunas
 */
@Service
@Slf4j
public class FileService {

    private final Path fileLocation;

    public FileService() {
        fileLocation = Paths.get("./files").toAbsolutePath().normalize();
    }

    public void saveFileInFileSystem(MultipartFile multipartFile) {
        createDirectory();

        try {
            Path newFilePath = fileLocation.resolve(getUniqueFileName(multipartFile));
            Files.copy(multipartFile.getInputStream(), newFilePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            log.error("Cannot create file ", e);
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
}
