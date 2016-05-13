package com.test.dbexpand.jpa.parameter;

import javax.persistence.Query;
import java.io.Serializable;

public class Predicate implements Serializable {

    /**
     * 字段名
     */
    private String key;
    /**
     * 连接串 = > < in ....
     */
    private LinkEnum link = LinkEnum.EQ;
    /**
     * 值
     */
    private Object value;

    /**
     * 默认是 like
     */
    public Predicate(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public Predicate(String key, Object value, LinkEnum link) {
        this.key = key;
        this.value = value;
        this.link = link;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public LinkEnum getLink() {
        return link;
    }

    public void setLink(LinkEnum link) {
        this.link = link;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String toCondition(String index){
        return link.toCondition(key,index);
    }

    public void setParameter(Query query,String index){
        link.setParameter(this,query,index);
    }


}
