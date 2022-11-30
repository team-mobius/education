package com.mobius.education.controller;

import com.mobius.education.domain.vo.LectureFileVO;
import com.mobius.education.service.LectureService;
import lombok.RequiredArgsConstructor;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/lectureFile/*")
public class LectureFileController {
    @PostMapping("/upload")
    public List<LectureFileVO> upload(List<MultipartFile> upload, LectureService lectureService) throws IOException {
        String rootPath = "C:/upload";
        String uploadPath = getUploadPath();
        List<LectureFileVO> files = new ArrayList<>();


        File uploadFullPath = new File(rootPath, uploadPath);
        if(!uploadFullPath.exists()){uploadFullPath.mkdirs();}

        for(MultipartFile multipartFile : upload){
            LectureFileVO lectureFileVO = new LectureFileVO();
            UUID uuid = UUID.randomUUID();
            String fileName = multipartFile.getOriginalFilename();
            String uploadFileName = uuid.toString() + "_" + fileName;

            lectureFileVO.setLectureFileName(fileName);
            lectureFileVO.setLectureFileUuid(uuid.toString());
            lectureFileVO.setLectureFileUploadPath(getUploadPath());
            lectureFileVO.setLectureFileSize(multipartFile.getSize());


            File fullPath = new File(uploadFullPath, multipartFile.getOriginalFilename());
            multipartFile.transferTo(fullPath);

            if(Files.probeContentType(fullPath.toPath()).startsWith("image")){
                FileOutputStream out = new FileOutputStream(new File(uploadFullPath, "s_" + uploadFileName));
                Thumbnailator.createThumbnail(multipartFile.getInputStream(), out, 100, 100);
                out.close();
                lectureFileVO.setLectureFileCheck(true);
            }
            files.add(lectureFileVO);
        }
        return files;
    }

    @GetMapping("/display")
    public byte[] display(String fileName) throws IOException {
        return FileCopyUtils.copyToByteArray(new File("C:/upload", fileName));
    }

    @PostMapping("/delete")
    public void delete(LectureFileVO lectureFileVO) {
        File file = new File("C:/upload", lectureFileVO.getLectureFileUploadPath() + "/" + lectureFileVO.getLectureFileName());
        if(file.exists()){
            file.delete();
        }
        if(lectureFileVO.isLectureFileCheck()){
            file = new File("C:/upload", lectureFileVO.getLectureFileUploadPath() + "/s_" + lectureFileVO.getLectureFileName());
            if(file.exists()){
                file.delete();
            }
        }
    }

    private String getUploadPath(){
        return new SimpleDateFormat("yyyy/MM/dd").format(new Date());
    }
}

