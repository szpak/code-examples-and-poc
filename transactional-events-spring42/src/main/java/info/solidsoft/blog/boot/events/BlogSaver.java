package info.solidsoft.blog.boot.events;

import info.solidsoft.blog.boot.events.domain.Blog;
import info.solidsoft.blog.boot.events.domain.event.BlogAddedEvent;
import info.solidsoft.blog.boot.events.repository.BlogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.invoke.MethodHandles;

@Service
@Transactional
public class BlogSaver {

    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final ApplicationEventPublisher publisher;
    private final BlogRepository blogRepository;

    @Autowired
    public BlogSaver(ApplicationEventPublisher publisher, BlogRepository blogRepository) {
        this.publisher = publisher;
        this.blogRepository = blogRepository;
    }

    void saveAndSendEvent(Blog blog) {
        log.info("Saving blog");
        blogRepository.save(blog);

        log.info("Publishing event");
        publisher.publishEvent(new BlogAddedEvent(blog));

        log.info("Synchronous business logic finished");
    }
}
