package com.Netty;

import com.alibaba.fastjson.JSON;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @author 吴喜华
 * @version 1.0
 * @date 2022/5/9 20:17
 */
// 通道处理器
public class ChatHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    private static ChannelGroup clients = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);


    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame msg) throws Exception {

        String text = msg.text();

        //处理消息

    }


    // 当有新的客户连接到服务器后，会自动创建新的Channel，调用该方法
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
      clients.add(ctx.channel());

    }


    // 当连接出现异常时调用
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {


        ctx.channel().close();
    }
   //当连接断开是调用
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {

    }
}


























