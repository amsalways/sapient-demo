package com.ameya.dao;

import java.util.List;

import com.ameya.domain.NavAid;


public interface INavAidsDAO extends IDAO<NavAid> {


    List<NavAid> findByName(String name);
}
