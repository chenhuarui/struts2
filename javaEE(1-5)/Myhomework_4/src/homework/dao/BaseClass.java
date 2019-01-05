package homework.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * 用于Hibernate对数据库的操作
 */
public class BaseClass {

    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    public Session InitializeBase() {

        //创建configuration对象，对应的Hibernate的基本信息和对象关系映射信息
        Configuration configuration = new Configuration().configure();

        //创建SessionFactory
        sessionFactory = configuration.buildSessionFactory();

        //创建一个Session 对象
        session = sessionFactory.openSession();

        //开启事务
        transaction = session.beginTransaction();

        return session;
    }

    public void endBase() {

        //事务提交
        transaction.commit();

        //session关闭
        session.close();

        //关闭sessionFactory
        sessionFactory.close();
    }
}
