package info.solidsoft.blog.boot.events.domain.event;

import info.solidsoft.blog.boot.events.domain.Blog;

public class BaseBlogEvent implements DomainEvent<Blog> {

    /**
     * <b>Please notice</b> that using domain objects in the events has notable drawback and is not the best idea in many situations.
     * Pseudodomain objects in the code examples were used to not introduce unnecessary complexity.
     */
    private final Blog blog;

    public BaseBlogEvent(Blog blog) {
        this.blog = blog;
    }

    public Blog getBlog() {
        return blog;
    }
}
