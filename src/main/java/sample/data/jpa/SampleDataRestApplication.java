/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.data.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sample.data.jpa.service.*;
import sample.data.jpa.domain.*;

@SpringBootApplication
public class SampleDataRestApplication  implements CommandLineRunner {
	@Autowired
	 LandmarkRepository landmark;
	@Autowired
	 CityRepository city;
	@Autowired
         CustomerRepository customer;
	 @Override
	public void run(String... args) throws Exception {

		
		this.landmark.deleteAll();

		// save a couple of customers
		this.landmark.save(new Landmark ("Dudeland","qwerty"));
		this.city.save(new City ("Dudeland","qwerty","map","state"));
		this.customer.save(new Customer ("Dudeland","qwerty"));
		 System.out.println(this.city.findByMap("map"));

	}      
		



	public static void main(String[] args) throws Exception {
		SpringApplication.run(SampleDataRestApplication.class, args);
	}

}
