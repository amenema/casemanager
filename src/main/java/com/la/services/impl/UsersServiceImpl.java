package com.la.services.impl;

import com.la.entitys.Tags;
import com.la.entitys.Users;
import com.la.model.spec.UsersSpec;
import com.la.model.vo.TagInfo;
import com.la.model.vo.UsersInfo;
import com.la.repository.ITagsRepository;
import com.la.repository.IUsersRepository;
import com.la.services.IUsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author amen
 * @date 2020/3/13 11:28 上午
 */

@Slf4j
@Service
public class UsersServiceImpl implements IUsersService {

    @Autowired
    private IUsersRepository usersRepository;

    @Override
    public List<Users> list(UsersInfo info, Pageable pageable) {

        return usersRepository.search(new UsersSpec(info), pageable);
    }

    @Override
    public Users detail(long id) {
        return usersRepository.findOne(id);
    }

    @Override
    public UsersInfo saveOrUpdate(UsersInfo usersInfo) {
        Users users = new Users();
        BeanUtils.copyProperties(usersInfo, users);
        usersRepository.save(users);
        return usersInfo;
    }

    @Override
    public void delete(Long id) {
        usersRepository.deleteById(id);
    }
}
