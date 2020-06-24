package com.revature.restdemobr3.web;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.revature.restdemobr3.dao.LessonsRepoDB;
import com.revature.restdemobr3.dao.StudentsRepoDB;
import com.revature.restdemobr3.model.Lesson;
import com.revature.restdemobr3.model.Student;
import com.revature.restdemobr3.model.Trainer;

@Path("/service")
public class TrainingService {

	TrainersRepoDB trainerRepo = new TrainersRepoDB();
	LessonsRepoDB lessonRepo = new LessonsRepoDB();
	StudentsRepoDB studentRepo = new StudentsRepoDB(new ConnectionService());
	
//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Response addLesson(Lesson lesson) {
//		lessonRepo.addLessons();
//		return Response.ok().build();
//	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addStudent(@FormParam("name") String studentName, @FormParam("id") int id, @FormParam("batchID") int batchID,
			@FormParam("topic") String topic, @FormParam("trainerName") String trainerName, @FormParam("trainerID") int trainerID,
			@FormParam("favStudentName") String favStudentName, @FormParam("currBatchID") int currBatchID) {
		Student favStudent = studentRepo.getStudent(favStudentName);
		Trainer trainer = new Trainer(trainerName, trainerID, favStudent, currBatchID);
		Lesson lesson = new Lesson(id, topic, trainer);
		Student newStudent = new Student(studentName, id, batchID, lesson);
		studentRepo.addNewStudent(newStudent);
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
	
//	@GET
//	@Path("/getlessonranks")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response getLessonRanking() {
//		return Response.ok((ArrayList<Lesson>)lessonRepo.getBestLessons()).build();
//	}
	
}
