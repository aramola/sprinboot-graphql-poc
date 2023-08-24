package com.poc.graphql.service;

import com.poc.graphql.model.DataModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataService implements IDataService {

    @Override
    public List<DataModel> getData() {
        List<DataModel> data = new ArrayList<>();
        for(int itr=0; itr<5; itr++)
            data.add(new DataModel(itr,"data value:"+ itr));
        return data;
    }
}
