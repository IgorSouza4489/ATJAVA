package com.ATJAVA.ATJAVA;

import com.ATJAVA.ATJAVA.model.Departamento;
import com.ATJAVA.ATJAVA.repository.DepartamentoRepository;
import com.ATJAVA.ATJAVA.service.DepartamentoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartamentoServiceTest {

    @Mock
    private DepartamentoRepository departamentoRepository;

    @InjectMocks
    private DepartamentoService departamentoService;

    @Test
    public void testGetAllDepartamentos() {
        List<Departamento> departamentos = new ArrayList<>();
        departamentos.add(new Departamento(1L, "Departamento 1", "Local 1", null));
        departamentos.add(new Departamento(2L, "Departamento 2", "Local 2", null));

        when(departamentoRepository.findAllDepartamentosSemFuncionarios()).thenReturn(departamentos);

        List<Departamento> result = departamentoService.getAllDepartamentos();

        assertEquals(departamentos.size(), result.size());
    }

    @Test
    public void testGetDepartamentoById() {
        Departamento departamento = new Departamento(1L, "Departamento Teste", "Local Teste", null);

        when(departamentoRepository.findById(1L)).thenReturn(Optional.of(departamento));

        Optional<Departamento> result = departamentoService.getDepartamentoById(1L);

        assertEquals(departamento, result.orElse(null));
    }

}
