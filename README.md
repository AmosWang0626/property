#   property

##  软件改变生活,软件创造价值.

### 项目各模块介绍：

####    property-common
* 项目通用模块;
* 通用的API,校验、加密的等相关工具类,枚举等等;
* 本项目全局*Request，*Response定义层

####    property-core
* 核心代码模块,项目中接口定义与实现的地方;
* 这里注意两个地方,service层和business层,首先他们都是业务层,这两层有个主干关系:
    * 干: business层放一些业务校验,这些校验是可拆卸的,也是主要应对项目需求变化的;
    * 主: service层放一些基础校验,这些校验不管项目需求如何变化都是必须的;service层的方法实现要加上事务回滚;

####    property-dao
* 数据持久模块,数据存储操作的入口;
* 数据经过业务层core处理之后,经过这里存入数据库;

####    property-facade
* 对外接口层,暴露一些***Form, ***VO;

####    property-web
* http请求层,基础交互层;
* 用户在网页端发出请求,web层拦截请求,如果有数据,解析数据.
* 然后web层调用core层接口,core层处理完毕,把处理结果交给web层,web层处理后将相应结果返回给用户;

### pom.xml依赖关系：
    common  -----+
                 | ----- dao  -----  core ----- web
    facade  -----+
    
### 项目须知
* 项目最外层pom.xml中用dependencyManagement定义依赖的jar及其版本,不引入;
* 在common层引入所有的jar;
* 具体可参照当前项目中写得用户登录/注册相关功能;
* 当前项目中分页模板已作出,需者可阅.