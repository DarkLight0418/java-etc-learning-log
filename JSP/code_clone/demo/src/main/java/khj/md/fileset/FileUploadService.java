package khj.md.fileset;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
    String saveAtStore(MultipartFile file);
}
