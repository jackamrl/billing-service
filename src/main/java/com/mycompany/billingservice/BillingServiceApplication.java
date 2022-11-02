package com.mycompany.billingservice;

import com.mycompany.billingservice.entities.Bill;
import com.mycompany.billingservice.repositories.BillRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}

//	@Bean
//	CommandLineRunner start(BillRepository billRepository) {
//		return args ->  {
//			for (int i = 0; i < 10; i++) {
//				Bill bill = Bill.builder()
//						.id(UUID.randomUUID().toString())
//						.discountPercentage(1000+Math.random()*5000 )
//						.billDate(new Date())
//						.validationDate(new Date())
//						.totalHt(Math.random()*7442415)
//						.totalTTC(Math.random()*545445455)
//						.build();
//
//				billRepository.save(bill);
//			}
//		};
//	}

}
