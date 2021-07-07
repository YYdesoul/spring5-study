##  I. 简介

1. **Spring是什么**

	Spring是一个开源免费的**轻量级**且**非侵入式的**框架（容器），其通过**注入Bean**的方式实现了**控制反转IOC**(Inversion of Control)和**面向切面编程AOP**(Aspect Oriented Programming)，并且具备对事物和其它框架（如MyBatis）的支持。

	Spring的核心思想是简化开发

2. 为什么用Spring

  **优势**

  - 作为一个开发容器，Spring大大地简化了开发，提升了开发地效率
  - 通过注入Bean的方式将控制从程序本身反转给了客户，使得程序的灵活性更高，改变了程序设计的逻辑
  - 将Bean和代码分离，使得程序的耦合性降低，提升了开发的安全性和代码的可读性
  - 通过AOP将程序解耦，使得业务和附加功能得以分离，大大地提升了开发地安全性和代码的可读性
  - 支持多个常用的开源框架
  - 用的人多，是经典的SSM框架的重要组成部分

  **劣势**

  - 经过多年的演变，Spring已经编程了一个大杂烩，其配置已经越来越复杂，于是这时候Springboot应运而生

[代码链接][https://github.com/YYdesoul/spring5-study]

## II. 组成部分

![spring_framework_runtime](C:\study\spring5-study\blog\img_spring\spring_framework_runtime.png)

Spring 框架是一个分层架构，由 7 个定义良好的模块组成。Spring 模块构建在核心容器之上，核心容器定义了创建、配置和管理 bean 的方式 。

![spring_component](C:\study\spring5-study\blog\img_spring\spring_component.png)

组成 Spring 框架的每个模块（或组件）都可以单独存在，或者与其他一个或多个模块联合实现。每个模块的功能如下：

1. **核心容器Core**

	核心容器提供 Spring 框架的基本功能。核心容器的主要组件是 BeanFactory ，它是工厂模式的实现。BeanFactory 使用控反转（IOC） 模式将应用程序的配置和依赖性规范与实际的应用程序代码分开。

2. **Spring 上下文Context**

	Spring 上下文是一个配置文件，向 Spring 框架提供上下文信息。Spring 上下文包括企业服务，例如 JNDI、EJB、电子邮件、国际化、校验和调度功能。

3. **Spring AOP**

	通过配置管理特性，Spring AOP 模块直接将面向切面的编程功能 , 集成到了 Spring框架中。所以，可以很容易地使 Spring 框架管理任何支持 AOP的对象。Spring AOP 模块为基于Spring 的应用程序中的对象提供了事务管理服务。通过使用 Spring AOP，不用依赖组件，就可以将声明性事务管理集成到应用程序中。

4. **Spring DAO**

	JDBC DAO 抽象层提供了有意义的异常层次结构，可用该结构来管理异常处理和不同数据库供应商抛出的错误消息。异常层次结构简化了错误处理，并且极大地降低了需要编写的异常代码数量（例如打开和关闭连接）。Spring DAO 的面向 JDBC 的异常遵通用的 DAO 异常层次结构。

5. **Spring ORM**

	Spring 框架插入了若干个 ORM 框架，从而提供了 ORM 的对象关系工具，其中包括 JDO、Hibernate 和 iBatis SQL Map。所有这些都遵从 Spring 的通用事务和 DAO 异常层次结构。

6. **Spring Web 模块**

	Web 上下文模块建立在应用程序上下文模块之上，为基于 Web 的应用程序提供了上下文。所以，Spring 框架支持与Jakarta Struts 的集成。Web 模块还简化了处理多部分请求以及将请求参数绑定到域对象的工作。

7. **Spring MVC 框架**

	MVC 框架是一个全功能的构建 Web 应用程序的 MVC 实现。通过策略接口，MVC 框架变成为高度可配置的，MVC 容纳了大量视图技术，其中包括 JSP、Velocity、Tiles、iText和 POI。

## III. Spring特性

### 1. IOC和DI

**a. IOC和DI是什么**

**控制反转IoC**是一种**设计思想**，而**依赖注入DI**(Dependency Injection)是IOC的一种**实现**方法。一般来说，对象的创建源自程序本身，而IoC反转了这种模式，将**创建对象的控制转移给了第三方（用户）**。这样使得程序的耦合性被大大地降低了。

![ioc_原理](C:\study\spring5-study\blog\img_spring\ioc_设计.png)

**b. 为什么要控制反转**

按照原本的设计模式，程序每次使用new自己在内部新建对象，这样的代码耦合性非常高。一旦业务增加或发生了改变，都需要修改大量的代码，牵一发而动全身。这样的设计明显是不可取的，使用IoC后，可以由用户根据自己的需求从外部注入Bean从而实现自己想要的功能。

**c. IoC和DI怎么用**

在Spring中，IoC的实现是通过依赖注入DI来实现的。注入的方式有两种：1) 编写xml配置文件注入Bean；2) 使用注解注入Bean

Spring容器在初始化时先读取配置文件，根据配置文件或元数据创建与组织对象存入容器中，程序使用时再从Ioc容器中取出需要的对象。

![ioc_原理](C:\study\spring5-study\blog\img_spring\ioc_原理.png)

采用XML方式配置Bean的时候，Bean的定义信息是和实现分离的，而采用注解的方式可以把两者合为一体，Bean的定义信息直接以注解的形式定义在实现类中，从而达到了零配置的目的。

**1) xml配置**

**aa. 使用xml配置流程**

第一步：编写Java Bean:

```java
public class User {
    private String name;
    public User() {
    	System.out.println("user无参构造方法");
    }
    public void setName(String name) {
    	this.name = name;
    }
    public void show(){
    	System.out.println("name="+ name );
    }
}
```

第二步：编写beans.xml配置bean:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://www.springframework.org/schema/beans
http://www.springframework.org/schema/beans/spring-beans.xsd">
    <!-- 通过Set方法(无参构造)构建Bean-->
    <bean id="user" class="com.soul.pojo.User">
    	<property name="name" value="Jack"/>
    </bean>
</beans>
```

第三步：编写测试类：

```java
@Test
public void test(){
    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    //在执行getBean的时候, user已经创建好了 , 通过无参构造
    User user = (User) context.getBean("user");
    //调用对象的方法 .
    user.show();
}
```



**bb. Bean注入**

set方法注入：

```xml
<bean id="addr" class="com.kuang.pojo.Address">
    <property name="address" value="重庆"/>
</bean>
<bean id="student" class="com.kuang.pojo.Student">
    <property name="name" value="小明"/>
    <property name="address" ref="addr"/>
</bean>
```



有参构造注入：

```xml
<!-- 1. 通过有参构造构建Bean,一共三种方式 -->

<!-- 第一种根据index参数下标设置 -->
<bean id="userT" class="com.soul.pojo.UserT">
	<!-- index指构造方法 , 下标从0开始 -->
	<constructor-arg index="0" value="Lily"/>
</bean>

<!-- 第二种根据参数名字设置 -->
<bean id="userT" class="com.soul.pojo.UserT">
    <!-- name指参数名 -->
    <constructor-arg name="name" value="Lily"/>
</bean>

<!-- 第三种根据参数类型设置 -->
<bean id="userT" class="com.soul.pojo.UserT">
    <constructor-arg type="java.lang.String" value="Lily"/>
</bean>
```


p命名空间注入：

```xml
导入约束 : xmlns:p="http://www.springframework.org/schema/p"

<!--P(属性: properties)命名空间 , 属性依然要设置set方法-->
<bean id="user" class="com.soul.pojo.User" p:name="David" p:age="18"/>
```



c命名空间注入：

```xml
导入约束 : xmlns:c="http://www.springframework.org/schema/c"
<!--C(构造: Constructor)命名空间 , 属性依然要设置set方法和有参构造-->
<bean id="user" class="com.soul.pojo.User" c:name="David" c:age="18"/>
```



**cc. Bean的作用域**

在Spring中，那些组成应用程序的主体及由Spring IoC容器所管理的对象，被称之为bean。简单地讲，bean就是由IoC容器初始化、装配及管理的对象。

![bean的作用域](C:\study\spring5-study\blog\img_spring\bean的作用域.png)

使用scope标签来标识作用域，默认为singleton：

```xml
<bean id="ServiceImpl" class="cn.csdn.service.ServiceImpl" scope="singleton">
```



**dd. Bean的自动装配**

使用`autowire`标签可以让bean进行自动装配。`autowire`有两种方式（值）：byName和byType。

**ee. 基于Java类进行配置**

JavaConfig 原来是 Spring 的一个子项目，它通过 Java 类的方式提供 Bean 的定义信息，在 Spring4 的版本， JavaConfig 已正式成为 Spring4 的核心功能 。

流程如下：

_第一步：编写一个实体类：_

```java
@Component //将这个类标注为Spring的一个组件，放到容器中！
public class Dog {
public String name = "dog";
}
```

_第二步：新建一个config配置包，编写一个MyConfig配置类：_

```java
@Configuration //代表这是一个配置类
@Import(MyConfig2.class) //可以用import导入合并其他配置类，类似于配置文件中的 inculde 标签
public class MyConfig {
    
    @Bean //通过方法注册一个bean，这里的返回值就Bean的类型，方法名就是bean的id！
    public Dog dog(){
    	return new Dog();
    }
}
```

_第三步：测试：_

```java
@Test
public void test2(){
    // 注意这里new的和xml不太一样
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);	
    Dog dog = (Dog) applicationContext.getBean("dog");
    System.out.println(dog.name);
}
```



### 2. AOP

AOP（Aspect Oriented Programming）意为：面向切面编程，通过预编译方式和运行期动态代理实现程序功能的统一维护的一种技术AOP是OOP的延续，是软件开发中的一个热点，也是Spring框架中的一个重要内容，是函数式编程的一种衍生范型。利用AOP可以对业务逻辑的各个部分进行隔离，从而使得业务逻辑各部分之间的耦合度降低，提高程序的可重用性，同时提高了开发的效率。

**AOP中的重要术语**

- 横切关注点：跨越应用程序多个模块的方法或功能。即是，与我们业务逻辑无关的，但是我们需要关注的部分，就是横切关注点。如日志 , 安全 , 缓存 , 事务等等 ....

- 切面（ASPECT）：横切关注点 被模块化 的特殊对象。即，它是一个类。
- 通知（Advice）：切面必须要完成的工作。即，它是类中的一个方法。
- 目标（Target）：被通知对象。
- 代理（Proxy）：向目标对象应用通知之后创建的对象。
- 切入点（PointCut）：切面通知 执行的 “地点”的定义。
- 连接点（JointPoint）：与切入点匹配的执行点。

在程序中，业务流程是纵向运行的（先做什么，再做什么），这个时候，我们可以使用AOP横向的再一个切入点处加入一些功能，这样既没有改变原有的代码，又添加了新的功能。

Spring的Aop就是将公共的业务 (日志 , 安全等) 和领域业务结合起来 , 当执行领域业务时 , 将会把公共业务加进来。实现公共业务的重复利用。领域业务更纯粹 , 程序猿专注领域业务 , 其本质还是动态代理。

![横切原理](C:\study\spring5-study\blog\img_spring\横切原理.png)

SpringAOP中，通过Advice定义横切逻辑，Spring中支持5种类型的Advice:

![aop_advice](C:\study\spring5-study\blog\img_spring\aop_advice.png)

**AOP使用流程**

1. _第一种方式：通过Spring API实现_

	a. 编写业务接口：

	```java
	public interface UserService {
	    public void add();
	    public void delete();
	    public void update();
	    public void search();
	}
	```

	b. 编写接口实现类：

	```java
	public class UserServiceImpl implements UserService{
	    @Override
	    public void add() {
	    	System.out.println("增加用户");
	    }
	    @Override
	    public void delete() {
	    	System.out.println("删除用户");
	    }
	    @Override
	    public void update() {
	    	System.out.println("更新用户");
	    }
	    @Override
	    public void search() {
	    	System.out.println("查询用户");
	    }
	}
	```

	c. 编写新的功能：

	```java
	public class Log implements MethodBeforeAdvice {	// 实现不同的接口功能运行的位置不同
	    //method : 要执行的目标对象的方法
	    //objects : 被调用的方法的参数
	    //Object : 目标对象
	    @Override
	    public void before(Method method, Object[] objects, Object o) throws Throwable {
	    	System.out.println( o.getClass().getName() + "的" + method.getName() + "方法被执行了");
	    }
	}
	```

	d. 去spring的文件中注册 , 并实现aop切入实现 , 注意导入约束 ：

	```xml
	<?xml version="1.0" encoding="UTF-8"?>
	<beans xmlns="http://www.springframework.org/schema/beans"
	        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	        xmlns:aop="http://www.springframework.org/schema/aop"
	        xsi:schemaLocation="http://www.springframework.org/schema/beans
	        http://www.springframework.org/schema/beans/spring-beans.xsd
	        http://www.springframework.org/schema/aop
	        http://www.springframework.org/schema/aop/spring-aop.xsd">
	    
	        <!--注册bean-->
	        <bean id="userService" class="com.kuang.service.UserServiceImpl"/>
	        <bean id="log" class="com.kuang.log.Log"/>
	    
	        <!--aop的配置-->
	        <aop:config>
	            <!--切入点 expression:表达式匹配要执行的方法-->
	            <aop:pointcut id="pointcut" expression="execution(*
	            com.kuang.service.UserServiceImpl.*(..))"/>
	            <!--执行环绕; advice-ref执行方法 . pointcut-ref切入点-->
	            <aop:advisor advice-ref="log" pointcut-ref="pointcut"/>
	        </aop:config>
	</beans>
	```

	e. 测试：

	```java
	public class MyTest {
	    @Test
	    public void test(){
	    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	    UserService userService = (UserService) context.getBean("userService");
	    userService.search();
	    }
	}
	```

	

2. 第二种方式：

	a. 编写新功能类

	```java
	public class DiyPointcut {
	    public void before(){
	    	System.out.println("---------方法执行前---------");
	    }
	    public void after(){
	    	System.out.println("---------方法执行后---------");
	    }
	}
	```

	b. 去Spring中配置：

	```xml
	<!--第二种方式自定义实现-->
	<!--注册bean-->
	<bean id="diy" class="com.kuang.config.DiyPointcut"/>
	<!--aop的配置-->
	<aop:config>
		<!--第二种方式：使用AOP的标签实现-->
	    <aop:aspect ref="diy">
	    <aop:pointcut id="diyPonitcut" expression="execution(*
	  	com.kuang.service.UserServiceImpl.*(..))"/>
	    <aop:before pointcut-ref="diyPonitcut" method="before"/>
	    <aop:after pointcut-ref="diyPonitcut" method="after"/>
	    </aop:aspect>
	</aop:config>
	```

	

3. 第三种方式（**注解**）：

	a. 编写一个注解实现的新功能类：

	```java
	package com.soul.annotation;
	
	import org.aspectj.lang.ProceedingJoinPoint;
	import org.aspectj.lang.annotation.*;
	
	@Aspect
	public class AnnotationPoincut {
	
	    @Before("execution(* com.soul.service.UserServiceImpl.*(..))")
	    public void before() {
	        System.out.println("Log, before execute the method, by annotation");
	    }
	
	    @AfterReturning("execution(* com.soul.service.UserServiceImpl.*(..))")
	    public void afterReturning() {
	        System.out.println("Log, after returning execute the method, by annotation");
	    }
	
	    @After("execution(* com.soul.service.UserServiceImpl.*(..))")
	    public void after() {
	        System.out.println("Log, after execute the method, by annotation");
	    }
	
	    @Around("execution(* com.soul.service.UserServiceImpl.*(..))")
	    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
	        System.out.println("Log, before around execute the method, by annotation");
	        Object proceed = joinPoint.proceed();
	        System.out.println("Log, after around execute the method, by annotation");
	    }
	}
	```

	b. 在Spring配置文件中，注册bean并以及添加注解支持

	```xml
	<!--方式三：注解-->
	<bean id="userService" class="com.soul.service.UserServiceImpl"/>
	<bean id="annotationPointcut" class="com.soul.annotation.AnnotationPoincut"/>
	
	<aop:aspectj-autoproxy/>
	```

	

## IV 注解开发

1. **注解开发步骤：**

_第一步：在spring4之后，想要使用注解形式，必须得要引入aop的包：_

```xml
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjweaver</artifactId>
    <version>1.9.4</version>
</dependency>
```

_第二步：在配置文件当中引入context约束和扫描包：_

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns:context="http://www.springframework.org/schema/context"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">
    
    <!--指定注解扫描包-->
	<context:component-scan base-package="com.kuang.pojo"/>
    <context:annotation-config/>
</beans>
```

_第三步：在Java Bean类的上方加入`@Component("beanId")的标签:_

```java
@Component("user")
// 相当于配置文件中 <bean id="user" class="当前注解的类"/>
public class User {
	@Value("Jack")
	// 相当于配置文件中 <property name="name" value="Jack"/>, 也可以在Set方法上加入@Value标签
	public String name;
}
```

_第四步：测试：_

```java
@Test
public void test(){
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
    User user = (User) applicationContext.getBean("user");
    System.out.println(user.name);
}
```

2. **衍生注解**

@Component三个衍生注解
为了更好的进行分层，Spring可以使用其它三个注解，功能一样，目前使用哪一个功能都一样。

- @Controller：web层

- @Service：service层

- @Repository：dao层

	写上这些注解，就相当于将这个类交给Spring管理装配了！

3. **自动装配注解**

注解开发注入属性流程：

_第一步：在Spring配置文件中引入context文件头：_

```xml
xmlns:context="http://www.springframework.org/schema/context"

http://www.springframework.org/schema/context
http://www.springframework.org/schema/context/spring-context.xsd
```



_第二步：在Spring配置文件中开启属性注解支持：_

```xml
<context:1 annotation-config/>
```

_第三步：在Java Bean的属性或Set方法上加入注解：_

```java
public class User {
    @Autowired
    private Cat cat;
    //如果允许对象为null，设置required = false,默认为true 
    @Autowired(required = false)
    // 加上@Qualifier则可以根据byName的方式自动装配
    @Qualifier(value = "cat2")
    private Dog dog;
    private String str;
    
    public Cat getCat() {
    	return cat;
    }
    
    public Dog getDog() {
        return dog;
    }
    public String getStr() {
   		return str;
    }
}
```

_第四步测试：_

```java
    @Test
    public void testComponent() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user.name);
    }
```

## IV. 整合MyBatis

Spring可以轻松整合MyBatis, 步骤如下：

1. 准备工作

	a. 导入包：

	```xml
	<dependency>
	    <groupId>org.mybatis</groupId>
	    <artifactId>mybatis-spring</artifactId>
	    <version>2.0.2</version>
	</dependency>
	```

	b.编写spring-dao.xml配置类：

	```xml
	<?xml version="1.0" encoding="UTF-8"?>
	<beans xmlns="http://www.springframework.org/schema/beans"
	       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	       xsi:schemaLocation="http://www.springframework.org/schema/beans
	       http://www.springframework.org/schema/beans/spring-beans.xsd">
	
	    <!--配置数据源-->
	    <bean id="dataSource"
	          class="org.springframework.jdbc.datasource.DriverManagerDataSource">
	        <property name="driverClassName" value="com.mysql.jdbc.Driver"/>
	        <property name="url" value="jdbc:mysql://localhost:3306/mybatis?useSSL=true&amp;useUnicode=true&amp;characterEncoding=utf8"/>
	        <property name="username" value="root"/>
	        <property name="password" value="123456"/>
	    </bean>
	
	    <!--配置SqlSessionFactory-->
	    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
	        <property name="dataSource" ref="dataSource"/>
	        <!--关联Mybatis-->
	        <property name="configLocation" value="classpath:mybatis-config.xml"/>	<!--导入mybatis-config.xml-->
	        <property name="mapperLocations"
	                  value="classpath:com/soul/mapper/*.xml"/>
	    </bean>
	
	    <!--注册sqlSessionTemplate , 关联sqlSessionFactory-->
	    <bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
	        <!--利用构造器注入, 没有set方法-->
	        <constructor-arg index="0" ref="sqlSessionFactory"/>
	    </bean>
	</beans>
	```

2. 实现一个功能

	_第一步：编写实体类_：

	```java
	package com.soul.pojo;
	
	public class User {
	    private int id;
	    private String name;
	    private String pwd;
	
	    public User() {
	    }
	
	    public User(int id, String name, String pwd) {
	        this.id = id;
	        this.name = name;
	        this.pwd = pwd;
	    }
	
		// getter, setter, toString ...
	}
	
	```

	_第二步：编写mapper接口：_

	```java
	package com.soul.mapper;
	
	import com.soul.pojo.User;
	import java.util.List;
	
	public interface UserMapper {
	    // 获取全部用户
	    List<User> getUserList();
	}
	```

	_第三步：编写userMapper.xml配置类：_

	```xml
	<?xml version="1.0" encoding="UTF-8" ?>
	<!DOCTYPE mapper
	        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
	        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
	<!--namespace=绑定一个对应的mapper/Mapper接口-->
	<mapper namespace="com.soul.mapper.UserMapper">
	    <!--id 对应方法名-->
	    <select id="getUserList" resultType="com.soul.pojo.User">
	        select * from user;
	    </select>
	</mapper>
	```

	

	_第四步：编写接口实现类：_

	方式一：

	```java
	public class UserMapperImpl implements UserMapper{
	
	    private SqlSessionTemplate sqlSession;	//相当于MyBatis中的sqlSession
	
	    public void setSqlSession(SqlSessionTemplate sqlSession) {
	        this.sqlSession = sqlSession;
	    }
	
	    public SqlSessionTemplate getSqlSession() {
	        return sqlSession;
	    }
	
	    @Override
	    public List<User> getUserList() {
	        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
	        return mapper.getUserList();
	    }
	}
	```

	方式二：

	```java
	package com.soul.mapper;
	
	import com.soul.pojo.User;
	import org.mybatis.spring.support.SqlSessionDaoSupport;
	
	import java.util.List;
	
	public class UserMapperImpl2 extends SqlSessionDaoSupport implements UserMapper {
	    @Override
	    public List<User> getUserList() {
	        return getSqlSession().getMapper(UserMapper.class).getUserList();
	    }
	}
	```

	_第五步：将mapper.xml配置到配置类中_:

	```xml
	<?xml version="1.0" encoding="UTF-8"?>
	<beans xmlns="http://www.springframework.org/schema/beans"
	       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	       xsi:schemaLocation="http://www.springframework.org/schema/beans
	       http://www.springframework.org/schema/beans/spring-beans.xsd">
	    
		<!-- 导入数据库配置-->
	    <import resource="spring-dao.xml"/>
	    
	    <bean id="userMapper" class="com.soul.mapper.UserMapperImpl">
	        <property name="sqlSession" ref="sqlSession"/>	<!--方式一-->
	    </bean>
	
	    <bean id="userMapper2" class="com.soul.mapper.UserMapperImpl2">
	        <property name="sqlSessionFactory" ref="sqlSessionFactory"/> <!--方式二-->
	    </bean>
	</beans>
	```

	

## V. 事务

Spring在不同的事务管理API之上定义了一个抽象层，使得开发人员不必了解底层的事务管理API就可以使用Spring的事务管理机制。Spring支持编程式事务管理和声明式的事务管理。
**编程式事务管理（不常用）**

- 将事务管理代码嵌到业务方法中来控制事务的提交和回滚

缺点：必须在每个事务操作业务逻辑中包含额外的事务管理代码
**声明式事务管理**

- 一般情况下比编程式事务好用。
- 将事务管理代码从业务方法中分离出来，以声明的方式来实现事务管理。
- 将事务管理作为横切关注点，通过aop方法模块化。Spring中通过Spring AOP框架支持声明式事务管理。

步骤：

1. 导入头文件约束到数据库配置文件spring-dao.xml：

	```xml
	xmlns:tx="http://www.springframework.org/schema/tx"
	
	http://www.springframework.org/schema/tx
	http://www.springframework.org/schema/tx/spring-tx.xsd">
	```

	

2. 在spring-dao.xml中配置事务：

	```xml
	    <!--配置声明式事务-->
	    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
	        <property name="dataSource" ref="dataSource"/>
	    </bean>
	
	    <!--结合AOP实现事务的植入-->
	    <!--配置事务通知：-->
	    <tx:advice id="txAdvice" transaction-manager="transactionManager">
	        <!--给哪些方法配置事务-->
	        <!--配置事务的传播特性：new propagation-->
	        <tx:attributes>
	            <tx:method name="add" propagation="REQUIRED"/>
	            <tx:method name="delete" propagation="REQUIRED"/>
	            <tx:method name="query" read-only="true"/>
	            <tx:method name="*" propagation="REQUIRED"/>
	        </tx:attributes>
	    </tx:advice>
	
	    <!--配置事务切入-->
	    <aop:config>
	        <aop:pointcut id="txPointCut" expression="execution(* com.soul.mapper.*.*(..))"/>
	        <aop:advisor advice-ref="txAdvice" pointcut-ref="txPointCut"/>
	    </aop:config>
	```

## VI. 总结

Spring是一个开源免费的**轻量级**且**非侵入式的**框架（容器），其通过**注入Bean**的方式实现了**控制反转IOC**(Inversion of Control)和**面向切面编程AOP**(Aspect Oriented Programming)，并且具备对事物和其它框架（如MyBatis）的支持。Spring的出现大大地简化了开发。但是随着时间的推移，Spring越来越庞杂，于是乎基于Spring之上的Springboot营运而出。因此，在学习Springboot之前，必须首先掌握Spring，不然是很难理解Springboot中的底层逻辑。这也是现在学习Spring的意义所在。

## VII. 参考

[狂神说][https://www.bilibili.com/video/BV1WE411d7Dv]

