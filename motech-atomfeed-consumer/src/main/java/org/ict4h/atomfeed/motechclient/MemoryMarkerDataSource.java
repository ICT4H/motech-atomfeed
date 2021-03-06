package org.ict4h.atomfeed.motechclient;

import org.ict4h.atomfeed.client.domain.Marker;
import org.ict4h.atomfeed.client.repository.datasource.MarkerDataSource;

import java.net.URI;
import java.util.HashMap;

public class MemoryMarkerDataSource implements MarkerDataSource{
    private HashMap<URI, Marker> map=new HashMap<URI, Marker>();


    @Override
    public Marker get(URI feedUri) {
        return map.get(feedUri);
    }

    @Override
    public void put(Marker marker) {
        map.put(marker.getFeedUri(), marker);
    }
}
