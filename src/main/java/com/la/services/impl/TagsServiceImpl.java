package com.la.services.impl;

import com.la.entitys.Tags;
import com.la.model.vo.TagInfo;
import com.la.repository.ITagsRepository;
import com.la.services.ITagsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author amen
 * @date 2020/3/13 11:28 上午
 */

@Slf4j
@Service
public class TagsServiceImpl  implements ITagsService {

    @Autowired
    private ITagsRepository tagsRepository;

    @Override
    public List<Tags> list(Long parentId) {
        if (parentId == null || parentId == 0){
            return tagsRepository.list();
        }
        return tagsRepository.subList(parentId);
    }

    @Override
    public TagInfo saveOrUpdate(TagInfo tagInfo) {
        Tags tags = new Tags();
        BeanUtils.copyProperties(tagInfo, tags);
        tagsRepository.save(tags);
        return tagInfo;
    }

    @Override
    public void delete(Long id) {
        tagsRepository.deleteById(id);
    }
}
