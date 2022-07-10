package com.Netty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author 吴喜华
 * @version 1.0
 * @date 2022/5/9 20:35
 */

//启动spring时启动netty服务
@Component
public class NettyListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private WebSockerServer webSockerServer;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
            if(contextRefreshedEvent.getApplicationContext().getParent() == null){
                   webSockerServer.start();
            }
    }
}
