package com.mycompany.billingservice;

import com.mycompany.billingservice.entities.Bill;
import com.mycompany.billingservice.entities.BillItem;
import com.mycompany.billingservice.entities.Quote;
import com.mycompany.billingservice.repositories.BillItemRepository;
import com.mycompany.billingservice.repositories.BillRepository;
import com.mycompany.billingservice.repositories.QuoteItemRepository;
import com.mycompany.billingservice.repositories.QuoteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

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
//	CommandLineRunner start(BillItemRepository billItemRepository) {
//		return args ->  {
//			for (int i = 0; i < 10; i++) {
//				BillItem billItem = BillItem.builder()
//						.qte(2)
//						.amount(Math.random()*4)
//						.rateTva(Math.random()/2)
//						.discountPercentage(Math.random())
//						.bill(new Bill())
//
//						.build();
//
//				billItemRepository.save(billItem);
//			}
//		};
//	}

}
