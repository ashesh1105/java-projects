package com.datastructures.linkedlist.dictionary;

import lombok.Getter;
import lombok.Setter;

public class DNode implements Comparable<DNode> {

    @Getter
    private String term;

    @Getter
    private String definition;

    @Getter
    @Setter
    private DNode next;

    public DNode(String term, String definition) {
        this.term = term;
        this.definition = definition;
    }

    @Override
    public int compareTo(DNode o) {
        if (!(o instanceof DNode)) {
            throw new RuntimeException("Error! Can't compare instances of multiple types!");
        }
        int comparision = this.term.compareTo(o.term);
        if (comparision == 0) {
            return this.definition.compareTo(o.definition);
        } else return comparision;
    }

    @Override
    public String toString() {
        return term + " -> " + definition;
    }
}
