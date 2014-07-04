package Parser;

public class TextScrapper {

	String pageSrc;
	public TextScrapper(String pageSrc) {
		this.pageSrc = pageSrc;
	}
	public void getSiteMapIndex() {

	}
	public String getSiteMapLink() {
		String link = "";
		if(pageSrc.contains("sitemap") || pageSrc.contains("site-map")){
			int start = pageSrc.indexOf("sitemap");
			int end = pageSrc.indexOf("\">", start);
			link = pageSrc.substring(start, end);
		}else{
			System.out.println("There is no SiteMap for this Website");
		}
		return link;
	}
	public String getmenuLink() {
		String link = "";
		if(pageSrc.contains("MENU")){
			int start = pageSrc.indexOf("sitemap");
			int end = pageSrc.indexOf("\">", start);
			link = pageSrc.substring(start, end);
		}else{
			System.out.println("There is no SiteMap for this Website");
		}
		return link;
	}
}
