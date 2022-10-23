package com.qaprosoft.carina.demo.api.testapi;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

@Endpoint(url = "${base_url}/posts/1", methodType = HttpMethodType.PUT)
@RequestTemplatePath(path = "api/testapi/_put/rq.json")
@ResponseTemplatePath(path = "api/testapi/_put/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PutMethod extends AbstractApiMethodV2 {

    public PutMethod() {
        super("api/testapi/_put/rq.json", "api/testapi/_put/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("test_api_url"));
    }
}
