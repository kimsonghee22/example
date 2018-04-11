package cms.precode.unitpage.example

class Sql {
	def url = ''
	def user = ''
	def password = ''
	def driver = ''
	
	
	List query( query ) {
		def sql = Sql.newInstance(url, user, password, driver)
		List result = sql.rows(query)
		sql.close()
		if(! result) {
			return []
		}
		return result
	}

	Map row(query) {
		def sql = Sql.newInstance(url, user, password, driver)
		List result = sql.rows(query)
		sql.close()
		if(! result) {
			return [:]
		}
		return result.first()
	}

	Boolean execute( query ) {
		def sql = Sql.newInstance(url, user, password, driver)

		Boolean result = sql.execute(query)
		sql.close()
		return result
	}
	

}
