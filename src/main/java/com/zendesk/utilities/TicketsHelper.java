package com.zendesk.utilities;

import com.zendesk.dto.TicketResponse;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class TicketsHelper {
    private List<TicketResponse> ticketResponses;
}
