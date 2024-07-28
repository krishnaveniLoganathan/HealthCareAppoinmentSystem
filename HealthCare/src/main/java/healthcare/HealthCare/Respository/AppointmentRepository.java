package healthcare.HealthCare.Respository;
import org.springframework.data.repository.CrudRepository;

import healthcare.HealthCare.Model.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer>
{
}
