package com.gaajula.sample.gtunes

class Album {
	String title
	static hasMany = [songs:Song]
	static constraints = {
	}

	String toString() {
		return title
	}
}
