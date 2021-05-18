package lt.codeacadamy.shop.api.controller;

import io.swagger.annotations.Api;
import lt.codeacadamy.shop.api.Endpoint;
import lt.codeacadamy.shop.api.service.FileService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Andrius Baltrunas
 */
@RestController
@RequestMapping(Endpoint.API_ROOT)
@Api(tags = "File upload controller")
public class FIleController {
    private final FileService fileService;

    public FIleController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping(Endpoint.FILE_UPLOAD)
    public void saveFileInFileSystem(@RequestParam MultipartFile multipartFile) {
        fileService.saveFileInFileSystem(multipartFile);
    }

    @GetMapping(Endpoint.FILE_BY_NAME)
    public ResponseEntity<Resource> getFileByNameFromFileSystems(@PathVariable String name) {

        Resource resource = new InputStreamResource(fileService.getFileByNameFromFileSystem(name));

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Disposition", "attachment; filename=\"" + name + "\"");

        MediaType mediaType = fileService.getFileMediaTypeByName(name);

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(mediaType)
                .body(resource);
    }

}
