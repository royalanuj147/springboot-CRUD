package com.example.Bank;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class BankController {

	@Autowired
	BankRepository brepo;
	
	
	// Data Inserted
	@RequestMapping("/save")
	public String save() {
		Bank b = new Bank();
		b.setName("Anuj");
		b.setCity("Ranchi");
		b.setAccount("484818210001657");
		brepo.save(b);
		return "Data inseted Suucessfully";
	}
	
	// Data Insert using Postman
	@PostMapping("/post/save")
	public String save(@RequestBody Bank bank)
	{
		brepo.save(bank);
		return "Data Saved";
	}

	// Fetch all data in database
		@RequestMapping("/all")
		public List<Bank> showData()
		{
			return brepo.findAll();
		}
		
		 //	data Fetch by id in database
		@RequestMapping("/{id}")
		public Optional<Bank> dataFetchById(@PathVariable int id)
		{
				return brepo.findById(id);
		
		}
		
		// delete data by id
		@RequestMapping("/delete/{id}")
		public String deleteDate(@PathVariable int id)
		{
			brepo.deleteById(id);
			return "Data Delete where id was "+ id;
		}
		
		
		
		// Put request 
		// Update DAta in database
		@PutMapping("/update/{id}")
		public String update(@PathVariable int id, @RequestBody Bank bank)
		{
		 Bank b = brepo.findById(id).get();
		 b.setName(bank.getName());
		 b.setCity(bank.getCity());
		 b.setAccount(bank.getAccount());
		 brepo.save(b);
		 return "book updated";
		}
		
	 @RequestMapping("/by/{name}")
	 public List<Bank> byname(@PathVariable String name)
	 {
		 return brepo.findByName(name);
	 }
		
}
