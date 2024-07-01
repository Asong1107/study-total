package com.asong.nacos;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;

public class FirstBeanPOJO implements BeanNameAware, BeanFactoryAware {
    @Override
    public void setBeanName(String s) {

    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

    }
}
