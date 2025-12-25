package org.solvd.test.api;

import org.skyscreamer.jsonassert.JSONCompareMode;
import org.solvd.api.GetWorkFlowsMethod;
import org.testng.annotations.Test;

public class GetWorkFlowsMethodTest  {

    @Test
    public void getWorkFlowsMethodTest() {
        GetWorkFlowsMethod workFlowApi = new GetWorkFlowsMethod();
        workFlowApi.callAPIExpectSuccess();
        workFlowApi.validateResponse(JSONCompareMode.LENIENT);
    }
}
