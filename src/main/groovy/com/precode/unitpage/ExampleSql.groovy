package com.precode.unitpage

import groovy.sql.Sql;
import org.springframework.stereotype.Component

@Component //��ǰ
class ExampleSql {

	def url = 'jdbc:mysql://49.247.203.238:3306/nksc'
	def user = 'nksc'
	def password = 'nkscnksc'
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
