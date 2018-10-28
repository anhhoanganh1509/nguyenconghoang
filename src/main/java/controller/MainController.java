package controller;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import entity.CrawlEntity;
import repository.CrawlRepository;

@Controller
public class MainController {
	@Autowired
	CrawlRepository crawlRepo;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String Main(Model model){
        return "login";
    }
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(){		
        return "index";
    }
	@RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user(){		
        return "user";
    }
	@RequestMapping(value = "/crawl",method = RequestMethod.GET)
    public String save(Model model){
		String linkViblo="https://viblo.asia/";
		try {
			Document doc = Jsoup.connect(linkViblo).timeout(5000).get();
	    	Elements questions = doc.select("ul[class=pagination]").select("a[href]");
	    	if(questions.size() == 1) {
        		Document docPage=Jsoup.connect(linkViblo).timeout(5000).get();
        		Elements questionsPage = docPage.select("div[class=post-title--inline]").select("h3[class=word-break mr-05]").select("a[href]");
        		for (Element linkPage : questionsPage) {
            		if (linkPage.attr("href").contains("java")) {
            			
            		}else {
            			CrawlEntity crawl = new CrawlEntity();
            			crawl.setCrawlURL(linkPage.attr("abs:href"));
            			crawlRepo.save(crawl);
            		}
                }
        	}else {
        		int count = 0;
    	    	for(Element link : questions) {
    	    		count++;
    	    		if(count == questions.size()-1) {
    	    			int countPage = Integer.parseInt(link.attr("href").split("=")[1]);
    	            	for(int i=1; i<=1; i++) {
    	            		Document docPage=Jsoup.connect(linkViblo+"?page="+i).timeout(5000).get();
    	            		Elements questionsPage = docPage.select("div[class=post-title--inline]").select("h3[class=word-break mr-05]").select("a[href]");
    	            		for (Element linkPage : questionsPage) {
    	                		if (linkPage.attr("href").contains("java")) {
    	                			
    	                		}else {
    	                			CrawlEntity crawlEntity = new CrawlEntity();
                					crawlEntity.setCrawlURL(linkPage.attr("abs:href"));
                					crawlRepo.save(crawlEntity);    	                			
    	                		}
    	                    }
    	            	}
    	    		}
    	    	}
        	}			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("msg","sucess");
        return "index";
    }
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {
		if (error != null) {
			model.addAttribute("error", "Invalid username and password!");
		}
		if (logout != null) {
			model.addAttribute("msg", "You've been logged out successfully.");
		}
		return "login";
	}

}
