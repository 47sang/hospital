package com.api.hospital.mapper;

import com.api.hospital.model.entity.Article;
import com.api.hospital.model.vo.Health;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleMapper {
    /**
     * 根据文章id查询文章
     * @param article_id 文章id
     * @return Article 文章对象
     */
    @Select("select * from article where article_id = #{article_id}")
    Article getArticleById(int article_id);

    /**
     * 根据文章id删除一条文章
     * @param articleId 文章id
     * @return int 1成功 0失败
     */
    @Delete("delete from article where article_id = #{articleId}")
    int deleteArticleById(int articleId);

    /**
     * 根据文章id更新文章信息
     * @param article 文章对象
     * @return int 1成功 0失败
     */
    @Update("update article set article_title = #{article_title}, article_keywords = #{article_keywords}," +
            " article_content = #{article_content}, article_pic = #{article_pic} where article_id = #{article_id}")
    int updateArticleById(Article article);

    /**
     * 插入一条文章数据
     * @param article 文章对象
     * @return int 1成功 0失败
     */
    @Options(useGeneratedKeys = true, keyProperty = "article_id", keyColumn = "article_id")
    @Insert("insert into article( article_title, article_keywords, article_content, doctor_id,article_type,article_pic) values(#{article_title}," +
            " #{article_keywords}, #{article_content}, #{doctor_id},#{article_type},#{article_pic})")
    int insertArticle(Article article);

    /**
     * 获取所有的文章列表，根据文章id倒序排列
     * @return List<Article> 文章列表对象
     */
    @Select("select * from article order by article_id desc")
    List<Article> getArticles();

    /**
     * 分页获取文章列表，根据文章id倒序排列
     * @param start 起始位置
     * @param end 每页显示条数
     * @return List<Article> 文章列表对象
     */
    @Select("select * from article order by article_id desc limit #{start},#{end}")
    List<Article> getArticlesByPage(int start, int end);

    /**
     * 根据文章类型，分页获取文章列表，根据文章id倒序排列
     * @param article_type 文章类型
     * @param start 起始位置
     * @param end 每页显示条数
     * @return List<Article> 文章列表对象
     */
    @Select("select * from article where article_type = #{article_type} order by article_id desc limit #{start},#{end}")
    List<Article> getArticlesByPaging(String article_type, int start, int end);

    /**
     * 根据文章类型，获取文章列表，根据文章id倒序排列
     * @param article_type 文章类型
     * @return List<Article> 文章列表对象
     */
    @Select("select * from article where article_type = #{article_type} order by article_id desc")
    List<Article> getArticlesByType(String article_type);

    /**
     * 分页获取文章列表，根据文章id倒序排列
     * @param start 起始位置
     * @param end 每页显示条数
     * @return List<Health> 健康圈文章列表对象
     */
    @Select("select article.article_id,article.article_datetime,article.article_title,article.article_keywords,article.article_content," +
            "article.article_praise,article.article_views,article.doctor_id,doctor.doctor_name,doctor.doctor_avatar from article left join " +
            "doctor on article.doctor_id = doctor.doctor_id order by article.article_id desc limit #{start},#{end}")
    List<Health> getHealth(int start, int end);

    /**
     * 每次访问文章详情页后，阅读数+1
     * @param article_id 文章id
     * @return int 1成功 0失败
     */
    @Update("update article set article_views = article_views + 1 where article_id = #{article_id}")
    int updateArticleViews(int article_id);

    /**
     * 发表评论后，文章评论数+1
     * @param article_id 文章id
     * @return int 1成功 0失败
     */
    @Update("update article set article_comments = article_comments + 1 where article_id = #{article_id}")
    int updateArticleCommentsCount(int article_id);

    /**
     * 删除评论后，文章评论数-1
     * @param article_id 文章id
     * @return int 1成功 0失败
     */
    @Update("update article set article_comments = article_comments - 1 where article_id = #{article_id} and article_comments > 0")
    int updateArticleCommentsCountMinus(int article_id);

    /**
     * 文章点赞后，点赞数+1
     * @param article_id 文章id
     * @return int 1成功 0失败
     */
    @Update("update article set article_praise = article_praise + 1 where article_id = #{article_id}")
    int updateArticlePraise(int article_id);

    /**
     * 取消文章点赞后，点赞数-1
     * @param article_id 文章id
     * @return int 1成功 0失败
     */
    @Update("update article set article_praise = article_praise - 1 where article_id = #{article_id} and article_praise > 0")
    int updateArticlePraiseCancel(int article_id);

}
