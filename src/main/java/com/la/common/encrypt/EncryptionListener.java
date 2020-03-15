package com.la.common.encrypt;

import org.hibernate.event.spi.*;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;


/**
 * @author amen
 * @date 2020/3/12 4:12 下午
 */
@Component
public class EncryptionListener implements PreInsertEventListener, PreUpdateEventListener, PostLoadEventListener {
    @Override
    public void onPostLoad(PostLoadEvent event) {
        Object entity = event.getEntity();
        ReflectionUtils.doWithFields(entity.getClass(), field -> loopDecode(entity, field), EncryptUtils::needEncode);
    }

    @Override
    public boolean onPreInsert(PreInsertEvent event) {
        final Object[] state = event.getState();
        Object entity = event.getEntity();
        final String[] propertyNames = event.getPersister().getPropertyNames();
        ReflectionUtils.doWithFields(entity.getClass(), field -> loopEncode(state, propertyNames, field), EncryptUtils::needEncode);
        return false;
    }

    @Override
    public boolean onPreUpdate(PreUpdateEvent event) {
        final Object[] state = event.getState();
        Object entity = event.getEntity();
        final String[] propertyNames = event.getPersister().getPropertyNames();
        ReflectionUtils.doWithFields(entity.getClass(), field -> loopEncode(state, propertyNames, field), EncryptUtils::needEncode);
        return false;
    }


    private static void loopEncode(Object[] state, String[] propertyNames, Field field) {
        int propertyIndex = EncryptUtils.getPropertyIndex(field.getName(), propertyNames);
        Object currentValue = state[propertyIndex];
        if (!(currentValue instanceof String)) {
            throw new IllegalStateException("Encrypted annotation was used on a non-String field");
        }
        state[propertyIndex] = EncryptUtils.encode(currentValue.toString());
    }


    private static void loopDecode(Object entity, Field field) {
        field.setAccessible(true);
        Object encodeValue = ReflectionUtils.getField(field, entity);

        if (!(encodeValue instanceof String)) {
            throw new IllegalStateException("Encrypted annotation was used on a non-String field");
        }
        ReflectionUtils.setField(field, entity, EncryptUtils.decode(encodeValue.toString()));
    }
}

