package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.AopTestUtils;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.spy;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WithoutSpyBeanTest {

    @Autowired
    private SomeServiceWithTransact someServiceWithTransact;

    @Test
    public void testWithGetTargetObject() throws Exception {
        SomeServiceWithTransact naked = AopTestUtils.getTargetObject(someServiceWithTransact);
        SomeServiceWithTransact spying = spy(naked);

        // when
        spying.transactionalMethod(1);

        // then
        Mockito.verify(spying, Mockito.times(1)).transactionalMethod(1);
        Mockito.verify(spying, Mockito.times(1)).transactionalMethod(anyInt());
    }

    @Test
    public void testWithGetUltimateTargetObject() throws Exception {
        SomeServiceWithTransact naked = AopTestUtils.getUltimateTargetObject(someServiceWithTransact);
        SomeServiceWithTransact spying = spy(naked);

        // when
        spying.transactionalMethod(1);

        // then
        Mockito.verify(spying, Mockito.times(1)).transactionalMethod(1);
        Mockito.verify(spying, Mockito.times(1)).transactionalMethod(anyInt());
    }

}
