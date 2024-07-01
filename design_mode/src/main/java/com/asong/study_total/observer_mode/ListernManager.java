package com.asong.study_total.observer_mode;

import java.io.File;
import java.util.*;

public class ListernManager {

    private static final Map<String, List<ListernService>> LIST_MAP= new HashMap<>();

    public ListernManager(String... type) {

        for (String s : type) {
            if (!LIST_MAP.containsKey(s)) {
                LIST_MAP.put(s, new ArrayList<>());
            }
        }

    }


    public void addListernService(String type, ListernService listernService) {
        if (!LIST_MAP.containsKey(type)) {
            LIST_MAP.put(type, Collections.singletonList(listernService));
            return;
        }
        LIST_MAP.get(type).add(listernService);
    }


    public void removeListernService(String type, ListernService listernService) {
        LIST_MAP.get(type).remove(listernService);
    }

    public void notify(String type, File file) {
        for (ListernService listernService : LIST_MAP.get(type)) {
            listernService.update(type,file);
        }
    }

}
