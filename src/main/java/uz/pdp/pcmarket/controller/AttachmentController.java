package uz.pdp.pcmarket.controller;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.pcmarket.entity.Attachment;
import uz.pdp.pcmarket.repository.AttachmentRepository;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/attachment")
public class AttachmentController {

    private static final String directory="files";

    final AttachmentRepository attachmentRepository;

    public AttachmentController(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }

    @PostMapping("/upload")
    public String upload(MultipartHttpServletRequest request) throws IOException {
        Iterator<String> fileNames = request.getFileNames();
        while (fileNames.hasNext()){
            MultipartFile file = request.getFile(fileNames.next());
            if (file!=null){
                String originalFilename = file.getOriginalFilename();
                Attachment attachment = new Attachment();
                attachment.setExtension(file.getContentType());
                attachment.setSize((int) file.getSize());
                attachment.setPath(originalFilename);

                String[] split = originalFilename.split("\\.");
                String name = UUID.randomUUID().toString() + "." + split[split.length-1];

                attachment.setName(name);
                attachmentRepository.save(attachment);

                Path path = Paths.get(directory+"/"+name);
                Files.copy(file.getInputStream(), path);
            }
        }
        return "Fayllar saqalndi";
    }
    @GetMapping("/getFileFromSystem/{id}")
    public void getFileFromSystem(@PathVariable Integer id, HttpServletResponse response) throws IOException {
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
        if (optionalAttachment.isPresent()){
            Attachment attachment = optionalAttachment.get();
            response.setHeader("Content-Disposition", "attachment; filename\""+ attachment.getPath()+ "\"");
            FileInputStream fileInputStream = new FileInputStream(directory+"/"+attachment.getName());

            FileCopyUtils.copy(fileInputStream, response.getOutputStream());
        }
    }


}
