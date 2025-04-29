package mylab.notification.di.annot.config;

import mylab.notification.di.annot.NotificationManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringJUnitConfig(NotificationConfig.class)
public class NotificationConfigTest {

    @Autowired
    private NotificationManager notificationManager;

    @Test
    void testNotificationManager() {
        assertNotNull(notificationManager);
        assertNotNull(notificationManager.getEmailService());
        assertNotNull(notificationManager.getSmsService());

        notificationManager.sendNotificationByEmail("이메일 테스트 메시지");
        notificationManager.sendNotificationBySms("SMS 테스트 메시지");
    }
}
