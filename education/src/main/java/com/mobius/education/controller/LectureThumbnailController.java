package com.mobius.education.controller;

import com.mobius.education.domain.vo.LectureFileVO;
import com.mobius.education.domain.vo.LectureThumbnailVO;
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
@RequestMapping("/lectureThumb/*")
public class LectureThumbnailController {
    @PostMapping("/upload")
    public List<LectureThumbnailVO> upload(List<MultipartFile> thumbUpload) throws IOException {
        String rootPath = "C:/upload";
        String uploadPath = getUploadPath();
        List<LectureThumbnailVO> thumbs = new ArrayList<>();

        File uploadFullPath = new File(rootPath, uploadPath);
        if(!uploadFullPath.exists()){uploadFullPath.mkdirs();}

        for(MultipartFile multipartFile : thumbUpload){
            LectureThumbnailVO lectureThumbnailVO = new LectureThumbnailVO();
            UUID uuid = UUID.randomUUID();
            String fileName = multipartFile.getOriginalFilename();
            String uploadFileName = uuid.toString() + "_" + fileName;

            lectureThumbnailVO.setLectureThumbnailName(fileName);
            lectureThumbnailVO.setLectureThumbnailUuid(uuid.toString());
            lectureThumbnailVO.setLectureThumbnailUploadPath(getUploadPath());
            lectureThumbnailVO.setLectureThumbnailSize(multipartFile.getSize());

            File fullPath = new File(uploadFullPath, uploadFileName);
            multipartFile.transferTo(fullPath);

            if(Files.probeContentType(fullPath.toPath()).startsWith("image")){
                FileOutputStream out = new FileOutputStream(new File(uploadFullPath, "s_" + uploadFileName));
                Thumbnailator.createThumbnail(multipartFile.getInputStream(), out, 300, 300);
                out.close();
                lectureThumbnailVO.setLectureThumbnailCheck(true);
            }

            thumbs.add(lectureThumbnailVO);
        }
        return thumbs;
    }

    @GetMapping("/display")
    public byte[] display(String lectureThumbnailName) throws IOException{
        return FileCopyUtils.copyToByteArray(new File("C:/upload", lectureThumbnailName));
    }

    @PostMapping("/delete")
    public void delete(LectureThumbnailVO lectureThumbnailVO) {
        File file = new File("C:/upload", lectureThumbnailVO.getLectureThumbnailUploadPath() + "/" + lectureThumbnailVO.getLectureThumbnailName());
        if(file.exists()){
            file.delete();
        }
        if(lectureThumbnailVO.isLectureThumbnailCheck()){
            file = new File("C:/upload", lectureThumbnailVO.getLectureThumbnailUploadPath() + "/s_" + lectureThumbnailVO.getLectureThumbnailName());
            if(file.exists()){
                file.delete();
            }
        }
    }

    private String getUploadPath() {
        return new SimpleDateFormat("yyyy/MM/dd").format(new Date());
    }
}

