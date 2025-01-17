package com.qaprosoft.carina.demo.api.testapi;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

@Endpoint(url = "${base_url}/posts/1", methodType = HttpMethodType.DELETE)
@ResponseTemplatePath(path = "api/testapi/_delete/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class DeleteMethod extends AbstractApiMethodV2 {

    public DeleteMethod() {
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("test_api_url"));
    }
}
