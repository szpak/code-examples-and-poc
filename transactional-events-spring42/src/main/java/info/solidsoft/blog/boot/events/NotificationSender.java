package info.solidsoft.blog.boot.events;

import info.solidsoft.blog.boot.events.domain.event.BlogAddedEvent;

public interface NotificationSender {

    void blogAdded(BlogAddedEvent blogAddedEvent);

    void blogAddedTransactional(BlogAddedEvent blogAddedEvent);

    void blogAddedTransactionalWithFallback(BlogAddedEvent blogAddedEvent);

    void blogAddedTransactionalOldSchool(BlogAddedEvent blogAddedEvent);
}
