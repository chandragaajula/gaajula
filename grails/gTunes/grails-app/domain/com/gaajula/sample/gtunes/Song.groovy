package com.gaajula.sample.gtunes

class Song {
	String title
	String artist
	Integer releaseYear
	Integer duration
	//	Album album
	static belongsTo = Album

	static constraints = {
		title (blank: false)
		artist (blank: false)
		releaseYear (blank: true)
		duration (min: 1)
	}

	static transients = ['releaseYear']

	String toString() {
		return title + " --> " + artist
	}
}
