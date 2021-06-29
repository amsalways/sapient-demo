package com.ameya.downloader;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AirportDataModification {

	public static void main(String[] args) {
		List<String> airports=new ArrayList<String>();
		for(int i=0;i<10;i++) {
			airports.add("Airport"+i);
		}

		List<String> appendedNamesToAirport=airports
											.stream()
											.map(a->a+1)
											.collect(Collectors.toList());
		System.out.println(airports);
		System.out.println(appendedNamesToAirport);
		
		System.out.println(airports.stream().collect(Collectors.joining("|")));
		System.out.println(airports);
	}

}
