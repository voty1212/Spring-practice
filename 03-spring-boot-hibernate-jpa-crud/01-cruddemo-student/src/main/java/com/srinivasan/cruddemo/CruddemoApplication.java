package com.srinivasan.cruddemo;

import com.srinivasan.cruddemo.dao.studentdao;
import com.srinivasan.cruddemo.dao.studentdaoimpl;
import com.srinivasan.cruddemo.entity.student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
@Bean
	public CommandLineRunner commandLineRunner(studentdao sd){
		return runner->{
				//createStudent(s);
		      createMultipleStudent(sd);
			//readStudent(sd);
			//queryforstudent(sd);
			//queryforstudentByLastName(sd);
			//updateStudent(sd);
			//deleteStudent(sd);
              //deletealls(sd);
		};

}

	private void deletealls(studentdao sd) {
		int rows=sd.deleteall();
		System.out.println(rows);
	}

	private void deleteStudent(studentdao sd) {
		int stid=3;
		System.out.println(stid);
		sd.delete(stid);
	}

	private void updateStudent(studentdao sd) {
		int stid=1;
		student s=sd.findbyId(stid);
		s.setFirstName("Max");
		sd.update(s);
		System.out.println(s);
	}

	private void queryforstudentByLastName(studentdao sd) {
	List<student> theStudent=sd.findByLastName("Shelby");
		for(student s:theStudent){
			System.out.println(s);
		}
	}

	private void queryforstudent(studentdao sd) {
		List<student> thestudent=sd.findall();
		for(student s:thestudent){
			System.out.println(s);
		}
	}

	private void readStudent(studentdao sd) {
		System.out.println("Create student ");
		student temp=new student("Devaansh","Singh","d@gmail.com");
		sd.save(temp);
		System.out.println("id of new student is "+temp.getId());
		int theid= temp.getId();
		student mystudent=sd.findbyId(theid);
		System.out.println(mystudent);
	}

	private void createMultipleStudent(studentdao s) {
		System.out.println("New student created");
		student temp=new student("Joe","Mama","joemama@gmail.com");
		student temp2=new student("Max","Million","max@gmail.com");
		student temp3=new student("Tom","Shelby","tom@gmail.com");
		student temp4=new student("Dick","Dickion","dick@gmail.com");
		System.out.println("Saving these");
		s.save(temp2);
		s.save(temp3);
		s.save(temp4        );


	}

//	private void createStudent(studentdao s) {
//		System.out.println("New student created");
//		student temp=new student("Joe","Mama","joemama@gmail.com");
//		System.out.println("saving");
//		s.save(temp);
//		System.out.println("Student saved, id is:  "+temp.getId());
//
//	}
}
