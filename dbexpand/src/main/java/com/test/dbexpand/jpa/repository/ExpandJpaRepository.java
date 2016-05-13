package com.test.dbexpand.jpa.repository;

import com.test.dbexpand.jpa.parameter.Operator;
import com.test.dbexpand.jpa.parameter.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@NoRepositoryBean
public interface ExpandJpaRepository<T, ID extends Serializable> extends JpaRepository<T,ID> {
    /**
     * 按查询条件返回单个对象
     * @param condition 带参数的查询语句
     * @param objects 查询语句参数对应的值
     * @return
     */
    T findOne(String condition, Object... objects);


    /**
     * 按查询条件返回对象列表
     * @param condition 带参数的查询语句
     * @param objects 查询语句参数对应的值
     * @return
     */
    List<T> findAll(String condition, Object... objects);

    /**
     * 按查询条件返回对象列表
     * @param predicates 查询条件集合
     * @param operator 运算方法
     * @return
     */
    List<T> findAll(Iterable<Predicate> predicates, Operator operator);

    /**
     * 按查询条件返回对象列表
     * @param predicates 查询条件集合
     * @param operator 运算方法
     * @param sort 排序对象
     * @return
     */
    List<T> findAll(Iterable<Predicate> predicates, Operator operator, Sort sort);

    /**
     * 按查询条件返回分页对象
     * @param predicates 查询条件集合
     * @param operator 运算方法
     * @param pageable 分页条件对象
     * @return
     */
    Page<T> findAll(Iterable<Predicate> predicates, Operator operator, Pageable pageable);

    long count(Iterable<Predicate> predicates, Operator operator);

    /**
     * 按查询条件返回对象列表
     * @param condition 带参数的查询语句
     * @param sort 排序对象
     * @param objects 查询语句参数对应的值
     * @return
     */
    List<T> findAll(String condition, Sort sort, Object... objects);

    /**
     * 按查询条件返回分页对象
     * @param condition 带参数的查询语句
     * @param pageable 分页条件对象
     * @param objects 查询语句参数对应的值
     * @return
     */
    Page<T> findAll(String condition, Pageable pageable, Object... objects);


    long count(String condition, Object... objects);


    /**
     * 通过ID的集合删除条目
     * @param ids
     */
    void deleteByIds(Iterable<ID> ids);

    /**
     * 获取当前DAO对应的实体模型
     * @return
     */
    Class<T> getEntityClass();

    /**
     * 通过一个sql 获取 一个list<map> 结果集
     * @param sql
     * @return
     */
    List<Map<String,Object>> nativeQuery4Map(String sql);

    /**
     * 通过一个sql 获取 一个list<map> 结果集
     * @param sql sql 语句
     * @param pageable 分页对象
     * @return
     */
    Page<Map> nativeQuery4Map(String sql, Pageable pageable);

    /**
     * 通过一个sql 查询一个值  比如: max count min等
     * @param sql
     * @return
     */
    Object nativeQuery4Object(String sql);
}
