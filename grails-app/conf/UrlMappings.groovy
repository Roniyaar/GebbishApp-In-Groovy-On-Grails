class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.${format})?"{
            constraints {
                // apply constraints here
            }
        }

        "/" {
			controller= "location"
			action="find"
        }
		
        "500"(view:'/error')
	}
}
