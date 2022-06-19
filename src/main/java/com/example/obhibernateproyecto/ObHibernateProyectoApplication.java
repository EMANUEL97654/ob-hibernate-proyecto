package com.example.obhibernateproyecto;

import com.example.obhibernateproyecto.entities.BillingInfo;
import com.example.obhibernateproyecto.entities.Task;
import com.example.obhibernateproyecto.entities.User;
import com.example.obhibernateproyecto.repository.BillingInfoRepository;
import com.example.obhibernateproyecto.repository.TaskRepository;
import com.example.obhibernateproyecto.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class ObHibernateProyectoApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(ObHibernateProyectoApplication.class, args);

		// Billing Info y user ===========
		BillingInfoRepository billinginfoRepository = context.getBean(BillingInfoRepository.class);

		UserRepository userRepository = context.getBean(UserRepository.class);

		BillingInfo info1 = new BillingInfo(null,"ELM street","55432","Transilvania","Pesadilla","ES543254325432",null);

		billinginfoRepository.save(info1);

		User user1 = new User(null,"Jack","Ryan","88877765R",true, LocalDate.of(1970,12,1));
		User user2 = new User(null,"Mike","Champion","888996542R",true, LocalDate.of(1970,10,1));
		user1.setBillingInfo(info1);
		userRepository.save(user1);
		userRepository.save(user2);

		//Task y User =================

		TaskRepository taskRepository = context.getBean(TaskRepository.class);
		Task task1 = new Task(null,"Tarea 1","Lorem ipsum",false,LocalDate.of(2022,1,1),user1);
		Task task2 = new Task(null,"Tarea 2","Lorem ipsum",true,LocalDate.of(2022,2,1),user1);
		Task task3 = new Task(null,"Tarea 3","Lorem ipsum",false,LocalDate.of(2022,3,1),user2);
		Task task4 = new Task(null,"Tarea 4","Lorem ipsum dolor",false,LocalDate.of(2022,4,1),user2);

		taskRepository.saveAll(List.of(task1,task2,task3,task4));



		System.out.println("FIN");
	}

}
