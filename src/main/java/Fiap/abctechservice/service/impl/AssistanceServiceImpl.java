package Fiap.abctechservice.service.impl;

import Fiap.abctechservice.model.Assistance;
import Fiap.abctechservice.repository.AssistanceRepository;
import Fiap.abctechservice.service.AssistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssistanceServiceImpl implements AssistanceService {

    private final AssistanceRepository repository;

    public AssistanceServiceImpl(
            @Autowired
                    AssistanceRepository repository
    ) {
        this.repository = repository;
    }

    @Override
    public List<Assistance> getAssistsList() {
        return this.repository.findAll();
    }
}
