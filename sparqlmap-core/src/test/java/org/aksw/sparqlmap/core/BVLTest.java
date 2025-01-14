package org.aksw.sparqlmap.core;

import java.io.File;

import org.aksw.sparqlmap.backend.metamodel.MetaModelBackend;
import org.apache.jena.sparql.core.DatasetGraph;
import org.apache.metamodel.DataContext;
import org.apache.metamodel.csv.CsvDataContext;
import org.junit.Test;

public class BVLTest {
  
  
  @Test
  public void testDirectMapping(){
    DataContext dc = new CsvDataContext(new File("./src/test/resources/bvl/le-online-extracted-places.csv"));
    MetaModelBackend mmBackend = new MetaModelBackend(dc);
    SparqlMap sm = SparqlMapBuilder.newSparqlMap("http://example.org/test/").connectTo(mmBackend).mappedByDefaultMapping().create();
    
    DatasetGraph dsg =  sm.getDumpExecution().dumpDatasetGraph();
    
    dsg.getDefaultGraph().find(null, null, null).forEachRemaining(System.out::println);
    
    
  }

}
