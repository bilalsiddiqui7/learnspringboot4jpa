package com.example.learnspringboot4jpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.learnspringboot4jpa.dao.AlienRepo;
import com.example.learnspringboot4jpa.model.Alien;

@Controller
public class AlienController {
	@RequestMapping("/Home")
	public String showFormPage() {
		return "Home.jsp";
	}

	@Autowired
	AlienRepo alienRepo;

	@RequestMapping("/addAlien")
	public String addingAlienInDb(Alien alien) {
		alienRepo.save(alien);
		return "Home.jsp";
	}

	@RequestMapping("/getAlien")
	public ModelAndView getAlienById(@RequestParam int aid) {
		// We can also set the view in the below way
		ModelAndView mv = new ModelAndView("ViewAlien.jsp");
		Optional<Alien> alien = alienRepo.findById(aid);
		mv.addObject("alien", alien);

		// CUSTOMIZED METHODS
		System.out.println(alienRepo.findByTech("Java"));
		System.out.println(alienRepo.findByAidGreaterThan(2));
		System.out.println(alienRepo.findAllAliensByJavaInDescOrder("Java"));
		return mv;
	}

//	 REST
	@RequestMapping("/aliens")
	@ResponseBody
	public String getAllAliens() {
		return alienRepo.findAll().toString();
	}

	@RequestMapping("/alien/{aid}")
	@ResponseBody
	public String getAlienByAid(@PathVariable("aid") int aid) {
		return alienRepo.findById(aid).toString();
	}
	
	@RequestMapping(path="/allAliens", produces= {"application/json"})
	@ResponseBody
	public List<Alien> getAllTheAliens() {
		return (List<Alien>) alienRepo.findAll();
	}

	@RequestMapping("/alienById/{aid}")
	@ResponseBody
	public Optional<Alien> getAlienByTheId(@PathVariable("aid") int aid) {
		return alienRepo.findById(aid);
	}
}
