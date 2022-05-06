package com.gdufe.cs.vo;


import com.gdufe.cs.es.esModel;
import lombok.Data;

import java.util.List;

/**
 * @Author: wzq
 * @Description: TODO
 * @DateTime: 2022/4/10 21:07
 **/
@Data
public class SearchResult {

    //查询到的所有作品信息
    private List<esModel> worksList;


    /*
    * 分页信息
    * */
    private Integer pageNum; //当前页码
    private Long total; //总数
    private Integer totalPages;//总页数


    private List<workscatelogVo> workscatelogVos; //作品形式
    private List<tagcatelogVo> tagcatelogVos; //分类信息
    private List<String> country;
    private List<String> createTime;

    @Data
    public static class tagcatelogVo{
        private Long tagId;
        private String tagName;
    }

    @Data
    public static class workscatelogVo{
        private Long workscateId;
        private String workscateName;
    }

}