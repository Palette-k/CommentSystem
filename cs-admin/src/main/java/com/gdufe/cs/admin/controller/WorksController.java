package com.gdufe.cs.admin.controller;

import com.gdufe.cs.admin.dto.AdminTagDTO;
import com.gdufe.cs.admin.dto.AdminWorksDTO;
import com.gdufe.cs.admin.mapper.WorkscategoryMapper;
import com.gdufe.cs.admin.service.WorksService;
import com.gdufe.cs.admin.service.WorkscategoryService;
import com.gdufe.cs.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author: wzq
 * @Description: TODO
 * @DateTime: 2022/4/5 14:17
 **/
@RestController
@RequestMapping("/admin/works")
public class WorksController {
    @Autowired
    private WorksService worksService;


    @Autowired
    private WorkscategoryService workscategoryService;

    private Long workscateId = null;

    @PostMapping("/insert")
    public CommonResult insertWorks(@RequestBody AdminWorksDTO adminWorksDTO){

        adminWorksDTO.setWorkscateId(workscateId);
        int b = worksService.saveWorksList(adminWorksDTO);
        if(b == 1){
            return new CommonResult(200,"插入作品数据成功");
        }
        return new CommonResult(400,"插入作品数据失败");
    }

    @PostMapping("/selectTag")
    public CommonResult selectTag(@RequestParam String tagName){


        AdminTagDTO adminTagDTO = worksService.selectTag(tagName);


        if(adminTagDTO != null){
            return new CommonResult(200,"查询标签成功",adminTagDTO);
        }
        return new CommonResult(400,"查询标签失败");
    }

    @PostMapping("/selectWorksCate")
    public CommonResult selectWorksCate(@RequestParam String WorkscateName){

        workscateId = workscategoryService.selectIdByName(WorkscateName);

        if(workscateId != null){
            return new CommonResult(200,"查询作品形式成功");
        }

        return new CommonResult(400,"查询作品形式失败");

    }

}
