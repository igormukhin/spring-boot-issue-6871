package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Matchers.anyInt;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootIssue6871ApplicationTests {

	@SpyBean
	private SomeServiceNoTransact someServiceNoTransact;

	@SpyBean
	private SomeServiceWithTransact someServiceWithTransact;

	@Test
	public void testNormalMethod() throws Exception {
		// when
		someServiceNoTransact.normalMethod(1);

		// then
		Mockito.verify(someServiceNoTransact, Mockito.times(1)).normalMethod(1);
		Mockito.verify(someServiceNoTransact, Mockito.times(1)).normalMethod(anyInt());
	}

	@Test
	public void testTransactionalMethod() throws Exception {
		// when
		someServiceWithTransact.transactionalMethod(1);

		// then
		Mockito.verify(someServiceWithTransact, Mockito.times(1)).transactionalMethod(1);
		Mockito.verify(someServiceWithTransact, Mockito.times(1)).transactionalMethod(anyInt());
	}

}
