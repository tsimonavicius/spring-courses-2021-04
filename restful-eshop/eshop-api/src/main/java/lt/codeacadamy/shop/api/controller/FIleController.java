package lt.codeacadamy.shop.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lt.codeacadamy.shop.api.Endpoint;
import lt.codeacadamy.shop.api.service.FileService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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

    @ApiOperation(value = "Save image", tags = "saveImage", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Kai sekmingai sukuriamas image"),
            @ApiResponse(code = 403, message = "Neturit permisionu gauti atsakymas"),
            @ApiResponse(code = 401, message = "Prisijunkite jei norit gauti atsakyma")
    })
    @PostMapping(Endpoint.FILE_UPLOAD)
    @ResponseStatus(HttpStatus.CREATED)
    public void saveFileInFileSystem(@RequestParam MultipartFile multipartFile) {
        fileService.saveFileInFileSystem(multipartFile);
    }

    @ApiOperation(value = "Get image by name", tags = "getFileImages", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Kai sekmingai grazinamas image"),
            @ApiResponse(code = 403, message = "Neturit permisionu gauti atsakymas"),
            @ApiResponse(code = 401, message = "Prisijunkite jei norit gauti atsakyma")
    })
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