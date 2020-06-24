package com.revature.restdemobr3.web;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.revature.restdemobr3.dao.LessonsRepoDB;
import com.revature.restdemobr3.dao.StudentsRepoDB;
import com.revature.restdemobr3.dao.TrainersRepoDB;
import com.revature.restdemobr3.model.Lesson;
import com.revature.restdemobr3.model.Student;
import com.revature.restdemobr3.model.Trainer;

@Path("/service")
public class TrainingService {

	TrainersRepoDB trainerRepo = new TrainersRepoDB();
	LessonsRepoDB lessonRepo = new LessonsRepoDB();
	StudentsRepoDB studentRepo = new StudentsRepoDB();
	
	@POST
	@Path("/addlesson")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addLesson(Lesson lesson) {
		lessonRepo.addLessons(lesson);
		return Response.status(201).build();
	}
	
	@POST
	@Path("/addstudent")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addStudent(Student student) {
		studentRepo.addNewStudent(student);
		return Response.status(201).build();
	}
	
	@GET
	@Path("/gettrainers")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllTrainers() {
		return Response.ok((ArrayList<Trainer>)trainerRepo.getAllTrainers()).build();
	}
	
	@GET
	@Path("/getlessons")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllLessons() {
		return Response.ok((ArrayList<Lesson>)lessonRepo.getAllLessons()).build();
	}
	
	@GET
	@Path("/getstudents")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllStudents() {
		return Response.ok((ArrayList<Student>)studentRepo.getAllStudents()).build();
	}
	
	@GET
	@Path("/getlessonranks")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLessonRanking() {
		return Response.ok((ArrayList<Lesson>)lessonRepo.getFavLessons()).build();
	}
	
}
