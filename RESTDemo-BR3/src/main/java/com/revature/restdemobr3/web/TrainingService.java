package com.revature.restdemobr3.web;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.revature.restdemobr3.model.Lesson;
import com.revature.restdemobr3.model.Student;
import com.revature.restdemobr3.model.Trainer;
import com.revature.restdemobr3.dao.LessonsRepoDB;

@Path("/service")
public class TrainingService {

	ITrainerRepo trainerRepo = new TrainerRepoDB();
	LessonsRepoDB lessonRepo = new LessonsRepoDB();
	IStudentRepo studentRepo = new StudentRepoDB();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addLesson(Lesson lesson) {
		lessonRepo.addLesson(lesson);
		return Response.ok().build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addStudent(Student student) {
		studentRepo.addStudent(student);
		return Response.ok().build();
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
		return Response.ok((ArrayList<Lesson>)lessonRepo.getBestLessons()).build();
	}
	
}
