package com.qmberi.testwebatrio.controllers;


import com.qmberi.testwebatrio.services.EnterpriseService;
import com.qmberi.testwebatrio.services.PersonService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("enterprise")
@CrossOrigin(origins = "*")
public class EnterpriseController {

    private EnterpriseService enterpriseService;
    private PersonService personService;

    public EnterpriseController(EnterpriseService enterpriseService, PersonService personService) {
        this.enterpriseService = enterpriseService;
        this.personService = personService;
    }

}
