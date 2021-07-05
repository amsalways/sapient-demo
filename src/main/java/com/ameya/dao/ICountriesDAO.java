package com.ameya.dao;

import java.util.List;

import com.ameya.domain.Country;

public interface ICountriesDAO extends IDAO<Country> {

    List<Country> findByName(String name);

    List<Country> findByContinent(String name);

    Country findByCode(String code);
}
