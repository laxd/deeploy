package uk.laxd.deepweb.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import uk.laxd.deepweb.dto.EditBuildFlowDto;
import uk.laxd.deepweb.dto.ViewBuildFlowDto;
import uk.laxd.deepweb.dto.ViewBuildFlowStepDto;
import uk.laxd.deepweb.mapper.EditBuildFlowMapper;
import uk.laxd.deepweb.mapper.ExecutorDefinitionMapper;
import uk.laxd.deepweb.mapper.ViewBuildFlowMapper;
import uk.laxd.deepweb.mapper.ViewBuildFlowStepMapper;
import uk.laxd.deepweb.model.BuildFlow;
import uk.laxd.deepweb.model.BuildFlowStep;
import uk.laxd.deepweb.service.BuildFlowService;
import uk.laxd.deepweb.service.BuildFlowStepExecutorService;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by lawrence on 28/04/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class BuildFlowControllerTest {

    public static final String BUILD_FLOW_ID = "123";
    public static final String FLOW_URL = "/flow/" + BUILD_FLOW_ID;
    private static final String FLOWS_URL = "/flow";
    private static final String ADD_FLOW_URL = "/flow/add";

    @Mock
    private BuildFlowService buildFlowService;

    @Mock
    private BuildFlowStepExecutorService executorService;

    @Mock
    private EditBuildFlowMapper editBuildFlowMapper;

    @Mock
    private ViewBuildFlowMapper viewBuildFlowMapper;

    @Mock
    private ViewBuildFlowStepMapper viewBuildFlowStepMapper;

    @Mock
    private ExecutorDefinitionMapper executorDefinitionMapper;

    @InjectMocks
    private BuildFlowController controller;
    
    private MockMvc mockMvc;

    @Mock
    private BuildFlow buildFlow;

    @Mock
    private ViewBuildFlowDto buildFlowDto;

    @Mock
    private Collection<BuildFlowStep> steps;

    @Mock
    private Collection<ViewBuildFlowStepDto> stepDtos;

    @Mock
    private List<BuildFlow> buildFlows;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .build();

        when(buildFlowService.findById(BUILD_FLOW_ID)).thenReturn(buildFlow);
        when(viewBuildFlowMapper.mapToDto(buildFlow)).thenReturn(buildFlowDto);
        when(buildFlow.getBuildFlowSteps()).thenReturn(steps);
        when(viewBuildFlowStepMapper.mapToDtos(steps)).thenReturn(stepDtos);
        when(buildFlowService.findAll()).thenReturn(buildFlows);
    }

    @Test
    public void testViewReturnedIsViewBuildFlow() throws Exception {
        mockMvc.perform(get(FLOW_URL))
                .andExpect(view()
                        .name("buildflow/view"));
    }

    @Test
    public void testBuildFlowParamInModel() throws Exception {
        mockMvc.perform(get(FLOW_URL))
                .andExpect(model()
                        .attribute("buildFlow", buildFlowDto));
    }

    @Test
    public void testStepsParamInModel() throws Exception {
        mockMvc.perform(get(FLOW_URL))
                .andExpect(model()
                        .attribute("steps", stepDtos));
    }

    @Test
    public void testViewReturnedIsViewBuildFlowList() throws Exception {
        mockMvc.perform(get(FLOWS_URL))
                .andExpect(view()
                        .name("buildflow/list"));
    }

    @Test
    public void testBuildFlowListParamInModel() throws Exception {
        mockMvc.perform(get(FLOWS_URL))
                .andExpect(model()
                        .attribute("buildFlows", buildFlows));
    }

    @Test
    public void testAddBuildFlowViewReturnedIsEditBuildFlow() throws Exception {
        mockMvc.perform(get(ADD_FLOW_URL))
                .andExpect(view()
                        .name("buildflow/edit"));
    }

    @Test
    public void testAddBuildFlowHasBuildFlowAttribute() throws Exception {
        MvcResult result = mockMvc.perform(get(ADD_FLOW_URL))
                .andExpect(model()
                        .attributeExists("buildFlow"))
                .andReturn();

        Object buildFlow = result.getModelAndView().getModel().get("buildFlow");

        assertNotNull(buildFlow);
        assertEquals(EditBuildFlowDto.class, buildFlow.getClass());
    }

    @Test
    public void testAddBuildFlowPostRedirectsToViewPage() throws Exception {
        when(editBuildFlowMapper.mapToEntity(any(EditBuildFlowDto.class))).thenReturn(buildFlow);
        when(buildFlow.getId()).thenReturn(BUILD_FLOW_ID);

        mockMvc.perform(post(ADD_FLOW_URL)
                .param("name", "Test Name"))
                .andExpect(redirectedUrl(FLOW_URL));
    }


}