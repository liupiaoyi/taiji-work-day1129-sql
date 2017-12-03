JPQL : 将SQL语句中 的 对象，换成实体.( 只做 查询，更改 )
		参数绑定形式： ①id=？1 ；  ②：id=orgId

	note:	JPQL特点：编译不会报错，运行才会报错。（ 不安全 ）；
		
			Criteria ( 安全 ) 

自定义query；通过在注解，

getSingleResult 如果没有数据，会报异常

删除 Query； 其他(增改查) TypedQuery

nameQuery 定义在实体类中注解

@Transactional

@Modifying 注解完成修改操作(注意:不支持新增)

@Cascade  级联



sqlserver 支持以下数据类型

	精确数字: 
		bigint ; decimal ; int ; numeric ,smallint,
		money  ; tinyint ; smallmoney ; bit 
	近似数字
		float ,real 
	日期和时间
		datetime , smalldatetime 
	字符串
		char ,text ,varchar ,Unicode 
	字符串
		nchar ,ntext ,nvarchar 
	二进制字符串
		binary ,image ,varbinary 
	其他数据类型
		cursor ,timestamp ,sql_variant ,
		uniqueidentifier ,table ,xml 



JPQL全称Java Persistence Query Language.是一种可移植的持久化查询语言

JPA是Java Persistence API的简称，中文名Java持久层API，是JDK 5.0注解或XML描述对象－关系表的映射关系，并将运行期的实体对象持久化到数据库中