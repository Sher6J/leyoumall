package com.leyou.goods.client;

import com.leyou.item.api.GoodsApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author sher6j
 * @create 2020-04-26-16:37
 */
@FeignClient("item-service") //通过Feign远程调用微服务
public interface GoodsClient extends GoodsApi {

}
