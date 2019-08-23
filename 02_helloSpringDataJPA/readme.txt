使用Spring Data JPA，需要整合Spring与Spring Data JPA，并且需要提供JPA的服务提供者hibernate，所以需要导入spring相关坐标，hibernate坐标，数据库驱动坐标等

过程：
1.导入依赖
2.配置spring的配置文件
3.编写dao接口，继承JpaRepository、JpaSpecificationExecutor
4.定义测试类调用接口


有时候莫名其妙的出现问题可能是由于包冲突引起的：
例如这里将hibernate的版本从5.0.7.Final改为5.4.1.Final就会出现问题

























