package com.schedulecommentpractice.service;

import com.schedulecommentpractice.dto.CommentSaveRequest;
import com.schedulecommentpractice.dto.CommentSaveResponse;
import com.schedulecommentpractice.entity.Comment;
import com.schedulecommentpractice.entity.Schedule;
import com.schedulecommentpractice.repository.CommentRepository;
import com.schedulecommentpractice.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    ///  일정이 필요해서
    private final ScheduleRepository scheduleRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public CommentSaveResponse save(long scheduleId, CommentSaveRequest request) {

        if (request.getContent() == null) {
            throw new IllegalStateException("댓글 내용은 필수값입니다.");
        }
        if (request.getContent().length() > 100) {
            throw new IllegalStateException("댓글 내용은 최대 100자입니다.");
        }

        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalArgumentException(scheduleId + "해당 id의 일정이 없습니다.")
        );

        /// 하나의 일정에는 댓글 10개까지 달 수 있다.
        List<Comment> comments = commentRepository.findAll();
        int commentCount = 0;
        for (Comment comment : comments) {
            if (comment.getScheduleId() == scheduleId) {
                commentCount = commentCount + 1;     // 또는 commentCount++;
            }
        }
        if (commentCount >= 10) {
            throw new IllegalStateException("댓글은 최대 10개까지만 작성할 수 있습니다.");
        }

        ///  도전과제의 핵심이었다... /
        Comment comment = new Comment(
                request.getContent(),
                request.getAuthor(),
                request.getPassword(),
                schedule.getId()
        );
        Comment savedComment = commentRepository.save(comment);
        return new CommentSaveResponse(
                savedComment.getId(),
                savedComment.getContent(),
                savedComment.getAuthor(),
                savedComment.getCreatedAt(),
                savedComment.getModifiedAt()
        );
    }
}
