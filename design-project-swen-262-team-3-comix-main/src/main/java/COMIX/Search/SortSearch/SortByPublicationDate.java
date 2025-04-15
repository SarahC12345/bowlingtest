package COMIX.Search.SortSearch;
import java.util.*;
import COMIX.ComicGrader.Comic;

public class SortByPublicationDate implements SortStrategy {

    @Override
    public List<Comic> sort(List<Comic> results) {
        results.sort(Comparator.comparing(comic -> {
            String pubDate = comic.getPublicationDate();

            // Check if the publication date is empty or invalid
            if (pubDate == null || pubDate.isEmpty()) {
                return "99999999"; 
            }

            // Split the publication date into parts (assuming format: yyyy-MM-dd, or other consistent format)
            String[] dateParts = pubDate.split("[^0-9]+"); 

            // Handle the case where the date format might not be as expected
            if (dateParts.length < 3) {
                return "99999999"; 
            }

            // Extract year, month, and day
            String year = dateParts[0];
            String month = dateParts[1];
            String day = dateParts[2];

            try {
                int monthInt = Integer.parseInt(month);
                int dayInt = Integer.parseInt(day);
                
                // Check if month and day are valid (1 <= month <= 12 and 1 <= day <= 31)
                if (monthInt < 1 || monthInt > 12 || dayInt < 1 || dayInt > 31) {
                    return "99999999"; 
                }
                
                
                return String.format("%s%02d%02d", year, monthInt, dayInt);
            } catch (NumberFormatException e) {
                return "99999999"; 
            }
        }));
        return results;
    }
}