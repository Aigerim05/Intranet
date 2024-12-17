package Users;

import java.util.Date;

public class TestRes{
	public static void main(String[] args) {
	    // Создание объектов ResearchPaper
	    ResearchPaper paper1 = new ResearchPaper("Paper 1", null, 10, new Date(), true, 50);
	    ResearchPaper paper2 = new ResearchPaper("Paper 2", null, 15, new Date(), false, 75);
	    ResearchPaper paper3 = new ResearchPaper("Paper 3", null, 8, new Date(), true, 30);
	    ResearchPaper paper4 = new ResearchPaper("Paper 4", null, 12, new Date(), false, 100);

	    // Создание ResearchDecorator и добавление публикаций
	    ResearchDecorator researcher = new ResearchDecorator();
	    researcher.addPaper(paper1);
	    researcher.addPaper(paper2);
	    researcher.addPaper(paper3);
	    researcher.addPaper(paper4);

	    // Вызов метода printResearchPapers
	    researcher.printResearchPapers();
	}
}

