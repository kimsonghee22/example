package com.precode.unitpage

import groovy.sql.Sql;
import org.springframework.stereotype.Component

@Component
class ExampleSql {

	def url = 'jdbc:mysql://qoov.iptime.org:33306/example'
	def user = 'root'
	def password = '51158128'
	def driver = 'com.mysql.jdbc.Driver'

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
