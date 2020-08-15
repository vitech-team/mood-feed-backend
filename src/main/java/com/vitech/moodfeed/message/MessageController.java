package com.vitech.moodfeed.message;

import com.vitech.moodfeed.RepoRegistry;
import com.vitech.moodfeed.message.dto.Request;
import com.vitech.moodfeed.message.dto.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessageController {

    private final RepoRegistry repoRegistry;

    @GetMapping
    public List<Response> getMessages(@RequestParam(defaultValue = "10") int limit) {
        PageRequest pageReq = PageRequest.of(0, limit, Sort.by(Sort.Direction.DESC, "createdAt"));
        return Message.getNewest(pageReq, repoRegistry);
    }

    @PostMapping
    public void createMessage(@RequestBody Request request) {
        Message.save(request, repoRegistry);
    }

}
