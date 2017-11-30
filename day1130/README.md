# taiji-work-day1129-sql

******** day1129 ***************************************
mariadb 替代mysql 继续开源。
5.5之前跟mysql一致。之后跳到10版本。
	mysqld 检测是否安装成功
	mysql -uroot -proot	输入用户，密码
	show database 显示数据库
	create databases first; 创建数据库
	use first;	打开（使用）数据库
	
	create table emp(ename varchar(10),hiredate date,sal decimal(10,2)（double类型）,deptno int(2));
	显示表信息		DESC emp
	显示表创建信息	show create table emp \G;
	插入字段		alter table test1 add age int(3);
	更改字段属性	alter table emp modify age varchar(3);

	create table deptno(deptno int(2) not null primary key,dname varchar(10) );
	修改数据
	update emp set hiredate='2000-00-00' where ename='json'; 
	设置主键
	alter table person add constraint PK_empno primary key(pid);
	设置外健+级联
	alter table employee add constraint PK_ep foreign key(pid) references person(pid) on delete cascade;
	
	
	增加
	insert into emp values ('ason',now(),2000,10,16,'b');（data类输入：'xxxx,xx,xx';'xxxx-xx-xx';now()）
	删除
	delete from 表名 where pid=2;
	修改
	update 表名 set 字段=值 where pid=2;
	
		

	字符型：
		char    速度快。占内存
		varchar
		text 纯字符型
		blob 保存二进制类型
	浮点型 (四舍五入)
		float
		double
	定点数
		decimal
		
	日期类型
		date年月日，time 时分秒
		
		
	 create table employee(eid int(6),ename varchar(20),salary decimal(10,2),deg varchar(20) );
	 create table Customer(id int(3),firstName varchar(20),lastName varchar(20) );
	 alter table person add constraint PK_pid primary key(pid);


	事物（A成功/撤回CID提交存储）
		begin 开启事物
		commit 提交事物
		rollback 回滚


	索引(单列索引/组合索引)	
		最多不超过3,5个。 列值（数据）最好不要经常更改 。 最好不要是图片类型
		
	mysql-connect	
	
	
pm*************
spring JDBC: core核心包
	jdbctimelate类的使用	.queryForObject(sql,值); 使用占位符方式将值传入 
							.queryForObject(sql,new RowMapper<Actor>() {}); 返回Actor 对象
							
							.update(insert sql,值) 执行增删改等语句
							.batchUpdate()批量操作
							.execute("create table mytable (id integer, name varchar(100))") 修改属性

	JdbcTemplate类的实例一旦配置就是 线程安全的		
	
	NamedParameterJdbcTemplate的使用：包装一个JdbcTemplate,提供命名参数而不是传统的JDBC“？” 占位符	
				自动装配 namedParameterJdbcTemplate --->  处理DataSource this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
				定义方法--> sql = "select count(*) from person where name = :name and age = :age";
							return this.namedParameterJdbcTemplate.queryForObject(sql,object,返回类型.class);
	SimpleJdbcTemplate

	executbatch 批量操作
	
	

******** day1130 ***************************************
JPA: 基于O/R映射的标准规范
	-----	file:///F:/taiji/d1129mysql/Pro%20JPA%202.pdf---page.17
实体@entity (特点：持久化)
		@table(name="person") 类跟表的对应
		 catalog,schema设置数据库目录和模式
		 @id 声明主键
		 @GeneratedValue 自增的
		 @column
		@OrderBy("name ASC")排序
		
		Employee{
		 @OneToOne 一对一
		 @JoinColumn(name="PK_name")
		 private OtherName otherName;
		}
		OtherName{
		 @OneToOne(mapperBy="otherName")
		 Employee employee;
		}
	
		@OneToMany 一对多	
		(ps： @mapperBy 只用在@OneToOne，@OneToMany，@ManyToMany ，不能用在@ManyToOne...
			  @ManyToOne用在主表(被引用)的一方 )

		@ManyToMany 多对多
		@JoinTables(name="",
			 主表：joinColumns=@JoinColumns(name="在中间表的名字",referencedColumnName="对应表主键"),
			 从表：inverseJoinColumns=@JoinColumns(name="在中间表的名字",referencedColumnName="对应表主键"),
			 uniqueConstraints=@UniqueConstraints
		  )添加中间表

持久化单元(静态，存在内存)：配置了数据来源，数据关联的实体类
使用：	自定义管理 		@PersistenceContext(容器托管)
						EntityManager
		应用程序管理（不推荐，需要手动关闭连接）Persistence.createENtityManageFactory(PersistenceName);

	
@Transactional( 属性= )事务  ------------->   只能用在 public 方法上。如果是其他方法，不报错，也不生效！！！！尽量在方法上用，不要在接口上用
	属性：propagation:事务传播行为，6个等级
		  isReadyOnly
		  @Transactional(noRollbackFor={RunTimeException.class,Exception.class})
		  timeout:超时



pm
entityManager.persist( employee ); 持久化
entityManager.getTransaction().commit(); 提交到数据库

JPA默认的行为是只要指定了主键生成策略，主键就不能设置了（即不要 setId(){值} ）










