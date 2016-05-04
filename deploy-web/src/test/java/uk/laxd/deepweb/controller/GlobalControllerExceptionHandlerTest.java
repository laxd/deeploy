package uk.laxd.deepweb.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import uk.laxd.deepweb.lang.ExecutorNotFoundException;
import uk.laxd.deepweb.mapper.ExecutorDefinitionMapper;
import uk.laxd.deepweb.service.BuildFlowService;
import uk.laxd.deepweb.service.BuildFlowStepExecutorService;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by lawrence on 03/05/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class GlobalControllerExceptionHandlerTest {

    private MockMvc mockMvc;

    @Mock
    private BuildFlowService buildFlowService;

    @Mock
    private BuildFlowStepExecutorService executorService;

    @Mock
    private ExecutorDefinitionMapper executorDefinitionMapper;

    @InjectMocks
    private BuildFlowController controller = new BuildFlowController();
    private GlobalControllerExceptionHandler exceptionHandler = new GlobalControllerExceptionHandler();

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setControllerAdvice(exceptionHandler)
                .build();
    }

    @Test
    public void testExceptionIsIntercepted() throws Exception {
        when(buildFlowService.findById(123L)).thenThrow(new ExecutorNotFoundException());

        mockMvc.perform(get("/flow/123"))
                .andExpect(view().name("deeploy-error"));
    }

    @Test
    public void testExceptionsAlreadyHandledAreNotIntercepted() throws Exception {


    }
}