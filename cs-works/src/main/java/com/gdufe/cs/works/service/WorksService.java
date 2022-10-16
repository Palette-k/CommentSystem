package com.gdufe.cs.works.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gdufe.cs.dto.IndexDTO;
import com.gdufe.cs.dto.ProducerDTO;
import com.gdufe.cs.dto.SearchParamDTO;
import com.gdufe.cs.dto.WorksDTO;
import com.gdufe.cs.entities.Producer;
import com.gdufe.cs.entities.Works;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @Author: wzq
 * @Description: TODO
 * @DateTime: 2022/3/15 17:39
 **/
public interface WorksService extends IService<Works> {

    //public int saveWorksList(Works works, Producer producer);

    public IndexDTO indexPage(Integer pageCurrent, Integer pageSize) throws ExecutionException, InterruptedException;



  //  public List<Works> selectRelated(WorksDTO worksDTO);

  //  List<Works> selectWorksByTagId(long tagId,Integer pageCurrent,Integer pageSize);


    SearchParamDTO showSearchParam(Long catelogId) throws ExecutionException, InterruptedException;

    WorksDTO showTargetWorks(Long id) throws ExecutionException, InterruptedException;

}