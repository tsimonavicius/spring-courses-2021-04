package lt.codeacadamy.shop.api.service;

import lombok.extern.slf4j.Slf4j;
import lt.codeacadamy.shop.api.entity.BlobFIle;
import lt.codeacadamy.shop.api.entity.File;
import lt.codeacadamy.shop.api.exception.FileException;
import lt.codeacadamy.shop.api.repository.FileRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

/**
 * @author Andrius Baltrunas
 */
@Service
@Slf4j
public class FileService {

    private static final int MAX_SIZE = 10000000; //10MB
    private final Set<String> types;
    private final Path fileLocation;

    private final FileRepository fileRepository;

    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;

        fileLocation = Paths.get("./files").toAbsolutePath().normalize();
        types = Set.of(MediaType.IMAGE_GIF_VALUE, MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_JPEG_VALUE, "image/svg+xml");
    }

    public void saveFileInFileSystem(MultipartFile multipartFile) {
        validateFile(multipartFile);
        createDirectory();

        try {
            File file = new File();
            file.setFileName(multipartFile.getOriginalFilename());
            file.setMediaType(multipartFile.getContentType());
            file.setSize(multipartFile.getSize());

            file = fileRepository.save(file);

            Path newFilePath = fileLocation.resolve(file.getId().toString());
            Files.copy(multipartFile.getInputStream(), newFilePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            log.error("Cannot create file ", e);
            throw new FileException("Cannot create file");
        }
    }

    public InputStream getFileByNameFromFileSystem(String fileName) {
        try {
            File file = fileRepository.findFirstByFileName(fileName);
            Path path = fileLocation.resolve(file.getId().toString());
            return Files.newInputStream(path);
        } catch (Exception e) {
            throw new FileException("Cannot get file ");
        }
    }

    public BlobFIle getFileByUUID(UUID uuid) {
        try {
            File file = fileRepository.findById(uuid)
                    .orElseThrow(() -> new FileException(String.format("Cannot find file by %s", uuid)));

            Path path = fileLocation.resolve(file.getId().toString());

            BlobFIle blobFIle = new BlobFIle();
            blobFIle.setBytes(Files.readAllBytes(path));
            blobFIle.setFileName(file.getFileName());
            blobFIle.setMediaType(file.getMediaType());

            return blobFIle;
        } catch (Exception e) {
            throw new FileException(String.format("Cannot find file by %s", uuid));
        }
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

    public MediaType getFileMediaTypeByName(String name) {
        String type = URLConnection.guessContentTypeFromName(name);

        return MediaType.valueOf(type);
    }
}
