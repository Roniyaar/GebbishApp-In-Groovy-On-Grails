package com.org.geb

import geb.Browser;


import static org.springframework.http.HttpStatus.*

class LocationController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

  

    def find() {
		
        respond new Location(params)
		
    }
    
	def rentalDetails = {
		Browser.drive {
			go"http://www.airbnb.com/rooms/"+2060986
			report "Rental Details"
			def details = $("div.#details-column").find("div.panel-body")
			println"LLLLLLLLLLL"+details.text()
		}
	}
    
    def search() {
		int size = 0;
		int offset = 0
		if (params.offset){
			offset = Integer.parseInt(params.offset)
		}
		
		ArrayList<String> aList = new ArrayList<String>();
		Browser.drive {
			//cleanReportGroupDir()
			go "http://www.airbnb.com/locations/" +java.net.URLEncoder.encode(params.location, "UTF-8")+ "/neighborhoods" //?source=bb&page=" + pageNum
			report "home page"
			size = $("div.neighborhood-list").find("div.container").find("div.row").find("div.span3").find("ul").find("li").size()
			println"SSSSSSSSS"+size
			params.max=10
			/*def downloadLink = $("a.pdf-download-link")
			println"HHHHHHHHHH"+downloadLink
			def bytes = downloadBytes(downloadLink.@href)
			println"KKKKKKKKKK"+bytes*/
			for(int i=offset; i<(offset+10) && i<size; i++){
				def firstLink = $("div.neighborhood-list").find("div.container").find("div.row").find("div.span3").find("ul").find("li",i).find("a")
				Location loc = new Location()
				loc.location = firstLink.text()
				loc.url = firstLink.attr("href")
				aList.add(loc)
			}
		}
		render (view: "results" , model: [location:params.location,  locationInstanceList:aList, locationInstanceCount: size])
    }



    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'locationInstance.label', default: 'Location'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
