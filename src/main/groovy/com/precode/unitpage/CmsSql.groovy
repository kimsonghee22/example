package com.precode.unitpage

import groovy.sql.Sql

class CmsSql {
	def url = 'jdbc:mysql://db4free.net:3306/precore'
	def user = 'precore'
	def password = '51158128'
	def driver = 'com.mysql.jdbc.Driver'
	
	def escapeStr = ''
	
	
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
	
	def executeInsert( query ) {
		def sql = Sql.newInstance(url, user, password, driver)

		def result = sql.executeInsert(query)
		sql.close()
		return result.first().first()
	}


}
