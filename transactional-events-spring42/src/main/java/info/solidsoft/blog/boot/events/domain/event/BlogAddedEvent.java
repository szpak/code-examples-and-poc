package info.solidsoft.blog.boot.events.domain.event;

import info.solidsoft.blog.boot.events.domain.Blog;

public class BlogAddedEvent extends BaseBlogEvent {

    public BlogAddedEvent(Blog blog) {
        super(blog);
    }
}
