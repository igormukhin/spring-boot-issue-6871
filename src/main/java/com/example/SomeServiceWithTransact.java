package com.example;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SomeServiceWithTransact {

    public void transactionalMethod(int param1) {
        // do nothing
    }

}
