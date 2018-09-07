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
在自己的工程目录下执(目前直支持kotlin 代码生成)
yo okra:entity-kotlin

````
* 数据库url格式
````
MySQL URL Format:
mysql://user:pass@host/db?charset=utf8

````

