package healthcare.HealthCare;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.sql.Date;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import healthcare.HealthCare.Controller.HealthcareSystemController;
import healthcare.HealthCare.Model.Appointment;
import healthcare.HealthCare.Model.Patient;
import healthcare.HealthCare.Service.AppoinmentService;
import healthcare.HealthCare.Service.PatientService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Import(HealthcareSystemController.class)
class HealthCareApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

    @Autowired
	private MockMvc mockMvc;
	
	@Test
	void contextLoads() {
	}
	
	@Autowired
	AppoinmentService appoinmentService;
	
	@Autowired
	PatientService patientService;
	
	
	@Test
	//++ve case patient details registered before an appoinment 
	
	
	/*
	 * {
    "appoinmentId": 1,
    "patientId": 1,
    "patientName": null,
    "doctorsName": null,
    "appointmentOn": null
	}
	
	{"name":"krish",
"age":28,
"email":"veni@gmail.com",
"complaint" :"Headache",
"type" :"IN"
}

	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	public void bookanAppointment() throws Exception {
	   String uri = "/getappoinment";
	   // valid appointment +ve case
	   
	   Patient patient = new Patient();
	   patient.setName("krishna");
	   patient.setAge(28);
	   patient.setComplaint("HeadAche");
	   patient.setEmail("krishna@gmail.com");
	   patientService.saveOrUpdate(patient);
	   
	   Appointment appointment = new Appointment();
	   appointment.setDoctorsName("Grija");
	   appointment.setPatientName("Krishna");
	   appointment.setPatientId(1);
	   LocalDate date = LocalDate.of(2024, 05, 28);
	   Date d = Date.valueOf(date);
	   appointment.setAppointmentOn(d);
	   
	   appointment = appoinmentService.saveOrUpdate(appointment);
	   assertNotEquals(0, appointment.getAppoinmentId());
	   
	
	}
	
	@Test
	public void bookanAppointmentWithoutPatientRegistration() throws Exception {
		// invalid valid appointment -ve cases
		
		   Appointment appointment = new Appointment();
		   appointment.setDoctorsName("Pooja");
		   appointment.setPatientName("Krish");
		   appointment.setPatientId(5);
		   LocalDate date = LocalDate.of(2024, 05, 28);
		   Date d = Date.valueOf(date);
		   appointment.setAppointmentOn(d);
		   appointment = appoinmentService.saveOrUpdate(appointment);
		   assertNotEquals(0, appointment.getAppoinmentId());
	}
	
	

}
