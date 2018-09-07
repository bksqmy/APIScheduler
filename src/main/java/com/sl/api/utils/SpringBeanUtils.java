package com.sl.api.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * bean工具类
 *  gaoxueyong
 */
@Component
public class SpringBeanUtils  implements ApplicationContextAware {

    private static ApplicationContext context;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    //根据bean name 获取实例

    public static Object getBeanByName(String beanName) {

        if (beanName == null || context == null) {

            return null;

        }

        return context.getBean(beanName);

    }

    //只适合一个class只被定义一次的bean（也就是说，根据class不能匹配出多个该class的实例）

    public static Object getBeanByType(Class clazz) {

        if (clazz == null || context == null) {

            return null;

        }

        return context.getBean(clazz);

    }
}
