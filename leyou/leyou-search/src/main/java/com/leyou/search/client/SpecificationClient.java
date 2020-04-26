package com.leyou.search.client;

import com.leyou.item.api.SpecificationApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author sher6j
 * @create 2020-04-26-16:52
 */
@FeignClient("item-service")
public interface SpecificationClient extends SpecificationApi {
}
