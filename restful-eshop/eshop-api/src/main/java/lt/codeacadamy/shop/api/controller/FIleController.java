package lt.codeacadamy.shop.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lt.codeacadamy.shop.api.Endpoint;
import lt.codeacadamy.shop.api.entity.File;
import lt.codeacadamy.shop.api.service.FileService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

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

    @ApiOperation(value = "Save image as BLOB", tags = "saveImage", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Kai sekmingai sukuriamas image, kaip BLOB"),
            @ApiResponse(code = 403, message = "Neturit permisionu gauti atsakymas"),
            @ApiResponse(code = 401, message = "Prisijunkite jei norit gauti atsakyma")
    })
    @PostMapping(Endpoint.FILE_UPLOAD_AS_BLOB)
    @ResponseStatus(HttpStatus.CREATED)
    public void saveFileAsBlob(@RequestParam MultipartFile multipartFile) {
        fileService.saveFileAsBlob(multipartFile);
    }

    @ApiOperation(value = "Get image by name", tags = "getImage", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Kai sekmingai grazinamas image"),
            @ApiResponse(code = 403, message = "Neturit permisionu gauti atsakymas"),
            @ApiResponse(code = 401, message = "Prisijunkite jei norit gauti atsakyma")
    })
    @GetMapping(Endpoint.FILE_BY_NAME)
    public ResponseEntity<Resource> getFileByNameFromFileSystems(@PathVariable String name) {

        Resource resource = new InputStreamResource(fileService.getFileByNameFromFileSystem(name));
        MediaType mediaType = fileService.getFileMediaTypeByName(name);

        return ResponseEntity.ok()
                .headers(getHttpHeader(name))
                .contentType(mediaType)
                .body(resource);
    }

    @ApiOperation(value = "Get image by UUID", tags = "getImage", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Kai sekmingai grazinamas image"),
            @ApiResponse(code = 403, message = "Neturit permisionu gauti atsakymas"),
            @ApiResponse(code = 401, message = "Prisijunkite jei norit gauti atsakyma")
    })
    @GetMapping(Endpoint.FILE_BY_UUID)
    public ResponseEntity<Resource> getFileByUUID(@PathVariable(Endpoint.UUID) UUID uuid) {
        File file = fileService.getFileByUUID(uuid);

        Resource resource = new ByteArrayResource(file.getBytes());

        return ResponseEntity.ok()
                .headers(getHttpHeader(file.getFileName()))
                .contentType(MediaType.valueOf(file.getMediaType()))
                .body(resource);
    }

    private HttpHeaders getHttpHeader(String fileName) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        return headers;
    }
}
