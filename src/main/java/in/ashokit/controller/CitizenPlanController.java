package in.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.binding.SearchCriteria;
import in.ashokit.entity.CitizenPlan;
import in.ashokit.service.CitizenPlanService;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class CitizenPlanController {

	@Autowired
	private CitizenPlanService service;

	@GetMapping("/")
	public String index(Model model) {

		formInit(model);

		model.addAttribute("search", new SearchCriteria());

		return "index";
	}

	private void formInit(Model model) {
		List<String> planNames = service.getPlanNames();
		List<String> planStatus = service.getPlanStatus();

		model.addAttribute("planNames", planNames);
		model.addAttribute("planStatus", planStatus);
	}

	@PostMapping("/filter-data")
	public String handleSearchBtn(@ModelAttribute("search") SearchCriteria criteria, Model model) {
		
		List<CitizenPlan> citizensInfo = service.searchCitizens(criteria);
		model.addAttribute("citizens", citizensInfo);
		
		formInit(model);
		
		return "index";
	}
	
	@GetMapping("/excel")
	public void downloadExcel(HttpServletResponse response) throws Exception{
		
		response.setContentType("application/octet-stream");
		
		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=data.xls";
		
		response.addHeader(headerKey, headerValue);
		
		service.generateExcel(response);
	}
	
	@GetMapping("/pdf")
	public void downloadPdf(HttpServletResponse response) throws Exception{
		
		response.setContentType("application/pdf");
		
		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=data.pdf";
		
		response.addHeader(headerKey, headerValue);
		
		service.generatePdf(response);
		
	}
}
