package com.tech.subash.controller;


import com.tech.subash.controller.redis.RedisAbstractAnnotationController;
import com.tech.subash.entity.UrbanEntity;
import com.tech.subash.repository.UrbanRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

 class NewStudentControllerTest {  // TODO

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UrbanRepository urbanRepository;

    @Autowired
    private ObjectMapper objectMapper;

    //@Test
     void getStudentTest() throws Exception {
        mockMvc.perform(get(""))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("subash.pernandas.savari"))
                .andExpect(jsonPath("$.age").value(31));
    }

    //@Test
     void storeUrbanDetailsTest() throws Exception {
        UrbanEntity urban =  new UrbanEntity();
        urban.setName("k.m.kottai");
        urban.setAge(1245);
        urban.setId(2);

        String  convertedString = new ObjectMapper().writeValueAsString(urban);
        mockMvc.perform(post("/v2/student/post").contentType(
                        MediaType.APPLICATION_JSON).content(convertedString))
                .andExpect(status().isOk());

        ArgumentCaptor<UrbanEntity> captor = ArgumentCaptor.forClass(UrbanEntity.class);
        verify(urbanRepository, times(1)).save(captor.capture());
        UrbanEntity savedUrban = captor.getValue();
        assertEquals("k.m.kottai", savedUrban.getName());
        assertEquals(1245, savedUrban.getAge());
        assertEquals(2L, savedUrban.getId());


    }
    //@Test
     void storeUrbanDetailsReturnTest() throws Exception {
        UrbanEntity inputUrban = new UrbanEntity(2L, "k.m.kottai", 1245);
        String jsonRequest = objectMapper.writeValueAsString(inputUrban);

        when(urbanRepository.save(Mockito.any(UrbanEntity.class))).thenReturn(inputUrban);

        mockMvc.perform(post("/v2/student/postreturn")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.name").value("k.m.kottai"))
                .andExpect(jsonPath("$.age").value(1245));

        ArgumentCaptor<UrbanEntity> captor = ArgumentCaptor.forClass(UrbanEntity.class);
        verify(urbanRepository, times(1)).save(captor.capture());

        UrbanEntity savedUrban = captor.getValue();
        assertEquals("k.m.kottai", savedUrban.getName());
        assertEquals(1245, savedUrban.getAge());
        assertEquals(2L, savedUrban.getId());
    }

    //@Test
     void fetchAllTest() throws Exception {
        UrbanEntity urban1 = new UrbanEntity(1L, "CityA", 10000);
        UrbanEntity urban2 = new UrbanEntity(2L, "CityB", 20000);
        List<UrbanEntity> mockUrbanList = Arrays.asList(urban1, urban2);

        when(urbanRepository.findAll()).thenReturn(mockUrbanList);

        mockMvc.perform(get("/v2/student/findAll"))
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("CityA"))
                .andExpect(jsonPath("$[1].name").value("CityB"));
    }

}
