package com.zendesk.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
//@JsonIgnoreProperties(ignoreUnknown = true)
public class TicketResponse {
    @JsonAlias({"id"})
    private long id;
    @JsonAlias({"assignee_id"})
    private long assigneeId;
    @JsonAlias({"priority"})
    private String priority;
    @JsonAlias({"status"})
    private String status;
    @JsonAlias({"subject"})
    private String subject;
    @JsonAlias({"type"})
    private String type;
    @JsonAlias({"description"})
    private String description;
}
