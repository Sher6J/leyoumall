package com.leyou.goods.client;

import com.leyou.item.api.BrandApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author sher6j
 * @create 2020-04-26-16:51
 */
@FeignClient("item-service")
public interface BrandClient extends BrandApi {
}
