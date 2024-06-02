package com.springboot.springbootpostgre;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

	@Autowired
	ConsumerRepository erepo;
	@RequestMapping("/test")
	public String test()
	{
		return "this is test for postgresSql";
	}
	@RequestMapping("/save")
	public String save (@RequestBody Consumer cs)
	{
		erepo.save(cs);
		return "data have been saved";
		
	}
	@RequestMapping("/all")
	public List<Consumer>alldata()
	{
		return erepo.findAll();
	}
	@RequestMapping("/{id}")
	public Optional<Consumer> byid(@PathVariable int id)
	{
		return erepo.findById(id);
	}
	@RequestMapping("name/{name}")
	public List<Consumer>byname(@PathVariable String name)
	{
		return erepo.findByName(name);
	}
	@RequestMapping("/city/{city}")
	public List<Consumer>bycity(@PathVariable String city)
	{
		return erepo.findByCity(city);
	}
	@RequestMapping("/both/{name}/{city}")
     public List<Consumer>both(@PathVariable String name , @PathVariable String city)
     { return erepo.findByNameAndCity(name , city);
     }
	@RequestMapping("/duo/{name}/{age}")
	public List<Consumer>duo (@PathVariable String name , @PathVariable int age)
	{
		return erepo.findByNameAndAge(name,age);
				}
	@RequestMapping("/or/name/age")
	public List<Consumer> or(@PathVariable String name , @PathVariable int age)
	{
		return erepo.findByNameOrAge(name,age);
	}
	@RequestMapping("/del/{id}")
	public String del (@PathVariable int id)
	{ 
		erepo.findById(id).get();
		erepo.deleteById(id);
		return "data deleted";
	}
	@RequestMapping("/upd/{id}")
	public Consumer update (@RequestBody Consumer cs , @PathVariable int id)
	{ 
		Consumer b=erepo.findById(id).get();
		b.setName(cs.getName());
		b.setAge(cs.getAge());
		b.setCity(cs.getCity());
		return erepo.save(b);	
	}
	@RequestMapping("/or/{name}/{city}")
	public List<Consumer> find (@PathVariable String name, @PathVariable String city)
	{
	
		return erepo.findByNameOrCity(name,city);
	}	 
}
