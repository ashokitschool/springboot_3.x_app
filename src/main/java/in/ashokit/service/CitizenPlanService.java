package in.ashokit.service;

import java.util.List;

import in.ashokit.binding.SearchCriteria;
import in.ashokit.entity.CitizenPlan;
import jakarta.servlet.http.HttpServletResponse;

public interface CitizenPlanService {

	public List<String> getPlanNames();

	public List<String> getPlanStatus();

	public List<CitizenPlan> searchCitizens(SearchCriteria criteria);

	public void generateExcel(HttpServletResponse response) throws Exception;

	public void generatePdf(HttpServletResponse response) throws Exception;
	
}
