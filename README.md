# generator-okra
基于Yeoman的工程脚手架

### FUNCTION 
* 基于mybatis plus的kotlin代码生成器
* 通过命令连接数据库选择表,可直接生成 service mapper.java mapper.xml entity sql语句


### USAGE
* 准备
````
安装  node
安装  yeoman npm install -g yo

$ node -v && npm -v && yo --version
v8.9.1
5.5.1
2.0.0
````
* 克隆项目 
````
git clone https://github.com/ycwmuyi/generator-okra.git
````

* 关联脚手架
````
在克隆下来的项目下执行
npm link
````

* 生成代码
````
yo okra:entity-kotlin-3 (生成kotlin 代码，mybatis-plus 3.0)

yo okra:entity-kotlin (生成kotlin 代码，mybatis-plus 2.0)

yo okra:entity-java (生成java 代码)

````
* 数据库url格式
````
MySQL URL Format:
mysql://user:pass@host/db?charset=utf8
````

# Change Log

## [1.0.0] - 2018-09-07
### Added

- entity-kotlin 只需要在数据库创建好表结构，即可生成一整套基于MyBatis-Plus的增删改查代码

## [1.1.0] - 2019-01-14
### Added

- 代码生成工具支持生成java代码
- 添加create_time 和 update_time 字段的自动填配置

## [1.2.0] - 2019-03-28
### Added

- 代码生成工具支持生成 mybatis-plus 3.0 代码 
- 添加create_time 和 update_time 字段的自动填配置





````

