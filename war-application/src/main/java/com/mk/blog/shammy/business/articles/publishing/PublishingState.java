package com.mk.blog.shammy.business.articles.publishing;

public enum PublishingState {
    DRAFT(0),
    PUBLISHED(1),
    MODIFIED(2),
    DELETED(-1);
    private final long id;

    PublishingState(long id){
        this.id=id;
    }

    public static PublishingState valueOf(Long publishingStateId) {
        if (publishingStateId == null) {
            return null;
        }

        for (PublishingState position : PublishingState.values()) {
            if (publishingStateId.equals(position.getId())) {
                return position;
            }
        }
        throw new IllegalArgumentException("No matching type for id " + publishingStateId);
    }


    public long getId() {
        return id;
    }
}
