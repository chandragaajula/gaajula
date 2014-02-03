package com.gaajula.sample.gtunes

class Album {
	String title
	static hasMany = [songs:Song]
	
	static constraints = { title (blank: false) }

	String toString() {
		return title
	}
}
