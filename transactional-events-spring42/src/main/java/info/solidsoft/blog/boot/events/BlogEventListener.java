package info.solidsoft.blog.boot.events;

import info.solidsoft.blog.boot.events.domain.event.BlogAddedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.lang.invoke.MethodHandles;

@Component
public class BlogEventListener {

    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final NotificationSender notificationSender;

    @Autowired
    public BlogEventListener(NotificationSender notificationSender) {
        this.notificationSender = notificationSender;
    }

    @EventListener
    public void blogAdded(BlogAddedEvent blogAddedEvent) {
        log.info("Sending standard external notification for added blog: {}", blogAddedEvent.getBlog());
        notificationSender.blogAdded(blogAddedEvent);
    }

    @EventListener
    public void blogAddedTransactionalOldSchool(final BlogAddedEvent blogAddedEvent) {
        //Note: *Old school* transaction handling before Spring 4.2
        if (TransactionSynchronizationManager.isActualTransactionActive()) {    //To not fail with "java.lang.IllegalStateException: Transaction synchronization is not active"
            TransactionSynchronizationManager.registerSynchronization(
                    new TransactionSynchronizationAdapter() {
                        @Override
                        public void afterCommit() {
                            internalSendBlogAddedNotification(blogAddedEvent);
                        }
                    });
        } else {
            log.warn("No active transaction found. Sending notification immediately.");
            internalSendBlogAddedNotification(blogAddedEvent);
        }
    }

    private void internalSendBlogAddedNotification(BlogAddedEvent blogAddedEvent) {
        log.info("Transactional old-school sending external notification for added blog: {}", blogAddedEvent.getBlog());
        notificationSender.blogAddedTransactionalOldSchool(blogAddedEvent);
    }

    @TransactionalEventListener
    public void blogAddedTransactional(BlogAddedEvent blogAddedEvent) {
        log.info("Transactional sending external notification for added blog: {}", blogAddedEvent.getBlog());
        notificationSender.blogAddedTransactional(blogAddedEvent);
    }

    @TransactionalEventListener(fallbackExecution = true)
    public void blogAddedTransactionalWithFallback(BlogAddedEvent blogAddedEvent) {
        log.info("Transactional (with fallback) sending external notification for added blog: {}", blogAddedEvent.getBlog());
        notificationSender.blogAddedTransactionalWithFallback(blogAddedEvent);
    }
}
