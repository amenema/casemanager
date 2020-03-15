package com.la.common.encrypt;

import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.reflect.Field;

/**
 * @author amen
 * @date 2020/3/12 4:19 下午
 */
public class EncryptUtils {

    public static boolean needEncode(Field field) {
        return AnnotationUtils.findAnnotation(field, EncryptColumn.class) != null;
    }

    public static String encode(String value) {
        if (StringUtils.isBlank(value)){
            return value;
        }
        return Base64.encodeBase64String(value.getBytes());
    }

    public static String decode(String value){
        if (StringUtils.isBlank(value)){
            return value;
        }
        return Base64.encodeBase64String(value.getBytes());
    }


    public static int getPropertyIndex(String name, String[] properties) {
        for (int i = 0; i < properties.length; i++) {
            if (name.equals(properties[i])) {
                return i;
            }
        }
            throw new IllegalArgumentException("No property was found for name " + name);
    }

}
