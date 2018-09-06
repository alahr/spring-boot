package com.alahr.springboot.person.mapper;

import com.alahr.springboot.person.dto.Person;
import org.apache.ibatis.annotations.*;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface PersonMapper {
    @Select("select * from person")
    List<Person> findAll();

    @Select("select * from person where id = #{id}")
    Person getById(@Param("id") BigInteger id);

    @Insert("insert into person " +
            "(name, birthday, gender, address) " +
            "values " +
            "(#{name}, #{birthday}, #{gender}, #{address})")
    int add(Person p);

    @Update("update person set " +
                "name=#{name}, birthday=#{birthday}, " +
                "gender=#{gender}, address=#{address} " +
            "where id=#{id}")
    int update(Person p);

    @Delete("delete from person where id = #{id}")
    int removeById(@Param("id") BigInteger id);
}
