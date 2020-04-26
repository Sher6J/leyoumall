package com.leyou.item.pojo;

import javax.persistence.*;
import java.util.List;

/**
 * @author sher6j
 * @create 2020-04-25-10:12
 */
@Table(name = "tb_spec_group")
public class SpecGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long cid;

    private String name;

    @Transient //表中没有该字段需要添加此注解
    private List<SpecParam> param;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SpecParam> getParam() {
        return param;
    }

    public void setParam(List<SpecParam> param) {
        this.param = param;
    }
}
