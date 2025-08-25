package com.tech.subash.controller;

import com.tech.subash.async.WaitService;
import com.tech.subash.components.AppProperties;
import com.tech.subash.controller.async.AsyncController;
import com.tech.subash.response.CommonResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
 class AsyncControllerTest {

    @InjectMocks
    private AsyncController asyncController;

    @Mock
    private WaitService waitService;

    @Mock
    private AppProperties appProperties;

    @Mock
    private AppProperties.Security security;

    @Test
     void getAsyncTest() {
        // Mock appProperties.getSecurity() to return the mocked security object
        when(appProperties.getSecurity()).thenReturn(security);

        // Mock methods of security
        when(security.getRole()).thenReturn("ROLE_USER");
        when(security.isEnabled()).thenReturn(true);

        // Other mocks and test logic
        when(appProperties.getName()).thenReturn("TestName");
        doNothing().when(waitService).waitIn20Seconds(); // Impo

        ResponseEntity<?> response = asyncController.getAsync();
        CommonResponse commonResponse = (CommonResponse) response.getBody();

        Assertions.assertEquals("subash.pernandas", commonResponse.getData());
    }

}
