package com.ameya.dao;

import java.util.List;

import com.ameya.domain.Region;

public interface IRegionDAO extends IDAO<Region> {
    Region findByCode(String code);
    List<Region> findByContinent(String continent);
    List<Region> findByName(String name);
}
