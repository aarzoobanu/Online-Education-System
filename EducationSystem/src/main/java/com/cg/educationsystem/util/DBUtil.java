package com.cg.educationsystem.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

import com.cg.educationsystem.dao.ScheduleDAOImp;

public class DBUtil {
	private static EntityManager manager;

	public static EntityManager getConnection() {
		Logger logger=Logger.getLogger(DBUtil.class); 
		logger.info("__________________________________________________________");
		logger.info("Getting connection");
		try {
			if (manager == null) {				
				EntityManagerFactory fac = Persistence.createEntityManagerFactory("JPA-PU");
				manager = fac.createEntityManager();
				logger.info("Connection successful");
			}
		} catch (Throwable ex) {
			logger.error("Connection failed");
			System.err.println("Entity Manager Creation failed " + ex);
			throw new ExceptionInInitializerError(ex);
		}
		return manager;
	}

	public static void closeConnection() {
		Logger logger=Logger.getLogger(DBUtil.class); 
		if (manager != null && manager.isOpen()) {
			manager.close();
			logger.info("Connection closed");
		}
	}
}
