package top.linjingc.basic_es_demo;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface SupplierRepository  extends ElasticsearchRepository<Supplier,String> {

    //类似JPA的写法
    //如果需要自定义基本的查询在这里书写
    //根据name查询
    List<Supplier> findByName(String keyWord);
    //根据name和leader查询
    List<Supplier> findByNameAndLeader(String key1,String key2);
    List<Supplier> findByNameOrLeader(String key1,String key2);
}