package com.Netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFactory;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author 吴喜华
 * @version 1.0
 * @date 2022/5/9 20:00
 */

//netty服务器
public class WebSockerServer {

  private EventLoopGroup mainGroup;
  private EventLoopGroup workerGroup;
  private ServerBootstrap server;
  private ChannelFuture future;

  public void start(){
     future = server.bind(9000);

  }
  public WebSockerServer(){
      mainGroup = new NioEventLoopGroup();
      workerGroup = new NioEventLoopGroup();
      server = new ServerBootstrap();
      server.group(mainGroup,workerGroup)
              .channel(NioServerSocketChannel.class)
              .childHandler(new WebSockerChannel());

  }


}
