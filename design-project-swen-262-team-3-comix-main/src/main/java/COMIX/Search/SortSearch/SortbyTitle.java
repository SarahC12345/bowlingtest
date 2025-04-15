package COMIX.Search.SortSearch;

import java.util.*;

import COMIX.ComicGrader.Comic;


public class SortbyTitle implements SortStrategy{
    @Override
    public List<Comic> sort(List<Comic> results){
        results.sort(Comparator.comparing(Comic::getStoryTitle));
        return results;
    }
}