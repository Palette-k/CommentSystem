package com.gdufe.cs.works.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gdufe.cs.dto.CommentDTO;
import com.gdufe.cs.entities.Comment;
import com.gdufe.cs.entities.User;
import com.gdufe.cs.works.enums.CommentTypeEnum;
import com.gdufe.cs.enums.NotificationTypeEnum;

import java.util.List;

/**
 * @Author: wzq
 * @Description: TODO
 * @DateTime: 2022/3/15 16:02
 **/
public interface CommentService extends IService<Comment> {
    public void insert(Comment comment, Long userId); //插入评论
    public List<CommentDTO> listByTargetId(Long id, CommentTypeEnum type); //罗列评论
    public boolean createNotify(Comment comment, Long receiver, String notifierName, String outerTitle, NotificationTypeEnum notificationType, Long commentId);

    boolean deleteComment(Long commentId);


}
