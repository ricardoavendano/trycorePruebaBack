package com.prueba.datatransfer;

import java.util.List;

public class PlanetaDTO {

	private Long count;
	private String next;
	private String previous;
	private List<ResultsPlanetDTO> results;

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public String getPrevious() {
		return previous;
	}

	public void setPrevious(String previous) {
		this.previous = previous;
	}

	public List<ResultsPlanetDTO> getResults() {
		return results;
	}

	public void setResults(List<ResultsPlanetDTO> results) {
		this.results = results;
	}

}
