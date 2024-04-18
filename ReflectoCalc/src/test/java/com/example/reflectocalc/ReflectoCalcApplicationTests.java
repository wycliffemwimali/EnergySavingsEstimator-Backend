package com.example.reflectocalc;

import com.example.reflectocalc.Repository.EnergySavingsRepository;
import com.example.reflectocalc.controller.EnergySavingsController;
import com.example.reflectocalc.model.Rooftop;
import com.example.reflectocalc.service.EnergySavingsService;
import com.example.reflectocalc.service.EnergySavingsServiceImpl;
import com.example.reflectocalc.service.RooftopService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
class ReflectoCalcApplicationTests {

    @InjectMocks
    private RooftopService rooftopService;

    @Mock
    private EnergySavingsRepository energySavingsRepository;

    private EnergySavingsServiceImpl energySavingsServiceImpl;



    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        energySavingsServiceImpl = new EnergySavingsServiceImpl(rooftopService, energySavingsRepository);
    }

    @Test
    void contextLoads() {
    }

    @Test
    void testCalculateEnergySavingsByRooftopId() {
        // Arrange
        Long rooftopId = 1L;
        Rooftop rooftop = new Rooftop();
        rooftop.setId(rooftopId);
        rooftop.setArea(100.0);
        double constantFactor = 0.5; // Assuming a constant factor
        double expectedEnergySavings = rooftop.getArea() * constantFactor;

        // Mock behavior
        when(rooftopService.getRooftopById(rooftopId)).thenReturn(rooftop);

        // Act
        double actualEnergySavings = energySavingsServiceImpl.calculateEnergySavingsByRooftopId(rooftopId);

        // Assert
        assertEquals(expectedEnergySavings, actualEnergySavings);
        verify(rooftopService, times(1)).getRooftopById(rooftopId);
        verifyNoMoreInteractions(rooftopService);
    }


}
