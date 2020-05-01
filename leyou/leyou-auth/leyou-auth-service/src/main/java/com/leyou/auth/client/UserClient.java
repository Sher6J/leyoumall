package com.leyou.auth.client;

import com.leyou.user.api.UserApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author sher6j
 * @create 2020-05-01-17:30
 */
@FeignClient("user-service")
public interface UserClient extends UserApi {
}
