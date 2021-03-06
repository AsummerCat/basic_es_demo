package top.linjingc.basic_es_demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Document(indexName = "supplier_index", type = "supplier")
public class Supplier implements Serializable {
    @Id   //映射id
    private String id;
    @Field(type = FieldType.Keyword)   //映射字段，可以指定分词
    private String name;
    @Field(type = FieldType.Keyword)
    private String leader;
    @Field(type = FieldType.Keyword)
    private String phone;
    @Field(type = FieldType.Date)
    private Date create_date;
}