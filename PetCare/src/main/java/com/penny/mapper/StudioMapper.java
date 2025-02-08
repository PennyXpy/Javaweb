package com.penny.mapper;

import com.penny.pojo.Studio;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudioMapper {

    @Select("select * from studio")
    List<Studio> list();

    @Delete("delete  from studio where id = #{id} ")
    void deleteById(Integer id);

    @Insert("insert  into studio(name, create_time, update_time) values (#{name}, #{createTime}, #{updateTime})")
    void insert(Studio studio);

    @Select("SELECT * FROM studio WHERE id = #{id}")
    Studio getById(Integer id);

    @Update("UPDATE studio SET name = #{name} WHERE id = #{id}")
    void updateStudio(Studio studio);
}
