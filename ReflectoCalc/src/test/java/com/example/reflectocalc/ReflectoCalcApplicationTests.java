package com.example.reflectocalc;

import com.example.reflectocalc.Repository.EnergySavingsRepository;
import com.example.reflectocalc.Repository.RooftopRepository;
import com.example.reflectocalc.controller.EnergySavingsController;
import com.example.reflectocalc.model.Rooftop;
import com.example.reflectocalc.service.EnergySavingsService;
import com.example.reflectocalc.service.EnergySavingsServiceImpl;
import com.example.reflectocalc.service.RooftopService;
import com.example.reflectocalc.service.RooftopServiceImpl;
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

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
class ReflectoCalcApplicationTests {

    @Mock
    private RooftopServiceImpl rooftopServiceImpl;


    @Mock
    private EnergySavingsRepository energySavingsRepository;

    @Mock
    private RooftopRepository rooftopRepository;

    @InjectMocks
    private EnergySavingsServiceImpl energySavingsServiceImpl;



    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
//        energySavingsServiceImpl = new EnergySavingsServiceImpl(rooftopServiceImpl, energySavingsRepository);
    }

    @Test
    void contextLoads() {
    }

    @Test
    void testCalculateEnergySavingsByRooftopId() {
        // Arrange
//        Long rooftopId = 1L;
//        Rooftop rooftop = new Rooftop();
//        rooftop.setId(rooftopId);
//        rooftop.setArea(100.0);
//        double constantFactor = 0.5; // Assuming a constant factor
//        double expectedEnergySavings = rooftop.getArea() * constantFactor;
//
//        // Mock behavior
//        when(rooftopRepository.findById(rooftopId)).thenReturn(Optional.of(rooftop));
//
//        // Act
//        double actualEnergySavings = energySavingsServiceImpl.calculateEnergySavingsByRooftopId(rooftopId);
//
//        // Assert
//        assertEquals(expectedEnergySavings, actualEnergySavings);
//        verify(rooftopServiceImpl, times(1)).getRooftopById(rooftopId);
//        verifyNoMoreInteractions(rooftopServiceImpl);
    }


}
