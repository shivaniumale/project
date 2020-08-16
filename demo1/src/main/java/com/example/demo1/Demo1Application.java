package com.example.demo1;

import com.example.demo1.pojo.User;
import com.example.demo1.service.CreateJDBC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
		CreateJDBC jdbc=new CreateJDBC();
		JdbcTemplate template;
		List<User> user=new ArrayList<>();
		String sql="select * from User";
		try{template=jdbc.CreateTemplate();
			user=template.query(sql, new BeanPropertyRowMapper(User.class));
			for (User u:user
				 ) {
				System.out.println(u.getName());
			}
		}
		catch(Exception e){
			e.printStackTrace();

		}

	}

}
