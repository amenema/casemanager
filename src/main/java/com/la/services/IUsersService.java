package com.la.services;


import com.la.entitys.Tags;
import com.la.entitys.Users;
import com.la.model.vo.TagInfo;
import com.la.model.vo.UsersInfo;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author amen
 * @date 2020/3/13 11:26 上午
 */
public interface IUsersService {
    /**
     *
     * @param type
     * @return
     */
    List<Users> list(UsersInfo info, Pageable pageable);


    Users detail(long id);


    /**
     *
     * @param tagInfo
     * @return
     */
    UsersInfo saveOrUpdate(UsersInfo usersInfo);

    /**
     *
     * @param id
     */
    void delete(Long id);


}
