package com.leyou.item.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author sher6j
 * @create 2020-04-23-21:23
 */
@RequestMapping("category")
public interface CategoryApi {
    /**
     * 根据Id查询名称
     * @param ids
     * @return
     */
    @GetMapping
    public List<String> queryNameByIds(@RequestParam("ids")List<Long> ids);
}
