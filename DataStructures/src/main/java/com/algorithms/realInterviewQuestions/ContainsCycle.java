package com.algorithms.realInterviewQuestions;
public class ContainsCycle {

    interface Link {
        Link getNext();
    }

    /**
     * @parm link is a non-null instance of a link in a list
     * @return true if link is part of a list that contains a cycle
     */
    public static boolean containsCycle(Link link) {
        //TODO implement
    	
    	Link prev = link;
    	Link current = prev;
    	
    	boolean isCycle = false;
    	
    	while (prev != null && current != null) {
    		
    		if (prev == current) {
    			
    			// log and return
    			isCycle = true;
    			break;
    		}
    		
    		prev = prev.getNext();
    		current = current.getNext();
    		
    		if (current != null) {
    			current = current.getNext();
    		}
    		
    	}
    	
    	// What is Link has only one node?
    	
    	
        return isCycle;
    }

    public static void main(String[] args) throws Exception {
        if (containsCycle(newLinkList(100,-1))) throw new Exception ("Wrong Answer");
        if (!containsCycle(newLinkList(100,0))) throw new Exception ("Wrong Answer");
        if (!containsCycle(newLinkList(100,1))) throw new Exception ("Wrong Answer");
    }

    private static Link newLinkList(int size, int tailSize) {
        LinkImpl last = new LinkImpl(null);
        Link first = last;
        int iAfterLast = size-2-tailSize;
        for (int i=0, n=size-1; i<n; ++i) {
            first = new LinkImpl(first);
            if (i == iAfterLast)
                last.setNext(first);
        }
        return first;
    }

    static class LinkImpl implements Link {
        private Link next;

        LinkImpl (Link next) {
            setNext(next);
        }

        public Link getNext() {
            return next;
        }

        public void setNext(Link next) {
            this.next = next;
        }
    }
}


