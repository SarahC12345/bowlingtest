package COMIX.ComicGrader;

import java.util.stream.Stream;

public class AuthenticatedComic extends GradeComic{
    public AuthenticatedComic(int grade, SignedComic comic){
        super(comic);
    }
    public double getTotalValue(){
        return super.getTotalValue() * 1.2;
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
