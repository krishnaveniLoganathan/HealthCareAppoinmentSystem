package healthcare.HealthCare.Controller;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import healthcare.HealthCare.Model.Appointment;
import healthcare.HealthCare.Model.Patient;
import healthcare.HealthCare.Service.AppoinmentService;
import healthcare.HealthCare.Service.PatientService;


//creating HealthcareSystemController

@RestController
public class HealthcareSystemController {
	@Autowired
	AppoinmentService appoinmentService;

	@Autowired
	PatientService patientService;

	Logger log = org.slf4j.LoggerFactory.getLogger(HealthcareSystemController.class);

// get mapping that retrieves all appointments from the database 
	@Test
	@GetMapping("/allappointments")
	private List<Appointment> getAllAppointments() {
		log.info("Enters into allappoinments");
		List<Appointment> appoinments = null;
		appoinments = appoinmentService.getAllAppointments();
		log.info("End of allappoinments");
		return appoinments;

	}

//get mapping that retrieves the detail of a specific appoinment
	@GetMapping("/appointment/{id}")
	private Appointment getAppointmentById(@PathVariable("id") int id) {
		log.info("Enters into getAppoinmentById Id :" + id);
		Appointment appoinment = appoinmentService.getAppointmentById(id);
		log.info(" Appoinment  details " + appoinment);
		return appoinment;
	}

//delete mapping that deletes a specific appoinment
	@DeleteMapping("/cancelappointment/{id}")
	private void deleteAppointmentById(@PathVariable("id") int id) {
		log.info("Enters into deleteAppointmentById Id :" + id);
		appoinmentService.delete(id);
		log.info("Appoinment  Cancelled ");
	}

// post mapping that post the appointment detail in the database  {
	/*
	 * "patientId" :3, "patientName":"Grija", "doctorsName":"pooja",
	 * "appointmentOn":"2020-04-01" }
	 */
	@PostMapping("/bookappointment")
	private Appointment saveAppointment(@RequestBody Appointment appointment) {
		log.info("Enters into saveAppoinment");
		appointment = appoinmentService.saveOrUpdate(appointment);
		log.info(" Appoinment  details " + appointment);
		return appointment;
	}

	// put mapping that updates the appointment detail in the database
	@PutMapping("/updateappointment")
	private Appointment updateAppointment(@RequestBody Appointment appointment) {
		log.info("Enters into updateAppoinment " + appointment);
		appointment = appoinmentService.saveOrUpdate(appointment);
		log.info("Updated Appoinment  details " + appointment);
		return appointment;
	}

	//post mapping that post the patient detail in the database
	@PostMapping("/addpatient")
	private Patient savePatient(@RequestBody Patient patient) {
		log.info("Enters into savePatient");
		patient = patientService.saveOrUpdate(patient);
		log.info(" Patient  details " + patient);
		return patient;
	}

	
	
	// get mapping that gets the detail of patient in the database
	@GetMapping("/patient/{id}")
	private Patient getPatientById(@PathVariable("id") int id) {
		log.info("Enters into getPatientById Id :" + id);
		Patient patient = patientService.getPatientById(id);
		log.info("Patient  details " + patient);
		return patient;
	}
}
