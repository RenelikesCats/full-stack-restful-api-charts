package com.rene.chart2023analyse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("principal")
public class PrincipalController {

    @GetMapping
    String findPrincipal(Principal principal) {
        return principal == null ? "" : principal.getName();
    }
}
