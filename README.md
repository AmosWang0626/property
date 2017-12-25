# property
软件改变生活,软件创造价值.

项目各模块介绍：

    property-common:项目通用模块；
    property-core:核心代码模块；
    property-dao:数据持久模块；
    property-facade:对外接口层，看下边依赖关系可以知道，web层定义的对象，core层是拿不到的，
                    所以需要把web层的对象*Request的数据进一步封装到facade层里边的对象*Form中，
                    然后core层去处理*Form；
    property-web:http请求层，网页发出请求，在这个里边去处理请求；

pom.xml依赖关系：

    common  -----   facade   -----   dao  -----  core ----- web

    项目最外层pom.xml中只定义jar，不引入；

    通常在common中引入所有的jar；

具体可参照当前项目中写得用户登录、注册相关功能