package COMIX;
import java.util.List;

import COMIX.Browse.BrosweStrategy;
import COMIX.Browse.BrowseAll;
import COMIX.Browse.BrowseByPage;
import COMIX.CSVFileReader.CSVFileReader;
import COMIX.ComicGrader.Comic;

public class PersonalDatabase {
    private final String personalDataFile = "src/main/java/COMIX/data/personalcomics.csv";
    private final List<Comic> personalComics;
    private BrosweStrategy strategy;

    public PersonalDatabase(){
        personalComics = CSVFileReader.readFile(personalDataFile);
    }

    public List<Comic> getCollection(){
        return personalComics;
    }

    public void setBrowseStrategy(BrosweStrategy strategy){
        this.strategy = strategy;
    }

    public void browse(){
        strategy.doBrowse(personalComics);
    }

  public static void main(String[] args) {
    PersonalDatabase database = new PersonalDatabase();
    database.setBrowseStrategy(new BrowseByPage(10));
    database.browse();

    System.out.println();

    database.setBrowseStrategy(new BrowseAll());
    database.browse();

    System.out.println();

  }
}
