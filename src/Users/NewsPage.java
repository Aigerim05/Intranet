import java.util.ArrayList;

public class NewsPage {
    // List of News objects
    private ArrayList<News> listOfNews;

    // Constructor
    public NewsPage() {
        this.listOfNews = new ArrayList<>();
    }

    // Method to add a news item to the list
    public void addNews(News news) {
        if (news != null) {
            this.listOfNews.add(news);
        }
    }

    // Method to remove a news item by its ID
    public void removeNews(String newsId) {
        this.listOfNews.removeIf(news -> news.getNewsId().equals(newsId));
    }

    // Method to get the list of all news items
    public ArrayList<News> getListOfNews() {
        return listOfNews;
    }

    // Method to display all ту 
    public void displayNews() {
        for (News news : listOfNews) {
            System.out.println(news);
        }
    }
}
