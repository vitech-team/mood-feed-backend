package com.vitech.moodfeed.dto;

import com.vitech.moodfeed.domain.Message;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class MessageRequest {

    String message;
    Long creatorId;

    public Message toMessage() {
        return Message.builder()
                .message(message)
                .creatorId(creatorId)
                .build();
    }

}
