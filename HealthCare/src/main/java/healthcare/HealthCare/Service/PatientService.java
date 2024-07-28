package healthcare.HealthCare.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import healthcare.HealthCare.Model.Appointment;
import healthcare.HealthCare.Model.Patient;
import healthcare.HealthCare.Respository.PatientRepository;

@Service
public class PatientService {
	
	@Autowired
	PatientRepository patientRepository;
	
	public Patient getPatientById(int id) 
	{
	return patientRepository.findById(id).get();
	}
	
	public Patient saveOrUpdate(Patient patient) {
		patient = patientRepository.save(patient);
		return patient;
	}


}
