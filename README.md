###springcloud.demo

####.项目结构

#####1.父项目-fsjxspringclouddemo
>#####主要对pom进行了配置，将公共的依赖加载进来（比如spring boot parent）

#####2.注册中心模块-fsjx-eureka
>#####起到服务注册与发现的作用

#####3.接口中心模块-fsjx-api
>#####所有的服务需要首先设计接口，每一个服务在fsjx-api又是单独的一个模块

######3.1接口中心子模块-fsjx-api-user
>######用户服务接口（只有单纯的一个查询接口）

#####4.服务实现模块-fsjx-userservice
>#####对fsjx-api-user的具体实现


#####4.服务实现模块-fsjx-userservice
>#####对fsjx-api-user的具体实现







       
     
      