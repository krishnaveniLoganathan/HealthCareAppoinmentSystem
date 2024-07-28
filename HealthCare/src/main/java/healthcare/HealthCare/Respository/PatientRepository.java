package healthcare.HealthCare.Respository;

import org.springframework.data.repository.CrudRepository;

import healthcare.HealthCare.Model.Patient;

public interface PatientRepository extends CrudRepository<Patient, Integer>{

}
