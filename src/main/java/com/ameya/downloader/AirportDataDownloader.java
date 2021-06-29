package com.ameya.downloader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AirportDataDownloader {

	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
		HttpRequest request=HttpRequest.newBuilder(new URI("https://ourairports.com/data/airports.csv"))
				.GET()
				.timeout(Duration.ofMinutes(1))
				.build();
		HttpResponse<String> response=HttpClient.newHttpClient()
				.send(request,HttpResponse.BodyHandlers.ofString());
		//System.out.println(response.body());
		BufferedReader reader=new BufferedReader(new StringReader(response.body()));
		String line="";
		List<String> airports=new ArrayList<String>();
		while((line=reader.readLine())!=null) {
			airports.add(line.replace("\"",""));
		}
		//Filteration through Lambda and stream API
		List<String> small_airports=airports
				.stream()
				.filter(airport->airport.contains("small_airport"))
				.collect(Collectors.toList());
		
		List<String> large_airports=airports
				.stream()
				.filter(airport->airport.contains("large_airport"))
				.collect(Collectors.toList());
		
		List<String> medium_airports=airports
				.stream()
				.filter(airport->airport.contains("medium_airport"))
				.collect(Collectors.toList());
		/* This might create multiple threads to read data but not guaranteed the data may be fetched in different order everytime.
		 * List<String> medium_airports=airports
				.parallelStream()
				.filter(airport->airport.contains("medium_airport"))
				.collect(Collectors.toList());
		 */
		
		
		System.out.println(small_airports.size());
		System.out.println(large_airports.size());
		System.out.println(medium_airports.size());
		System.out.println(airports
				.stream()
				//.filter(airport->airport.contains("Shivaji"))
				.filter(airport->filterByNamePredicate(airport))
				.findAny()
				.orElse(null));
		
		//List<String> distinctAirports=airports.stream().distinct().collect(Collectors.toList());
		//System.out.println(distinctAirports);
	}
	
	 public static boolean filterByNamePredicate(String airportName) { boolean
	 status=false; if(airportName.contains("Sivaji")) { status= true; } return
	  status; }
	 

}
