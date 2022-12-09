package com.demo.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.beans.JdbcBean;
import com.demo.config.BeanConfigClass;
import com.demo.db.JdbcDAO;

public class MainClass {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfigClass.class);

		// dao를 가져온다.
		JdbcDAO dao = ctx.getBean(JdbcDAO.class);

		// insert
//		JdbcBean bean1 = new JdbcBean();
//		bean1.setInt_data(2);
//		bean1.setStr_data("문자열2");
//		dao.insert_data(bean1);

		// update
		JdbcBean bean4 = new JdbcBean();
		bean4.setInt_data(1);
		bean4.setStr_data("문자열3");
		dao.update_data(bean4);

		// delete
		dao.delete_data(2);

		List<JdbcBean> list = dao.select_data();

		for (JdbcBean bean : list) {
			System.out.printf("int_data : %d\n", bean.getInt_data());
			System.out.printf("str_data : %s\n", bean.getStr_data());
			System.out.println("----------------------------------------");
		}

		ctx.close();

	}
}
