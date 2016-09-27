package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootIssueApplicationTests {

	@SpyBean
	private CityRepository cityRepository;

	@Autowired
	private CityService cityService;

	@Test
	public void testNormalMethod() throws Exception {
		// when
		cityService.getCity("a", "c");

		// then
		verify(cityRepository, Mockito.times(1)).findByNameAndCountryAllIgnoringCase("a", "c");
	}

}
