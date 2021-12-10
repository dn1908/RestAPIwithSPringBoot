package versions;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVesrioningController {

	@GetMapping(value = "/person", params="version=1")
	public Person getPerson() {
		return new Person("Bob charlie");
	}
	
	@GetMapping(value = "/person", params="version=1")
	public PersonV2 getPerson2() {
		return new PersonV2("Bob", "Charlie");
	}
}
