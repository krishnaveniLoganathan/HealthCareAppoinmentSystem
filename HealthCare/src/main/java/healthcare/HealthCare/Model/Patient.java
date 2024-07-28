package healthcare.HealthCare.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class Patient {

	@Id
	@Column
	@GeneratedValue
	private int id;

	@Column
	private String name;

	@Column
	private int age;

	@Column
	private String email;

	@Column
	private String type;

	@Column
	private String complaint;
}