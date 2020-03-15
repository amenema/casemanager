package com.la.controller;

import com.la.common.ResponseResult;
import com.la.model.vo.AttachmentInfo;
import com.la.model.vo.UsersInfo;
import com.la.services.IAttachmentService;
import com.la.services.IUsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author amen
 * @date 2020/3/13 2:28 下午
 */
@Slf4j
@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private IUsersService usersService;

    @GetMapping("/list")
    public ResponseResult list(@RequestBody UsersInfo info) {
        PageRequest pageRequest = new PageRequest(info.getPageNo(), info.getPageSize());
        return ResponseResult.success(usersService.list(info, pageRequest));
    }

    @PostMapping
    public ResponseResult create(@RequestBody UsersInfo info) {
        return ResponseResult.success(usersService.saveOrUpdate(info));
    }

    @GetMapping("/del")
    public ResponseResult delete(@Validated Long id) {
        usersService.delete(id);
        return ResponseResult.success();
    }

    @GetMapping
    public ResponseResult detail(@Validated Long id) {
        return ResponseResult.success(usersService.detail(id));
    }
}
