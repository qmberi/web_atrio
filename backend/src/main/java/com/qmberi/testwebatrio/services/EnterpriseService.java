package com.qmberi.testwebatrio.services;

import com.qmberi.testwebatrio.domains.Enterprise;
import com.qmberi.testwebatrio.repositories.EnterpriseRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseService {

    private final EnterpriseRepository enterpriseRepository;

    public EnterpriseService(EnterpriseRepository enterpriseRepository) {
        this.enterpriseRepository = enterpriseRepository;
    }

}
