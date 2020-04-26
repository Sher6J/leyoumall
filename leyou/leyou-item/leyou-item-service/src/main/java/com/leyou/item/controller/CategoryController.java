package com.leyou.item.controller;

import com.leyou.item.pojo.Category;
import com.leyou.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author sher6j
 * @create 2020-04-23-21:23
 */
@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 根据父节点的id查询子节点
     * @param pid
     * @return
     */
    @GetMapping("list")
    public ResponseEntity<List<Category>> queryCategoriesByPid(
            @RequestParam(value = "pid", defaultValue = "0")Long pid) {

        if (pid == null || pid < 0) {
            //响应400：参数不合法
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return ResponseEntity.badRequest().build();//上述两种方法的简化写法
        }
        List<Category> categories = this.categoryService.queryCategoriesByPid(pid);
        if (CollectionUtils.isEmpty(categories)) {
            //响应404：资源服务器未找到
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            return ResponseEntity.notFound().build();
        }
        //响应200：查询成功
        return ResponseEntity.ok(categories);

        //响应500：服务器内部错误，程序出错自然会产生500
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

    }

    /**
     * 根据Id查询名称
     * @param ids
     * @return
     */
    @GetMapping
    public ResponseEntity<List<String>> queryNameByIds(@RequestParam("ids")List<Long> ids) {
        List<String> names = this.categoryService.queryNamesByIds(ids);

        if (CollectionUtils.isEmpty(names)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(names);

    }
}
