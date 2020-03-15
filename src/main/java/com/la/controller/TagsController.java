package com.la.controller;

import com.la.common.ResponseResult;
import com.la.model.vo.TagInfo;
import com.la.services.ITagsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author amen
 * @date 2020/3/13 2:28 下午
 */
@Slf4j
@RestController
@RequestMapping("/tags")
public class TagsController {

    @Autowired
    private ITagsService tagsService;

    @GetMapping("/list")
    public ResponseResult list(long parentId) {
        return ResponseResult.success(tagsService.list(parentId));
    }

    @PostMapping
    public ResponseResult create(@Validated TagInfo tagInfo) {
        return ResponseResult.success(tagsService.saveOrUpdate(tagInfo));
    }

    @GetMapping("/del")
    public ResponseResult delete(@Validated Long id) {
        tagsService.delete(id);
        return ResponseResult.success();
    }
}
