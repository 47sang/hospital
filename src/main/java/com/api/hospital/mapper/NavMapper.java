package com.api.hospital.mapper;

import com.api.hospital.model.entity.Nav;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NavMapper {

    /**
     * 添加一条导航信息
     * @param nav 导航对象
     * @return int 1成功 0失败
     */
    @Options(useGeneratedKeys = true, keyProperty = "nav_id", keyColumn = "nav_id")
    @Insert("insert into nav(nav_title,nav_icon,nav_type,nav_url,nav_sort,nav_status) values(#{nav_title},#{nav_icon}," +
            "#{nav_type},#{nav_url},#{nav_sort},#{nav_status})")
    int addNav(Nav nav);

    /**
     * 根据导航id删除一条导航信息
     * @param nav_id 导航id
     * @return int 1成功 0失败
     */
    @Delete("delete from nav where nav_id=#{nav_id}")
    int deleteNav(Integer nav_id);

    /**
     * 根据导航id更新一条导航信息
     * @param nav 导航对象
     * @return int 1成功 0失败
     */
    @Update("update nav set nav_title=#{nav_title},nav_icon=#{nav_icon},nav_type=#{nav_type},nav_url=#{nav_url}," +
            "nav_sort=#{nav_sort},nav_status=#{nav_status} where nav_id=#{nav_id}")
    int updateNav(Nav nav);

    /**
     * 根据导航id查询一条导航信息
     * @param nav_id 导航id
     * @return Nav 导航对象
     */
    @Select("select * from nav where nav_id=#{nav_id}")
    Nav findNavById(Integer nav_id);

    /**
     * 根据导航名称查询一条导航信息
     * @param nav_title 导航标题
     * @return Nav 导航对象
     */
    @Select("select * from nav where nav_title=#{nav_title}")
    Nav findNavByTitle(String nav_title);

    /**
     * 根据导航类型查询所有导航信息
     * @param nav_type 导航类型
     * @return List<Nav> 导航对象集合
     */
    @Select("select * from nav where nav_type=#{nav_type} order by nav_sort desc")
    List<Nav> findNavByType(String nav_type);

    /**
     * 获取所有导航信息
     * @return List<Nav> 导航对象集合
     */
    @Select("select * from nav")
    List<Nav> findNavAll();
}
