package com.agriculture_platform.Notification.Service;

import com.agriculture_platform.Notification.Entity.Notification;
import com.agriculture_platform.Notification.Repository.NotificationRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class PushNotificationService {


    private final NotificationRepository notificationStorageRepository;


    public PushNotificationService(NotificationRepository notificationStorageRepository) {
        this.notificationStorageRepository = notificationStorageRepository;
    }

    private List<Notification> getNotifs(String userID) {
        var notifs = notificationStorageRepository.findByUserToIdAndDeliveredFalse(userID);
        notifs.forEach(x -> x.setDelivered(true));
        notificationStorageRepository.saveAll(notifs);
        return notifs;
    }

    public Flux<ServerSentEvent<List<Notification>>> getNotificationsByUserToID(String userID) {

        if (userID != null && !userID.isBlank()) {
            return Flux.interval(Duration.ofSeconds(1))
                    .publishOn(Schedulers.boundedElastic())
                    .map(sequence -> ServerSentEvent.<List<Notification>>builder().id(String.valueOf(sequence))
                            .event("user-list-event").data(getNotifs(userID))
                            .build());
        }

        return Flux.interval(Duration.ofSeconds(1)).map(sequence -> ServerSentEvent.<List<Notification>>builder()
                .id(String.valueOf(sequence)).event("user-list-event").data(new ArrayList<>()).build());
    }
}
