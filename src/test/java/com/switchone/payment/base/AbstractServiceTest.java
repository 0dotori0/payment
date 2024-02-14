package com.switchone.payment.base;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ExtendWith(MockitoExtension.class)
public abstract class AbstractServiceTest {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());
}
