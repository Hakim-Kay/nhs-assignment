package com.makiini.nhsbsa.assignment.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.makiini.nhsbsa.assignment.model.ScenarioDetails;
import com.makiini.nhsbsa.assignment.model.ScenarioRequest;
import com.makiini.nhsbsa.assignment.model.ScenarioResponse;
import com.makiini.nhsbsa.assignment.service.ScenarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
public class ScenarioControllerTest {

    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Mock
    private ScenarioService scenarioService;

    @InjectMocks
    private ScenarioController scenarioController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(scenarioController).build();
    }

    @Test
    void postScenarioRequest_shouldReturnStructuredResponse() throws Exception {
        ScenarioRequest requestObject = new ScenarioRequest();
        requestObject.setTechnology("Cloud Computing");
        requestObject.setRole("Software Engineer");
        requestObject.setEnvironment("Cloud Infrastructure");

        ScenarioDetails dummyDetails = ScenarioDetails.builder()
            .challenge("Test")
            .build();
        ScenarioResponse dummyResponse = new ScenarioResponse(
            requestObject,
            dummyDetails
        );

        when(
            scenarioService.generateRandomScenario(any(ScenarioRequest.class))
        ).thenReturn(dummyResponse);

        mockMvc
            .perform(
                post("/api/scenario")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(requestObject))
            )
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.inputs").exists())
            .andExpect(jsonPath("$.scenario.challenge").value("Test"));
    }
}
