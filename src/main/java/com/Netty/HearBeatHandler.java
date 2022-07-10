package com.Netty;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.concurrent.EventExecutorGroup;


/**
 * @author 吴喜华
 * @version 1.0
 * @date 2022/5/9 20:17
 */
//心跳机制
public class HearBeatHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
          if(ctx instanceof IdleStateEvent){
                IdleStateEvent idleStateEvent = (IdleStateEvent)ctx;
                if(idleStateEvent.state() == IdleState.READER_IDLE){
                    System.out.println("读空闲异常");
                }else if(idleStateEvent.state() == IdleState.WRITER_IDLE){

                    System.out.println("写空闲异常");

                }else if(idleStateEvent.state() == IdleState.ALL_IDLE){
                    System.out.println("读写空闲异常");

                    ctx.channel().close();


                }

          }
    }
}
