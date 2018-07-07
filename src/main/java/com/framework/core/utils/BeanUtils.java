package com.framework.core.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>JavaBean工具类。</p>
 *
 * @Author xia_xiaojie
 * @CreateDate 2016/10/21
 * @Version 1.0
 */
public final class BeanUtils extends org.apache.commons.beanutils.BeanUtils {

    /**
     * 将E对象转换成T对象
     */
    public static <E, T> T toBean(E source, Class<T> targetClass) {
        T target = null;
        try {
            target = targetClass.newInstance();
            if (null != source) {
                copyProperties(target, source);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return target;
    }

    /**
     * 将E对象的集合转换成T对象的集合
     */
    public static <E, T> List<T> toList(List<E> sourceList, Class<T> targetClass) {
        List<T> targetList = new ArrayList<>();
        for (E source : sourceList) {
            T target = toBean(source, targetClass);
            targetList.add(target);
        }
        return targetList;
    }

}
