package com.test.dbexpand.jpa.parameter;

import java.util.ArrayList;
import java.util.List;

public class PredicateBuilder {
    private List<Predicate> predicates = new ArrayList<Predicate>();

    public static PredicateBuilder create(){
        return new PredicateBuilder();
    }

    public PredicateBuilder add(String key,Object value,LinkEnum link){
        predicates.add(new Predicate(key,value,link));
        return this;
    }

    public PredicateBuilder add(String key,Object value){
        predicates.add(new Predicate(key,value));
        return this;
    }
    public List<Predicate> build(){
        return predicates;
    }
}
