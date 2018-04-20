package com.precode.unitpage

import org.springframework.stereotype.Component

@Component
class ExampleSql {
	def url = 'jdbc:mysql://qoov.iptime.org:33306/example'
	def user = 'root'
	def password = '51158128'
	//def driver = 'com.mysql.jdbc.Driver'
	def driver = 'net.sf.log4jdbc.sql.jdbcapi.DriverSpy'
	
	
	List query( query ) {
		def sql = ExampleSql.newInstance(url, user, password, driver)
		List result = sql.rows(query)
		sql.close()
		if(! result) {
			return []
		}
		return result
	}

	Map row(query) {
		def sql = ExampleSql.newInstance(url, user, password, driver)
		List result = sql.rows(query)
		sql.close()
		if(! result) {
			return [:]
		}
		return result.first()
	}

	Boolean execute( query ) {
		def sql = ExampleSql.newInstance(url, user, password, driver)

		Boolean result = sql.execute(query)
		sql.close()
		return result
	}
	

}
