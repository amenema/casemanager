package com.la.common.encrypt;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;

/**
 * @author amen
 * @date 2020/3/12 11:03 下午
 */
@Slf4j
@Component
public class EncryptionBeanPostProcessor implements BeanPostProcessor {

    @Autowired
    private EncryptionListener encryptionListener;



    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof EntityManagerFactory) {
            HibernateEntityManagerFactory hibernateEntityManagerFactory = (HibernateEntityManagerFactory) bean;
            SessionFactoryImpl sessionFactoryImpl = (SessionFactoryImpl) hibernateEntityManagerFactory.getSessionFactory();
            EventListenerRegistry registry = sessionFactoryImpl.getServiceRegistry().getService(EventListenerRegistry.class);
            registry.appendListeners(EventType.POST_LOAD, encryptionListener);
            registry.appendListeners(EventType.PRE_INSERT, encryptionListener);
            registry.appendListeners(EventType.PRE_UPDATE, encryptionListener);
            log.info("Encryption has been successfully set up");
        }
        return bean;
    }
}
