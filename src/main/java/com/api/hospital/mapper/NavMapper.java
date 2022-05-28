package com.api.hospital.mapper;

import com.api.hospital.model.entity.Nav;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NavMapper {
    /*
    private Integer nav_id;
    private String nav_title;
    private String nav_icon;
    private String nav_type;
    private String nav_url;
    private Integer nav_sort;
    private enum nav_status
     */
    @Options(useGeneratedKeys = true, keyProperty = "nav_id", keyColumn = "nav_id")
    @Insert("insert into nav(nav_title,nav_icon,nav_type,nav_url,nav_sort,nav_status) values(#{nav_title},#{nav_icon}," +
            "#{nav_type},#{nav_url},#{nav_sort},#{nav_status})")
    int addNav(Nav nav);

    @Delete("delete from nav where nav_id=#{nav_id}")
    int deleteNav(Integer nav_id);

    @Update("update nav set nav_title=#{nav_title},nav_icon=#{nav_icon},nav_type=#{nav_type},nav_url=#{nav_url}," +
            "nav_sort=#{nav_sort},nav_status=#{nav_status} where nav_id=#{nav_id}")
    int updateNav(Nav nav);

    @Select("select * from nav where nav_id=#{nav_id}")
    Nav findNavById(Integer nav_id);

    @Select("select * from nav where nav_type=#{nav_type} order by nav_sort desc")
    List<Nav> findNavByType(String nav_type);

    @Select("select * from nav")
    List<Nav> findNavAll();
}
