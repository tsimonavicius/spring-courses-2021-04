package lt.codeacadamy.shop.api.controller;

import io.swagger.annotations.Api;
import lt.codeacadamy.shop.api.Endpoint;
import lt.codeacadamy.shop.api.service.FileService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
}
