package homework.interceptor;


import com.mysql.jdbc.AbandonedConnectionCleanupThread;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

@WebListener
public class ContextFinalizer implements ServletContextListener {

    private com.opensymphony.xwork2.util.logging.Logger logger = LoggerFactory.getLogger(this.getClass());
    public void contextInitialized(ServletContextEvent sce) {
    }

    public void contextDestroyed(ServletContextEvent sce) {
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        Driver d = null;
        try {
            while (drivers.hasMoreElements()) {
                d = drivers.nextElement();
                DriverManager.deregisterDriver(d);
                logger.info(" 消除数据库连接驱动 --> : Driver {} deregistered");
            }
        } catch (SQLException ex) {
            logger.error("Error: deregistering driver {} exceptionName:{} detail:{}", d, ex.getClass().getName(), ex.getMessage());
        }finally {
            try {
                AbandonedConnectionCleanupThread.shutdown();
            } catch (InterruptedException e) {
                logger.error("Error: SEVERE problem cleaning up: " + e.getMessage());
            }
        }
    }
}