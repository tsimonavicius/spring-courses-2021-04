package lt.codeacadamy.shop.api.repository;

import lt.codeacadamy.shop.api.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author Andrius Baltrunas
 */
public interface FileRepository extends JpaRepository<File, UUID> {
    File findFirstByFileName(String fileName);
}
