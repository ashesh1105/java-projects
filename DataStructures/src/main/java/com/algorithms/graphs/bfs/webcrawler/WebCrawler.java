package com.algorithms.graphs.bfs.webcrawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.Getter;

import org.apache.commons.lang3.StringUtils;

public class WebCrawler {

	private Queue<String> queue;
	private List<String> discoveredWesiteList;

	public WebCrawler() {
		queue = new LinkedList<>();
		discoveredWesiteList = new ArrayList<>();
	}

	public void startCrawl(String root) {

		this.queue.add(root);
		this.discoveredWesiteList.add(root);
		
		while (!queue.isEmpty()) {
			String v = this.queue.remove();
			String rawHtml = getRawHtml(v);
			String regexp = "http://(\\w+\\.)*(\\w+)";
			Pattern pattern = Pattern.compile(regexp);
			Matcher regexMatcher = pattern.matcher(rawHtml);
			
			while (regexMatcher.find()) {
				String newUrl = regexMatcher.group();
				if (!discoveredWesiteList.contains(newUrl)) {
					discoveredWesiteList.add(newUrl);
					System.out.println("Match for new URL found with URL: "
							+ newUrl);
					queue.add(newUrl);
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
				}
			}
		}
	}

	private String getRawHtml(String siteAddr) {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader in = new BufferedReader(new InputStreamReader(
				new URL(siteAddr).openStream()))) {
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				inputLine = in.readLine();
				// sb.append(current);
				sb.append(inputLine);
				sb.append("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage() + "\n" + e.getStackTrace());
		}

		// return sb.toString();
		return sb.toString();
	}
}
