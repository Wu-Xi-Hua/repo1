package com.Netty;


import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.IdleStateHandler;


/**
 * @author 吴喜华
 * @version 1.0
 * @date 2022/5/9 20:08
 */
//配置通道
public class WebSockerChannel extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast(new HttpServerCodec());
        pipeline.addLast(new ChunkedWriteHandler());
        pipeline.addLast(new HttpObjectAggregator(1024*64));

        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));

        pipeline.addLast(new IdleStateHandler(4,6,12));
        pipeline.addLast(new HearBeatHandler());
        pipeline.addLast(new ChatHandler());

    }
}
