package com.octopusthu.dev.samples.spring.boot.task;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.boot.task.ThreadPoolTaskExecutorBuilder;
import org.springframework.stereotype.Component;

@Component
public class ThreadPoolTaskExecutorProvisioner implements BeanDefinitionRegistryPostProcessor {
    private final ThreadPoolTaskExecutorBuilder executorBuilder;

    @Autowired
    public ThreadPoolTaskExecutorProvisioner(ThreadPoolTaskExecutorBuilder executorBuilder) {
        this.executorBuilder = executorBuilder;
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        var executor = executorBuilder
            .corePoolSize(5)
            .maxPoolSize(10)
            .build();
        registry.registerBeanDefinition("", executor);
    }
}
