
package com.bugcat.apiResVal.service;

import com.bugcat.apiResVal.entity.ResenaValoracion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "resena-service",
        url = "http://localhost:8085/")
public interface ApiRestClient {
    @GetMapping("api/v1/resena/findByResenavalSK/{resenavalSK}")
    ResenaValoracion findByResenavalSK(@PathVariable String resenavalSK);
}
