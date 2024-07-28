package healthcare.HealthCare.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import healthcare.HealthCare.Model.Appointment;
import healthcare.HealthCare.Respository.AppointmentRepository;


@Service
public class AppoinmentService {
	@Autowired
	AppointmentRepository appoinmentRepository;
	@Autowired
	PatientService patientService;

	// gets All the appointment detils
	public List<Appointment> getAllAppointments() {
		List<Appointment> appointments = new ArrayList<Appointment>();
		appoinmentRepository.findAll().forEach(appointment -> appointments.add(appointment));
		return appointments;
	}

	// gets specific appointment against id
	public Appointment getAppointmentById(int id) {
		return appoinmentRepository.findById(id).get();
	}

	// updates specific appointment against id
	public Appointment saveOrUpdate(Appointment appointment) {
		if(patientService.getPatientById(appointment.getPatientId())!=null) {
			appointment = appoinmentRepository.save(appointment);
		}  
		return appointment;
	}

	// deletes specific appointment against id
	public int delete(int id) {
	     appoinmentRepository.deleteById(id);
		 return id;
	}
}