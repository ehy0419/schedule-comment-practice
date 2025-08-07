package com.schedulecommentpractice.controller;

import com.schedulecommentpractice.dto.CommentSaveRequest;
import com.schedulecommentpractice.dto.CommentSaveResponse;
import com.schedulecommentpractice.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/schedules/{schedulesId}/comments")
    public ResponseEntity<CommentSaveResponse> saveComment(
            @PathVariable long schedulesId,
            @RequestBody CommentSaveRequest request
    ){
        return ResponseEntity.ok(commentService.save(schedulesId, request));
    }
}
