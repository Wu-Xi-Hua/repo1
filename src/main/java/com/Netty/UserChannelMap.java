package com.Netty;

import io.netty.channel.Channel;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author 吴喜华
 * @version 1.0
 * @date 2022/5/9 20:43
 */
public class UserChannelMap {

    private  static Map<String , Channel> map;

    {
        map  = new HashMap<String,Channel>();
    }

    public static Map<String, Channel> getMap() {
        return map;
    }

    public static void setMap(Map<String, Channel> map) {
        UserChannelMap.map = map;
    }

    public  static  void put(String userid ,Channel channel){
          map.put(userid,channel);

    }
    public static  void remove(String userid){
         map.remove(userid);
    }
    public  static  Channel push(String userid){
         return  map.get(userid);
    }
    public static void removeByChannel(String channelid){
         if(!StringUtils.isNotBlank(channelid)){
                   return ;
         }
        for (String s : map.keySet()) {
            Channel channel = map.get(s);
            if(channelid.equals(channel.id().asLongText())){
                 map.remove(s);
                 break;
            }
        }

    }


}
