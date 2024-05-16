import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.servlet.http.HttpServletRequest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class SmallBusinessControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private SmallBusinessController smallBusinessController;

    @Mock
    private Engine engine;

    @Mock
    private WorkflowFactory workflowFactory;

    @Mock
    private LoggerUtil loggerUtil;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(smallBusinessController).build();
    }

    @Test
    void testRetrieveSmallBusinessCliDetails_Success() throws Exception {
        SBCliRetrieveRequest request = new SBCliRetrieveRequest();
        SBCliRetrieveResponse response = new SBCliRetrieveResponse();
        RulesData data = new RulesData();

        // Mocking the behavior of dependencies
        when(engine.executeRule(any(), any())).thenReturn("en_US");
        when(workflowFactory.getWorkflow(any(), any(), any(), any(), any())).thenReturn(Map.of(
                WorkflowFactory.ATTRIBUTE.WORKFLOW, "workflowId",
                WorkflowFactory.ATTRIBUTE.METHOD, "methodId"
        ));
        when(engine.executeWorkflow(any(), any())).thenReturn(data);
        data.put(CliConstants.RESPONSE, response);

        mockMvc.perform(MockMvcRequestBuilders.post("/smallbusiness/v1/retrieve")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"payload\": {\"account\": {\"adx\": \"123\"}}}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.payload").exists());
    }

    @Test
    void testRetrieveSmallBusinessCliDetails_InvalidRequest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/smallbusiness/v1/retrieve")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"payload\": {}}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}
