package com.mobius.education.controller;

import com.mobius.education.domain.vo.RequestCommentDTO;
import com.mobius.education.domain.vo.RequestCommentVO;
import com.mobius.education.domain.vo.RequestDTO;
import com.mobius.education.service.RequestBoardService;
import com.mobius.education.service.RequestCommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/comment/*")
public class RequestCommentController {
    private final RequestCommentService requestCommentService;
    private final RequestBoardService requestBoardService;

//    추가
    @PostMapping("/new")
    public String write(@RequestBody RequestCommentVO requestCommentVO){
        requestCommentService.save(requestCommentVO);
        return "write success";
    }

//    전체 조회
    @GetMapping("/list/{requestNumber}")
    public List<RequestCommentDTO> list(@PathVariable("requestNumber") Long requestNumber){
        log.info("여기 들어옴");
        System.out.println("4");
        return requestBoardService.showComment(requestNumber);
    }

//    수정
//    @PatchMapping(value = "/{rno}")
//    public void modify(@RequestBody RequestCommentVO requestCommentVO, @PathVariable("rno") Long requestNumber){
//        requestCommentVO.setRequestCommentNumber(requestNumber);
//        requestCommentService.modify(requestCommentVO);
//    }
    @PostMapping("/modify")
    public void modify(@RequestBody RequestCommentVO requestCommentVO){
        requestCommentService.modify(requestCommentVO);
    }

//    댓글 삭제
    @DeleteMapping("/{requestCommentNumber}")
    public void remove(@PathVariable Long requestCommentNumber){
        requestCommentService.remove(requestCommentNumber);
    }

//    댓글 1개 조회
    @GetMapping("/{requestCommentNumber}")
    public RequestCommentDTO show(@PathVariable Long requestCommentNumber){
        return requestCommentService.showOne(requestCommentNumber);
    }

}
