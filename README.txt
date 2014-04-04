Hibernate demo

包名规则：
com.jamorn.hibernate
                    .annotation         --该包下全是以注解配置
                               .crud    --相关增删改查
                               .entity  --实体类
                    .xml                --该包下全是以xml配置,配置文件位置是 resources/hbm
                               .crud    --相关增删改查
                               .entity  --实体类，和注解包中的实体类完全一样
                    .util               --工具类
                    .extension          --扩展类

表名规则：
（1）以"a_"开头，表示对应的实体类是以注解的形式配置
（2）以"x_"开头，表示对应的实体类是以xml的形式配置

映射关系：
Address  Customer  一对一外键关联双向映射
Boss     Company   一对一连接表关联双向映射