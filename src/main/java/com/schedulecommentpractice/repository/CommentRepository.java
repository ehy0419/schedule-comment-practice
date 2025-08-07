package com.schedulecommentpractice.repository;

import com.schedulecommentpractice.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}

