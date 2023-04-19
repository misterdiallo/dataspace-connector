package com.misterdiallo.backend.connector.services;

import com.misterdiallo.backend.connector.secutiry.policies.Policy;
import com.misterdiallo.backend.connector.secutiry.policies.PolicyEnum;
import org.springframework.stereotype.Service;

@Service
public class PolicyService {
    @Policy(PolicyEnum.OPEN)
    public String openPolicy() {
        return "Open Policy Service";
    }

    @Policy(PolicyEnum.RESTRICTED)
    public String restrictedPolicy() {
        return "Restricted Policy Service";
    }

    @Policy(PolicyEnum.LIMITED)
    public String limitedPolicy() {
        return "Limited Policy Service";
    }
}
