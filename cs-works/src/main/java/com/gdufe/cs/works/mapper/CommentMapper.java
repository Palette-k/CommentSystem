package com.gdufe.cs.works.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gdufe.cs.entities.Comment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: wzq
 * @Description: TODO
 * @DateTime: 2022/3/15 16:04
 **/
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
    int incCommentCount(Comment record); //增加评论数
    int incLikeCount(Comment record); //增加点赞数

    int decCommentCount(Comment parentComment);

}
