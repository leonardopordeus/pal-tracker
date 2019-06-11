package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    HashMap<Long, TimeEntry> db;
    private static long lastId;

    public InMemoryTimeEntryRepository() {
        this.db = new HashMap<>();
        this.lastId = 0;
    }

    public TimeEntry create(TimeEntry timeEntry) {
        lastId = lastId+1;
        timeEntry.setId(lastId);
        db.put(lastId,timeEntry);
        return timeEntry;
    }

    public TimeEntry update(long id, TimeEntry timeEntry)
    {
        if(db.containsKey(id)) {
            timeEntry.setId(id);
            db.put(id, timeEntry);
            return timeEntry;
        }
        return null;
    }

    public TimeEntry find(long id) {
        return db.get(id);
    }

    public List<TimeEntry> list() {
        List<TimeEntry> result = new ArrayList<>(db.values());
        return result;
    }

    public void delete(long id){
        if(db.containsKey(id)) {
            db.remove(id);
        }
    }
}

