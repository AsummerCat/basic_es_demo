package top.linjingc.basic_es_demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestEs {
    @Autowired
    private SupplierRepository supplierRepository;

    @Test
    public void test() {

        Supplier supplier1 = new Supplier();
        supplier1.setId("1");
        supplier1.setCreate_date(new Date());
        supplier1.setName("小明");

        //保存
        System.out.println(supplierRepository.save(supplier1));
        System.out.println(supplierRepository.findById("1"));
        //更新
        supplier1.setName("小明啊啊啊啊啊");
        System.out.println(supplierRepository.save(supplier1));
        System.out.println(supplierRepository.findById("1"));
        //删除
        supplierRepository.deleteById("1");
        System.out.println();


        //查询所有
        supplierRepository.findAll().forEach(supplier -> System.out.println(supplier));
        //根据id查询
        System.out.println(supplierRepository.findById("1016"));
        //排序查询
        supplierRepository.findAll(Sort.by(Sort.Order.asc("name"))).forEach(supplier -> System.out.println(supplier));
        //根据name查询
        System.out.println(supplierRepository.findByName("腾讯"));
        //根据name和leader查询
        System.out.println(supplierRepository.findByNameAndLeader("腾讯", "马化腾"));
        //根据name或者leader查询
        System.out.println(supplierRepository.findByNameOrLeader("0001", "马化腾"));
    }
}