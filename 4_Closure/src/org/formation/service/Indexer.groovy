package org.formation.service

import java.time.LocalDate
import org.formation.model.Index

class Indexer {
	String tokenizer = /\b/
	List<Closure> filters = []

	
	public Index buildIndex(source) {
		def texte = source.toString()
		def words = texte.split(tokenizer)
		
		filters.each { c ->
			// équivalent à c.call(words)
			words = c(words);
			println 'Words after filter applied : ' + words
		}
		Index index = new Index(source:source)
		
		
		words.each({
			def occurence = index.keywords.get(it.toLowerCase(),0);
			index.keywords[it.toLowerCase()]=occurence+1;
		})
		
		index.indexedDate = LocalDate.now()
		index
	}


}
