复刻太和县医院API
===============

# 数据库表设计

## 患者信息表[patient]

字段|注释|类型(长度)|默认值|主键|允许为空|自增|
--|--|--|--|--|--|--|
patient_id | 患者id | int(11) | NO   | PRI | NULL    | auto_increment |
patient_name | 患者名称 | varchar(20) | NO   |     | NULL    |                |
patient_card_id | 患者身份证号 | varchar(18) | NO   |     | NULL    |                |
patient_born_date | 患者出生日期 | int(11) | NO   |     | NULL    |                |
patient_sex | 患者性别 | enum('男','女') | NO   |     | NULL    |                |
patient_phone | 患者手机 | int(11) | NO   |     | NULL    |                |

## 医生信息表[doctor]

字段|注释|类型(长度)|默认值|主键|允许为空|自增|
--|--|--|--|--|--|--|
doctor_id | 医生id | int(11) | NO   | PRI | NULL    | auto_increment |
doctor_name | 医生姓名 | varchar(255) | NO   |     | NULL    |             |
doctor_title | 医生职称 | varchar(255) | NO   |     | NULL    |             |
doctor_hospital | 医生医院 | varchar(255) | NO   |     | NULL    |             |
doctor_department | 医生科 | varchar(255) | NO   |     | NULL    |             |
doctor_introduction | 医生介绍 | varchar(255) | NO   |     | NULL    |             |
doctor_avatar | 医生头像 | varchar(255) | NO   |     | NULL    |             |
doctor_hosp_id | 医生医院编号 | int(11) | NO   |     | NULL    |             |
doctor_dep_id | 医生部门编号 | int(11) | NO   |     | NULL    |             |
doctor_hosp_name | 医生医院名称 | varchar(255) | NO   |     | NULL    |             |
doctor_dep_name | 医生部门名称 | varchar(255) | NO   |     | NULL    |             |
doctor_hosp_level | 医院级别 | int(11) | NO   |     | NULL    |             |
doctor_dep_level | 部门级别 | int(11) | NO   |     | NULL    |             |
doctor_hosp_level_name | 医院级别名称 | varchar(255) | NO   |     | NULL    |             |
doctor_dep_level_name | 部门级别名称 | varchar(255) | NO   |     | NULL    |             |

## 导航表[nav]

字段|注释|类型(长度)|默认值|主键|允许为空|自增|
--|--|--|--|--|--|--|
nav_id | 导航id | int(11) | NO   | PRI | NULL    | auto_increment |
nav_title | 导航标题 | varchar(255) | NO   |     | NULL    |             |
nav_icon | 导航图标地址 | varchar(255) | NO   |     | NULL    |             |
nav_type | 导航分类 | varchar(255) | NO   |     | NULL    |             |
nav_url | 导航链接 | varchar(255) | NO   |     | NULL    |             |
nav_sort | 导航排序 | int(11) | NO   |     | NULL    |             |
nav_status | 导航状态 | enum('启用','禁用') | NO   |     | NULL    |             |

## 健康圈文章表[article]

字段|注释|类型(长度)|默认值|主键|允许为空|自增|
--|--|--|--|--|--|--|
article_id | 文章id | int(11) | NO   | PRI | NULL    | auto_increment |
article_datetime | 发布时间 | datetime(8) | NO   |     | NULL    |             |
article_title | 文章标题 | varchar(255) | NO   |     | NULL    |             |
article_content | 文章内容 | varchar(255) | NO   |     | NULL    |             |
article_doctor_id | 医生id | int(11) | NO   |  FK  | NULL    |             |
article_赞 | 赞数 | int(11) | NO   |    | NULL    |             |
article_views | 阅读数 | int(11) | NO   |    | NULL    |             |
article_comments | 评论数 | int(11) | NO   |    | NULL    |             |


## 健康圈文章评论表[article_comment]

字段|注释|类型(长度)|默认值|主键|允许为空|自增|
--|--|--|--|--|--|--|
comment_id | 评论id | int(11) | NO   | PRI | NULL    | auto_increment |
article_id | 文章id | int(11) | NO   | FK | NULL    |  |
comment_content | 评论内容 | varchar(255) | NO   |     | NULL    |             |
comment_datetime | 评论时间 | datetime(8) | NO   |     | NULL    |             |

## 门诊缴费记录表[pay]

字段|注释|类型(长度)|默认值|主键|允许为空|自增|
--|--|--|--|--|--|--|
pay_id | 缴费id | int(11) | NO   | PRI | NULL    | auto_increment |
pay_datetime | 缴费时间 | datetime(255) | NO   |     | NULL    |             |
pay_money | 缴费金额 | float(11) | NO   |     | NULL    |             |
pay_type | 缴费类型 | varchar(255) | NO   |     | NULL    |             |
pay_status | 缴费状态 | varchar(255) | NO   |     | NULL    |             |
patient_id | 缴费患者id | int(11) | NO   |   FK  | NULL    |             |

## 

