package uk.laxd.deepweb.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import uk.laxd.deepweb.executor.ExecutorDefinition;
import uk.laxd.deepweb.executor.SshExecutorDefinition;
import uk.laxd.deepweb.service.BuildFlowStepExecutorService;

import static org.junit.Assert.*;

/**
 * Created by lawrence on 27/04/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class ExecutorControllerTest {

    private static final String EXECUTOR_DEFINITION_NAME = "SSH";
    private static final String INVALID_EXECUTOR_DEFINITION_NAME = "TESTING";
    private static final String MODAL_URL = "/executor/modal";

    @Mock
    private BuildFlowStepExecutorService buildFlowStepExecutorService;

    @InjectMocks
    private ExecutorController executorController;

    private MockMvc mockMvc;

    private ExecutorDefinition executorDefinition;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(executorController)
                .build();

        executorDefinition = new SshExecutorDefinition();

        when(buildFlowStepExecutorService.getExecutorDefinitionByName(EXECUTOR_DEFINITION_NAME)).thenReturn(executorDefinition);
    }

    @Test
    public void testViewNameIsExecutorConfig() throws Exception {
        mockMvc.perform(get(MODAL_URL)
                .param("type", EXECUTOR_DEFINITION_NAME))
                .andExpect(status().isOk())
                .andExpect(view()
                        .name("buildflowstep/executor_config"));
    }

    @Test
    public void testArgumentsReturned() throws Exception {
        mockMvc.perform(get(MODAL_URL)
                .param("type", EXECUTOR_DEFINITION_NAME))
                .andExpect(status().isOk())
                .andExpect(model()
                        .attributeExists("arguments"));
    }

    @Test
    public void testExecutorTypeReturnedMatchesGivenType() throws Exception {
        mockMvc.perform(get(MODAL_URL)
                .param("type", EXECUTOR_DEFINITION_NAME))
                .andExpect(status().isOk())
                .andExpect(model()
                        .attribute("type", EXECUTOR_DEFINITION_NAME));
    }

    @Test
    public void testAllArgumentsAreIncluded() throws Exception {
        mockMvc.perform(get(MODAL_URL)
                .param("type", EXECUTOR_DEFINITION_NAME))
                .andExpect(status().isOk())
                .andExpect(model()
                        .attribute("arguments", executorDefinition.getArguments()));
    }

    @Test
    public void testInvalidTypeThrowsException() throws Exception {
        mockMvc.perform(get(MODAL_URL)
                .param("type", INVALID_EXECUTOR_DEFINITION_NAME))
                .andExpect(status().is4xxClientError());
    }
}