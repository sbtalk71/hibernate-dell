package com.demo.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

public class JdbcInsertDemo {

	public static void main(String[] args) {
		String INSERT_SQL = "insert into emp(empno,name,address,salary) values (?,?,?,?)";
		ApplicationContext ctx = new AnnotationConfigApplicationContext(JdbcAppConfig.class);

		JdbcTemplate jt = ctx.getBean(JdbcTemplate.class);

		int count = jt.update(new PreparedStatementCreator() {

			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pst = con.prepareStatement(INSERT_SQL);
				pst.setInt(1, 300);
				pst.setString(2, "Rajeev");
				pst.setString(3, "Noida");
				pst.setDouble(4, 76000);
				return pst;
			}
		});

		System.out.println("Rows Inserted : " + count);

	}

}
