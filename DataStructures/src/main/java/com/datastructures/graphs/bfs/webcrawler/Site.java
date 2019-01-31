package com.datastructures.graphs.bfs.webcrawler;

import java.net.URL;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Site {
	
	private URL url;
	@Setter
	private boolean isVisited;
	
	
	public Site(URL url) {
		this.url = url;
	}

}
