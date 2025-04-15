package COMIX.ComicGrader;

import java.util.stream.Stream;

public class SlabbedComic extends GradeComic{
    public SlabbedComic(int grade, Comic comic){
        super(comic);
    }
    public double getTotalValue(){
        return super.getTotalValue() * 2;
    }
    @Override
    public String toString() {
        return Stream.of(
                getTotalValue(),
                getPublisher(),
                getSeriesTitle(),
                getStoryTitle(),
                getVolumeNumber(),
                getIssueNumber(),
                getPublicationDate(),
                getCreators(),
                getPrincipleCharaters(),
                getDescription()
        ).map(String::valueOf)
         .reduce((a, b) -> a + ", " + b)
         .orElse("");
}}
