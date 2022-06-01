复刻太和县医院API
===============

# swagger接口文档

本地运行后，自动部署接口文档访问地址：[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

# 功能实现

小程序接口：

```text
|_WxHome：首页✔
   |__demand：搜索（未实现）
   |__demand：门诊挂号（未实现）
   |__demand：在线问诊（未实现）
   |__navs：顶部导航✔
   |__headlines：最头条✔
   |__banners：banner轮播图✔
   |__general：综合服务✔
   |__departments：科室导航✔
   |__healthPush：健康推送✔
|_WxHealth：健康圈✔
   |__demand：搜索（未实现）
   |__demand：问答社区（未实现）
   |__demand：健康咨询（未实现）
   |__health：文章列表✔
|_WxDisease：慢病管理（未实现）
   |__demand：患者信息（未实现）
   |__demand：工具导航（未实现）
   |__demand：慢病常识（未实现）
   |__demand：体征监测（未实现）
|_WxMine：我的（未实现）
   |__demand：患者信息（未实现）
   |__demand：账户信息、收藏、提问（未实现）
   |__demand：功能按钮（未实现）
   |__demand：门诊住院（未实现）
   |__demand：其他服务（未实现）
```

后端功能接口：

```text
|_patient：患者信息✔
|_doctor：医生信息✔
|_department：科室部门管理✔
|_clinic：科室门诊管理✔
|_nav：导航管理✔
|_article：文章管理✔
|_article_comment：文章评论管理✔
|_praise：文章点赞记录管理✔
|_collect：个人文章收藏管理✔
|_pay：缴费记录✔
|_reservation：预约信息记录（未实现）
```


# 目录结构

```text
|_annotation：放置项目自定义注解
|_aspect：放置切面代码
|_config：放置配置类
|_constant：放置常量、枚举等定义
   |__consist：存放常量定义
   |__enums：存放枚举定义
|_controller：放置控制器代码
|_filter：放置一些过滤、拦截相关的代码
|_mapper：放置数据访问层代码接口
|_model：放置数据模型代码
   |__entity：放置数据库实体对象定义
   |__dto：存放数据传输对象定义
   |__vo：存放显示层对象定义
|_service：放置具体的业务逻辑代码（接口和实现分离）
   |__intf：存放业务逻辑接口定义
   |__impl：存放业务逻辑实际实现
|_utils：放置工具类和辅助代码
```

# 数据库表设计

## 患者信息表[patient]

字段|注释|类型(长度)|允许为空|主键|默认值|自增|
--|--|--|--|--|--|--|
patient_id | 患者id | int(11) | NO   | PRI | NULL    | auto_increment |
patient_name | 患者名称 | varchar(20) | NO   |     | NULL    |                |
patient_card_id | 患者身份证号 | varchar(18) | NO   |     | NULL    |                |
patient_born_date | 患者出生日期 | int(11) | NO   |     | NULL    |                |
patient_sex | 患者性别 | enum('男','女') | NO   |     | NULL    |                |
patient_phone | 患者手机 | int(11) | NO   |     | NULL    |                |
patient_medical_card | 患者就诊卡号 | int(10) | NO   |     | NULL    |                |

## 医生信息表[doctor]

字段|注释|类型(长度)|允许为空|主键|默认值|自增|
--|--|--|--|--|--|--|
doctor_id | 医生id | int(11) | NO   | PRI | NULL    | auto_increment |
doctor_name | 医生姓名 | varchar(255) | NO   |     | NULL    |             |
doctor_avatar | 医生头像 | varchar(255) | NO   |     | NULL    |             |
doctor_title | 医生职称 | varchar(255) | NO   |     | NULL    |             |
doctor_specialty | 医生专长 | varchar(255) | NO   |     | NULL    |             |
doctor_resume | 医生履历 | varchar(255) | NO   |     | NULL    |             |
department_id | 科室编号 | int(11) | NO   |   FK  | NULL    |             |
clinic_id | 门诊编号 | int(11) | NO   |   FK  | NULL    |             |

## 科室部门表[department]

字段|注释|类型(长度)|允许为空|主键|默认值|自增|
--|--|--|--|--|--|--|
department_id | 科室编号 | int(11) | NO   |   PK  | NULL    |       auto_increment      |
department_name | 科室名称 | varchar(255) | NO   |     | NULL    |             |

## 科室门诊表[clinic]

字段|注释|类型(长度)|允许为空|主键|默认值|自增|
--|--|--|--|--|--|--|
clinic_id | 门诊编号 | int(11) | NO   |   PK  | NULL    |        auto_increment     |
clinic_name | 门诊名称 | varchar(255) | NO   |     | NULL    |             |           |

## 导航表[nav]

字段|注释|类型(长度)|允许为空|主键|默认值|自增|
--|--|--|--|--|--|--|
nav_id | 导航id | int(11) | NO   | PRI | NULL    | auto_increment |
nav_title | 导航标题 | varchar(255) | NO   |     | NULL    |             |
nav_icon | 导航图标地址 | varchar(255) | NO   |     | NULL    |             |
nav_type | 导航分类 | varchar(255) | NO   |     | NULL    |             |
nav_url | 导航链接 | varchar(255) | NO   |     | NULL    |             |
nav_sort | 导航排序 | int(11) | NO   |     | NULL    |             |
nav_status | 导航状态 | enum('启用','禁用') | NO   |     | NULL    |             |

## 健康圈文章表[article]

字段|注释|类型(长度)|允许为空|主键|默认值|自增|
--|--|--|--|--|--|--|
article_id | 文章id | int(11) | NO   | PRI | NULL    | auto_increment |
article_datetime | 发布时间 | datetime(0) | NO   |     | NULL    | CURRENT_TIMESTAMP |
article_title | 文章标题 | varchar(255) | NO   |     | NULL    |             |
article_keywords | 文章关键词 | varchar(255) | NO   |     | NULL    |             |
article_content | 文章内容 | mediumtext | NO   |     | NULL    |             |
doctor_id | 作者医生id | int(11) | NO   |  FK  | NULL    |             |
article_praise | 赞数 | int(11) | YES   |    | 0    |             |
article_views | 阅读数 | int(11) | YES   |    | 0    |             |
article_comments | 评论数 | int(11) | YES   |    | 0    |             |


## 健康圈文章评论表[article_comment]

字段|注释|类型(长度)|允许为空|主键|默认值|自增|
--|--|--|--|--|--|--|
comment_id | 评论id | int(11) | NO   | PRI | NULL    | auto_increment |
article_id | 文章id | int(11) | NO   | FK | NULL    |  |
patient_id | 患者id | int(11) | NO   | FK | NULL    |  |
comment_content | 评论内容 | varchar(255) | NO   |     | NULL    |             |
comment_datetime | 评论时间 | datetime(8) | NO   |     | NULL    | CURRENT_TIMESTAMP |

## 文章点赞表[praise]

字段|注释|类型(长度)|允许为空|主键|默认值|自增|
--|--|--|--|--|--|--|
article_id | 文章id | int(11) | NO   |  | NULL    |  |
patient_id | 患者id | int(11) | NO   |  | NULL    |  |

## 文章收藏表[collect]

字段|注释|类型(长度)|允许为空|主键|默认值|自增|
--|--|--|--|--|--|--|
collect_id | 收藏id | int(11) | NO   | PRI | NULL    | auto_increment |
article_id | 文章id | int(11) | NO   |  | NULL    |  |
patient_id | 患者id | int(11) | NO   |  | NULL    |  |

## 门诊缴费记录表[pay]

字段|注释|类型(长度)|允许为空|主键|默认值|自增|
--|--|--|--|--|--|--|
pay_id | 缴费id | int(11) | NO   | PRI | NULL    | auto_increment |
pay_datetime | 缴费时间 | datetime(0) | NO   |     | NULL    |             |
pay_money | 缴费金额 | float(11) | NO   |     | NULL    |             |
pay_type | 缴费类型 | varchar(255) | NO   |     | NULL    |             |
pay_status | 缴费状态 | varchar(255) | NO   |     | NULL    |             |
patient_id | 缴费患者id | int(11) | NO   |   FK  | NULL    |             |

## 患者预约表[reservation]

字段|注释|类型(长度)|允许为空|主键|默认值|自增|
--|--|--|--|--|--|--|
patient_id | 患者id | int(11) | NO   | FK | NULL    |  |
doctor_id | 医生id | int(11) | NO   |  FK| NULL    |  |
department_id | 科室编号 | int(11) | NO   | FK | NULL    |  |
clinic_id | 门诊编号 | int(11) | NO   | FK | NULL    |  |
datetime | 预约时间 | datetime(0) | NO   |  | NULL    |  |
