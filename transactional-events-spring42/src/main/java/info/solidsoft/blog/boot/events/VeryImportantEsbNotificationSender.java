package info.solidsoft.blog.boot.events;

import info.solidsoft.blog.boot.events.domain.event.BlogAddedEvent;
import org.springframework.stereotype.Component;

/**
 * Very important ESB (or whatever Enterprise) notification sender.
 */
@Component
public class VeryImportantEsbNotificationSender implements NotificationSender {

    @Override
    public void blogAdded(BlogAddedEvent blogAddedEvent) {
        //...
    }

    @Override
    public void blogAddedTransactional(BlogAddedEvent blogAddedEvent) {
        //...
    }

    @Override
    public void blogAddedTransactionalWithFallback(BlogAddedEvent blogAddedEvent) {
        //...
    }

    @Override
    public void blogAddedTransactionalOldSchool(final BlogAddedEvent blogAddedEvent) {
        //...
    }
}
