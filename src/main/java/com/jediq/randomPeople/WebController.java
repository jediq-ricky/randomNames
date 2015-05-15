package com.jediq.randomPeople;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Configuration
@EnableAutoConfiguration
@EnableAspectJAutoProxy
@ComponentScan

@Controller
@RequestMapping(value="/")
public class WebController {


	private static SpringApplication springApplication = new SpringApplication(WebController.class);
	
	public static void main(String[] args) {
		springApplication.run(args);
	}


	@Autowired
	private GeneratorService generatorService;

	@RequestMapping()
	@ResponseBody
	public List<Person> getHandler(@RequestParam(defaultValue = "2000") int number) throws IOException {
		List <Person> persons = new ArrayList<>();
		for (int i=0; i< number; i++) {
			Person person = generatorService.generatePerson();
			persons.add(person);
		}
		return persons;
	}
}
