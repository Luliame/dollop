package com.example.dollop.service;

import com.example.dollop.model.dto.CommentDto;

public interface CommentService extends Service<CommentDto> {
    // db.comment.aggregate([{"$group" : {_id:"$userId", count:{$sum:1}}} ])
}
