package uk.co.n3tw0rk.profiler.docker.WebSocket.Controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class DockerController {

    @MessageMapping("/stats")
    @SendTo("/topic/docker/stats")
    public void statsSubscription() {}
}
