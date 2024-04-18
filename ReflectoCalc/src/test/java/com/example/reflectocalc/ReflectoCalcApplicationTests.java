package com.example.reflectocalc;

import com.example.reflectocalc.Repository.EnergySavingsRepository;
import com.example.reflectocalc.controller.EnergySavingsController;
import com.example.reflectocalc.service.EnergySavingsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
class ReflectoCalcApplicationTests {

    @InjectMocks
    private EnergySavingsService energySavingsService;

    @Mock
    private EnergySavingsRepository energySavingsRepository;

    @InjectMocks
    private EnergySavingsController energySavingsController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
    }
    @Test
    void testGetEnergySavings() {
        // Arrange
        Long rooftopId = 1L;
        double expectedEnergySavings = 100.0;

        // Configure mock behavior to return the expected value when the service method is called
        when(energySavingsService.calculateEnergySavingsByRooftopId(rooftopId)).thenReturn(expectedEnergySavings);

        // Act
        double responseEntity = energySavingsService.calculateEnergySavingsByRooftopId(rooftopId);

        // Assert
//        assertEquals(HttpStatus.OK, responseEntity.());
//        assertEquals(expectedEnergySavings, responseEntity.getBody()); // Ensure the expected value is returned
        verify(energySavingsRepository, times(1)).save(any());
    }

}
