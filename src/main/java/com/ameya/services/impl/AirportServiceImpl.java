package com.ameya.services.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ameya.dao.IAirportsDAO;
import com.ameya.dao.ICountriesDAO;
import com.ameya.dao.INavAidsDAO;
import com.ameya.dao.IRegionDAO;
import com.ameya.domain.Airport;
import com.ameya.domain.Country;
import com.ameya.domain.NavAid;
import com.ameya.domain.Region;
import com.ameya.functions.FilterFunctions;
import com.ameya.helpers.AirportType;
import com.ameya.services.IAirportService;

public class AirportServiceImpl implements IAirportService {

    IAirportsDAO airportsDAO;
    IRegionDAO regionDAO;
    INavAidsDAO navAidsDAO;
    ICountriesDAO countriesDAO;

    private static final Logger logger = LoggerFactory.getLogger(AirportServiceImpl.class);

    public AirportServiceImpl(IAirportsDAO airportsDAO, IRegionDAO regionDAO, INavAidsDAO navAidsDAO, ICountriesDAO countriesDAO) {
        this.airportsDAO = airportsDAO;
        this.regionDAO = regionDAO;
        this.navAidsDAO = navAidsDAO;
        this.countriesDAO = countriesDAO;

    }

    @Override
    public List<Airport> listAllAirports() {
        return airportsDAO.findAll();
    }

    @Override
    public List<Airport> findAirportsByName(String name) {
        return airportsDAO.findByName(name);
    }

    @Override
    public List<Airport> findAirportsByCountry(String country) {
        return airportsDAO.findByCountry(country);
    }

    @Override
    public List<Airport> findAirportsByRunways() {
        throw new RuntimeException("No Implementation ");
    }

    @Override
    public List<Airport> listAllHeliports() {
        return airportsDAO.findByType(AirportType.HELIPORT.heliport());
    }

    @Override
    public List<Airport> listAirportsByContinent(String continent) {
        return Collections.emptyList();
    }

    @Override
    public List<Region> listAllRegions() {
        return regionDAO.findAll();
    }

    @Override
    public List<NavAid> listAllNavaids() {
        return this.navAidsDAO.findAll();
    }

    @Override
    public Airport getRandomAirport() {
        Random r = new Random();
        int low = 1;
        int high = airportsDAO.findAll().size();
        int result = r.nextInt(high - low) + low;
        return airportsDAO.findAll().get(result);
    }

    @Override
    public void listAllCountries() {
        this.countriesDAO.findAll();
    }

    @Override
    public List<String> listAllContinents() {
        List<Country> personListFiltered = countriesDAO.findAll().stream()
                .filter(FilterFunctions.distinctByKey(p -> p.getContinent()))
                .collect(Collectors.toList());
        return personListFiltered.stream().map(r -> r.getContinent()).collect(Collectors.toList());
    }

    @Override
    public void login() {
        throw new RuntimeException("Login Not Implemented");
    }

    @Override
    public void signup() {
        throw new RuntimeException("Signup Not Implemented");
    }

    @Override
    public void help() {
        throw new RuntimeException("Help Not implemented");
    }

    @Override
    public List<Airport> airportsSorted(String key) {
        Comparator<Airport> compareByName = Comparator.comparing(Airport::getName );
        return airportsDAO.findAll().stream().sorted(compareByName).collect(Collectors.toList());
    }

    @Override
    public void listAirportsPaginated() {
        throw new RuntimeException("Not Yet implemented .");
    }

}
