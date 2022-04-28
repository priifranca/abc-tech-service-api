package Fiap.abctechservice.application.impl;

import Fiap.abctechservice.application.AssistanceApplication;
import Fiap.abctechservice.application.dto.AssistDto;
import Fiap.abctechservice.model.Assistance;
import Fiap.abctechservice.service.AssistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AssistanceApplicationImpl implements AssistanceApplication {

    private final AssistanceService assistanceService;

    public AssistanceApplicationImpl(
            @Autowired
                    AssistanceService assistanceService) {
        this.assistanceService = assistanceService;
    }


    @Override
    public List<AssistDto> getAssists() {
        List<Assistance> listAssists = this.assistanceService.getAssistsList();
        return listAssists.stream().map(
                assistance -> new AssistDto(assistance.getId(), assistance.getName(), assistance.getDescription())
        ).collect(Collectors.toList());
    }
}
