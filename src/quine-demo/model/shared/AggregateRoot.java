// MR-1, MR-2, MR-3: Base class for all aggregate roots

package quine.demo.model.shared;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Abstract base class for all aggregate roots in the domain model.
 * Aggregate roots are the entry points for all interactions with an aggregate.
 * They maintain a list of uncommitted domain events that occurred during their lifecycle.
 */
public abstract class AggregateRoot {
    private final List<DomainEvent> uncommittedEvents = new ArrayList<>();

    /**
     * Publishes a domain event by adding it to the list of uncommitted events.
     * This method is called by concrete aggregate roots when they want to emit an event.
     *
     * @param event the domain event to publish
     */
    protected void publish(DomainEvent event) {
        if (event == null) {
            throw new IllegalArgumentException("Domain event cannot be null");
        }
        uncommittedEvents.add(event);
    }

    /**
     * Returns an unmodifiable list of uncommitted domain events.
     *
     * @return list of uncommitted events
     */
    public List<DomainEvent> getUncommittedEvents() {
        return Collections.unmodifiableList(uncommittedEvents);
    }

    /**
     * Clears the list of uncommitted events after they have been persisted.
     */
    public void clearUncommittedEvents() {
        uncommittedEvents.clear();
    }
}
