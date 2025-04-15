package COMIX.Search.SortSearch;

import java.util.*;

import COMIX.ComicGrader.Comic;


public class SortbySeries implements SortStrategy{
    @Override
    public List<Comic> sort(List<Comic> results){
        results.sort(Comparator.comparing(Comic::getSeriesTitle));
        return results;
    }
}