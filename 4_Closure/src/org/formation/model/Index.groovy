package org.formation.model

import java.time.LocalDate

class Index {
	def source
	LocalDate createdDate = LocalDate.now(), indexedDate
	def keywords = [:]
	
	
	@Override
	public String toString() {
		return this.dump()
	}
	

}
