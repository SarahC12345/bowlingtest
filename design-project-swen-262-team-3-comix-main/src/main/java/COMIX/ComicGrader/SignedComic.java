package COMIX.ComicGrader;

import java.util.stream.Stream;

public class SignedComic extends GradeComic{
    public SignedComic(int grade, Comic comic){
        super(comic);
    }
    public double getTotalValue(){
        return super.getTotalValue() * 1.05;
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
    }
}
