package uk.laxd.deepweb.service;

import java.util.Collection;
import java.util.Map;

/**
 * Created by lawrence on 21/04/16.
 */
public interface CollectionToMap<A, B, C> {
    Map<A, B> toMap(Collection<C> c);
}
