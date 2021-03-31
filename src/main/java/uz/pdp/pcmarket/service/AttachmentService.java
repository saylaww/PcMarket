package uz.pdp.pcmarket.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.pcmarket.entity.Attachment;
import uz.pdp.pcmarket.payload.Response;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public interface AttachmentService {

    Response saveFiles(MultipartFile[] files, MultipartFile[] images);

    List<Attachment> findAll();

    Response saveFile(MultipartHttpServletRequest request);

    Response download(Integer id, HttpServletResponse response);

    Response delete(Integer id);
}
