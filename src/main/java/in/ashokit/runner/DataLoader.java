package in.ashokit.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.ashokit.entity.CitizenPlan;
import in.ashokit.repo.CitizenPlanRepo;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private CitizenPlanRepo repo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		
		repo.deleteAll();

		CitizenPlan p1 = new CitizenPlan("John", "john@in.com", 1234l, 98765l, "Male", "Cash", "Approved",
				LocalDate.now(), LocalDate.now().plusMonths(6));

		CitizenPlan p2 = new CitizenPlan("Smith", "smith@in.com", 2234l, 68765l, "Male", "Cash", "Denied", null, null);

		CitizenPlan p3 = new CitizenPlan("Cathy", "cathy@in.com", 3234l, 78765l, "Fe-Male", "Food", "Approved",
				LocalDate.now(), LocalDate.now().plusMonths(6));

		CitizenPlan p4 = new CitizenPlan("Johny", "johny@in.com", 3234l, 38765l, "Fe-Male", "Food", "Denied", null,
				null);

		CitizenPlan p5 = new CitizenPlan("Robert", "robert@in.com", 7234l, 48765l, "Male", "Medical", "Approved",
				LocalDate.now(), LocalDate.now().plusMonths(6));

		CitizenPlan p6 = new CitizenPlan("Any", "any@in.com", 3234l, 38765l, "Fe-Male", "Medical", "Denied", null,
				null);

		List<CitizenPlan> records = Arrays.asList(p1, p2, p3, p4, p5, p6);

		repo.saveAll(records);
	}
}
