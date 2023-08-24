package com.poc.graphql.resolver;

import com.poc.graphql.model.DataModel;
import com.poc.graphql.service.IDataService;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataResolver {
    @Autowired
    IDataService dataService;


    @GraphQLQuery(name = "getData", description = "Get all books")
    public List<DataModel> getData()  {
        return dataService.getData();
    }

}
