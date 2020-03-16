package com.prueba.datatransfer;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonaDTO {

	private Long count;
	private String next;
	private String previous;
	private List<ResultsDTO> results;
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
	public List<ResultsDTO> getResults() {
		return results;
	}
	public void setResults(List<ResultsDTO> results) {
		this.results = results;
	}
	
	
}
