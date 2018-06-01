package com.tuyoo.hqlcenter.task;

import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.quartz.*;
import org.springframework.stereotype.Component;

@Configuration
@Component
@EnableScheduling
public class HelloTask {

    public void sayHello() {
        System.out.println(" hello world");
    }

    @Bean("jobDetail")
    public MethodInvokingJobDetailFactoryBean detailFactoryBean(HelloTask task) {
        MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();
        jobDetail.setConcurrent(true);
        jobDetail.setTargetObject(task);
        jobDetail.setTargetMethod("sayHello");
        return jobDetail;
    }

//    @Bean("simpleTrigger")
//    public SimpleTriggerFactoryBean simpleTriggerFactoryBean (JobDetailFactoryBean jobDetail) {
//        SimpleTriggerFactoryBean simpleTriggerFactoryBean = new SimpleTriggerFactoryBean();
//        simpleTriggerFactoryBean.setJobDetail(jobDetail.getObject());
//        simpleTriggerFactoryBean.setStartDelay(0);
//        simpleTriggerFactoryBean.setRepeatInterval(1000);
//        return simpleTriggerFactoryBean;
//    }

    @Bean("cronJobTrigger")
    public CronTriggerFactoryBean cronJobTrigger(MethodInvokingJobDetailFactoryBean jobDetai) {
        CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
        trigger.setJobDetail(jobDetai.getObject());
        trigger.setCronExpression("*/10 * * * * ?");
        return trigger;
    }

    @Bean("scheduler")
    public SchedulerFactoryBean schedulerFactoryBean(Trigger cronJobTrigger) {
        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        bean.setOverwriteExistingJobs(true);
        bean.setStartupDelay(1);
        bean.setTriggers(cronJobTrigger);
        return bean;
    }
}
