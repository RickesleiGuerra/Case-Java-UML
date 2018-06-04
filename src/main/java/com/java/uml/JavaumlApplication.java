package com.java.uml;


import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.java.uml.domain.Adress;
import com.java.uml.domain.Category;
import com.java.uml.domain.City;
import com.java.uml.domain.Client;
import com.java.uml.domain.Request;
import com.java.uml.domain.RequestItem;
import com.java.uml.domain.Payment;
import com.java.uml.domain.PaymentBankSlip;
import com.java.uml.domain.PaymentCreditCard;
import com.java.uml.domain.Product;
import com.java.uml.domain.State;
import com.java.uml.domain.enums.StatePayment;
import com.java.uml.domain.enums.TypeClient;
import com.java.uml.repositories.AdressRepository;
import com.java.uml.repositories.CategoryRepository;
import com.java.uml.repositories.CityRepository;
import com.java.uml.repositories.ClientRepository;
import com.java.uml.repositories.RequestRepository;
import com.java.uml.repositories.PaymentRepository;
import com.java.uml.repositories.ProductRepository;
import com.java.uml.repositories.RequestItemRepository;
import com.java.uml.repositories.StateRepository;

@SpringBootApplication
public class JavaumlApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private StateRepository stateRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private AdressRepository adressRepository;
	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private RequestRepository requestRepository;
	@Autowired
	private RequestItemRepository requestItemRepository;
	
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(JavaumlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Computing");
		Category cat2 = new Category(null, "Office");
		
		Product p1 = new Product(null, "Computer", 2000.00);
		Product p2 = new Product(null, "Printer", 800.00);
		Product p3 = new Product(null, "Mouse", 50.00);
		
		cat1.getProducts().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProducts().addAll(Arrays.asList(p2));
		
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1,cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));
		
		categoryRepository.saveAll(Arrays.asList(cat1,cat2));
		productRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		State st1 = new State (null, "Minas Gerais");
		State st2 = new State (null, "São Paulo");
		
		City ct1 = new City (null, "Uberlândia",st1);
		City ct2 = new City (null, "São Paulo",st2);
		City ct3 = new City (null, "Campinas",st2);
		
		st1.getCities().addAll(Arrays.asList(ct1));
		st1.getCities().addAll(Arrays.asList(ct2,ct3));
		
		stateRepository.saveAll(Arrays.asList(st1,st2));
		cityRepository.saveAll(Arrays.asList(ct1,ct2,ct3));
		
		Client cl1 = new Client (null, "Maria Silva", "maria@gmail.com","6239988345", TypeClient.PESSOAFISICA);
		
		cl1.getPhones().addAll(Arrays.asList("32785467","98234567"));
		
		Adress adr1 = new Adress(null, "Flowers Street", "300", "Apto 12", "Garden", "3245674", cl1, ct1);
		Adress adr2 = new Adress(null, "Mamba Street", "100", "Apto 151", "Center", "0912733", cl1, ct2);
		
		cl1.getAdresses().addAll(Arrays.asList(adr1,adr2));
		
		clientRepository.saveAll(Arrays.asList(cl1));
		adressRepository.saveAll(Arrays.asList(adr1,adr2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy hh:mm");
		
		Request req1 = new Request(null, sdf.parse("30/01/2000 08:00"),cl1,adr1);
		Request req2 = new Request(null, sdf.parse("31/02/2010 09:00"),cl1,adr2);
		
		Payment pay1 = new PaymentBankSlip(null, StatePayment.PENDING, req2, sdf.parse("29/03/2024 04:00"),null);
		req2.setPayment(pay1);
		
		Payment pay2 = new PaymentCreditCard(null, StatePayment.SETTLED, req1, 6);
		req2.setPayment(pay2);
		
		cl1.getRequests().addAll(Arrays.asList(req1,req2));
		
		paymentRepository.saveAll(Arrays.asList(pay1,pay2));
		requestRepository.saveAll(Arrays.asList(req1,req2));
		
		RequestItem ri1 = new RequestItem(req1, p1, 0.00, 2000.00, 1);
		RequestItem ri2 = new RequestItem(req1, p3, 0.00, 80.00, 2);
		RequestItem ri3 = new RequestItem(req2, p2, 100.00, 700.00, 1);
		
		req1.getItens().addAll(Arrays.asList(ri1,ri2));
		req2.getItens().addAll(Arrays.asList(ri3));
		
		p1.getItens().addAll(Arrays.asList(ri1));
		p2.getItens().addAll(Arrays.asList(ri3));
		p3.getItens().addAll(Arrays.asList(ri2));
		
		requestItemRepository.saveAll(Arrays.asList(ri1,ri2,ri3));
		
	}
}
