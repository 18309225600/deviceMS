# deviceMS
面向企业的办公设备管理系统


1．设计并开发一个面向企业的办公设备管理系统，
角色分为：企业员工、设备管理人员及系统管理人员。
企业员工拥有的权限有设备、维修设备、报废设备、报失设备查询等功能；
设备管理人员可以增加、维修、报废、报失申请设备管理，设备采购管理等；
系统管理人员可以进行用户管理、日志管理、权限管理等管理。

2．系统应满足实用性、安全性、灵活性、容错性和稳定性等非功能需求。


setup:
    1.将doc中的sql执行
    2.修改配置文件中的数据库连接信息
    3.修改邮箱信息
    4.设置运行环境  spring.profiles.active=dev   or    spring.profiles.active=test    or    spring.profiles.active=prod
    5.device-facade下面运行App