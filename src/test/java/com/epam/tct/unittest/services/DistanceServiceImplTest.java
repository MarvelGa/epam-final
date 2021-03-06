package com.epam.tct.unittest.services;

import com.epam.tct.dao.DistanceDAO;
import com.epam.tct.exception.DaoException;
import com.epam.tct.model.Distance;
import com.epam.tct.service.DistanceService;
import com.epam.tct.service.impl.DistanceServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DistanceServiceImplTest {
    @Mock
    final DistanceDAO distanceDAO = mock(DistanceDAO.class);
    DistanceService service;

    private Distance dataDistance;
    private List<Distance> listDistance;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new DistanceServiceImpl(distanceDAO);

        listDistance = new ArrayList<>();
        dataDistance = new Distance();
        dataDistance.setId(1);
        dataDistance.setCityFrom("Kyiv");
        dataDistance.setCityFrom("Lviv");
        dataDistance.setDistance(480);
        listDistance.add(dataDistance);
    }

    @Test
    void shouldFindAll() {
        try {
            when(distanceDAO.readAll()).thenReturn(listDistance);
            List<Distance> expected = listDistance;
            List<Distance> actual = service.findAll();
            assertEquals(expected, actual);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void whenTryFindAllThanThrowsDaoException() {
        try {
            doThrow(DaoException.class).when(distanceDAO).readAll();
            service.findAll();
            fail();
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    void shouldFindById() {
        try {
            when(distanceDAO.readById(1)).thenReturn(dataDistance);
            Distance expected = dataDistance;
            Distance actual = service.findById(1);
            assertEquals(expected, actual);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void whenTryFindByIdThanThrowsDaoException() {
        try {
            doThrow(DaoException.class).when(distanceDAO).readById(1);
            service.findById(1);
            fail();
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    void shouldGetCityIdByName() {
        try {
            when(distanceDAO.getCityIdByName("Kiyv")).thenReturn(1);
            int expected = 1;
            int actual = service.getCityIdByName("Kiyv");
            assertEquals(expected, actual);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void whenTryGetCityIdByNameThanThrowsDaoException() {
        try {
            doThrow(DaoException.class).when(distanceDAO).getCityIdByName("Kiyv");
            service.getCityIdByName("Kiyv");
            fail();
        } catch (Exception e) {
            assertTrue(true);
        }
    }

}
