package com.ATJAVA.ATJAVA;

import com.ATJAVA.ATJAVA.model.Departamento;
import com.ATJAVA.ATJAVA.service.DepartamentoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class DepartamentoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartamentoService departamentoService;

    @Test
    public void testGetAllDepartamentos() throws Exception {
        Departamento departamento = new Departamento();
        departamento.setId(1L);
        departamento.setNome("Departamento de Teste");

        when(departamentoService.getAllDepartamentos()).thenReturn(Collections.singletonList(departamento));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/departamentos")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].nome").value("Departamento de Teste"));
    }

}
